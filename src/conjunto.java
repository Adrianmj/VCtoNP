import java.util.ArrayList;

public class conjunto {
	int SIZE;
	int conjunto[];

	public conjunto(int size) {
		conjunto = new int[size];
	}

	public void setConjunto(int conjunto[]) {
		this.conjunto = conjunto;
	}
	public int[] getConjunto(){
		return conjunto;
	}
	public String toString() {
		String salida = "{";
		for (int i = 0; i < conjunto.length; i++) {
			salida = salida + conjunto[i];
			if (i < conjunto.length-1) {
				salida = salida + ",";
			}
		}
		return salida + "}";
	}
	
	
}
