package com.hepsiburada.pages;

import com.hepsiburada.utils.BrowUtils;
import com.hepsiburada.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div/h1[@class='keyword']")
    public WebElement resultKeyword;

    @FindBy(xpath = "//a[.='En Çok Satanlar']")
    public WebElement enCokSatanlar;

    @FindBy(xpath = "//a[.='Değerlendirme Sayısı']")
    public WebElement degerlendirmeSayisi;

    @FindBy(xpath = "//a[.='Artan Fiyat']")
    public WebElement artanFiyat;

    @FindBy(xpath = "//a[.='Azalan Fiyat']")
    public WebElement azalanFiyat;


    public void getPageNum(String num){
        String pagePath = "//a[@class='page-"+ num + " ']";
        WebElement pageNum = Driver.get().findElement(By.xpath(pagePath));
        BrowUtils.scrollToElement(pageNum);

        BrowUtils.waitForClickablility(pageNum, 5);
        pageNum.click();

    }

    public void verifyPage(String num){

        String pagePath = "//a[@class='page-"+ num + " active']";
        WebElement pageNum = Driver.get().findElement(By.xpath(pagePath));
        BrowUtils.scrollToElement(pageNum);

        BrowUtils.waitForClickablility(pageNum, 5);
        String pageVerify = pageNum.getAttribute("href");
        System.out.println(pageVerify);
        Assert.assertTrue(pageVerify.endsWith("2"));
    }
}
