package com.lanalabs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lanalabs.config.Config;

import net.serenitybdd.core.pages.PageObject;

public class LanaLabsPages extends PageObject{
	static Logger log = Logger.getLogger(LanaLabsPages.class);
	public Config config = new Config();
	

	public WebElement  findElementVerifyItsVisibility(WebDriver driver, int timeout, String locatorXpath) {
		WebElement x = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorXpath))));
		return x;
	}
	
	public WebElement  findElementVerifyItsClickability(WebDriver driver, int timeout, String locatorXpath) {
		WebElement x = new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locatorXpath))));
		return x;
	}
	
	public void penguinLoading() {
		try {
			if(getDriver().findElement(By.xpath("//div[@id='loadingAnimation']")).isDisplayed()){
				log.info("Penguin Loading Page displayed");
				waitFor(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//div[@id='loadingAnimation']"))));
				waitABit(1000);
				log.info("Penguin Loading Hidden");
			}
		}catch(Exception e) {
			log.info("No Penguin Loading Page displayed");
		}
	}
}