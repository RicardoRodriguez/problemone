/**
 * 
 */
package net.itr2.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import net.itr2.control.RailMapController;
import net.itr2.control.RailMapControllerInterface;
import net.itr2.control.StationController;
import net.itr2.control.StationControllerInterface;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ricardorodriguez
 *
 */
public class RailMapTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * Test method for {@link net.itr2.control.RailMapController#doExecute(net.itr2.model.Station, net.itr2.model.Station)}.
	 * @throws Itr2ConnectionException 
	 */
	@Test
	public void testDoExecute() throws Itr2ConnectionException {
		RailMapControllerInterface rail = new RailMapController();
		StationControllerInterface sc = new StationController(); 
		Station origin = sc.getStation("A");
		Station target = sc.getStation("E");
		LinkedList<Station> path = rail.doExecute(origin, target); 
		assertNotNull(path);
		assertTrue(path.size() > 0);
		for (Station station: path){
			System.out.println(station.toString());
		}
	}

}
