package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /**
     * This method will send Text to  element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement1(By by) {
        driver.findElement(by);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sentTextToAlert(String Text) {
        driver.switchTo().alert().sendKeys(Text);
    }

    public void verifyToElement(String first, String second) {
        Assert.assertEquals(first, second);
    }

    public void selectByVisibleTextFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);

    }
    public void pageNavigation(){
        driver.navigate();


    //************ Action Class **************//

//    public void mouseHoverToElement(By by) {
//        Actions actions = new Actions(driver);
//        WebElement mouseHover = driver.findElement(by);
//        actions.moveToElement(mouseHover).build().perform();
//
//    }
//
//    public void mouseHoverToElementAndClick(By by) {
//        Actions actions = new Actions(driver);
//        WebElement mouseHoveAndClick = driver.findElement(by);
//        actions.moveToElement(mouseHoveAndClick).click().build().perform();
   }



}
