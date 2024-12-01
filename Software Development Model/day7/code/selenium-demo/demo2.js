const { Builder, By, Key, Browser } = require('selenium-webdriver')

async function testLogin() {
  // create browser instance
  const browser = await new Builder().forBrowser(Browser.FIREFOX).build()

  try {
    // open the web page
    await browser.get(
      'file:///Volumes/MyData/Sunbeam/2024/sept/kdac/sdm/day8/code/selenium-demo/index.html'
    )

    // find the input for email
    const emailInput = await browser.findElement(By.id('email'))

    // enter email address
    emailInput.sendKeys('test@test.com', Key.ENTER)

    // find the input for password
    const passwordInput = await browser.findElement(By.id('password'))

    // enter password
    passwordInput.sendKeys('test', Key.ENTER)

    // find the button login
    const buttonLogin = await browser.findElement(By.id('login'))

    // click the button
    await buttonLogin.click()

    // get the div to read the result
    const resultDiv = await browser.findElement(By.id('result'))

    console.log(await resultDiv.getText())
  } catch (ex) {
    console.log(ex)
  } finally {
    await browser.quit()
  }
}

testLogin()
