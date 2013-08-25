package net.itr2.connection;

import java.util.ArrayList;
import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public class ConnectionMemory implements ConnectionFactory {

	private LoadDataMemory loadData;

	public ConnectionMemory() {

	}

	private void openDatabase() {
		this.loadData = LoadDataMemory.getInstance();
	}


	public List<Station> doGetStations() throws Itr2ConnectionException {
		if (this.loadData == null){
			this.openDatabase();
		}
		List <Station> result = new ArrayList<Station>(loadData.getStationsMap().values()); 

		if (result.isEmpty())
			throw new Itr2ConnectionException("Não foi possivel carregar a tabela Station de LoadDataMemory");

		return result;
	}

	public Station doGetStation(String idStation) throws Itr2ConnectionException{
		List<Station> stations = this.doGetStations();
		Station result = new Station();
		result.setDescription("Nao encontrei a estaçao: "+idStation);
		for (Station station: stations){
			if (station.getIdStation().equals(idStation)){
				result = station;
				break;
			}
		}
		return result;
	}

	public List<Route> doGetRoutes() throws Itr2ConnectionException {
		if (this.loadData == null){
			this.openDatabase();
		}
		List <Route> result =  new ArrayList<Route>(loadData.getRoutesMap().values()); 

		if (result.isEmpty())
			throw new Itr2ConnectionException("Não foi possivel carregar a tabela Routes de LoadDataMemory");

		return result;

	}

}
