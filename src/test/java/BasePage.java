import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest {

    @Step("<wait> saniye bekle")
    public void second(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        System.out.println(wait + "saniye beklendi ...");
        logger.info("PASSED");


    }

    @Step("<selectorid> id'li elemente tıkla")
    public void clickByid(String selectorid) {
        appiumDriver.findElement(By.id(selectorid)).click();
        logger.info("PASSED");

    }
    @Step("<Favorite> butonuna tıklanır")
    public void clickByXpath(String Favori){
        appiumDriver.findElement(By.xpath("//*[contains(@text,'"+Favori+"')]")).click();
        logger.info("PASSED");
    }
    @Step("<number> Scrol yapılır.")
    public void scrollDown(int number) {
        int startX = 538;
        int startY = 1947;
        int endX = 538;
        int endY = 30;
        for (int i = 0; i < number; i++) {

            (new TouchAction(appiumDriver))
                    .press(point(startX, startY))
                    .moveTo(point(endX,endY))
                    .release()
                    .perform();
        }
    }
   @Step("<rastgele> random secildi")
    public void passing(String rastgele){

           List<MobileElement> elements = appiumDriver.findElements(By.id(rastgele));
           Random rnd = new Random();
           int rndInt = rnd.nextInt(elements.size());
           elements.get(rndInt).click();
          logger.info("PASSED");
    }


    @Step("<key> id'li element <keyword> text değerini içerdiğni kontrol et")
    public void textControl(String key,String keyword){
        Assert.assertTrue("Elementi içermiyor",appiumDriver.findElement(By.id(key)).getText().contains(keyword));
        System.out.println(keyword + "Kontrol edilmistir.");
        logger.info("PASSED");

    }
    @Step("<kategori> xpath'li element <deger> değerini içerdiğini kontrol et")
    public void categoryControl(String kategori,String deger){
        Assert.assertTrue("Elementi içermiyor",appiumDriver.findElement(By.xpath(kategori)).getText().contains(deger));
        System.out.println(deger + "Kontrol edilmistir.");
        logger.info("PASSED");
    }



}
