package ejercicio5;

public abstract class  Empleado {
	protected String nombre;
	protected int edad;
	protected int salario;
	protected static final int PLUS = 300;

	/**
	 * 	
	 */
	public Empleado() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.salario = 0;
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param salario
	 */
	public Empleado(String nombre, int edad, int salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public abstract int getPlus();

	@Override
	public abstract String toString();

}
