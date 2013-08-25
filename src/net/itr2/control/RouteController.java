package net.itr2.control;

import java.util.List;

import net.itr2.connection.ConnectionFactory;
import net.itr2.connection.ConnectionMemory;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Route;
import net.itr2.model.Station;


public class RouteController implements RouteControllerInterface{


	private ConnectionFactory connection;
	
	public RouteController() {
		this.connection = new ConnectionMemory();
	}

	
	public String showRoute(Station from, Station to) throws Itr2ViewException{
		String estacoes = "A partir da "+ from.getDescription() + " ate a estacao "+to.getDescription();
		String retorno = "Rota apresentada nao existe. "+ estacoes;
		String chave = from.getIdStation()+to.getIdStation();
		try {	
			for (Route route: connection.doGetRoutes()){
				if (route.getIdRoute().equalsIgnoreCase(chave)){
					retorno = estacoes + " a distancia e: " + route.getDistance();
					break;
				}
			}
		} catch (Itr2ConnectionException e) {
			throw new Itr2ViewException("Nao foi possivel ler as rotas. "+e.getMessage());
		}
		return retorno;
	}


	public List<Route> getAllRoutes() throws Itr2ViewException {
		try {
			return connection.doGetRoutes();
		} catch (Itr2ConnectionException e) {
			 throw new Itr2ViewException("N‹o voi possivel ler as rotas"+e.getMessage());
		}
	}
		
}
