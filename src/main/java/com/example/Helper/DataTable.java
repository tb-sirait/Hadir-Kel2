package com.example.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class DataTable {

    private static WebDriver driver;

    public DataTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getDataTableVerifikator(int columnIndex, WebElement locator) {
        List<WebElement> rows = locator.findElements(By.tagName("tr"));
        // List untuk menyimpan data dari kolom yang diinginkan
        List<String> columnData = new ArrayList<>();

        // Iterasi setiap baris dan ambil data dari kolom tertentu
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > columnIndex) { // Pastikan kolom ada
                columnData.add(columns.get(columnIndex).getText());
            }
        }
        return columnData;
    }



}





