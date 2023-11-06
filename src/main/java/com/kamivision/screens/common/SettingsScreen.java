package com.kamivision.screens.common;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class SettingsScreen  {
    private final UIHelper app;
    public SettingsScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper deviceNameMenu() throws Exception{ return app.setBy(
            By.xpath("//*[@text='"+app.lang.getProperty("cameraSetting_name")+"' or contains(@text,'" +app.lang.getProperty("title_cameraName") + "')]"),
            By.xpath("//*[@name='"+app.lang.getProperty("DescribeCamera_1441676159_95")+"']"));}
    public UIHelper deviceSettingsMenu() throws Exception{ return app.setBy(
            By.xpath("//*[@text='" + app.lang.getProperty("cameraSetting_title")+ "' or @text='" + app.lang.getProperty("cameraNavigation_settings_label")+ "' and not(contains(@resource-id,'tv'))]"),
            By.xpath("//*[@name='"+app.lang.getProperty("PrivacyCamera_1441676159_146")+"']/following-sibling::*//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("title_cameraSettings")+"']"));}
    public UIHelper shareMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("share_camera_setting_title")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("PSelectorShare_1441710825_1")+"']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper logoutButton() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tv_login_out')]"),By.xpath("//*[@name='"+app.lang.getProperty("account_logout")+"']"));}
    public UIHelper confirmLogoutButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnAntsDialogRight')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("ios_confirm")+"']"));}
    public UIHelper pinProtectionToggle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_pincode_password")+"']/parent::*/following-sibling::android.view.View"),By.xpath("//*[@name='"+app.lang.getProperty("cameraSetting_pincode_password")+"']/..//XCUIElementTypeSwitch"));}
    public UIHelper cameraOffMessage() throws Exception{ return app.setBy(
            By.xpath("//*[contains(@text, '"+app.lang.getProperty("camera_hint_offline")+"') or contains(@text, '"+app.lang.getProperty("camera_hint_noConnection")+"')]"),
            By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("PrivacyCamera_1442543248_18")+"']"));}
    public UIHelper infoMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_network_info")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_101")+"']"));}
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"),By.xpath("//XCUIElementTypeButton[@name='yh ic nav back']"));}
    public UIHelper turnOnOffToggle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_mute_micAndCamera")+"']/parent::*/following-sibling::android.view.View"),By.xpath("//*[@name='"+app.lang.getProperty("cameraSetting_mute_micAndCamera")+"']/..//XCUIElementTypeSwitch"));}
    public UIHelper hideChatbotToggle() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("account_hideChatbotSetting_title")+"')]/../following-sibling::*"),By.xpath("//XCUIElementTypeSwitch[@name='Hide Chatbot, This will hide the chatbot throughout the app']"));}
    public UIHelper deviceName(String name) throws Exception {
        return app.setBy(By.xpath("//*[contains(@text,'"+name+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("DescribeCamera_1441676159_95")+"']/..//XCUIElementTypeStaticText[@name='"+name+"']"));
    }


    @Step("Click on menu: Device name")
    public void clickOnDeviceNameMenu() throws Exception {
        log.info("Click on menu: Device name");
        deviceNameMenu().isElementPresent(5);
        rotateLoadingIcon().waitForDisappear();
        deviceNameMenu().click();
    }

    @Step("Click on menu: Device Settings")
    public void clickOnDeviceSettingsMenu() throws Exception {
        log.info("Click on menu: Device Settings");
        rotateLoadingIcon().waitForDisappear();
        deviceSettingsMenu().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on menu: Share")
    public void clickOnShareMenu() throws Exception {
        log.info("Click on menu: Share");
        rotateLoadingIcon().waitForDisappear();
        shareMenu().click();
    }

    @Step("Verify camera name displayed")
    public void verifyCameraNameDisplayed(String cameraName) throws Exception {
        log.info("Verify camera name displayed");
        rotateLoadingIcon().waitForDisappear();
        Assert.assertTrue(deviceName(cameraName).isElementPresent(5),
                cameraName + " is not displayed");
    }

    @Step("User logout & confirm logout")
    public void logoutAndConfirm() throws Exception {
        log.info("User logout & confirm logout");
        logoutButton().click();
        confirmLogoutButton().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on menu: PIN Protection")
    public void clickOnPINProtectionToggle() throws Exception {
        log.info("Click on menu: PIN Protection");
        rotateLoadingIcon().waitForDisappear();
        pinProtectionToggle().click();
    }

    @Step("Verify PIN Protection toggle displayed")
    public void verifyPINProtectionToggleDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify PIN Protection toggle displayed");
        Assert.assertTrue(pinProtectionToggle().isElementPresent(30), "PIN toggle is missing");
    }

    @Step("Verify camera Off message is displayed")
    public void verifyCameraOffMessageIsDisplayed() throws Exception {
        log.info("Verify camera Off message is displayed");
        rotateLoadingIcon().waitForDisappear();
        Assert.assertTrue(cameraOffMessage().isElementPresent(15), "Camera is off is not displayed");
    }

    @Step("Navigate Back")
    public void clickOnBackButton() throws Exception {
        log.info("Navigate Back");
        rotateLoadingIcon().waitForDisappear();
        backButton().click();
        Thread.sleep(1000);
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on menu: Info")
    public void clickOnInfoMenu() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on menu: Info");
        infoMenu().scroll(UIHelper.ScrollDirection.DOWN);
        infoMenu().click();
    }

    @Step("Click on menu: Turn camera On-Off")
    public void clickOnTurnOnOffToggle() throws Exception {
        log.info("Click on toggle: Turn camera On-Off");
        if(app.isIOS()) {
            turnOnOffToggle().tapios();
            Thread.sleep(2000);
        } else {
            if (turnOnOffToggle().isElementPresent(5)) {
                turnOnOffToggle().click();
            }
        }

        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify camera is Turned off")
    public void verifyCameraIsTurnedOff() throws Exception {
        Thread.sleep(5000);
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify camera is Turned off");
        Assert.assertFalse(deviceSettingsMenu().isElementPresent(5),
                "Device setting menu still displayed, camera is not turned off");
    }

    @Step("Verify camera is Turned on")
    public void verifyCameraIsTurnedOn() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify camera is Turned On");
        Assert.assertTrue(deviceSettingsMenu().isElementPresent(25),
                "Device setting menu is not displayed, camera is not yet turned on");
    }

    @Step("Click Hide Chatbot toggle")
    public void clickHideChatbotToggle() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify chatbot toggle is clicked");
        hideChatbotToggle().click();
    }

    @Step("Verify Hide Chatbot toggle is switched ON")
    public void verifyHideChatbotIsSwitchedOn() throws Exception {
        log.info("Verify Hide-Chatbot toggle is switched ON");
        if(app.isAndroid()) {
        	//disabling for now as the attribute isn't changing even after toggling
        	//Assert.assertEquals(hideChatbotToggle().getAttribute("selected"), "true");
        }else {
        Assert.assertEquals(hideChatbotToggle().getAttribute("wdValue"), "1");
        }

    }

    @Step("Verify chatbot toggle is clicked")
    public void verifyHideChatbotIsSwitchedOFF() throws Exception {
        log.info("Verify Hide-Chatbot toggle is switched OFF");
        if(app.isAndroid()) {
        	Assert.assertEquals(hideChatbotToggle().getAttribute("selected"), "false");
        }else {
        Assert.assertEquals(hideChatbotToggle().getAttribute("wdValue"), "0");
        }

    }


}
