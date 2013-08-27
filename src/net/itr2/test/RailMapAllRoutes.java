package net.itr2.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.itr2.control.RailMapController;
import net.itr2.control.RailMapControllerInterface;
import net.itr2.control.RouteMapController;
import net.itr2.control.StationController;
import net.itr2.control.StationControllerInterface;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RailMapAllRoutes {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Category(net.itr2.test.AllTests.class)
	public void testDoGetAllRoutes() throws Itr2ConnectionException {
		RailMapControllerInterface rail = new RailMapController();
		StationControllerInterface sc = new StationController(); 
		Station origin = sc.getStation("A");
		Station target = sc.getStation("E");
		List<RouteMapController> ways = rail.doGetAllRoutes(origin, target); 
		assertNotNull(ways);
		assertTrue(ways.size() > 0);
		for (RouteMapController route: ways){
			System.out.println(route.toString());
		}
	}

}
