package pizza.spring.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandePizzaAcceptanceTest {

	private WebDriver webDriver;

	  @Before
	  public void createWebDriver() {
	    webDriver = new ChromeDriver();
	  }

	  @After	  
	  public void closeWebDriver() {
	    webDriver.quit();
	  }
	  
	  @Test
		public void commandeDePizzaRealiseeAvecSucces() throws Exception {
			 CommandePage commandePage= HomePage.openWith(webDriver)
					 						    .clickOnCommander();
			 DetailsCommandePage detailsCommandePage = commandePage.selectPizza(0)
					 										   .enterName("CommandePizzaOk")
					 										   .enterTelephone("0668870588")
					 										   .clickOnCommande();
			assertTrue(detailsCommandePage.isLinkPresent("recap-commande"));
		}
		
		@Test
		public void commandeDePizzaSansSelectionnerDePizzaRevoitUneErreur() throws Exception {
			CommandePage commandePage= HomePage.openWith(webDriver)
					   						   .clickOnCommander();
			DetailsCommandePage detailsCommandePage = commandePage.enterName("CommandePizzaSansSelectionnerDePizza")
															   .enterTelephone("0668870588")
															   .clickOnCommande();
			 assertTrue(commandePage.isElementPresent("pizzaId.errors"));
		}
		
		@Test
		public void commandeDePizzaSansRentrerDeNumeroDeTelephoneRevoitUneErreur() throws Exception {
			CommandePage commandePage= HomePage.openWith(webDriver)
											   .clickOnCommander();
			DetailsCommandePage detailsCommandePage = commandePage.selectPizza(0)
														      .enterName("CommandePizzaSansRentrerDeNumeroDeTelephone")
														      .clickOnCommande();
			assertTrue(commandePage.isElementPresent("telephone.errors"));
		}
}
