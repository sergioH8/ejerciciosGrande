package ejercicio5;

public class Repartidor extends Empleado {

	private String zona;

	/**
	 * 
	 */
	public Repartidor() {
		super();
		zona = "";
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param salario
	 */
	public Repartidor(String nombre, int edad, int salario, String zona) {
		super(nombre, edad, salario);
		this.zona = zona;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Repartidor [zona=" + zona + "]";
	}

	

	@Override
	public int getPlus() {
		if (edad < 25 && zona.equals("3")) {
			return salario += PLUS;
		}
		return salario;
	}

}