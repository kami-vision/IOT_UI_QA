package com.kamivision.screens.common;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class CloudServiceScreen {
    private final UIHelper app;
    public CloudServiceScreen(UIHelper app) {
        this.app=app;
    }

    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"),By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper manageBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tv_cloud_btn')]"),By.xpath("//*[@name='Manage Plans'][1]"));}
    public UIHelper myDetailsPlans() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'My Plans')]//following-sibling::*//*[descendant::*[contains(@text,'Active')] and descendant::*[contains(@text,'SERVICE TILL')] and descendant::*[contains(@text,'SERVICE FROM')] and descendant::*[contains(@text,'NEXT PAYMENT')]]"),By.xpath("ios"));}
    public UIHelper managePlanBtn() throws Exception{ return app.setBy(By.xpath("(//*[contains(@text,'Manage')])[1]"), By.xpath("ios"));}
    public UIHelper keepPlanBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Keep Plan']"), By.xpath("ios"));}
    public UIHelper cancelPlanBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Cancel Plan']"), By.xpath("ios"));}
    public UIHelper orderHistoryBtn() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Order History')]"), By.xpath("ios"));}
    public UIHelper orderTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvTitle') and @text='Order']"), By.xpath("ios"));}
    public UIHelper orderHistory() throws Exception{ return app.setBy(By.xpath("//android.view.View[descendant::*[contains(@text,'ORDER #')] and descendant::*[contains(@text,'USD $11.99')] and descendant::*[contains(@text,'Purchase Date')]]"), By.xpath("ios"));}
    public UIHelper paymentBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Payment Methods']"), By.xpath("ios"));}
    public UIHelper paymentMethodTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id,'tvTitle') and @text='Payment Methods']"), By.xpath("ios"));}
    public UIHelper defaultCard() throws Exception{ return app.setBy(By.xpath("//*[@index=0 and @text='****5936']"), By.xpath("ios"));}
    public UIHelper removeCardBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Remove card']"), By.xpath("ios"));}
    public UIHelper cardNumberLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Card number*')]"), By.xpath("ios"));}
    public UIHelper emailLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Email*')]"), By.xpath("ios"));}
    public UIHelper nameOnCardLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Name on card')]"), By.xpath("ios"));}
    public UIHelper zipCodeLabel() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Zipcode*')]"), By.xpath("ios"));}
    public UIHelper renewPlanBtn() throws Exception{ return app.setBy(By.xpath("(//*[contains(@text,'My Plans')]//following-sibling::*//*[contains(@text,'RENEW PLAN')])[1]"), By.xpath("ios"));}
    public UIHelper cancelPlanMessage() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'sorry to see you go.')]"), By.xpath("ios"));}
    public UIHelper reasonCheckbox() throws Exception{ return app.setBy(By.xpath("//android.widget.CheckBox[1]"), By.xpath("ios"));}
    public UIHelper nextBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Next']"), By.xpath("//*[@name='Next']"));}
    public UIHelper activePlan() throws Exception{ return app.setBy(By.xpath("//android.widget.ListView//android.view.View[descendant::*[@text='Active']]"), By.xpath("//*[contains(@name,'0 of 1')]"));}
    public UIHelper cameraInActivePlan() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'cameras')]"), By.xpath("//*[contains(@name,'of 5')]"));}
    public UIHelper cameraCheckbox() throws Exception{ return app.setBy(By.xpath("//android.view.View[@text='cameraName']//following-sibling::android.widget.CheckBox"), By.xpath("ios"));}
    public UIHelper emptyCamerasCountInActivePlan() throws Exception{ return app.setBy(By.xpath("//android.widget.ListView//android.view.View[descendant::*[@text='Active']]//*[contains(@text,'0 of 5 cameras added')]"), By.xpath("//*[contains(@name,'of 5')]"));}
    public UIHelper checkAddedCamera() throws Exception{ return app.setBy(By.xpath("//android.widget.CheckBox[@checked='true']"), By.xpath("ios"));}
    public UIHelper backButton() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"),By.xpath("//XCUIElementTypeButton[@name='yh ic nav back']"));}
    public UIHelper manageCloudPlanTitle() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'My Plans')]"), By.xpath("//XCUIElementTypeNavigationBar[@name='Manage Plan']"));}
    public UIHelper expiredPlan() throws Exception{ return app.setBy(By.xpath("//*[contains(@text,'Plan Expired')]"), By.xpath("//XCUIElementTypeNavigationBar[@name='Manage Plan']"));}
    public UIHelper backButtonOnAddCameraPlan() throws Exception{ return app.setBy(By.xpath("//android.widget.ImageView[contains(@resource-id, 'ivNavigation')]"),By.xpath("//XCUIElementTypeButton[@name='back arrow white']"));}
    public UIHelper confirmBtn() throws Exception{ return app.setBy(By.xpath("//*[@text='Confirm']"), By.xpath("//*[@name='Confirm']"));}
    @Step("Click Manage button")
    public void clickManage() throws Exception {
        log.info("Click Manage button");
        if(app.isAndroid()) {
            manageBtn().scroll(UIHelper.ScrollDirection.UP);
        }
            manageBtn().click();
            rotateLoadingIcon().waitForDisappear();
    }
    
    @Step("Verify expired plan")
    public void verifyExpiredPlan() throws Exception {
        log.info("Verify expired plan");
        if(app.isAndroid()) {
            Assert.assertTrue(manageCloudPlanTitle().isElementPresent(15), "CloudPlanTitle is not displayed");
            Assert.assertTrue(expiredPlan().isElementPresent(15));
        }
    }
    
    @Step("Verify all purchased plan details")
    public void verifyCloudPlanOption() throws Exception {
        log.info("Verify all purchased plan details");
        if(app.isAndroid()) {
            Assert.assertTrue(myDetailsPlans().isElementPresent(15), "Detailed plan is not displayed");
            Assert.assertTrue(managePlanBtn().isElementPresent(15), "Manage Plan button is not displayed");
        }
    }

    @Step("Click Manage Plan button")
    public void clickManagePlanButton() throws Exception {
        log.info("Click Manage Plan button");
        if(app.isAndroid()) {
            log.info("Manage Plan button is displayed: " + orderHistoryBtn().isElementPresent(5));
            managePlanBtn().safeClick();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify Active plans has option of Manage plan, User can either keep or cancel plan from here.")
    public void verifyKeepAndCancelPlanVisibility() throws Exception {
        log.info("Verify all purchased plan details");
        if(app.isAndroid()) {
            Assert.assertTrue(keepPlanBtn().isElementPresent(15), "Keep plan is not displayed");
            Assert.assertTrue(cancelPlanBtn().isElementPresent(15), "Cancel plan button is not displayed");
        }
    }

    @Step("Click order history")
    public void clickOrderHistory() throws Exception {
        log.info("Click order history");
        if(app.isAndroid()) {
            Thread.sleep(5000);
            log.info("Order history button is displayed: " + orderHistoryBtn().isElementPresent(5));
            orderHistoryBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify purchased order plans history")
    public void verifyPurchasedOrderPlansHistory() throws Exception {
        log.info("Verify purchased order plans history");
        if(app.isAndroid()) {
            Assert.assertTrue(orderTitle().isElementPresent(15), "Order title is not displayed");
            Assert.assertTrue(orderHistory().isElementPresent(15), "Order history is not displayed");
        }
    }

    @Step("Click payment")
    public void clickPayment() throws Exception {
        log.info("Click payment");
        if(app.isAndroid()) {
            Thread.sleep(5000);
            log.info("Order history button is displayed: " + paymentBtn().isElementPresent(5));
            paymentBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify payment method title")
    public void verifyPaymentMethodTitle() throws Exception {
        log.info("Verify payment method title");
        if(app.isAndroid()) {
            Assert.assertTrue(paymentMethodTitle().isElementPresent(15), "Payment methods title is not displayed");
            Assert.assertTrue(defaultCard().isElementPresent(15), "Default card is not displayed");
        }
    }

    @Step("Click default card")
    public void clickDefaultCard() throws Exception {
        log.info("Click default card");
        if(app.isAndroid()) {
            Thread.sleep(5000);
            defaultCard().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify it should display card detail. User should be able edit Card information like email , Name and Zipcode")
    public void verifyDefaultCardDetails() throws Exception {
        log.info("Verify it should display card detail. User should be able edit Card information like email , Name and Zipcode");
        if(app.isAndroid()) {
            Assert.assertTrue(removeCardBtn().isElementPresent(15), "Remove card button is not displayed");
            Assert.assertTrue(cardNumberLabel().isElementPresent(15), "Card number is not displayed");
            Assert.assertTrue(nameOnCardLabel().isElementPresent(15), "Name card is not displayed");
            Assert.assertTrue(zipCodeLabel().isElementPresent(15), "Zip code is not displayed");
        }
    }

    @Step("Tap on keep plan")
    public void tapKeepPlanButton() throws Exception {
        log.info("Tap on keep plan");
        if(app.isAndroid()) {
            keepPlanBtn().click();
        }
    }

    @Step("Tap on cancel plan")
    public void tapCancelPlanButton() throws Exception {
        log.info("Tap on cancel plan");
        if(app.isAndroid()) {
            cancelPlanBtn().safeClick();
        }
    }

    @Step("Select cancel reason")
    public void selectCancelReason() throws Exception {
        log.info("Select cancel reason");
        if(app.isAndroid()) {
            reasonCheckbox().click();
        }
    }

    @Step("Verify cancel plan message is displayed")
    public void verifyCancelMessagePlanIsDisplayed() throws Exception {
        log.info("Verify cancel plan message is displayed");
        if(app.isAndroid()) {
            Assert.assertTrue(cancelPlanMessage().isElementPresent(15), "Payment methods title is not displayed");
        }
    }

    @Step("Verify all purchased plan status after cancelling before expire date")
    public void verifyCloudPlanStatusAftẹrCancellingBeforeExpireDate() throws Exception {
        log.info("Verify all purchased plan status after cancelling before expire date");
        if(app.isAndroid()) {
            Assert.assertTrue(myDetailsPlans().isElementPresent(15), "Detailed plan is not displayed");
        }
    }

    @Step("Tap on renew plan button")
    public void tapOnRenewPlan() throws Exception {
        log.info("Tap on renew plan button");
        if(app.isAndroid()) {
            renewPlanBtn().click();
        }
    }

    @Step("Add two camera {0} into the active plan")
    public void addCameras(String camera) throws Exception {
        log.info("Add camera by name into the active plan");
        if(app.isAndroid()) {
        	rotateLoadingIcon().waitForDisappear();
        	Thread.sleep(5000);
            rotateLoadingIcon().waitForDisappear();
        	log.info("Click add camera arrow on the active plan");
            cameraInActivePlan().safeClick();
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(5000);
            log.info("Check if camera is checked");
            By locator = By.xpath(String.format(
                            "//android.view.View[@text='%s']//following-sibling::android.widget.CheckBox",
                            camera));
            String checkStatus = app.setBy(locator,null).getAttribute("checked");
            if (!Boolean.parseBoolean(checkStatus)) {
                log.info("Select camera");
                Thread.sleep(2000);
                app.setBy(locator, null).safeClick();
                Thread.sleep(2000);
            } else {
                log.info("Camera is selected");
            }
        } else {
            log.info("Click add camera arrow on the active plan");
            Thread.sleep(3000);
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(3000);
            if(app.setBy(null, By.xpath("//XCUIElementTypeStaticText[@name='" + camera + "']/../following-sibling::XCUIElementTypeSwitch")).getAttribute("value").equals("0"))
            app.setBy(null, By.xpath("//XCUIElementTypeStaticText[@name='" + camera + "']/../following-sibling::XCUIElementTypeSwitch")).click();
        }
    }

    @Step("Click next button")
    public void clickNext() throws Exception {
        log.info("Click next button");
        if(app.isAndroid()) {
        	rotateLoadingIcon().waitForDisappear();
            nextBtn().safeClick();
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(2000);
        } else{
                nextBtn().click();
                rotateLoadingIcon().waitForDisappear();
        }
    }

    @Step("Verify camera is added")
    public void verifyCameraIsAdded() throws Exception {
        log.info("Verify camera is added");
        if(app.isAndroid()) {
            log.info("Verify camera is added");
            rotateLoadingIcon().waitForDisappear();

            Assert.assertTrue(cameraInActivePlan().getText().contains("1 of 5"), "Camera is not added");
        } else{
            Assert.assertTrue(emptyCamerasCountInActivePlan().isElementPresent(15), "Cameras count is not correct");
        }
        rotateLoadingIcon().waitForDisappear();
    }


    @Step("Remove camera from the active plan")
    public void removeCamera(String camera) throws Exception {
        log.info("Remove camera from the active plan");
        if(app.isAndroid()) {
            Thread.sleep(3000);
            rotateLoadingIcon().waitForDisappear();
            log.info("Click camera label");
            Thread.sleep(5000);
            cameraInActivePlan().safeClick();
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(5000);
            app.setBy(By.xpath("//android.view.View[@text='"+camera+"']//following-sibling::android.widget.CheckBox"), null).safeClick();
            log.info("Unselect camera");
            try {
                String checkStatus = app.setBy(
                        By.xpath(String.format(
                                "//android.view.View[@text='%s']//following-sibling::android.widget.CheckBox",
                                camera)),null).getAttribute("checked");
                
                if (Boolean.parseBoolean(checkStatus)) {
                	 Thread.sleep(3000);
                	 app.safeClick();                   
                }
               String Y20CheckStatus = app.setBy(
                        By.xpath(String.format(
                                "//android.view.View[@text='%s']//following-sibling::android.widget.CheckBox",
                                "Y20")),null).getAttribute("checked");
                if (Boolean.parseBoolean(Y20CheckStatus)) {
                    app.safeClick();
                }
            } catch (Exception e) {}
        } else {
            log.info("Remove camera arrow on the active plan");
            Thread.sleep(3000);
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(3000);
            if(app.setBy(null, By.xpath("//XCUIElementTypeStaticText[@name='" + camera + "']/../following-sibling::XCUIElementTypeSwitch")).getAttribute("value").equals("1"))
            app.setBy(null, By.xpath("//XCUIElementTypeStaticText[@name='" + camera + "']/../following-sibling::XCUIElementTypeSwitch")).click();
        }
    }


    @Step("Deselect All Cameras")
    public void deSelectAllCameras() throws Exception {
        log.info("De select all cameras");
        if(cameraInActivePlan().isElementPresent(10))
        {
        	if(app.isIOS()) 
            cameraInActivePlan().tapios();
        	else
        		 cameraInActivePlan().click();
        }
        else {
        	if(app.isIOS())
            emptyCamerasCountInActivePlan().tapios();
        	else
        		 emptyCamerasCountInActivePlan().click();
        }
        int numberOfCameras=app.setBy(By.xpath("//android.widget.Image"),By.xpath("//XCUIElementTypeSwitch")).getAll().size();
        for(int i=1;i<=numberOfCameras;i++){
        	if(app.isIOS())
        	{
            if( app.setBy(null,By.xpath("(//XCUIElementTypeSwitch)["+i+"]")).getAttribute("value").equals("1"))
                app.setBy(null,By.xpath("(//XCUIElementTypeSwitch)["+i+"]")).click();
        	}
        	if(app.isAndroid())
        	{
        		 if( app.setBy(By.xpath("(//android.view.View/android.view.View//following-sibling::android.widget.CheckBox)["+i+"]"),null).getAttribute("checked").equals("true"))
                     app.setBy(By.xpath("( //android.view.View/android.view.View//following-sibling::android.widget.CheckBox)["+i+"]"),null).click();
        	}
        }
    }
    
    @Step("Verify camera is removed")
    public void verifyCameraIsRemoved() throws Exception {
        if(app.isAndroid()) {
            log.info("Verify camera is removed");
            rotateLoadingIcon().waitForDisappear();
            Assert.assertTrue(cameraInActivePlan().getText().contains("0 of 5"), "Cameras is not removed");
        } else{
            Assert.assertTrue(cameraInActivePlan().isElementPresent(15), "Cameras is not removed");
        }
    }

    @Step("Check if cameras have already been added into the active plan")
    public boolean checkIfCameraIsAdded() throws Exception {
        log.info("Check camera added in active plan");
        String count = cameraInActivePlan().getText();
        log.info("Check status: " + count);
        if (count.contains("1 of 1")) {
            return true;
        } else {
            log.info("Camera has not been added.");
            return false;
        }
    }
    
    @Step("Set Camera State As Per Use Case")
    public void setCameraState(String cameraName,Boolean cameraState) throws Exception {
    	if(app.isAndroid()) {
    		if (cameraState) {
        		addCameras(cameraName);
    			clickNext();
    			app.navigateBack();
    		}else {
    			removeCamera(cameraName);
    			clickNext();
    			app.navigateBack();
    		}
    	}
    }
    
    @Step("Restore Camera State To Default")
    public void restoreCameraState(String cameraName,Boolean InitialState) throws Exception {
    	if(app.isAndroid()) {
    		clickManage();
    		Boolean CurrentState=checkIfCameraIsAdded(cameraName);
    		if (CurrentState ^ InitialState) {
    			if (InitialState && !CurrentState) {
    				addCameras(cameraName);
    				clickNext();
    			} else {
    				removeCamera(cameraName);
    				clickNext();
    			}
    		}
    	}
    }
    
    @Step("Check if particular camera have already been added into the active plan")
    public boolean checkIfCameraIsAdded(String camera) throws Exception {
        log.info("Check camera added in active plan");
        Boolean checkStatus=false;
        if(app.isAndroid()) {
            log.info("Click add camera arrow on the active plan");
            rotateLoadingIcon().waitForDisappear();
            cameraInActivePlan().safeClick();
            rotateLoadingIcon().waitForDisappear();
            log.info("Check if camera is checked");
            By locator = By.xpath(String.format(
                            "//android.view.View[@text='%s']//following-sibling::android.widget.CheckBox",
                            camera));
            checkStatus = Boolean.parseBoolean(app.setBy(locator,null).getAttribute("checked"));
            if (checkStatus) {
                log.info("Camera already added to plan.");
            } else {
                log.info("Camera has not been added to plan.");
                }
            clickNext();
        }
        return checkStatus;
    }
    
    
	@Step("Add camera for new cloud user")
	public void verifyAnyCameraisPreAdded(String camera) throws Exception {
		rotateLoadingIcon().waitForDisappear();
		Thread.sleep(5000);
		rotateLoadingIcon().waitForDisappear();
		log.info("Click add camera arrow on the active plan");
		cameraInActivePlan().safeClick();
		rotateLoadingIcon().waitForDisappear();
		Thread.sleep(5000);
		if (checkAddedCamera().isElementPresent(5))
		{
			checkAddedCamera().safeClick();
		log.info("unselect camera");
		Thread.sleep(5000);
		}
		
		By locator = By.xpath(
				String.format("//android.view.View[@text='%s']//following-sibling::android.widget.CheckBox", camera));
		log.info("select camera");
		app.setBy(locator, null).safeClick();
		Thread.sleep(5000);
	}
	
	@Step("Verify Camera active lable on manage plan screen")
	public void verifycameraInActivePlanText() throws Exception
	{
		rotateLoadingIcon().waitForDisappear();
		 Assert.assertTrue(cameraInActivePlan().isElementVisible(15),"Cameras added is visible");
	}
	
	@Step("Add Cameras")
	public void addCameraAndroid(String camera) throws Exception {
		log.info("add cameras");
		if (cameraInActivePlan().isElementPresent(10)) {
			cameraInActivePlan().click();
			rotateLoadingIcon().waitForDisappear();
		}
		int numberOfCameras=app.setBy(By.xpath("//android.widget.Image"),By.xpath("//XCUIElementTypeSwitch")).getAll().size();
        for(int i=1;i<=numberOfCameras;i++){
        	if(app.isAndroid())
        	{
        		 if( app.setBy(By.xpath("(//android.view.View/android.view.View//following-sibling::android.widget.CheckBox)["+i+"]"),null).getAttribute("checked").equals("true"))
                     app.setBy(By.xpath("( //android.view.View/android.view.View//following-sibling::android.widget.CheckBox)["+i+"]"),null).click();
        	}
        }
		
        for(int i=1;i<=numberOfCameras;i++){
        		 if( app.setBy(By.xpath("(//*[contains(@text,'Y')])["+i+"]"),null).getAttribute("text").equals(camera))
                     app.setBy(By.xpath("( //android.view.View/android.view.View//following-sibling::android.widget.CheckBox)["+i+"]"),null).click();     	
        }
		
	}
    @Step("Click confirm button")
    public void clickConfirm() throws Exception {
        log.info("Click confirm button");
        if(app.isAndroid()) {
            rotateLoadingIcon().waitForDisappear();
            confirmBtn().safeClick();
            rotateLoadingIcon().waitForDisappear();
            Thread.sleep(2000);
        } else{
            confirmBtn().click();
            rotateLoadingIcon().waitForDisappear();
        }
    }
}
