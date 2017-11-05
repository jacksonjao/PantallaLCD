
import java.util.ArrayList;

public class Logica {
	// Arraylist de la matriz de cada número
	private ArrayList<Matriz> matrices;
	// Arraylist que contiene todas las matrices
	private String[][] bigMatriz;
	// Número de filas de cada matriz
	private int filas;
	// Número de columnas de cada matriz
	private int columnas;
	// Suma total obtenida de las columnas de cada matriz
	private int totalColumnas;
	// Espacio entre cada caracter
	private int espacio;

	public Logica() {
		matrices = new ArrayList<Matriz>();
	}

	// Método que recibe los eventos del teclado, este recibe el tamaño y los
	// números a imprimir
	public void accion(int size, String numeros) {
		// Espacio entre cada impresión como se planteó en el problema
		espacio = 1;
		// Limpio la matriz para darle paso a los nuevos dígitos
		matrices.clear();
		// tamaño de filas y columnas como se plateó en el problema
		columnas = size + 2;
		filas = (2 * size) + 3;
		// Partición de cada número que se tomó del String "numeros"
		int numero[] = new int[numeros.toCharArray().length];
		for (int i = 0; i < numeros.toCharArray().length; i++) {
			numero[i] = Integer.parseInt(numeros.toCharArray()[i] + "");
			matrices.add(new Matriz(filas, columnas, size, numero[i]));
		}
		// se adecúa la columna de la "bigMatriz" con los espacios
		totalColumnas = columnas * (matrices.size()) + matrices.size() * espacio;
		bigMatriz = new String[filas][totalColumnas];
		// Se inicializa la "bigMatriz"
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < totalColumnas; j++) {
				bigMatriz[i][j] = " ";
			}
		}
		// se agregan las matrices a la "bigMatriz"
		for (int i = 0; i < matrices.size(); i++) {
			for (int j = 0; j < filas; j++) {
				for (int k = 0; k < columnas; k++) {
					bigMatriz[j][(k + (columnas * i)) + i * espacio] = matrices.get(i).getMatriz()[j][k];
				}
			}
		}

		// Se imprime la "bigMatriz" con todas las matrices guardadas
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < totalColumnas; j++) {
				System.out.print(bigMatriz[i][j]);
			}
			System.out.println("");
		}

	}
}
