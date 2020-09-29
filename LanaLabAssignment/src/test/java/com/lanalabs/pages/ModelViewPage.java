package com.lanalabs.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.By;

public class ModelViewPage extends LanaLabsPages {

	public WebElement chooseALogPopupTitle() {
		return getDriver().findElement(By.xpath("//h2[text()='Choose a log']"));
	}

	public WebElement existingLogRadioButton(String logFileName) {
		return getDriver().findElement(By.xpath(
				"//h2[text()='Choose a log']//ancestor::mat-dialog-container[contains(@class,'mat-dialog-container')]//span[contains(text(),'"
						+ logFileName + "')]//parent::div/preceding-sibling::div"));
	}

	public WebElement useSelectedButton() {
		return getDriver().findElement(By.xpath(
				"//h2[text()='Choose a log']//ancestor::mat-dialog-container[contains(@class,'mat-dialog-container')]//span[text()='Use selected']"));
	}

	public WebElement filterMenuButton() {
		return findElementVerifyItsVisibility(getDriver(), 20, "//button[@id='addFilterMenuButton']");
	}

	public WebElement filterOptionMenuItem(String FilterMenuName) {
		return findElementVerifyItsClickability(getDriver(), 20,
				"//div[contains(@class,'mat-menu-panel')]//span[text()='" + FilterMenuName + "']");
	}

	public WebElement introToolTip() {
		return getDriver().findElement(By.xpath("//div[contains(@class,'introjs-tooltip introjs')]"));
	}

	public WebElement introToolTipSkipButton() {
		penguinLoading();
		return introToolTip().findElement(By.xpath("//a[contains(@class,'introjs-button introjs-skipbutton')]"));
	}

	public WebElement selectFilterOptionCheckBox(String filterOption) {
		return findElementVerifyItsVisibility(getDriver(), 20,
				"//h2[text()='Add attribute filters']//ancestor::mat-dialog-content//mat-cell[contains(text(),'"
						+ filterOption + "')]/preceding-sibling::mat-cell//label/div");
	}

	public WebElement clickOnSaveButtonInFilterPopup() {
		return getDriver().findElement(By.xpath("//span[contains(text(),'Save')]"));
	}
	
	public List<WebElement> pieChartSections() {
		return getDriver().findElements(By.xpath("//mat-card-title/b[text()='Country filter']//ancestor::mat-card//div[@class='pie-div ng-star-inserted']/*[name()='svg']//*[name()='path']"));
	}
	public WebElement pieChartSection(String string) {
		return getDriver().findElement(By.xpath("//mat-card-title/b[text()='Country filter']//ancestor::mat-card//div[@class='pie-div ng-star-inserted']/*[name()='svg']//*[name()='path']["+string+"]"));
	}
	
	public WebElement ChartSectionToolTipCountryName() {
		return getDriver().findElement(By.xpath("//mat-card-title/b[text()='Country filter']//ancestor::mat-card//div[@id='attributeFilterTooltipCountry']/div[@class='attrLabel']"));
	}

	public WebElement ChartSectionToolTipCountryCount() {
		return getDriver().findElement(By.xpath("//mat-card-title/b[text()='Country filter']//ancestor::mat-card//div[@id='attributeFilterTooltipCountry']/div[@class='attrCount']"));
	}
	
	public WebElement SelectedCountryCountAndPercentageDisplayed() {
		penguinLoading();
		waitABit(1000);
		return getDriver().findElement(By.xpath("//div[@class='log-filter-percentage ng-star-inserted']//span[@class='ng-star-inserted']"));
	}
	
	public WebElement LeftSideMainMenuButton() {
		return getDriver().findElement(By.xpath("//button/span/i[@class='material-icons']"));
	}
	
	public WebElement OptionInLeftSideMainMenu(String mainMenuOptionText) {
		return getDriver().findElement(By.xpath("//div[@class='mat-list-text']/h4[text()='"+mainMenuOptionText+"']"));
	}
}