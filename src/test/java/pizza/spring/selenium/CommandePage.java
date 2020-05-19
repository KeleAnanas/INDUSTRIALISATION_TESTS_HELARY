package pizza.spring.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class CommandePage {
	
private WebDriver webDriver;
	
	public CommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public CommandePage selectPizza(int index) {
		Select pizza = new Select(webDriver.findElement(By.id("pizzaId")));
		pizza.selectByIndex(index);
		return this;
	}
	
	public CommandePage enterName(String... words) {
	    WebElement nameInput = webDriver.findElement(By.id("nom"));
	    nameInput.sendKeys(String.join(" ", words));
	    return this;
	  }
	
	public CommandePage enterTelephone(String... words) {
		WebElement nameInput = webDriver.findElement(By.id("telephone"));
		nameInput.sendKeys(String.join(" ", words));
		return this;
	}

	public DetailsCommandePage clickOnCommande() {
		WebElement searchButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		searchButton.click();
		return new DetailsCommandePage(webDriver);
	}
	
	public boolean isElementPresent(String element) {
		return webDriver.findElement(By.id(element)).isDisplayed();
	}
}


