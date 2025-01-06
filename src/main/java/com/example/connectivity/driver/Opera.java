package com.example.connectivity.driver;

import com.example.connectivity.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;

public class Opera implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        WebDriverManager.operadriver().setup();
        WebDriver driver = (WebDriver) new OperaDriverManager();

        return driver;
    }
}
