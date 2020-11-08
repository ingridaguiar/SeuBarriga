package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Prova\\chromedriver_win32\\chromedriver.exe");

        WebDriver navegador = new ChromeDriver();

        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://seubarriga.wcaquino.me/");

        return navegador;
    }
}
