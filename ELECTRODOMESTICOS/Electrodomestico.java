package ejercicio04;

public class Electrodomestico {

	protected  double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected double peso;

	// Constantes por defecto
	protected final static String COLOR_POR_DEFECTO = "blanco";
	protected final static char CONSUMO_ENERGETICO_POR_DEFECTO = 'F';
	protected final static double PRECIO_BASE_POR_DEFECTO = 100.0;
	protected final static double PESO_POR_DEFECTO = 5.0;

	// Colores permitidos
	private static final String[] COLORES_PERMITIDOS = { "blanco", "negro", "rojo", "azul", "gris" };
	// Letras permitidas
	private static final char[] LETRAS_PERMITIDAS = { 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 *  // Constructor por defecto
	 */
	public Electrodomestico() {
		this.precioBase = PRECIO_BASE_POR_DEFECTO;
		this.color = COLOR_POR_DEFECTO;
		this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;
	}

	/** 
	 * // Constructor con parámetros obligatorios
	 * @param precioBase
	 * @param peso
	 */
	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.color = COLOR_POR_DEFECTO;
		this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;
		this.peso = peso;
	}

	/**
	 * 
	 * @param precioBase double
	 * @param color String
	 * @param consumoEnergetico char
	 * @param peso double
	 */
	public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		super();
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public void setColor(String color) {
		this.color = comprobarColor(color);
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public static String getColorPorDefecto() {
		return COLOR_POR_DEFECTO;
	}

	public static char getConsumoEnergeticoPorDefecto() {
		return CONSUMO_ENERGETICO_POR_DEFECTO;
	}

	public static double getPrecioBasePorDefecto() {
		return PRECIO_BASE_POR_DEFECTO;
	}

	public static double getPesoPorDefecto() {
		return PESO_POR_DEFECTO;
	}

	 String comprobarColor(String color) {
		
		for (String colorPermitido : COLORES_PERMITIDOS) {
			if (colorPermitido.equalsIgnoreCase(color)) {
				this.color = colorPermitido;
			}
		}
		// Asignar color por defecto
		if (this.color == null) {
			System.out.println("Color no válido. Se mantiene el color por defecto: " + COLOR_POR_DEFECTO);
			this.color = COLOR_POR_DEFECTO;
		}
		return color;

	}

	private char comprobarConsumoEnergetico(char letra) {
		// Validar sin importar mayúsculas o minúsculas
		for (char letraPermitida : LETRAS_PERMITIDAS) {
			if (Character.toLowerCase(letraPermitida) == Character.toLowerCase(letra)) {
				this.consumoEnergetico = letra;
				return this.consumoEnergetico;  // Al comprobar y devolver con return no llega a la siguiente parte del
												// codigo, se sale directamente.
			}
		}

		// Asignar consumo por defecto si no encontramos una letra permitida
		System.out.println(
				"Letra de consumo no válida. Se mantiene el consumo por defecto: " + CONSUMO_ENERGETICO_POR_DEFECTO);
		this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;

		return this.consumoEnergetico;
	}

	protected static  double calcularPrecioLetra(char consumoEnergetico) {
		char letraMayuscula = Character.toUpperCase(consumoEnergetico);

		switch (letraMayuscula) {
		case 'A':
			return 100;
		case 'B':
			return 80;
		case 'C':
			return 60;
		case 'D':
			return 50;
		case 'E':
			return 30;
		case 'F':
			return 10;
		default:
			System.out.println("Letra no válida. Se aplica un precio predeterminado (F)");
			return 10; // Precio de letra predeterminada
		}
	}

	protected static  double calcularPrecioPeso(double peso) {
		if (peso >= 0 && peso < 20) {
			return 10;
		} else if (peso >= 20 && peso < 50) {
			return 50;
		} else if (peso >= 50 && peso < 80) {
			return 80;
		} else if (peso >= 80) {
			return 100;
		} else {
			System.out.println("Peso no válido. Se aplica un precio predeterminado.");
			return 10;
		}
	}

	public double calcularPrecioFinal() {
		 double precioLetra = calcularPrecioLetra(consumoEnergetico);
		    double precioPeso = calcularPrecioPeso(peso);
		    double precioFinal = this.precioBase + precioLetra + precioPeso;
		    return precioFinal;
	}
}