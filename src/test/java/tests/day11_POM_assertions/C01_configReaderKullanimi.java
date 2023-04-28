package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_configReaderKullanimi {
    @Test
    public  void test01(){
        //amazon ana
        //Driver i driver clasından aldık
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));//Meydancı bize amazonun url sını getir dicez ve
        // bunun icin meydancının adın yazıyoruz.test datası olarak nasıl kaydettiysek o sekılde yazmamız yeterli
        // Test datasi olarak verilen kelime icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();//locator amazon page de o yuzden burdan bir obje olustyuruyoruz
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

       // amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        // arama sonuclarinin arattigimiz test datasini icerdigini test edelim

        String expectedIcerik = ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();

    }
    }

