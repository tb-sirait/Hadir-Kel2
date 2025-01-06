package com.example.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 07/12/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 07/12/2024 16:21
@Last Modified 07/12/2024 16:21
Version 1.0
*/
public class ButtonInTable {

    private static WebDriver driver;

    public ButtonInTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getButtonsInColumn(int buttonColumnIndex, WebElement locator) {
        List<WebElement> rows = locator.findElements(By.tagName("tr"));
        // List untuk menyimpan elemen tombol dari kolom yang diinginkan
        List<WebElement> buttonElements = new ArrayList<>();

        // Iterasi setiap baris dan ambil elemen checkbox dari kolom tertentu
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > buttonColumnIndex) { // Pastikan kolom ada
                WebElement button = columns.get(buttonColumnIndex).findElement(By.tagName("a")); // Ambil tombol
                if (button != null) {
                    buttonElements.add(button);
                }
            }
        }
        return buttonElements;
    }



}





