package io.selenide

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


fun WebDriver.element(cssLocator: String): UIElement {
    return UIElement(this, By.cssSelector(cssLocator))
}


class UIElement(private val driver: WebDriver, private val locator: By) {
    fun getWrappedElement(): WebElement {
        return WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(locator))
    }

    val text: String
        get() = getWrappedElement().text

    fun sendKeys(s: String) {
        getWrappedElement().sendKeys(s)
    }

    fun click() {
        getWrappedElement().click()
    }

    fun shouldHaveText(text: String) {
        assert(this.text == text)
    }
}
