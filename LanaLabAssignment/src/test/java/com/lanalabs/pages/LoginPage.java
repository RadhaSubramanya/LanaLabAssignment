package com.lanalabs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;

public class LoginPage extends LanaLabsPages {
	
	public WebElement userNameTextField() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'visible-md visible-lg')]//input[@id=\"signInFormUsername\"]"));	
	}
	
	public WebElement passwordTextField() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'visible-md visible-lg')]//input[@id=\"signInFormPassword\"]"));	
	}
	
	public WebElement signInButton() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'visible-md visible-lg')]//following-sibling::input[@name='signInSubmitButton']"));	
	}
	
	public WebElement centerLogo() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'visible-md visible-lg')]//div[@class='banner-customizable']//img[@class='logo-customizable']"));
	}
	
	public WebElement SignInAsDifferentUserLink() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'visible-md visible-lg')]//a[text()='Sign in as a different user?']"));
	}
}
