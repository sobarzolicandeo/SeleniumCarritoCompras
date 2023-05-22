package seleniumcarritocompras;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumCarritoComprasTest {
    private WebDriver driver;

@BeforeClass
public static void deleteFolder() throws Exception {
    String imageFileDir = System.getProperty("user.dir") + "/screenshots";
    FileUtils.deleteDirectory(new File(imageFileDir));
}

@Before
public void SetUp() throws Exception{
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
    try {
        takeScreenShot("CP-UE02-1_ValidarNombreProducto_"+timestamp()+".png");// Capture screenshot of current state
    } catch (IOException ex) {
        Logger.getLogger(SeleniumCarritoComprasTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Test
    public void validarDescripcionProducto() {
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
    try {
        takeScreenShot("CP-UE04-1_ValidarDescripcionProducto_"+timestamp()+".png");// Capture screenshot of current state
    } catch (IOException ex) {
        Logger.getLogger(SeleniumCarritoComprasTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
    
    private void takeScreenShot(String fname) throws IOException {
        // Capture the screenshot
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Specify the destination path for the screenshot file
        String destinationPath = System.getProperty("user.dir") + "/screenshots";
        // Save the screenshot to the specified path
        FileUtils.copyFile(screenshotFile, new File(destinationPath + "/" + fname));
    }
    
    public static String timestamp() {
        return new SimpleDateFormat("MM-dd-yyyy_HH.mm.ss").format(new Date());
    }
    
}
