package net.itr2.control;

import java.util.List;

import net.itr2.exception.Itr2ConnectionException;
import net.itr2.model.Station;

public interface StationControllerInterface {
	
	/**
	 * Carrega as estações de trem
	 * @return Collection<Station>
	 * @throws Itr2ConnectionException
	 */
	public List<Station> getStations() throws Itr2ConnectionException;
}
