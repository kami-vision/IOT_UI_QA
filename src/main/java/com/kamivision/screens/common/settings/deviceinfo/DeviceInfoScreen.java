package com.kamivision.screens.common.settings.deviceinfo;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class DeviceInfoScreen {
    private final UIHelper app;
    public DeviceInfoScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"), By.xpath("ios"));}

    public UIHelper wifiSSID() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llWifiName')]//android.widget.TextView[@text='"+app.lang.getProperty("system_wifiName")+"' or @text='"+app.lang.getProperty("CameraNetworkInfo_1441676159_102")+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_102")+"']/../XCUIElementTypeStaticText"));}
    public UIHelper wifiStrength() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llWifiStrength')]//android.widget.TextView[@text='"+app.lang.getProperty("system_wifiStrength")+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_103")+"']/../XCUIElementTypeStaticText"));}
    public UIHelper rPackageLoss() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llRouterConnect')]//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_network_router_loss")+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_104")+"']/../XCUIElementTypeStaticText"));}
    public UIHelper iPackageLoss() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llServerConnect')]//android.widget.TextView[contains(@text,'"+app.lang.getProperty("cameraSetting_network_server_loss")+"')]"), By.xpath("//XCUIElementTypeStaticText[@name=\""+app.lang.getProperty("CameraNetworkInfo_1441676159_105")+"\"]/../XCUIElementTypeStaticText"));}
    public UIHelper ipAddr() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llIP')]//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_network_ipAddress")+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_107")+"']/../XCUIElementTypeStaticText"));}
    public UIHelper macAddr() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llMAC')]//android.widget.TextView[@text='"+app.lang.getProperty("cameraSetting_network_macAddress")+"']"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("CameraNetworkInfo_1441676159_108")+"']/../XCUIElementTypeStaticText"));}


    @Step("Verify Info page details displayed")
    public void verifInfoDetailsPageDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Info page details displayed");
        Assert.assertTrue(wifiSSID().isElementPresent(5), "Wifi SSID is not displayed");
        Assert.assertTrue(wifiStrength().isElementPresent(5), "Wifi Strength is not displayed");
        Assert.assertTrue(rPackageLoss().isElementPresent(5), "Router package loss is not displayed");
        Assert.assertTrue(iPackageLoss().isElementPresent(5), "Internet package loss is not displayed");
        Assert.assertTrue(ipAddr().isElementPresent(5), "IP address is not displayed");
        Assert.assertTrue(macAddr().isElementPresent(5), "MAC addr is not displayed"); 
    }
}
