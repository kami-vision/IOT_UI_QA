package com.kamivision.screens.common.addcamera;


import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class AddCameraScreen  {
    private final UIHelper app;
    public AddCameraScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper cameraName() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("system_name_R40GA")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("system_name_R40GA")+"']"));}
    public UIHelper didNotHearLink() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text,'"+app.lang.getProperty("pairing_failed_voiceHint")+"')]"),By.xpath("//*[@name=\""+app.lang.getProperty("CWaitConnect_1441676159_5")+"\"]"));}
    public UIHelper pushResetButtonMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvResetHint') and contains(@text,'"+app.lang.getProperty("pairing_step_resetVoice")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("update_hint_reset")+"']"));}

    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='" + app.lang.getProperty("pairing_step_selectDevice02")+ "']"), By.xpath("//XCUIElementTypeStaticText[@name='" + app.lang.getProperty("CloudStorageDeviceList_1462357384_64")+ "']"));}
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"), By.xpath("//XCUIElementTypeButton[@name='yh ic nav back']"));}
    public UIHelper cameraTypeQrcode() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivCameraTypeQrcode')]"), By.xpath("//XCUIElementTypeButton[@name='" + app.lang.getProperty("ios_scan_qr_button")+ "']"));}
    public UIHelper categoryMenus() throws Exception{ return app.setBy(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id, 'rvCategoryType')]"), By.xpath("//*[@name='"+app.lang.getProperty("pairing_device_catalog_outdoor")+"']"));}
    public UIHelper scrollToText(String text) throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+text+"')]"), By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+text+"')]"));}

    public UIHelper getCamera(String cameraName) throws Exception {
        return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvCameraName') and @text='"+cameraName+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+cameraName+"']"));
    }

    public UIHelper getMenuCategory(String cameraCategory) throws Exception {
        return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvMenuName') and @text='"+cameraCategory+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+cameraCategory+"']"));
    }

    @Step("Select Camera")
    public void selectCamera() throws Exception {
        log.info("Select Camera");
        cameraName().click();
    }

    @Step("Click on hyperlink: If you did not hear anything, tap here.")
    public void clickOnDidNotHeardSoundLink() throws Exception {
        log.info("Click on hyperlink: If you did not hear anything, tap here.");
        didNotHearLink().click();
    }

    @Step("Verify Text Use a paper clip to push the reset button in for a few seconds displayed")
    public void verifyPushResetButtonMessageDisplayed() throws Exception {
        log.info("Verify Text Use a paper clip to push the reset button in for a few seconds displayed");
        Assert.assertTrue(pushResetButtonMessage().isElementPresent(5),
                "Text Use a paper clip to push the reset button in for a few seconds is not missing");
    }

    @Step("Scroll to camera {0}")
    public void scrollToCamera(String cameraName) throws Exception {
        log.info("Scroll to camera " + cameraName);
        if (app.isIOS()) {
            scrollToText(cameraName).scrollToElementDownSide();
        } else {
            scrollToText(cameraName).androidScrollToText(cameraName);
        }

    }

    @Step("Verify Select Device screen displayed")
    public void verifySelectDeviceScreenDisplayed() throws Exception {
        log.info("Verify Select Device screen displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5), "Add camera page is not displayed");
        Assert.assertTrue(backButton().isElementPresent(5), "Back button is not displayed");
        Assert.assertTrue(cameraTypeQrcode().isElementPresent(5), "QR code is not displayed");
        boolean categoryMenus;
        if(app.isIOSAndPerfectoExecution()){
            categoryMenus=app.perfectoIsTextPresent(app.lang.getProperty("pairing_device_catalog_outdoor"));
        }else {
            categoryMenus=categoryMenus().isElementPresent(5);
        }
        Assert.assertTrue(categoryMenus, "Category menu is not displayed");
    }

    @Step("Click Back button")
    public void clickBackButton() throws Exception {
        log.info("Click Back button");
        backButton().safeClick();
    }

    @Step("Verify camera displayed {0}")
    public void verifyCameraIsDisplayed(String cameraName) throws Exception {
        log.info("Verify Select Device screen displayed");
        Assert.assertTrue(getCamera(cameraName).isElementPresent(5), "Add camera page is not displayed");
    }

    @Step("Select camera category: {0}")
    public void selectCameraCategory(String categoryMenu) throws Exception {
        log.info("Verify category screen displayed");
        if(app.isIOSAndPerfectoExecution()){
            app.perfectoClickButton(categoryMenu);
        }else {
            Assert.assertTrue(getMenuCategory(categoryMenu).isElementPresent(5), "Category is not displayed");
        }
    }
}
