package com.kamivision.testcases;

import com.kamivision.screens.common.*;
import com.kamivision.screens.common.accounts.profile.ChangePasswordScreen;
import com.kamivision.screens.common.accounts.profile.ProfileScreen;
import com.kamivision.screens.common.accounts.profile.profileaccount.ProfileAccountScreen;
import com.kamivision.screens.common.addcamera.AddCameraScreen;
import com.kamivision.screens.common.alerts.AlertsScreen;
import com.kamivision.screens.common.cloud.CloudScreen;
import com.kamivision.screens.common.windows.WindowsScreen;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import utilities.TestListener;
import utilities.UIHelper;

@Listeners(TestListener.class)
@Log4j2
public class yi_iot {

    LoginScreen loginScreen;
    HomeScreen homeScreen;
    AccountScreen accountScreen;
    StoreScreen storeScreen;
    SignUpScreen signUpScreen;
    ProfileScreen profileScreen;
    ProfileAccountScreen profileAccountScreen;
    ChangePasswordScreen changePasswordScreen;
    AddCameraScreen addCameraScreen;
    SettingsScreen settingsScreen;
    CameraScreen cameraScreen;
    WindowsScreen windowsScreen;
    AlertsScreen alertsScreen;
    CloudScreen cloudScreen;
    UIHelper app;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        app                     = new UIHelper();
        loginScreen             = new LoginScreen(app);
        homeScreen              = new HomeScreen(app);
        signUpScreen            = new SignUpScreen(app);
        accountScreen           = new AccountScreen(app);
        storeScreen             = new StoreScreen(app);
        changePasswordScreen    = new ChangePasswordScreen(app);
        profileScreen           = new ProfileScreen(app);
        settingsScreen          = new SettingsScreen(app);
        profileAccountScreen    = new ProfileAccountScreen(app);
        addCameraScreen         = new AddCameraScreen(app);
        cameraScreen            = new CameraScreen(app);
        windowsScreen           = new WindowsScreen(app);
        alertsScreen            = new AlertsScreen(app);
        cloudScreen             = new CloudScreen(app);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() throws InterruptedException {
        app.quitDriver();
    }

    @AfterMethod(groups = {"Single_Smoke","en_locale"})
    public void relaunchApp() throws Exception {
        app.relaunchApp();
        homeScreen.relaunchLogout();
    }

    @Link("https://kami-vision.atlassian.net/browse/IOSAPP-408")
    @Test(enabled = true, description = "")
    public void test() throws Exception {
        log.info("--test--");
        loginScreen.selectRegion();
        loginScreen.login();
        Thread.sleep(100000);








//*[@resource-id="com.yunyi.smartcamera:id/ivDeploy"]

        // //*[@resource-id="com.yunyi.smartcamera:id/tvSignIn"]
//  //*[@resource-id="com.yunyi.smartcamera:id/tvAreaSelectContinue"]


        //*[@text="Enter email"]

        //*[@text="Enter password"]


        // 6 left swipe
        // //*[@resource-id="com.android.permissioncontroller:id/permission_allow_button"]



        // //*[@resource-id="com.yunyi.smartcamera:id/vfHome"]//*[@password="false"]
        // ok buttob
        // ok button


        //Map<String, Object> params = new HashMap<>();params.put("label", "OK");driver.executeScript("mobile:button-text:click", params);



    }
}
