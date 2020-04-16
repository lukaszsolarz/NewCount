import org.apache.http.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    String name="****@gmail.com";
    String password ="********";

        @BeforeEach
        public void driverSetup()

        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            driver = new ChromeDriver();
            openStartPage();
        }

        @AfterEach
        public  void closeAndQuite()
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }

        @Test 
        public void GoToApplications()
        {
            Login(name,password);
        }

        @Test
         public void Wyszukiwanie()
        {
            KliknijWPasek();
            WpiszHaslo();
            KliknijWyszukaj();
        }

        private void openStartPage()
        {
            driver.navigate().to("https://google.com");
        }

        private void KliknijWPasek()

        {
            WebElement PasekSzukania = (driver.findElement(By.cssSelector("input[title='Szukaj']"))) ;
            PasekSzukania.click();
        }

        private void WpiszHaslo()
        {
            WebElement PasekSzukania = (driver.findElement(By.cssSelector("input[title='Szukaj']"))) ;
            PasekSzukania.sendKeys("Nasa");
        }

        private  void KliknijWyszukaj()
        {
            WebElement ButtonSzukaj = (driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")));
        }

        private void Login (String name, String password)
        {
            driver.findElement(By.xpath("//*[text()='Zaloguj się']")).click();
            WebElement nameField= driver.findElement(By.xpath("//input[@aria-label='Adres e-mail lub telefon']"));
            nameField.sendKeys(name);
            WebElement next = driver.findElement(By.xpath("//div[@id='identifierNext']"));
            next.click();
        }
}
