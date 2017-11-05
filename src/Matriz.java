
public class Matriz {

	private String[][] matriz;
	// caracteres que dividir�n los d�gitos
	private static final String CARACTERHORIZONTAL = "-";
	private static final String CARACTERVERTICAL = "|";
	private int columnaFinal;
	private int filasMitad;
	private int filaFinal;
	private int size;
	// seguidas incluye los car�cteres que est�n seguidos, ejemplo: |___| en
	// este caso los guiones "___"
	private int seguidas[];
	// numero es el n�mero al que se le dar� forma
	private int numero;
	// Es la forma o caracter que tendr�n los campos que no est�n ocupados
	private String formatoMatriz;

	public Matriz(int filas, int columnas, int size, int numero) {
		this.size = size;
		this.numero = numero;
		matriz = new String[filas][columnas];
		seguidas = new int[size];
		filasMitad = filas / 2;
		filaFinal = filas - 1;
		columnaFinal = columnas - 1;
		formatoMatriz = " ";
		// Aqu� se le da valor a las que van seguidas, esto se da cuando el
		// tama�o es mayor a 1
		for (int i = 0; i < size; i++) {
			seguidas[i] = 1 + i;
		}
		// Aqu� se le da el formato a la matr�z
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = formatoMatriz;
			}
		}
		// ejecutarMatriz es el m�todo que le da la forma a los d�gitos
		ejecutarMatriz();
	}

	private void ejecutarMatriz() {
		switch (numero) {
		case 0:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 1:
			for (int i = 0; i < size; i++) {
				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 2:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][0] = CARACTERVERTICAL;
			}
			break;
		case 3:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 4:
			for (int i = 0; i < size; i++) {
				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 5:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 6:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 7:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 8:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][0] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		case 9:
			for (int i = 0; i < size; i++) {
				matriz[0][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filasMitad][seguidas[i]] = CARACTERHORIZONTAL;
				matriz[filaFinal][seguidas[i]] = CARACTERHORIZONTAL;

				matriz[seguidas[i]][0] = CARACTERVERTICAL;
				matriz[seguidas[i]][columnaFinal] = CARACTERVERTICAL;
				matriz[filasMitad + seguidas[i]][columnaFinal] = CARACTERVERTICAL;
			}
			break;
		default:
			break;
		}

	}

	public String[][] getMatriz() {
		return matriz;
	}

}
