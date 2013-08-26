/**
 * Singleton que implementa a interface ViewFactory.
 * Poderemos definir qualquer tipo de console a partir deste elemento.
 */
package net.itr2.view;

import java.io.Console;
import java.util.List;

import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Route;
import net.itr2.model.Station;
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
	private Station from;
	private Station to;
	private ProcessOptionInterface processOptionView;


	/**
	 * 
	 */
	private ConsoleView() throws Itr2ViewException{
		console = System.console();
		if (console == null){
			throw new Itr2ViewException("Execute este programa a partir do diretorio bin em seu terminal." +
					"");
		}
		this.processOptionView = new ProcessOptionView();
		this.clearFromTo();
	}

	/**
	 * Singleton da tela.
	 * @return Objeto Tela.
	 * @throws Itr2ViewException Não foi possivel carregar a tela.
	 */
	public static ViewFactoryInterface getInstance() throws Itr2ViewException{

		if (instance == null) {
			instance = new ConsoleView();
		}
		return instance;
	}

	/**
	 * Mostra a tela
	 */
	public void showScreen() throws Itr2ViewException {
		clearScreen();
		showOriginDestiny();
		showMenu();
		readOption();
	}

	/**
	 * Mostra a origem e destino na tela.
	 */
	private void showOriginDestiny() {
		console.writer().println("Origem  da viagem: " + 
				(this.from.getDescription().isEmpty() ? "Nao definido":this.from.getDescription() ));

		console.writer().println("Destino da viagem: " + 
				(this.to.getDescription().isEmpty()  ? "Nao definido" : this.to.getDescription() ));
	}

	public void clearFromTo() throws Itr2ViewException{
		this.from 	= new Station();
		this.to 	= new Station();
		this.showScreen();

	}

	public void doExit() {
		System.exit(-1);
	}

	/**
	 * Mostra o meu de opções da tela.
	 */
	private void showMenu(){

		printBlankLines(2);

		console.writer().println(" Escolha uma das opcoes abaixo  ");
		console.writer().println(" =============================== ");
		printBlankLines(1);
		console.writer().println(" 1. Definir origem da viagem");
		console.writer().println(" 2. Definir destino da viagem ");
		console.writer().println(" 3. Distancia entre origem e destino");
		console.writer().println(" 4. Mostrar o melhor caminho  entre origem e destino");
		console.writer().println(" 5. Mostrar os caminhos possíveis entre origem e destino");
		console.writer().println(" 6. Limpar origem e destino");
		console.writer().println(" 7. Mostrar a tabela de rotas");
		printBlankLines(1);
		console.writer().println(" 0. Encerrar o programa");
		printBlankLines(1);		

	}

	/**
	 * Lê a opção selecionada.
	 * @throws Itr2ViewException 
	 */
	private void readOption() throws Itr2ViewException{
		String readLine = System.console().readLine();
		try {
			int option = Util.toInteger(readLine);
			this.processOptionView.processOption(this,option);

		}catch (Itr2ViewException e){
			this.reloadOptions(e.getMessage());
			readOption(); 
		}

	}
	/**
	 * 
	 * Recarrega a tela de opcoes 
	 * @param message
	 * @throws Itr2ViewException 
	 */
	private void reloadOptions(String message) throws Itr2ViewException{
		this.showMessage(message);
		try {
			this.showScreen();
		} catch (Itr2ViewException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Limpa o conteudo da tela.
	 * @throws Itr2ViewException
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
	/**
	 * Imprime linhas em branco.
	 * @param quantity numero de linhas
	 */
	private void printBlankLines(int quantity){
		for (int i =0 ; i < quantity ; ++i){
			console.writer().println();
		}
	}

	public void readOrigin(List<Station> stations)
			throws Itr2ViewException {
		this.from = processReadLine(stations, this.from, this.to);
		this.showScreen();

	}

	public void readDestiny(List<Station> stations)
			throws Itr2ViewException {
		this.to = processReadLine(stations, this.to, this.from);
		this.showScreen();
	}

	/**
	 * Processa a leitura da tela da opção origem / destino
	 * @param stations - Lista de estações
	 * @param selected - Estação selecionada
	 * @param notSelected - Estação a ser ignorada.
	 * @throws Itr2ViewException Não voi possivel ler o aplicativo
	 */
	private Station processReadLine(List<Station> stations,Station selected, Station notSelected) throws Itr2ViewException {
		boolean notValidate = true;
		while (notValidate) {
			printBlankLines(1);
			this.showStations(stations,notSelected);
			printBlankLines(1);
			String readLine = System.console().readLine();
			selected = checkStation(stations,readLine.toUpperCase(),notSelected);
			notValidate = (selected.getIdStation().isEmpty());
		}
		return selected;

	}

	/**
	 * Verifica a opção de estação escolhida
	 * @param stations Lista de Estações
	 * @param id - opção escolhida
	 * @return Estação selecionada
	 */
	private Station checkStation(List<Station> stations,String id, Station notSelected){
		Station result = new Station();

		id = id.equalsIgnoreCase(notSelected.getIdStation()) ? "":id;

		for(Station station: stations){
			if (id.equals(station.getIdStation())){
				result = station;
			}
		}
		return result;
	}

	/**
	 * Mostra as opções de estações exceto uma já escolhida
	 * @param stations - Lista de estações
	 * @param stationOut - Estação para ser ignorada.
	 */
	private void showStations(List<Station> stations, Station stationOut) {
		for (Station station:stations){
			if (! station.equals(stationOut)) {
				console.writer().println(station.getIdStation()+ " - " + station.getDescription() );
			}
		}
	}

	public void showMessage(String message) throws Itr2ViewException{
		this.printBlankLines(1);
		console.writer().println(message);
		this.pause();
		this.showScreen();
	}

	private void pause(){
		this.printBlankLines(1);
		console.writer().println("Pressione <Enter> para continuar." );
		System.console().readLine();
	}

	public Station getFrom() {
		return from;
	}

	public Station getTo() {
		return to;
	}

	public void showDistance(String message) throws Itr2ViewException{
		showMessage(message);
	}

	public void showTableRoute(List<Route> routes) throws Itr2ViewException {
		doShowRoutes(routes);
		this.pause();
		this.showScreen();
	}

	private void doShowRoutes(List<Route> routes) {
		this.printBlankLines(1);
		String line;
		for (Route route: routes){
			line = " da Estacao " + route.getOrigin() + " para a Estacao " +
					route.getDestiny() + ": Distancia-> " + route.getDistance();
			console.writer().println(line);
		}
	}

	public void showBestRoute(List<Route> routes, long totalRoute) throws Itr2ViewException {
		this.doShowRoutes(routes);
		this.showMessage("Total do percurso: "+totalRoute);
	}


	public void showRoute(List<Route> routes, long totalRoute) throws Itr2ViewException {
		this.doShowRoutes(routes);
		this.printBlankLines(1);
		console.writer().println("Total do percurso: "+totalRoute);
		console.writer().println("----------------------------");
		this.printBlankLines(1);
	}

	
}
