package net.itr2.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	public Map<Integer, RouteMapController> doGetAllRoutes(Station origin, Station target) throws Itr2ConnectionException {
		this.prepareEdges();
		this.prepareStations();
		int id = 0;
	
		Map<Integer,RouteMapController> result = new HashMap<Integer,RouteMapController>();
		RailMap map = new RailMap(stations, edges);
		RailMapPathCalculator calculator = new RailMapPathCalculator(map);
		List<String> paths = calculator.doGetAllPaths(origin, target);
	
		for(String path: paths){
			if (path.startsWith(origin.getIdStation()) && path.endsWith(target.getIdStation())){
				RouteMapController routeMap = new RouteMapController(this.doGetStations(path));
				result.put(id++, routeMap);
			}
		}
		return result;
	}

	private LinkedList<Station> doGetStations(String path) throws Itr2ConnectionException{
		StationControllerInterface stationController = new StationController();
		LinkedList<Station> result = new LinkedList<Station>();
		for(int i = 0; i < path.length(); ++i){
			String key = path.substring(i,1);
			result.add(stationController.getStation(key));
		}
		return null;
	}
	
}
