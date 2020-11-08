package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import pages.*;
import suporte.*;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "SeuBarrigaTestes.csv")

public class SeuBarrigaTestes {

    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    //Como usuário, desejo que meus dados sejam de acesso restrito a mim via autenticação a fim de que tenha sigilo para os mesmos
    public void testAcessarSistemaSucesso(@Param(name="login") String login,
                                          @Param(name="senha") String senha,
                                          @Param(name="mensagem") String mensagemEsperada){
        String alertaSucesso = new LoginPage(navegador).acessarSistema(login,senha).alertaSucessoLogin();
        assertEquals(mensagemEsperada,alertaSucesso);
    }

    @Test
    public void testAcessarSistemaFalha(@Param(name="login") String login,
                                        @Param(name="senha") String senha,
                                        @Param(name="mensagem") String mensagemEsperada){
        String alertaFalha = new LoginPage(navegador).informarLogin(login).informarSenha(senha).clicarEntrar().alertaFalhaLogin();
        assertEquals(mensagemEsperada,alertaFalha);
    }

    @Test
    //US2: Como administrador do sistema, desejo que usuários se cadastrem na aplicação a fim de obte as credenciais de acess
    public void testNovoUsuarioSucesso(@Param(name="nome") String nome,
                                       @Param(name="email") String email,
                                       @Param(name="senha") String senha,
                                       @Param(name="mensagem") String mensagemEsperada){
        String alertaSucesso = new LoginPage(navegador).clicarNovoUsuario().cadastrarNovoUsuario(nome,email,senha).alertaSucessoNovoUsuario();
        assertEquals(mensagemEsperada,alertaSucesso);
    }

    @Test
    public void testNovoUsuarioFalha(@Param(name="nome") String nome,
                                       @Param(name="email") String email,
                                       @Param(name="senha") String senha,
                                       @Param(name="mensagem") String mensagemEsperada){
        String alertaFalha = new LoginPage(navegador).clicarNovoUsuario().cadastrarNovoUsuario(nome,email,senha).alertaFalhaNovoUsuario();
        assertEquals(mensagemEsperada,alertaFalha);
    }

    @Test
    //US3 -	R1: Contas com movimentação não podem ser excluídas
    public void testContaComMovimentacao(@Param(name="login") String login,
                                         @Param(name="senha") String senha,
                                         @Param(name="mensagem") String mensagemEsperada){

        String alertaErro = new LoginPage(navegador).acessarSistema(login, senha)
                                                    .acessarMenuContas()
                                                    .clicarListarContas()
                                                    .removerContacomMovimentacao()
                                                    .alertaContaComMovimentacao();
        assertEquals(mensagemEsperada,alertaErro);
    }

    @Test
    //US3 -	R2: Contas não podem ter o mesmo nome
    public void testCadastrarContaEmDuplicidade(@Param(name="login") String login,
                                                @Param(name="senha") String senha,
                                                @Param(name="conta") String conta,
                                                @Param(name="mensagem") String mensagemEsperada){

        String alertaContaJaExiste = new LoginPage(navegador).acessarSistema(login, senha)
                                                             .acessarMenuContas()
                                                             .clicarAdicionarContas()
                                                             .informarConta(conta)
                                                             .salvarConta()
                                                             .alertaJaExiste();

        assertEquals(mensagemEsperada,alertaContaJaExiste);
    }

    //US4: Como usuário, desejo lançar minhas movimentações de crédito ou débito selecionando uma conta pré-cadastrada a fim de aplicar as movimentações na conta correta
    //R1: Campos Obrigatórios: Data da Movimentação, Data do Pagamento (Caso “Pago” esteja marcado)

    @Test
    public void testCamposObrigatorios(@Param(name="login") String login,
                                       @Param(name="senha") String senha,
                                       @Param(name="transacao") String transacao,
                                       @Param(name="pagamento") String pagamento,
                                       @Param(name="descricao") String descricao,
                                       @Param(name="interessado") String interessado,
                                       @Param(name="valor") String valor,
                                       @Param(name="mensagem01") String mensagemEsperada,
                                       @Param(name="mensagem02") String mensagemEsperada02){

        new LoginPage(navegador).acessarSistema(login, senha)
                                .acessarMenuMovimentacao()
                                .informarMovimentacao(transacao, pagamento, descricao, interessado,valor)
                                .salvarMovimentacao();

        String alertaData01 = new MovimentacaoPage(navegador).alertaDataMovimentacao();
        assertEquals(mensagemEsperada,alertaData01);

        String alertaData02 = new MovimentacaoPage(navegador).alertaDataPagamento();
        assertEquals(mensagemEsperada02,alertaData02);
    }

    //R2: Campos de data devem ter formato DD/MM/AAAA

    @Test
    public void testFormatoData(@Param(name="login") String login,
                                @Param(name="senha") String senha,
                                @Param(name="transacao") String transacao,
                                @Param(name="pagamento") String pagamento,
                                @Param(name="descricao") String descricao,
                                @Param(name="interessado") String interessado,
                                @Param(name="valor") String valor,
                                @Param(name="mensagem01") String mensagemEsperada01,
                                @Param(name="mensagem02") String mensagemEsperada02){


        new LoginPage(navegador).acessarSistema(login, senha)
                .acessarMenuMovimentacao()
                .informarMovimentacao(transacao, pagamento, descricao, interessado,valor)
                .salvarMovimentacao();

        String alertaFormatoDM = new MovimentacaoPage(navegador).alertaFormatoDataMovimentacao();
        assertEquals(mensagemEsperada01,alertaFormatoDM);

        String alertaFormatoDP = new MovimentacaoPage(navegador).alertaFormatoDataPagamento();
        assertEquals(mensagemEsperada02,alertaFormatoDP);

    }

    //R3: Movimentações não podem acontecer em datas futuras
    @Test
    public void testDataFutura(@Param(name="login") String login,
                               @Param(name="senha") String senha,
                               @Param(name="transacao") String transacao,
                               @Param(name="pagamento") String pagamento,
                               @Param(name="descricao") String descricao,
                               @Param(name="interessado") String interessado,
                               @Param(name="valor") String valor,
                               @Param(name="mensagem") String mensagemEsperada){

        String alertaDF = new LoginPage(navegador).acessarSistema(login, senha)
                .acessarMenuMovimentacao()
                .informarMovimentacao(transacao, pagamento, descricao, interessado,valor)
                .salvarMovimentacao().alertaDataFutura();

        assertEquals(mensagemEsperada,alertaDF);

    }

    //US5: Como usuário, desejo ser capaz de encerrar uma sessão iniciada a fim de que meu acesso seja encerrado

    @Test
    public void testSairdoSistema(@Param(name="login") String login,
                                  @Param(name="senha") String senha,
                                  @Param(name="mensagem") String mensagemEsperada){

    String logout = new LoginPage(navegador).acessarSistema(login,senha).clicarSair().confirmacaoLogout();
    assertEquals(mensagemEsperada, logout);
    }

    @After
    public void tearDown() {
        navegador.quit();
    }

}
