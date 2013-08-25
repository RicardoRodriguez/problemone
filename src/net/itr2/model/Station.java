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
	  public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((this.idStation == null) ? 0 : this.idStation.hashCode());
	    return result;
	  }
	  
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Station other = (Station) obj;
	    if (this.idStation == null) {
	      if (other.idStation != null)
	        return false;
	    } else if (!idStation.equals(other.idStation))
	      return false;
	    return true;
	  }

	  @Override
	  public String toString() {
	    return this.idStation+" - "+this.description;
	  }
	  

}
