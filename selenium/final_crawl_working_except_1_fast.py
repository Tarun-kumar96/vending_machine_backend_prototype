from selenium import webdriver
from random import randrange
import time
import re
from selenium.webdriver.common.keys import Keys

pageNumber = 88

while pageNumber<=545:
	print "Opening "+str(pageNumber)+" page"
	url = "https://www.commonfloor.com/bangalore-property/for-sale/status-completed/projects?page="+str(pageNumber)
	chrome_options = webdriver.ChromeOptions()
	chrome_options.add_argument("--incognito")
	driver = webdriver.Chrome(chrome_options=chrome_options,executable_path='chromedriver')
	driver.maximize_window()
	driver.get(url)
	notNowButtons = driver.find_elements_by_class_name('wpn_modal_actionButton')
	for e in notNowButtons:
		action=webdriver.ActionChains(driver)
		action.move_to_element(e).click().perform()
		break
	print "Initiating script... "
	time.sleep(1.5)
	documents = driver.find_elements_by_xpath("//*[@class='btn quick-view pull-right mrtp10 cf-tracking-enabled']") 
	print "closing ad"
	driver.execute_script("window.scrollTo(0, 1000)") 
	time.sleep(1)
	adSuppress = driver.find_elements_by_class_name('closead')
	for e in adSuppress:
		action=webdriver.ActionChains(driver)
		action.move_to_element(e).click().perform()

	try:
		adSuppress = driver.find_elements_by_class_name('closead')
		for e in adSuppress:
			action=webdriver.ActionChains(driver)
			action.move_to_element(e).click().perform()
	except Exception, e:
		print "Ad already close. No need to retry"+str(e)
	time.sleep(1)
	print "Fetching data..."
	count = 0
	for document in documents:
		try:
			count=count+1
			if count == 1:
				continue
			action=webdriver.ActionChains(driver)
			action.move_to_element(document).click().perform()
			time.sleep(1)
			ttt = driver.find_element_by_xpath('//*[@class="modal-header"]')
			flatName=ttt.text
			elem = driver.find_element_by_xpath('//*[@id="serp-quick-view-modal"]')
			source_code = elem.get_attribute("outerHTML")
			# f.write(source_code.encode('utf-8'))
			numOfUnits = source_code.split('NO OF UNITS ')[1].split('</span>')[0].split('<span>')[1]
			location = source_code.split('LOCATION ')[1].split('</span>')[0].split('<span>')[1]
			f = open('results_bangalore.txt', 'a+')
			fileVar=""+flatName + "," +numOfUnits.decode('utf-8')  + "," + location.decode('utf-8') + ""
			# print fileVar
			f.write(fileVar)
			f.close()
			webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
			time.sleep(1)
		except Exception, e:
			print "Exception occured. Ignore it"+str(e)
	driver.close()
	pageNumber=pageNumber+1
	time.sleep(0.5)