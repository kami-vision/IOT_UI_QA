package com.kamivision.screens.common.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class HomeScreenWeb {
	
	private final UIHelper app;
	
	public HomeScreenWeb(UIHelper app) {
		this.app=app;
		}
	
    public UIHelper kamiCloud() throws Exception{ return app.setBy(By.xpath("//img[@alt='Yi Cloud']"));}
    public UIHelper orders() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Orders')]"));}
    public UIHelper logout() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Logout')]"));}
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'Choose the right plan for you')]"));}
    public UIHelper spinner() throws Exception{ return app.setBy(By.xpath("//div[@class='loading-full-screen']"));}

    @Step("Verify PageHeaders")
    public void verifyPageHeaders() throws Exception {
    	log.info("Verify PageHeaders");
    	Assert.assertTrue(kamiCloud().isElementPresent(15), "kamicloud is not displayed");
    	Assert.assertTrue(orders().isElementPresent(15), "orders is not displayed");
    	Assert.assertTrue(logout().isElementPresent(15), "logout is not displayed");
    	Assert.assertTrue(pageTitle().isElementPresent(15), "pageTitle is not displayed");
    }

    
}
