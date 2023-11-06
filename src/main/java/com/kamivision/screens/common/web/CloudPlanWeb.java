package com.kamivision.screens.common.web;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.UIHelper;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class CloudPlanWeb {
    private final UIHelper app;
    String planValue;

    public CloudPlanWeb(UIHelper app) {
        this.app=app;
    }

    public UIHelper yearlyOption() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("yearlyOption").trim()+"')]"));}
    public UIHelper monthlyOption() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("monthlyOption").trim()+"')]"));}
    public UIHelper entryPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("entryPlanValue").trim()+"')]"));}
    public UIHelper standradPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("standradPlanValue").trim()+"')]"));}
    public UIHelper plusPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("plusPlanValue").trim()+"')]"));}
    public UIHelper yearlyPlanPrice() throws Exception{ return app.setBy(By.xpath("//*[@id='app']//h6[1]"));}
    public UIHelper yearlyPlanNumOfCamera() throws Exception{ return app.setBy(By.xpath("//*[@id='app']//ul//li[@class='li-single-cameras']"));}
    public UIHelper yearlyPlanDaysHistory() throws Exception{ return app.setBy(By.xpath("//*[@id='app']//ul//li[@class='li-duration']"));}
    public UIHelper buyBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("buyButton").trim()+"')]"));}
    public UIHelper CVRoption() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("cvrOptionValue").trim()+"')]"));}
    public UIHelper serviceGiftCard() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("serviceGiftCard").trim()+"')]"));}
    public UIHelper reedemBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("redeemOption").trim()+"')]"));}
    public UIHelper copyRight() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("copyRightOption").trim()+"')]"));}
    public UIHelper TnC() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("privacyPolicyOption").trim()+"')]"));}
    public UIHelper MAR() throws Exception{ return app.setBy(By.xpath("//a[contains(text(),'"+app.lang.getProperty("motionRecordingPlanOption").trim()+"')]"));}
    public UIHelper buyEntryPlan() throws Exception{ return app.setBy(By.xpath("//*[@class='card mb-5 mb-lg-0 plan-card']//h5[contains(text(),'ENTRY')]/parent::div/following-sibling::*[contains(text(),'Buy')]"));}
    public UIHelper buyStandardPlan() throws Exception{ return app.setBy(By.xpath("//*[@class='card mb-5 mb-lg-0 plan-card']//h5[contains(text(),'STANDARD')]/parent::div/following-sibling::*[contains(text(),'Buy')]"));}
    public UIHelper buyPlusPlan() throws Exception{ return app.setBy(By.xpath("//*[@class='card mb-5 mb-lg-0 plan-card']//h5[contains(text(),'PLUS')]/parent::div/following-sibling::*[contains(text(),'Buy')]"));}
    public UIHelper purchaseAdditionalPlanDialog() throws Exception{ return app.setBy(By.xpath("//*[(@role='dialog')]"));}
    public UIHelper purchaseAdditionalPlanClick() throws Exception{ return app.setBy(By.xpath("//*[(@role='dialog')]//span[contains(text(),'Purchase Additional Plan')]"));}
    public UIHelper checkoutHeader() throws Exception{ return app.setBy(By.xpath("//h1[contains(text(),'Checkout')]"));}
    public UIHelper checkoutPriceValue() throws Exception{ return app.setBy(By.xpath("//h2[starts-with(@class,'card-price')]//span[1]"));}
    public UIHelper addCreditCard() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("addCard").trim()+"')]"));}
    public UIHelper cardUsername() throws Exception{ return app.setBy(By.xpath("//input[@name='username']"));}
    public UIHelper cardNumber() throws Exception{ return app.setBy(By.xpath("//*[@id='card-number']"));}
    public UIHelper cardExpiry() throws Exception{ return app.setBy(By.xpath("//*[@id='card-expiry']"));}
    public UIHelper cardCVC() throws Exception{ return app.setBy(By.xpath("//*[@id='card-cvc']"));}
    public UIHelper cardAddress() throws Exception{ return app.setBy(By.xpath("//*[@placeholder='Address']"));}
    public UIHelper cardCity() throws Exception{ return app.setBy(By.xpath("//*[@placeholder='City']"));}
    public UIHelper cardState() throws Exception{ return app.setBy(By.xpath("//*[@placeholder='State']"));}
    public UIHelper cardZIP() throws Exception{ return app.setBy(By.xpath("//*[@placeholder='Zip ']"));}
    public UIHelper saveCard() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("saveCard").trim()+"')]"));}
    public UIHelper savedCreditCard() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("savedCards").trim()+"')]"));}
    public UIHelper selectSavedCard() throws Exception{ return app.setBy(By.xpath("//input[@id='checkbox0']"));}
    public UIHelper payButton() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("payClick").trim()+"')]"));}
    public UIHelper paySuccess() throws Exception{ return app.setBy(By.xpath("//*[contains(text(),'"+app.lang.getProperty("paySuccess").trim()+"')]"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[starts-with(@class, 'spinner-container container')]"));}

    @Step("Verify Yearly Cloud plans are listed")
    public void verifyYearlyCloudPlans() throws Exception {
        log.info("Verify YCloud plans");
        Assert.assertTrue(yearlyOption().isElementPresent(15), "yearlyOption is not displayed");
        Assert.assertTrue(entryPlan().isElementPresent(15), "entryPlan is not displayed");
        Assert.assertTrue(standradPlan().isElementPresent(15), "standradPlan is not displayed");
        Assert.assertTrue(plusPlan().isElementPresent(15), "plusPlan is not displayed");
        verifyYearlyPlanAmountVerify(); //* verify yearly price values *//
        verifyPlanBenefitsCheck(); //* verify all plan benefits *//
        buyBtn().webScroll();
        Assert.assertTrue(buyBtn().isElementPresent(15), "buy button is not displayed");
        Assert.assertTrue(buyBtn().getAll().size() == 3, "All 3 Yearly cloud plans are not listed ");
    }

    @Step("Verify plan Benefits- Number of Cameras supported & Plan days History ")
    public void verifyPlanBenefitsCheck() throws Exception {
        verifySupportedCameraCheck(); //private method
        verifySupportedDaysHistoryCheck(); //private method
    }

    @Step("Verify plan Benefits- Plan days History ")
    private void verifySupportedDaysHistoryCheck() throws Exception {
        String[] expectedSupportDayHistory = {"7 days history", "15 days history", "30 days history"};
        WebElement numCam = yearlyPlanDaysHistory().getElement();
        numCam.click();
        int len=yearlyPlanDaysHistory().getAll().size(); //* get list of plan cards *//
        String[] actualNum = new String[len];
        for (int i=0;i<len;i++)
        {
            actualNum[i]=yearlyPlanDaysHistory().getAll().get(i).getText();
        }
        List<String> expectedHistory = Arrays.asList(expectedSupportDayHistory);
        List<String> actualHistory = Arrays.asList(actualNum);
        Assert.assertTrue((expectedHistory.containsAll(actualHistory)) , "Yearly plan supported days of history are not matched"); ;
        log.info("Yearly plan supported days of history are matched");
    }

    @Step("Verify plan Benefits- Supported number of cameras ")
    private void verifySupportedCameraCheck() throws Exception {
        String[] expectedSupportCameras = {"1 camera", "5 cameras", "5 cameras"};
        WebElement numCam = yearlyPlanNumOfCamera().getElement();
        numCam.click();
        int len=yearlyPlanNumOfCamera().getAll().size(); //* get list of plan cards *//
        String[] actualNumCam = new String[len];
        for (int i=0;i<len;i++)
        {
            actualNumCam[i]=yearlyPlanNumOfCamera().getAll().get(i).getText();
        }
        List<String> expectedCameras = Arrays.asList(expectedSupportCameras);
        List<String> actualCameras = Arrays.asList(actualNumCam);
        Assert.assertTrue((expectedCameras.containsAll(actualCameras)) , "Yearly plan supported number of cameras are not matched"); ;
        log.info("Yearly plan supported number of cameras are matched");
    }

    @Step("Verify Yearly plan price")
    public void verifyYearlyPlanAmountVerify() throws Exception {
        String[] actualPlanPrice = getActualPriceValues();
        String[] expectedPlanPrice =  getExpectedPriceValues();

        List<String> expectedPlanPriceVal = Arrays.asList(expectedPlanPrice);
        List<String> actualPlanPriceVal = Arrays.asList(actualPlanPrice);

        Assert.assertTrue((expectedPlanPriceVal.containsAll(actualPlanPriceVal)) , "Yearly plan price values are not matched"); ;
        log.info("Yearly plan price values are  matched");

    }

    private String[] getExpectedPriceValues() {
        String[] expectedPlanPrice = {"$2.50 /Month", "$6.67 /Month", "$10.83 /Month"};
        return expectedPlanPrice;
    }

    private String[] getActualPriceValues() throws Exception {
        WebElement yearlyPrice = yearlyPlanPrice().getElement();
        yearlyPrice.click();
        int len=yearlyPlanPrice().getAll().size(); //* get list of plan cards *//
        String[] actualPlanPrice = new String[len];
        for (int i=0;i<len;i++)
        {
            actualPlanPrice[i]=yearlyPlanPrice().getAll().get(i).getText();
        }
        return actualPlanPrice;
    }

    @Step("Verify CVR option")
    public void verifyCVR() throws Exception {
        log.info("Verify CVR option");
        CVRoption().webScroll();
        Assert.assertTrue(CVRoption().isElementPresent(15), "CVRoption is not displayed");
        Assert.assertTrue(serviceGiftCard().isElementPresent(15), "serviceGiftCard option is not displayed");
        Assert.assertTrue(reedemBtn().isElementPresent(15), "reedem here button is not displayed");
    }

    @Step("Verify Terms & Conditions")
    public void verifyFooter() throws Exception {
        log.info("Verify Terms & Conditions");
        copyRight().webScroll();
        Assert.assertTrue(copyRight().isElementPresent(15), "CopyRight is not displayed");
        Assert.assertTrue(TnC().isElementPresent(15), "Terms & Conditions not displayed");
    }

    @Step("Click CVR option")
    public void clickCVROption() throws Exception {
        log.info("Scroll down & click CVR option");
        CVRoption().webScroll();
        CVRoption().jsclick();
        log.info("Verify monthly & yearly Option");
        monthlyOption().webScroll();
        Assert.assertTrue(yearlyOption().isElementPresent(15), "yearlyOption is not displayed");
        Assert.assertTrue(monthlyOption().isElementPresent(15), "monthlyOption is not displayed");
        monthlyOption().jsclick();
        buyBtn().webScroll();
        Assert.assertTrue(buyBtn().isElementPresent(15), "buy button is not displayed");
    }

    @Step("Verify Motion Active Recording")
    public void verifyMAR() throws Exception {
        log.info("Verify Motion Active Recording option");
        MAR().webScroll();
        Assert.assertTrue(MAR().isElementPresent(15), "Motion Active Recording is not displayed");
        log.info("Scroll down & click Motion Active Recording option");
        MAR().jsclick();
        CVRoption().webScroll();
        Assert.assertTrue(CVRoption().isElementPresent(15), "CVRoption is not displayed");
    }

    @Step("Verify Yearly Cloud plan purchase flow")
    public void verifyYearlPlanPurchase() throws Exception {
        clickYearlyOption();
        rotateLoadingIcon().waitForDisappear();
        selectRandomPlanToPurchase();
    }

    @Step("Select any random plan - Entry ,Standard, CVR. Plus")
    private void selectRandomPlanToPurchase() throws Exception {
        int planChoice=getRandomNum(1,4);
        planChoice=1;
        if(planChoice==1)
        {
            String[] actualPlanPrice = getActualPriceValues();
            log.info("Purchasing Entry Plan");
            buyEntryPlan().click();
            rotateLoadingIcon().waitForDisappear();
            List<String> actualPlanPriceVa = Arrays.asList(actualPlanPrice);
            log.info("buy Entry Plan of price "+actualPlanPriceVa.get(0));
            verifyPurchaseAdditionalPlan();
            verifyCheckoutScreen();
            verifyAddCard();
            clickPayPlan();
            verifyPaymentSuccess();
        }
        else if(planChoice==2){
            log.info("Purchasing Standard Plan");
            buyStandardPlan().click();
        }
        else if(planChoice==3){
            log.info("Purchasing Plus Plan");
            buyPlusPlan().click();
        }
        else if(planChoice==4){
            log.info("Purchasing CVR Plan");
        }
        else{
            log.info("Wrong choice");
        }
    }

    @Step("To verify payment successful")
    private void verifyPaymentSuccess() throws Exception {
        log.info("Verify is payment is successful");
        Assert.assertTrue(paySuccess().isElementPresent(15), "Payment successful is not displayed");
        log.info("payment is successful");
    }

    @Step("To click on payButton")
    private void clickPayPlan() throws Exception {
        payButton().click();
        rotateLoadingIcon().waitForDisappear();
        log.info("Pay button is clicked");
    }

    @Step("To Add credit card")
    private void verifyAddCard() throws Exception {
        if(savedCreditCard().isElementPresent())
        {
            log.info("User is already have saved card");
            selectSavedCard().click();
            rotateLoadingIcon().waitForDisappear();
        }
        else
        { //Need to refactor below block of code //
            log.info("User needs to add new card");
            Thread.sleep(1000);
            addCreditCard().click();
            log.info("User will enter card details");
            cardUsername().sendKeys("Test User");
            cardNumber().sendKeys("4242");
            cardExpiry().sendKeys("02/22");
            cardCVC().sendKeys("111");
            cardAddress().sendKeys("Boston");
            cardCity().sendKeys("Boston");
            cardState().sendKeys("Boston");
            cardZIP().sendKeys("02111");
            saveCard().click();
        }
    }

    @Step("Verify plan purchase checkout screen")
    private void verifyCheckoutScreen() throws Exception {
        Assert.assertTrue(checkoutHeader().isElementPresent(15), "Checkout screen is not displayed");
    }

    @Step("Verify if user wants to purchase additional plan")
    private void verifyPurchaseAdditionalPlan() throws Exception {
        if(purchaseAdditionalPlanDialog().isElementPresent())
        {
            log.info("User wants to purchase additional plan");
            purchaseAdditionalPlanClick().click();
        }
        else
        {
            log.info("User is not having any existing purchased plan");
        }
    }

    @Step("Click Yearly option")
    private void clickYearlyOption() throws Exception {
        log.info( "click Yearly option");
        yearlyOption().click();
    }

    @Step("Click Monthly option")
    private void clickMonthlyOption() throws Exception {
        log.info( "click Monthly option");
        monthlyOption().click();
    }

    @Step("to get any random value method")
    public int getRandomNum(int mn, int mx) {
        int p = 0;
        int i;
        for (i = 0; i < 1; i++) {
            int min = mn;
            int max = mx;
            p = ((int) (Math.random() * (max - min + 1)) + min);
        }
        return p;
    }

    @Step("Verify Monthly Cloud plan purchase flow")
    public void verifyMonthlyPlanPurchase() throws Exception {
        clickMonthlyOption();
        rotateLoadingIcon().waitForDisappear();
        selectRandomPlanToPurchase();
    }
}