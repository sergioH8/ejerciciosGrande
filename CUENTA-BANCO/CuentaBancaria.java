package ejercicio02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CuentaBancaria {
	private String nombreCliente;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;

	/**
	 * Constructor por defecto
	 */
	public CuentaBancaria() {
		nombreCliente = "";
		numeroCuenta = "";
		tipoInteres = 0;
		saldo = 0;
	}

	/**
	 * Constructor copia
	 * 
	 * @param c
	 */
	public CuentaBancaria(CuentaBancaria c) {
		nombreCliente = c.nombreCliente;
		numeroCuenta = c.numeroCuenta;
		tipoInteres = c.tipoInteres;
		saldo = c.saldo;
	}

	/**
	 * Constructor con todos los parámetros
	 * 
	 * @param nombreCliente
	 * @param numeroCuenta
	 * @param tipoInteres
	 * @param saldo
	 */
	public CuentaBancaria(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
		this.nombreCliente = nombreCliente;
		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean hacerIngreso(double ingreso) {
		if (ingreso > 0) {
			saldo += ingreso;
			return true;
		}
		return false;
	}

	public boolean hacerReintegro(double reintegro) {
		if (saldo - reintegro >= 0) {
			saldo -= reintegro;
			return true;
		}
		return false;
	}

	public static void mostrarCuentas(ArrayList<CuentaBancaria> cuentas) { // Pasamos la lista por parámetro
		System.out.println("Estas son tus cuentas: ");
		for (int i = 0; i < cuentas.size(); i++) { // Recorremos el tamaño de la lista
			System.out.println((i + 1) + "  " + cuentas.get(i).getNombreCliente()); // Mostramos el numero de la
																					// posicion de cada variable con
																					// con su nombre
		}
	}

	public static boolean hacerTransferencia(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino,
			double importe) {
		if (importe > 0 && cuentaOrigen.saldo >= importe) {
			cuentaOrigen.saldo -= importe;
			cuentaDestino.saldo += importe;
			return true;
		}
		return false;
	}

	public static void hacerIngreso(ArrayList<CuentaBancaria> cuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido hacer ingreso");
		if (!cuentas.isEmpty()) {
			try { // Con el try nos aseguramos que el programa no se para
					// en el caso de que el usuario no introduzca un numero
				System.out.println("Cuánto dinero quieres ingresar?");
				double ingreso = sc.nextDouble();

				CuentaBancaria.mostrarCuentas(cuentas); // Llamamos al metodo mostrar.cuentas para ver por pantalla
				System.out.println("A qué cliente le quieres ingresar? "); // las cuentas que tenemos actualmente

				int cuentaIndex;

				if (sc.hasNextInt()) { // Aseguramos que es un entero con este metodo de la clase Scanner
					cuentaIndex = sc.nextInt();

					if (cuentaIndex >= 1 && cuentaIndex <= cuentas.size()) { // Comparamos que hay mas de dos cuentas
						cuentas.get(cuentaIndex - 1).hacerIngreso(ingreso); // señalamos la cuenta a la que vamos a
																			// ingresar el dinero
						System.out.println("Ingreso exitoso. Saldo actual de "
								+ cuentas.get(cuentaIndex - 1).getNombreCliente() + ": "// Mostramos el saldo de esa
																						// cuenta y el nombre del
																						// propietario
								+ cuentas.get(cuentaIndex - 1).getSaldo());
					} else {
						System.out.println("Número de cuenta inválido");
					}
				} else {
					System.out.println("Por favor, ingresa un número válido para elegir la cuenta");

				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, ingresa un número válido para el monto del ingreso");

			}
		} else {
			System.out.println("No hay cuentas creadas");
		}
	}
	
	public static void hacerReintegro(ArrayList<CuentaBancaria> cuentas) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Has elegido hacer reintegro");
	    
	    if (!cuentas.isEmpty()) {
	        mostrarCuentas(cuentas);

	        System.out.println("Introduce el número de la cuenta elegida: ");
	        if (sc.hasNextInt()) {
	            int cuentaIndex = sc.nextInt();
	            
	            try {
	                if (cuentaIndex >= 1 && cuentaIndex <= cuentas.size()) {
	                    System.out.println("¿Cuánto dinero quieres sacar?");
	                    double reintegro = sc.nextDouble();

	                    CuentaBancaria cuentaSeleccionada = cuentas.get(cuentaIndex - 1);

	                    if (cuentaSeleccionada.hacerReintegro(reintegro)== true) {
	                        System.out.println("Reintegro exitoso. Saldo actual de "
	                                + cuentaSeleccionada.getNombreCliente() + ": " + cuentaSeleccionada.getSaldo());
	                    } else {
	                        System.out.println("No hay suficiente saldo para realizar el reintegro.");
	                    }
	                } else {
	                    System.out.println("Número de cuenta inválido");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Por favor, ingresa un número válido para la cuenta o el monto del reintegro.");
	            }
	        } else {
	            System.out.println("Por favor, ingresa un número válido para la cuenta.");
	        }
	    } else {
	        System.out.println("No hay cuentas creadas");
	    }
	}


	public static void hacerTransferencia(ArrayList<CuentaBancaria> cuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido hacer transferencia");
		if (cuentas.size() >= 2) { // Aseguramos que tenemos al menos dos cuentas
			CuentaBancaria.mostrarCuentas(cuentas); // LLamamos a la funcion mostar cuentas para ver cuales tenemos

			System.out.println("Introduce el número de la cuenta de origen: ");
			if (sc.hasNextInt()) { // Aseguramos que es un entero el numero pasado por consola
				int cuentaOrigenIndex = sc.nextInt();

				System.out.println("Introduce el número de la cuenta de destino: ");
				if (sc.hasNextInt()) { // Aseguramos que es un entero el numero pasado por consola
					int cuentaDestinoIndex = sc.nextInt();
					sc.nextLine();
					try {
						System.out.println("¿Cuánto dinero quieres enviar?");
						double importe = sc.nextDouble();
						sc.nextLine();

						CuentaBancaria cuentaOrigen = cuentas.get(cuentaOrigenIndex - 1); // Nombramos cual sera la
																							// cuenta de origen y
																							// destino
						CuentaBancaria cuentaDestino = cuentas.get(cuentaDestinoIndex - 1);

						CuentaBancaria.hacerTransferencia(cuentaOrigen, cuentaDestino, importe); // Le pasamos los
																									// parámetros
																									// obtenidos al
																									// metodo
																									// que opera
					} catch (InputMismatchException e) {
						System.out.println("Por favor, ingresa un número válido para elegir la cuenta.");
						sc.nextLine();
					}
				} else {
					System.out.println("Por favor, ingresa un número válido para elegir la cuenta");
					sc.nextLine();
				}
			} else {
				System.out.println("Por favor, ingresa un número válido para elegir la cuenta");
				sc.nextLine();
			}
		} else {
			System.out.println("Debes tener al menos dos cuentas creadas para hacer una transferencia");
		}
	}

	public static void mostarSaldo(ArrayList<CuentaBancaria> cuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Has elegido mostrar saldo");
		if (!cuentas.isEmpty()) { // Aseguramos que la lsita no esta vacia
			CuentaBancaria.mostrarCuentas(cuentas); // LLamamos al metodo mostrar cuentas para elegir que cuenta
													// queremos
			int cuentaIndexToShow = sc.nextInt(); // Nombramos a la cuenta dandole en un valor INT
			sc.nextLine();

			if (cuentaIndexToShow >= 1 && cuentaIndexToShow <= cuentas.size()) { // Si esta dentro del tamaño de la
																					// lista operamos
				System.out.println("Saldo de la cuenta " + cuentaIndexToShow + ": " // Mostramos la cuenta y el saldo de
																					// ese valor en la lista
						+ cuentas.get(cuentaIndexToShow - 1).getSaldo());
			} else {
				System.out.println("Número de cuenta inválido");
			}
		} else {
			System.out.println("No hay cuentas creadas");
		}
	}

	public static void crearCuenta(ArrayList<CuentaBancaria> cuentas) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del cliente: ");
		try {
			String nombreCliente = sc.nextLine();

			System.out.println("Introduce el numero de cuenta con la letra del cliente: ");// Introducimos valores
			try {
				String numeroCuenta = sc.nextLine();
				System.out.println("Introduce el tipo de interes del cliente: ");
				if (sc.hasNextDouble()) {
					double tipoInteres = sc.nextDouble();
					System.out.println("Introduce el saldo del cliente: ");
					if (sc.hasNextDouble()) {
						double saldo = sc.nextDouble();
						CuentaBancaria nuevaCuenta = new CuentaBancaria(); // Usamos esos valores para los setters y
																			// actualizar la cuenta
						nuevaCuenta.setNombreCliente(nombreCliente);
						nuevaCuenta.setNumeroCuenta(numeroCuenta);
						nuevaCuenta.setSaldo(saldo);
						nuevaCuenta.setTipoInteres(tipoInteres);
						cuentas.add(nuevaCuenta); // Añadimos cuenta

					} else {
						System.out.println("Introduce un valor numerico");
					}
				} else {
					System.out.println("Introduce un valor numerico");
				}
			} catch (NoSuchElementException e) {
				System.out.println(
						"Error: No se ha proporcionado una cadena de texto. Por favor, introduce un nombre válido.");
				sc.nextLine();
			}
		} catch (NoSuchElementException e) {
			System.out.println(
					"Error: No se ha proporcionado una cadena de texto. Por favor, introduce un nombre válido.");
			sc.nextLine();
		}
	}
	public static void eliminarCuenta(ArrayList<CuentaBancaria> cuentas) {
	    Scanner sc = new Scanner(System.in);
	    mostrarCuentas(cuentas);
	    if (!cuentas.isEmpty()) {
	      
	        System.out.println("Seleccione el número de la cuenta que desea eliminar: ");

	        try {
	            int cuentaIndex = sc.nextInt();
	            sc.nextLine(); // Limpiar el buffer

	            if (cuentaIndex >= 1 && cuentaIndex <= cuentas.size()) {
	                CuentaBancaria cuentaSeleccionada = cuentas.get(cuentaIndex - 1);

	                if (cuentaSeleccionada.getSaldo() == 0) {
	                    cuentas.remove(cuentaIndex - 1);
	                    System.out.println("Cuenta eliminada: " + cuentaSeleccionada.getNombreCliente());
	                } else {
	                    System.out.println("No puedes eliminar una cuenta con saldo. El saldo actual es: " + cuentaSeleccionada.getSaldo());
	                }
	            } else {
	                System.out.println("Número de cuenta inválido");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Por favor, ingresa un número válido para seleccionar la cuenta.");
	            sc.nextLine(); // Limpiar el buffer
	        }
	    } else {
	        System.out.println("No hay cuentas creadas");
	    }
	}

	public static void mostrarDatosCuentas(ArrayList<CuentaBancaria> cuentas) {
		System.out.println("Mostrar datos de las cuentas:");
		for (int i = 0; i < cuentas.size(); i++) {
			System.out.println("Cuenta " + (i + 1) + ": " + cuentas.get(i).toString());
		}
	}

	@Override
	public String toString() {
		return "CuentaBancaria [nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", tipoInteres="
				+ tipoInteres + ", saldo=" + saldo + "]";
	}
}
