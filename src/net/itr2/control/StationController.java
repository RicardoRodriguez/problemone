package net.itr2.control;

import java.util.List;

import net.itr2.connection.ConnectionFactory;
import net.itr2.connection.ConnectionMemory;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

public class StationController implements StationControllerInterface {

	private ConnectionFactory connection = new ConnectionMemory();
	
	public StationController() {
		// TODO Auto-generated constructor stub
	}

	public List<Station> getStations() throws Itr2ConnectionException {
		return connection.doGetStations();
	}

	public Station getStation(String idStation) throws Itr2ConnectionException {
		return connection.doGetStation(idStation);
	}
}
