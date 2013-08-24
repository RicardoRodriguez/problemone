package net.itr2.view;

import java.util.ArrayList;
import java.util.List;

import net.itr2.control.StationController;
import net.itr2.control.StationControllerInterface;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Station;

public class ProcessOptionView implements ProcessOptionInterface{


	public ProcessOptionView() {

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

	private List<Station> getStationList() throws Itr2ViewException{
		StationControllerInterface controller = new StationController();
		List <Station> result = new ArrayList<Station>();
		try {
			result = controller.getStations();
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Não foi possivel estabeler conexão via Controller. "+e.getMessage());
		}

		return result;
	}

}
