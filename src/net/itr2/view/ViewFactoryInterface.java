package net.itr2.view;

import net.itr2.exception.Itr2ViewException;

public interface ViewFactoryInterface {
	/**
	 * Apresenta a tela escolhida pelo Cliente.
	 * @throws Itr2ViewException
	 */
	public void showScreen() throws Itr2ViewException;
	
	public void clearFromTo() throws Itr2ViewException;
	
	public void doExit();
	
	public void readOrigin() throws Itr2ViewException;
	
	public void readDestiny() throws Itr2ViewException;
	
}
