package com.wikia.webdriver.testcases.adstests;

import com.wikia.webdriver.common.contentpatterns.AdsContent;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.drivers.Browser;
import com.wikia.webdriver.common.core.helpers.Emulator;
import com.wikia.webdriver.common.dataprovider.ads.AdsDataProvider;
import com.wikia.webdriver.common.templates.TemplateNoFirstLoad;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsBaseObject;

import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsEvolveObject;
import org.testng.annotations.Test;

@Test(groups = "AdsNoAdsOnAdsFreeWikisOasis")
public class TestAdsNoAdsOnFreeWikisOasis extends TemplateNoFirstLoad {

  @Test(
      dataProviderClass = AdsDataProvider.class,
      dataProvider = "adFreeWikis",
      groups = {"AdsNoAdsOnAdsFreeWikisOasis", "AdsEvolveOasis"}
  )
  public void testNoEvolveAdsOasis(String wikiName, String path) {
    String testedPage = urlBuilder.getUrlForPath(wikiName, path);
    AdsEvolveObject wikiPage = new AdsEvolveObject(driver);
    wikiPage.enableEvolve(testedPage);
    wikiPage.verifyNoAdsOnPage();
  }

  @Test(
      dataProviderClass = AdsDataProvider.class,
      dataProvider = "adFreeWikis",
      groups = "AdsNoAdsOnAdsFreeWikisOasis"
  )
  public void testNoAdsOasis(String wikiName, String path) {
    String testedPage = urlBuilder.getUrlForPath(wikiName, path);
    AdsBaseObject wikiPage = new AdsBaseObject(driver, testedPage);
    wikiPage.verifyNoAdsOnPage();
  }

  @InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
  @Test(
      dataProviderClass = AdsDataProvider.class,
      dataProvider = "adFreeWikis",
      groups = "AdsNoAdsOnAdsFreeWikisMercury"
  )
  public void testNoAdsMercury(String wikiName, String path) {
    String testedPage = urlBuilder.getUrlForPath(wikiName, path);
    AdsBaseObject wikiPage = new AdsBaseObject(driver, testedPage);
    wikiPage.setEnvironment(AdsContent.ENV_MOBILE);
    wikiPage.verifyNoAdsOnPage();
  }
}
