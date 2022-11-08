package marketAlertUM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.MarketAlertUM.MarketUMAdmin;
import org.MarketAlertUM.MarketUMAlert;
import org.MarketAlertUM.MarketUMLogin;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginSteps {
    MarketUMLogin marketUMLogin;
    MarketUMAdmin marketUMAdmin = new MarketUMAdmin();
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


    @Given("I am an administrator of the website and I upload {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAlerts(int arg0) throws IOException, InterruptedException {
        this.marketUMAdmin.clearAlerts();
        MarketUMAlert alert = new MarketUMAlert(1,"Test","TestDescription","https://olimpusmusic.com/product/adam-audio-t7v/","https://olimpusmusic.com/wp-content/uploads/2022/10/IT12575.jpg",21900);
        String alertJson = alert.alertToJson();
        for (int i =0; i<arg0; i++)
        {
            this.marketUMAdmin.postAlert(alertJson);
        }
    }


    @When("I view a list of alerts")
    public void iViewAListOfAlerts() {
        this.marketUMLogin.login("5b403bf6-4f10-4bb3-ba93-54a4513864e2");
        this.marketUMLogin.viewAlerts();
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertTrue(alert.findElement(By.xpath("//td[@colspan='2']")).findElements(By.tagName("img")).size() > 0);
        }

    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading()
    {
        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertNotEquals(alert.findElement(By.tagName("h4")).getText(),"");
        }
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {

        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertNotEquals(alert.findElements(By.tagName("td")).get(2).getText(),"");
        }
    }

    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertTrue(alert.findElement(By.xpath("//td[@rowspan='4']")).findElements(By.tagName("img")).size() > 0);
        }
    }

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertNotEquals(alert.findElements(By.tagName("td")).get(3).getText(),"");
        }
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        for(WebElement alert: this.marketUMLogin.getAlerts())
        {
            Assertions.assertNotEquals(alert.findElements(By.tagName("td")).get(4).findElement(By.tagName("a")).getAttribute("href"),"");
        }
    }

    @Given("I am an administrator of the website and I upload more than {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadMoreThanAlerts(int arg0) throws IOException, InterruptedException {
        this.marketUMAdmin.clearAlerts();
        MarketUMAlert alert = new MarketUMAlert(1,"Test","TestDescription","https://olimpusmusic.com/product/adam-audio-t7v/","https://olimpusmusic.com/wp-content/uploads/2022/10/IT12575.jpg",21900);
        String alertJson = alert.alertToJson();
        for (int i = arg0+1; i>0; i--)
        {
            this.marketUMAdmin.postAlert(alertJson);
        }
    }

    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
        Assertions.assertEquals(this.marketUMLogin.getAlerts().size(),arg0);
    }
}
