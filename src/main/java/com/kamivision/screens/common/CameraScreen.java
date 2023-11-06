package com.kamivision.screens.common;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import utilities.UIHelper;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

@Log4j2
public class CameraScreen  {
    private final UIHelper app;
    public CameraScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper activityTab() throws Exception{ return app.setBy(By.xpath("//android.widget.RadioButton[contains(@text,'"+app.lang.getProperty("camera_playback_android")+"')]"),By.xpath("//*[starts-with(@name,'"+app.lang.getProperty("camera_playback")+"')]"));}
    public UIHelper videoPlayerTips() throws Exception{ return app.setBy(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'videoPlayer')]"),By.xpath("ios"));}
    public UIHelper microIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'btnTalk')]"),By.xpath("//XCUIElementTypeButton[@name='audio off white']"));}
    public UIHelper backIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'btnQuitHalf')]"),By.xpath("ios"));}
    public UIHelper rateSizeKBsIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvKbps')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+app.lang.getProperty("xiaomi_kilobytes_unit")+"')]"));}
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'...')]"));}
    public UIHelper turnedOffMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@text, '" + app.lang.getProperty("cameraSetting_hint_live_off")+ "')]"),By.xpath("//*[contains(@name,'" + app.lang.getProperty("cameraSetting_hint_live_off")+ "')]"));}
    public UIHelper cameraLiveViewPercentage() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'%')]"));}
    public UIHelper noonLightButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='911 play alarm']"));}
    public UIHelper noonLightCancelButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='911 cancel help']"));}
    public UIHelper allowAccessToPhotosButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[contains(@name,'Allow Access')]"));}
    public UIHelper viewAlbumButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeStaticText[@name='View album']"));}
    public UIHelper playAndPauseButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'albumPlay')]"),By.xpath("//XCUIElementTypeButton[@name='play white']"));}
    public UIHelper previousButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='previous white']"));}
    public UIHelper captureButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='icons capture still']"));}
    public UIHelper recordButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='Icons Record']"));}
    public UIHelper stopRecordButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[contains(@name,'0:')]"));}
    public UIHelper fullViewButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageButton[contains(@resource-id,'btnFullScreen')]"),By.xpath("//XCUIElementTypeButton[@name='yh btn play fullscreen']"));}
    public UIHelper fullViewCaptureButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn play capture h']"));}
    public UIHelper fullViewTalkBackButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn play say h']"));}
    public UIHelper fullViewRecordButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn play recode h']"));}
    public UIHelper fullViewStopTalkBackButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn play phone call off h']"));}
    public UIHelper fullViewStopRecordButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn play recode h 0']"));}
    public UIHelper fullViewBackButton() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='yh btn nav back big']"));}
    public UIHelper resolutionDropDown() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeButton[@name='HD' or @name='SD' or @name='Auto']"));}
    public UIHelper resolutionSDorHD() throws Exception{ return app.setBy(By.xpath("android"),By.xpath("//XCUIElementTypeStaticText[@name='SD' or @name='HD']"));}
    public UIHelper cbAudio() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'btnListen') or contains(@resource-id,'cbAudio')]"),By.xpath("//XCUIElementTypeButton[@name='audio off white']"));}
    public UIHelper loadingProgressBar() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'loading_progress')]"),By.xpath("//XCUIElementTypeStaticText[contains(@name,'...')]"));}
    public UIHelper cloudToggle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'imb_cloud')]"),By.xpath("//XCUIElementTypeButton[@name='Cloud' or @name='cloud videos']"));}
    public UIHelper sdCardToggle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'imb_sdcard')]"),By.xpath("//XCUIElementTypeButton[@name='SD Card' or @name='sd card']"));}
    public UIHelper learnMore() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvBuyCloud')]"),By.xpath("//XCUIElementTypeButton[@name='Learn More']"));}
    public UIHelper addCameraToPlanButton() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[@text='Add Camera to Plan']"),By.xpath("//XCUIElementTypeButton[@name='Add Camera to Plan']"));}
    public UIHelper noThanksButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvCancel')]"),By.xpath("//XCUIElementTypeButton[@name='No Thanks']"));}
    public UIHelper kamiCloudLogoOnPurchase() throws Exception{ return app.setBy(By.xpath("and"),By.xpath("//XCUIElementTypeImage[@name='kami_cloud_text_logo']"));}
    public UIHelper viewOnSDCardButton() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'View on SD Card')]"),By.xpath("//XCUIElementTypeImage[@name='alert_sdcard_white']/../XCUIElementTypeButton"));}
    public UIHelper cameraTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvTitle')]"),null);}
    public UIHelper pauseClick()  throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'ivPlayPause')]"),null);}
    public UIHelper videoformat()  throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'rlResolutionPortrait')]"),null);}
    public UIHelper videoFormatSelect()  throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvNormal')]"),null);}
    public UIHelper selectPIP()  throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'imageSuspend')]"),null);}
    public UIHelper cameraPIP() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@text, '"+app.lang.getProperty("camera_PIP")+"')]"),null);}
    public UIHelper noonlightIcon() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivE911')]"),By.xpath("ios"));}
    public UIHelper emergencyTitle() throws Exception{ return app.setBy(By.xpath("//android.widget.TextView[contains(@resource-id, 'tvTitle')]"),By.xpath("ios"));}
    public UIHelper seekbar() throws Exception{ return app.setBy(By.xpath("//android.view.View[contains(@resource-id,'horizontalVideoSeekBar')]"),By.xpath("ios"));}

    public UIHelper liveBtn() throws Exception{
        int livButtonIndex=1;
        if(app.isIOS()){
            if(app.setBy(By.xpath(""),By.xpath("//XCUIElementTypeButton[@name='Live']")).getAll().size()>1){
                livButtonIndex=2;
            }
        }
        return app.setBy(By.xpath("//*[contains(@resource-id,'gobacklive')]"),By.xpath("(//XCUIElementTypeButton[@name='Live'])["+livButtonIndex+"]"));
    }

    @Step("Click on Alert tab")
    public void clickOnActivityTab() throws Exception {
        log.info("Click on Alert tab");
        if(app.isIOS())
            activityTab().tapios();
		else {
			rotateLoadingIcon().waitForDisappear();
			activityTab().safeClick();
			log.info("Clicked on activity tab");
		}
    }

    @Step("Click on Video Player Tips")
    public void clickOnVideoPlayerTips() throws Exception {
        log.info("Click on Video Player Tips");
        videoPlayerTips().click();
    }

    @Step("Verify Micro icon displayed")
    public void verifyMicroIconDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Micro icon displayed");
        Assert.assertTrue(microIcon().isElementPresent(25), "Micro icon is missing");
    }

    @Step("Click on Micro icon")
    public void clickOnAMicroIcon() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Click on Micro icon");
        microIcon().click();
    }

    @Step("Click on Back")
    public void clickOnBack() throws Exception {
        log.info("Click on Back icon");
        backIcon().click();
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Rate size display KB/s icon visible")
    public void verifyRateSizeKBsIconDisplayed() throws Exception {
        log.info("Verify Rate size display KB/s icon visible");
        Assert.assertTrue(rateSizeKBsIcon().isElementPresent(5), "Rate size display KB/s icon is missing");
    }

    @Step("Verify Camera is turned off")
    public void verifyCameraIsTurnedOff() throws Exception {
        log.info("Verify Camera is turned off");
        if(app.isIOS()){
            cameraLiveViewPercentage().waitForDisappear();
        }
        Assert.assertTrue(turnedOffMessage().isElementPresent(15), "Camera is turned off message is not diplayed");
    }

    @Step("Click on Noon Light Button")
    public void verifyUserAbleToClickOnNoonLight() throws Exception {
        log.info("Click on Noon Light Button");
        noonLightButton().click();
        noonLightCancelButton().click();
    }


    @Step("Click on resolution")
    public void verifyUserAbleToClickOnResolution() throws Exception {
        log.info("Click on resolution");
        if(!resolutionDropDown().isElementPresent()){
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
        resolutionDropDown().click();
        resolutionDropDown().waitForDisappear();
        if(!resolutionDropDown().isElementPresent()){
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
        resolutionSDorHD().click();
        resolutionSDorHD().waitForDisappear();
        if(!resolutionDropDown().isElementPresent()){
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
        String selectedValue=resolutionDropDown().getAttribute("name");
        Assert.assertTrue((selectedValue.equals("HD") || selectedValue.equals("SD")),"No able to Select resolution");
    }
    @Step("Click on play/pause")
    public void clickOnPlayAndPause() throws Exception {
        log.info("Click on play/pause");
        if(!playAndPauseButton().isElementPresent()){
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
        playAndPauseButton().click();
        Thread.sleep(3000);
        cameraLiveViewPercentage().waitForDisappear();
        Thread.sleep(3000);
    }

    @Step("Click on previous")
    public void clickOnPrevious() throws Exception {
        log.info("Click on previous");
        if(!previousButton().isElementPresent()){
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
        if(previousButton().isElementPresent()) {
            previousButton().click();
            loadingProgressBar().waitForDisappear();
            Thread.sleep(6000);
            liveBtn().click();
            loadingProgressBar().waitForDisappear();
            app.scrollSlowlyByScreenRatio(UIHelper.ScrollDirection.DOWN,.3,.3);
        }
    }

    @Step("Click on capture button")
    public void clickOnCapture() throws Exception {
        log.info("Click on capture button");
        captureButton().click();
    }

    @Step("Click on Full view capture button")
    public void clickOnFullViewCapture() throws Exception {
        log.info("Click on Full view capture button");
        fullViewCaptureButton().click();
        if(allowAccessToPhotosButton().isElementPresent()) {
            allowAccessToPhotosButton().click();
            fullViewCaptureButton().click();
        }
    }

    @Step("Click on View Album and navigate back")
    public void clickOnViewAlbumAndNavigateBack() throws Exception {
        log.info("Click on View Album and navigate back");
        clickOnViewAlbum();
        Thread.sleep(5000);
        new AlbumScreen(app).clickOnBackButton();
    }

    @Step("Click on view Album")
    public void clickOnViewAlbum() throws Exception {
        log.info("Click on view Album");
        viewAlbumButton().click();
    }

    @Step("Click on Record stop button")
    public void clickOnStopRecord() throws Exception {
        log.info("Click on Record stop button");
        stopRecordButton().click();
    }

    @Step("Click on Record button")
    public void clickOnRecord() throws Exception {
        log.info("Click on Record button");
        recordButton().click();
    }

    @Step("CVR Controls")
    public void verifyUserAbleToClickCVRControls() throws Exception {
        log.info("CVR Controls");
        clickOnPlayAndPause();
        clickOnPlayAndPause();
        clickOnPrevious();
        clickOnCapture();
        if(allowAccessToPhotosButton().isElementPresent()){
            allowAccessToPhotosButton().click();
            clickOnCapture();
        }
        clickOnViewAlbumAndNavigateBack();
        clickOnRecord();
        Thread.sleep(5000); // for recording video
        clickOnStopRecord();
    }

    @Step("Verify Call back Audio Working")
    public void verifyUserAbleToClickOnCallBackAudio() throws Exception {
        log.info("Verify Call back Audio Working");
        cbAudio().click();
        if(app.isIOS()) {
            Assert.assertTrue(cbAudio().getValue().equalsIgnoreCase("1"), "Live view Audio is not turned on");
            cbAudio().click();
        }
    }


    @Step("Click Full View")
    public void clickOnFullView() throws Exception {
      rotateLoadingIcon().waitForDisappear();
        log.info("Click Full View");
        if(app.isIOS()){
            fullViewButton().tapios();
        }else {
            fullViewButton().safeClick();
        }
    }

    @Step("Click on Full View Talk Back")
    public void clickOnFullViewTalkBack() throws Exception {
        log.info("Click on Full View Talk Back");
        fullViewTalkBackButton().click();
        if(app.setBy(null,app.alertOKButton).isElementPresent()) {
            app.acceptAlertOK();
            if(fullViewTalkBackButton().isElementPresent())
            fullViewTalkBackButton().click();
        }
        Thread.sleep(3000);
        cameraLiveViewPercentage().waitForDisappear();
        Thread.sleep(3000);
    }

    @Step("Click on Full View Stop Talk Back")
    public void clickOnFullViewStopTalkBack() throws Exception {
        log.info("Click on Full View Stop Talk Back");
        if(fullViewStopTalkBackButton().isElementPresent())
        fullViewStopTalkBackButton().click();
    }

    @Step("Verify Talk Back Functionality")
    public void verifyFullViewTalkBack() throws Exception {
        log.info("Click FullView Talk Back");
        clickOnFullViewTalkBack();
        if(app.isIOS()) {
           // Assert.assertTrue(cbAudio().getValue().equalsIgnoreCase("1"), "Live view Audio is not turned on");
        }
        clickOnFullViewStopTalkBack();
        if(app.isIOS()) {
           // Assert.assertTrue((cbAudio().getValue()==null || cbAudio().getValue().equalsIgnoreCase("")), "Live view Audio is not turned off");
        }
    }

    @Step("Click on Full View Record")
    public void clickOnFullViewRecord() throws Exception {
        log.info("Click on Full View Record");
        fullViewRecordButton().click();
        app.acceptAlert();
    }

    @Step("Click on Full View Stop Record")
    public void clickOnFullViewStopRecord() throws Exception {
        log.info("Click on Full View Stop Record");
        fullViewStopRecordButton().click();
    }

    @Step("Verify Record Functionality")
    public void verifyFullViewRecord() throws Exception {
        log.info("Verify Record Functionality");
        clickOnFullViewRecord();
        clickOnFullViewStopRecord();
    }

    @Step("Click on Full view Back Button")
    public void clickOnFullViewBackButton() throws Exception {
        log.info("Click on Full view Back Button");
        fullViewBackButton().click();
    }
    
	@Step("select video format")
	public void selectVideoFormat() throws Exception {
		log.info("select dropdown list of video format");
		videoformat().click();
		log.info("select normal mode option (SD)  of video format");
		videoFormatSelect().safeClick();
		log.info("selected normal mode option (SD)  of video format");
	}
	
	@Step("play/pause video")
	public void pauseVideo() throws Exception {
		cameraTitle().click();
		log.info("clicking on play/pause button");
		
		try {
			 pauseClick().safeClick();
		} catch (StaleElementReferenceException e) {
			pauseClick().safeClick();
		}
		log.info("clicked on play/pause button");
	}
	
	@Step("verify PIP controller")
	public void verifyPIPcontroller() throws Exception
	{
		log.info("select PIP controller");
		assertTrue(selectPIP().isElementPresent(), "PIP option is visible");
		log.info("PIP controller visible");
		selectPIP().click();
		rotateLoadingIcon().waitForDisappear();
	}
	
	@Step("Move time line")
    public void moveTimeline() throws Exception {
        cameraLiveViewPercentage().waitForDisappear();
        WebElement timeLineElement = seekbar().getElement();
        int timeLineXLocation=timeLineElement.getLocation().getX();
        int timeLineYLocation=timeLineElement.getLocation().getY()+50;
        int timeLineElementHeight=timeLineElement.getSize().getHeight();
        int timeLineElementWidth=timeLineElement.getSize().getWidth();
        app.swipeByCordinates(timeLineXLocation, timeLineYLocation + (timeLineElementHeight / 2), timeLineXLocation + timeLineElementWidth, timeLineYLocation + (timeLineElementHeight / 2));

    }
	
	@Step("Verify Noonlight Controller")
	public void verifyNoonlightController() throws Exception
	{
        cameraLiveViewPercentage().waitForDisappear();
        log.info("Verify & Click Noonlight Controller");
		assertTrue(noonlightIcon().isElementPresent(10), "Noonlight Controller is not visible");
		noonlightIcon().click();
		log.info("Verify 24/7 emergency page is displayed");
		rotateLoadingIcon().waitForDisappear();
		assertTrue(emergencyTitle().isElementPresent(10), "24/7 emergency page is not visible");
	}
}
