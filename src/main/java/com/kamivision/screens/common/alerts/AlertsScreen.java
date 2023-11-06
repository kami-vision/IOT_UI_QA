package com.kamivision.screens.common.alerts;

import com.kamivision.screens.common.CameraScreen;
import com.kamivision.screens.common.CloudSubscriptionScreen;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.UIHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Log4j2
public class AlertsScreen  {
    private final UIHelper app;
    private double fixedHeight;
    private boolean isAlertAvailable;
    private boolean isCameraAddedToPlan;
    public AlertsScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper pageTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle') and  @text ='"+app.lang.getProperty("camera_playback_android")+"']"),By.xpath("(//*[starts-with(@name,'"+app.lang.getProperty("camera_playback")+"')])[2]"));}
    public UIHelper lastAlertRecord() throws Exception{ return app.setBy(By.xpath("(//*[contains(@resource-id,'messageTypeAlertImg')])[last()]"),By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));}
    public UIHelper lastAlertRecordTimeStamp() throws Exception{ return app.setBy(By.xpath("(//*[contains(@resource-id,'messageTypeAlertImg')])[last()]"),By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,':')]"));}
    public UIHelper allProduct() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("alert_type_allProducts")+"')]"),By.xpath("(//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton)[3]"));}
    public UIHelper allActivities() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("alert_type_allActivities")+"')]"),By.xpath("(//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton)[1]"));}
    public UIHelper alertTime() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id,'cameraCurrentTime')]"),By.xpath("//XCUIElementTypeButton[contains(@name,'-')]/XCUIElementTypeStaticText[contains(@name,'-')]"));}
    public UIHelper noDeviceMessage() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'alertNoCamera') and contains(@text, '"+app.lang.getProperty("alert_hint_noPairing")+"')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+app.lang.getProperty("MessageList_1441676159_83")+"')]"));}
    public UIHelper calendar() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'recDateView')]"),By.xpath("ios"));}
    public UIHelper liveBtn() throws Exception{
        int livButtonIndex=1;
        if(app.isIOS()){
            if(app.setBy(By.xpath(""),By.xpath("//XCUIElementTypeButton[@name='Live']")).getAll().size()>1){
                livButtonIndex=2;
            }
        }
        return app.setBy(By.xpath("//*[contains(@resource-id,'gobacklive')]"),By.xpath("(//XCUIElementTypeButton[@name='Live'])["+livButtonIndex+"]"));
    }
    public UIHelper messageItemTime() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id,'messageItemTime')]"),By.xpath("//XCUIElementTypeButton[@name='mic icon']/../following-sibling::XCUIElementTypeOther//XCUIElementTypeImage"));}
    public UIHelper horizontalVideoSeekBar() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'horizontalVideoSeekBar')]"),By.xpath("ios"));}
    public UIHelper tvSubtitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvSubtitle')]"),By.xpath("ios"));}
    public UIHelper cbAudio() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'btnListen') or contains(@resource-id,'cbAudio')]"),By.xpath("//XCUIElementTypeButton[@name='audio off white']"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'...')]"));}
    public UIHelper loadingProgressBar() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'loading_progress')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'...')]"));}
    public UIHelper tvConnectError() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvConnectError')]"),By.xpath("ios"));}
    public UIHelper allProductDropDrownList() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("(//XCUIElementTypeWindow/XCUIElementTypeOther)[2]//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"));}
    public UIHelper allActivitiesDropDrownList() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("(//XCUIElementTypeWindow/XCUIElementTypeOther)[2]//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"));}
    public UIHelper allProductDropDrownList(int index) throws Exception{ return app.setBy(By.xpath("android"),By.xpath("((//XCUIElementTypeWindow/XCUIElementTypeOther)[2]//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText)["+index+"]"));}
    public UIHelper allActivitiesDropDrownList(int index) throws Exception{ return app.setBy(By.xpath("android"),By.xpath("((//XCUIElementTypeWindow/XCUIElementTypeOther)[2]//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText)["+index+"]"));}
    public UIHelper playingAlertTimeStamp() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='play white']/preceding-sibling::XCUIElementTypeStaticText[1]"));}
    public UIHelper navigateBackButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='back arrow white']"));}
    public UIHelper tvDate() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvDate')]"),By.xpath("//XCUIElementTypeImage[@name='calender_icon']"));}
    public UIHelper dates() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvDate')]"),By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell"));}
    public UIHelper todayStringDate() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeImage[@name='calender_icon']/../XCUIElementTypeButton"));}
    public UIHelper noActivityMsg() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'"+app.lang.getProperty("cameraActivity_emptyStateText_body")+"') or contains(@text,'"+app.lang.getProperty("cloudActivity_emptyWithVideoActivity_body")+"')]"),By.xpath("ios"));}
    public UIHelper cameraLiveViewPercentage() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'%')]"));}
    public UIHelper alertClipNames() throws Exception{return app.setBy(By.xpath("//*[contains(@resource-id,'iv_gradient')]"),By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));}
    public UIHelper completeVideoButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'messageItemAlertImg')]"),By.xpath("//XCUIElementTypeButton[@name='play white']"));}

    public UIHelper chatbotIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'mainRelative')]/following-sibling::*"),By.xpath("//*[@name='alerts']"));}
    public UIHelper guideToolTip() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'Recent activities')]"));}
    public UIHelper noThanksCTA() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvCancel')]"),By.xpath("//XCUIElementTypeButton[@name='No Thanks']"));}
    public UIHelper learnMoreCTA() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvBuyCloud')]"),By.xpath("//XCUIElementTypeButton[@name='Learn More']"));}
    public UIHelper sixSecClipEndMsg() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Your free 6 second clip ended')]"),By.xpath("//*[@name='Your free 6 second clip ended']"));}
    public UIHelper viewOnSDCard() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'View on SD Card')]"), By.xpath("//XCUIElementTypeImage[@name='alert_sdcard_white']/../XCUIElementTypeButton"));}
    public UIHelper playbackLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Playback')]"), By.xpath("//*[contains(@name,'Playback')]"));}
    public UIHelper sdIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'imb_sdcard')]"), By.xpath("//XCUIElementTypeButton[@name='SD Card' or @name='sd card']"));}
    public UIHelper addCameraToPlanBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Add Camera to Plan')]"), By.xpath("//*[contains(@name,'Add Camera to Plan')]"));}
    public UIHelper cloudIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'imb_cloud')]"), By.xpath("//XCUIElementTypeButton[@name='Cloud' or @name='cloud videos']"));}
    public UIHelper noVideoLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'No video')]"), By.xpath("//*[starts-with(@name,'No')]"));}
    public UIHelper upgrageToLongerHistory() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Upgrade to a longer history')]"),By.xpath("//XCUIElementTypeStaticText[@name='Upgrade to a longer history']"));}
    public UIHelper getSelectedDate() throws Exception{ return app.setBy(By.xpath("and"),By.xpath("//XCUIElementTypeImage[@name='calender_icon']/../XCUIElementTypeButton"));}
    public UIHelper playCompleteVideo() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tv_view_onsdcard')]"),By.xpath("//XCUIElementTypeStaticText[@name='Play Complete Video']/../XCUIElementTypeButton"));}
    public UIHelper historydates() throws Exception { return app.setBy(By.xpath("(//*[contains(@resource-id,'recDateView')]/android.widget.RelativeLayout/android.widget.TextView)"), null);}
    public UIHelper inActiveDates() throws Exception { return app.setBy(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'tvDate') and @enabled='false']"), By.xpath("ios"));}
    public UIHelper activeDates() throws Exception { return app.setBy(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'tvDate') and @enabled='true']"), By.xpath("ios"));}
    public UIHelper downloadVideo() throws Exception { return app.setBy(By.xpath("and"), By.xpath(" //XCUIElementTypeButton[@name='alert download']"));}
    public UIHelper allowAccessToPhotosButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[contains(@name,'Allow Access')]"));}
    public UIHelper okButton() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnOk')]"),By.xpath("//*[@name='OK']"));}
    public UIHelper downloadIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'alertSave')]"),By.xpath("ios"));}
    public UIHelper shareIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'alertShare')]"),By.xpath("ios"));}
    public UIHelper videoSavedMsg() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvSaveMsg')]"),By.xpath("ios"));}
    public UIHelper viewAlbum() throws Exception{ return app.setBy(By.xpath("//android.widget.Button[contains(@resource-id, 'btnEnterAlbum')]"),By.xpath("ios"));}
    
    @Step("Verify user can see alert clips")
    public void verifyUserCanSeeAlertClips() throws Exception {
        if (app.isIOS()) {
            goToAlertDate();
            log.info("Verify user can see alert clips");
            Assert.assertTrue(alertClipNames().isElementPresent(15), "Alert clips are not displayed");
            return;
        }
        if (alertClipNames().isElementPresent(15)) {
            log.info("Verify user can see alert clips");
            Assert.assertTrue(alertClipNames().isElementPresent(15), "Alert clips are not displayed");
            isAlertAvailable = true;
        } else {
            log.info("No activity message is displayed");
            Assert.assertTrue(noActivityMsg().isElementPresent());
            isAlertAvailable = false;
        }
    }

    @Step("Verify Alerts page is Displayed")
    public void verifyAlertsPageDisplayed() throws Exception {
        log.info("Verify Alerts page is Displayed");
        Assert.assertTrue(pageTitle().isElementPresent(5), "Alerts page is missing");
    }

    @Step("Select last Alert")
    public void selectLastAlert() throws Exception {
        if (isAlertAvailable && app.isAndroid()) {
            log.info("Select last Alert when the flag is: " + isAlertAvailable);
            lastAlertRecord().click();
        }
        if (app.isIOS()) {
            log.info("Select last Alert");
            lastAlertRecord().click();
        }
    }

    @Step("Click on complete video button")
    public void waitAndClickOnCompleteVideoButton() throws Exception {
        if (isAlertAvailable && app.isAndroid()) {
            log.info("Click on complete video button");
            completeVideoButton().click();
        }
        if (app.isIOS()) {
            log.info("Select last Alert");
            //lastAlertRecord().click();
        }
    }

    @Step("Verify Alerts page menus is displayed")
    public void verifyAlertsPageMenusDisplayed() throws Exception {
        log.info("Verify Alerts page menus is displayed");
        Assert.assertTrue(allProduct().isElementPresent(5), "All product menus are missing");
        Assert.assertTrue(allActivities().isElementPresent(5), "All Activities menus are missing");
        Assert.assertTrue(alertTime().isElementPresent(5), "Date menus are missing");
    }

    @Step("Verify No Device message is displayed")
    public void verifyNoDeviceMessageDisplayed() throws Exception {
        log.info("Verify No Device message is displayed");
        Assert.assertTrue(noDeviceMessage().isElementPresent(5), "No Alert message is missing");
    }

    @Step("Verify chatbot displayed")
    public void verifyChatbotDisplayed() throws Exception {
        log.info("Verifying chatbot is displayed");
        Assert.assertTrue(chatbotIcon().isElementPresent(5),  "Chatbot is not displayed");
    }

    @Step("Verify chatbot  is Not displayed")
    public void verifyChatbotNotDisplayed() throws Exception {
        log.info("Verifying chatbot is not displayed");
        Assert.assertFalse(chatbotIcon().isElementPresent(5),  "Chatbot is displayed");
    }

    @Step("Click guide tool tip")
    public void skipGuideToolTip() throws Exception {
        log.info("Skip guide tool tip");
        if(guideToolTip().isElementPresent(3)){
            guideToolTip().click();
        }
    }

    @Step("Click live button")
    public void clickLiveButton() throws Exception {
        log.info("Click live button");
        liveBtn().click();
    }

    @Step("Verify audio button is displayed")
    public void verifyMotionAlertIsPlayback() throws Exception {
        log.info("Verify audio button is displayed");
        if(!noVideoLabel().isElementPresent(15)) {
            Assert.assertTrue(cbAudio().isElementVisible(25),  "Camera audio icon is not displayed");	
        }
    }

    @Step("Scroll to left video alerts to make sure app doesn't crash")
    public void scrollToLeftVideoAndVerifyLoadingAlert(int loopTime) throws Exception {
        if(app.isAndroid()) {
            int scrollAttempt = 0;
            rotateLoadingIcon().waitForDisappear();
            double height = 0.6;
            long start = System.currentTimeMillis();
            while (height < 0.8) {
                log.info(String.format("Start scrolling to left at the %s attempt at height: %s", scrollAttempt++, height));
                messageItemTime().scrollWithCustomizedAxis(0.5, 0.4, height, UIHelper.ScrollDirection.LEFT);
                checkTimer(start);
                if (tvSubtitle().isElementPresent(30) || noVideoLabel().isElementPresent(30)) {
                    fixedHeight = height;
                    loadingProgressBar().waitForDisappear();
                    if (tvConnectError().isElementPresent(2)) {
                        log.info("Network error happens. Please try again!");
                    }
                    while (loopTime-- > 0) {
                        log.info("Keep scrolling to left...");
                        messageItemTime().scrollWithCustomizedAxis(0.5, 0.4, height, UIHelper.ScrollDirection.LEFT);
                        verifyLoadingAlert();
                        checkTimer(start);
                    }
                    break;
                }
                log.info("Keep increase height level as it varies from device to device");
                height = height + 0.05;
            }
        }else{
            int looping=loopTime+1;
            cameraLiveViewPercentage().waitForDisappear();
            WebElement timeLineElement = messageItemTime().getElement();
            int timeLineXLocation=timeLineElement.getLocation().getX();
            int timeLineYLocation=timeLineElement.getLocation().getY()+50;
            int timeLineElementHeight=timeLineElement.getSize().getHeight();
            int timeLineElementWidth=timeLineElement.getSize().getWidth();
            while ((looping--)>0) {
                app.swipeByCordinates(timeLineXLocation, timeLineYLocation + (timeLineElementHeight / 2), timeLineXLocation + timeLineElementWidth, timeLineYLocation + (timeLineElementHeight / 2));
            }
            log.info("wait for loading...");
            Thread.sleep(2000);
            loadingProgressBar().waitForDisappear();
            log.info("scrolling right of the time line");
             looping=loopTime;
            while ((looping--)>0) {
                app.swipeByCordinates(timeLineXLocation + timeLineElementWidth, timeLineYLocation + (timeLineElementHeight / 2), timeLineXLocation, timeLineYLocation + (timeLineElementHeight / 2));
            }
            log.info("wait for loading...");
            Thread.sleep(2000);
            loadingProgressBar().waitForDisappear();
            log.info("click on Live button");
            liveBtn().click();
            Thread.sleep(2000);
            log.info("wait for loading...");
            loadingProgressBar().waitForDisappear();
            log.info("scrolling right of the time line");
        }
    }

    @Step("Scroll to right video alerts to make sure app doesn't crash")
    public void scrollToRightVideoAndVerifyLoadingAlert(int loopTime) throws Exception {
        if(app.isAndroid()) {
            long start = System.currentTimeMillis();
            while (loopTime-- > 0) {
                log.info("Keep scrolling to right");
                messageItemTime().scrollWithCustomizedAxis(0.3, 0.4, fixedHeight, UIHelper.ScrollDirection.RIGHT);
                verifyLoadingAlert();
                checkTimer(start);
            }
        }
    }

    @Step("Scroll to down video alerts to make sure app doesn't crash")
    public void scrollToDownVideoAndVerifyLoadingAlert(int loopTime) throws Exception {
        if(app.isAndroid()) {
            long start = System.currentTimeMillis();
            while (loopTime-- > 0) {
                log.info("Keep scrolling to down");
                messageItemTime().scrollWithCustomizedAxis(0.7, 0.8, 0.5, UIHelper.ScrollDirection.DOWN);
                verifyLoadingAlert();
                checkTimer(start);
            }
        }else{
            int numberOfAlerts=alertClipNames().getAll().size();
            if(numberOfAlerts>0) {
                int numberOfScrolls = (numberOfAlerts / 3) + 1;
                log.info("scroll till last alerts");
                while (numberOfScrolls-- > 0) {
                    app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN, .9, .7);
                }
                ((WebElement)alertClipNames().getAll().get(numberOfAlerts - 1)).click();
                Thread.sleep(2000);
                log.info("wait for loading...");
                loadingProgressBar().waitForDisappear();
            }else{
                logToReport("no Alerts are found, skip");
            }
        }
    }

    @Step("{0}")
    public void logToReport(String message){
        return;
    }

    @Step("Scroll to top video alerts to make sure app doesn't crash")
    public void scrollToTopVideoAndVerifyLoadingAlert(int loopTime) throws Exception {
        if(app.isAndroid()) {
            long start = System.currentTimeMillis();
            while (loopTime-- > 0) {
                log.info("Keep scrolling to top");
                messageItemTime().scrollWithCustomizedAxis(0.7, 0.5, 0.5, UIHelper.ScrollDirection.UP);
                verifyLoadingAlert();
                checkTimer(start);
            }
        }else{
            int numberOfAlerts=alertClipNames().getAll().size();
            if(numberOfAlerts>0) {
            int numberOfScrolls=(numberOfAlerts/3)+1;
            log.info("scroll till first alerts");
            while ((numberOfScrolls--)>0) {
                app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN, .7, .9);
            }
                ((WebElement)alertClipNames().getAll().get(0)).click();
            Thread.sleep(2000);
            log.info("wait for loading...");
            loadingProgressBar().waitForDisappear();
            }else{
                logToReport("no Alerts are found, skip");
            }
        }
    }


    private void verifyLoadingAlert() throws Exception {
        log.info("Wait for loading progress bar is disappeared.It may take time...");
        rotateLoadingIcon().waitForDisappear();
        loadingProgressBar().waitForDisappear();
        log.info("Verify horizontal video seek bar is displayed");
        Assert.assertTrue(horizontalVideoSeekBar().isElementVisible(25),  "Alert video icon is not displayed");
        if (noActivityMsg().isElementPresent(5) || noVideoLabel().isElementPresent(5)) {
            log.info("Verify no activity message is displayed");
        } else {
            log.info("Verify alert videos are shown");
            Assert.assertTrue(messageItemTime().isElementVisible(25),  "Alert video icon is not displayed");
        }
    }

    @Step("Verify the visibility of calendar")
    public void verifyCalendarVisibility(List<WebElement> dates) throws Exception {
        log.info("Verify the visibility of calendar");
        Assert.assertTrue(dates.size() > 2);
    }

    @Step("Click on today icon")
    public List<WebElement> clickTodayIcon() throws Exception {
        List<WebElement> datesList = dates().waitForElementsToBeVisible();
        while (datesList.size() < 2) {
            try {
                log.info("Click date icon");
                tvDate().safeClick();
                Thread.sleep(2000);
                log.info("Get visible dates");
                datesList = dates().waitForElementsToBeVisible();
            } catch (Exception e) {
                log.info("Something wrong happens");
            }
        }
        datesList = dates().waitForElementsToBeVisible();
        List<WebElement> selectiveDates = new ArrayList<>();
        for (WebElement element : datesList) {
            if (element.getText().matches("\\d+")) {
                log.info("Add date element into list");
                selectiveDates.add(element);
            }
        }
        return selectiveDates;
    }

    @Step("Click on Calendar icon")
    public String clickCalendarIcon() throws Exception {
        String xpath = "";
        try {
            String now = java.time.LocalDate.now().toString();
            int date = Integer.parseInt(now.substring(now.length() -2));
            String formattedDate = date < 10 ? ("0" + date) : String.valueOf(date);
            xpath = "//android.widget.TextView[@text='" + formattedDate + "']";
            if (!app.setBy(By.xpath(xpath), By.xpath("")).isElementPresent(5)) {
                log.info("Click calendar button");
                tvDate().click();
                Thread.sleep(2000);
            } else {
                log.info("Calendar has already been opened");
            }
        } catch (Exception e) {
            log.info("Something wrong happens: " + e.getMessage());
        }
        return xpath;
    }

    @Step("Verify the visibility of calendar")
    public void verifyCalendarVisibility(String dates) throws Exception {
        log.info("Verify calendar visibility");
        Assert.assertTrue(app.setBy(By.xpath(dates), By.xpath("")).isElementVisible(15));
    }

    @Step("Tap on each dates")
    public void tapCalendarAndVerifyMotionAlertIsLoaded(int dayCount) throws Exception {
        if(app.isAndroid()) {
            for (int i = 1; i < dayCount; i++) {
                clickCalendarIcon();
                try {
                    String now = java.time.LocalDate.now().toString();
                    int date = (Integer.parseInt(now.substring(now.length() -2)) - i);
                    String formattedDate = date < 10 ? ("0" + date) : String.valueOf(date);
                    log.info("Click at date: " + formattedDate);
                    String dateXpath = "//*[@text='" + formattedDate + "']";
                    app.setBy(By.xpath(dateXpath), By.xpath("")).quickClick();
                    if (!noActivityMsg().isElementPresent(5)) {
                        verifyMotionAlertIsPlayback();
                        boolean onSuccess = tapOnAlertClip();
                        if (onSuccess) {
                            verifyCTAsAndSixSecondMessageAreDisplayed();
                        }
                    } else {
                        log.info("No motion alert");
                    }
                } catch (Exception e) {
                    log.info("Network issue: " + e.getMessage());
                }
            }
        }else{

        }
    }

    @Step("Tap on each dates")
    public void tapOnEachDateAndVerifyMotionAlertIsLoaded(List<WebElement> dates, int dayCount) throws Exception {
        tvDate().tapios();
        Thread.sleep(5000);
        int datesCount = dates().getAll().size() - 1;
        log.info("datesCount:" + datesCount);
        for (int i = 0; i <= dayCount; i++) {
            log.info("datesCount - i:" + (datesCount - i - 2));
            WebElement dateToBeSelected = dates().getAll().get(datesCount - i - 2);
            String dateToBeSelectedText = dateToBeSelected.findElement(By.xpath("//XCUIElementTypeStaticText")).getAttribute("name");
            dateToBeSelected.click();
            Thread.sleep(4000);
            loadingProgressBar().waitForDisappear();
            String dispalyedDate = todayStringDate().getAttribute("name");
            log.info("dispalyedDate:" + dispalyedDate);
            log.info("dateToBeSelectedText:" + dateToBeSelectedText);
            Assert.assertTrue(dispalyedDate.contains(dateToBeSelectedText), "Selected Date and Displayed Date are different");
            verifyPlaybackLabelIsShown();
            tvDate().tapios();
            Thread.sleep(5000);
        }
    }

    public void checkTimer(long timeStamp) {
        long finish = System.currentTimeMillis();
        long duration;
        duration = (finish - timeStamp)/1000;
        log.info("Duration is: " + duration);
        if (duration > 100) {
            log.info("Loading time takes too long");
            return;
        }
    }

    @Step("Tap SD card")
    public void tapSDCard() throws Exception {
        log.info("Tap SD card");
        if (app.isAndroid()) {
            sdIcon().quickClick();
        }else{
            sdIcon().tapios();
        }
    }

    @Step("Tap Cloud icon")
    public void tapCloudIcon() throws Exception {
        if (app.isAndroid()) {
            log.info("Tap Cloud icon");
            sdIcon().click();
        }else{
            new CameraScreen(app).cloudToggle().click();
        }
    }

    @Step("Tap on alert")
    public boolean tapOnAlertClip() throws Exception {
        log.info("Tap on alert");
            try {
                if(app.isIOS()){
                    goToAlertDate();
                }
                alertClipNames().click();
                rotateLoadingIcon().waitForDisappear();
                isAlertAvailable = true;
            } catch (Exception e) {
                log.info("No alert is displayed");
                isAlertAvailable = false;
            }

        return isAlertAvailable;
    }
    
    @Step("Verify alerts available")
    public boolean isAlertAvailable() throws Exception {
    	log.info("Verify alerts available");
        if(alertClipNames().isElementPresent(5)) {
        	return true;
        }else {
        	return false;
        }
    }

    @Step("Verify CTA is displayed with the six-second message")
    public boolean verifyCTAsAndSixSecondMessageAreDisplayed() throws Exception {
        if (isAlertAvailable) {
            log.info("Verify No Thanks");
            Assert.assertTrue(noThanksCTA().isElementVisible(15),  "No Thanks is not displayed");
            log.info("Verify Learn More");
            Assert.assertTrue(learnMoreCTA().isElementVisible(15),  "Learn More is not displayed");
            log.info("Verify 6 second message");
            Assert.assertTrue(sixSecClipEndMsg().isElementVisible(15),  "Six second message is not displayed");
            return true;
        } else {
            log.info("Skip this step due to unavailable motion alert");
            return false;
        }
    }

    @Step("Tap on Learn More CTA")
    public void tapLearnMoreCTA() throws Exception {
        if (app.isAndroid()) {
            log.info("Tap on Learn More CTA");
            learnMoreCTA().safeClick();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Tap on Add Camera to Plan")
    public void tapAddCameraToPlan() throws Exception {
        log.info("Tap on Add Camera To Plan");
        if (app.isAndroid()) {
            addCameraToPlanBtn().safeClick();
            rotateLoadingIcon().waitForDisappear();
        }else{
            addCameraToPlanBtn().tapios();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("View on SD card")
    public void tapViewOnSDCard() throws Exception {
        log.info("Click view on SD card");
            try {
                noThanksCTA().safeClick();
                viewOnSDCard().safeClick();
            } catch (Exception e) {
                viewOnSDCard().safeClick();
            }
    }
    
    @Step("Verify CameraAddedToPlan")
    public Boolean verifyCameraAddedToPlan() throws Exception {
        log.info("Verify CameraAddedToPlan happens");
        if(!addCameraToPlanBtn().isElementPresent()) {
        	log.info("Camera Added To Plan");
        	isCameraAddedToPlan=true;
        }else {
        	log.info("Camera not Added To Plan");
        	Assert.assertTrue(addCameraToPlanBtn().isElementPresent(15), "addCameraToPlanBtn not displayed");
        	isCameraAddedToPlan=false;
        }
		return isAlertAvailable;
    }

    @Step("Click PlayCompleteVideo")
    public void clickPlayCompleteVideo() throws Exception {
    	 log.info("Click playCompleteVideo");
            if(isAlertAvailable && app.isAndroid()) {
            	playCompleteVideo().click();
            	Thread.sleep(3000);
            }
            if(app.isIOS()) {
            	playCompleteVideo().click();
            }
    }
    
    @Step("Verify PlayCompleteVideo")
    public void verifyPlayCompleteVideo() throws Exception {
    	 log.info("Verify playCompleteVideo is displayed");
            if(isAlertAvailable && app.isAndroid()) {
            	Assert.assertTrue(playCompleteVideo().isElementVisible(15),  "PlayCompleteVideo is not displayed");
            }
    }
    
    @Step("Verify play playback nearest timestamp")
    public void verifyPlaybackLabelIsShown() throws Exception {
        log.info("Verify play playback happens");
            if (tvConnectError().isElementPresent(5)) {
                log.info("Network issue");
                return;
            }
            if(isAlertAvailable && isCameraAddedToPlan && app.isAndroid()) {
            	if(!noVideoLabel().isElementPresent(5)) {
                    Assert.assertTrue(playbackLabel().isElementVisible(15),  "Playback is not displayed");
                }else {
                	log.info("No video uploaded to Kami Cloud");
                    Assert.assertTrue(noVideoLabel().isElementVisible(15),  "No video uploaded to Kami Cloud message is not displayed");
                }
            }
            if(app.isIOS()) {
                if(!playbackLabel().isElementVisible(15)) {
                    Assert.assertTrue(noVideoLabel().isElementVisible(5), "No video uploaded to Kami Cloud message is not displayed");
                }else {
                    Assert.assertTrue(playbackLabel().isElementVisible(5), "Playback is not displayed");
                }
            }
            
    }
    
    @Step("Verify Alert is played")
	public void verifyAlertplayed() throws Exception {
		if (!noVideoLabel().isElementPresent(10) && app.isAndroid()) {
			log.info("Verify horizontal video seek bar is displayed");
			Assert.assertTrue(horizontalVideoSeekBar().isElementVisible(25),
					"Alert horizontal video seek bar is not displayed");
		}
	}
    
    @Step("Verify AlertPlay")
	public void verifyAlertPlay() throws Exception {
		log.info("Verify AlertPlay for selected dates");
		if (app.isAndroid()) {
			try {
				if (alertClipNames().isElementPresent(5)) {
					tapOnAlertClip();
					verifyAlertplayed();
				}
				log.info("Click Calender Icon");
				tvDate().safeClick();
				log.info("Try Available dates");
				int activedates = activeDates().getAll().size();
				log.info("Available dates :" + activedates);
				for (int i = 1; i < activedates; i++) {
					try {
						String dateXpath = "(//*[contains(@resource-id,'tvDate')])[last()-" + i + "]";
						String date = app.setBy(By.xpath(dateXpath), By.xpath("")).getAttribute("text");
						app.setBy(By.xpath(dateXpath), By.xpath("")).safeClick();
						log.info("Selected Date " + date);
						if (alertClipNames().isElementPresent(5)) {
							tapOnAlertClip();
							verifyAlertplayed();
						} else {
							log.info("No alert. Try again...");
						}
					} catch (Exception e1) {
						log.info("Issue Selecting Date. Try again...");
					}
					tvDate().safeClick();
				}
			} catch (Exception e2) {
				log.info("No alert. End all attempts");
			}
		}
	}

    @Step("Tap on alert")
    public boolean tryTapAlertUntilSuccess() throws Exception {
        boolean onSuccess = false;
        if (app.isAndroid()) {
            onSuccess = tapOnAlertClip();
            if (!onSuccess) {
                log.info("Try other dates");
                int attempt = 4;
                try {
                    for (int i = 1; i < attempt; i++) {
                        clickCalendarIcon();
                        try {
                            String now = java.time.LocalDate.now().toString();
                            int date;
                            if(Integer.parseInt(now.substring(now.length() - 2))!=1) {
                            	date = (Integer.parseInt(now.substring(now.length() - 2)) - i);
                            }else {
                            	int month=Integer.parseInt(now.substring(5,7));
                            	if(month==5 || month==7 || month==10 || month==12){
                            		date =30;
                            	}else {
                            		date =31;
                            	}
                            	if(month==3) {
                            		if(Integer.parseInt(now.substring(0,4))%4!=0) {
                            			date =28;
                            		}else {
                            			date =29;
                            		}
                            	}
                            }
                            String formalizedDate = date < 10 ? ("0" + date) : String.valueOf(date);
                            log.info("Click at date: " + formalizedDate);
                            String dateXpath = "//*[@text='" + formalizedDate + "']";
                            app.setBy(By.xpath(dateXpath), By.xpath("")).quickClick();
                            if (alertClipNames().isElementPresent(5)) {
                                verifyMotionAlertIsPlayback();
                                onSuccess = tapOnAlertClip();
                                boolean viewOnSDCardDisplayed = viewOnSDCard().isElementPresent(10);
                                if (onSuccess) {
                                    if (viewOnSDCardDisplayed) {
                                    	log.info("View On SDCard Upsell Displayed");
                                        break;
                                    }else {
                                    	log.info("View On SDCard Upsell Not Displayed");
                                    }
                                    log.info("Verify No Thanks");
                                    Assert.assertTrue(noThanksCTA().isElementVisible(15),
                                            "No Thanks is not displayed");
                                    if(learnMoreCTA().isElementPresent(15)) {
                                    	log.info("Verify Learn More");
                                        Assert.assertTrue(learnMoreCTA().isElementVisible(15),
                                                "Learn More is not displayed");
                                    }else {
                                    	log.info("Verify AddCameraToPlan");
                                        Assert.assertTrue(addCameraToPlanBtn().isElementVisible(15),
                                                "AddCameraToPlan is not displayed");
                                    }
                                    break;
                                } else {
                                    log.info("No motion alert. Try again...");
                                }
                            } else {
                                log.info("No motion alert. Try again...");
                            }
                        } catch (Exception e1) {
                            log.info("Network issue. Try again...");
                        }
                    }
                } catch (Exception e2) {
                    log.info("No motion alert. End all attempts");
                }
            }
        }else{
            goToAlertDate();
            onSuccess = tapOnAlertClip();
        }
        return onSuccess;
    }

    @Step("Tap on No Thanks")
    public void tapNoThanks() throws Exception {
        if (isAlertAvailable) {
            log.info("Tap on No Thanks");
            noThanksCTA().safeClick();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify 'View on SD Card' is displayed")
    public void verifyViewOnSDCardIsDisplayed() throws Exception {
        log.info("Verify 'View on SD Card' is displayed");
        if (isAlertAvailable) {
            Assert.assertTrue(viewOnSDCard().isElementPresent(15));
        }
    }

    @Step("Free User only 4 dates are visible and only 2 selectable")
    public void verifyFreeHasOnly4DatesVisible() throws Exception {
        log.info("Free User only 4 dates are visible and only 2 selectable");
        if(app.isIOS()) {
            List<WebElement> dates = dates().getAll();
            HashMap<Integer, String> datevalues = new HashMap<Integer, String>();
            for (int dateIndex = 0; dateIndex < dates.size(); dateIndex++) {
                datevalues.put(dateIndex, dates.get(dateIndex).findElement(By.xpath("//XCUIElementTypeStaticText")).getAttribute("name"));
            }
            Assert.assertTrue(dates.size() == 5, "Dates Visible Free user are more than 4 dates/less than 4 dates");
            for (int dateIndex = 1; dateIndex < datevalues.size(); dateIndex++) {
                app.setBy(null, By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell//XCUIElementTypeStaticText[@name='" + datevalues.get(dateIndex) + "']")).click();
                if (dateIndex > 2) {
                    Thread.sleep(3000);
                    Assert.assertTrue(getSelectedDate().getAttribute("name").equals("Today") || getSelectedDate().getAttribute("name").equals("Yesterday"), "Today/Yesterday are not selectable/not enabled to be selected");
                    tvDate().tapios();
                } else {
                    Assert.assertTrue(getSelectedDate().getAttribute("name").equals("Today"), "Disabled Dates are selectable");
                }
            }
        }
    }
    
    @Step("Clicking on Upgrade, User is navigated to Manage plans page")
    public void verifyUserNavigatedToManagePlanPage() throws Exception {
        if(app.isIOS()) {
            upgrageToLongerHistory().click();
            Assert.assertTrue(new CloudSubscriptionScreen(app).manageCloudPlanTitle().isElementPresent(10), "Manage cloud plan is not displayed");
        }
        if(app.isAndroid()) {
            upgrageToLongerHistory().click();
            rotateLoadingIcon().waitForDisappear();
            Assert.assertTrue(new CloudSubscriptionScreen(app).manageCloudPlanTitle().isElementPresent(10), "Manage cloud plan is not displayed");
        }
    }

    @Step("Select Previous Date")
    public void selectPreviousDate() throws Exception {
        app.setBy(By.xpath("(//*[contains(@resource-id,'llItem')]/android.widget.TextView)[last()-1]"), By.xpath("(//XCUIElementTypeCollectionView/XCUIElementTypeCell//XCUIElementTypeStaticText)[last()-1]")).click();
    }
    @Step("Verify Play back on moving time line")
    public void verifyTimeLinePlayBack() throws Exception {
        new CameraScreen(app).cameraLiveViewPercentage().waitForDisappear();
        WebElement timeLineElement = messageItemTime().getElement();
        int timeLineXLocation=timeLineElement.getLocation().getX();
        int timeLineYLocation=timeLineElement.getLocation().getY()+50;
        int timeLineElementHeight=timeLineElement.getSize().getHeight();
        int timeLineElementWidth=timeLineElement.getSize().getWidth();
        app.swipeByCordinates(timeLineXLocation, timeLineYLocation + (timeLineElementHeight / 2), timeLineXLocation + timeLineElementWidth, timeLineYLocation + (timeLineElementHeight / 2));

    }
    
	@Step("Tap on cloud")
	public void tapCloud() throws Exception {
		if (app.isAndroid()) {
			cloudIcon().click();
			log.info("Clicked on cloud");
		} else
			cloudIcon().tapios();
	}
	
	@Step("Tap on Today icon")
	public void tapToday() throws Exception {
		if (app.isAndroid()) {
			tvDate().click();
			log.info("clicked on today icon");
		} else
			tvDate().tapios();
	}
	
	@Step("Free Cloud User only 2 active dates are visible and only 2 inactive dates")
	public void verifyFreeHas2InActiveDates() throws Exception {
		int numberofInactiveDates = inActiveDates().getAll().size();
		int numberofActiveDates = activeDates().getAll().size();
		Assert.assertTrue(numberofActiveDates >= 1, "Free Cloud User has  2 active dates");
		log.info("2 active dates verified");
		Assert.assertTrue(numberofInactiveDates == 2, "Free Cloud User has only 2 inactive dates");
		log.info("2 inactive dates verified");
		Assert.assertTrue(upgrageToLongerHistory().isElementPresent(15), "Upgrade to Longer history visible");
	}
	
	@Step("Verify Play complete video label is present")
	public void verifyPlayCompleteVideoText() throws Exception {
		Assert.assertTrue(playCompleteVideo().isElementPresent(10), "Play complete video label is present");
		log.info("verified play complete video label ");
	}
	
	@Step("Verify 'Learn More' Text")
	public void verifyLearnMoreText() throws Exception {
		log.info("Verify Learn More");
		Assert.assertTrue(learnMoreCTA().isElementVisible(15), "Learn More is not displayed");
	}
	
	@Step("Verify 'No Thanks' Text")
	public void verifyNoThanksText() throws Exception {
		if (app.isAndroid() && isAlertAvailable) {
			log.info("Verify No Thanks");
			Assert.assertTrue(noThanksCTA().isElementVisible(15), "No Thanks is not displayed");
		}
	}
	
	@Step("Verify Download & Share Icon After AlertPlay")
	public void verifyDownloadShareIcon() throws Exception {
		if (app.isAndroid() && isAlertAvailable) {
			log.info("Verify Download Icon");
			Assert.assertTrue(downloadIcon().isElementVisible(15), "Download icon is not displayed");
			log.info("Verify Share Icon");
			Assert.assertTrue(shareIcon().isElementVisible(15), "Share icon is not displayed");
		}
	}
	
	@Step("Verify Download & Share Icon Not Displayed After AlertPlay")
	public void verifyDownloadShareIconNotDisplayed() throws Exception {
		if (app.isAndroid() && isAlertAvailable) {
			log.info("Verify Download Icon");
			Assert.assertFalse(downloadIcon().isElementVisible(10), "Download icon is displayed");
			log.info("Verify Share Icon");
			Assert.assertFalse(shareIcon().isElementVisible(10), "Share icon is displayed");
		}
	}
	
	@Step("Verify user can see alert clips")
    public boolean canSeeAlertClips() throws Exception {
       
        if (alertClipNames().isElementPresent(15)) {
            log.info("Verify user can see alert clips");
            Assert.assertTrue(alertClipNames().isElementPresent(15), "Alert clips are not displayed");
            isAlertAvailable = true;
        } 
        else
        	isAlertAvailable = false;
        return isAlertAvailable;
        }

    @Step("Go To Alert Existing date")
    public void goToAlertDate() throws Exception {
        log.info("Go To Alert Existing date");
        tvDate().tapios();
        Thread.sleep(4000);
        for (int i = 1; i <= dates().getAll().size(); i++) {
            if(alertClipNames().isElementPresent()){
                break;
            }
            app.setBy(null,By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[last()-"+(i)+"]")).click();
            Thread.sleep(4000);
            loadingProgressBar().waitForDisappear();
            tvDate().tapios();
        }
    }
}
