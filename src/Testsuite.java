import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testsuite extends Utilities {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test

    public void amazon() throws InterruptedException {
        // Accept the cookies
        clickOnElement(By.xpath("//input[@class='a-button-input celwidget']"));
        //   2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));


        Thread.sleep(1000);
        //  3. Click on the checkbox brand Dell on the left side.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        //  4. Verify that the  30(Maybe different) products are displayed on the page.
        List<WebElement> productsList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(productsList.size());

        //  5. Print all product names in the console.
        for (WebElement element : productsList) {
            System.out.println(element.getText());
        }
        // 6. Click on the product name
        findLaptop("Dell Inspiron 16 Plus-7620 Laptop i7-12700H");

        //  7. Verify the Product name 'Dell LATITUDE 5300 LAPTOP CORE I5 8365u 8GB 250GB SSD 13.3" FHD TOUCH'
        String actualText = getTextFromElement(By.xpath("//span[@id='productTitle']"));
        String expectedText = "Dell Inspiron 16 Plus-7620 Laptop i7-12700H";
        String[] name = actualText.split(",");
        Assert.assertEquals(expectedText, name[0]);

    }

    public void findLaptop(String value) throws InterruptedException {
        Thread.sleep(1000);
        boolean flag = true;
        while (flag) {
            //   boolean flag=true;
            List<WebElement> products1 = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a"));

            // String value = "Dell Inspiron 16 Plus-7620 Laptop i7-12700H";
            //  while (true) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (WebElement e : products1) {
                String productname = e.getText();
                String[] laptopNames = productname.split(",");
                arrayList.addAll(Arrays.asList(laptopNames[0]));
            }

            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
                if (arrayList.get(i).equalsIgnoreCase(value)) {
                    clickOnElement(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2//a[contains(normalize-space(.), '" + value + "')]"));
                    // break;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("==================================================================");
                clickOnElement(By.xpath("//a[normalize-space()='Next']"));
            }
        }
    }
}
