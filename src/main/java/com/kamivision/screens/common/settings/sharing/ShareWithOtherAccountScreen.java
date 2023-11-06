package com.kamivision.screens.common.settings.sharing;

import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class ShareWithOtherAccountScreen  {
    private final UIHelper app;
    public ShareWithOtherAccountScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("share_YIAccount")+"']"),By.xpath("//XCUIElementTypeNavigationBar[@name=\""+app.lang.getProperty("CameraAccountShare_1484535623_33")+"\"]"));}
    public UIHelper accountTextBox() throws Exception{ return app.setBy(By.xpath("//android.widget.EditText[contains(@resource-id, 'actvShareAccount')]"),By.xpath("//XCUIElementTypeButton[@name='yh share bottom arrow']/../XCUIElementTypeTextField"));}
    public UIHelper okButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnOk')]"),By.xpath("(//XCUIElementTypeButton[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"'])[2]"));}
    public UIHelper shareButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnShare')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"']"));}
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"),By.xpath("//XCUIElementTypeButton[@name='yh ic nav back']"));}
    public UIHelper sharedAccountMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text,'"+app.lang.getProperty("share_hint_accountExisted")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("share_hint_existed")+"']"));}
    public UIHelper okDuplicateShareButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnAntsDialogRight')]"),By.xpath("(//XCUIElementTypeButton[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"'])[2]"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}

    @Step("Enter email into share account textBox {0}")
    public void shareToAccount(String account) throws Exception {
        log.info("Enter email into share account textBox "+account);
        accountTextBox().sendKeys(account);
        shareButton().click();
        app.waitForAnimationEffectInSeconds(5);
        if(app.isIOSAndPerfectoExecution() && false) {
            //app.perfectoClickImage("");
            app.perfectoClickButton(app.lang.getProperty("ConnectBase_1441676159_41"));
        }else{
            okButton().click();
        }
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Navigated back to Home Screen")
    public void navigateBack(int times) throws Exception {
        log.info("Navigated back to Home Screen");
        if(app.isIOS()){
            for (int i = 0; i < times; i++) {
                Thread.sleep(2000);
                rotateLoadingIcon().waitForDisappear();
                backButton().click();

            }
        }else {
            for (int i = 0; i < times; i++) {
                Thread.sleep(1500);
                app.navigateBack();
            }
        }
    }

    @Step("Verify share device page displayed")
    public void verifyShareWithOtherAccountPageDisplayed() throws Exception {
        log.info("Verify share device page displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5),
                "Share With other account page not displayed");
    }

    @Step("Verify shared account message displayed")
    public void verifySharedAccountMessageForAnExistingCameraDisplayed() throws Exception {
        log.info("Verify shared account message displayed");
        Assert.assertTrue(sharedAccountMessage().isElementPresent(5),
                "Shared account message not displayed");
    }

    @Step("Click OK button")
    public void clickOkButton() throws Exception {
        log.info("Click OK button");
        okDuplicateShareButton().click();
    }
}
