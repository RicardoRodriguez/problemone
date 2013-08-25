package net.itr2.control;

import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Route;
import net.itr2.model.Station;

public interface RouteControllerInterface {
	
	public String showRoute(Station from, Station to) throws Itr2ConnectionException;
	public List<Route> getAllRoutes() throws Itr2ConnectionException;
}
