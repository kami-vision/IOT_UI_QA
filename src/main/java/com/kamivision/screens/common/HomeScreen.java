package com.kamivision.screens.common;

import com.kamivision.screens.common.accounts.profile.ProfileScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.UIHelper;
import utilities.UIHelper.ScrollDirection;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

import java.time.Duration;

@Log4j2
public class HomeScreen  {
    private final UIHelper app;
    public HomeScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper addDeviceButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'ivAddCameraWhite')]"),By.xpath("//XCUIElementTypeButton[@name='home addDevice']"));}
    public UIHelper pairCameraButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tv_confirm')]"),By.xpath("//XCUIElementTypeButton[@label='Pair A Camera']"));}
    public UIHelper qrCodeScanButton() throws Exception{ return app.setBy(By.id("ivCameraTypeQrcode"),By.xpath("ios"));}
    public UIHelper skipTutorial() throws Exception{ return app.setBy(By.id("camera_list_bg_iv"),By.xpath("ios"));}
    public UIHelper myTab() throws Exception{ return app.setBy(By.id("rbMyTab"),By.xpath("ios"));}
    public UIHelper openAddedCamera() throws Exception{ return app.setBy(By.id("ivCover"),By.xpath("ios"));}
    public UIHelper navigationPanel() throws Exception{ return app.setBy(By.id("mDirctionCtrlView"),By.xpath("ios"));}
    public UIHelper recordVideoButton() throws Exception{ return app.setBy(By.id("btnRecord"),By.xpath("ios"));}
    public UIHelper stopVideoButton() throws Exception{ return app.setBy(By.id("btnRecord"),By.xpath("ios"));}
    public UIHelper viewAlbum() throws Exception{ return app.setBy(By.id("btnEnterAlbum"),By.xpath("ios"));}

    public UIHelper userTips() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'llUserTips')]"),By.xpath("ios"));}
    public UIHelper cameraAlertTab() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[@text='"+app.lang.getProperty("camera_playback_android")+"']"),By.xpath("//*[@name='"+app.lang.getProperty("camera_playback")+"']"));}
    public UIHelper accountTab() throws Exception{
        return app.setBy(
                By.xpath("//*[contains(@resource-id, 'MyTab') or contains(@text,'"+app.lang.getProperty("system_tab_discover")+"')]"),
                By.xpath("//XCUIElementTypeTabBar//*[@name='"+app.lang.getProperty("system_tab_discover")+"']"));}
    public UIHelper homeTab() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[contains(@resource-id, 'rbCameraTab')]"),By.xpath("//XCUIElementTypeTabBar//*[@name='"+app.lang.getProperty("system_tab_main")+"']"));}
    public UIHelper homePageWelcomeTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@text, '"+app.lang.getProperty("title_welcome_app_home")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("title_welcome_app_home")+"']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper settingCameraIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[@text='"+app.lang.getProperty("cameraNavigation_settings_label")+"']"), By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("PrivacyCamera_1441676159_146")+"']"));}
    public UIHelper guideImageIcon() throws Exception{ return app.setBy(By.id("guide_image"), By.xpath("//XCUIElementTypeAlert//XCUIElementTypeButton[contains(@name,\""+app.lang.getProperty("system_got")+"\")]"));}
    public UIHelper cameraProgressLayout() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'rlCameraProgressLayout')]"),By.xpath("//XCUIElementTypeScrollView"));}
    public UIHelper YiLifeWarningMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'iv_close')]"),By.xpath("ios"));}
    public UIHelper confirmButton() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvConfirm')]"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("manageCloud_confirm_button")+"']"));}
    public UIHelper homeMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text= '"+app.lang.getProperty("system_homeMode")+"']"),By.xpath("(//XCUIElementTypeButton[@name='bt home switchbg n'])[1]"));}
    public UIHelper awayMenu() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'rlArmed')]"),By.xpath("//XCUIElementTypeTable/XCUIElementTypeButton[2]"));}
    public UIHelper homeSwitchingConfirmText() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("others_alarmMode_disarm_Hint")+"')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("others_alarmMode_disarm_Hint")+"']"));}
    public UIHelper localNetworkConnectionAllowButton() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("system_confirm")+"')]"),By.xpath("//*[@name='"+app.lang.getProperty("ConnectBase_1441676159_41")+"']"));}
    public UIHelper windowIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivMutiPlayer')]"),By.xpath("//*[@label='home multi live icon']"));}
    public UIHelper cloudTab() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[contains(@resource-id, 'rbCloudTab')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("camera_playerTag_cloud")+"']"));}
    public UIHelper deleteButton() throws Exception{ return app.setBy(By.xpath(""),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("CameraList_1467687112_3")+"']"));}
    public UIHelper getCamera(String cameraName) throws Exception{
        return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvName') and @text = '"+cameraName+"']"),By.xpath("//*[contains(@name,'"+cameraName+"')]"));
    }
    public UIHelper cameraLiveViewPercentage() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//*[contains(@name,'%')]"));}
    public UIHelper cloudSuggestionGotIt() throws Exception{return app.setBy(By.id("btnAntsDialogRight"),By.xpath("ios"));};
    public UIHelper chatbotIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'mainRelative')]/following-sibling::*"),By.xpath("//*[@name='home']"));}
    private UIHelper hideChatbotButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvHide')]"),By.xpath("//XCUIElementTypeButton[@name='chatbot hide']"));}
    private UIHelper neverMindButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvNeverMind')]"),By.xpath("//XCUIElementTypeButton[@name='Nevermind']"));}
    private UIHelper hideChatbotPopUp() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'tvNote')]"),By.xpath("//XCUIElementTypeStaticText[@name='You can always re-enable it under  Account > Settings > Show Chatbot']"));}
    public UIHelper timeLineLoader() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeActivityIndicator"));}
    public UIHelper switchToAwayModeButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("home_switchToAwayMode_button")+"']"));}
    public UIHelper switchToHomeModeButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='"+app.lang.getProperty("home_switchToHomeMode_button")+"']"));}
    public UIHelper settingIcon(String cameraName) throws Exception{
        return app.setBy(By.xpath("//android.widget.TextView[@text='"+cameraName
                +"']/following-sibling::*/android.widget.ImageView[contains(@resource-id, 'ivCameraSetting')]"),By.xpath("ios"));
    }
    public UIHelper activityTab() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[contains(@text,'"+app.lang.getProperty("camera_playback_android")+"')]"),By.xpath("//*[starts-with(@name,'"+app.lang.getProperty("camera_playback")+"')]"));}
    public UIHelper alertIcon(String cameraName) throws Exception{
        return app.setBy(By.xpath("//android.widget.TextView[@text='"+cameraName+"']/following-sibling::*/android.widget.ImageView[contains(@resource-id, 'ivCameraAlerts')]"),By.xpath("ios"));
    }

    public UIHelper tryCloudCloseButton() throws Exception{ return app.setBy(By.xpath("//*[@resource-id='com.ants360.yicamera.international:id/iv_close']"),By.xpath("//*[@label='yh btn close']"));}
    public UIHelper detectionPopup() throws Exception{ return app.setBy(By.xpath("//*[@text='Person, animal, and vehicle detection were added to this camera.']"),By.xpath("ios"));}
    public UIHelper detectionPopupClose() throws Exception{ return app.setBy(By.xpath("//*[@text='Close']"),By.xpath("ios"));}

    @Step("Wait and Close User Tips Twice")
    public void waitAndCloseUserTipsTwice() throws Exception {
        log.info("Wait and Close User Tips Twice");
        if(app.isAndroid()){
            closeKamiCloudPoupIfVisible();
            userTips().click();
            userTips().click();
        }else {
            app.iosAfterLoginChecks();
            closeKamiCloudPoupIfVisible();

        }
    }

    @Step("Click on Account Tab")
    public void clickOnAccountTab() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Account Tab");
        accountTab().click();
        Thread.sleep(3000);
    }

    @Step("Verify Home screen displayed")
    public void verifyHomeScreenDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Home screen displayed");
        Assert.assertTrue(homePageWelcomeTitle().isElementPresent(20),  "Home page is not displayed");
    }

    @Step("Click on Camera {0}")
    public void clickOnCamera(String cameraName) throws Exception {
        log.info("Click on Camera "+cameraName);
        if(app.isIOS()) {
            if(app.setBy(By.xpath(""),By.xpath("//*[@name='home bt play']")).isElementPresent()) {
                app.relaunchApp();
                Thread.sleep(5000);
            }
            if(app.setBy(By.xpath(""),By.xpath("//*[@name='home bt play']")).isElementPresent()) {
                app.relaunchApp();
                Thread.sleep(5000);
            }
            int noOfTriesToFindCamera=5;
            if(app.isIOSAndPerfectoExecution() && !getCamera(cameraName).isElementPresent()){
                log.info("trying to find camera with perfecto commands");
                while(noOfTriesToFindCamera>0){
                    try {
                        app.perfectoClickButton(cameraName);
                        break;
                    }catch (Exception e){
                        app.scroll(UIHelper.ScrollDirection.DOWN);
                    }
                    noOfTriesToFindCamera--;
                }

            }else {
                int expectedScrolls=noOfTriesToFindCamera;
                int expectedYLocation = app.setBy(By.xpath(""), By.xpath("//XCUIElementTypeTabBar")).getElement().getLocation().getY();
                while (noOfTriesToFindCamera > 0) {
                    try {
                        while(app.getDriver().findElement(By.xpath("//*[starts-with(@name,'"+cameraName+"')]")).getLocation().getY() > expectedYLocation && noOfTriesToFindCamera > 0){
                            app.scroll(UIHelper.ScrollDirection.DOWN);
                            noOfTriesToFindCamera--;
                        }
                        break;
                    }catch (Exception e){
                        noOfTriesToFindCamera--;
                        accountTab().click();
                        homeTab().click();
                        Thread.sleep(5000);
                        for(int i=(expectedScrolls-noOfTriesToFindCamera);i>0;i--)
                            app.scroll(UIHelper.ScrollDirection.DOWN);
                    }
                }
                //app.scrollSlowly(UIHelper.ScrollDirection.DOWN);
                Dimension size =app.getDriver().manage().window().getSize();
                app.swipeByCordinates((int)(size.width*.5),(int)(size.height*.75),(int)(size.width*.5),(int)(size.height*.70));
                getCamera(cameraName).tapios();
            }
            }
        if(app.isIOS()) {
            if( new CameraScreen(app).activityTab().isElementPresent(2)) {
                new CameraScreen(app).activityTab().tapios();
                    if(guideImageIcon().isElementPresent()){
                        guideImageIcon().click();
                        if(guideImageIcon().isElementPresent())
                        guideImageIcon().click();
                    }
                cameraLiveViewPercentage().waitForDisappear();
                //Thread.sleep(5000);
                timeLineLoader().waitForDisappear();
            }
        }
        if(app.isAndroid()) {
            getCamera(cameraName).click();
            rotateLoadingIcon().waitForDisappear();
            if (!cameraName.equalsIgnoreCase("kami-Mini-offline")) {
                log.info("Wait for 20s before accepting the user tips");
                Thread.sleep(20000);
                log.info("Tap to accept user tips");
                activityTab().scroll(UIHelper.ScrollDirection.UP);
            }
        }
    }

    @Step("Close camera progress layout")
    public void closeCameraProgressLayout() throws Exception {
        if(cameraProgressLayout().isElementPresent(10)) {
            cameraProgressLayout().click();
        }
    }

    @Step("Click on Settings icon of camera {0}")
    public void clickOnSettingIconOfCamera(String cameraName) throws Exception {
        log.info("Click on Settings icon of camera "+cameraName);
        settingIcon(cameraName).click();
        Thread.sleep(5000);
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on camera {0} -> Setting")
    public void openCameraAndSetting(String cameraName) throws Exception {
        log.info("Click on camera "+cameraName+" -> Setting");
        scrollToCamera(cameraName);
        clickOnCamera(cameraName);
        if(app.isAndroid() && cameraName.equals(app.props.getProperty("DistortionCamera"))){
            if(cloudSuggestionGotIt().isElementPresent(10)){
                cloudSuggestionGotIt().click();
            }
        }
        clickSettingIconOnCamera();
        if (app.isIOS()) {
            if (rotateLoadingIcon().isElementPresent()) {
                app.relaunchApp();
                Thread.sleep(5000);
                clickOnCamera(cameraName);
                clickSettingIconOnCamera();
            }
        }
    }

    @Step("Click Setting icon")
    public void clickSettingIconOnCamera() throws Exception {
        if(app.isAndroid() && guideImageIcon().isElementPresent(2)){
            log.info("Navigate away guide image");
            navigateAwayGuideImage();
        }
        if(app.isIOS()) {
            cameraLiveViewPercentage().waitForDisappear();
        }
        log.info("Click Setting icon");
        settingCameraIcon().safeClick();
        Thread.sleep(10000);
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Navigating away the Guide Image on Camera Screen")
    public void navigateAwayGuideImage() throws Exception{
        log.info("Navigating away the Guide Image on Camera Screen");
        if(guideImageIcon().isElementPresent(10)){
            guideImageIcon().click();
        }
    }

    @Step("Scroll to camera {0}")
    public void scrollToCamera(String cameraName) throws Exception {
        if(app.isAndroid()){
            int maxAttempt = 3;
            rotateLoadingIcon().waitForDisappear();
            while (!getCamera(cameraName).isElementPresent(1) && maxAttempt-- != 0) {
                log.info("Scroll to camera: "+cameraName);
                Thread.sleep(2000);
                getCamera(cameraName).androidScrollToText(cameraName);
                Thread.sleep(2000);
                if (!getCamera(cameraName).isElementPresent(1)) {
                    getCamera(cameraName).scrollToElementDownSide();
                }
            }
        }
    }

    @Step("Open Camera -> Add camera")
    public void clickOnAddCamera() throws Exception {
        log.info("Open Camera -> Add camera");
        addDeviceButton().click();
    }
    @Step("Open Camera -> Pair camera")
    public void clickOnPairCamera() throws Exception {
        log.info("Pair a Camera");

        pairCameraButton().click();
    }

    @Step("Click on camera {0} - Alert icon")
    public void clickOnCameraAlert(String cameraName) throws Exception {
        log.info("Click on camera "+cameraName+" - Alert icon");
        alertIcon(cameraName).click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Open Camera -> Start Recording -> Stop Recording -> Go To View Albums")
    public void recordVideoFeature(){
        log.info("Open Camera -> Start Recording -> Stop Recording -> Go To View Albums");
        try {
            skipTutorial().click();
            Thread.sleep(2000);
            myTab().click();
            Thread.sleep(2000);
            openAddedCamera().waitForElementToAppear();
        } catch (Exception e){
            log.info("exception is "+ e);
        }
    }

    @Step("Open Added Camera")
    public void openExistingCamera(){
        log.info("Open Added Camera");
        try {
            openAddedCamera().click();
            Thread.sleep(5000);
        }catch (Exception e){
            log.info("exception is "+ e);
        }
    }

    @Step("Record Video")
    public void recordVideo(){
        log.info("Record Video");
        try {
            recordVideoButton().click();
            Thread.sleep(2000);
            recordVideoButton().click();
            Thread.sleep(15000);
        }catch (Exception e){
            log.info("exception is "+ e);
        }
    }

    @Step("Stop Recording Video")
    public void stopRecordingVideo() throws Exception {
        log.info("Stop Recording Video");
        stopVideoButton().click();
    }

    @Step("View Album")
    public void viewAlbumStep(){
        log.info("View Album");
        try {
            viewAlbum().click();
            Thread.sleep(10000);
        }catch (Exception e){
            log.info("exception is "+ e);
        }
    }

    @Step("Close YILife warning message")
    public void closeYILifeWarningMessageIfDisplayed() throws Exception {
        log.info("Close YILife warning message");
        if(YiLifeWarningMessage().isElementPresent(5)) {
            cameraProgressLayout().click();
        }
    }

    @Step("Click on confirm switching to Home button")
    public void confirmSwitchToHomeButton() throws Exception {
        log.info("Click on confirm switching to Home button");
        Thread.sleep(4000);
        rotateLoadingIcon().waitForDisappear();
        confirmButton().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Home mode displayed")
    public void verifyHomeModeDisplayed() throws Exception {
        log.info("Verify Home mode displayed");
        app.waitForAnimationEffectInSeconds(5);
        String isSelected="";
        if(app.isIOS()){
             isSelected = String.valueOf(homeMenu().getAttribute("value").equals("1"));
        }else{
             isSelected = homeMenu().getAttribute("selected");
        }
        Assert.assertTrue(isSelected.contains("true"),  "Home Mode is not selected");
    }

    @Step("Verify Home Switching confirm popup displayed")
    public void verifyHomeSwitchingConfirmPopupDisplayed() throws Exception {
        log.info("Verify Home Switching confirm popup displayed");
        rotateLoadingIcon().waitForDisappear();
        Assert.assertTrue(homeSwitchingConfirmText().isElementPresent(15), "Text: '"+app.lang.getProperty("others_alarmMode_disarm_Hint")+"' is missing");
    }

    @Step("Click on Home button")
    public void clickOnHomeMenu() throws Exception {
        log.info("Click on Home menu");
        if(app.isIOS()){
            homeMenu().tapios();
        } else {
            rotateLoadingIcon().waitForDisappear();
            homeMenu().click();
        }
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Click on Away button")
    public void clickOnAwayMenu() throws Exception {
        log.info("Click on Away menu");
        awayMenu().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Away mode displayed")
    public void verifyAwayModeDisplayed() throws Exception {
        log.info("Verify Away mode is selected");
        app.waitForAnimationEffectInSeconds(5);
        String isSelected="";
        if(app.isIOS()){
            isSelected = String.valueOf(awayMenu().getAttribute("value").equals("1"));
        } else{
            isSelected = awayMenu().getAttribute("selected");
        }
        Assert.assertTrue(isSelected.contains("true"),  "Away Mode is not selected");
    }

    @Step("Click on Home Tab")
    public void clickOnHomeTab() throws Exception {
        log.info("Click on Home Tab");
        rotateLoadingIcon().waitForDisappear();
        homeTab().click();
    }

    public void relaunchLogout() throws Exception {
        if(app.isIOS() && new HomeScreen(app).accountTab().isElementPresent()) {
            try {
                new HomeScreen(app).clickOnAccountTab();
                new ProfileScreen(app).clickOnAccountMenu();
                new SettingsScreen(app).logoutAndConfirm();
            }catch (Exception e){
                app.relaunchApp();
                try {
                    new HomeScreen(app).clickOnAccountTab();
                    new ProfileScreen(app).clickOnAccountMenu();
                    new SettingsScreen(app).logoutAndConfirm();
                }catch (Exception e2){
                    log.info("Could not Log out after second attempt");
                }
            }
            app.relaunchApp();
        }
    }

    public void closeLocalNetworkConnectionPopup() throws Exception {
        if(app.isIOS()) {
            if(localNetworkConnectionAllowButton().isElementPresent(10))
                localNetworkConnectionAllowButton().click();
        }
    }

    @Step("Click on Window icon")
    public void clickOnWindowIcon() throws Exception {
        log.info("Click on Window icon");
        rotateLoadingIcon().waitForDisappear();
        if(app.isIOS()) {
            Thread.sleep(10000);
            if(app.isIOSAndPerfectoExecution()){
                app.perfectoClickImage("GROUP:windowicon.png");
            }
            if(windowIcon().isElementPresent()){
            //    windowIcon().click();
                WebElement timeLineElement = windowIcon().getElement();
                int timeLineXLocation=timeLineElement.getLocation().getX();
                int timeLineYLocation=timeLineElement.getLocation().getY();
                int timeLineElementHeight=timeLineElement.getSize().getHeight();
                int timeLineElementWidth=timeLineElement.getSize().getWidth();
                    app.clickByCordinates(timeLineXLocation +( timeLineElementWidth / 2), timeLineYLocation + (timeLineElementHeight / 2), timeLineXLocation +( timeLineElementWidth / 2), timeLineYLocation + (timeLineElementHeight / 2));
            }
        }else{
            windowIcon().click();
        }
    }

    @Step("Click on Cloud Tab")
    public void clickOnCloudTab() throws Exception {
        log.info("Click on Cloud Tab");
        rotateLoadingIcon().waitForDisappear();
        cloudTab().click();
    }

    @Step("Click on Settings icon")
    public void clickOnSettingIconOfCamera() throws Exception {
        log.info("Click on Settings icon");
        settingCameraIcon().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("LongPress chatbot icon")
    public void longPressChatbot() throws Exception {
    	if(app.isAndroid()) {
    		log.info("Chatbot icon is minimized so relaunching app before LongPress");
    		app.navigateBack();
    		app.navigateBack();
    		app.reOpenApp();
    	}else {
    		log.info("Chatbot icon is minimized so relaunching app before LongPress");
            app.relaunchApp();
    	}
    	Point point =  new Point(chatbotIcon().getElement().getLocation().x+10 ,
                chatbotIcon().getElement().getLocation().y );
        log.info("LongPress chatbot icon");
        chatbotIcon().tapAtPoint(point);
        Thread.sleep(1000);
        Assert.assertTrue(hideChatbotButton().isElementPresent(5),  "Hide-Catbot Pop-up is not displayed");
    }

    @Step("Click Hide Chatbot button on Pop-up")
    public void clickHideChatbotButton() throws Exception {
        log.info("Click Hide Chatbot button");
        hideChatbotButton().click();

    }

    @Step("Click Nevermind button on Hide Chatbot Pop-up")
    public void clickNevermindButton() throws Exception {
        log.info("Click Nevermind  button");
        neverMindButton().click();
    }

    @Step("Verify Hide Chatbot Pop-Up is not displayed")
    public void verifyHideChatbotPopUpIsClosed() throws Exception {
        log.info("Verifying Hide Chatbot pop-up is closed");
        Assert.assertFalse(hideChatbotPopUp().isElementPresent(5),  "Pop-up is not displayed");

    }
    @Step("Verify chatbot displayed")
    public void verifyChatbotDisplayed() throws Exception {
        log.info("verifying chatbot is displayed");
        Assert.assertTrue(chatbotIcon().isElementPresent(5),  "Chatbot is not displayed");

    }
    @Step("Verify chatbot Not displayed")
    public void verifyChatbotNotDisplayed() throws Exception {
        log.info("verifying chatbot is Not displayed");
        Assert.assertFalse(chatbotIcon().isElementPresent(5),  "Chatbot is displaying");

    }

    @Step("Click on Alert Tab")
    public void clickOnAlertTab() throws Exception {
        log.info("Click on Alert Tab");
        if(app.isIOS()){
            cameraAlertTab().tapios();
        }else {
            cameraAlertTab().click();
        }

    }
    @Step("Close try kami cloud popup ")
    public void closeKamiCloudPoupIfVisible() throws Exception {
        log.info("Close try kami cloud popup if visible");
        Thread.sleep(10000);
        if(app.isAndroid()){
            if(tryCloudCloseButton().isElementPresent(10))
            {
                tryCloudCloseButton().click();
                Thread.sleep(10000);
            }
        }else {
            if(tryCloudCloseButton().isElementPresent(10))
            {
                tryCloudCloseButton().click();
                Thread.sleep(10000);
            }
        }
    }
}

