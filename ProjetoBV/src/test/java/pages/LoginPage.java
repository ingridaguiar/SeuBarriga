package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Navegador{
    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginPage informarLogin(String login){
        navegador.findElement(By.id("email")).sendKeys(login);
        return this;
    }

    public LoginPage informarSenha(String senha){
        navegador.findElement(By.id("senha")).sendKeys(senha);
        return this;
    }

    public HomePage clicarEntrar(){
        navegador.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        return new HomePage(navegador);
    }

    public HomePage acessarSistema(String login, String senha){
        return informarLogin(login).informarSenha(senha).clicarEntrar();
    }

    public CadastroPage clicarNovoUsuario(){
        navegador.findElement(By.xpath("//a[contains(text(),'Novo usuário?')]")).click();
        return new CadastroPage(navegador);
    }

    public String confirmacaoLogout() {
        return navegador.findElement(By.xpath("//a[contains(text(),'Login')]")).getText();
    }
}
