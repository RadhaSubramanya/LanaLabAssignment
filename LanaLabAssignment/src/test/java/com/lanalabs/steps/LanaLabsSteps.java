package com.lanalabs.steps;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.lanalabs.config.Config;
import com.lanalabs.pages.LanaLabsPages;
import com.lanalabs.pages.LoginPage;
import com.lanalabs.pages.ModelViewPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LanaLabsSteps extends ScenarioSteps{
	public static Logger log = Logger.getLogger(LanaLabsSteps.class);
	public Config config = new Config();
	
	LanaLabsPages lanaLabsPages;
	LoginPage loginPage;
	ModelViewPage modelViewPage;

	@Step
	public void launchURL() {
		getDriver().manage().window().maximize();
		log.info("Browser Launched and  Maximised to Fit to Screen");
		getDriver().get(config.url);
		log.info("Launched Url : "+config.url);
	}
	
	@Step
	public void quitSession() {
		getDriver().quit();
		log.info("Closed the Browsing Session");
	}
	
	@Step
	public void validateTitle(String expectedTitle) {
		String Title = getDriver().getTitle();
		log.info("Title of the Page is : "+Title);
		Assert.assertEquals(expectedTitle, Title);
		log.info("Title Verification Completed");
	}
	
	@Step
	public void mouseClick(WebElement element) {
		Actions action = new Actions(getDriver());
		action.moveToElement(element).click().build().perform();
		log.info("Performed Mouse Click on the element");
	}
	
	@Step
	public void mouseHover(WebElement element) {
		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();
		log.info("Performed Hover on the element");
	}
	
}