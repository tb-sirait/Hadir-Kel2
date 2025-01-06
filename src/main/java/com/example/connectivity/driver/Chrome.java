package com.example.connectivity.driver;

import com.example.connectivity.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Chrome implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", System.getProperty("user.home") + "\\Downloads"); // Path folder
		prefs.put("download.prompt_for_download", false); // Disable download prompt
		prefs.put("profile.default_content_settings.popups", 0); // Disable popups
		prefs.put("safebrowsing.enabled", "true"); // Allow download from unsafe websites
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--no-sandbox");
		options.addArguments("use-fake-ui-for-media-stream");
		options.setExperimentalOption("prefs", prefs);

		return new ChromeDriver(options);
	}

}
