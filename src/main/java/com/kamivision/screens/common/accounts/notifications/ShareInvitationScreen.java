package com.kamivision.screens.common.accounts.notifications;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class ShareInvitationScreen  {
    private final UIHelper app;
    public ShareInvitationScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper acceptButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnInvitationAccept')]"),By.xpath("//XCUIElementTypeButton[@name=\""+app.lang.getProperty("DeviceShareQRCodeScanSuccess_1448619345_1")+"\"]"));}
    public UIHelper denyButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnInvitationDeny')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("DeviceShareQRCodeScanSuccess_1484535623_5")+"']"));}
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"),By.xpath("Dummy"));}
    public UIHelper invitation() throws Exception {return app.setBy(By.xpath("//*[contains(@text, '"+app.lang.getProperty("share_hint_accepted")+"')]"),By.xpath("//*[@name=\""+app.lang.getProperty("share_hint_inviting")+"\"]"));}

    @Step("Verify Account and Decline invitation button displayed")
    public void verifyAcceptAndDeclinedInvitationButtonDisplayed() throws Exception {
        if (!acceptButton().isElementPresent(5) && app.isAndroid()) {
            log.info("Skip this step");
            return;
        }
        log.info("Verify Account and Decline invitation button displayed");
        Assert.assertTrue(acceptButton().isElementPresent(5),
                "Accept invitation button is not displayed");
        Assert.assertTrue(denyButton().isElementPresent(5),
                "Deny invitation button is not displayed");
    }

    @Step("Accept Invitation")
    public boolean clickOnAcceptInvitationButton() throws Exception {
        if (app.isAndroid() && !acceptButton().isElementPresent(5)) {
            backButton().click();
            log.info("Skip this step");
            return false;
        }
        log.info("Accept Invitation");
        acceptButton().click();
        return true;
    }
}
