package net.itr2.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.itr2.control.RailMapController;
import net.itr2.control.RailMapControllerInterface;
import net.itr2.control.RouteController;
import net.itr2.control.RouteControllerInterface;
import net.itr2.control.RouteMapController;
import net.itr2.control.RouteMapControllerInterface;
import net.itr2.control.StationController;
import net.itr2.control.StationControllerInterface;
import net.itr2.exception.Itr2ConnectionException;
import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Route;
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
			this.showDistance(viewer);	
			break;

		case 4:
			this.showBestWay(viewer);
			break;
			
		case 5:	
			this.showAllWays(viewer);
			break;
			
		case 6:
			viewer.clearFromTo();
			break;

		case 7:
			viewer.showTableRoute(this.getAllRoutes());
			break;	
		default:
			throw new Itr2ViewException("Opção inválida. Tente de Novo.");
		}

	}

	private void showAllWays(ViewFactoryInterface viewer) throws Itr2ViewException {
		if (! this.checkStations(viewer)) {
			return;
		}
		try {
		RailMapControllerInterface rail = new RailMapController();
		Map<Integer, RouteMapController> 
		routes = rail.doGetAllRoutes(viewer.getFrom(), viewer.getTo());
		for(RouteMapControllerInterface routeMap: routes.values() ){
			viewer.showRoute(routeMap.doGetRoutes(),routeMap.doGetTotalRouteMap());
		}
		viewer.showMessage("Término das Rotas");
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Não foi possivel mostrar todas as rotas. Erro:"+ e.getMessage());
		}
	
	}
	
	private void showBestWay(ViewFactoryInterface viewer) throws Itr2ViewException{
		
		if (! this.checkStations(viewer)) {
			return;
		}
		
		RailMapControllerInterface rail = new RailMapController();

		try {
			LinkedList<Station> path = rail.doExecute(viewer.getFrom(), viewer.getTo());
			RouteMapControllerInterface routeMap = new RouteMapController(path);
			viewer.showBestRoute(routeMap.doGetRoutes(),routeMap.doGetTotalRouteMap());
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Não foi possivel mostrar a melhor Rota. Erro:"+ e.getMessage());
		} 
	}

	private List<Route> getAllRoutes() throws Itr2ViewException{
		RouteControllerInterface route = new RouteController();
		List<Route> result = new ArrayList<Route>();

		try {
			result = route.getAllRoutes();
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Erro de conexao: " + e.getMessage());
		}

		return result;
	}

	private boolean checkStations(ViewFactoryInterface viewer) throws Itr2ViewException{
		boolean result = true;
		if (viewer.getFrom().getIdStation().isEmpty() || viewer.getTo().getIdStation().isEmpty()) {
			viewer.showMessage("Opcao Invalida. Informe primeiro estacoes origem e destino");
			result = false;
		}
		return  result;
	}
	
	private void showDistance(ViewFactoryInterface viewer) throws Itr2ViewException{
		RouteControllerInterface route = new RouteController();
		
		String result="";
		if (! this.checkStations(viewer)) {
			return;
		}
		try {
			result = route.showRoute(viewer.getFrom(), viewer.getTo());
			viewer.showDistance(result);
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Erro de conexao: " + e.getMessage());	
		}
	}

	private List<Station> getStationList() throws Itr2ViewException{
		StationControllerInterface controller = new StationController();
		List <Station> result = new ArrayList<Station>();
		try {
			result = controller.getStations();
		} catch (Itr2ConnectionException e) {
			new Itr2ViewException("Nao foi possivel estabeler conexão via Controller. "+e.getMessage());
		}

		return result;
	}

}
