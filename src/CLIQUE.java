import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CLIQUE {
	Graph grafo;
	int K;
	ArrayList<conjunto> conjuntos = new ArrayList<conjunto>();

	public CLIQUE(Graph grafo, int k) {
		this.K = k;
		System.out.println("---CLIQUE---");
		this.grafo = grafo;
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
			conjunto auxiliar = new conjunto(this.K);
			auxiliar.setConjunto(aux);
			conjuntos.add(auxiliar);

		}

		conjunto resultado = new conjunto(this.K);
		//comprobamos si hay algun conjnto vlaido
		outer:for (int z = 0; z < conjuntos.size(); z++) {
			int[] aux = conjuntos.get(z).getConjunto();
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
				resultado = conjuntos.get(z);
				break outer;
			}
		}
		if (resultado.SIZE == this.K) {
			conjuntos.clear();
			conjuntos.add(resultado);
			System.out.print("Conjunto CLIQUE: ");
			System.out.println(conjuntos);
		} else {
			System.out.println("Clique no encntrado con ese tamaño");
		}
		conjuntos.clear();

	}

	public void showConjuntos() {
		System.out.println("Conjuntos:");
		System.out.println(conjuntos);
	}
}
