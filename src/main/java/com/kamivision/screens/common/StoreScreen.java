package com.kamivision.screens.common;
import lombok.extern.log4j.Log4j2;
import utilities.UIHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

@Log4j2
public class StoreScreen  {
    private final UIHelper app;
    public StoreScreen(UIHelper app) {
        this.app=app;
    }
    public UIHelper storeItems() throws Exception{ return app.setBy(By.xpath("//*[contains(@resource-id, 'store_iv')]"),By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell"));}


    @Step("Verify Store Page is Displayed with Store Options")
    public void verifyStorePageDisplayedWithStores() throws Exception {
        log.info("Verify Store Page is Displayed with Store Options");
        Boolean storePage = storeItems().isElementPresent(5);
        Assert.assertTrue(storePage, "Store Page is missing");
        Boolean storeItems = storeItems().getAll().size() >= 1;
        Assert.assertTrue(storeItems, "Stores are missing");
    }
}
