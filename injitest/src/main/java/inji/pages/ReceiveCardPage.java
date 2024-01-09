package inji.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ReceiveCardPage extends BasePage {
	 @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Allow\")")
	  private WebElement allowButton;
	 
	 @AndroidFindBy(accessibility = "showQrCode")
	  private WebElement receiveCardHeder;
	 
	 @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Ipakita ang QR code na ito para humiling ng resident card\")")
	  private WebElement receiveCardHederInFilipinoLanguage;
	 
	 @AndroidFindBy(accessibility = "qrCode")
	  private WebElement qrCode;
	 
	 @AndroidFindBy(accessibility = "receiveCardStatusMessage")
	  private WebElement watitingForConnection;
	 
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.oplus.wirelesssettings:id/alertTitle\")")
	    private WebElement bluetoothPopUp;

    public ReceiveCardPage(AppiumDriver driver) {
        super(driver);
    }
    
    public ReceiveCardPage clickOnAllowButton() {
    	if (isElementDisplayed(bluetoothPopUp, "\"Inji\" wants to turn on Bluetooth")) {
    		clickOnElement(allowButton);
        }
         return this;
    }
    
    public boolean isReceiveCardHederDisplayed() {
        return this.isElementDisplayed(receiveCardHeder, "Display this QR code to request resident Card");
    }
    
    public boolean isReceiveCardHederInFilipinoLanguageDisplayed() {
        return this.isElementDisplayed(receiveCardHederInFilipinoLanguage, "Ipakita ang QR code na ito para humiling ng resident card");
    }
    
    public boolean isWaitingForConnectionDisplayed() {
        return this.isElementDisplayed(watitingForConnection, "Waiting for connection...");
    }
    
    public boolean isQrCodeEnabled() {
        return this.isElementEnabled(qrCode);
    }

}