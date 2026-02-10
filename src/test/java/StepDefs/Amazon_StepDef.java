package StepDefs;

import Drivers.DriverManager;
import PomClass.PageClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static PomClass.BaseClass.launchURL;

public class Amazon_StepDef {

    PageClass page = new PageClass(DriverManager.getDriver());


    @Given("user launch the browser and url")
    public void user_launch_the_browser_and_url() {
        launchURL();
    }

    @When("user search the product")
    public void user_search_the_product() {
        page.searchProduct();
    }

    @When("user clicks the product")
    public void user_clicks_the_product() {
        page.selectProduct();
    }

    @Then("verify the product details page")
    public void verify_the_product_details_page() {
        Assert.assertTrue(page.txtTitle.isDisplayed());
    }

}
