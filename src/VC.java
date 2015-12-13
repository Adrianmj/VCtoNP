import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VC {
	int K;
	Graph grafo;
	ArrayList<conjunto> conjuntos = new ArrayList();

	public VC(int k) {
		System.out.println("---Vertex Cover---");
		this.K = k;
		grafo = new Graph("grafo1");
	}

	public boolean vertexCover() {

		
		//Creaamos la lista superset
		List<Integer> superSet = new ArrayList<>();
		for (int i = 0; i < grafo.N; i++) {
			superSet.add(i);
		}

		//Generamos los subconjuntos de tamaño K
		List<Set<Integer>> listonsia = new ArrayList<Set<Integer>>();
		listonsia = subsetGenerator.getSubsets(superSet, this.K);
			
		for (int i = 0; i < listonsia.size(); i++) {
			int aux[]= new int[this.K];
			String[] cadena;
			String conjunt = ""+listonsia.get(i)+"";
			conjunt = conjunt.replaceAll("[^0-9]","");
			for (int j = 0; j < conjunt.length(); j++) {
				aux[j] = Character.getNumericValue(conjunt.charAt(j));

			}
			conjunto auxiliar = new conjunto(2);
			auxiliar.setConjunto(aux);;
			conjuntos.add(auxiliar);
			
			
		}
		this.showConjuntos();
		for (int k = 0; k < conjuntos.size(); k++) {
			int cont = 0;
			int[] conjuntoAuxiliar = conjuntos.get(k).getConjunto();
			// System.out.println("Conjunto " + conjuntos.get(k));
			grafo.clear();
			for (int i = 0; i < conjuntoAuxiliar.length; i++) {
				for (int j = 0; j < grafo.N; j++) {
					if (grafo.getVisited(conjuntoAuxiliar[i], j) == false) {
						cont = cont + grafo.getEdge(conjuntoAuxiliar[i], j);
						// System.out.println("Valor(" + conjuntaso[i] + "," + j
						// + "}: " + grafo.getEdge(conjuntaso[i], j));
						// System.out.println("Contador(" + conjuntaso[i] + ","
						// + j + "}: " + cont);
					}
				}
				if (cont == 5) {
					System.out.print("Conjunto VC: ");
					conjunto obtenido = conjuntos.get(k);
					conjuntos.clear();
					conjuntos.add(obtenido);
					System.out.println(conjuntos);
					return true;
				}
			}

		}
		return false;
	}

	public void showConjuntos() {
		System.out.println("Conjuntos:");
		System.out.println(conjuntos);
	}

}
