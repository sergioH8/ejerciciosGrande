package ejercicio04;

public class Main {

	public static void main(String[] args) {
		// Crear electrodomésticos
		Electrodomestico electrodomestico1 = new Electrodomestico(200, "rojo", 'a', 40);
		Electrodomestico electrodomestico2 = new Electrodomestico();
		Electrodomestico electrodomestico3 = new Electrodomestico(400, "azul", 'd', 20);
		Electrodomestico electrodomestico4 = new Electrodomestico(300, 70);

		Electrodomestico lavadora1 = new Lavadora(250, "verde", 'c', 40, 80);
		Electrodomestico lavadora2 = new Lavadora();
		Electrodomestico lavadora3 = new Lavadora(300, 250);

		Electrodomestico television1 = new Television(400, "rojo", 'a', 60, 60, true);
		Electrodomestico television2 = new Television();
		Electrodomestico television3 = new Television(400, 60);
		
		System.out.println("Precio final de electrodomestico1: " + electrodomestico1.calcularPrecioFinal());
		System.out.println("Precio final de electrodomestico2: " + electrodomestico2.calcularPrecioFinal());
		System.out.println("Precio final de electrodomestico3: " + electrodomestico3.calcularPrecioFinal());
		System.out.println("Precio final de electrodomestico4: " + electrodomestico4.calcularPrecioFinal());

		System.out.println("Precio final de lavadora1: " + lavadora1.calcularPrecioFinal());
		System.out.println("Precio final de lavadora2: " + lavadora2.calcularPrecioFinal());
		System.out.println("Precio final de lavadora3: " + lavadora3.calcularPrecioFinal());

		System.out.println("Precio final de television1: " + television1.calcularPrecioFinal());
		System.out.println("Precio final de television2: " + television2.calcularPrecioFinal());
		System.out.println("Precio final de television3: " + television3.calcularPrecioFinal());

	}
}
