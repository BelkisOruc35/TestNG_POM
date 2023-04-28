package tests.day12_xmlFiles;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("Pozitif Login Testi",
                "gecerli bilgilerle giris yapılabilmeli");
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Qualitydemi anasayfaya gidildi");

        // login linkine tiklayin
        QdPage qdPage= new QdPage();
        qdPage.ilkLoginLinki.click();
        extentTest.info("Ilk login linkine tiklandi");
        qdPage.cookieaccept1.click();

        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("Gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("Gecerli password yazildi ve giris yapildi");
        qdPage.loginButonu.click();
        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("Basarili sekilde giris yapildigi test edildi");

    }
}
