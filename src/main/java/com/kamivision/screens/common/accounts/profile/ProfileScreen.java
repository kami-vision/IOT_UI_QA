package com.kamivision.screens.common.accounts.profile;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class ProfileScreen  {
    private final UIHelper app;
    public ProfileScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("user_detail")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("system_tab_profile")+"']"));}
    public UIHelper accountMenu() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'ll_account')]"),By.xpath("//XCUIElementTypeCell/*[contains(@name,'"+app.lang.getProperty("account_myAccountSetting_title")+"')]"));}
    public UIHelper changePasswordMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llChangePassWord')]"),By.xpath("//*[contains(@name,'"+app.lang.getProperty("ChangePassword_1448448251_1")+"')]"));}


    @Step("Verify Profile page is displayed")
    public void verifyProfilePageDisplayed() throws Exception {
        log.info("Verify Profile page is displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5),
                "Verify Profile page is not displayed");
    }

    @Step("Click on Account menu")
    public void clickOnAccountMenu() throws Exception {
        log.info("Click on Account menu");
        if(app.isIOS()){
            app.scroll(UIHelper.ScrollDirection.DOWN);
            app.scroll(UIHelper.ScrollDirection.DOWN);
        }
        accountMenu().click();
    }

    @Step("Click on Change password menu")
    public void clickOnChangePasswordMenu() throws Exception {
        log.info("Click on Change password menu");
        changePasswordMenu().click();
    }
}
