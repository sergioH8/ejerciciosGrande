package ejercicio03;

import java.util.ArrayList;
import java.util.Scanner;

import ejercicio02.CuentaBancaria;

public class Libro {
	protected String tituloLibro;
	protected String nombreAutor;
	protected int numeroEjemplares;
	protected int numeroEjemplaresPrestados;

	/**
	 * 
	 */
	public Libro() {
		super();
		tituloLibro = "";
		nombreAutor = "";
		numeroEjemplares = 0;
		numeroEjemplaresPrestados = 0;

	}

	/**
	 * 
	 * @param tituloLibro
	 * @param nombreAutor
	 * @param numeroEjemplares
	 * @param numeroEjemplaresPrestados
	 */
	public Libro(String tituloLibro, String nombreAutor, int numeroEjemplares, int numeroEjemplaresPrestados) {
		super();
		this.tituloLibro = tituloLibro;
		this.nombreAutor = nombreAutor;
		this.numeroEjemplares = numeroEjemplares;
		this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
	}
	

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	public int getNumeroEjemplaresPrestados() {
		return numeroEjemplaresPrestados;
	}

	public void setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) {
		this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
	}

	private boolean prestarLibro() {
		if (numeroEjemplares > 0) {
			numeroEjemplares--;
			numeroEjemplaresPrestados++;
			return true;
		} else {
			return false;
		}
	}

	private boolean devolverLibro() {
		if (numeroEjemplaresPrestados > 0) {
			numeroEjemplares++;
			numeroEjemplaresPrestados--;
			return true;
		} else {
			return false;
		}
	}

	public static void agregarLibro(ArrayList<Libro> listaDeLibros) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Especifique el titulo del libro:");
		String tituloLibro = sc.nextLine();
		System.out.println("Especifique el nombre del autor:");
		String nombreAutor = sc.nextLine();
		System.out.println("Especifique el número de ejemplares:");
		int numeroEjemplares = sc.nextInt();
		System.out.println("Especifique el número de ejemplares prestados:");
		int numeroEjemplaresPrestados = sc.nextInt();

		Libro libroNuevo = new Libro();
		libroNuevo.setNombreAutor(nombreAutor);
		libroNuevo.setNumeroEjemplares(numeroEjemplares);
		libroNuevo.setNumeroEjemplaresPrestados(numeroEjemplaresPrestados);
		libroNuevo.setTituloLibro(tituloLibro);

		listaDeLibros.add(libroNuevo);
		System.out.println("Libro agregado con éxito");
	}

	public static void devolucionLibro(ArrayList<Libro> listaDeLibros) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido Realizar devolución");
		System.out.println("Especifique el título del libro a devolver:");
		String libroADevolver = sc.nextLine();
		for (Libro libro : listaDeLibros) {
			if (libro.getTituloLibro().equalsIgnoreCase(libroADevolver)) {
				libro.devolverLibro();
				break;
			}
		}
	}

	public static void prestacionLibro(ArrayList<Libro> listaDeLibros) {
		System.out.println(" Aqui tienes tu lista de libros, cual quieres prestar ? ");
		Libro.mostrarLibros(listaDeLibros);
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido Realizar préstamo");
		System.out.println("Especifique el título del libro a prestar:");
		String libroAPrestar = sc.nextLine();

		for (Libro libro : listaDeLibros) {
			if (libro.getTituloLibro().equals(libroAPrestar)) {
				libro.prestarLibro();
				// Puedes imprimir un mensaje indicando que el préstamo se realizó con éxito, si
				// lo deseas.
				System.out.println("Préstamo realizado con éxito.");
				return; // Termina el método después de prestar el libro.
			}
		}

		// Si llegamos aquí, significa que no se encontró el libro en la lista.
		System.out.println("Libro no encontrado en la lista.");
	}

	public static void mostrarLibros(ArrayList<Libro> listaDeLibros) {
		System.out.println("Has elegido Mostrar libros");
		for (Libro libro : listaDeLibros) {
			System.out.println(libro.toString());
		}

	}

	public static void eliminarLibro(ArrayList<Libro> listaDeLibros) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido Eliminar libro");
		System.out.println("Estos son tus libros");
		Libro.mostrarLibros(listaDeLibros);
		System.out.println("Especifique el título del libro a eliminar:");
		String libroAEliminar = sc.nextLine();

		// Crear una lista temporal para almacenar libros a eliminar
		ArrayList<Libro> librosAEliminar = new ArrayList<>();

		// Iterar sobre la lista original
		for (Libro libro : listaDeLibros) {
			if (libro.getTituloLibro().equalsIgnoreCase(libroAEliminar)) {
				if (libro.getNumeroEjemplaresPrestados() == 0) {
					librosAEliminar.add(libro);
				} else {
					System.out.println("No puedes eliminar un libro con ejemplares prestados.");
					return;
				}
			}
		}

		// Eliminar los libros de la lista original después de completar la iteración
		listaDeLibros.removeAll(librosAEliminar);

		// Mostrar mensaje de éxito si se eliminaron libros
		if (!librosAEliminar.isEmpty()) {
			System.out.println("Libro(s) eliminado(s) con éxito.");
		} else {
			System.out.println("No se encontró ningún libro con el título especificado.");
		}
	}

	@Override
	public String toString() {
		return "Libro [tituloLibro=" + tituloLibro + ", nombreAutor=" + nombreAutor + ", numeroEjemplares="
				+ numeroEjemplares + ", numeroEjemplaresPrestados=" + numeroEjemplaresPrestados + "]";
	}

}
