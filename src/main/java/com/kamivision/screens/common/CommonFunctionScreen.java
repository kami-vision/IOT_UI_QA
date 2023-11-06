package com.kamivision.screens.common;

import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.UIHelper;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class CommonFunctionScreen {
    private final UIHelper app;
    public CommonFunctionScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper disarmSettings()throws Exception{ return app.setBy(
            By.xpath("//*[@label='Disarm Passcode']"));}




public void verifyToastMessage(String message,int timeout)throws Exception{
        timeout=timeout*2;
        while(timeout>0) {
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("content", message);
                ((JavascriptExecutor) ((AppiumDriver) app.getDriver())).executeScript("mobile:text:find", params);
                timeout=0;
            }catch(Exception e){
                if(timeout==0){
                    throw new Exception("toast message not visible");
                }
                Thread.sleep(500);
                timeout--;
            }
        }

}

}
