package com.kamivision.screens.common;


import com.kamivision.screens.common.accounts.profile.ProfileScreen;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class AccountScreen  {
    private final UIHelper app;
    public AccountScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper accountSettingPageTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tv_account')]"),By.xpath("//XCUIElementTypeStaticText[@name=\""+app.lang.getProperty("account_discover_accountSettings")+"\"]"));}

    public UIHelper storeMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("system_tab_store")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("system_tab_store")+"']"));}
    public UIHelper settingsMenu() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'ll_account')]"),By.xpath("//*[@name='"+app.lang.getProperty("system_settings")+"']"));}
    public UIHelper appsettingsMenu() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tv_content') and @text='"+app.lang.getProperty("account_appSettingsPage_title")+"']"),By.xpath("ios"));}
	public UIHelper notificationsMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("profile_notification")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("profile_notification")+"']"));}
    public UIHelper profileIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivUserIcon')]"),By.xpath("//XCUIElementTypeButton[@name='yh use head default']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper storePageTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'barTitle')]//android.widget.TextView[@text='"+app.lang.getProperty("system_tab_store")+"']"),By.xpath("ios"));}
    public UIHelper homeAwayMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("profile_account_home")+"']"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("account_homeAwaySettingsPage_title")+"']"));}
    public UIHelper chatbotIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'mainRelative')]/following-sibling::*"),By.xpath("//*[@name='discover']"));}
    public UIHelper albumMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='"+app.lang.getProperty("account_album")+"']"),null);}
    public UIHelper viewAlbumDropDown() throws Exception{return app.setBy(By.xpath("//*[contains(@resource-id,'sp_title')]"),null);}
    public UIHelper viewDownloadedVideo() throws Exception{return app.setBy(By.xpath("//*[contains(@resource-id,'text_view_spinner')]"),null);}
    public UIHelper countDownloadedVideo() throws Exception{return app.setBy(By.xpath("//*[contains(@resource-id,'ivImage')]"),null);}
    public UIHelper HelpAndResourcesMenu() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("help_and_resources")+"']"),By.xpath("//*[@label='"+app.lang.getProperty("help_and_resources")+"']"));}
    public UIHelper PurchaseNewDevices() throws Exception{ return app.setBy(By.xpath("//*[@text='"+app.lang.getProperty("purchase_new_devices")+"']"),By.xpath("//*[@label='"+app.lang.getProperty("purchase_new_devices")+"']"));}
    
    @Step("Verify Account Screen is Displayed")
    public void verifyAccountScreenDisplayed() throws Exception {
        log.info("Verify Account Screen is Displayed");

        if(app.isAndroid()) {
         String pageTitle = accountSettingPageTitle().getText();
        Assert.assertTrue(pageTitle.contains(app.lang.getProperty("account_setting")), "Account page is missing as actual page title is: " + pageTitle);
        }else{
            //Assert.assertTrue(accountSettingPageTitle().isElementPresent(5), "Account page is missing");
        }
    }

    @Step("Click on Store Menu")
    public void clickOnStoreMenu() throws Exception {
        log.info("Click on Store Menu");
        if(app.isIOS()){
            app.scroll(UIHelper.ScrollDirection.DOWN);
            app.scroll(UIHelper.ScrollDirection.DOWN);
        }else {
            storeMenu().scrollToElementDownSide();
        }
        storeMenu().click();
    }

    @Step("Click on Setting Menu")
    public void clickOnSettingMenu() throws Exception {
        log.info("Click on Setting Menu");
        if(app.isIOS()){
            rotateLoadingIcon().waitForDisappear();
            new ProfileScreen(app).clickOnAccountMenu();
        }else {
            rotateLoadingIcon().waitForDisappear();
            settingsMenu().scroll(UIHelper.ScrollDirection.DOWN);
            settingsMenu().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }
    
    @Step("Click on App Setting Menu")
    public void clickOnAppSettingMenu() throws Exception {
        log.info("Click on App Setting Menu");
        rotateLoadingIcon().waitForDisappear();
        appsettingsMenu().scroll(UIHelper.ScrollDirection.DOWN);
        appsettingsMenu().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on Notifications Menu")
    public void clickOnNotificationMenu() throws Exception {
        log.info("Click on Notifications Menu");
        notificationsMenu().scrollSlowly(UIHelper.ScrollDirection.DOWN);
        notificationsMenu().click();
    }

    @Step("Click on Profile Icon")
    public void clickOnProfileIcon() throws Exception {
        log.info("Click on Profile Icon");
        profileIcon().click();
    }

    @Step("Verify Home/Away menu is Displayed")
    public void verifyHomeAwayMenuDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Home Away Menu menu is displayed");
        Assert.assertTrue(homeAwayMenu().isElementPresent(5), "Home Away menu list is missing");
    }

    @Step("Verify chatbot displayed")
    public void verifyChatbotDisplayed() throws Exception {
        log.info("Verifying chatbot is displayed");
        Assert.assertTrue(chatbotIcon().isElementPresent(5),  "Chatbot is not displayed");

    }
    
	@Step("Click on Album Menu")
	public void clickOnAlbumMenu() throws Exception {
		log.info("Click on Album Menu");
		albumMenu().scrollToElementDownSide();
		albumMenu().click();
	}
	
	@Step("Select Downloaded Videos option on Album screen")
	public void selectDownloadedVideos() throws Exception {
		log.info("select  Downloaded Videos option from dropdown list");
		viewAlbumDropDown().waitForElementToAppear();
		viewAlbumDropDown().click();
		log.info("click on downloaded video option");
		viewDownloadedVideo().waitForElementToAppear();
		viewDownloadedVideo().click();
	}
	
	@Step("verify recording is availabe")
	public void verifyRecordingAvailable() throws Exception {
		int final_count = countDownloadedVideo().getAll().size();
		Assert.assertTrue(final_count > 0, "video recording not availble");
	}

	@Step("Click on Help & Resources")
    public void clickHelpAndResources() throws Exception {
        log.info("Click on Help & Resources");
        HelpAndResourcesMenu().scrollToElementDownSide();
        HelpAndResourcesMenu().click();
    }

    @Step("Click on Purchase New Devices")
    public void clickPurchaseNewDevices() throws Exception {
        log.info("Click on Purchase New Devices");
        PurchaseNewDevices().scrollToElementDownSide();
        PurchaseNewDevices().click();
    }
	


}
