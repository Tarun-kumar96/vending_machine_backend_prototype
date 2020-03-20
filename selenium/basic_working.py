from selenium import webdriver
import time
import re
from selenium.webdriver.common.keys import Keys
url = 'https://www.commonfloor.com/bangalore-property/for-sale/status-completed/projects?page=1'
# driver = webdriver.Chrome(executable_path = r"C:/webdriver/chromedriver.exe")
driver = webdriver.Chrome(executable_path='chromedriver')
driver.maximize_window()
driver.get(url)
# assert 'Facebook' in driver.title
# elem = driver.find_element_by_id('email')
# elem.send_keys(username)
# elem = driver.find_element_by_id('pass')
# elem.send_keys(password)
# elem.send_keys(Keys.RETURN)
f = "document.getElementsByClassName('btn quick-view pull-right mrtp10 cf-tracking-enabled')[0].click()"
driver.execute_script(f)
time.sleep(1)
elem = driver.find_element_by_xpath('//*[@id="serp-quick-view-modal"]')
source_code = elem.get_attribute("outerHTML")
print(source_code.split('NO OF UNITS ')[1].split('</span>')[0]
      .split('<span>')[1])
# driver.switchTo().alert().getText()
driver.close()