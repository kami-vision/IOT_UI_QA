package com.kamivision.screens.common;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import utilities.UIHelper;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class SecurityScreen {
    private final UIHelper app;
    public SecurityScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper deviceNameMenu() throws Exception{ return app.setBy(
            By.xpath("//*[@text='"+app.lang.getProperty("cameraSetting_name")+"' or contains(@text,'" +app.lang.getProperty("title_cameraName") + "')]"),
            By.xpath("//*[@name='"+app.lang.getProperty("DescribeCamera_1441676159_95")+"']"));}
    public UIHelper learnMoreButton() throws Exception{ return app.setBy(
            By.xpath("(//XCUIElementTypeButton[@name='Learn More'])[1]"));}
    public UIHelper nextButton() throws Exception{ return app.setBy(
            By.xpath("//*[@label='page next']"));}
    public UIHelper tryKamiProButton() throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeButton[@label='Try Kami Pro Security']"));}
    public UIHelper yearlyRadioButton() throws Exception{ return app.setBy(
            By.xpath("//*[contains(text()='Yearly')]"));}
    public UIHelper monthlyRadioButton() throws Exception{ return app.setBy(
            By.xpath("//*[contains(text()='Monthly')]"));}
    public UIHelper buyNowButton() throws Exception{ return app.setBy(
            By.xpath("//*[@class='pro-bottom-btn']"));}
    public UIHelper subscribeButton()throws Exception{ return app.setBy(
                    By.xpath("//XCUIElementTypeButton[@label='Subscribe']"));}
    public UIHelper applePasswordTextbox()throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeButton[@label='Subscribe']"));}
    public UIHelper appleSignInButton()throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeButton[@label='Sign In']"));}
    public UIHelper okButton()throws Exception{ return app.setBy(
            By.xpath("//*[@label='OK']"));}
    public UIHelper startServiceButton()throws Exception{ return app.setBy(
            By.xpath("//*[@class='btn-next']"));}
    public UIHelper setupButton()throws Exception{ return app.setBy(
            By.xpath("(//XCUIElementTypeButton[@name='Setup'])[1]"));}
    public UIHelper iAgreeButton()throws Exception{ return app.setBy(
            By.xpath("//*[@label='I agree to all the above terms & conditions and privacy policy.']/preceding-sibling::XCUIElementTypeButton"));}
    public UIHelper homeAddressLink()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Home Address']"));}
    public UIHelper streetAddress1Textbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Street Address']/following-sibling::XCUIElementTypeTextField"));}
    public UIHelper streetAddress1IntelligentTextbox()throws Exception{ return app.setBy(
            By.xpath("(//*[@label='Street Address']/following-sibling::XCUIElementTypeTextField)[2]"));}
    public UIHelper streetAddress1Sugestion(String address)throws Exception{ return app.setBy(
            By.xpath("//*[@label='"+address+"']"));}
    public UIHelper streetAddress2Textbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Street Address']//following::XCUIElementTypeTextField[2]"));}
    public UIHelper cityTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='City']//following-sibling::XCUIElementTypeTextField"));}
    public UIHelper stateTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='State']//following-sibling::XCUIElementTypeTextField"));}
    public UIHelper zipTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='ZIP Code']//following-sibling::XCUIElementTypeTextField"));}

    public UIHelper firstnameTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='First Name']//following-sibling::XCUIElementTypeTextField"));}
    public UIHelper lastnameTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Last Name']//following-sibling::XCUIElementTypeTextField"));}
    public UIHelper phoneTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Phone Number']//following-sibling::XCUIElementTypeTextField"));}
    public UIHelper verificationCodeTextbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Verification Code']/following-sibling::XCUIElementTypeTextField"));}
    public UIHelper verifyButton()throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeButton[@label='Verify']"));}
    public UIHelper disarmSettings()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Disarm Passcode']"));}
    public UIHelper safeWordTextbox()throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeTextField"));}
    public UIHelper cameraSelection()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Camera Selection']"));}

    public UIHelper cameraSetup()throws Exception{ return app.setBy(
            By.xpath("(//*[@label='Camera Selection'])[2]"));}
    public UIHelper cameraCheckbox()throws Exception{ return app.setBy(
            By.xpath("//XCUIElementTypeCell/XCUIElementTypeImage[2]"));}
    public UIHelper iUnderstandcheckbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='unSelectBox']"));}
    public UIHelper setupCameraButton()throws Exception{ return app.setBy(
            By.xpath("//*[@value='Setup Cameras']"));}
    public UIHelper myCamerasAreSetupCheckbox()throws Exception{ return app.setBy(
            By.xpath("//*[@label='unSelectBox']"));}
    public UIHelper setupCamerasButton()throws Exception{ return app.setBy(
            By.xpath("//*[@value='Setup Cameras']"));}
    public UIHelper skipArmDisarmTestButton()throws Exception{ return app.setBy(
            By.xpath("///*[@value='Skip Arm & Disarm Test']"));}
    public UIHelper skipAlarmTestButton()throws Exception{ return app.setBy(
            By.xpath("//*[@value='Skip Alarm Test']"));}
    public UIHelper systemTestButton()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Test Run The System']"));}
    public UIHelper inviteHouseholdMembers()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Invite Household Members']"));}
    public UIHelper skipHouseholdMembers()throws Exception{ return app.setBy(
            By.xpath("///*[@value='Skip']"));}
    public UIHelper okayButton()throws Exception{ return app.setBy(
            By.xpath("//*[@value='Okay']"));}
    public UIHelper finishButton()throws Exception{ return app.setBy(
            By.xpath("//*[@value='Finish']"));}












    @Step("Click on Learn More button")
    public void clickOnLearnMoreButton() throws Exception{
        log.info("Learn more");
        learnMoreButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on Next button")
    public void clickOnNextButton() throws Exception{
        log.info("next button");
        nextButton().isElementPresent(10);
        nextButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on Next button multiple times")
    public void clickOnNextButtonMultipleTimes(int numberOfClick)throws Exception{
        while(numberOfClick!=0){
            clickOnNextButton();
            numberOfClick--;
        }
    }

    @Step("Click on Try kami pro security button")
    public void clickOnTryKamiProSecurityButton() throws Exception{
        log.info("Try Kami Pro Security");
        tryKamiProButton().click();
        Thread.sleep(1000);
    }

    @Step("Choose kami pro security purchase options")
    public void chooseKamiProSecutiryPurchaseOptions(String options)throws Exception{
        log.info("choose Kami Pro Security Purchase Options");
        Map<String, Object> params = new HashMap<>();params.put("content", options);
        ((JavascriptExecutor) ((AppiumDriver) app.getDriver())).executeScript("mobile:button-text:click", params);
        Thread.sleep(1000);

    }

    @Step("Click on buy now button")
    public void clickOnBuyNowButton() throws Exception{
        log.info("Buy Now");
        buyNowButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on subscribe button")
    public void clickOnSubscribeButton() throws Exception{
        log.info("Subscribe");
        subscribeButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on OK button if visible")
    public void clickOnOkButtonIfVisible() throws Exception{
        log.info("Ok");
        if(okButton().isElementPresent(10)) {
            okButton().click();
            Thread.sleep(1000);
        }
    }

    @Step("Enter apple password")
    public void enterApplePwdifVisible(String applePassword) throws Exception{
        log.info("Apple Password");
        if(appleSignInButton().isElementPresent(10)) {
            applePasswordTextbox().sendKeys(applePassword);
            Thread.sleep(1000);
            appleSignInButton().click();
        }
    }

    @Step("Click on start service button")
    public void clickOnStartServiceButton() throws Exception{
        log.info("start service");
        startServiceButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on Setup button")
    public void clickOnSetupButton() throws Exception{
        log.info("setup");
        setupButton().click();
        Thread.sleep(1000);
    }

    @Step("Click on agree terms and click next button")
    public void agreeTermsAndClickNext() throws Exception{
        log.info("Agree terms and click Next");
        iAgreeButton().click();
        Thread.sleep(1000);
        nextButton().click();
        Thread.sleep(1000);
    }

    @Step("Enter address details")
    public void enterAddressDetails(String streetAddress1) throws Exception{

        homeAddressLink().click();
        Thread.sleep(1000);

        streetAddress1Textbox().click();
        Thread.sleep(1000);

        streetAddress1IntelligentTextbox().sendKeys(streetAddress1);
        Thread.sleep(1000);
        streetAddress1Sugestion(streetAddress1).click();
        Thread.sleep(1000);
////*[@label="718 Cassaday Court, San Jose, CA, USA"]
        /*streetAddress2Textbox().sendKeys(streetAddress2);
        Thread.sleep(1000);

        cityTextbox().sendKeys(city);
        Thread.sleep(1000);

        stateTextbox().sendKeys(state);
        Thread.sleep(1000);

        zipTextbox().sendKeys(zip);
        Thread.sleep(1000);

        nextButton().click();
        Thread.sleep(1000);
*/
    }

    @Step("Enter primary contact name")
public void enterPrimaryContactName(String firstName, String lastName) throws Exception{
        firstnameTextbox().sendKeys(firstName);
        Thread.sleep(1000);
        lastnameTextbox().sendKeys(lastName);
        Thread.sleep(1000);
}

    @Step("Enter primary contact phone")
public void enterPrimaryContactPhone(String phone) throws Exception{
        phoneTextbox().sendKeys(phone);
        Thread.sleep(1000);
}

    @Step("Enter verification code")
public void enterVerificationCode(String verificationCode) throws  Exception{
    phoneTextbox().sendKeys(verificationCode);
    Thread.sleep(1000);
    verifyButton().click();
}

    @Step("Enter safe word")
    public void enterSafeWord(String safeWord) throws  Exception{
        safeWordTextbox().sendKeys(safeWord);
        Thread.sleep(1000);
        nextButton().click();
    }

    @Step("Click on disarm setting")
public void clickDisarmSettings()throws Exception{
        disarmSettings().click();
    Thread.sleep(1000);
}

    @Step("Click on camera setup")
    public void clickCameraSetup()throws Exception{
        cameraSetup().click();
        Thread.sleep(1000);
    }
    @Step("Click on camera selection")
    public void clickCameraSelection()throws Exception{
        cameraSelection().click();
        Thread.sleep(1000);
    }

    @Step("Select first camera and click next")
    public void selectFirstCameraAndClickNext()throws Exception{
        cameraCheckbox().click();
        Thread.sleep(1000);
        nextButton();
    }

    @Step("click on I understand checkbox")
    public void clickOnIUnderstandCheckbox() throws Exception{
        iUnderstandcheckbox().click();
        Thread.sleep(1000);
    }

    @Step("Click on Setup camera button")
    public void clickOnSetupCameraButton()throws Exception{
        cameraSetup().click();
        Thread.sleep(1000);
    }
    @Step("setup cameras before continuing")
    public void setupCamerasBeforeContinuing()throws Exception{
        myCamerasAreSetupCheckbox().click();
        setupCamerasButton().click();
        Thread.sleep(1000);
    }

    @Step("Configure system test")
    public void SystemTest()throws Exception{
        systemTestButton().click();;
        Thread.sleep(1000);
        skipArmDisarmTestButton().click();
        Thread.sleep(1000);
        skipAlarmTestButton().click();
        Thread.sleep(1000);
    }

    @Step("configure household members")
    public void houseHoldMembers()throws Exception{
        inviteHouseholdMembers().click();
        Thread.sleep(1000);
        skipHouseholdMembers().click();
        Thread.sleep(1000);
        okayButton().click();
    }

    @Step("click on finish setup")
    public void finishSetup()throws Exception{
        finishButton().click();
        Thread.sleep(1000);
    }


}
