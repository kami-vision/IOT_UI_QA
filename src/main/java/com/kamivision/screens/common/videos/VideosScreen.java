package com.kamivision.screens.common.videos;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class VideosScreen  {
    private final UIHelper app;
    public VideosScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper pageTitleByCameraName(String cameraName) throws Exception {
        return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'camera_name_tv') and @text='"+cameraName+"']"),By.xpath("(//XCUIElementTypeStaticText[@name='"+cameraName+"'])[1]"));
    }
    @Step("Verify video page is displayed with camera {0}")
    public void verifyVideoPageDisplayed(String cameraName) throws Exception {
        log.info("Verify video page is displayed with camera "+cameraName);
        Assert.assertTrue(pageTitleByCameraName(cameraName).isElementPresent(10),
                "Videos page of camera: "+cameraName+" is missing");
    }
}
