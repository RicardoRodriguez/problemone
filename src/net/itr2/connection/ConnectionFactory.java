package net.itr2.connection;

import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface ConnectionFactory {

	/**
	 * Carrega a lista de estaçoes cadastradas
	 * @return Lista de estacoes
	 * @throws Itr2ConnectionException
	 */
	public List<Station> doGetStations() throws Itr2ConnectionException;
	
	
	/**
	 * Carrega a lista de rotas cadastradas
	 * @return Colecao de rotas
	 * @throws Itr2ConnectionException
	 */
	public List<Route>  doGetRoutes() throws Itr2ConnectionException;
	
	/**
	 * Retorna a estação a partir do seu id
	 * @param idStation - identificador da estação
	 * @return Objeto Station
	 * @throws Itr2ConnectionException
	 */
	public Station doGetStation(String idStation) throws Itr2ConnectionException;
	
}
