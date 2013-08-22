package net.itr2.view;

import net.itr2.exception.Itr2ViewException;

public class ProcessOptionView implements ProcessOptionInterface{

	
	private static ProcessOptionView instance;
	
	private ProcessOptionView() {
		
	}
	
	public static ProcessOptionView getInstance(){
		if (instance == null){
			instance = new ProcessOptionView();
		}
		return instance;
	}
	
	public void processOption(ViewFactoryInterface viewer, int option)  throws Itr2ViewException {
		switch (option) {
			case 0:
				viewer.doExit();
				break;
			
			case 1:
				viewer.readOrigin(this.getStationList());
				break;
			
			case 2:
				viewer.readDestiny(this.getStationList());
				break;
			
			case 3:
				
			case 6:
				viewer.clearFromTo();
				break;
		default:
			throw new Itr2ViewException("Opção inválida. Tente de Novo.");
		}
		
	}
	
	
}
