import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CLIQUE {
	Graph grafo;
	int K = 4;
	ArrayList<conjunto> conjuntos = new ArrayList();

	public CLIQUE() {
		System.out.println("---CLIQUE---");
		Graph aux = new Graph("grafo1");
		grafo = new Graph(aux.N);
		for (int i = 0; i < grafo.N; i++) {
			for (int j = 0; j < grafo.N; j++) {
				if (i != j) {
					grafo.setEdge(i, j, 1 - aux.getEdge(i, j));
				} else {
					grafo.setEdge(i, j, 0);
				}
			}
		}
	}

	public void getClique() {
		List<Integer> superSet = new ArrayList<>();
		for (int i = 0; i < grafo.N; i++) {
			superSet.add(i);
		}

		// Generamos los subconjuntos de tamaño K
		List<Set<Integer>> listonsia = new ArrayList<Set<Integer>>();
		listonsia = subsetGenerator.getSubsets(superSet, this.K);

		for (int i = 0; i < listonsia.size(); i++) {
			int aux[] = new int[this.K];
			String[] cadena;
			String conjunt = "" + listonsia.get(i) + "";
			conjunt = conjunt.replaceAll("[^0-9]", "");
			for (int j = 0; j < conjunt.length(); j++) {
				aux[j] = Character.getNumericValue(conjunt.charAt(j));

			}
			conjunto auxiliar = new conjunto(2);
			auxiliar.setConjunto(aux);
			;
			conjuntos.add(auxiliar);

		}
		this.showConjuntos();
		conjunto resultado = new conjunto(K);
		for (int k = 0; k < conjuntos.size(); k++) {
			int[] aux = conjuntos.get(k).getConjunto();

			boolean valido = true;
			for (int i = 0; i < aux.length; i++) {
				for (int j = i + 1; j < aux.length; j++) {
					if (grafo.getEdge(aux[i], aux[j]) != 1) {
						valido = false;
						break;
					}
				}
			}
			if (valido) {
				resultado = conjuntos.get(k);
			}
		}
		conjuntos.clear();
		conjuntos.add(resultado);
		System.out.print("Conjunto CLIQUE: ");
		System.out.println(conjuntos);
	}

	public void showConjuntos() {
		System.out.println("Conjuntos:");
		System.out.println(conjuntos);
	}
}
