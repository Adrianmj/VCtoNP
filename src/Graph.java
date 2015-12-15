import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Graph {
	int grafo[][];
	boolean grafoB[][];
	int N;

	public Graph(int n) {
		this.N = n;
		grafo = new int[n][n];
		grafoB = new boolean[n][n];
	}

	public Graph(String file) {
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			linea = br.readLine();
			N = Integer.parseInt(linea);
			grafo = new int[N][N];
			grafoB = new boolean[N][N];

			int j = 0;
			while (br.ready()) {
				linea = br.readLine();
				String line[] = linea.split(" ");
				for (int i = 0; i < line.length; i++) {
					this.setEdge(i, j, Integer.parseInt(line[i]));
				}
				j++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Graph getInverso(){
		Graph invertido = new Graph(this.N);
		for (int i = 0; i < invertido.N; i++) {
			for (int j = 0; j < invertido.N; j++) {
				if(i!=j){
					invertido.setEdge(i, j, 1-this.getEdge(i, j));
				}else{
					invertido.setEdge(i, j, 0);
				}
			}
		}
		return invertido;
	}
	public void setEdge(int i, int j, int value) {
		grafo[i][j] = value;
	}

	public int getEdge(int i, int j) {
		this.grafoB[i][j] = true;
		this.grafoB[j][i] = true;

		return grafo[i][j];
	}

	public boolean getVisited(int i, int j) {
		return grafoB[i][j];
	}

	public void clear() {
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				grafoB[i][j] = false;
			}
		}
	}

	void show() {
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				System.out.print(grafo[i][j] + " ");
			}
			System.out.println();
		}
	}
}
