package Gun05;


import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Daha önceki derslerde yaptğımız Search fonksiyonunu
 * mac,ipod ve samsung için Dataprovider ile yapınız.
 */

public class _03_Soru extends BaseDriver {

    @Test(dataProvider = "getData")
    public void SearchFunction(String aranacakKelime){

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(aranacakKelime + Keys.ENTER);

        List<WebElement> captions = driver.findElements
                (By.cssSelector("[class='caption'] > h4"));

        for (WebElement e : captions) {
            //System.out.println("e.getText() = " + e.getText());
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacakKelime), "aranan kelime bulunamadı");
        }

    }

    @DataProvider
    Object[] getData()
    {
        Object[] data={"mac","samsung","ipod"};
        return data;
    }



}
