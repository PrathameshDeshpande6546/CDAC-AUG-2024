// import the required classes/functions/enums
const { Builder, Browser, By, Key, until } = require('selenium-webdriver')

;(async function example() {
  // create firefox instance
  const driver = await new Builder().forBrowser(Browser.FIREFOX).build()
  try {
    // browse your website
    await driver.get('https://www.google.co.in')

    // wait for 1000ms or the tab title is Google
    // await driver.wait(until.titleIs('Google'), 1000)
  } finally {
    // close the browser
    await driver.quit()
  }
})()
