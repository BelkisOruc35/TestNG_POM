package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PozitifLoginTesti {
    @Test(groups = "smoke")
    public void pozitifLoginTesti(){
        // qd anasayfaya gidin
        QdPage qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qdPage.cookieaccept.click();

        // login linkine tiklayin

        qdPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        ReusableMethods.bekle(2);
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(3);

        qdPage.loginButonu.click();
       // ReusableMethods.bekle(3);

        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();




}}
