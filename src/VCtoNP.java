
public class VCtoNP {
	public static void main(String[] args) {
		Graph grafo1 = new Graph("grafo1");
		
		CLIQUE clique = new CLIQUE(grafo1);
		clique.getClique();
		
		final int K = clique.grafo.N - clique.K;
		Graph grafoAuxiliar = clique.grafo.getInverso();
		System.out.println("INVERTIDO");
		grafoAuxiliar.show();
		VC vertex = new VC(K,grafoAuxiliar);
		vertex.vertexCover();
	}
}
