package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ContasPage extends Navegador {
    public ContasPage(WebDriver navegador) {
        super(navegador);
    }

    public ContasPage informarConta(String conta){
        navegador.findElement(By.xpath("//input[@id='nome']")).sendKeys(conta);
        return this;
    }
    public ContasPage salvarConta(){
        navegador.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();
        return this;
    }
    public ContasPage removerContacomMovimentacao() {
        navegador.findElement(By.xpath("//tbody/tr[1]/td[2]/a[2]/span[1]")).click();
        return this;
    }
    public String alertaContaComMovimentacao(){
        return navegador.findElement(By.xpath("//div[contains(text(),'Conta em uso na movimentações')]")).getText();
    }
    public String alertaJaExiste(){
        return navegador.findElement(By.xpath("//div[contains(text(),'Já existe uma conta com esse nome!')]")).getText();
    }

}

