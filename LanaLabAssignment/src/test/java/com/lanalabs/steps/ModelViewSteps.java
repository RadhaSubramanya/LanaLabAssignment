package com.lanalabs.steps;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ModelViewSteps extends LanaLabsSteps {
	public static Logger log = Logger.getLogger(ModelViewSteps.class);

	@Step
	public void selectExistingLogFromChooseALogPopup(String logFileName){
		clickOnExistingLogRadioButton(logFileName);
		clickOnUseSelectedButton();
		clickOnExitButtonInIntroToolTip();
	}
	
	@Step
	public void clickOnExistingLogRadioButton(String logFileName) {
		modelViewPage.existingLogRadioButton(logFileName).click();
		log.info("Selected Log file : "+logFileName);
	}
	
	@Step
	public void clickOnUseSelectedButton(){
		modelViewPage.useSelectedButton().click();
		log.info("Clicked on Use Selected Button");
	}
	
	@Step
	public void clickOnExitButtonInIntroToolTip() {
		if(modelViewPage.introToolTip().isDisplayed()) {
			log.info("Introductory Tool Tip Popup Displayed");
			modelViewPage.introToolTipSkipButton().click();
			log.info("Clicked on Exit/Skip Button in Intro tool Tip Popup");
		}
	}
	
	@Step
	public void selectFilterMenuOptions(String FilterMenuName) {
		clickOnRightSideFilterMenuButton();
		filterOptionSelectionOnRightSideFilterMenu(FilterMenuName);
	}
	
	@Step
	public void clickOnRightSideFilterMenuButton() {
		modelViewPage.filterMenuButton().click();
		log.info("Clicked on Right Menu Button");
		waitABit(1000);
	}
	
	@Step
	public void filterOptionSelectionOnRightSideFilterMenu(String FilterMenuName) {
		mouseClick(modelViewPage.filterOptionMenuItem(FilterMenuName));
		log.info("Clicked on Filter Menu : "+FilterMenuName);
	}
	
	@Step
	public void selectAFilterInPopup(String filterOption) {
		selectFilterInPopup(filterOption);
		selectSaveButtonInFilterSelectionPopup();
	}
	
	@Step
	public void selectFilterInPopup(String filterOption) {
		modelViewPage.selectFilterOptionCheckBox(filterOption).click();
		log.info("Clicked on "+filterOption+" Filter Option");
	}
	
	@Step
	public void selectSaveButtonInFilterSelectionPopup() {
		modelViewPage.clickOnSaveButtonInFilterPopup().click();
		log.info("Clicked on Save Button in Filter Selection Popup");
	}
	
	@Step
	public void selectOptioninCountryGraphAndValidateTheCount(String countryNameToClickOnChart) {
		int numberOfPieChartSections = modelViewPage.pieChartSections().size();
		log.info("Number of Sections in Pie Chart : "+numberOfPieChartSections);
		HashMap countryNameAndCount = new HashMap();
		HashMap countryNameAndIndex = new HashMap();
		String countryName = null;
		String countryCount;
		for(int i=1;i<=numberOfPieChartSections;i++) {
			mouseHover(modelViewPage.pieChartSection(String.valueOf(i)));
			log.info("Hovering Mouse on "+i+" Section of Pie Chart");
			countryName= modelViewPage.ChartSectionToolTipCountryName().getText();
			log.info("Getting Country name from the Hovered Section Country Name : "+countryName);
			countryCount = modelViewPage.ChartSectionToolTipCountryCount().getText();
			log.info("Getting Country Count from the Hovered Section Country Name : "+countryCount);
			countryNameAndCount.put(countryName, countryCount);
			countryNameAndIndex.put(countryName, i);
		}
		String x = countryNameAndIndex.get(countryNameToClickOnChart).toString();
		modelViewPage.pieChartSection(x).click();
		String countDisplayed = modelViewPage.SelectedCountryCountAndPercentageDisplayed().getText();
		String[] a = countDisplayed.split("\\W+");
		Assert.assertEquals(a[1], countryNameAndCount.get(countryNameToClickOnChart));
		log.info("Displayed : "+a[1] +" And value in map : "+countryNameAndCount.get(countryNameToClickOnChart));
	}
	
	@Step
	public void logout() {
		modelViewPage.LeftSideMainMenuButton().click();
		log.info("Clicked on Left Side Main Menu");
		waitABit(1000);
		mouseClick(modelViewPage.OptionInLeftSideMainMenu("Logout"));
		log.info("Clicked on Logout Button in Left side Main Menu");
	}
}
