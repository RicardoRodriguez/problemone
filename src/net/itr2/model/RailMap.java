package net.itr2.model;

import java.util.List;

public class RailMap {
  private final List<Station> stations;
  private final List<Edge> edges;

  public RailMap(List<Station> stations, List<Edge> edges) {
    this.stations = stations;
    this.edges = edges;
  }

  public List<Station> getStations() {
    return stations;
  }

  public List<Edge> getEdges() {
    return edges;
  }
  
}
