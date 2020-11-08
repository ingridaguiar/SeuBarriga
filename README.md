# SeuBarriga
Instruções para rodar o Projeto:

 1 - Possuir o jdk1.8.0_271;
 
 2 - Navegador utilizado para testes foi ChromeDriver, portanto, é necessário obter o arquivo chromedriver.exe 
     compátivel com a Versão 86.0.4240.183; 
     
 3 - Importar Projeto na IDE; 
 
 4 - No pacote "suporte", clicar na Classe "Web" e alterar o caminho do arquivo chromedriver.exe (Linha 10)
     [ System.setProperty("webdriver.chrome.driver", "C:\\Prova\\chromedriver_win32\\chromedriver.exe")];
     
 5 - Importar todas as dependências existentes no arquivo pom.xml;
 
 6 - Acessar a classe principal de Testes "SeuBarrigaTestes" e clicar em "Run Test";
 
 7 - Todos a massa de dados necessária para a realização dos testes está contida no arquivo "SeuBarrigaTestes.csv".
     Caso deseje alterar as informações de dados, as mesmas deverão ser alteradas nesse documento.
 
Observações: 
Caso deseje verificar como a Página ficou após a realização dos testes, 
é necessário comentar o comando "navegador.quit()" existente no @After. 

Caso contrário, após a realização dos testes, todas as páginas serão fechadas automáticamente. 

-------------------------------------CASOS DE TESTES E SEUS RESPECTIVOS MÉTODOS ---------------------------------------

US1: Como usuário, desejo que meus dados sejam de acesso restrito a mim via autenticação a fim de que tenha sigilo para os mesmos.

Validação do acesso ao sistema com as credeciais corretas: testAcessarSistemaSucesso.

Validação do acesso ao sistema com as credeciais erradas: testAcessarSistemaFalha.

US2: Como administrador do sistema, desejo que usuários se cadastrem na aplicação a fim de obter as credenciais de acesso.

Validação da criação de um novo usuário para o sistema: testNovoUsuarioSucesso.

Validação da duplicidade na criação de um novo usuário para o sistema: testNovoUsuarioFalha.

US3: Como usuário, desejo gerenciar minhas contas a fim de controlar minhas movimentações financeiras.

○ R1: Contas com movimentação não podem ser excluídas: testContaComMovimentacao.

○ R2: Contas não podem ter o mesmo nome: testCadastrarContaEmDuplicidade.

US4: Como usuário, desejo lançar minhas movimentações de crédito ou débito selecionando uma conta pré-cadastrada a fim de aplicar as movimentações na conta correta.

○ R1: Campos Obrigatórios: Data da Movimentação, Data do Pagamento (Caso “Pago” esteja marcado)}: testCamposObrigatorios.

○ R2: Campos de data devem ter formato DD/MM/AAAA: testFormatoData.

○ R3: Movimentações não podem acontecer em datas futuras: testDataFutura.

US5: Como usuário, desejo ser capaz de encerrar uma sessão iniciada a fim de que meu acesso seja encerrado: testSairdoSistema.
