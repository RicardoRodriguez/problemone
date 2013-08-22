/**
 * Singleton que implementa a interface ViewFactory.
 * Poderemos definir qualquer tipo de console a partir deste elemento.
 */
package net.itr2.view;

import java.io.Console;

import net.itr2.exception.Itr2ViewException;
import net.itr2.util.Util;

/**
 * @author ricardorodriguez
 *
 */
public class ConsoleView implements ViewFactoryInterface {

	public static final char ESC = 27;
	public static ConsoleView instance;
	
	private static final int DEFAULT_TIME=200;
	private Console console;
	private String from;
	private String to;
	/**
	 * 
	 */
	private ConsoleView() throws Itr2ViewException{
		console = System.console();
		if (console == null){
			throw new Itr2ViewException("Execute este programa a partir do diretorio bin em seu terminal." +
					"");
		}
	}
	
	public static ViewFactoryInterface getInstance() throws Itr2ViewException{

		if (instance == null) {
			instance = new ConsoleView();
		}
		return instance;
	}

	public void showScreen() throws Itr2ViewException {
	   clearScreen();
	   showOriginDestiny();
	   showMenu();
	   readOption();
	}

	private void showOriginDestiny() {
		console.writer().println("Origem do trajeto  :" + 
				(Util.isEmpty(from) ? "Nao definido":from ));
	
		console.writer().println("Destino do trajeto :" + 
				(Util.isEmpty(from) ? "Nao definido" : to ));
	

	}

	private void showStationList(String stationId){
		
	}
	
	private void showRoute() {
		// TODO Auto-generated method stub

	}



	private void showPaths() {
		// TODO Auto-generated method stub

	}

	private void showBestPath() {
		// TODO Auto-generated method stub

	}
	
	public void clearFromTo() throws Itr2ViewException{
		this.from = null;
		this.to = null;
		this.showScreen();
		
	}
	
	public void doExit() {
		System.exit(-1);
	}
	
	private void showMenu(){
	
		printBlankLines(2);
		
		console.writer().println(" Escolha uma das opcoes abaixo  ");
		console.writer().println(" =============================== ");
		
		printBlankLines(1);
		
		console.writer().println(" 1. Definir origem da viagem");
		console.writer().println(" 2. Definir destino da viagem ");
		console.writer().println(" 3. Distancia entre origem e destino");
		console.writer().println(" 4. Mostrar o melhor caminho");
		console.writer().println(" 5. Mostrar todos os caminhos");
		console.writer().println(" 6. Limpar origem e destino");
		printBlankLines(1);
		console.writer().println(" 0. Encerrar o programa");
		printBlankLines(1);		
		
	}

	private void readOption(){
		String readLine = System.console().readLine();
		try {
			int option = Util.toInteger(readLine);
			ProcessOptionView processOptionView = ProcessOptionView.getInstance();
			processOptionView.processOption(this,option);
			
		}catch (Itr2ViewException e){
			this.reloadOptions(e.getMessage());
			readOption(); 
		}

	}
	
	private void reloadOptions(String message){
		 console.writer().println(message + ". Pressione <Enter> para continuar." );
		 System.console().readLine();
		 try {
			this.showScreen();
		} catch (Itr2ViewException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * Limpa o conteudo da tela
	 * sleepTime Tempo de adormecimento da tela.
	 */
	private void clearScreen() throws Itr2ViewException{
		console.writer().print(ESC + "[2J");
		console.flush();
		try {
			Thread.sleep(DEFAULT_TIME);
		} catch (InterruptedException e) {
			throw new Itr2ViewException("Erro de interrupção. Mensagem do Sistema:"+ e.getMessage());
		}
	}
	
	/*
	 * Immprime linhas em branco
	 * quantity Quantidade de linhas em branco.
	 */
	
	private void printBlankLines(int quantity){
		for (int i =0 ; i < quantity ; ++i){
			console.writer().println();
		}
	}
	
}
