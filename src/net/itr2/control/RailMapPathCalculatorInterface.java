package net.itr2.control;

import java.util.LinkedList;

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
	
}
