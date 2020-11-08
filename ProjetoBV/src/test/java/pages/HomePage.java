package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Navegador{
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public HomePage acessarMenuContas(){
        navegador.findElement(By.xpath("//body/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
        return this;
    }

    public ContasPage clicarListarContas(){
        navegador.findElement(By.xpath("//a[contains(text(),'Listar')]")).click();
        return new ContasPage(navegador);
    }

    public ContasPage clicarAdicionarContas(){
        navegador.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
        return new ContasPage(navegador);
    }

    public MovimentacaoPage acessarMenuMovimentacao(){
        navegador.findElement(By.xpath("//a[contains(text(),'Criar Movimentação')]")).click();
        return new MovimentacaoPage(navegador);
    }

    public LoginPage clicarSair(){
        navegador.findElement(By.xpath("//a[contains(text(),'Sair')]")).click();
        return new LoginPage(navegador);
    }

}
