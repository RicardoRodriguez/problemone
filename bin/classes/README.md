Projeto ProgramOne:

1.	Pacotes
	a.	net.itr2.connection: Realiza as conex�es com os bancos de dados
	b.	net.itr2.control: Realiza todas as opera��es de tratamento de erro do sistema
	c.	net.itr2.main: Localiza��o da classe principal
	d.	net.itr2.model: Objetos POJO do sistema. Modelo de dados.
	e.	net.itr2.test:  Realiza os testes unit�rios e su�te de testes
	f.	net.itr2.util: Classes utilit�rias do projeto
	g.	net.itr2.view: Realiza as opera��es de apresenta��o visual de resultados e op��es.

2.	Metodologia:
	a.	Devido ao prazo estabelecido, utilizamos como apresenta��o visual System.console.
	b.	Esta solu��o pode ser substitu�da a qualquer tempo utilizando o contrato ViewFactoryInterface
	c.	O mesmo acontece com o acesso aos dados. Estou utilizando um Mock de memoria. 
		Este mecanismo pode ser substitu�do atrav�s de ConnectionFactoryInterface.
	d.	Os c�lculos e rotas utilizadas utilizando o algoritmo de Dijkstra.

3.	Funcionamento:
	a.	Compile o sistema (Dentro ou fora utilizando o Maven contido na pasta src -> pom.xml)
	b.	O arquivo execut�vel encontra-se no diret�rio bin.
	c.	Execute o comando  java �jar ProblemOne-1.0.0.jar.

4.	Arquivo Manifest.mf criado pelo MAVEN:
			Manifest-Version: 1.0
			Built-By: ricardorodriguez
			Build-Jdk: 1.6.0_51
			Main-Class: net.itr2.main.Start
			Created-By: Maven Integration for Eclipse

5.	O conte�do deste documento encontra-se no arquivo src/README.md

6.	Demais informa��es entrar em contato com ricardo.domingos@gmail.com

