package net.itr2.control;

import java.util.LinkedList;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

public interface RailMapControllerInterface {

	/**
	 * Prepara e calcula as rotas
	 * @param origin Sta��o de Origem
	 * @param target Sta��o Destino desejada
	 * @return Lista de Esta��es do Melhor caminho
	 * @throws Itr2ConnectionException N�o teve acesso ao banco de dados.
	 */
	public LinkedList<Station> doExecute(Station origin,Station target) throws Itr2ConnectionException;

}
