package net.itr2.view;

import net.itr2.exception.Itr2ViewException;

public interface ProcessOptionInterface {

	/**
	 * Processa as opções do processo
	 * @param viewer - Interface do Viewer utilizada pelo Cliente. 
	 * @param option - Opção Selecionada.
	 * @throws Itr2ViewException
	 */
	public void processOption(ViewFactoryInterface viewer, int option) throws Itr2ViewException; 
	
	
}
