package net.itr2.view;

import java.util.List;

import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface ViewFactoryInterface {
	/**
	 * Apresenta a tela escolhida pelo Cliente.
	 * @throws Itr2ViewException Nao foi possivel mostrar a tela
	 */
	public void showScreen() throws Itr2ViewException;
	
	/**
	 * Limpa estações origem e destino da tela.
	 * @throws Itr2ViewException Não foi possivel limpar as estações
	 */
	public void clearFromTo() throws Itr2ViewException;
	
	/**
	 * Saida do Sistema
	 */
	public void doExit();
	
	/**
	 * Lê a Estação origem
	 * @param stations - Lista de estações
	 * @throws Itr2ViewException Não foi possivel ler a estações
	 */
	public void readOrigin(List<Station> stations) throws Itr2ViewException;
	
	/**
	 * Lê a Estação Destino
	 * @param stations Lista de estações
	 * @throws Itr2ViewException Não foi possivel ler a estações
	 */
	public void readDestiny(List<Station> stations) throws Itr2ViewException;

	/**
	 * Mostra a distância, se existe da rota informada
	 * @param message Mensagem de distancia
	 */
	public void showDistance(String message) throws Itr2ViewException;
	
	/**
	 * Mostra a lista de rotas
	 * @param routes Lista de rotas.
	 * @throws Itr2ViewException
	 */
	public void showTableRoute(List<Route> routes) throws Itr2ViewException;
	
	public Station getFrom();
	
	public Station getTo();

	/**
	 * Mostra o melhor caminho entre 2 estações
	 * @param routes Lista de rotas selecionads
	 * @param totalRoute Total da rota percorrida
	 * @throws Itr2ViewException
	 */
	public void showBestRoute(List<Route> routes, long totalRoute) throws Itr2ViewException;
	
	/**
	 * Mostra mensagem desejada
	 * @param message mensagem
	 * @throws Itr2ViewException
	 */
	public void showMessage(String message) throws Itr2ViewException;
	
	/**
	 * Mostra o caminho de uma rota
	 * @param routes Rotas
	 * @param totalRoute distancia total da rota
	 * @throws Itr2ViewException 
	 */
	public void showRoute(List<Route> routes, long totalRoute) throws Itr2ViewException;
}
