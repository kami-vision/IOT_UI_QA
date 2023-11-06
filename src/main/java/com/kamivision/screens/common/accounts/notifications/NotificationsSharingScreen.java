package com.kamivision.screens.common.accounts.notifications;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class NotificationsSharingScreen  {
    private final UIHelper app;
    public NotificationsSharingScreen(UIHelper app) throws Exception {
        this.app=app;
    }
    public UIHelper invitation() throws Exception {return app.setBy(By.xpath("//*[contains(@text, \""+app.lang.getProperty("share_hint_accepted")+"\")]"),By.xpath("//*[@name=\""+app.lang.getProperty("share_hint_inviting")+"\"]"));}
    public UIHelper shareDeviceInvitation() throws Exception {return app.setBy(By.xpath("//*[contains(@text, \""+app.lang.getProperty("share_hint_inviting")+"\")]"),By.xpath("//*[@name=\""+app.lang.getProperty("share_hint_inviting")+"\"]"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}

    @Step("Click on the invitation")
    public void clickOnShareDeviceInvitation() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        if(app.isAndroid()) {
            if(shareDeviceInvitation().isElementPresent(15)) {
                log.info("Click on the invitation");
                shareDeviceInvitation().click();
                return;
            }
            return;
        }
        log.info("Click on the invitation");
        shareDeviceInvitation().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Share Device invitation is displayed")
    public void verifyShareDeviceInvitationDisplayed() throws Exception {
        log.info("Verify Share Device invitation is displayed");
        rotateLoadingIcon().waitForDisappear();
        if (shareDeviceInvitation().isElementPresent(15)) {
            Assert.assertTrue(shareDeviceInvitation().isElementPresent(15),
                    "Share Invitation page not displayed");
        }
    }
}
