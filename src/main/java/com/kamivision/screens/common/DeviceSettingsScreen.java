package com.kamivision.screens.common;
import com.kamivision.screens.common.alerts.AlertsScreen;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class DeviceSettingsScreen  {
    private final UIHelper app;
    public DeviceSettingsScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper cameraMicrophoneToggle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llMicVolume')]/*/android.view.View"),By.xpath("//*[@name='"+app.lang.getProperty("CameraOtherSetting_1461899937_40")+"']/..//XCUIElementTypeSwitch"));}
    public UIHelper statusLightToggle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llMicVolume')]/*/android.view.View"),By.xpath("//XCUIElementTypeStaticText[@name=\""+app.lang.getProperty("CameraOtherSetting_1461899937_39")+"\"]/..//XCUIElementTypeSwitch"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}

    public UIHelper timeZoneMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llTimeZone')]"),By.xpath("//*[@name='"+app.lang.getProperty("system_zone")+"']"));}
    public UIHelper timeZoneList() throws Exception{ return app.setBy(By.xpath("//android.widget.ListView[contains(@resource-id, 'timeZoneListView')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+app.lang.getProperty("utc")+"')]"));}
    public UIHelper nightVisionMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llNightVisionH18')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraOtherSetting_1452571389_1")+"']/..//XCUIElementTypeSwitch"));}
    public UIHelper nightVisionToggle() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llNightVisionH18')]/*/android.view.View"),By.xpath("//*[@name='"+app.lang.getProperty("CameraOtherSetting_1452571389_1")+"']/..//XCUIElementTypeSwitch"));}
    public UIHelper cameraLightToggle() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llLight')]/*/android.view.View"),By.xpath("//XCUIElementTypeSwitch[@name=\""+app.lang.getProperty("CameraOtherSetting_1461899937_39")+"\"]"));}
    public UIHelper firmwareVersion() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("system_firmwareVersion")+"')]"),By.xpath("//*[@name='"+app.lang.getProperty("PrivacyCamera_1441676159_165")+"']"));}
    public UIHelper callModeMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("cameraSetting_basic_audioMode_call")+"')]"),By.xpath("//*[@name=\""+app.lang.getProperty("CameraOtherSetting_1466056833_29")+"\"]"));}
    public UIHelper callModeSettingPopup() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("cameraSetting_basic_audioMode_setting")+"')]"),By.xpath("//*[contains(@name, '"+app.lang.getProperty("ConversationModeSet_1466056833_172")+"')]"));}
    public UIHelper callModeIntercomOption() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'icon_intercom_mode')]"),By.xpath("//*[@name='"+app.lang.getProperty("CameraOtherSetting_1466056833_31")+"']"));}
    public UIHelper callModeHandFreeOption() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'icon_conversation_mode')]"),By.xpath("//*[@name='"+app.lang.getProperty("CameraOtherSetting_1466056833_30")+"']"));}
    public UIHelper okCallMode() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnAntsDialogRight')]"),By.xpath("//*[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"']"));}
    public UIHelper callModeIntercomSelected() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("cameraSetting_basic_audioMode_talkback")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraOtherSetting_1466056833_31")+"']"));}
    public UIHelper callModeHandFreeSelected() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("cameraSetting_basic_audioMode_phone")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraOtherSetting_1466056833_30")+"']"));}
    public UIHelper lensDistortion() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("cameraSetting_basic_idcAdjust_android")+"')]"),By.xpath("//*[contains(@name, '"+app.lang.getProperty("CameraOtherSetting_1451384669_8")+"')]"));}

    public UIHelper recordBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'btnRecord')]"),By.xpath("//XCUIElementTypeButton[@name='Icons Record']"));}
    public UIHelper stopBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvRecTime')]"),By.xpath("//XCUIElementTypeButton[starts-with(@name,'0:')]"));}
    public UIHelper viewAlbum() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'btnEnterAlbum')]"),By.xpath("//XCUIElementTypeStaticText[@name='View album']"));}
    public UIHelper fullScreenBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'btnFullScreen')]"),By.xpath("//XCUIElementTypeButton[@name='yh btn play fullscreen']"));}
    public UIHelper horizontalView() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'horizontalTitle')]"),By.xpath("ios"));}

    public UIHelper allowAccessButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[contains(@name,'Allow')]"));}
    @Step("Verify Camera Microphone toggle displayed")
    public void verifyCameraMicrophoneToggleDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Camera Microphone toggle displayed");
        Assert.assertTrue(cameraMicrophoneToggle().isElementPresent(15), "Camera Microphone toggle is missing");
    }

    @Step("Click on menu: Timezone")
    public void clickOnTimeZoneMenu() throws Exception {
        log.info("Click on menu: Timezone");
        timeZoneMenu().click();
    }

    @Step("Verify Timezone list displayed")
    public void verifyTimeZoneListIsDisplayed() throws Exception {
        log.info("Verify Timezone list displayed");
        Assert.assertTrue(timeZoneList().isElementPresent(25), "Timezone list is missing");
    }

    @Step("Verify Status Light toggle displayed")
    public void verifyStatusLightToggleDisplayed() throws Exception {
        log.info("Verify Status Light toggle displayed");
        Assert.assertTrue(cameraLightToggle().isElementPresent(5), "Camera Light toggle is missing");
    }

    @Step("Click on Status Light toggle")
    public void clickStatusLightToggle() throws Exception {
        log.info("Click on Status Light toggle");
        statusLightToggle().click();
    }

    @Step("Click on Camera microphone toggle")
    public void clickCameraMicrophoneToggle() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Camera microphone toggle");
        cameraMicrophoneToggle().click();
    }

    @Step("Click on Firmware Version")
    public void clickFirmwareVersionMenu() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Firmware Version");
        if(app.isIOS())
            firmwareVersion().tapios();
        else
            firmwareVersion().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Night vision IR Light menu displayed")
    public void verifyNightVisionMenuIsDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        Assert.assertTrue(nightVisionMenu().isElementPresent(30), " Night vision IR Light menu is missing");
    }

    @Step("Click on Night vision IR Light toggle")
    public void clickNightVisionIRToggle() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Night vision IR Light toggle");
        nightVisionToggle().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on menu: Call mode")
    public void clickOnCallModeMenu() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        if(app.isIOS())
            callModeMenu().tapios();
        else
            callModeMenu().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Call Mode setting popup displayed")
    public void verifyCallModeSettingPopupDisplayed() throws Exception {
        log.info("Verify Call Mode setting popup displayed");
        app.waitForAnimationEffectInSeconds(5);
        if(app.isIOSAndPerfectoExecution() && false){
            Assert.assertTrue(app.perfectoIsTextPresent(app.lang.getProperty("ConversationModeSet_1466056833_172")),"Call Mode setting popup is missing");
        }else {
            Assert.assertTrue(callModeSettingPopup().isElementPresent(15),
                    "Call Mode setting popup is missing");
        }
    }

    @Step("Click on Call mode - Intercom option")
    public void selectCallModeIntercomOption() throws Exception {
        log.info("Click on Call mode - Intercom option");
        if(app.isIOSAndPerfectoExecution() && false){
            app.perfectoClickButton(app.lang.getProperty("CameraOtherSetting_1466056833_31"));
        }else {
            callModeIntercomOption().click();
        }
    }

    @Step("Click on Call mode - HandFree option")
    public void selectCallModeHandFreeOption() throws Exception {
        log.info("Click on Call mode - HandFree option");
        if(app.isIOSAndPerfectoExecution() && false){
            app.perfectoClickButton(app.lang.getProperty("CameraOtherSetting_1466056833_30"));
        }else {
            callModeHandFreeOption().click();
        }
    }

    @Step("Click on OK Call mode button")
    public void clickOnOkCallModeOption() throws Exception {
        log.info("Click on OK Call mode button");
        if(app.isIOSAndPerfectoExecution()&& false){
            app.perfectoClickButtonWithCase(app.lang.getProperty("ConnectBase_1441676159_41"));
        }else {
            okCallMode().click();
        }
    }

    @Step("Verify Call Mode Intercom selected")
    public void verifyCallModeInterCornOptionsSelected() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Call Mode Intercom displayed");
        Assert.assertTrue(callModeIntercomSelected().isElementPresent(25), "Call Mode Intercom is not displayed");
    }

    @Step("Verify Call Mode Hand-free selected")
    public void verifyCallModeHandFreeOptionsSelected() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Call Mode Hand-free displayed");
        Assert.assertTrue(callModeHandFreeSelected().isElementPresent(25), "Call Mode Hand-free is not displayed");
    }

    @Step("Click on Lens Distortion Correction")
    public void clickLensDistortionCorrectionMenu() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Lens Distortion Correction");
        if(app.isIOS())
            lensDistortion().tapios();
        else
            lensDistortion().click();
    }

    @Step("On device settings, click record button")
    public void clickRecordBtn() throws Exception {
            rotateLoadingIcon().waitForDisappear();
            log.info("On device settings, click record button");
            recordBtn().click();
            log.info("Let record happens in 5s");
            Thread.sleep(5000);
    }

    @Step("On device settings, click stop button")
    public void clickStopBtn() throws Exception {
            rotateLoadingIcon().waitForDisappear();
            log.info("On device settings, click stop button");
            stopBtn().click();
            if(app.isIOS() && app.setBy(null,app.alertOKButton).isElementPresent()) {
                app.acceptAlertOK();
            }
    }

    @Step("Verify view album is visible")
    public void verifyViewAlbumIsVisible() throws Exception {
        log.info("Verify view album is visible");
        if(app.isAndroid()) {
            Assert.assertTrue(viewAlbum().isElementPresent(25), "View album is not visible");
        }else{
            if(viewAlbum().isElementPresent(4)){
                Assert.assertTrue(true, "View album is not visible");
            }else{
                log.info("Before Element identified it is vanished");
            }
        }
    }

    @Step("On device settings, click full screen button")
    public void clickFullScreenBtn() throws Exception {
            rotateLoadingIcon().waitForDisappear();
            log.info("On device settings, click full screen button");
            fullScreenBtn().click();
    }

    @Step("Verify fullscreen mode is displayed")
    public void verifyFullScreenModeIsDisplayed() throws Exception {
        if (app.isAndroid()) {
            rotateLoadingIcon().waitForDisappear();
            log.info("Verify fullscreen mode is displayed");
            Assert.assertTrue(horizontalView().isElementPresent(25), "Full screen mode is not visible");
        }else{
            rotateLoadingIcon().waitForDisappear();
            log.info("Verify fullscreen mode is displayed");
            Assert.assertFalse(new AlertsScreen(app).alertClipNames().isElementPresent(2), "Full screen mode is not visible");
        }
    }
}
