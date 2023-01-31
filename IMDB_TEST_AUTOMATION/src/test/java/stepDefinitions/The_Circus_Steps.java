package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.dialogContent;
import utilities.GWD;

public class The_Circus_Steps {

    dialogContent dc=new dialogContent();
    private static final Logger logger = LogManager.getLogger(The_Circus_Steps.class);

    @Given("www.imdb.com adresine gidilir")
    public void wwwImdbComAdresineGidilir() {
        GWD.getDriver().manage().window().maximize();
        GWD.getDriver().manage().deleteAllCookies();
        GWD.getDriver().get("https://www.imdb.com/");

        logger.info(GWD.threadBrowserName.get() +" "+"www.imdb.com adresine gidilir");

    }


    @When("Arama cubugunun sol tarafinda bulunan Menu butonuna basilir")
    public void aramaCubugununSolTarafindaBulunanMenuButonunaBasilir()
    {
        dc.findAndClick("menuButton");
        logger.info(GWD.threadBrowserName.get() +" "+"Arama cubugunun sol tarafinda bulunan Menu butonuna basilir");

    }

    @Then("Gelen ekranda “Award & Events” basligi altinda bulunan “Oscars” butonuna tiklanir")
    public void gelenEkrandaAwardEventsBasligiAltindaBulunanOscarsButonunaTiklanir()
    {
        dc.findAndClick("oscarsButton");
        logger.info(GWD.threadBrowserName.get() +" "+" Gelen ekranda Award & Events basligi altinda bulunan \"Oscars\" butonuna tiklandi");
    }

    @And("“Event History” basligi altinda 1929 secilir")
    public void eventHistoryBasligiAltinda1929Secilir()
    {
        dc.findAndClick("eventHistory1929");
        logger.info(GWD.threadBrowserName.get() +" "+" Event History basligi altinda \"1929\"'a tiklandi");
    }


    @Then("“Honorary Award” basligi altinda “The Circus \\(Charles Chaplin)” secilir")
    public void honoraryAwardBasligiAltindaTheCircusCharlesChaplinSecilir()
    {
        dc.findAndClick("CharloAtTheCircusButton");
        logger.info(GWD.threadBrowserName.get() +" "+" Honorary Award basligi altinda \"The Circus\"'a tiklandi");
    }

    @And("Gelen ekranda, The Circus'a ait; Director,Writer ve Stars bilgileri kayit edilir")
    public void gelenEkrandaTheCircusAAitDirectorWriterVeStarsBilgileriKayitEdilir()
    {
        dc.findAndAddToTheList("directorWriterStarsTheCircus");
        logger.info(GWD.threadBrowserName.get() +" "+" Gelen ekranda The Circus filminin \"Director\",\"Writer\"ve \"Stars\" bilgileri kayit edildi");
    }

    @Then("Ekranin sol ustunde bulunan “IMDb” butonuna tiklanarak “Anasayfa”ya donulur")
    public void ekraninSolUstundeBulunanIMDbButonunaTiklanarakAnasayfaYaDonulur()
    {
        dc.findAndClick("homeButton");
        logger.info(GWD.threadBrowserName.get() +" "+" Ekranin sol ustunde bulunan IMDB butonuna tiklanilarak ana sayfaya donuldu");

    }

    @Given("Arama cubuguna “The Circus” yazilir")
    public void aramaCubugunaTheCircusYazilir()
    {
        dc.findAndSend("searchBar","The Circus");
        logger.info(GWD.threadBrowserName.get() +" "+" Arama kutucuguna \"The Circus\" yazildi");

    }

    @When("Sonuclar arasinda gelen “The Circus”a tiklanir")
    public void sonuclarArasindaGelenTheCircusATiklanir()
    {
        dc.findAndWaitUntilVisible("listbox");
        dc.findAndClick("theCircus");
        logger.info(GWD.threadBrowserName.get() +" "+" Sonuclar arasinda Gelen \"The Circus\"'a tiklanildi");
    }

    @Then("Gelen ekranda; The Circus'a ait Director, Writer ve Stars bilgisi kayit edilen bilgilerle ayni mi kontrol edilir")
    public void gelenEkrandaTheCircusAAitDirectorWriterVeStarsBilgisiKayitEdilenBilgilerleAyniMiKontrolEdilir()
    {
        dc.findAndAddToTheList("directorWriterStarsTheCircus2");
        for (int i=0; i<dc.list1.size(); i++) {
            Assert.assertEquals(dc.list1.get(i).getText(), dc.list2.get(i).getText());
            System.out.println("dc.list1.get(i).getText() = " + dc.list1.get(i).getText());
            System.out.println("dc.list2.get(i).getText() = " + dc.list2.get(i).getText());

            logger.info(GWD.threadBrowserName.get() +" "+" Gelen ekranda \"The Circus\"a ait \"Director\",\"Writer\" ve \"Stars\" bilgilerinin kayit edilen bilgilerle ayni olup olmadigi test edilir");
        }
    }

    @And("Kontroller yapildiktan sonra “Photos” linkine tiklanir")
    public void kontrollerYapildiktanSonraPhotosLinkineTiklanir()
    {

            dc.findAndGetAttribute("photosButton","href");
            logger.info(GWD.threadBrowserName.get() +" "+" Photos butonuna tiklandi");
    }
    @Then("Gelen ekranda butun fotograflarin linklerinin kirik olmadigi kontrol edilir")
    public void gelenEkrandaButunFotograflarinLinklerininKirikOlmadigiKontrolEdilir()
    {
        dc.findAndVerifyImages("allPhotos");
        logger.info(GWD.threadBrowserName.get() +" "+" Gelen ekranda fotograflarin linklerinin kirik olup olmadigi test edilir");

    }
}



