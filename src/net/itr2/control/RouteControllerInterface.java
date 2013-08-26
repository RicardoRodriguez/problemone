package net.itr2.control;

import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface RouteControllerInterface {
	
	/**
	 * Apresenta a Rota a partir de 2 estações
	 * @param from Estação origem
	 * @param to Estação destino
	 * @return Retorna a rota na forma de String
	 * @throws Itr2ConnectionException
	 */
	public String showRoute(Station from, Station to) throws Itr2ConnectionException;
	
	/**
	 * Apresenta todas as rotas cadastradas
	 * @return Rotas Cadastradas.
	 * @throws Itr2ConnectionException
	 */
	public List<Route> getAllRoutes() throws Itr2ConnectionException;
	
	public Route getRoute(String idRoute) throws Itr2ConnectionException;
	
}
