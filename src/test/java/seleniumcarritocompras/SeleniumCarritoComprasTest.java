package seleniumcarritocompras;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumCarritoComprasTest {
    private WebDriver driver;
    
@Before
public void SetUp(){
    String baseUrl = "http://localhost:8080/CarritoCompras/";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        
    System.setProperty("webdriver.chrome.driver", chromePath);
    driver = new ChromeDriver();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
} 
    
@Test
public void validarNombreProducto() {
    driver.findElement(By.xpath("//a[@href='Controlador?accion=home']")).click();
    //Obtener texto del producto
    String textoActualproducto = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")).getText();
    //Variable con valor esperado
    String textoEsperadoproducto = "producto 1";
    assertEquals(textoActualproducto, textoEsperadoproducto);
        // TODO review the generated test code and remove the default call to fail.
        if(!textoActualproducto.equals(textoEsperadoproducto)) {
            fail("ERROR: Se esperaba el valor Descripcion producto 1");
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}