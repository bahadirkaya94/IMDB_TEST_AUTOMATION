package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.ArrayList;
import java.util.List;

public class dialogContent extends parent {

    public dialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "iconContext-menu")
    private WebElement menuButton;

    @FindBy(xpath = "//span[text()='Oscars']")
    private WebElement oscarsButton;

    @FindBy(linkText = "1929")
    private WebElement  eventHistory1929;

    @FindBy(linkText = "Şarlo Sirkte")
    private WebElement CharloAtTheCircusButton;

    @FindBy(linkText = "Caz Mugannisi")
    private WebElement cazMugannisi;

    @FindBy(xpath = "//div[@class='sc-fa02f843-0 iDXoEx']//ul//div//ul//li//a")
    private List<WebElement> directorWriterStarsTheCircus;

    @FindBy(xpath = "//div[@class='sc-fa02f843-0 iDXoEx']//ul//div//ul//li//a")
    private List<WebElement> directorWriterStarsTheJazzSinger;

    @FindBy(id = "home_img_holder")
    private WebElement homeButton;

    @FindBy(id = "suggestion-search")
    private WebElement searchBar;

    @FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list anim-enter-done']")
    private WebElement listbox;

    @FindBy(xpath = "//div[@class='sc-bjfHbI fOUGiO searchResult__constTitle' and text()='The Circus']")
    private WebElement theCircus;

    @FindBy(xpath = "(//div[@class='sc-bjfHbI fOUGiO searchResult__constTitle' and text()='The Jazz Singer'])[1]")
    private WebElement theJazzSinger;

    @FindBy(xpath = "//div[@class='sc-fa02f843-0 iDXoEx']//ul//div//ul//li//a")
    private List<WebElement> directorWriterStarsTheCircus2;

    @FindBy(xpath = "//div[@class='sc-fa02f843-0 iDXoEx']//ul//div//ul//li//a")
    private List<WebElement> directorWriterStarsTheJazzSinger2;

    @FindBy(xpath = "(//a[@class='ipc-title-link-wrapper'])[1]")
    private WebElement photosButton;

    @FindBy(xpath = "//div[@id='media_index_thumbnail_grid']//a//img")
    private List<WebElement> allPhotos;


    private WebElement myElement;
    private List<WebElement> myElements;

    public List<WebElement> list1=new ArrayList<>();
    public List<WebElement> list2=new ArrayList<>();

    public List<WebElement> list3=new ArrayList<>();

    public List<WebElement> list4=new ArrayList<>();

    private final List<String> brokenImageLinks=new ArrayList<>();


    public void findAndClick(String strElement){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "menuButton" : myElement = menuButton; break;
            case "oscarsButton" : myElement = oscarsButton; break;
            case "eventHistory1929": myElement = eventHistory1929; break;
            case "CharloAtTheCircusButton": myElement = CharloAtTheCircusButton; break;
            case "cazMugannisi": myElement = cazMugannisi; break;
            case "homeButton" : myElement = homeButton; break;
            case "theCircus" : myElement = theCircus; break;
            case "theJazzSinger" : myElement = theJazzSinger; break;
        }
        clickFunction(myElement);
    }

    public void findAndAddToTheList(String strElement) {
        switch (strElement) {
            case "directorWriterStarsTheCircus": myElements = directorWriterStarsTheCircus;
            list1 = waitVisibleListAllElement(myElements);
            for (WebElement l1 : list1) System.out.println("l1.getText() = " + l1.getText()); break;

            case "directorWriterStarsTheCircus2": myElements = directorWriterStarsTheCircus2;
            list2=waitVisibleListAllElement(myElements);
            for (WebElement l2: list2) System.out.println("l2.getText() = " + l2.getText()); break;

            case "directorWriterStarsTheJazzSinger": myElements = directorWriterStarsTheJazzSinger;
                list3=waitVisibleListAllElement(myElements);
                for (WebElement l3: list3) System.out.println("l3.getText() = " + l3.getText()); break;

            case "directorWriterStarsTheJazzSinger2": myElements = directorWriterStarsTheJazzSinger2;
                list4=waitVisibleListAllElement(myElements);
                for (WebElement l4: list4) System.out.println("l4.getText() = " + l4.getText()); break;

        }
    }

    public void findAndSend(String strElement, String value){
        // burda string isimden weblemente ulaşıcam
        if ("searchBar".equals(strElement)) {
            myElement = searchBar;
        }
        sendKeysFunction(myElement, value);
    }

    public Response imageCheck(String url)
    {
        return RestAssured.get(url);
    }

    public void findAndVerifyImages(String strElement) {
        if ("allPhotos".equals(strElement)) {
            myElements = allPhotos;
        }
        for (WebElement e : myElements) {
            if (imageCheck(e.getAttribute("src")).statusCode() != 200) {
                brokenImageLinks.add(e.getAttribute("src"));
                for (int i = 0; i < brokenImageLinks.size(); i++) {
                    System.out.println("brokenImageLinks.get(" + i + ") = " + brokenImageLinks.get(i));
                }
            }
        }
            if (brokenImageLinks.size() == 0)
                System.out.println("Kırık görsel linki bulunamamıştır");

    }

    public void findAndWaitUntilVisible(String strElement){
        if ("listbox".equals(strElement)) {
            myElement = listbox;
        }
        waitUntilVisible(myElement);
    }

    public void findAndGetAttribute(String strElement,String tag)
    {
        if ("photosButton".equals(strElement)) {
            myElement = photosButton;
        }
        String link = myElement.getAttribute(tag);
        GWD.getDriver().get(link);
    }
}

