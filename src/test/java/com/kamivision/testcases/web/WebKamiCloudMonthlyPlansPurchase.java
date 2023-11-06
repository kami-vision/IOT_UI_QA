package com.kamivision.testcases.web;

import com.kamivision.screens.common.web.CloudPlanWeb;
import com.kamivision.screens.common.web.HomeScreenWeb;
import com.kamivision.screens.common.web.LoginScreenWeb;
import io.qameta.allure.Link;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import utilities.TestListener;
import utilities.UIHelper;
import java.net.MalformedURLException;

@Listeners(TestListener.class)
@Log4j2

public class WebKamiCloudMonthlyPlansPurchase {
    UIHelper app;
    LoginScreenWeb loginScreenWeb;
    HomeScreenWeb homeScreenWeb;
    CloudPlanWeb cloudScreenWeb;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        app = new UIHelper();
        loginScreenWeb = new LoginScreenWeb(app);
        homeScreenWeb = new HomeScreenWeb(app);
        cloudScreenWeb = new CloudPlanWeb(app);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        app.quitDriver();
    }

    @AfterMethod(alwaysRun = true, groups = { "Single_Smoke", "web_KamiCloud", "en_locale" })
    public void closeDriver() throws InterruptedException, MalformedURLException {
        app.quitDriver();
    }

    @Link("https://kami-vision.atlassian.net/browse/WKC-63")
    @Test(description = "Purchase Monthly kami cloud plans- WKC-63", groups = {"Single_Smoke","web_KamiCloud", "en_locale"})
    public void webKamiCloudMonthlyPlansPurchase() throws Exception {
        log.info("Logged in with user on web kami cloud site");
        loginScreenWeb.loginWithCredentials(app.props.getProperty("pwebUserName"), app.props.getProperty("pwebPassword"));
        log.info("web kami cloud site logged in successful!");
        log.info("web kami cloud Monthly plan Purchase!");
        cloudScreenWeb.verifyMonthlyPlanPurchase();
        log.info("web kami cloud Monthly plan Purchase is successful!");
    }
}
