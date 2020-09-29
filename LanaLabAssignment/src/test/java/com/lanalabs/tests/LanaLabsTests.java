package com.lanalabs.tests;


import org.junit.After;
import org.junit.Before;

import com.lanalabs.config.Config;
import com.lanalabs.steps.LanaLabsSteps;
import com.lanalabs.steps.LoginSteps;
import com.lanalabs.steps.ModelViewSteps;

import net.thucydides.core.annotations.Steps;

public class LanaLabsTests {
	public Config config = new Config();

	@Steps
	public static LanaLabsSteps lanaLabsSteps;
	
	@Steps
	public static LoginSteps loginSteps;
	
	@Steps
	public static ModelViewSteps modalViewSteps;
	
	@Before
	public void setUp() {
		lanaLabsSteps.launchURL();
	}
	
	@After
	public void shutDown() {
		lanaLabsSteps.quitSession();
	}
	
	
}
