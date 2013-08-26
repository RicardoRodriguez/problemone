package net.itr2.control;

import java.util.List;
import java.util.Map;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface RouteMapControllerInterface {

	/**
	 * Retorna as rotas mapeadas pelo RailMapControllerInterface
	 * @return - Lista das Rotas
	 */
	public List<Route> doGetRoutes();
	
	/**
	 * Calcula o tamanho total do caminho.
	 * @return tamanho total.
	 */
	public long doGetTotalRouteMap();
	
	

}
