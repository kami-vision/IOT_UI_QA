package com.kamivision.screens.common;


import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class PrivacyPolicyScreen  {
    private final UIHelper app;
    private boolean isFlagOn;
    public PrivacyPolicyScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("profile_user_privacyPolicy_android")+"']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("profile_user_privacyPolicy")+"']"));}
    public UIHelper endPrivacyPage(String text) throws Exception {
        return app.setBy(By.xpath("//android.view.View[contains(@text, '" + text + "')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+text+"')]"));
    }

    public UIHelper scrollToText(String text) throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+text+"')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+text+"')]"));}


    @Step("Verify Privacy Policy page is Displayed")
    public void verifyPrivacyPolicyPageDisplayed() throws Exception {
        log.info("Verify Privacy Policy page is Displayed");
        if (!pageTitle().isElementPresent(10)) {
            isFlagOn = false;
        } else {
            isFlagOn = true;
        }
        if(app.isIOS())
            Assert.assertTrue(isFlagOn, "Privacy Policy page is missing");
    }

    @Step("Scroll down")
    public void scrollToEndPage(String text) throws Exception {
        if (isFlagOn) {
            log.info("Scroll down");
            scrollToText(text).scrollToElementDownSide();
        }
    }

    @Step("Verify user can scroll to the end")
    public void verifyScrolledToTheEnd(String text) throws Exception {
        if (isFlagOn) {
            log.info("Verify user can scroll to the end");
            Assert.assertTrue(endPrivacyPage(text).isElementPresent(5), "Term of Use end page is missing");
        }
    }
}
