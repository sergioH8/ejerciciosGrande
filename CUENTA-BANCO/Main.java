package ejercicio02;

/*
 * Ejercicio 2:
 * 
 * A) Crea una clase Cuenta para representar una cuenta bancaria. Los datos de
 * la cuenta son:
 * 
 * · nombre del cliente (String)
 * 
 * · número de cuenta (String)
 * 
 * · tipo de interés (double)
 * 
 * · saldo (double).
 * 
 * La clase contendrá los siguientes métodos:
 * 
 * · Constructor por defecto
 * 
 * · Constructor con todos los parámetros
 * 
 * · Constructor copia. Este método crea una cuenta a partir de otra ya
 * existente.
 * 
 * · Métodos setters/getters para asignar y obtener los datos de la cuenta.
 * 
 * · Métodos ingreso y reintegro.
 * 
 * o Un ingreso consiste en aumentar el saldo en la cantidad que se indique. Esa
 * cantidad no puede ser negativa.
 * 
 * o Un reintegro consiste en disminuir el saldo en una cantidad pero antes se
 * debe comprobar que hay saldo suficiente. La cantidad no puede ser negativa.
 * 
 * Los métodos ingreso y reintegro devuelven true si la operación se ha podido
 * realizar o false en caso contrario.
 * 
 * · Método transferencia que permita pasar dinero de una cuenta a otra siempre
 * que en la cuenta de origen haya dinero suficiente para poder hacerla. Ejemplo
 * de uso del método transferencia:
 * 
 * cuentaOrigen.transferencia(cuentaDestino, importe);
 * 
 * que indica que queremos hacer una transferencia desde cuentaOrigen a
 * cuentaDestino del importe indicado.
 * 
 * B) Crea una clase principal donde:
 * 
 * · Crea un menú con las siguientes opciones
 * 
 * o Crear cuenta
 * 
 * o Mostrar saldo cuenta
 * 
 * o Hacer ingreso en cuenta
 * 
 * o Hacer transferencia
 * 
 * o Mostrar datos de la cuenta
 * 
 * · Realizar las operaciones que se indican en el menú utilizando la clase
 * cuenta creada en el apartado A
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
		int opcion = 0;

		while (opcion != 7) {
			System.out.println("Escribe la opción: ");
			System.out.println("1- Crear cuenta");
			System.out.println("2- Mostrar saldo cuenta");
			System.out.println("3- Hacer ingreso cuenta");
			System.out.println("4- Sacar dinero cuenta");
			System.out.println("5- Hacer transferencia cuenta");
			System.out.println("6- Mostrar datos cuenta");
			System.out.println("7- Eliminar cuenta");
			System.out.println("8- Salir");

			try {
				opcion = sc.nextInt();
				sc.nextLine();

				switch (opcion) {

				case 1:
					CuentaBancaria.crearCuenta(cuentas);
					break;

				case 2:
					CuentaBancaria.mostarSaldo(cuentas);
					break;

				case 3:
					CuentaBancaria.hacerIngreso(cuentas);
					break;
					
				case 4:
					CuentaBancaria.hacerReintegro(cuentas);
					break;
					
				case 5:
					CuentaBancaria.hacerTransferencia(cuentas);
					break;
				case 6:

					CuentaBancaria.mostrarDatosCuentas(cuentas);
					break;
				case 7:

					CuentaBancaria.eliminarCuenta(cuentas);
					break;
				case 8:

					System.out.println("Saliendo del programa");
					break;
				default:

					System.out.println("La opción que has elegido es incorrecta");
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, ingresa un número válido ");
				sc.nextLine();
			}
		}

		sc.close();
	}
}