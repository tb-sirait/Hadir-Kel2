package com.example.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    private static WebDriver driver;

    public Dropdown(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSelectByIndex(int index, WebElement locator) {
        Select dropdown = new Select(locator);
        dropdown.selectByIndex(index);
    }
}
