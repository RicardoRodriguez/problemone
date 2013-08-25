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

	public void showDistance(String message);
	
	public void showTableRoute(List<Route> routes) throws Itr2ViewException;
	
	public Station getFrom();
	
	public Station getTo();
	
}
