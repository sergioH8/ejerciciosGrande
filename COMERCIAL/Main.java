package ejercicio5;

public class Main {
    public static void main(String[] args) {

        // Empleado empleado1 = new Empleado(); Compilaria error al ser una clase abstacta, no se puede crear objetos de ella,
    	// solo seria el molde para crear objetos de sus subclases

        Comercial comercial1 = new Comercial("Juan", 35, 2000, 250);

        Repartidor repartidor1 = new Repartidor("Sergio", 28, 1500, "3");
        Repartidor repartidor2 = new Repartidor("Fernando", 23, 1500, "3");

        System.out.println("El salario final del comercial1 es: " + comercial1.getPlus());
        System.out.println("El salario final del repartidor1 es: " + repartidor1.getPlus());
        System.out.println("El salario final del repartidor2 es: " + repartidor2.getPlus());
    }
}
