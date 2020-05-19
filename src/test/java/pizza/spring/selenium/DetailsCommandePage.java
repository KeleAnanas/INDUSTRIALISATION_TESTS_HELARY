package pizza.spring.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsCommandePage {
	
	private WebDriver webDriver;
	
	public DetailsCommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public boolean isLinkPresent(String element) {
		return new WebDriverWait(webDriver, 1).until(webDriver -> webDriver.getCurrentUrl().contains(element));
	}

}
