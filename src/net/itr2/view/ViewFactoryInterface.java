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
	 * Limpa esta��es origem e destino da tela.
	 * @throws Itr2ViewException N�o foi possivel limpar as esta��es
	 */
	public void clearFromTo() throws Itr2ViewException;
	
	/**
	 * Saida do Sistema
	 */
	public void doExit();
	
	/**
	 * L� a Esta��o origem
	 * @param stations - Lista de esta��es
	 * @throws Itr2ViewException N�o foi possivel ler a esta��es
	 */
	public void readOrigin(List<Station> stations) throws Itr2ViewException;
	
	/**
	 * L� a Esta��o Destino
	 * @param stations Lista de esta��es
	 * @throws Itr2ViewException N�o foi possivel ler a esta��es
	 */
	public void readDestiny(List<Station> stations) throws Itr2ViewException;

	public void showDistance(String message);
	
	public void showTableRoute(List<Route> routes) throws Itr2ViewException;
	
	public Station getFrom();
	
	public Station getTo();
	
}
