import com.tonnomd.rbac.LoginPage;
import com.tonnomd.rbac.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;

public class RoleBasedAccessTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testAdminAccess() {
        User admin = new User("admin", "adminPass", "admin");
        driver.get("http://localhost:8080/login"); // Assure-toi que l'URL correspond à la page de login

        loginPage.login(admin.getUsername(), admin.getPassword());

        // Vérifie si l'admin est redirigé vers la page d'administration
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    public void testUserAccess() {
        User user = new User("user", "userPass", "user");
        driver.get("http://localhost:8080/login");

        loginPage.login(user.getUsername(), user.getPassword());

        // Vérifie si l'utilisateur est redirigé vers une page d'utilisateur
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    public void testGuestAccess() {
        User guest = new User("guest", "", "guest");
        driver.get("http://localhost:8080/login");

        loginPage.login(guest.getUsername(), guest.getPassword());

        // Vérifie que l'invité ne peut pas accéder à des ressources protégées
        assertFalse(loginPage.isLoginSuccessful());
    }

    // Ajouter une méthode @After pour fermer le navigateur
}
