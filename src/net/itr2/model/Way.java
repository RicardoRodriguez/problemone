package net.itr2.model;

import java.util.ArrayList;
import java.util.List;

public class Way implements Comparable<Way> {

	private String description;
	private long distance;
	private boolean visited;
	private Way father;
	private List<Route> routes;
	private List<Way> neightboards;
	private String origin;
	private String  destiny;

	public Way() {
		this.routes = new ArrayList<Route>();
		this.neightboards = new ArrayList<Way>();
		this.visited = false;
		this.distance = 0;
		this.description = "";
	}
	
	public void setWayByRoute(Route route){
		this.distance 		= route.getDistance();
		this.origin 		= route.getOrigin();
		this.destiny 		= route.getDestiny();
		this.description 	= route.getIdRoute();
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public boolean isVisited() {
		return visited;
	}

	public void toVisit(){
		this.visited = true;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public boolean checkVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Way getFather() {
		return father;
	}

	public void setFather(Way father) {
		this.father = father;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Way> getNeightboards() {
		return neightboards;
	}

	public void setNeightboards(List<Way> neightboards) {
		this.neightboards = neightboards;
	}

	public int compareTo(Way way) {
		if(this.getDistance() < way.getDistance()) 
			return -1;
        else if(this.getDistance() == way.getDistance()) 
        	return 0;
        return 1;

	}
    @Override
  	public boolean equals(Object obj) {
  		if(obj instanceof Way){
  			Way vRef = (Way) obj;
  			if(this.getDescription().equals(vRef.getDescription())) return true;
  		}
  		return false;
  	}
     
}
