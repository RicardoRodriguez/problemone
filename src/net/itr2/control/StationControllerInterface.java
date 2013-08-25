package net.itr2.control;

import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

public interface StationControllerInterface {
	
	/**
	 * Carrega as esta��es de trem
	 * @return Collection<Station>
	 * @throws Itr2ConnectionException
	 */
	public List<Station> getStations() throws Itr2ConnectionException;
	
	/**
	 * Retorna a esta��o de trem por id.
	 * @param idStation - id da esta��o
	 * @return 
	 * @throws Itr2ConnectionException - Conex�o falhor ou registro n�o encontrado
	 */
	public Station getStation(String idStation) throws Itr2ConnectionException;
}
