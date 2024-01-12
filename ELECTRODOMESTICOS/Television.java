package ejercicio04;

public class Television extends Electrodomestico{
	int resolucion;
	boolean tdt;
	
	protected final int RESOLUCION_POR_DEFECTO = 20;
	protected final boolean TDT_POR_DEFECTO = false;
	

	
	/**
	 * Constructor por defecto con la carga y el resto de atreibutos heredados
	 */
	public Television() {
		super();
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.tdt = TDT_POR_DEFECTO;
	}
	
	/**
	 * Constructor con precio y peso. El resto por defecto
	 * @param precioBase
	 * @param peso
	 */
	public Television(double precioBase, double peso) {
		super(precioBase,peso);
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.tdt = TDT_POR_DEFECTO;
		// TODO Auto-generated constructor stub
	}
	/**
	 *  // Constructor con carga y el resto de atributos heredados
	 * @param precioBase
	 * @param color
	 * @param consumoEnergetico
	 * @param peso
	 * @param resolucion
	 * @param tdt
	 */

	public Television(double precioBase, String color, char consumoEnergetico, double peso,int resolucion, boolean tdt) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.tdt = tdt;
		// TODO Auto-generated constructor stub
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	@Override
	public double calcularPrecioFinal() {
	    double precioLetra = Electrodomestico.calcularPrecioLetra(consumoEnergetico);
	    double precioTamaño = Electrodomestico.calcularPrecioPeso(peso);
	    double precioFinal = precioBase + precioLetra + precioTamaño;

	    if (resolucion > 40) {
	        precioFinal *= 1.3; // Aumentamos un 30%
	    }
	    if (tdt == true) {
	        precioFinal += 50;
	    }

	    return precioFinal;
	}
}