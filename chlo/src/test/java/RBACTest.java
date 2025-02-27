import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RBACTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAdminAccess() {
        driver.get("http://localhost/login");

        // Connexion en tant qu'admin
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.id("login-btn")).click();

        // Vérifie que l'admin peut voir le panneau d'administration
        Assertions.assertTrue(driver.findElement(By.id("admin-panel")).isDisplayed(),
                "L'admin ne peut pas accéder au panneau d'administration !");
    }

    @Test
    public void testUserRestriction() {
        driver.get("http://localhost/login");

        // Connexion en tant qu'utilisateur standard
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user123");
        driver.findElement(By.id("login-btn")).click();

        // Vérifie que l'utilisateur ne voit pas le panneau admin
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            driver.findElement(By.id("admin-panel"));
        }, "Un utilisateur a pu voir le panneau admin !");
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}