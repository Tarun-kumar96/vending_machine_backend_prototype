from selenium import webdriver

driver = webdriver.Chrome(executable_path='chromedriver')
driver.maximize_window()
driver.get("https://www.commonfloor.com/bangalore-property/projects/status-completed")

# javaScript = "document.getElementsByClassName('btn btn-sm tilecontactbtn pull-right mrtp20')[0].click();"

# driver.execute_script(javaScript)

# To press the Quick view button
javaScript = "document.getElementsByClassName('btn quick-view pull-right mrtp10 cf-tracking-enabled')[0].click();"

print javaScript

driver.execute_script(javaScript)

# flatName = driver.find_element_by_class_name('snb-projecttile-ab').text

# print find_element_by_class_name

# flatCount = driver.find_element_by_css_selector('col-xs-6 col-sm-3 col-md-3').text

# print flatCount

# flatCount = driver.find_element_by_class_name('boxcod')

# print flatCount



# driver.findElement(By.linkText("Quick View")).click()

#assert "Selenium Easy Demo - Simple Form to Automate using Selenium" in driver.title

# eleUserMessage = driver.find_element_by_id("user-message")
# eleUserMessage.clear()
# eleUserMessage.send_keys("Test Python")

# eleShowMsgBtn=driver.find_element_by_css_selector('#get-input > .btn')
# eleShowMsgBtn.click()

# eleYourMsg=driver.find_element_by_id("display")
# assert "Test Python" in eleYourMsg.text
# driver.close()