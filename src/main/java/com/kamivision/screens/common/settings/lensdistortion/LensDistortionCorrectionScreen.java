package com.kamivision.screens.common.settings.lensdistortion;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.UIHelper;

@Log4j2
public class LensDistortionCorrectionScreen {
    private final UIHelper app;
    public LensDistortionCorrectionScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper rotateLoadingIcon() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'rotateloading')]"), By.xpath("//XCUIElementTypeStaticText[@name='"+app.lang.getProperty("system_loading")+"']"));}
    public UIHelper adjustLendsDistortionRange() throws Exception{ return app.setBy(By.xpath("//android.widget.LinearLayout[contains(@resource-id, 'llLdcModePercent')]"), By.xpath("//XCUIElementTypeStaticText[@name=\""+app.lang.getProperty("CameraOtherSetting_1451384669_8")+"\"]"));}
    public UIHelper adjustLendsDistortionSeekBar() throws Exception{ return app.setBy(By.xpath("//android.widget.SeekBar[contains(@resource-id, 'ldcModePercentSeekBar')]"), By.xpath("//XCUIElementTypeSlider[contains(@value, '%')]"));}

    @Step("Verify Adjust Lens Distortion Range displayed")
    public void verifyAdjustLendsDistortionRangeDisplayed() throws Exception {
        rotateLoadingIcon().waitForDisappear();
        log.info("Verify Adjust Lens Distortion Range displayed");
        Assert.assertTrue(adjustLendsDistortionRange().isElementPresent(10),
                "Adjust Lens Distortion Range is not displayed");
        Assert.assertTrue(adjustLendsDistortionSeekBar().isElementPresent(10),
                "Adjust Lens Distortion Seek bar is not displayed");
    }

    @Step("Click on middle point of Adjust Lens Distortion Range")
    public void clickOnMiddlePointOfAdjustLendsDistortionRange() throws Exception {
        log.info("Verify Adjust Lens Distortion Range displayed");
        if(app.isIOS()){
            adjustLendsDistortionSeekBar().getElement().sendKeys(".5");
            Thread.sleep(2000);
        }else {
            adjustLendsDistortionSeekBar().click();
        }
        rotateLoadingIcon().waitForDisappear();
    }

    @Step("Verify Adjust Lens Distortion Range value updated")
    public void verifyAdjustLendsDistortionRangeValueIsUpdated() throws Exception {
        log.info("Verify Adjust Lens Distortion Range value = 50");
        rotateLoadingIcon().waitForDisappear();
        String point="";
        if(app.isIOS()){
            point = adjustLendsDistortionSeekBar().getValue();
            int value=Integer.parseInt(point.substring(0,2));
            if(value>=45 && value<=50){
                point="50";
            }
        }else {
             point = adjustLendsDistortionSeekBar().getText();
        }
        log.info("point = " + point);
        Assert.assertTrue(point.contains("50"), "Adjust Lens Distortion Range is not correct");
    }
}
