package com.kamivision.testcases.web;

import java.net.MalformedURLException;
import org.testng.annotations.*;
import com.kamivision.screens.common.web.HomeScreenWeb;
import com.kamivision.screens.common.web.LoginScreenWeb;
import io.qameta.allure.Link;
import lombok.extern.log4j.Log4j2;
import utilities.TestListener;
import utilities.UIHelper;

@Listeners(TestListener.class)
@Log4j2

public class WebKamiCloudLaunchLogin {

    UIHelper app;
    LoginScreenWeb loginScreenWeb;
    HomeScreenWeb homeScreenWeb;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        app = new UIHelper();
        loginScreenWeb = new LoginScreenWeb(app);
        homeScreenWeb = new HomeScreenWeb(app);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        app.quitDriver();
    }

    @AfterMethod(alwaysRun = true, groups = { "Single_Smoke", "web_KamiCloud", "en_locale" })
    public void closeDriver() throws InterruptedException, MalformedURLException {
        app.quitDriver();
    }

    @Link("https://kami-vision.atlassian.net/browse/WKC-47")
    @Link("https://kami-vision.atlassian.net/browse/WKC-35")
    @Link("https://kami-vision.atlassian.net/browse/WKC-31")
    @Test(description = "Launch Web Kamicloud , Login", groups = {"Single_Smoke","web_KamiCloud", "en_locale"})
    public void webKamiCloudLaunchLogin() throws Exception {
        log.info("--WKC-47,WKC-35 -- _verifyWebkamiCloudPlan--");
        log.info("Logged in with user on web kami cloud site");
        loginScreenWeb.loginWithCredentials(app.props.getProperty("pwebUserName"), app.props.getProperty("pwebPassword"));
        log.info("web kami cloud site logged in successfully!");
        log.info("Logout user");
        loginScreenWeb.logout().click();
        log.info("Logout user is successful!");
    }
}