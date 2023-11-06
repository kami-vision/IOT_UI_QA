package com.kamivision.screens.common;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class AlbumScreen {
    private final UIHelper app;
    public AlbumScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh ic nav back']"));}

    @Step("Album back button")
    public void clickOnBackButton() throws Exception {
        log.info("Album back button");
        backButton().click();
    }
}
