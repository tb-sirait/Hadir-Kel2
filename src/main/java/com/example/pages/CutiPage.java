package com.example.pages;

import com.example.Helper.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CutiPage {
    private WebDriver driver;
    private DataTable dataTable = new DataTable(driver);
    Actions actions;

    public CutiPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;
    @FindBy(xpath = "//input[@placeholder='Start Date']")
    WebElement startDateField;
    @FindBy(xpath = "//input[@placeholder='End Date']")
    WebElement endDateField;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchBtnField;
    @FindBy(xpath = "//button[normalize-space()='save']")
    WebElement saveBtn;
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetBtnField;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement resultCuti;
    @FindBy(xpath = "//table[@aria-label='sticky table']")
    WebElement tabelCuti;
    @FindBy(xpath = "//button[@aria-label='toggle password visibility']")
    WebElement dateBtn;
    @FindBy(xpath = "(//*[name()='svg'][@class='feather feather-filter '])[1]")
    WebElement filterButton;
    @FindBy(xpath = "//input[@id='job_departement']")
    WebElement departermen;
    @FindBy(xpath = "//button[normalize-space()='Terapkan']")
    WebElement clickTerapkan;



    public String getResultCuti() {
        return this.resultCuti.getText();
    }

    public void setSearchField(String input) {
        this.searchField.clear();
        this.searchField.sendKeys(input);
    }

    public void clickSearchBtn(){this.searchBtnField.click();}

    public List<String> dataCuti(int index){
        List<String> namCuti = dataTable.getDataTableVerifikator(index, tabelCuti);
        return namCuti;
    }

    public void setStartDateField(String dateAwal) {
        this.startDateField.sendKeys(dateAwal);

    }

    public void setEndDateField(String dateAkhir) {
        this.endDateField.clear();
        this.endDateField.sendKeys(dateAkhir);
    }

    public void setSaveBtn(){
        this.saveBtn.click();
    }

    public void clickDateBtn(){
        this.dateBtn.click();
    }

    public void clikcResetBtn(){this.resetBtnField.click();}


    public void isFilterCleared() {
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickTerapkan(){this.clickTerapkan.click();}

    public void pilihDepartemenDenganKeyboard() {
        this.departermen.click();
//        actions.sendKeys("\ue015").pause(500) // Arrow Down (↓)
//                .sendKeys("\ue015").pause(500) // Arrow Down (↓)
//                .sendKeys("\ue007")            // Enter
//                .build().perform();

        departermen.sendKeys(Keys.ARROW_DOWN);
        departermen.sendKeys(Keys.ARROW_DOWN);
        departermen.sendKeys(Keys.ENTER);
    }
}
