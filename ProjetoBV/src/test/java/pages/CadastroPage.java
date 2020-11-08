package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage extends Navegador{

    public CadastroPage(WebDriver navegador) {
        super(navegador);
    }

    public CadastroPage informarNome(String nome){
        navegador.findElement(By.name("nome")).sendKeys(nome);
        return this;
    }

    public CadastroPage informarEmail(String email){
        navegador.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public CadastroPage informarSenha(String senha){
        navegador.findElement(By.id("senha")).sendKeys(senha);
        return this;
    }

    public LoginPage clicarCadastrar(){
        navegador.findElement(By.xpath("//input[@value=\"Cadastrar\"]")).click();
        return new LoginPage(navegador);
    }

    public LoginPage cadastrarNovoUsuario(String nome, String email, String senha){
        return informarNome(nome).informarEmail(email).informarSenha(senha).clicarCadastrar();
    }

}
