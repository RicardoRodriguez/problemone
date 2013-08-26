package net.itr2.control;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.itr2.model.Station;

public interface RailMapPathCalculatorInterface {

	/**
	 * Prepara a esta��o origem 
	 * @param source Esta��o origem
	 */
	public void execute(Station source); 
	
	/**
	 * Este metodo retorna o caminho da origem apra o destino selecionado.
	 * NULL caminho n�o existe.
	 * @param target - Esta��o Destino Informada.
	 * @return Lista de esta��es.
	 */
	public LinkedList<Station> getPath(Station target);

	/**
	 * Retorna todas as rotas entre uma origem e um destino
	 * @param source N� origem.
	 * @param target N� destino.
	 * @return
	 */
	public List<String> doGetAllPaths(Station source, Station target);
	
}
