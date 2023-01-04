package parallel.steps;

import POM.HomePage;
import POM.RumahTanggaCategoryPage;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import parallel.appHooks.Hooks;

public class ProductSteps {
    private Hooks hooks;

    public ProductSteps(Hooks hooks) {
        this.hooks = hooks;
    }

    private HomePage homePage;

    private RumahTanggaCategoryPage rumahTanggaCategoryPage;

    @Then("Verify {string} category label is displayed")
    public void verify_category_label_is_displayed(String category) {
        rumahTanggaCategoryPage= new RumahTanggaCategoryPage(DriverFactory.getDriver());
        rumahTanggaCategoryPage.scrollIntoCategory(category);
        rumahTanggaCategoryPage.verifyCategoryMessage(category);
    }
}
