package com.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Masuk']")
    WebElement btnMasuk;
    @FindBy(xpath = "//h5[contains(text(),'Admin Hadir')]")
    WebElement resultTxtDashboard;
    @FindBy(xpath = "//div[@role='alert']")
    WebElement invalidTxtDashboard;

    public String getResultTxtDashboard() {
        return this.resultTxtDashboard.getText();
    }

    public String getInvalidTxtDashboard() {
        return this.invalidTxtDashboard();
    }

    private String invalidTxtDashboard() {
        return "";
    }


    public void setInputEmail(String email) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password) {
        this.inputPassword.clear();
        this.inputPassword.sendKeys(password);
    }

    public void setBtnMasuk() {
        this.btnMasuk.click();
    }

}
