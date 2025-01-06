package com.example.pages;

import com.example.Helper.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LemburPage {
    private WebDriver driver;
    private DataTable dataTable = new DataTable(driver);
    Actions actions;

    public LemburPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//input[@id='search']")
    WebElement searchFlied;
    @FindBy(xpath = "(//input[@placeholder='Start Date'])[1]")
    WebElement startDate;
    @FindBy(xpath = "//input[@placeholder='End Date']")
    WebElement endDate;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchBtn;
    @FindBy(xpath = "//button[normalize-space()='save']")
    WebElement saveBtn;
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetBtnField;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    WebElement resultLembur;
    @FindBy(xpath = "//table[@aria-label='sticky table']")
    WebElement tabelLembur;
    @FindBy(xpath = "//button[@aria-label='toggle password visibility']")
    WebElement dateBtn;
    @FindBy(xpath = "(//*[name()='polygon' and contains(@points,'22 3 2 3 1')]")
    WebElement filterButton;
    @FindBy(xpath = "(//*[name()='polygon'])[1]")
    WebElement departermen;
    @FindBy(xpath = "//button[normalize-space()='Terapkan']")
    WebElement clickTerapkan;
    @FindBy(xpath = "//button[normalize-space()='Export']")
    WebElement btnExport;

    public String getResultLembur(){
        return this.resultLembur.getText();
    }
    public void setSearchFlied(String input) {
        this.searchFlied.clear();
        this.searchFlied.sendKeys(input);
    }
    public void clickSearchBtn(){
        this.searchBtn.click();
    }
    public void setSaveBtn(){
        this.saveBtn.click();
    }
    public void setResetBtnField(){
        this.resetBtnField.click();
    }

    public List<String> dataLembur(int index){
        List<String> namaLembur = dataTable.getDataTableVerifikator(index, tabelLembur);
        return namaLembur;
    }
    public void setStartDate(String dateAwal) {
        this.startDate.sendKeys(dateAwal);
    }
    public void setEndDate(String dateAkhir){
        this.endDate.clear();
        this.endDate.sendKeys(dateAkhir);
    }
    public void clickDatebtn(){
        this.dateBtn.click();
    }
//    public void clickFilterbtn(){
//        this.filterButton.click();
//    }
//    public void setResetBtnField(){
//        this.resetBtnField.click();
//    }
//    public void clickTerapkan(){this.clickTerapkan.click();}
//
//    public void pilihDepartemenDenganKeyboard() {
//        this.departermen.click();
////        actions.sendKeys("\ue015").pause(500) // Arrow Down (↓)
////                .sendKeys("\ue015").pause(500) // Arrow Down (↓)
////                .sendKeys("\ue007")            // Enter
////                .build().perform();
//
//        departermen.sendKeys(Keys.ARROW_DOWN);
//        departermen.sendKeys(Keys.ARROW_DOWN);
//        departermen.sendKeys(Keys.ENTER);
//
//    }
    public void clickBtnExport(){
        this.btnExport.click();
    }
    public void isFilterCleared(){

    }


}
