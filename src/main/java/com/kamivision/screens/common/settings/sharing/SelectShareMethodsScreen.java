package com.kamivision.screens.common.settings.sharing;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class SelectShareMethodsScreen  {
    private final UIHelper app;
    public SelectShareMethodsScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("share_chooseSharingMethod")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name='"+app.lang.getProperty("CameraShareStyle_1484535623_57")+"']"));}
    public UIHelper shareWithOtherAccount() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text ='"+app.lang.getProperty("share_YIAccount")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("share_YIAccount")+"']"));}


    @Step("Tap on Share with another account")
    public void clickOnShareWithOtherAccount() throws Exception {
        log.info("Tap on Share with another account");
        shareWithOtherAccount().click();
    }

    @Step("Verify 'Select method of sharing' page displayed")
    public void verifySelectMethodOfSharingPageDisplayed() throws Exception {
        log.info("Verify 'Select method of sharing' page displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5),
                "Select method of sharing page not displayed");
    }
}
