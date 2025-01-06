package com.example.Helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HandleDownload {

    private WebDriver driver;

    public HandleDownload(WebDriver driver) {
        this.driver = driver;;
        PageFactory.initElements(driver, this);
    }

    // Method untuk mengecek apakah file sudah ada di folder download
    public boolean isFileDownloaded(String fileDownloadpath, String fileName) {
        boolean flag = false;
        File dir = new File(fileDownloadpath);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
    }

    // Method untuk menunggu file terdownload dalam waktu tertentu
    public void waitForDownload(String downloadPath, String fileName, int timeoutInSeconds){
        int timeElapsed = 0;
        while (timeElapsed < timeoutInSeconds) {
            if (isFileDownloaded(downloadPath, fileName)) {
                System.out.println("File berhasil di download: " + fileName);
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeElapsed++;
        }

        if (timeElapsed >= timeoutInSeconds) {
            System.out.println("File tidak terunduh dalam waktu yang ditentukan.");
        }
    }
}
