package net.itr2.control;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.itr2.model.Station;

public interface RailMapPathCalculatorInterface {

	/**
	 * Prepara a estação origem 
	 * @param source Estação origem
	 */
	public void execute(Station source); 
	
	/**
	 * Este metodo retorna o caminho da origem apra o destino selecionado.
	 * NULL caminho não existe.
	 * @param target - Estação Destino Informada.
	 * @return Lista de estações.
	 */
	public LinkedList<Station> getPath(Station target);

	/**
	 * Retorna todas as rotas entre uma origem e um destino
	 * @param source Nó origem.
	 * @param target Nó destino.
	 * @return
	 */
	public List<String> doGetAllPaths(Station source, Station target);
	
}
