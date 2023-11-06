package com.kamivision.testcases;

import lombok.extern.log4j.Log4j2;
import utilities.TestListener;
import utilities.UIHelper;
import com.kamivision.screens.common.*;
import io.qameta.allure.Link;
import org.testng.annotations.*;
@Listeners(TestListener.class)
@Log4j2
public class AccountTests {

    LoginScreen loginScreen;
    HomeScreen homeScreen;
    UIHelper app;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        app                     = new UIHelper();
        loginScreen             = new LoginScreen(app);
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

    @Link("https://kami-vision.atlassian.net/browse/ANDR-695")
    @Link("https://kami-vision.atlassian.net/browse/IOSAPP-408")
    @Test(enabled = true, description = "ANDR-695 YI/Kami app - Discover(Account) -  Store Verification", groups = {"Single_Smoke","en_locale"}, priority = 0)
    public void ANDR_695_AccountStoreVerification() throws Exception {
        log.info("----ANDR_695_AccountStoreVerification--");
        String regionUSA = app.props.getProperty("regionUSA");
        loginScreen.selectRegion(regionUSA);
        loginScreen.verifyRegionSelected(regionUSA);
        loginScreen.skipOnBoarding();
        loginScreen.login();
    }

}
