package com.kamivision.screens.common.accounts.profile.profileaccount;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class ProfileAccountScreen  {
    private final UIHelper app;
    public ProfileAccountScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvTitle')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("account_myAccountSetting_title")+"']"));}
    public UIHelper deleteAccountButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tv_delete_account')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("AccountDeletePassword_1476262444_1")+"']"));}
    public UIHelper deleteAccountConfirmMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("cloud_deleteDeviceHint")+"')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+app.lang.getProperty("cloud_deleteDeviceHint")+"')]"));}
    public UIHelper deleteAccountWarningMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("profile_delete_account_confirm_content1_content")+"')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+app.lang.getProperty("profile_delete_account_confirm_content1_content")+"')]"));}


    @Step("Verify Profile - Account page is displayed")
    public void verifyProfileAccountPageDisplayed() throws Exception {
        log.info("Verify Profile - Account page is displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5),
                "Account page is not displayed");
    }

    @Step("Verify Delete account confirmation message is displayed")
    public void verifyDeleteAccountConfirmationMessagePageDisplayed() throws Exception {
        log.info("Verify Delete account confirmation message is displayed");
        Assert.assertTrue(deleteAccountConfirmMessage().isElementPresent(15),
                "Delete account confirmation message is not displayed");
    }

    @Step("Verify Delete account warning message is displayed")
    public void verifyDeleteAccountWarningMessage() throws Exception {
        log.info("Verify Delete account warning message is displayed");
        Assert.assertTrue(deleteAccountWarningMessage().isElementPresent(15),
                "Delete account confirmation message is displayed/Displayed Twice");
    }

    @Step("Click on Delete Account button")
    public void clickOnDeleteAccountButton() throws Exception {
        log.info("Click on Delete Account button");
        deleteAccountButton().click();
    }
}
