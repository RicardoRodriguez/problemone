package net.itr2.control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Edge;
import net.itr2.model.RailMap;
import net.itr2.model.Route;
import net.itr2.model.Station;

public class RailMapController implements RailMapControllerInterface {

	private List<Edge> edges;
	private List<Station> stations;
	public RailMapController() {

	}
	public LinkedList<Station> doExecute(Station origin,Station target) throws Itr2ConnectionException{
		this.prepareEdges();
		this.prepareStations();
		RailMap map = new RailMap(stations, edges);
		RailMapPathCalculator calculator = new RailMapPathCalculator(map);
		calculator.execute(origin);
		LinkedList<Station> path = calculator.getPath(target);
		return path;
	}

	private void prepareEdges() throws Itr2ConnectionException{
		this.edges = new ArrayList<Edge>();
		RouteControllerInterface routeController = new RouteController();
		StationControllerInterface stationController = new StationController();
		for(Route route: routeController.getAllRoutes()){
			Station source 	= stationController.getStation(route.getOrigin());
			Station destiny = stationController.getStation(route.getDestiny());
			Edge edge = new Edge(route.getIdRoute(),source,destiny,route.getDistance());
			this.edges.add(edge);
		}
	}
	
	private void prepareStations() throws Itr2ConnectionException{
		StationControllerInterface stationController = new StationController();
		this.stations = stationController.getStations();
	}
}
