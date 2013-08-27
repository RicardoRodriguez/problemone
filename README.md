problemone
==========

Solução do problema um apresentado pela Orga Systems:

Projeto ProgramOne:

1.	Pacotes
a.	net.itr2.connection: Realiza as conexões com os bancos de dados
b.	net.itr2.control: Realiza todas as operações de tratamento de erro do sistema
c.	net.itr2.main: Localização da classe principal
d.	net.itr2.model: Objetos POJO do sistema. Modelo de dados.
e.	net.itr2.test:  Realiza os testes unitários e suíte de testes
f.	net.itr2.util: Classes utilitárias do projeto
g.	net.itr2.view: Realiza as operações de apresentação visual de resultados e opções.

2.	Metodologia:
a.	Devido ao prazo estabelecido, utilizamos como apresentação visual System.console.
b.	Esta solução pode ser substituída a qualquer tempo utilizando o contrato ViewFactoryInterface
c.	O mesmo acontece com o acesso aos dados. Estou utilizando um Mock de memoria. Este mecanismo pode ser substituído através de ConnectionFactoryInterface.
d.	Os cálculos e rotas utilizadas utilizando o algoritmo de Dijkstra.

3.	Funcionamento:
a.	Compile o sistema (Dentro ou fora utilizando o Maven contido na pasta src -> pom.xml)
b.	O arquivo executável encontra-se no diretório bin.
c.	Execute o comando  java –jar ProblemOne-1.0.0.jar.

4.	Arquivo Manifest.mf criado pelo MAVEN:
fest-Version: 1.0
Built-By: ricardorodriguez
Build-Jdk: 1.6.0_51
Main-Class: net.itr2.main.Start
Created-By: Maven Integration for Eclipse

5.	O conteúdo deste documento encontra-se no arquivo src/README.md

