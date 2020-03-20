from selenium import webdriver
import time
import re
from selenium.webdriver.common.keys import Keys
url = 'https://www.commonfloor.com/bangalore-property/for-sale/status-completed/projects?page=1'
# driver = webdriver.Chrome(executable_path = r"C:/webdriver/chromedriver.exe")

chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument("--incognito")
# chrome_options.add_extension("AdBlock-Chrome_v3.50.1.crx")

driver = webdriver.Chrome(chrome_options=chrome_options,executable_path='chromedriver')
# driver = webdriver.Chrome(executable_path='chromedriver')

driver.maximize_window()
driver.get(url)

# assert 'Facebook' in driver.title
# elem = driver.find_element_by_id('email')
# elem.send_keys(username)
# elem = driver.find_element_by_id('pass')
# elem.send_keys(password)
# elem.send_keys(Keys.RETURN)
# f = "document.getElementsByClassName('btn quick-view pull-right mrtp10 cf-tracking-enabled')[1].click()"

# documents = "document.getElementsByClassName('btn quick-view pull-right mrtp10 cf-tracking-enabled')"
print "sleeping for 5 secs"
time.sleep(5)

documents = driver.find_elements_by_xpath("//*[@class='btn quick-view pull-right mrtp10 cf-tracking-enabled']") 

totalButtons = len(documents)

driver.execute_script("window.scrollTo(0, 500)") 
time.sleep(1)

adSuppress = driver.find_elements_by_class_name('closead')
for e in adSuppress:
	action=webdriver.ActionChains(driver)
	action.move_to_element(e).click().perform()

 # e.click()

time.sleep(5)

# count = 0
# while (count < totalButtons):
# 	# document = driver.find_elements_by_xpath("//*[@class='btn quick-view pull-right mrtp10 cf-tracking-enabled']")[count]
# 	document = driver.find_element_by_xpath("//*[@class='btn quick-view pull-right mrtp10 cf-tracking-enabled']")

# 	action=webdriver.ActionChains(driver)
# 	action.move_to_element(document).click().perform()

 
# 	print "fetching button: "
# 	print document.text
# 	print "other print"
# 	print documents[count].text
# 	# document.click()
# 	print "sleeping for 4 secs"
# 	time.sleep(4)
# 	print "pressing esc key"
# 	webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
# 	print "pressed esc key"
# 	count = count+1
# 	if count == 3:
# 		break

count = 0
for document in documents:
	# script = "document.click()"
	# driver.execute_script(script)
	# print count
	count=count+1
	if count == 1:
		print "clicking 3th button"
		action=webdriver.ActionChains(driver)
		action.move_to_element(document).click().perform()
		# document.click()
		print "sleeping for 4 secs"
		time.sleep(4)
		print "pressing esc key"
		webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
		print "pressed esc key"
		print "sleeping for 1 secs"
		time.sleep(1)
	if count == 2:
		print document.text
		time.sleep(1)
		print "clicking 10th button"
		action=webdriver.ActionChains(driver)
		action.move_to_element(document).click().perform()
		# document.click()
		print "sleeping for 4 secs"
		time.sleep(4)
		print "pressing esc key"
		webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
		print "pressed esc key"
		time.sleep(1)
	if count == 4:
		print document.text
		time.sleep(1)
		print "clicking 10th button"
		action=webdriver.ActionChains(driver)
		action.move_to_element(document).click().perform()
		# document.click()
		print "sleeping for 4 secs"
		time.sleep(4)
		print "pressing esc key"
		webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
		print "pressed esc key"
		time.sleep(1)
	if count == 6:
		print document.text
		time.sleep(1)
		print "clicking 10th button"
		action=webdriver.ActionChains(driver)
		action.move_to_element(document).click().perform()
		# document.click()
		print "sleeping for 4 secs"
		time.sleep(4)
		print "pressing esc key"
		webdriver.ActionChains(driver).send_keys(Keys.ESCAPE).perform()
		print "pressed esc key"
		time.sleep(1)




# driver.execute_script(f)
# time.sleep(1)
# elem = driver.find_element_by_xpath('//*[@id="serp-quick-view-modal"]')
# source_code = elem.get_attribute("outerHTML")
# print(source_code.split('NO OF UNITS ')[1].split('</span>')[0]
#       .split('<span>')[1])
# # driver.switchTo().alert().getText()
# driver.close()