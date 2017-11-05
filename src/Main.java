import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	// clase que vincular� las diferentes clases de la aplciaci�n
	private static Logica logica;

	public static void main(String[] args) {
		logica = new Logica();
		teclado();
	}

	
	private static void teclado() {
		// variable que agregar� los datos ingresados
		String input = ",";
		// variable que agrega la forma de finalizar la apicaci�n
		String finalizar = "0,0";
		// variable que agrega los distintos mensajes que se muestran en
		// pantalla, errores, etc.
		String mensaje;
		// arraylist que agregar� los datos ingresados para que no se pierdan si se llegaran a necesitar
		ArrayList<String> valores = new ArrayList<>();
		// variable que recibir� el tama�o de la impresi�n
		int size;
		// variable que recibir� los n�meros a imprimir
		String numero;
		Scanner teclado = new Scanner(System.in);
		mensaje = "Ingrese 2 valores num�ricos con la forma 'x,y' sin las comillas '0,0' terminar� la aplicaci�n \nx = tama�o de impresi�n (debe estar entre 1 y 10) \ny = n�meros que se mostrar�n (pueden ser infinitos :D)";
		System.out.println(mensaje);
		mensaje = "Ingrese los valores abajo V, recuerde terminar la aplicaci�n para ver el resultado:";
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
					mensaje = "ERROR, el tama�o de la impresi�n debe de estar entre 1 y 10";
					System.err.println(mensaje);
					break;
				}
				if (input.split(",").length > 2) {
					mensaje = "ERROR, el valor contiene m�s caracteres, recuerda la forma 'x,y'";
					System.err.println(mensaje);
					break;
				}
				valores.add(size + "," + numero);

			} catch (ArrayIndexOutOfBoundsException e) {
				mensaje = "ERROR. debes escribir 2 valores n�mericos, recuerda la forma 'x,y'";
				System.err.print(mensaje);
				break;
			} catch (NumberFormatException e) {
				mensaje = "ERROR. Los valores tienen que ser num�ricos, recuerda la forma 'x,y'";
				System.err.print(mensaje);
				break;
			}
		} while (!input.equals(finalizar));
		teclado.close();
		// obtendr� el tama�o de la impresi�n desde "valores"
		int getSize;
		// obtendr� los n�meros de la impresi�n desde "valores"
		String getNumero;
		// ejecuta el m�todo accion de la l�gica las veces que se ingres� un
		// nuevo dato a "valores
		for (int i = 0; i < valores.size(); i++) {
			getSize = Integer.parseInt(valores.get(i).split(",")[0]);
			getNumero = valores.get(i).split(",")[1];
			logica.accion(getSize, getNumero);
		}
	}
}
