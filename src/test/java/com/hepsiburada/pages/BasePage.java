package com.hepsiburada.pages;

import com.hepsiburada.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-input']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@id='shoppingCart']")
    public WebElement sepetim;

    @FindBy(xpath = "//span[.='Giriş Yap']")
    public WebElement girisYapButon;

    @FindBy(xpath = "//span[@class='sf-OldMyAccount-1k66b']")
    public WebElement hesabım;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//a[@id='register']")
    public WebElement uyeOl;

    @FindBy(xpath = "//a[.='Beğendiklerim']")
    public WebElement begendiklerim;

    @FindBy(xpath = "//a[@class='sf-OldHeader-1NFKi']")
    public WebElement Anasayfa;

    @FindBy(xpath = "//div[@class='SearchBoxOld-buttonContainer']")
    public WebElement AraButon;

    @FindBy(xpath = "//li//span[text()='Elektronik']")
    public WebElement Elektronik;

    @FindBy(xpath = "//li//span[text()='Moda']")
    public WebElement Moda;

    @FindBy(xpath = "//li//span[text()='Ev, Yaşam, Kırtasiye, Ofis']")
    public WebElement EvYasamKırtOfis;

    @FindBy(xpath = "//li//span[text()='Oto, Bahçe, Yapı Market']")
    public WebElement OtoBahceYapıMarket;

    @FindBy(xpath = "//li//span[text()='Anne, Bebek, Oyuncak']")
    public WebElement AnneBebekOyuncak;

    @FindBy(xpath = "//li//span[text()='Spor, Outdoor']")
    public WebElement SporOutdoor;

    @FindBy(xpath = "//li//span[text()='Kozmetik, Kişisel Bakım']")
    public WebElement KozmetikKisiselBakım;

    @FindBy(xpath = "//li//span[text()='Süpermarket, Pet Shop']")
    public WebElement SuperMarPetShop;

    @FindBy(xpath = "//li//span[text()='Kitap, Müzik, Film, Hobi']")
    public WebElement KitapMuzikFilmHobi;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void checkAlert() {

        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.get().switchTo().alert();
            System.out.println(alert.getText());
            alert.dismiss();
        } catch (Exception e) {

        }
    }

}

