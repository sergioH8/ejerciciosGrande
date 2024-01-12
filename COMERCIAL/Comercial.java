package ejercicio5;

public class Comercial extends Empleado {

	private double comision;

	/**
	 * 
	 */
	public Comercial() {
		super();
		comision = 0;
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param salario
	 */
	public Comercial(String nombre, int edad, int salario, double comision) {
		super(nombre, edad, salario);
		this.comision = comision;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	@Override
	public String toString() {
		return "Comercial [comision=" + comision + "]";
	}


	@Override
	public int getPlus() {
		if (edad > 30 && salario > 200) {
			return salario += PLUS;
		}
		return salario;
	}


}
