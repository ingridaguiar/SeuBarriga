package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovimentacaoPage extends Navegador{
    public MovimentacaoPage(WebDriver navegador) {
        super(navegador);
    }

    public MovimentacaoPage informarMovimentacao(String transacao,
                                                 String pagamento,
                                                 String descricao,
                                                 String interessado,
                                                 String valor){

        navegador.findElement(By.xpath("//input[@id='data_transacao']")).sendKeys(transacao);
        navegador.findElement(By.xpath("//input[@id='data_pagamento']")).sendKeys(pagamento);
        navegador.findElement(By.xpath("//input[@id='descricao']")).sendKeys(descricao);
        navegador.findElement(By.xpath("//input[@id='interessado']")).sendKeys(interessado);
        navegador.findElement(By.xpath("//input[@id='valor']")).sendKeys(valor);

        //navegador.findElement(By.xpath("//label[contains(text(),'Pago')]")).click();

        return this;
    }

    public MovimentacaoPage salvarMovimentacao(){
        navegador.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();
        return this;
    }

    public String alertaDataMovimentacao(){
        return navegador.findElement(By.xpath("//li[contains(text(),'Data da Movimentação é obrigatório')]")).getText();
    }

    public String alertaDataPagamento(){
        return navegador.findElement(By.xpath("//li[contains(text(),'Data do pagamento é obrigatório')]")).getText();
    }

    public String alertaFormatoDataMovimentacao(){
        return navegador.findElement(By.xpath("//li[contains(text(),'Data da Movimentação inválida (DD/MM/YYYY)')]")).getText();
    }

    public String alertaFormatoDataPagamento(){
        return navegador.findElement(By.xpath("//li[contains(text(),'Data do pagamento inválida (DD/MM/YYYY)')]")).getText();
    }

    public String alertaDataFutura(){
        return navegador.findElement(By.xpath("//li[contains(text(),'Data da Movimentação deve ser menor ou igual à dat')]")).getText();
    }

}
