import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    WebDriver driver;

    @BeforeEach
    public void driverSetup()

        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }

        @AfterEach

        public  void closeAndQuite()
        {
            driver.quit();
        }

        @Test
         public void Wyszukiwanie()
        {
            openStartPAge();
            KliknijWPasek();
            WpiszHaslo();
            KliknijWyszukaj();

        }

        private void openStartPAge()
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
}
