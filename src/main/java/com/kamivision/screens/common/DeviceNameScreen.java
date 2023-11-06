package com.kamivision.screens.common;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class DeviceNameScreen  {
    private final UIHelper app;
    public DeviceNameScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper deviceNameTextBox() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText[contains(@resource-id,'edtNickName')]"),By.xpath("//XCUIElementTypeTextField"));}
    public UIHelper saveButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id,'btnSave')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("select_device_list_save")+"']"));}
    public UIHelper equipmentNumber() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id,'tvUID')]"),By.xpath("//XCUIElementTypeStaticText[starts-with(@name,'"+app.lang.getProperty("system_number")+"')]"));}


    @Step("Enter name for the camera: {0}")
    public void editDeviceName(String name) throws Exception {
        log.info("Enter name for the camera: "+name);
       deviceNameTextBox().sendKeys(name);
    }

    @Step("Save Changes")
    public void saveChanges() throws Exception {
        log.info("Save Changes");
        saveButton().click();
    }

    @Step("Verify equipment number of device displayed")
    public void verifyEquipmentNumberDisplayed() throws Exception {
        log.info("Verify equipment number of device displayed");
        Assert.assertTrue(equipmentNumber().isElementPresent(5), "Camera Equipment number is missing");

    }
}
