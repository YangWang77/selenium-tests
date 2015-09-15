package com.wikia.webdriver.pageobjectsfactory.pageobject.widget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @ownership: Content X-Wing
 */
public class PollsnackWidgetPageObject extends WidgetPageObject {

  @FindBy(css = "iframe[data-wikia-widget=\"pollsnack\"]")
  private WebElement pollsnackIframe;
  @FindBy(css = "iframe[data-wikia-widget=\"pollsnack\"]")
  private List<WebElement> pollsnackIframeList;
  @FindBy(css = "iframe")
  private WebElement pollsnackBody;

  private static final String TAG_NAME = "pollsnack";
  private static final String ARTICLE_NAME = "PollsnackWidget";
  private static final String[] TAGS = {
      "<pollsnack hash=\"q7kiw9kz\"/>",
      "<pollsnack hash=\"q7kiw9kz\"/>",
  };
  private static final String INCORRECT_TAG = "<pollsnack />";
  private static final String ERROR_MESSAGE = "Failed to render the PollSnack widget. Please check if all required parameters are in place.";

  public PollsnackWidgetPageObject(WebDriver driver) {
    super(driver);
  }

  protected String getArticleName() {
    return ARTICLE_NAME;
  }

  protected String getTagName() {
    return TAG_NAME;
  }

  protected String[] getTags() {
    return TAGS;
  }

  protected String getIncorrectTag() {
    return INCORRECT_TAG;
  }

  protected String getErrorMessage() {
    return ERROR_MESSAGE;
  }

  protected boolean isTagLoadedOnMercury() {
    return isWidgetVisible(pollsnackIframe, pollsnackBody);
  }

  protected boolean isTagLoadedOnOasis() {
    return isWidgetVisible(pollsnackIframe, pollsnackBody);
  }

  protected boolean areTagsLoadedOnOasis() {
    for (WebElement iframe: pollsnackIframeList) {
      if (!isWidgetVisible(iframe, pollsnackBody)) {
        return false;
      }
    }
    return true;
  }

  protected boolean areTagsLoadedOnMercury() {
    for (WebElement iframe: pollsnackIframeList) {
      if (!isWidgetVisible(iframe, pollsnackBody)) {
        return false;
      }
    }
    return true;
  }
}
