package net.itr2.model;

import java.io.Serializable;

public class Station implements Serializable{

	private static final long serialVersionUID = 2238865525870096459L;
	private String idStation;
	private String description;
	
	public Station() {
		this.idStation = "";
		this.description = "";
	}

	public Station(String idStation,String description) {
		this.idStation = idStation;
		this.description = description;
	}
	
	public String getIdStation() {
		return idStation;
	}

	public void setIdStation(String idStation) {
		this.idStation = idStation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		Station station  = (Station) obj;
		return this.idStation == station.idStation;
	}

}
