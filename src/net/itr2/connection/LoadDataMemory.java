package net.itr2.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.itr2.model.Route;
import net.itr2.model.Station;

public class LoadDataMemory {
	
	private  Map<String,Station> stationsMap;
	private  Map<String,Route> routesMap;
	private static LoadDataMemory instance;
	
	private LoadDataMemory(){
		// Esta classe Ž um Singleton.
	}
	
	public static LoadDataMemory getInstance(){
		if (instance == null){
			instance = new LoadDataMemory();
			instance.stationsMap = new HashMap<String,Station>();
			instance.routesMap   = new HashMap<String,Route>();
			instance.addStations();
			instance.addRoutes();
		}
		return instance;
	}
	
	private void executeStation(Map<String, Station> map, Station value){
			map.put(value.getIdStation(),value);
	}
	
	private void executeRoute(Map<String, Route> map, Route value){
		map.put(value.getIdRoute(),value);
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private void execute (Map<?,?> map, Object object) {
		if (object instanceof Station){
			executeStation( (Map<String,Station>) map,(Station) object);
		} else {
			executeRoute( (Map<String,Route>) map,(Route) object);
		}
			
	}
	
	private void addStations() {
			this.execute(stationsMap,new Station("A","Estacao A"));
			this.execute(stationsMap,new Station("B","Estacao B"));
			this.execute(stationsMap,new Station("C","Estacao C"));
			this.execute(stationsMap,new Station("D","Estacao D"));
			this.execute(stationsMap,new Station("E","Estacao E"));
			this.execute(stationsMap,new Station("F","Estacao F"));
			
	}

	private void addRoutes(){
			this.execute(routesMap,new Route("AB","A","B",10));
			this.execute(routesMap,new Route("BC","B","C",15)); 
			this.execute(routesMap,new Route("AC","A","C",12)); 
			this.execute(routesMap,new Route("CD","C","D",10)); 
			this.execute(routesMap,new Route("DE","D","E",5));  
			this.execute(routesMap,new Route("ED","E","D",8));  
			this.execute(routesMap,new Route("EC","E","C",15));  
			this.execute(routesMap,new Route("CE","C","E",12));  
			this.execute(routesMap,new Route("DE","D","E",5));   
			this.execute(routesMap,new Route("DF","D","F",5));   
			this.execute(routesMap,new Route("EF","E","F",10));  
			this.execute(routesMap,new Route("FE","F","E",15));  
	}

	public Map<String, Station> getStationsMap() {
		Map<String, Station> result  = new TreeMap<String, Station>(this.stationsMap);
		return result;
	}

	public Map<String, Route> getRoutesMap() {
		Map<String, Route> result  = new TreeMap<String, Route>(this.routesMap);
		return result;
	}
	
	
	
}
