package io.selenide

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver

class MainPageTest {
    @Test
    fun openPage(){
        WebDriverManager.chromedriver().setup()
        var driver = ChromeDriver()

        driver.get("https://www.google.com")

        driver.element("[data-pid='23']").shouldHaveText("Gmail")

        driver.close()
    }
}
