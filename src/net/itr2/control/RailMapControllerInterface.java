package net.itr2.control;

import java.util.LinkedList;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

public interface RailMapControllerInterface {

	/**
	 * Prepara e calcula as rotas
	 * @param origin Stação de Origem
	 * @param target Stação Destino desejada
	 * @return Lista de Estações do Melhor caminho
	 * @throws Itr2ConnectionException Não teve acesso ao banco de dados.
	 */
	public LinkedList<Station> doExecute(Station origin,Station target) throws Itr2ConnectionException;

}
