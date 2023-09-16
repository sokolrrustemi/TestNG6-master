package Gun04;


/*
   bu örneği istediğin aşamada sorabilirsin, ister burda ister paralel testten sonra
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
*/


import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _03_Soru extends BaseDriverParameter {

    @Test
    public void test1() {
        WebElement specials = driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> newPrices = driver.findElements(By.cssSelector("span[class='price-new']")); //$80 $90
        List<WebElement> oldPrices = driver.findElements(By.cssSelector("span[class='price-old']")); //$100 $100

        Assert.assertTrue(newPrices.size() == oldPrices.size(), "hepsinde indirim bulunamadı"); // 3-

        for (int i = 0; i < newPrices.size(); i++) { //2 kere dönecek
            double newPrice = Double.parseDouble(newPrices.get(i).getText().replaceAll("[^0-9.,]", ""));
            double oldPrice = Double.parseDouble(oldPrices.get(i).getText().replaceAll("[^0-9.,]", ""));

            System.out.println(newPrice+" "+oldPrice);
            Assert.assertTrue(newPrice < oldPrice, "Yeni fiyat eski fiyattan küçük değil"); // 4-
        }

    }

}
