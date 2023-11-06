package com.kamivision.screens.common;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.UIHelper;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class LoginScreen  {
    private final UIHelper app;
    public static String CURRENT_PASSWORD;
    public LoginScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper acceptPermission() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("allow")+"']"),By.xpath("ios"));}

    public UIHelper continueButton() throws Exception{ return app.setBy(By.xpath("//*[@resource-id=\"com.yunyi.smartcamera:id/tvAreaSelectContinue\"]"),By.xpath("//*[@name='"+app.lang.getProperty("system_continue")+"']"));}
    public UIHelper loginUserName() throws Exception{ return app.setBy(By.xpath("//*[@text=\"Enter email\"]"),By.xpath("//XCUIElementTypeTable//XCUIElementTypeTextField"));}
    public UIHelper loginPassword() throws Exception{
        return app.setBy(
                By.xpath("//*[@text=\"Enter password\"]"),
                By.xpath("//XCUIElementTypeTable//XCUIElementTypeSecureTextField"));}
    public UIHelper test() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'action_bar_root')]"),By.xpath("//XCUIElementTypeImage[@name='yh_location_device_icon.png']"));}

    public UIHelper selectRegionDropdown() throws Exception{
        return app.setBy(By.xpath("//*[contains(@resource-id, 'llAreaSelect')]"),By.xpath("//*[@name='yh_location_pin.png']/../XCUIElementTypeStaticText"));
    }
    public UIHelper chooseYourLocationPageTitle() throws Exception{ return app.setBy(By.xpath("//*[@text='Choose your location']"),By.xpath("ios"));}
    public UIHelper createAccountButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvSignUp')]"),By.xpath("//*[@name='"+app.lang.getProperty("account_guide")+"']"));}
    public UIHelper loginButton() throws Exception{ return app.setBy(By.xpath(""),By.xpath("//*[@name='"+app.lang.getProperty("Login_1441676159_248")+"']"));}
    public UIHelper agreeTermsRadioButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llUserAgreement')]"),By.xpath("//XCUIElementTypeButton[@name='yh i login uncheck']"));}
    public UIHelper loginWithFacebookButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'ivFacebook')]"),By.xpath("//*[@label='facebookLoginButton']"));}
    public UIHelper agreeTermButton() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("account_login_agreementAgree")+"']"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("account_login_agreementAgree")+"']"));}
    public UIHelper termAndPrivacyPopup() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvThirdUserAgreement')]"),By.xpath("ios"));}

    public UIHelper continueTermAndPrivacy() throws Exception{ return app.setBy(By.xpath("(//*[contains(@text,'CONTINUE')])[last()]"),By.xpath("ios"));}
    public UIHelper facebookUsername() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'm_login_email')]"),By.xpath("//*[@name='main']/XCUIElementTypeTextField"));}
    public UIHelper facebookPassword() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'm_login_password')]"),By.xpath("//*[@name='main']/XCUIElementTypeSecureTextField"));}
    public UIHelper facebookLoginButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'login_password_step_element')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("facebook_login")+"']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}

    public UIHelper termsLink() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvUserAgreement')]"),By.xpath("//*[@name='"+app.lang.getProperty("onboarding_termsAndConditions_link")+"']"));}
    public UIHelper privacyPolicyLink() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvUserAgreement')]"),By.xpath("//*[@name='"+app.lang.getProperty("profile_user_privacyPolicy")+"']"));}
    public UIHelper incorrectPasswordMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'etPassword')]//*[@text='" + app.lang.getProperty("account_err_password")+ "']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("Login_1441676159_248")+"']"));}
    public UIHelper incorrectEmailMessage() throws Exception{ return app.setBy(By.xpath("//*[@text='" + app.lang.getProperty("account_err_inexistence") + "']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("Login_1441676159_248")+"']"));}
    public UIHelper privacy() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("privacy_policy")+"')]"), By.xpath("ios"));}

    public UIHelper backGround() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView\n[contains(@resource-id, 'ivAreaSelectBackground')]"),By.xpath("ios"));}

    public UIHelper selectRegionList(String region) throws Exception {
        return app.setBy(By.xpath("//*[@resource-id='com.yunyi.smartcamera:id/tvItemArea' and @text='"+region+"']"),By.xpath("//*[@name='"+region+"']"));
    }
    public UIHelper selectedRegion(String region) throws Exception {
        return app.setBy(By.xpath("//*[contains(@resource-id, 'llAreaSelect')]/*[@text = '" + region + "']"),By.xpath("//*[@name='"+region+"']"));
    }

    ////*[@resource-id="com.yunyi.smartcamera:id/tvCurrentSelectArea"]
    public UIHelper selectedRegion() throws Exception {
        return app.setBy(By.xpath("//*[@resource-id=\"com.yunyi.smartcamera:id/tvCurrentSelectArea\"]"),By.xpath(""));
    }

    public UIHelper RegionDropdown() throws Exception {
        return app.setBy(By.xpath("//*[@resource-id=\"com.yunyi.smartcamera:id/tvCurrentSelectArea\"]"),By.xpath(""));
    }
    public UIHelper clickOKbutton() throws Exception {
        return app.setBy(By.xpath("//Map<String, Object> params = new HashMap<>();params.put(\"label\", \"OK\");driver.executeScript(\"mobile:button-text:click\", params);"),By.xpath(""));
    }
    //*[@resource-id="com.yunyi.smartcamera:id/tvSignIn"]
    public UIHelper loginClick() throws Exception {
        return app.setBy(By.xpath("//*[@resource-id=\"com.yunyi.smartcamera:id/tvSignIn\"]"),By.xpath(""));
    }




    public UIHelper facebookContinueAsButton() throws Exception {
        return app.setBy(By.xpath("//*[@class='android.widget.Button' and contains(@text,'"+app.lang.getProperty("facebook_continue_as")+"')]"),By.xpath("//*[contains(@name,'"+app.lang.getProperty("facebook_continue_as")+"')]"));
    }

    public UIHelper facebookPopContinueButton() throws Exception {
        return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("facebook_continue")+"')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("facebook_continue")+"']"));
    }

    public UIHelper passwordField() throws Exception {
        return app.setBy(By.xpath("(//android.widget.EditText)[2]"),By.xpath(""));
    }

    public UIHelper userTips() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llUserTips')]"),By.xpath("ios"));}

    @Step("Skip OnBoarding step by clicking Continue")
    public void skipOnBoarding() throws Exception {
        log.info("Skip OnBoarding step by clicking Continue");
       continueButton().click();
    }



    @Step("Select Region {region}")
    public void selectRegion(String region) throws Exception {
        log.info("Select Region "+region);
        if (app.isIOS()) {
            if(!selectedRegion(region).isElementPresent(15)) {
                selectRegionDropdown().click();
                if(app.isIOS()) {
                    selectRegionList(region).getElement().click();
                    selectRegionList(region).tapios();
                }else {
                    selectRegionList(region).scrollToElementDownSide();
                    selectRegionList(region).click();
                }
            }
        } else {
            if (selectRegionDropdown().isElementPresent(15)) {
                selectRegionDropdown().click();
                selectRegionList(region).scrollToElementDownSide();
                selectRegionList(region).click();
            }
        }
    }

    @Step("Select Region {region}")
    public void selectRegion() throws Exception {
        log.info("Select Region ");
        //Thread.sleep(5);
        String region = app.props.getProperty("region");
        RegionDropdown().click();
        int maxScrollCount=10;
        while(!selectRegionList(region).isElementPresent() && maxScrollCount>0){
            selectRegionList(region).scrollToElementDownSide();
            maxScrollCount--;
        }
selectRegionList(region).click();
        continueButton().click();



    }






            //Wait for elemnet for 5 sec
            //If contry is US , click continue
            //if contry is any other
            //click on drop down and Wiat for 5 sec to load
            //scrool and select country
            //Click continue





    @Step("Login using already Created Account")
    public void login() throws Exception {
        log.info("Login using already Created Account");
        String username = app.props.getProperty("AppUserName");
        String password = app.props.getProperty("AppPassword");
        loginWithCred(username,password);
        Thread.sleep(3000);
        //rotateLoadingIcon().waitForDisappear();
    }

    @Step("Login with credentials")
    public void loginWithCredentials(String username, String password) throws Exception {
        loginWithCred(username,password);
        Thread.sleep(3000);
        rotateLoadingIcon().waitForDisappear();
    }

    public void loginWithCred(String username, String password) throws Exception {
        log.info("Login with credentials");
        if(app.isIOS()){
            WebElement loginTextBox = loginUserName().getElement();
            loginTextBox.click();
            app.selectEnglishKeyboard();
            if(loginTextBox.findElements(By.xpath("//XCUIElementTypeButton")).size()>0)
            loginTextBox.findElement(By.xpath("//XCUIElementTypeButton")).click();
            loginTextBox.sendKeys(username);
            loginPassword().sendKeys(password);
            // agreeTermsRadioButton().click();
            //app.hideKeyboard();
            loginClick().click();
        } else {
            loginUserName().sendKeys(username);
            loginPassword().sendKeys(password);
            // agreeTermsRadioButton().click();
            //app.hideKeyboard();
            loginClick().click();
           /* int maxAttempt = 5;
            while (maxAttempt-- > 0 && username.contains("mahipal") && !userTips().isElementPresent(15)) {
                rotateLoadingIcon().waitForDisappear();
                log.info("Try again with new password: " + password);
                password = password + 1;
                passwordField().clear();
                loginPassword().sendKeys(password);
                Thread.sleep(500);
                loginClick().click();
                rotateLoadingIcon().waitForDisappear();*/
            }
        }
        //CURRENT_PASSWORD = password;
    //}

    @Step("Login with credentials without waiting after login click")
    public void loginWithCredentialsWithoutWait(String username, String password) throws Exception {
        loginWithCred(username,password);
        rotateLoadingIcon().waitForDisappear();
    }


    @Step("Verify Incorrect Password message displayed")
    public void verifyIncorrectPasswordMessage() throws Exception {
        log.info("Verify Incorrect Password message displayed");
        Boolean isIncorrectPasswordMessage =incorrectPasswordMessage().isElementPresent(5);
        Assert.assertTrue(isIncorrectPasswordMessage, "Incorrect Password message is not displayed");
    }

    @Step("Verify Incorrect Email message displayed")
    public void verifyIncorrectEmailMessage() throws Exception {
        log.info("Verify Incorrect Email message displayed");
        Boolean isIncorrectEmailMessage = incorrectEmailMessage().isElementPresent(5);
        Assert.assertTrue(isIncorrectEmailMessage, "Incorrect Email message is not displayed");
    }

    @Step("Click on Create Account button")
    public void clickOnCreateAccount() throws Exception {
        log.info("Click on Create Account button");
        createAccountButton().click();
    }

    @Step("Click on Login with Facebook button")
    public void clickLoginWithFacebookButton() throws Exception {
        log.info("Click on Login with Facebook button");
        loginWithFacebookButton().click();
    }

    @Step("Click on Continue button on Term and Privacy popup")
    public void clickOnContinueButtonOnTermsAndPrivacyPopup() throws Exception {
        log.info("Click on Continue button on Term and Privacy popup");
       continueTermAndPrivacy().click();
    }

    @Step("Login to Facebook by account by input username, password and click login")
    public void loginWithFacebookAccount(String username, String password) throws Exception {
        log.info("Login to Facebook by account by input username, password and click login");
        if(!facebookContinueAsButton().isElementPresent(5)) {
            if(app.isIOS()){
                app.acceptAlert();
                //app.setBy(By.xpath(""),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("agree")+"']")).click();
                facebookPopContinueButton().click();
            }
            if (!facebookPopContinueButton().isElementPresent(5)) {
                facebookUsername().sendKeys(username);
                facebookPassword().sendKeys(password);
                facebookLoginButton().click();
            }
            facebookPopContinueButton().click();
        }else{
            facebookContinueAsButton().click();
        }
    }

    @Step("Click on Agree Term and privacy Agree button")
    public void clickAgreeButtonOnTermAndPrivacyPopup() throws Exception {
        agreeTermButton().click();
    }

    @Step("Verify Terms of Use and Privacy Policy displayed")
    public void verifyTermsOfUseAndPrivacyPolicyPopupDisplayed() throws Exception {
        Assert.assertTrue(termAndPrivacyPopup().isElementPresent(5), "Term and Privacy are not displayed");
    }

    @Step("Verify Region is Selected")
    public void verifyRegionSelected(String region) throws Exception {
        Assert.assertTrue(selectedRegion(region).isElementPresent(5), region + " not selected");
    }

    @Step("Verify Login Screen is displayed")
    public void verifyLoginScreenDisplayed() throws Exception {
        Assert.assertTrue(loginUserName().isElementPresent(5), "Login screen not displayed");
    }

    @Step("Open Term of Use page")
    public void clickOnTermOfUseHyperlink() throws Exception {
        if(app.isIOS()){
            termsLink().click();
        } else {
            if (app.getExecution().equalsIgnoreCase("perfecto")) {
                Map<String, Object> params = new HashMap<>();
                params.put("content", app.lang.getProperty("term_of_use"));
                params.put("threshold", 80);
                params.put("operation", "single");
                ((JavascriptExecutor) ((AppiumDriver) app.getDriver())).executeScript("mobile:text:select", params);
            } else {
                Assert.assertTrue(false, "Can be tested only Perfect As of now");
            }
        }
    }

    @Step("Open Privacy policy page")
    public void clickOnPrivacyPolicyHyperlink() throws Exception {
        if(app.isIOS()){
            privacyPolicyLink().click();
        }else {
            Map<String, Object> params = new HashMap<>();
            if (app.getExecution().equalsIgnoreCase("perfecto")) {
                params.put("content", app.lang.getProperty("privacy_policy"));
                params.put("threshold", 80);
                params.put("operation", "single");
                ((JavascriptExecutor) ((AppiumDriver) app.getDriver())).executeScript("mobile:text:select", params);
            } else {
                privacy().click();
            }
        }
    }

    @Step("Verify Landing screen details displayed")
    public void verifyLandingScreenDetailsDisplayed() throws Exception {
        log.info("Verify Welcome page displayed");
        Assert.assertTrue(test().isElementPresent(10), "Welcome page is not displayed");
        log.info("Verify Region dropdown displayed");
        Assert.assertTrue(selectRegionDropdown().isElementPresent(10), "Region dropdown is not displayed");
        log.info("Verify Continue button displayed");
        Assert.assertTrue(continueButton().isElementPresent(10), "Continue button is not displayed");
    }
}
