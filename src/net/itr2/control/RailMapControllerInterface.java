package net.itr2.control;

import java.util.LinkedList;
import java.util.Map;

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

	
	/**
	 * Retorna a Rota a partir da Chave informada.
	 * @param key chave do registro.
	 * @return
	 * @throws Itr2ConnectionException
	 */

	public Map<Integer, RouteMapController> doGetAllRoutes(Station origin, Station target) throws Itr2ConnectionException;
}
