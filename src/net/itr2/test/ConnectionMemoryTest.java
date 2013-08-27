package net.itr2.test;

import static org.junit.Assert.assertTrue;
import net.itr2.connection.ConnectionFactory;
import net.itr2.connection.ConnectionMemory;
import net.itr2.exception.Itr2ConnectionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConnectionMemoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Category(net.itr2.test.AllTests.class)
	public void testDoGetStations() throws Itr2ConnectionException {
	    ConnectionFactory connection = new ConnectionMemory();
	    System.out.println("Total de Estações:" + connection.doGetStations().size());
		assertTrue("Ha registros na tabela de estacoes? ",
		          ! connection.doGetStations().isEmpty());

	}

	@Test
	@Category(net.itr2.test.AllTests.class)
	public void testDoGetRoutes() throws Itr2ConnectionException {
		ConnectionFactory connection = new ConnectionMemory();
	    System.out.println("Total de Rotas:" + connection.doGetRoutes().size());
		assertTrue("Ha registros na tabela de Rotas? ",
		          ! connection.doGetRoutes().isEmpty());

	}

}
