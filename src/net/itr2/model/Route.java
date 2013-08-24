package net.itr2.model;

import java.io.Serializable;

public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904394533489807596L;
	
	private String idRoute;
	private String origin;
	private String destiny;
	private long   distance;
	

	
	public Route() {
		this.idRoute 	= "";
		this.origin		= "";
		this.destiny	= "";
		this.distance	= 0;
	}

	public Route(String idRoute, String origin, String destiny,long distance) {
		this.idRoute 	= idRoute;
		this.origin		= origin;
		this.destiny	= destiny;
		this.distance	= distance;
	}

	
	public String getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(String idRoute) {
		this.idRoute = idRoute;
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

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	
}
