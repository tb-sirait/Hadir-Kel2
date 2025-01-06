package com.example.pages;

import com.example.Helper.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KoreksiPage {
    private WebDriver driver;
    private DataTable dataTable = new DataTable(driver);
    Actions actions;

    public KoreksiPage(WebDriver driver) {
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
    WebElement resultKoreksi;
    @FindBy(xpath = "//table[@aria-label='sticky table']")
    WebElement tabelKoreksi;
    @FindBy(xpath = "//button[@aria-label='toggle password visibility']")
    WebElement dateBtn;
    @FindBy(xpath = "(//*[name()='polygon' and contains(@points,'22 3 2 3 1')]")
    WebElement filterButton;
    @FindBy(xpath = "(//*[name()='polygon'])[1]")
    WebElement departermen;
    @FindBy(xpath = "//button[normalize-space()='Terapkan']")
    WebElement clickTerapkan;
    @FindBy(xpath = "(//button[@aria-label='Approval Koreksi'])[1]")
    WebElement btnApprove;
    @FindBy(xpath = "(//button[@aria-label='Reject Koreksi'])[1]")
    WebElement btnTolak;
    @FindBy(xpath = "//button[normalize-space()='Setujui']")
    WebElement clikSetujui;
    @FindBy(xpath = "(//button[@aria-label='Reject Koreksi'])[1]")
    WebElement clickTolak;
    @FindBy(xpath = "//input[@id='rejectReason']")
    WebElement alasanTolak;
    @FindBy(xpath = "//button[normalize-space()='Tolak']")
    WebElement clickBtnTolak;

    public String getResultKoreksi() {
        return this.resultKoreksi.getText();
    }

    public void setSearchField(String input) {
        this.searchField.clear();
        this.searchField.sendKeys(input);
    }

    public void clickSearchBtn(){this.searchBtnField.click();}

    public List<String> dataKoreksi(int index){
        List<String> namaKoreksi = dataTable.getDataTableVerifikator(index, tabelKoreksi);
        return namaKoreksi;
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

    public void setBtnApprove(){
        this.btnApprove.click();
    }

    public void setClickBtnTolak(){
        this.btnTolak.click();
    }

    public void clickDatebtn(){
        this.dateBtn.click();
    }

    public void setAlasanTolak(String alasanTolak){
        this.alasanTolak.sendKeys(alasanTolak);
    }

    public void setBtnTolak(){
        this.clickBtnTolak.click();
    }

    public void setClickTolak(){
        this.clickTolak.click();
    }

    public void setClikSetujui(){
        this.clikSetujui.click();
    }

    public void setResetBtnField(){this.resetBtnField.click();}


    public void isFilterCleared() {
    }

    public void clickFilterButton() {
        filterButton.click();
    }

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

}

