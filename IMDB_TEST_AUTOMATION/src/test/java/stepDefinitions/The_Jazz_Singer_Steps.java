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

public class The_Jazz_Singer_Steps {

    dialogContent dc=new dialogContent();

    private static final Logger logger = LogManager.getLogger(The_Jazz_Singer_Steps.class);

    @Then("“Honorary Award” basligi altinda The Jazz Singer secilir")
    public void honoraryAwardBasligiAltindaTheJazzSingerSecilir()
    {
        dc.findAndClick("cazMugannisi");
        logger.info(GWD.threadBrowserName.get() +" Honorary Award basligi altinda \"The Jazz Singer\" secilir");

    }

    @And("Gelen ekranda, filme ait; Director, Writer ve Stars bilgileri kayit edilir")
    public void gelenEkrandaFilmeAitDirectorWriterVeStarsBilgileriKayitEdilir() {
        dc.findAndAddToTheList("directorWriterStarsTheJazzSinger");
        logger.info(GWD.threadBrowserName.get() +" Gelen ekranda, filme ait; Director, Writer ve Stars bilgileri kayit edilir");
    }

    @Then("Gelen ekranda; The Jazz Singer'a ait Director, Writer ve Stars bilgisi kayit edilen bilgilerle ayni mi kontrol edilir")
    public void gelenEkrandaTheJazzSingerAAitDirectorWriterVeStarsBilgisiKayitEdilenBilgilerleAyniMiKontrolEdilir() {
        dc.findAndAddToTheList("directorWriterStarsTheJazzSinger2");
        for (int i=0; i<dc.list3.size(); i++) {
            Assert.assertEquals(dc.list3.get(i).getText(), dc.list4.get(i).getText());
            System.out.println("dc.list3.get(i).getText() = " + dc.list3.get(i).getText());
            System.out.println("dc.list4.get(i).getText() = " + dc.list4.get(i).getText());

            logger.info(GWD.threadBrowserName.get() +" "+" Gelen ekranda \"The Jazz Singer\"a ait \"Director\",\"Writer\" ve \"Stars\" bilgilerinin kayit edilen bilgilerle ayni olup olmadigi test edilir");

        }
    }

    @Given("Arama cubuguna “The Jazz Singer” yazilir")
    public void aramaCubugunaTheJazzSingerYazilir()
    {
        dc.findAndSend("searchBar","The Jazz Singer");
        logger.info(GWD.threadBrowserName.get() + " Arama cubuguna \"The Jazz Singer\" yazilir");
    }

    @When("Sonuclar arasinda gelen “The Jazz Singer”a tiklanir")
    public void sonuclarArasindaGelenTheJazzSingerATiklanir() {

        dc.findAndWaitUntilVisible("listbox");
        dc.findAndClick("theJazzSinger");
        logger.info(GWD.threadBrowserName.get() +" Sonuclar arasinda gelen \"The Jazz Singer\" a tiklanir");
    }
}
