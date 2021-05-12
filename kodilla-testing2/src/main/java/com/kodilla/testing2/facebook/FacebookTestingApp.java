package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES = "//button[contains(@data-cookiebanner, \"accept\")]";
    public static final String XPATH_ACCOUNT_BUTTON = "//div[contains(@class, \"_6ltg\")]/a[contains(@class, \"_4jy2\")]";
    public static final String XPATH_SPAN = "//div[contains(@class, \"_5k_5\")]/span[contains(@class, \"_5k_4\")]/span";
    public static final String XPATH_DAY = XPATH_SPAN + "/select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_MONTH = XPATH_SPAN + "/select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_YEAR = XPATH_SPAN + "/select[contains(@name, \"birthday_year\")]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIES)).isDisplayed());

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIES));
        cookieButton.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_ACCOUNT_BUTTON));
        createAccount.click();

        Thread.sleep(3000);

        WebElement dayOfBirthWebElem = driver.findElement(By.xpath(XPATH_DAY));
        Select dayOfBirthSelect = new Select(dayOfBirthWebElem);
        dayOfBirthSelect.selectByIndex(12);

        WebElement monthOfBirthWebElem = driver.findElement(By.xpath(XPATH_MONTH));
        Select monthOfBirthSelect = new Select(monthOfBirthWebElem);
        monthOfBirthSelect.selectByIndex(6);

        WebElement yearOfBirthWebElem = driver.findElement(By.xpath(XPATH_YEAR));
        Select yearOfBirthSelect = new Select(yearOfBirthWebElem);
        yearOfBirthSelect.selectByValue("1994");
    }
}
