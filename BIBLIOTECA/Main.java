package ejercicio03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/*
	 * A) Crea una clase llamada Libro que guarde la información de cada uno de los
	 * libros de una biblioteca. La clase debe guardar:
	 * 
	 * · el título del libro
	 * 
	 * · autor
	 * 
	 * · número de ejemplares del libro
	 * 
	 * · número de ejemplares prestados
	 * 
	 * La clase contendrá los siguientes métodos:
	 * 
	 * · Constructor por defecto.
	 * 
	 * · Constructor con parámetros.
	 * 
	 * · Métodos Setters/getters
	 * 
	 * · Método préstamo que incremente el atributo correspondiente cada vez que se
	 * realice un préstamo del libro. No se podrán prestar libros de los que no
	 * queden ejemplares disponibles para prestar. Devuelve true si se ha podido
	 * realizar la operación y false en caso contrario.
	 * 
	 * · Método devolución que decremente el atributo correspondiente cuando se
	 * produzca la devolución de un libro. No se podrán devolver libros que no se
	 * hayan prestado. Devuelve true si se ha podido realizar la operación y false
	 * en caso contrario.
	 * 
	 * · Método toString para mostrar los datos de los libros. Este método se
	 * heredada de Object y lo debemos modificar (override) para adaptarlo a la
	 * clase Libro.
	 * 
	 * B) Crea una clase principal para probar el funcionamiento de la clase Libro
	 * que contenga un menú que realice las siguientes acciones:
	 * 
	 * · Inserción de libros
	 * 
	 * · Mostrar libros
	 * 
	 * · Realizar préstamo
	 * 
	 * · Realizar devolución
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		// String nombreAutor, int numeroEjemplares, int numeroEjemplaresPrestados

		ArrayList<Libro> listaDeLibros = new ArrayList<>();

		while (opcion != 6) {
			System.out.println("Escribe la opcion: ");
			System.out.println("1- Inserccion de libros: ");
			System.out.println("2- Mostrar libros: ");
			System.out.println("3- Realizar préstamo: ");
			System.out.println("4- Realizar devolución: ");
			System.out.println("5- Eliminar libro: ");
			System.out.println("6- Salir: ");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				Libro.agregarLibro(listaDeLibros);
				break;
			case 2:
				Libro.mostrarLibros(listaDeLibros);
				break;
			case 3:
				Libro.prestacionLibro(listaDeLibros);
				break;
			case 4:
				Libro.devolucionLibro(listaDeLibros);
				break;
			case 5:
				Libro.eliminarLibro(listaDeLibros);
			case 6:
				System.out.println("Saliendo del programa");
				break;

			default:
				System.out.println("La opcion que has elegido es incorrecta");
			}
		}
	}
}
