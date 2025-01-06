package com.example.connectivity.driver;

import com.example.connectivity.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		WebDriverManager.firefoxdriver().setup();

		// Konfigurasi Firefox agar mengizinkan akses kamera
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("use-fake-ui-for-media-stream");


		return new FirefoxDriver(options);
	}
	
}
