package net.itr2.model;

import java.io.Serializable;

public class Station implements Serializable{

	/**
	 * Esta classe Ž serializada.
	 */
	private static final long serialVersionUID = 2238865525870096459L;
	private String idStation;
	private String Description;
	
	public Station() {
		this.idStation = "";
		this.Description = "";
	}

	public String getIdStation() {
		return idStation;
	}

	public void setIdStation(String idStation) {
		this.idStation = idStation;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	
}
