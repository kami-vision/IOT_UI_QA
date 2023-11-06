package com.kamivision.screens.common.accounts.profile;

import com.kamivision.screens.common.LoginScreen;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class ChangePasswordScreen  {
    private final UIHelper app;
    public ChangePasswordScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper currentPassword() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText[@text ='"+app.lang.getProperty("account_reset_currentPassword")+"']"),By.xpath("(//XCUIElementTypeSecureTextField)[1]"));}
    public UIHelper newPassword() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText[@text ='"+app.lang.getProperty("account_retrieve_newPassword")+"']"),By.xpath("(//XCUIElementTypeSecureTextField)[2]"));}
    public UIHelper confirmNewPassword() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText[contains(@text,'"+app.lang.getProperty("account_retrieve_confiemNewPassword")+"')]"),By.xpath("(//XCUIElementTypeSecureTextField)[3]"));}
    public UIHelper changePwdButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tv_confirm')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("ChangePassword_1448448251_1")+"']"));}
    public UIHelper loginButton() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tv_confirm')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("Login_1441676159_248")+"']"));}
    public UIHelper successMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("password_has_changed")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("account_passwordUpdatePopup_title")+"']"));}
    public UIHelper oldPasswordField() throws Exception{ return app.setBy(By.xpath("(//android.widget.EditText)[1]"),By.xpath("(//XCUIElementTypeSecureTextField)[1]"));}

    @Step("Verify Change password successful message is displayed")
    public void verifyChangePasswordSuccessfulMessageIsDisplayed() throws Exception {
        log.info("Verify Change password successful message is displayed");
        Assert.assertTrue(successMessage().isElementPresent(5),
                "Change password successful message is not displayed");
    }

    @Step("Enter current and new password")
    public void inputCurrentAndNewPasswordMenuAndSave(String currentPassword, String newPassword) throws Exception {
        log.info("Enter current and new password");
        newPassword = newPassword.equals(app.props.getProperty("ChangePwdPwd")) ? newPassword : LoginScreen.CURRENT_PASSWORD + "1";
        rotateLoadingIcon().waitForDisappear();
        currentPassword().sendKeys(LoginScreen.CURRENT_PASSWORD);
        newPassword().sendKeys(newPassword);
        confirmNewPassword().sendKeys(newPassword);
        changePwdButton().click();
        rotateLoadingIcon().waitForDisappear();
        LoginScreen.CURRENT_PASSWORD = newPassword;
    }

    @Step("Click on Return button")
    public void clickOnReturnButton() throws Exception {
        log.info("Click on Return button");
        loginButton().click();
    }
}
