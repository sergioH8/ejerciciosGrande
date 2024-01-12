package ejercicio04;

public class Lavadora extends Electrodomestico {
	protected int carga;

	protected final int CARGA_POR_DEFECTO = 5;

		
	/**
	 * Constructor por defecto con la carga y el resto de atreibutos heredados
	 */
	public Lavadora() {
		super();
		this.carga = CARGA_POR_DEFECTO;
	}
	
	/**
	 * Constructor con precio y peso. El resto por defecto
	 * @param precioBase
	 * @param peso
	 */
	public Lavadora(double precioBase, double peso) {
		super(precioBase,peso);
		this.carga = CARGA_POR_DEFECTO;
		// TODO Auto-generated constructor stub
	}
	 /**
	  *  // Constructor con carga y el resto de atributos heredados
	  * @param precioBase
	  * @param color
	  * @param consumoEnergetico
	  * @param peso
	  * @param carga
	  */

	public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, int carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
		// TODO Auto-generated constructor stub
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getCARGA_POR_DEFECTO() {
		return CARGA_POR_DEFECTO;
	}

    @Override
    public double calcularPrecioFinal() {
        double precioLetra = Electrodomestico.calcularPrecioLetra(consumoEnergetico);
        double precioTamaño = Electrodomestico.calcularPrecioPeso(peso);
      
        if (carga >= 30) {
        	precioBase += 50;
        }
        double precioFinal = precioLetra + precioTamaño +  precioBase;
        return precioFinal;
    }
}
