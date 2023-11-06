package com.kamivision.screens.common.settings.sharing;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class SettingShareDeviceScreen  {
    private final UIHelper app;
    public SettingShareDeviceScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle')]"),By.xpath("//XCUIElementTypeNavigationBar[@name='"+app.lang.getProperty("CameraShare_1484535623_41")+"']"));}
    public UIHelper shareWithFamily() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("share_hint_family")+"')]"),By.xpath("//*[@name='"+app.lang.getProperty("CameraShare_1484535623_43")+"']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper sharedCamera() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivAvatar')]"),By.xpath("//*[contains(@name,'YI_')]"));}
    public UIHelper deleteInvites() throws Exception{ return app.setBy(By.xpath(""),By.xpath("//*[@name='"+app.lang.getProperty("general_delete")+"']"));}



    @Step("Click on menu: Share cameras with your family")
    public void clickOnMenuShareCameraWithFamily() throws Exception {
        log.info("Click on menu: Share cameras with your family");
        rotateLoadingIcon().waitForDisappear();
        shareWithFamily().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify share device page displayed")
    public void verifyShareDevicePageDisplayed() throws Exception {
        log.info("Verify share device page displayed");
        Assert.assertTrue
                (pageTitle().isElementPresent(5),
                        "Share device page not displayed");
    }

    @Step("Open shared camera page")
    public void openSharedCameraPage() throws Exception {
        log.info("Open shared camera page");
        if(app.isIOS())
        rotateLoadingIcon().waitForDisappear();
        sharedCamera().click();
    }
}
