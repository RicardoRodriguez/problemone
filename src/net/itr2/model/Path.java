package net.itr2.model;

import java.util.ArrayList;
import java.util.List;

public class Path {

	private List<Way> ways;

	public Path() {
		this.ways = new ArrayList<Way>();
	}

	public List<Way> getWays() {
		return ways;
	}

	public void setPaths(List<Way> paths) {
		this.ways = paths;
	}

	public void addWay(Way newWay){
		this.ways.add(newWay);
	}
	/**
	 * M�todo que retorna o v�rtice cuja a descricao � igual a procurada
	 * @param nome
	 * @return
	 */
	public Way findWay(String description){

		for(Way way: ways){
			if (description.equalsIgnoreCase(way.getDescription())){
				return way;
			}
		}
		return null;

	}



}
