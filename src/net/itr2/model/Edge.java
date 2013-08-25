package net.itr2.model;

public class Edge  {
	  private final String id; 
	  private final Station source;
	  private final Station destination;
	  private final long weight; 
	  
	  public Edge(String id, Station source, Station destination, long weight) {
	    this.id = id;
	    this.source = source;
	    this.destination = destination;
	    this.weight = weight;
	  }
	  
	  public String getId() {
	    return id;
	  }
	  public Station getDestination() {
	    return destination;
	  }

	  public Station getSource() {
	    return source;
	  }
	  public long getWeight() {
	    return weight;
	  }
	  
	  @Override
	  public String toString() {
	    return source.getDescription() + " " + destination.getDescription();
	  }
	  
	  
	} 