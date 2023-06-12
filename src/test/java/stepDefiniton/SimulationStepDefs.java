package stepDefiniton;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SimulationStepDefs {
    static WebDriver webDriver;
    static FluentWait wait ;
    public static final String FORM = "//form/div[1]/";
    public static final String INPUT1 = FORM + "div[1]/div/input";
    public static final String INPUT2 = FORM + "div[2]/div/input";
    @BeforeAll
    public static void setUp()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver= new ChromeDriver(chromeOptions);
         wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("I am on the simulation website")
    public void iAmOnTheSimulationWebsite() {
        webDriver.get("https://moncredit.sgmaroc.com/credit/personnel/");
    }

    @Then("I select my job type as {string}")
    public void iSelectMyJobTypeAs(String jobType) {
        locateElement(By.xpath("//form/div[1]/div/div[1]/div/label/div")).click();
        nextStep(webDriver);
    }

    @And("I enter my monthly pay as {string} and other monthly income as {string}")
    public void iEnterMyMonthlyPayAsAndOtherMonthlyIncomeAs(String monthlyPay, String monthlyIncome) {
        waitForElement();
        locateElement(By.xpath(INPUT1)).sendKeys(monthlyPay);
        locateElement(By.xpath(INPUT2)).sendKeys(monthlyIncome);
        nextStep(webDriver);
    }

    @And("I enter my monthly property charges as {string} and other monthly charges as {string}")
    public void iEnterMyMonthlyPropertyChargesAsAndOtherMonthlyChargesAs(String monthlyPropertyCharges, String otherMonthlyCharges) {
        waitForElement();
        locateElement(By.xpath(INPUT1)).sendKeys(monthlyPropertyCharges);
        locateElement(By.xpath(INPUT2)).sendKeys(otherMonthlyCharges);
        nextStep(webDriver);
    }

    @And("I enter the loan amount as {string}")
    public void iEnterTheLoanAmountAs(String loanAmount) {
        waitForElement();
        locateElement(By.xpath(FORM + "div/div/div/div[1]/span/span[1]/button[1]")).click();
        locateElement(By.xpath(FORM + "div/div/div/div[1]/span/span[3]/input")).sendKeys(loanAmount);
        locateElement(By.xpath(FORM + "div/div/div/div[1]/span/span[1]/button[2]")).click();
        nextStep(webDriver);
    }

    @And("I enter my birthday as {string} and loan duration as {string}")
    public void iEnterMyBirthdayAsBirthdayAndLoanDurationAs(String birthday,String loanDuration) {
        waitForElement();
        locateElement(By.xpath(INPUT1)).sendKeys(birthday);
        locateElement(By.xpath(FORM + "div[2]/div/div[1]/span/span[1]/button[1]")).click();
        locateElement(By.xpath(FORM + "div[2]/div/div[1]/span/span[3]/input")).sendKeys(loanDuration);
        locateElement(By.xpath(FORM + "div[2]/div/div[1]/span/span[1]/button[2]")).click();
        nextStep(webDriver);
    }

    @And("I provide my first name as {string} and last name as {string}")
    public void iProvideMyFirstNameAsAndLastNameAs(String firstname, String lastname) {
        waitForElement();
        locateElement(By.xpath(INPUT1)).sendKeys(firstname);
        locateElement(By.xpath(INPUT2)).sendKeys(lastname);
        nextStep(webDriver);
    }

    @And("i set my email to {string}")
    public void iSetMyEmailToEmail(String email) {
        waitForElement();
        locateElement(By.xpath(INPUT1)).sendKeys(email);
        nextStep(webDriver);
    }

    @And("I provide my phone number as {string}")
    public void iProvideMyPhoneNumberAs(String phoneNumber) {
        waitForElement();
        locateElement(By.xpath(FORM + "div/div[2]/input")).sendKeys(phoneNumber);
        nextStep(webDriver);
    }

    @And("I accept the legal terms")
    @SneakyThrows
    public void iAcceptTheLegalTerms() {
        Thread.sleep(10000);
        locateElement(By.xpath("//div[3]/div/div/div/div[2]/div[1]/div[1]/label")).click();
        locateElement(By.xpath("//div[3]/div/div/div/div[3]/div/button[2]")).click();
    }

    @And("I enter the OTP")
    public void iEnterTheOTP() {
    }

    @Then("the mensualite should be {string}")
    public void theMensualiteShouldBe(String mensualite) {
    }
    @SneakyThrows
    public static void waitForElement()  {
        Thread.sleep(3000);
    }

    private static void nextStep(WebDriver driver) {
        driver.findElement(By.xpath("//form/div[2]/div/button")).click();
    }
    private static WebElement locateElement(By by)
    {
        return  webDriver.findElement(by);
    }
}
