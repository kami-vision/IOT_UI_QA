package com.kamivision.screens.common;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class SignUpScreen  {
    private final UIHelper app;
    public SignUpScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper signUpPageTitle() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("account_regist_YI")+"']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("account_regist_YI")+"']"));}
    public UIHelper firstName() throws Exception{ return app.setBy(By.xpath("//*[@text='Enter first name']"),By.xpath("//XCUIElementTypeButton[@name='yh i login eye 0']/following-sibling::XCUIElementTypeTextField"));}
    public UIHelper lastName() throws Exception{ return app.setBy(By.xpath("//*[@text='Enter last name']"),By.xpath("(//XCUIElementTypeButton[@name='yh i login eye 0']/following-sibling::XCUIElementTypeTextField)[2]"));}
    public UIHelper enterEmailTextbox() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'etEmail')]//android.widget.EditText"),By.xpath("//XCUIElementTypeButton[@name='yh i login eye 0']/following-sibling::XCUIElementTypeTextField"));}
    public UIHelper enterPasswordTextbox() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'etPassword')]//android.widget.EditText"),By.xpath("(//XCUIElementTypeButton[@name='yh i login eye 1'])[1]/following-sibling::XCUIElementTypeSecureTextField"));}
    public UIHelper enterConfirmPasswordTextbox() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'etConfirmPassword')]//android.widget.EditText"),By.xpath("(//XCUIElementTypeButton[@name='yh i login eye 1'])[2]/following-sibling::XCUIElementTypeSecureTextField"));}
    public UIHelper enterCaptchaTextbox() throws Exception{ return app.setBy(By.xpath("//*[@resource-id='com.ants360.yicamera.international:id/btnSignup']/../../android.widget.LinearLayout[1]/android.widget.LinearLayout[7]//android.widget.EditText"),By.xpath("//XCUIElementTypeButton[@label='Sign up']/../..//XCUIElementTypeTable/XCUIElementTypeCell[7]//XCUIElementTypeTextField"));}
    public UIHelper signUpButton() throws Exception{ return app.setBy(By.xpath("//*[@resource-id='com.ants360.yicamera.international:id/btnSignup']"),By.xpath("//*[@name='"+app.lang.getProperty("XYLogin_1447845904_17")+"']"));}
    public UIHelper termAndCondCheckbox() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llUserAgreement')]"),By.xpath("//XCUIElementTypeButton[@name='yh i login uncheck']"));}
    public UIHelper incorrectPasswordMessage() throws Exception{ return app.setBy(By.xpath("//*[@text='" + app.lang.getProperty("account_err_passwordFormt") + "']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("XYLogin_1447845904_17")+"']"));}
    @Step("Enter Email Address")
    public void firstName(String firstName) throws Exception {
        log.info("Enter first name");
        firstName().sendKeys(firstName);
    }

    @Step("Enter last name")
    public void lastName(String lastName) throws Exception {
        log.info("Enter last name");
        lastName().sendKeys(lastName);
    }

    @Step("Enter Email Address")
    public void enterEmailAndVerify(String email) throws Exception {
        log.info("Enter Email Address");
        enterEmailTextbox().sendKeys(email);
    }

    @Step("Verify Email Address is Entered")
    public void verifyEmailEntered(String email) throws Exception {
        log.info("Verify Email Address is Entered");
        String currentEmail = enterEmailTextbox().getText();
        Assert.assertTrue(email.contains(currentEmail));
    }

    @Step("Enter Password and Enter Confirm Password")
    public void enterPasswordAndConfirmPassword(String password) throws Exception {
        log.info("Enter Password and Enter Confirm Password");
        enterPasswordTextbox().sendKeys(password);
        enterConfirmPasswordTextbox().sendKeys(password);
    }

    @Step("Enter Captcha and Verify")
    public void enterCaptchaAndVerify(String captcha) throws Exception {
        log.info("Enter Captcha and Verify");
        enterCaptchaTextbox().sendKeys(captcha);
        String enteredCaptcha = enterCaptchaTextbox().getText();
        Assert.assertTrue(captcha.contains(enteredCaptcha));
        if(app.isAndroid()) {
            enterCaptchaTextbox().hideKeyboard();
        }
    }

    @Step("Tap on Terms and Conditions CheckBox")
    public void tapOnTermAndConditionCheckbox() throws Exception {
        log.info("Tap on Terms and Conditions CheckBox");
        if(app.isAndroid())
            termAndCondCheckbox().click();
    }

    @Step("Click on Sign Up Icon")
    public void clickOnSignUpIcon() throws Exception {
        log.info("Click on Sign Up Icon");
        signUpButton().click();
    }


    @Step("Verify Sign Up Page is Displayed")
    public void verifySignUpPageDisplayed() throws Exception {
        log.info("Verify Sign Up Page is Displayed");
        Assert.assertTrue(signUpPageTitle().isElementPresent(5),
                "SignUp page is missing");
    }

    @Step("Verify Incorrect Password Format message appeared")
    public void verifyIncorrectPasswordFormatMessage() throws Exception {
        log.info("Verify Incorrect Password Format message appeared");
        Boolean isIncorrectPasswordMessage = incorrectPasswordMessage().isElementPresent(5);
        Assert.assertTrue(isIncorrectPasswordMessage, "Your password must be 8–16 characters and must include at least: one number, one uppercase letter and one lower case character.");
    }
}
