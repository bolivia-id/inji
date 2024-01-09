package inji.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HelpPage extends BasePage {

    @AndroidFindBy(accessibility = "helpScreen")
    @iOSXCUITFindBy(accessibility = "helpScreen")
    private WebElement helpText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"iconIcon\")")
    @iOSXCUITFindBy(accessibility = "close")
    private WebElement crossIcon;
    
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"What happens when Android keystore biometric is changed?\"));")
    @iOSXCUITFindBy(accessibility = "How to add a card?")
    public WebElement biometricIsChangeTextdHeader;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"The Android keystore holds important information like private keys \")")
    private WebElement biometricIsChangeTextdDiscription;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"How to add a card?\")")
    @iOSXCUITFindBy(accessibility = "How to add a card?")
    public WebElement helpPageContent;
    
    public HelpPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isHelpPageLoaded() {
        return this.isElementDisplayed(helpText, "Help page");
    }

    public void exitHelpPage() {
        this.clickOnElement(crossIcon);
    }
    
    public void scrollPerformInHelpPage() {
    	biometricIsChangeTextdHeader.isDisplayed();
    }

    public boolean ishelpPageContentEmpty() {
    	return helpPageContent.getText().isBlank();
    }
    
    public boolean isBiometricIsChangeTextdDiscription() {
        return this.isElementDisplayed(biometricIsChangeTextdDiscription, "The Android keystore holds important information like private keys for identity proofs. When you change your biometrics, old keys are no longer safe. To keep things secure, we remove identity proofs signed by those old keys. You can simply download your identity proofs again, and they will be signed with the latest, safer keys.");
    }
    
}