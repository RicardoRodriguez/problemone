package net.itr2.test;

import static org.junit.Assert.assertTrue;
import net.itr2.connection.ConnectionFactory;
import net.itr2.connection.ConnectionMemory;
import net.itr2.exception.Itr2ConnectionException;

import org.junit.Before;
import org.junit.Test;

public class ConnectionMemoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDoGetStations() throws Itr2ConnectionException {
	    ConnectionFactory connection = new ConnectionMemory();
	    System.out.println("Total de Esta��es:" + connection.doGetStations().size());
		assertTrue("Ha registros na tabela de estacoes? ",
		          ! connection.doGetStations().isEmpty());

	}

	@Test
	public void testDoGetRoutes() throws Itr2ConnectionException {
		ConnectionFactory connection = new ConnectionMemory();
	    System.out.println("Total de Esta��es:" + connection.doGetRoutes().size());
		assertTrue("Ha registros na tabela de Rotas? ",
		          ! connection.doGetRoutes().isEmpty());

	}

}
