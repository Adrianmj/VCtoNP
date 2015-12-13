
public class VCtoNP {
	public static void main(String[] args) {
		Graph A = new Graph("grafo1");
		A.show();
		int K = 2;
		VC vertex = new VC(2);
		vertex.vertexCover();
		CLIQUE clique = new CLIQUE();
		clique.getClique();
	}
}
