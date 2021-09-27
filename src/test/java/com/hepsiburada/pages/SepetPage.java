package com.hepsiburada.pages;

import com.hepsiburada.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SepetPage{

    public SepetPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div/h3")
    public WebElement favouriteProductName;

    @FindBy(css = ".hb-fznxLu")
    public WebElement optionButtonOfProduct;

    @FindBy(xpath = "//div[.='Listeden sil']")
    public WebElement deleteFromList;

    @FindBy(xpath = "//span[.=', listen şu an boş.']")
    public WebElement emptyListMessage;

    @FindBy(xpath = "//h5[.='Hediye Listelerim']")
    public WebElement forAppearingOfProduct;



}
