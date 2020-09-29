package com.lanalabs.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class Config {
	
	static Logger log = Logger.getLogger(Config.class);
	private Properties properties = new Properties();
	
	public String url;
	public String userName;
	public String password;
	
	public Config() {
		loadConfig("config.properties");
		setValues();
	}
	
	private void loadConfig(String propertiesFile) {
		try {
			properties.load(new FileInputStream(propertiesFile));
			log.info("Configuration File Successfully loaded to Properties Object");
		} catch (Exception e) {
			log.error("Error loading config : " + e);
		}
	}
	
	private void setValues() {
		log.info("---------- Intitiating Set Values ----------");
		url = ((url = System.getProperty("url")) != null) ? url : properties.getProperty("url");
		log.info("url : " + url);
		userName = ((userName = System.getProperty("userName")) != null) ? userName : properties.getProperty("userName");
		log.info("userName : " + userName);
		password = ((password = System.getProperty("password")) != null) ? password : properties.getProperty("password");
		log.info("password : " + password);
		log.info("---------- Initiating Config Values Completed Successfully ----------");
	}
}