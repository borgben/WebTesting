package marketAlertUM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.MarketAlertUM.MarketUMLogin;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    MarketUMLogin marketUMLogin;
    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\benja\\webtesting\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        this.marketUMLogin = new MarketUMLogin(driver);
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        this.marketUMLogin.login("5b403bf6-4f10-4bb3-ba93-54a4513864e2");
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        Assertions.assertEquals("https://www.marketalertum.com/Alerts/List",marketUMLogin.getCurrentURL());
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {
        this.marketUMLogin.login("ben");
    }

    @Then("I should see the login page")
    public void iShouldSeeTheLoginPage() {
        Assertions.assertEquals("https://www.marketalertum.com/Alerts/Login",marketUMLogin.getCurrentURL());
    }

}
