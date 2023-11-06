package com.kamivision.screens.common.accounts.notifications;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

@Log4j2
public class NotificationsScreen  {
    private final UIHelper app;
    public NotificationsScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper shareDevice() throws Exception{ return app.setBy(By.xpath("//*[contains(@text, '"+app.lang.getProperty("share_device_message_share_title")+"')]"),By.xpath("//*[@name='"+app.lang.getProperty("AccountMessage_1499073519_7")+"']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}

    @Step("Click on Share Device")
    public void clickOnShareDevice() throws Exception {
        Thread.sleep(5000);
        rotateLoadingIcon().waitForDisappear();
        if (shareDevice().isElementPresent(25)) {
            log.info("Click on Share Device");
            shareDevice().click();
            Thread.sleep(1000);
        }
        rotateLoadingIcon().waitForDisappear();
    }
}
