package utilities;

import io.appium.java_client.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Log4j2
public class UIHelper {

	public Select sel;
    private  String execution;
    private  WebDriver driver ;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
    private  String platform ;

    public  DesiredCapabilities cap;
    public  Properties props;
    public  Properties lang;
    public String language;

    public  By by;
    public  int timeOut=15;

    public static SessionId sessionId;
    String siteLoginUrl;
	String browserMode;

    public String getExecution() {
        return execution;
    }

    public UIHelper() throws Exception {
        propertiesFileLoad();
        if(isAndroid()){
            Android_LaunchApp();
        }else if(isIOS()){
            iOS_LaunchApp();
        }else if(isWeb()){
        	webDriver();
			log.info("Web Driver Created");
        }else{
            log.error("Launch Method Not Yet implemented");
            throw new Exception("Launch Method Not Yet implemented");
        }
    }


    /**
     * this method loads properties files config and file having test data.
     *
     * @throws Exception property files are not loaded successfully
     */
    public void propertiesFileLoad() throws Exception {
        Properties configProps;
        configProps =new Properties();
        props =new Properties();
        lang =new Properties();
        FileInputStream basicConfigProp = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
        configProps.load(basicConfigProp);


        String platform="";
        if(System.getProperty("os")== null) {
            platform = configProps.getProperty("os");
        }else{
            platform = System.getProperty("os");
        }
        this.platform=platform;
        log.info("platform Supplied is : "+ platform);

        String execution="";
        if(System.getProperty("execution")== null) {
            execution = configProps.getProperty("execution");
        }else{
            execution = System.getProperty("execution");
        }
        this.execution=execution;
        log.info("execution Supplied is : "+ execution);

        String locale="";
        if(System.getProperty("locale")== null) {
            locale = configProps.getProperty("locale");
        }else{
            locale = System.getProperty("locale");
        }
        language = locale;
        log.info("Locale Supplied is : "+ locale);

        String env="";
        if(System.getProperty("env")== null){
            env = configProps.getProperty("env");
        }else{
            env = System.getProperty("env");
        }
        log.info("Env Chosen is: "+ env);
        String filePath=System.getProperty("user.dir") +"/src/main/java/testdata/"+ platform + "_config.properties";
        log.info("Loading Prop file: "+ filePath);
        props.load(new FileInputStream(filePath));

        filePath=System.getProperty("user.dir") +"/src/main/java/testdata/"+ locale +".properties";
        log.info("Loading Locale file: "+ filePath);
        lang.load(new FileInputStream(filePath));
    }


    public  void Android_LaunchApp() throws IOException {
        log.info("Trying to Launch Android");
        cap = new DesiredCapabilities();
        String appPackage = props.get("appPackage").toString();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("name", "KamiMobileTesting");
        cap.setCapability("app", props.get("localApkFilePath"));
        cap.setCapability("udid", props.getProperty("udid"));
        cap.setCapability("noReset", false);
        cap.setCapability("fullReset", true);
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appWaitActivity","*.SplashActivity");
        cap.setCapability("language", language);
        cap.setCapability("locale", language);
        cap.setCapability("adbExecTimeout", 120000);
        cap.setCapability("disableAnimations", "true");

        if(execution.equalsIgnoreCase("PERFECTO")) {
            log.info("ANDROID PERFECTO Execution");
            String host = props.get("perfectoCloudName").toString();
            String repositoryKey = props.get("perfectoRepositoryKey").toString();

            String perfectoSecurityToken = props.get("perfectoSecurityToken").toString();
            String browserName = "mobileOS";
            String perfectoDeviceModel="";
            if(System.getProperty("perfectoDeviceModel")== null) {
            	perfectoDeviceModel=props.getProperty("perfectoDeviceModel");
            }else{
            	perfectoDeviceModel = System.getProperty("perfectoDeviceModel");
            }
            log.info("Device Selected : "+perfectoDeviceModel+"");
            //Mobile: Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
            DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANDROID);
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("model", perfectoDeviceModel);
            capabilities.setCapability("enableAppiumBehavior", true);
            capabilities.setCapability("openDeviceTimeout", 2);
            capabilities.setCapability("waitForAvailableLicense",true);
            capabilities.setCapability("app", repositoryKey);
            capabilities.setCapability("autoLaunch", true);
            capabilities.setCapability("autoInstrument", true);
            capabilities.setCapability("takesScreenshot", true);
            capabilities.setCapability("screenshotOnError", true);
            capabilities.setCapability("securityToken", perfectoSecurityToken);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("grantAllPermissions", true);
            capabilities.setCapability("language", language);
            capabilities.setCapability("locale", language);
            String url = "https://"+host+"/nexperience/perfectomobile/wd/hub";
            threadLocalDriver.set(new AndroidDriver<MobileElement>(new URL(url), capabilities));
            driver=getDriver();
        }else{
            cap.setCapability("deviceName", props.getProperty("udid"));
            threadLocalDriver.set(new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap));
            driver=getDriver();
        }
        log.info("Android driver is set");
    }

    public  void iOS_LaunchApp() throws Exception {
        log.info("Trying to Launch IOS");
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        //cap.setCapability("platformVersion", props.getProperty("iosVersion"));
        cap.setCapability("name", "KamiMobileTesting");
        cap.setCapability("deviceName", props.getProperty("deviceName"));
        cap.setCapability("udid", props.getProperty("udid"));
        cap.setCapability("app", props.get("localAppFilePath").toString());
        cap.setCapability("noReset", true);
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("locationServicesEnabled", Boolean.TRUE);
        cap.setCapability("locationServicesAuthorized", Boolean.TRUE);
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("resetKeyboard", true);
        cap.setCapability("networkConnectionEnabled", true);
        cap.setCapability("grantAllPermissions", true);
        cap.setCapability("language", language);
        cap.setCapability("locale", language);
        cap.setCapability("newCommandTimeout",60000);
        //cap.setCapability("noReset", false);

        if(execution.equalsIgnoreCase("PERFECTO")) {
            log.info("IOS PERFECTO Execution");
            String host = props.get("perfectoCloudName").toString();
            String repositoryKey = props.get("perfectoRepositoryKey").toString();

            String perfectoSecurityToken = props.get("perfectoSecurityToken").toString();
            String browserName = "mobileOS";
            String perfectoDeviceModel="";
            if(System.getProperty("perfectoDeviceModel")== null) {
            	perfectoDeviceModel=props.getProperty("perfectoDeviceModel");
            }else{
            	perfectoDeviceModel = System.getProperty("perfectoDeviceModel");
            }
            log.info("Device Selected : "+perfectoDeviceModel+"");
            //Mobile: Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
            DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.IOS);
            capabilities.setCapability("manufacturer", "Apple");
            capabilities.setCapability("model", perfectoDeviceModel);
            capabilities.setCapability("openDeviceTimeout", 2);
            if(props.getProperty("perfectoDeviceVersion")!=null && !props.getProperty("perfectoDeviceVersion").equals(""))
            capabilities.setCapability("platformVersion", props.getProperty("perfectoDeviceVersion"));
            capabilities.setCapability("waitForAvailableLicense",true);
            capabilities.setCapability("app", repositoryKey);
            capabilities.setCapability("autoLaunch", true);
            capabilities.setCapability("autoInstrument", true);
            capabilities.setCapability("takesScreenshot", true);
            capabilities.setCapability("screenshotOnError", true);
            capabilities.setCapability("securityToken", perfectoSecurityToken);
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("grantAllPermissions", true);
            capabilities.setCapability("useAppiumForHybrid", true);
            capabilities.setCapability("language", language);
            capabilities.setCapability("locale", language);

            String url = "https://"+host+"/nexperience/perfectomobile/wd/hub";
            threadLocalDriver.set(new IOSDriver<MobileElement>(new URL(url), capabilities));
            driver=getDriver();
        }else {
            log.info("IOS local Execution");
            threadLocalDriver.set(new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap));
            driver=getDriver();
        }
        log.info("iOS driver is set");
        iosOpenAppChecks();
    }

    public void webDriver() throws MalformedURLException {

		if (System.getProperty("Url") != null) {
			siteLoginUrl = System.getProperty("Url");
		} else {
			siteLoginUrl = props.getProperty("siteLoginUrl");
		}
		if (System.getProperty("BrowserMode") != null) {
			browserMode = (System.getProperty("BrowserMode"));
		} else {
			browserMode = props.getProperty("BrowserMode");
		}

		if (execution.equalsIgnoreCase("BS")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Catalina");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("resolution", props.getProperty("bs_resolution"));
			caps.setCapability("browser_version", "81.0 beta");
			caps.setCapability("project", "Kami Mobile Web Tests");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("browserstack.console", "verbose");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("browserstack.selenium_version", "3.141.59");
			caps.setCapability("project", "Kami Web Project");
			caps.setCapability("build", "WebTests: " + LocalDate.now() + " " + language + " " + execution);
			URL bs_url = new URL("https://" + props.getProperty("userName") + ":"
					+ props.getProperty("accessKey") + "@hub-cloud.browserstack.com/wd/hub");
			log.info("BS APP URL fired is: " + bs_url);
			driver = new RemoteWebDriver(bs_url, caps);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.get(siteLoginUrl);
			driver.manage().window().maximize();
			sessionId = ((RemoteWebDriver) driver).getSessionId();
			log.info("Session ID for BS driver session is: " + sessionId);
		} else if (execution.equalsIgnoreCase("LTWeb")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("build", "ResponsiveWebTests " + LocalDate.now() + " " + language + " " + execution);
			caps.setCapability("name", "Daily Run");
			caps.setCapability("platform", "MacOS Catalina");
			caps.setCapability("browserName", "Chrome");
			caps.setCapability("version", "88.0");
			URL lt_url = new URL("https://" + props.getProperty("userNameLT") + ":"
					+ props.getProperty("accessKeyLT") + "@hub.lambdatest.com/wd/hub");
			log.info("LT APP URL fired is: " + lt_url);
			driver = new RemoteWebDriver(lt_url, caps);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.get(siteLoginUrl);
			driver.manage().window().maximize();
			sessionId = ((RemoteWebDriver) driver).getSessionId();
			log.info("Session ID for LT driver session is: " + sessionId);
		} else if (execution.equalsIgnoreCase("LTMobWeb")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("build",
					"ResponsiveMobileWebTests " + LocalDate.now() + " " + language + " " + execution);
			caps.setCapability("name", "Daily Run");
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "Galaxy S10");
			caps.setCapability("platformVersion", "9");
			caps.setCapability("appiumVersion", "1.17.1");
			URL lt_url = new URL("https://" + props.getProperty("userNameLT") + ":"
					+ props.getProperty("accessKeyLT") + "@hub.lambdatest.com/wd/hub");
			log.info("LT APP URL fired is: " + lt_url);
			driver = new RemoteWebDriver(lt_url, caps);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			driver.get(siteLoginUrl);
			sessionId = ((RemoteWebDriver) driver).getSessionId();
			log.info("Session ID for LT driver session is: " + sessionId);
		}
        else if (execution.equalsIgnoreCase("LOCAL"))
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-blink-features", "BlockCredentialedSubresources");
            chromeOptions.addArguments("--start-fullscreen");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments(browserMode);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            log.info("Url Chosen is: " + siteLoginUrl);
            driver.get(siteLoginUrl);
        }
        else if (execution.equalsIgnoreCase("PERFECTO")) {
        	log.info("WEB PERFECTO Execution");
            String host = props.get("perfectoCloudName").toString();
            String perfectoSecurityToken = props.get("perfectoSecurityToken").toString();
            String browserName = "mobileChrome";
            String perfectoPlatformName="";
            if(System.getProperty("perfectoPlatformName")== null) {
            	perfectoPlatformName=props.getProperty("perfectoPlatformName");
            }else{
            	perfectoPlatformName = System.getProperty("perfectoPlatformName");
            }
            log.info("PlatformName Selected : "+perfectoPlatformName+"");
            String perfectoPlatformVersion="";
            if(System.getProperty("perfectoPlatformVersion")== null) {
            	perfectoPlatformVersion=props.getProperty("perfectoPlatformVersion");
            }else{
            	perfectoPlatformVersion = System.getProperty("perfectoPlatformVersion");
            }
            log.info("PlatformVersion Selected : "+perfectoPlatformVersion+"");
            DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
            capabilities.setCapability("build", "ResponsiveWebTests " + LocalDate.now() + " " + language + " " + execution);
			capabilities.setCapability("platformName", perfectoPlatformName);
            capabilities.setCapability("platformVersion", perfectoPlatformVersion);
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "96");
            capabilities.setCapability("location", props.getProperty("perfectoLocation"));
            capabilities.setCapability("resolution", props.getProperty("bs_resolution"));
            capabilities.setCapability("takesScreenshot", true);
            capabilities.setCapability("screenshotOnError", true);
            capabilities.setCapability("securityToken", perfectoSecurityToken);
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("grantAllPermissions", true);
            capabilities.setCapability("language", language);
            capabilities.setCapability("locale", language);
            URL url = new URL("https://"+host+"/nexperience/perfectomobile/wd/hub");
            log.info("Perfecto URL fired is: " + url);
			driver = new RemoteWebDriver(url, capabilities);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			log.info("App Url Chosen is: " + siteLoginUrl);
			driver.get(siteLoginUrl);
			driver.manage().window().maximize();
			sessionId = ((RemoteWebDriver) driver).getSessionId();
			log.info("Session ID for Perfecto driver session is: " + sessionId);
		}
	}

	public void remoteWebDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		ChromeOptions cap = new ChromeOptions();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		driver = new RemoteWebDriver(new URL(props.getProperty("remoteWebDriverURL")), capabilities);
		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		driver.get(siteLoginUrl);
	}



    public UIHelper setBy(By android, By ios) throws Exception {
        timeOut=15;
        if(isAndroid()){
            by=android;
        }else if(isIOS()){
            by=ios;
        }else{
            log.error("Not implemented yet");
            throw new Exception("Not implemented yet");
        }
        return this;
    }

    public UIHelper setBy(By web) throws Exception {
        timeOut=15;
        if(isWeb()){
            by=web;
        }else{
            log.error("Not implemented yet");
            throw new Exception("Not implemented yet");
        }
        return this;
    }

    // select by text from drop down by locator
 	public void selectFromDropDownByText(String text) throws Exception {
 		WebElement selElement = waitForElement();
 		sel = new Select(selElement);
 		sel.selectByVisibleText(text);
 	}

 	// select by index from drop down using locator
 	public void selectFromDropDownByIndex(int index) throws Exception {
 		WebElement selElement = waitForElement();
 		sel = new Select(selElement);
 		sel.selectByIndex(index);
 	}

 	public void scrollToElement() throws Exception {
		WebElement element = waitForElement();
		TouchActions action = new TouchActions(driver);
		log.info(action);
		action.scroll(element, 10, 100);
		action.perform();
	}

 	public void webScroll() throws Exception {
 		WebElement element = waitForElement();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	}

 	public void jsclick() throws Exception {
		WebElement element = waitForElement();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

    public String getPlatform() {
        return this.platform;
    }



    /**
     * method verify whether element is present on screen
     *
     * @return WebElement if element is present else throws exception
     *
     */
    private WebElement waitForElement() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementToBeClickable() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Click on the element
     *
     * @return void
     *
     */
    public void click() throws Exception {
            WebElement element = waitForElement();
            element.click();
    }

    public void safeClick() throws Exception {
        WebElement element = waitForElementToBeClickable();
        element.click();
    }

    public WebElement getElement() throws Exception {
        return waitForElement();
    }

    public void quickClick() throws Exception {
        driver.findElement(by).click();
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping,
     *                              or otherwise occupied, and the thread is interrupted, either before
     *                              or during the activity.
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException {
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    /**
     * method to hide keyboard
     */
    public void hideKeyboard() {
        if(isIOS()){
            by=By.xpath("(//XCUIElementTypeToolbar//XCUIElementTypeButton)[last()-1]");
            if(isElementPresent())
                driver.findElement(by).click();
        } else {
            try {
                log.info("Hide keyboard");
                ((AppiumDriver) driver).hideKeyboard();
            } catch (Exception e) {
                log.info("Unable to hide keyboard");
            }
        }
    }



    /**
     * method to go back by Android Native back click
     */
    public void back() {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void sendKeys(String textToEnter) throws Exception {
        try {
            WebElement element = waitForElement();
            element.clear();
            element.sendKeys(textToEnter);
            if(isIOS())
                hideKeyboard();
        }catch(Exception e) {
            throw new Exception("Falied to Type ");
        }
    }

    public void clear() throws Exception {
        try {
            WebElement element = waitForElement();
            element.clear();
            if(isIOS()) {
                log.info("Handle later...");
            }
        }catch(Exception e) {
            throw new Exception("Falied to Type ");
        }
    }

    public void tapElementByRatio(double x, double y) throws Exception {
        MobileElement element = (MobileElement) waitForElement();
        Rectangle elRect = element.getRect();
        Point point = new Point(
                elRect.x + (int)(elRect.getWidth()/x),
                elRect.y + (int)(elRect.getHeight()/y)
        );
        tapAtPoint(point);
    }

    public void tapAtPoint(Point point) {
        TouchAction touch = new TouchAction((MobileDriver) driver);
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withPosition(new PointOption().withCoordinates(point.x, point.y));
        touch.longPress(longPressOptions).release().perform();
    }

    public void tapios() throws Exception {
        MobileElement element = (MobileElement) waitForElement();
        Map<String, Object> args = new HashMap<>();
        Rectangle react = element.getRect();
        args.put("element", (element).getId());
        args.put("x", react.getWidth()/2);
        args.put("y", react.getHeight()/2);
        ((AppiumDriver) driver).executeScript("mobile: tap", args);
    }



    public void waitForDisappear() throws Exception {
        int polling=1;
        int networkDelayRepeater=2;
        try {
            WebDriverWait wait = new WebDriverWait(driver, networkDelayRepeater*timeOut,polling*500); // defalut is 500 keep as is for android
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }catch(Exception e) {
            log.error("waitForDisappear:");
        }
    }

    public  String getText() throws Exception {
        try {
            WebElement element = waitForElement();
            return element.getText();
        }catch (Exception e){
            WebElement element = waitForElement();
            return element.getText();
        }
    }

    public  String getAttribute(String attributeName) throws Exception {
        WebElement element = waitForElement();
        String text=  element.getAttribute(attributeName);
        return text;
    }

    public  String getValue() throws Exception {
        WebElement element = waitForElement();
        if(isIOS())
            return element.getAttribute("value");
        else
            return element.getText();
    }

    public boolean isElementPresent() {
        try {
            timeOut=1;
            WebElement element = waitForElement();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isElementPresent(int waitTimeForElementToAppear) {
        try {
            timeOut=waitTimeForElementToAppear;
            WebElement element = waitForElement();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean waitForElementToAppear() {
        try {
            WebElement element = waitForElement();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void waitForAnimationEffectInSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public boolean waitForElementToDisAppear() {
        int waitTime=timeOut;
        timeOut=0;
        try {
            while (isElementPresent() && waitTime>0){
                waitTime--;
                Thread.sleep(1000);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void assertExist() throws Exception {
        if(isElementPresent(5)==false) {
            throw new Exception("could not find Web Element");
        }
    }

    //Vertical Swipe by percentages
    private void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        int duration = isAndroid() ? 800 : 1000;
        new TouchAction((AppiumDriver<MobileElement>)driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void swipeByCordinates(int startX, int startY, int endX, int endY) {
        Dimension size = driver.manage().window().getSize();
        int duration = isAndroid() ? 800 : 1000;
        new TouchAction((AppiumDriver<MobileElement>)driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void clickByCordinates(int startX, int startY, int endX, int endY) {
        Dimension size = driver.manage().window().getSize();
        int duration = isAndroid() ? 800 : 1000;
        new TouchAction((AppiumDriver<MobileElement>)driver).tap(PointOption.point(startX, startY))
               .perform();
    }

    public void androidScrollToText(String text) {
        String uiSelector = "new UiSelector().textMatches(\"" + text + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(command));
        } catch (Exception e) {
            log.info("Something wrong happens when scrolling to text");
        }
    }


    public void scroll(ScrollDirection dir) throws Exception {
        if (dir.equals(ScrollDirection.DOWN)) {
            verticalSwipeByPercentages(0.75, 0.25, 0.5);
        } else if (dir.equals(ScrollDirection.UP)) {
            verticalSwipeByPercentages(0.25, 0.75, 0.5);
        } else if (dir.equals(ScrollDirection.LEFT)) {
            verticalSwipeByPercentages(.5, .3, 0.5);
        } else if (dir.equals(ScrollDirection.MIDDLE)) {
            verticalSwipeByPercentages(.4, .5, 0.5);
        }
    }

    public void scrollSlowly(ScrollDirection dir) throws Exception {
        if (dir.equals(ScrollDirection.DOWN)) {
            verticalSwipeByPercentages(0.6, 0.4, 0.5);
        } else if (dir.equals(ScrollDirection.UP)) {
            verticalSwipeByPercentages(0.4, 0.6, 0.5);
        } else if (dir.equals(ScrollDirection.LEFT)) {
        } else if (dir.equals(ScrollDirection.MIDDLE)) {
            verticalSwipeByPercentages(.4, .5, 0.5);
        }
    }

    /***
     *
     * @param screenStart >0 and <1 .5 is middle screen and >.5 bottom of screen
     * @param screenEnd > 0 and <1 .5 is middle screen and <.5 top of screen
     * @throws Exception
     */
    public void scrollSlowlyByScreenRatio(ScrollDirection dir,double screenStart,double screenEnd) throws Exception {
        if (dir.equals(ScrollDirection.DOWN)) {
            verticalSwipeByPercentages(screenStart, screenEnd, 0.5);
        } else if (dir.equals(ScrollDirection.UP)) {
            verticalSwipeByPercentages(screenStart, screenEnd, 0.5);
        } else if (dir.equals(ScrollDirection.LEFT)) {
        } else if (dir.equals(ScrollDirection.MIDDLE)) {
            verticalSwipeByPercentages(screenStart, screenEnd, 0.5);
        }
    }

    public void pressNumber(AndroidKey key) {
        ((AndroidDriver) driver).pressKey( new KeyEvent().withKey(key));
    }

    public void launchApp() throws Exception{
        if (isAndroid()) {
            ((AndroidDriver) driver).launchApp();
        } else {
            ((IOSDriver) driver).launchApp();
            by=By.xpath("//*[@name='OK' or starts-with(@name,'Allow') or @name='Agree']");
            if (isElementPresent(1)) {
                click();
            }
        }
    }

    public void closeApp() {
        if (isAndroid()) {
            ((AndroidDriver) driver).closeApp();
        } else {
            ((IOSDriver) driver).closeApp();
        }
    }

    public void reOpenApp() {
        if (isAndroid()) {
            ((AndroidDriver) driver).activateApp(props.get("appPackage").toString());
        } else {
            ((IOSDriver) driver).launchApp();
        }
    }

    public void relaunchApp() {
        try {
            closeApp();
            launchApp();
        } catch(Exception e) {
        }
    }

    public void quitDriver() throws InterruptedException {
        Thread.sleep(6);
        driver.quit();
    }


    private static Dimension windowSize;
    private static Duration SCROLL_DUR = Duration.ofMillis(1000);
    private static double SCROLL_RATIO = 0.8;
    private static int ANDROID_SCROLL_DIVISOR = 3;

    public void navigateBack() {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public List<WebElement> getAll() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch (Exception e){
            return new ArrayList<WebElement>();
        }
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public void acceptAlert() throws Exception {
        if(isIOS()) {
            this.by=By.xpath("//*[@name='Allow' or @name='Agree' or @name='OK']");
            if(isElementPresent(3))
                click();
        }
    }

    boolean keyboardSet=false;
    public void selectEnglishKeyboard() throws Exception {
        int set=5;
        if(!keyboardSet && language.equalsIgnoreCase("ru")) {
            while (!setBy(By.xpath(""), By.xpath("//XCUIElementTypeKey[@name=\"space\"]")).isElementPresent() && set > 0) {
                Thread.sleep(5000);
                setBy(By.xpath(""), By.xpath("(//XCUIElementTypeWindow)[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")).click();
                Thread.sleep(2000);
                set--;
            }
        }
            keyboardSet=true;
    }

    public By alertOKButton=By.xpath("//XCUIElementTypeButton[@name='OK']");
    public void acceptAlertOK() throws Exception {
        if(isIOS()) {
            this.by=alertOKButton;
            if(isElementPresent(3))
                click();
        }
    }


    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT, MIDDLE
    }


    public void scrollToElementDownSide() throws Exception {
        scrollDirections(ScrollDirection.DOWN);
    }

    public void touchScreenMiddle() throws Exception {
        scrollDirections(ScrollDirection.MIDDLE);
    }

    private void scrollDirections(ScrollDirection dir) throws Exception {
        timeOut=1;
        int tries=50;
        while(tries>0) {
            try {
                if(isIOS()) {
                    if (getAttribute("visible").equalsIgnoreCase("true"))
                        return;
                    else
                        scroll(dir);
                } else{
                    driver.findElement(by).isDisplayed();
                    return;
                }
            } catch (Exception e) {
                scroll(dir);
            }
            tries--;
        }
        log.error("Error getting the element");
        throw new Exception("Error getting the element");
    }

    public void scrollDirectionsSlowly(ScrollDirection dir) throws Exception {
        timeOut=1;
        int tries=50;
        while(tries>0) {
            try {
                if(isIOS()) {
                    if (getAttribute("visible").equalsIgnoreCase("true"))
                        return;
                    else
                        scrollSlowly(dir);
                }else{
                    WebElement element = waitForElement();
                    return;
                }
            } catch (Exception e) {
                scrollSlowly(dir);
            }
            tries--;
        }
        throw new Exception("Error getting the element");
    }

    public void scrollToElementUpSide() throws Exception {
        scrollDirections(ScrollDirection.UP);
    }

    public void scrollToElementUpSideSlowly() throws Exception {
        scrollDirectionsSlowly(ScrollDirection.UP);
    }

    public boolean perfectoIsTextPresent(String textToFind){
        Map<String, Object> params = new HashMap<>();
        params.put("content", textToFind);
        params.put("context", "body");
        if(language.equalsIgnoreCase("ru")){
           // params.put("language", "Russian");
            params.put("source", "native");
        }
        String res = (String)((AppiumDriver)driver).executeScript("mobile:text:find",params);
        return Boolean.parseBoolean(res);
    }

    public boolean perfectoScrollToText(String text){
        Map<String, Object> params = new HashMap<>();
        params.put("content", text);
        params.put("scrolling", "scroll");
        ((AppiumDriver)driver).executeScript("mobile:text:find", params);

        return true;
    }

    public void perfectoClickButton(String textToFind){
        Map<String, Object> params = new HashMap<>();
        params.put("label", textToFind);
        params.put("threshold", 80);
        if(language.equalsIgnoreCase("ru")){
          //  params.put("language", "Russian");
            params.put("source", "native");
        }
        params.put("ignorecase", "nocase");
        ((AppiumDriver)driver).executeScript("mobile:button-text:click", params);
    }


    public void perfectoClickButtonWithCase(String textToFind){
        Map<String, Object> params = new HashMap<>();
        params.put("label", textToFind);
        params.put("threshold", 80);
        if(language.equalsIgnoreCase("ru")){
           // params.put("language", "Russian");
            params.put("source", "native");
        }
        params.put("ignorecase", "case");
        ((AppiumDriver)driver).executeScript("mobile:button-text:click", params);
    }

    public void perfectoClickImage(String pefectoImageRepoPath){
        Map<String, Object> params = new HashMap<>();
        params.put("label", pefectoImageRepoPath);
        params.put("threshold", 50);
        ((AppiumDriver)driver).executeScript("mobile:button-image:click", params);
    }

    public boolean isIOSAndPerfectoExecution(){
        return (isIOS() && execution.equalsIgnoreCase("perfecto"));
    }
    public boolean isIOS() {
        return platform.equalsIgnoreCase("IOS");
    }

    public boolean isAndroid() {
        return platform.equalsIgnoreCase("android");
    }

    public boolean isWeb() {
        return platform.equalsIgnoreCase("web");
    }

    boolean iosOpenAppChecked=false;
    public void iosOpenAppChecks() throws Exception {
        if(isIOS() && !iosOpenAppChecked){
            by=By.xpath("//*[@name='OK' or starts-with(@name,'Allow') or @name='Agree']");
            if(isElementPresent(15)){
                click();
            }
            iosOpenAppChecked=true;
        }
    }

    boolean isCheckDone=false;
    public void iosAfterLoginChecks() throws Exception {
        if(isIOS()) {
            if(!isCheckDone) {
                by=By.xpath("//*[@name='OK' or starts-with(@name,'Allow') or @name='Agree']");
                if (isElementPresent(30)) {
                    click();
                }
                by=By.xpath("//*[contains(@name,'Skip')]");
                if (isElementPresent(10)) {
                    click();
                }
                isCheckDone=true;
            }
            relaunchApp();
            Thread.sleep(5000);

            by=By.xpath("//*[@name='Not really']");
            if (isElementPresent(30)) {
                relaunchApp();
            }

            Thread.sleep(3000);

        }
    }

    public void setValue(String textToEnter) throws Exception {
        try {
            if(isIOS()) {
                log.info("Do nothing");
                return;
            }
            MobileElement element = (MobileElement)waitForElement();
            element.sendKeys(textToEnter);
        } catch(Exception e) {
            throw new Exception("Failed to set value: " + e.getMessage());
        }
    }

    private WebElement waitForElementToBeVisible() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)).get(0);
    }

    public boolean isElementVisible(int waitTimeForElementToAppear) {
        try {
            timeOut=waitTimeForElementToAppear;
            WebElement element = waitForElementToBeVisible();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private void horizontalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int height = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction((AppiumDriver<MobileElement>)driver)
                .press(PointOption.point(startPoint, height))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, height))
                .release().perform();
    }

    public void scrollWithCustomizedAxis(double x0, double x1, double y, ScrollDirection dir) throws Exception {
        if (dir.equals(ScrollDirection.LEFT)) {
            horizontalSwipeByPercentages(x0, x1, y);
        } else if (dir.equals(ScrollDirection.RIGHT)) {
            horizontalSwipeByPercentages(x0, x1, y);
        } else if (dir.equals(ScrollDirection.DOWN)) {
            verticalSwipeByPercentages(x0, x1, y);
        } else if (dir.equals(ScrollDirection.UP)) {
            verticalSwipeByPercentages(x0, x1, y);
        }
    }

    public List<WebElement> waitForElementsToBeVisible() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public boolean searchAndScrollIsElementDisplayed(HashMap<String, String> elementIdentifier, int numberOfTimes, String direction) {
        try
        {
            if (!isElementDisplayed(elementIdentifier))
            {
                for(int i=0; i<numberOfTimes; i++)
                {
                    List<Integer> screenSize = getScrenSize();
                   // scrollWithCoordinates_iOS1(screenSize.get(0) / 2, screenSize.get(1) / 2, screenSize.get(0) / 2, (screenSize.get(1) / 2)-500, direction);
                    Thread.sleep(5000);
                    driver.getPageSource();
                    Thread.sleep(5000);
                    if(isElementDisplayed(elementIdentifier))
                    {
                        return true;
                    }
                    System.out.println("Scroll and search element loop : "+elementIdentifier +" "+i);
                }
            } else {
                return true;
            }
        } catch (Exception e) {


        }

        System.out.println("Element not found in given number of scrolls");
        return false;
    }


    public List<Integer> getScrenSize() throws Exception {
        List<Integer> size = new ArrayList<>();
        int screenX = driver.manage().window().getSize().width;
        int screenY = driver.manage().window().getSize().height;
        size.add(screenX);
        size.add(screenY);
        return size;
    }
    public boolean isElementDisplayed(HashMap<String, String> elementIdentifier) {
        boolean result = false;
        try {
            //result = waitForElementToAppear(elementIdentifier, 0);

            return result;
        } catch (Exception nse) {

            return false;
        }
    }


}

