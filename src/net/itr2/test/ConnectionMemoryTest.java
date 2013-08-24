package net.itr2.test;

import static org.junit.Assert.assertTrue;
import net.itr2.connection.ConnectionFactory;
import net.itr2.connection.ConnectionMemory;
import net.itr2.exception.Itr2ConnectionException;

import org.junit.Before;
import org.junit.Test;

public class ConnectionMemoryTest {
	private ConnectionFactory connection;
	@Before
	public void setUp() throws Exception {
		this.connection =  new ConnectionMemory();
		this.testDoGetStations();
		this.testDoGetRoutes();
	}

	@Test
	public void testDoGetStations() throws Itr2ConnectionException {

		assertTrue("Ha registros na tabela de estacoes? ",
		          ! this.connection.doGetStations().isEmpty());
	}

	@Test
	public void testDoGetRoutes() throws Itr2ConnectionException {
	
		assertTrue("Ha registros na tabela de Rotas? ",
		          ! this.connection.doGetRoutes().isEmpty());

	}

}
