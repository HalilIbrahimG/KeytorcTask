package com.hepsiburada.stepDefs;

import com.hepsiburada.pages.DashboardPage;
import com.hepsiburada.pages.LoginPage;
import com.hepsiburada.pages.SearchPage;
import com.hepsiburada.pages.SepetPage;
import com.hepsiburada.utils.BrowUtils;
import com.hepsiburada.utils.ConfReader;
import com.hepsiburada.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class task_definitions {

    @Given("the user is on the dashboard")
    public void the_user_is_on_the_dashboard() {
        String url = ConfReader.get("url");
        Driver.get().get(url);
        String titleOfDashboard = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(titleOfDashboard, Driver.get().getTitle());
    }

    @When("the user is on the login page and logged in")
    public void the_user_is_on_the_login_page_and_logged_in() {

        DashboardPage dashboardPage = new DashboardPage();
        BrowUtils.waitForVisibility(dashboardPage.girisYapButon, 3);
        BrowUtils.hover(dashboardPage.girisYapButon);
        dashboardPage.login.click();

        LoginPage loginPage = new LoginPage();
        BrowUtils.waitForClickablility(loginPage.username, 5);

        loginPage.username.sendKeys(ConfReader.get("username"));
        loginPage.password.sendKeys(ConfReader.get("password"));
        loginPage.loginButton.click();

    }

    @Then("the user sendKeys {string} keyword to search")
    public void the_user_sendKeys_keyword_to_search(String keyword) {

        DashboardPage dashboardPage = new DashboardPage();
        BrowUtils.waitFor(5);
        dashboardPage.searchBox.sendKeys(keyword);
        dashboardPage.AraButon.click();

    }

    @Then("the user goes to page {string} from opened page")
    public void the_user_goes_to_page_from_opened_page(String pageNum) {

        SearchPage searchPage = new SearchPage();
        searchPage.getPageNum(pageNum);
        searchPage.verifyPage(pageNum);
    }

    String productName = "";

    @Then("the user adds the {string} th element of the table to the favourite")
    public void the_user_adds_the_th_element_of_the_table_to_the_favourite(String tableElement) {
        String favouriteButtonPath = "//div[@id='heartWrapper' and @data-position='" + tableElement + "']";
        WebElement favourite = Driver.get().findElement(By.xpath(favouriteButtonPath));
        BrowUtils.scrollToElement(favourite);
        BrowUtils.waitForClickablility(favourite, 10);
        favourite.click();

        String elementNamePath = "//a[@data-position='" + tableElement + "']//h3";
        WebElement elementName = Driver.get().findElement(By.xpath(elementNamePath));
        productName = elementName.getAttribute("title");

    }

    @Then("the user should see the selected option in the favourite")
    public void the_user_should_see_the_selected_option_in_the_favourite() {

        SearchPage searchPage = new SearchPage();
        BrowUtils.scrollToElement(searchPage.hesabım);
        BrowUtils.hover(searchPage.hesabım);
        BrowUtils.waitForClickablility(searchPage.begendiklerim, 5);
        searchPage.begendiklerim.click();

        SepetPage sepetPage = new SepetPage();
        BrowUtils.scrollToElement(sepetPage.favouriteProductName);
        BrowUtils.waitForClickablility(sepetPage.favouriteProductName, 5);
        Assert.assertEquals(productName, sepetPage.favouriteProductName.getText());
    }

    @Then("the user will remove the product in the favorites and verify that it has been removed")
    public void the_user_will_remove_the_product_in_the_favorites_and_verify_that_it_has_been_removed() {

        SepetPage sepetPage = new SepetPage();
        BrowUtils.scrollToElement(sepetPage.favouriteProductName);
        BrowUtils.hover(sepetPage.optionButtonOfProduct);
        sepetPage.optionButtonOfProduct.click();

        sepetPage.deleteFromList.click();
        BrowUtils.waitForVisibility(sepetPage.emptyListMessage, 5);

    }
}
