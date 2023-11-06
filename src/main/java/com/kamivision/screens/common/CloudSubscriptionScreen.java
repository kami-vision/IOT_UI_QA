package com.kamivision.screens.common;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class CloudSubscriptionScreen {
    private final UIHelper app;
    public static boolean isPurchased;
    public CloudSubscriptionScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper manageCloudPlanTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'My Plans')]"), By.xpath("//XCUIElementTypeNavigationBar[@name='Manage Plan']"));}
    public UIHelper later() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Later')]"), By.xpath("ios"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper manageCloudPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tv_cloud_btn')]"), By.xpath("ios"));}
    public UIHelper buyBtn() throws Exception{ return app.setBy(By.xpath("(//android.widget.Button[contains(@text,'" + app.lang.getProperty("buy_android")+ "')])[2]"), By.xpath("ios"));}
    public UIHelper kamiCloudPlans() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("kami_cloud_plans_android")+ "')]"), By.xpath("ios"));}
    public UIHelper purchaseNewPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("h5_managePlans_purchaseNewPlan_button")+ "')]"), By.xpath("ios"));}
    public UIHelper monthlyOption() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("monthly_anroid")+ "')]"), By.xpath("ios"));}
    public UIHelper plusOption() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("plus_android")+ "')]"), By.xpath("ios"));}
    public UIHelper standardOption() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("standard_android")+ "')]"), By.xpath("ios"));}
    public UIHelper cvrEntryOption() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("cvr_entry_android")+ "')]"), By.xpath("ios"));}
    public UIHelper entryOption() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("entry_android")+ "')]"), By.xpath("ios"));}
    public UIHelper buyNowBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("buy_now_android")+ "')]"), By.xpath("ios"));}
    public UIHelper orderConfirmation() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text,'" + app.lang.getProperty("order_confirmation_android")+ "')]"), By.xpath("ios"));}
    public UIHelper standardStorageTime() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("storage_time_android")+ "')]//following-sibling::android.view.View[contains(@text,'" + app.lang.getProperty("15_days_android") + "')]"), By.xpath("ios"));}
    public UIHelper standardSupportedCameras() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("supported_cameras_android")+ "')]//following-sibling::android.view.View[contains(@text,'5')]"), By.xpath("ios"));}
    public UIHelper standardServiceLength() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("service_length_android")+ "')]//following-sibling::android.view.View[contains(@text,'" + app.lang.getProperty("months_android") + "')]"), By.xpath("ios"));}
    public UIHelper standardPrice() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("price_android")+ "')]//following-sibling::android.view.View[contains(@text,'$ 11.99') or contains(@text,'$ 79.99')]"), By.xpath("ios"));}
    public UIHelper standardPayment() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("credit_debit_card_android")+ "')]"), By.xpath("ios"));}
    public UIHelper standardPaypal() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("paypal_android")+ "')]"), By.xpath("ios"));}
    public UIHelper continueBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("continue_android")+ "')]"), By.xpath("ios"));}
    public UIHelper selectedCard() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'mastercard **** ***** **** 5936')]"), By.xpath("ios"));}
    public UIHelper purchaseBtn() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@text,'" + app.lang.getProperty("purchase_android")+ "')]"), By.xpath("ios"));}
    public UIHelper paymentSuccess() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("payment_success_android")+ "')]"), By.xpath("ios"));}
    public UIHelper startServiceBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'" + app.lang.getProperty("start_service_android")+ "')]"), By.xpath("ios"));}
    public UIHelper addCameras() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text,'" + app.lang.getProperty("add_cameras_android")+ "')]"), By.xpath("ios"));}
    public UIHelper addNewCardBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Add new card')]"), By.xpath("ios"));}
    public UIHelper haveCloudServiceCardLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Have a Yi Cloud Service Card?')]"), By.xpath("ios"));}
    public UIHelper enter18DigitLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Please enter 18-digit')]"), By.xpath("ios"));}
    public UIHelper serviceCodeField() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText"), By.xpath("ios"));}
    public UIHelper okBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'OK')]"), By.xpath("ios"));}
    public UIHelper termsAndPrivacyPolicy() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Terms of use & Privacy Policy')]"), By.xpath("ios"));}
    public UIHelper purchaseAdditionPlanBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Purchase Additional Plan')]"), By.xpath("ios"));}
    public UIHelper privacyPolicy() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Privacy Policy')]"), By.xpath("ios"));}
    public UIHelper whatIsCRV() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'what is CVR?')]"), By.xpath("ios"));}
    public UIHelper CVRpopup() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'CVR vs Motion')]"), By.xpath("ios"));}
    public UIHelper CVRtext() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'CVR recording is not supported on battery powered cameras')]"), By.xpath("ios"));}

    @Step("Verify Cloud Plans Option")
    public void verifyCloudPlanOption() throws Exception {
        log.info("Verify Cloud Plans Option");
        if(app.isAndroid()) {
            Assert.assertTrue(manageCloudPlan().isElementPresent(15), "Cloud Plans Option is not available");
        }
    }

    @Step("Click on Manage and Purchase Cloud Plan")
    public void clickOnCloudPlans() throws Exception {
        log.info("Click on Manage and Purchase Cloud Plan");
        if(app.isAndroid()) {
            manageCloudPlan().safeClick();
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(1000);
            purchaseNewPlan().safeClick();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify Kami cloud plan screen")
    public void verifyKamiCloudPlanScreen() throws Exception {
        log.info("Verify Kami cloud plan screen");
        if(app.isAndroid()) {
            Assert.assertTrue(monthlyOption().isElementPresent(15), "Monthly option is not displayed");
        }
    }

    @Step("Click on Monthly")
    public void clickMonthlyOption() throws Exception {
        log.info("Click on Monthly");
        if(app.isAndroid()) {
            monthlyOption().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify Plus, Standard, CVR-Entry, Entry plan, amount and benefits")
    public void verifyPlanOptionsAndBenefits() throws Exception {
        log.info("Verify Plus, Standard, CVR-Entry, Entry plan, amount and benefits");
        if(app.isAndroid()) {
            Assert.assertTrue(standardOption().isElementPresent(15), "Standard is not displayed");
            Assert.assertTrue(plusOption().isElementPresent(15), "Plus is not displayed");
            Assert.assertTrue(cvrEntryOption().isElementPresent(15), "CVR Entry is not displayed");
            Assert.assertTrue(entryOption().isElementPresent(15), "Entry Plan is not displayed");
        }
    }

    @Step("Select any monthly plan randomly (except Plus plan)")
    public void SelectStandardPlan() throws Exception {
        log.info("Select any monthly plan randomly (except Plus plan)");
        if(app.isAndroid()) {
            standardOption().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Select Buy now")
    public boolean selectBuyNow() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Select Buy now");
        if(app.isAndroid()) {
            buyNowBtn().click();
            rotateLoadingIcon().waitForDisappear();
            isPurchased = continueBtn().isElementPresent(5);
        }
        log.info("Is plan purchased before: " + isPurchased);
        return isPurchased;
    }

    @Step("Verify Order Confirmation screen")
    public void verifyOrderConfirmationScreen() throws Exception {
        log.info("Verify Order Confirmation screen");
        if(app.isAndroid()) {
            Assert.assertTrue(orderConfirmation().isElementPresent(15), "Order confirmation is not displayed");
            Assert.assertTrue(standardStorageTime().isElementPresent(15), "Storage is not displayed");
            Assert.assertTrue(standardSupportedCameras().isElementPresent(15), "Supported cameras is not displayed");
            Assert.assertTrue(standardServiceLength().isElementPresent(15), "Service length is not displayed");
            Assert.assertTrue(standardPrice().isElementPresent(15), "Price is not displayed");
            Assert.assertTrue(standardPayment().isElementPresent(15), "Payment methods are not displayed");
            Assert.assertTrue(standardPaypal().isElementPresent(15), "Paypal is not displayed");
        }
    }

    @Step("Select Paypal")
    public void selectPaypal() throws Exception {
        log.info("Select Paypal");
        if(app.isAndroid()) {
            standardPaypal().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Tap on Continue")
    public void tapContinueButton() throws Exception {
        log.info("Tap on Continue");
        if(app.isAndroid() && continueBtn().isElementPresent(5)) {
            continueBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Select your card and then, click purchase button")
    public void selectYourCardAndClickPurchase() throws Exception {
        log.info("Select your card and then, click purchase button");
        if(app.isAndroid()) {
            selectedCard().click();
            purchaseBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify Payment success message")
    public void verifyPaymentSuccessMessage() throws Exception {
        log.info("Verify Payment success message");
        if(app.isAndroid()) {
            Assert.assertTrue(paymentSuccess().isElementPresent(15), "Success Message is not displayed");
        }
    }

    @Step("Click on Start service")
    public void clickStartService() throws Exception {
        log.info("Click on Start service");
        if(app.isAndroid()) {
            startServiceBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify it should take to cloud service page, where it will list purchased plan")
    public void verifyPurchasedPlanWithLisOfCamera() throws Exception {
        log.info("Verify it should take to cloud service page, where it will list purchased plan");
        if(app.isAndroid()) {
            Assert.assertTrue(addCameras().isElementPresent(15), "Add cameras view is not displayed");
        }
    }

    @Step("Scroll down and click on Cloud Service Card")
    public void scrollDownAndClickCloudServiceCard() throws Exception {
        log.info("Scroll down and click on Cloud Service Card");
        if(app.isAndroid()) {
        	haveCloudServiceCardLabel().scrollToElementDownSide();
            Thread.sleep(1000);
            haveCloudServiceCardLabel().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify a small window should open, and allow to enter 18 digit valid service code")
    public void verifySmallWindowToAllowEnter18Digit() throws Exception {
        log.info("Verify a small window should open, and allow to enter 18 digit valid service code");
        if(app.isAndroid()) {
            Assert.assertTrue(enter18DigitLabel().isElementPresent(15), "Label is not displayed");
            Assert.assertTrue(serviceCodeField().isElementPresent(15), "Service code field is not displayed");
        }
    }

    @Step("Enter invalid code")
    public void enterInvalidCode() throws Exception {
        log.info("Enter invalid code");
        if(app.isAndroid()) {
            haveCloudServiceCardLabel().scrollToElementDownSide();
            serviceCodeField().sendKeys(RandomStringUtils.random(18));
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Click OK button")
    public void clickOkButton() throws Exception {
        log.info("Click OK button");
        if(app.isAndroid()) {
            okBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify it should not apply service code and should not allow to buy plan accordingly")
    public void verifyCodeShouldNotBeApply() throws Exception {
        log.info("Verify it should not apply service code and should not allow to buy plan accordingly");
        if(app.isAndroid()) {
            haveCloudServiceCardLabel().scrollToElementDownSide();
            serviceCodeField().sendKeys(RandomStringUtils.randomAlphanumeric(18));
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Scroll down and click on Terms of use & Privacy policy link")
    public void scrolDownAndClickTermsAndPolicy() throws Exception {
        log.info("Scroll down and click on Terms of use & Privacy policy link");
        if(app.isAndroid()) {
            termsAndPrivacyPolicy().scrollToElementDownSide();
            termsAndPrivacyPolicy().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify it should open term of use and privacy policy page")
    public void verifyTermOfUserAndPrivacyIsOpened() throws Exception {
        log.info("Verify it should open term of use and privacy policy page");
        if(app.isAndroid()) {
            Assert.assertTrue(termsAndPrivacyPolicy().isElementPresent(15), "T&C is not displayed");
        }
    }

    @Step("Purchase addition plan")
    public void purchaseAdditionalPlan() throws Exception {
        log.info("Purchase additional plan");
        if(app.isAndroid()) {
            purchaseAdditionPlanBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify Continuous renewal of service agreements link should visible and clickable")
    public void verifyPrivacyPageIsDisplayed() throws Exception {
        log.info("Verify Continuous renewal of service agreements link should visible and clickable");
        if(app.isAndroid()) {
            Assert.assertTrue(privacyPolicy().isElementPresent(15), "Privacy is not displayed");
        }
    }

    @Step("Click Continuous renewal of service agreements link")
    public void clickContinuousRenewalServiceAgreement() throws Exception {
        log.info("Click Continuous renewal of service agreements link");
        if(app.isAndroid()) {
            privacyPolicy().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Scroll down CRV")
    public void scrollDownWhatIsCRV() throws Exception {
        log.info("Scroll down to CRV question");
        if(app.isAndroid()) {
            whatIsCRV().scrollToElementDownSide();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify CRV question is clickable")
    public void verifyCrvQuestionIsClickable() throws Exception {
        log.info("Verify CRV question is clickable");
        if(app.isAndroid()) {
            Assert.assertTrue(whatIsCRV().isElementPresent(15));
        }
    }
    
    @Step("Verify CRV PopUp")
    public void verifyCVRPopUp() throws Exception {
        log.info("Verify CRV PopUp");
        if(app.isAndroid()) {
        	termsAndPrivacyPolicy().scrollToElementDownSide();
        	whatIsCRV().safeClick();
            Assert.assertTrue(CVRpopup().isElementPresent(15), "CVR PopUp not displayed");
            okBtn().click();
            Assert.assertTrue(CVRtext().isElementPresent(15), "CVR text not displayed");
        }
    }
    
}
