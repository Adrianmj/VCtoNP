
public class VCtoNP {
	public static void main(String[] args) {
		System.out.println("-------GRAFO 1--------");
		Graph grafo1 = new Graph("grafo1");
		CLIQUE clique = new CLIQUE(grafo1,4);
		clique.getClique();
		
		final int K = clique.grafo.N - clique.K;
		Graph grafoAuxiliar = clique.grafo.getInverso();

		VC vertex = new VC(K,grafoAuxiliar);
		vertex.vertexCover();
		
		System.out.println("-------GRAFO 2--------");
		Graph grafo2 = new Graph("grafo2");
		CLIQUE clique2 = new CLIQUE(grafo2.getInverso(),2);
		clique2.getClique();
		VC vertex2 = new VC(2,grafo2);
		vertex2.vertexCover();
	}
}
