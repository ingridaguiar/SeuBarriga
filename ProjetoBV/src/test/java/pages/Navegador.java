package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Navegador {
    protected WebDriver navegador;

    public Navegador (WebDriver navegador){
        this.navegador = navegador;
    }

    public String alertaSucessoLogin(){
        return navegador.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
    }

    public String alertaFalhaLogin(){
        return navegador.findElement(By.xpath("//div[contains(text(),'Problemas com o login do usuário')]")).getText();
    }

    public String alertaSucessoNovoUsuario(){
        return navegador.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
    }

    public String alertaFalhaNovoUsuario(){
        return navegador.findElement(By.xpath("//div[contains(text(),'Endereço de email já utilizado')]")).getText();
    }


}
