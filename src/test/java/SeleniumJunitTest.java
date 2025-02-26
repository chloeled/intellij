import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumJunitTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        // Configure WebDriverManager pour télécharger et configurer ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        // Crée une nouvelle instance de ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTitle() {
        // Accède à Google et vérifie que le titre est "Google"
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @AfterEach
    public void teardown() {
        // Ferme le navigateur après chaque test
        if (driver != null) {
            driver.quit();
        }
    }
}
