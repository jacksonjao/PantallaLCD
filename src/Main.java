import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	// clase que vinculará las diferentes clases de la aplciación
	private static Logica logica;

	public static void main(String[] args) {
		logica = new Logica();
		teclado();
	}

	
	private static void teclado() {
		// variable que agregará los datos ingresados
		String input = ",";
		// variable que agrega la forma de finalizar la apicación
		String finalizar = "0,0";
		// variable que agrega los distintos mensajes que se muestran en
		// pantalla, errores, etc.
		String mensaje;
		// arraylist que agregará los datos ingresados para que no se pierdan si se llegaran a necesitar
		ArrayList<String> valores = new ArrayList<>();
		// variable que recibirá el tamaño de la impresión
		int size;
		// variable que recibirá los números a imprimir
		String numero;
		Scanner teclado = new Scanner(System.in);
		mensaje = "Ingrese 2 valores numéricos con la forma 'x,y' sin las comillas '0,0' terminará la aplicación \nx = tamaño de impresión (debe estar entre 1 y 10) \ny = números que se mostrarán (pueden ser infinitos :D)";
		System.out.println(mensaje);
		mensaje = "Ingrese los valores abajo V, recuerde terminar la aplicación para ver el resultado:";
		System.out.println(mensaje);
		do {
			try {
				input = teclado.next();
				size = Integer.parseInt(input.split(",")[0]);
				numero = input.split(",")[1];

				if (input.equals(finalizar)) {
					mensaje = "Mira los resultados :D";
					System.out.println(mensaje);
					break;
				}
				if (size == 0 || size > 10) {
					mensaje = "ERROR, el tamaño de la impresión debe de estar entre 1 y 10";
					System.err.println(mensaje);
					break;
				}
				if (input.split(",").length > 2) {
					mensaje = "ERROR, el valor contiene más caracteres, recuerda la forma 'x,y'";
					System.err.println(mensaje);
					break;
				}
				valores.add(size + "," + numero);

			} catch (ArrayIndexOutOfBoundsException e) {
				mensaje = "ERROR. debes escribir 2 valores númericos, recuerda la forma 'x,y'";
				System.err.print(mensaje);
				break;
			} catch (NumberFormatException e) {
				mensaje = "ERROR. Los valores tienen que ser numéricos, recuerda la forma 'x,y'";
				System.err.print(mensaje);
				break;
			}
		} while (!input.equals(finalizar));
		teclado.close();
		// obtendrá el tamaño de la impresión desde "valores"
		int getSize;
		// obtendrá los números de la impresión desde "valores"
		String getNumero;
		// ejecuta el método accion de la lógica las veces que se ingresó un
		// nuevo dato a "valores
		for (int i = 0; i < valores.size(); i++) {
			getSize = Integer.parseInt(valores.get(i).split(",")[0]);
			getNumero = valores.get(i).split(",")[1];
			logica.accion(getSize, getNumero);
		}
	}
}
