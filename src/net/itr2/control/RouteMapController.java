package net.itr2.control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public class RouteMapController implements RouteMapControllerInterface{

	private List<Route> routes;
	private long totalRouteMap;
	
	public RouteMapController(LinkedList<Station> stations) throws Itr2ConnectionException{
		String key = "";
		this.routes = new ArrayList<Route>();
		for(Station station: stations){
			key += station.getIdStation();
			if (key.length()==2){
				this.addRoute(key);
				key = station.getIdStation();
			}
		}
	}
	
	private void addRoute(String key) throws Itr2ConnectionException{
		RouteControllerInterface routeController = new RouteController();
		this.addRoute(routeController.getRoute(key));
	}
	
	private void addRoute(Route route){
		if (route != null){
			routes.add(route);
		}
	}
	public List<Route> doGetRoutes() {
		return routes;
	}

	public long doGetTotalRouteMap() {
		this.totalRouteMap = 0;
		for(Route route: this.doGetRoutes()){
			this.totalRouteMap += route.getDistance();
		}
		return totalRouteMap;
	}

	@Override
	public String toString(){
		String result = "";
		for(Route route: this.doGetRoutes()){
			result +=route.getOrigin()+"->"+route.getDestiny()+"->";
		}
		result +=  this.doGetTotalRouteMap();
		return result;
	}
}
