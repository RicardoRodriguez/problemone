package net.itr2.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.itr2.model.Path;
import net.itr2.model.Way;

public class PathCalculatorController {

	// Lista que guarda os caminhos pertencentes ao menor caminho encontrado.
	private List<Way> bestWay;
	
	// Variavel que recebe os caminhos pertencentes ao menor caminho
	private Way way;
	
	// Variavel que guarda o caminho que est‡ sendo visitado
	private Way actualWay;
	
	// Variavel que marca o vizinho do caminho altualmente visitado.
	private Way neighboard;
	
	//Lista dos caminhos ainda n‹o visitados.
	private List<Way> notVisited;
	
	
 	public PathCalculatorController() {
		this.bestWay = new ArrayList<Way>();
		this.way = new Way();
		this.actualWay = new Way();
		this.neighboard = new Way();
		this.notVisited = new ArrayList<Way>();
	}

 	public List<Way> findMinorPath(Path path, Way from, Way to){
 		this.bestWay.add(from);
 		for (int i = 0; i < path.getWays().size(); i++) {

			// Caminho atual tem distancia zero, e todos os outros, 9999("infinita")
			if (path.getWays().get(i).getDescription()
					.equals(from.getDescription())) {

				path.getWays().get(i).setDistance(0);

			} else {

				path.getWays().get(i).setDistance(9999);

			}
			//Insere o caminho na lista de caminhos nao visitados 
			this.notVisited.add(path.getWays().get(i));
		}
		
		Collections.sort(notVisited);

		// O algoritmo continua ate que todos os caminhos sejam visitados
				while (!this.notVisited.isEmpty()) {

					// Toma-se sempre o caminho com menor distancia, que eh o primeiro da
					// lista
					
					this.actualWay = this.notVisited.get(0);
					
					//System.out.println("Pegou esse caminho:  "+atual);
					/*
					 * Para cada vizinho (cada rota), calcula-se a sua possivel
					 * distancia, somando a distancia da rota atual com a da rota
					 * correspondente. Se essa distancia for menor que a distancia do
					 * vizinho, esta eh atualizada.
					 */
					for (int i = 0; i < actualWay.getRoutes().size(); i++) {

						this.neighboard.setWayByRoute(this.actualWay.getRoutes().get(i));
					
						if (! this.neighboard.checkVisited()){

							// Comparando a dist‰ncia do vizinho com a poss’vel
							// dist‰ncia
							
							if (this.neighboard.getDistance() > (this.actualWay.getRoutes().get(i).getDistance())) {

								this.neighboard.setDistance(actualWay.getRoutes().get(i).getDistance());
								this.neighboard.setFather(actualWay);

								/*
								 * Se o vizinho eh o destinoe procurado, e foi feita uma
								 * mudanca na distancia, a lista com o menor caminho
								 * anterior eh apagada, pois existe um caminho menor
								 * vertices pais, ateh o vertice origem.
								 */
								if (this.neighboard == to) {
									bestWay.clear();
									this.way = this.neighboard;
									this.bestWay.add(this.neighboard);
									while (way.getFather() != null) {

										bestWay.add(way.getFather());
										way = way.getFather();

									}
									// Ordena a lista do menor caminho, para que ele
									// seja exibido da origem ao destino.
									Collections.sort(bestWay);

								}
							}
						}

					}
					// Marca o caminho atual como visitado e o retira da lista de nao visitados
					actualWay.toVisit();
					this.notVisited.remove(actualWay);
					/*
					 * Ordena a lista, para que o caminho com menor distancia
					 * fique na primeira posicao
					 */

					Collections.sort(notVisited);
					//System.out.println(naoVisitados);
					

				}

				return bestWay;
		
 	}
 	
}
