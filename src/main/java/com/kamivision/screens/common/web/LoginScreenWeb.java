package com.kamivision.screens.common.web;

import org.openqa.selenium.By;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;

@Log4j2
public class LoginScreenWeb {
	private final UIHelper app;

	public LoginScreenWeb(UIHelper app) {
		this.app=app;
		}

    public UIHelper welcome() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Welcome!')]"));}
    public UIHelper email() throws Exception{ return app.setBy(By.xpath("//input[@type='email']"));}
    public UIHelper password() throws Exception{ return app.setBy(By.xpath("//input[@type='password']"));}
    public UIHelper selectCountry() throws Exception{ return app.setBy(By.xpath("//button[@id='dropdownMenuButton']"));}
    public UIHelper selectRegionList(String region) throws Exception { return app.setBy(By.xpath("//*[contains(text(),'" + region + "')]")); }
    public UIHelper loginBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'LOGIN')]"));}
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Choose the right plan for you')]"));}
    public UIHelper spinner() throws Exception{ return app.setBy(By.xpath("//div[@class='loading-full-screen']"));}
    public UIHelper logout() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Logout')]"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[starts-with(@class, 'spinner-container container')]"));}

    @Step("Select Country")
    public void selectCountry(String region) throws Exception {
    	log.info("Select Country");
    	if (selectCountry().isElementPresent(15)) {
    		selectCountry().click();
            selectRegionList(region).webScroll();
            selectRegionList(region).click();
         }
    }
    
    @Step("Login with credentials")
    public void loginWithCredentials(String username, String password) throws Exception {
    	log.info("Login with credentials");
    	welcome().waitForElementToAppear();
    	email().sendKeys(username);
    	password().sendKeys(password);
    	selectCountry(app.props.getProperty("regionUSA"));
    	loginBtn().click();
        rotateLoadingIcon().waitForDisappear();
    	pageTitle().waitForElementToAppear();
    }
}