package com.kamivision.screens.common.settings.sharing;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class SharedDeviceScreen  {
    private final UIHelper app;
    public SharedDeviceScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper deviceShareCancelButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnDeviceShareCancel')]"),By.xpath("//XCUIElementTypeButton[@name=\""+app.lang.getProperty("CameraSharePermissionSetting_1484545835_1")+"\"]"));}
    public UIHelper confirmDeviceShareCancelButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnAntsDialogRight')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"']"));}
    public UIHelper sharedAccountMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("share_hint_cancelSharing")+"')]"),By.xpath("//*[contains(@name,'"+app.lang.getProperty("share_hint_cancelSharing")+"')]"));}



    @Step("Click Cancel Invitation button")
    public void clickOnCancelInvitationPopup() throws Exception {
        log.info("Click Cancel Invitation button");
        deviceShareCancelButton().click();

    }

    @Step("Verify message Are you sure want to cancel displayed")
    public void verifyCancelSharingDeviceMessage() throws Exception {
        log.info("Verify message Are you sure want to cancel displayed");
        Assert.assertTrue(sharedAccountMessage().isElementPresent(5),
                "message: Are you sure you want to cancel the camera sharing? not displayed");
    }

    @Step("Confirm cancel sharing")
    public void confirmCancelSharingPopup() throws Exception {
        log.info("Confirm cancel sharing");
        confirmDeviceShareCancelButton().click();
        rotateLoadingIcon().waitForDisappear();
    }
}
