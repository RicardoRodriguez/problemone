package net.itr2.connection;

import java.util.Collection;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface ConnectionFactory {

	/**
	 * Carrega a lista de estaçoes cadastradas
	 * @return Colecao de estacoes
	 * @throws Itr2ConnectionException
	 */
	public Collection<Station> doGetStations() throws Itr2ConnectionException;
	
	
	/**
	 * Carrega a lista de rotas cadastradas
	 * @return Colecao de rotas
	 * @throws Itr2ConnectionException
	 */
	public Collection<Route>  doGetRoutes() throws Itr2ConnectionException;
	
	
}
