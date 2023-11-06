package com.kamivision.screens.common.cloud;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class CloudScreen {
    private final UIHelper app;
    public CloudScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper buyCloudBanner() throws Exception{
        return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivBuyCloud')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("cloud_service_trial_unlock")+"']"));
    }
    public UIHelper chatbotIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'rlBase')]/following-sibling::*"),By.xpath("//*[@name='cloud']"));}
    public UIHelper myPlanLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'My Plans')]"),By.xpath("ios"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    
    @Step("Verify Cloud screen displayed")
    public void verifyCloudScreenDisplayed() throws Exception {
        log.info("Verify Cloud screen is displayed");
        if(app.isAndroid()){
        	rotateLoadingIcon().waitForDisappear();
        	Assert.assertTrue(myPlanLabel().isElementPresent(10),"Cloud screen is not displayed");
        	rotateLoadingIcon().waitForDisappear();
        }else{
        	Assert.assertTrue(buyCloudBanner().isElementPresent(10),"Cloud screen is not displayed");
        }
    }

    @Step("Verify chatbot displayed")
    public void verifyChatbotDisplayed() throws Exception {
        log.info("Verifying chatbot is displayed");
        Assert.assertTrue(chatbotIcon().isElementPresent(5),  "Chatbot is not displayed");

    }
    @Step("Verify chatbot is Not displayed")
    public void verifyChatbotNotDisplayed() throws Exception {
        log.info("Verifying chatbot is not displayed");
        Assert.assertFalse(chatbotIcon().isElementPresent(5),  "Chatbot is not displayed");
    }
}
