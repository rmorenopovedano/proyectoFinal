/**
 * 
 */
package proyectoFinal;
/**
 * Clase que contiene la información del Entrenador
 * @author RAUL MORENO POVEDANO	
 * @version 1.0 
 */
public class Entrenador extends Miembro implements Sueldos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Nivel del entrenador
	 */
	private NivelEntrenador nivel;
	/**
	 * Años de experiencia
	 */
	private int annosExp;
	/**
	 * Construye un nuevo Entrenador por nombre, apellido1, apellido2, categoría, nivel y años de experiencia
	 * @param nombre Representa el nombre del entrenador
	 * @param apellido1 Representa el primer apellido del entrenador
	 * @param apellido2 Representa el segundo apellido del entrenador
	 * @param categoria Representa la categoría del entrenador
	 * @param nivel Representa el nivel del entrenador
	 * @param annosExp Representa los años de experiencia del entrenador
	 * @throws NombreInvalidoException Si el nombre no es válido
	 * @throws ApellidoInvalidoException Si el apellido no es válido
	 * @throws AñoNacimientoInvalidoException Si el año de nacimiento no es válido
	 * @throws ValorNegativoException Si hay valores negativos
	 */
	public Entrenador(String nombre, String apellido1, String apellido2, Categoria categoria,
			NivelEntrenador nivel, int annosExp)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super(Tipo.ENTRENADOR, nombre, apellido1, apellido2, categoria);
		setNivel(nivel);
		setAnnosExp(annosExp);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}
	/**
	 * Obtiene el nivel del entrenador
	 * @return nivel del entrenador
	 */

	public NivelEntrenador getNivel() {
		return nivel;
	}
	/**
	 * Modifica el nivel del entrenador
	 * @param nivel Representa el nuevo nivel del entrenador
	 */

	public void setNivel(NivelEntrenador nivel) {
		this.nivel = nivel;
	}
	/**
	 * Obtiene los años de experiencia del entrenador
	 * @return años de experiencia del entrenador
	 */

	public int getAnnosExp() {
		return annosExp;
	}
	/**
	 * Modifica los años de experiencia del entrenador
	 * @param annosExp Representan los nuevos años de experiencia del entrenador
	 */
	public void setAnnosExp(int annosExp) {
		this.annosExp = annosExp;
	}
	/**
	 * Calcula el sueldo de un entrenador según su nivel y los años de experiencia
	 * @return sueldo del entrenador
	 */
	public float calcularSueldo(float sueldo) {
		switch (getNivel()) {
		case LICENCIADO:
			if (annosExp == 0)
				sueldo *= 4.10;
			else if (annosExp > 0 && annosExp < 5)
				sueldo *= 4.20;
			else
				sueldo *= 4.30;
			return sueldo;
		case NIVEL2:
			if (annosExp == 0)
				sueldo *= 4.09;
			else if (annosExp > 0 && annosExp < 5)
				sueldo *= 4.19;
			else
				sueldo *= 4.29;
			return sueldo;

		case NIVEL1:
			if (annosExp == 0)
				sueldo *= 4.07;
			else if (annosExp > 0 && annosExp < 5)
				sueldo *= 4.17;
			else
				sueldo *= 4.27;
			return sueldo;

		case MONITOR:
			if (annosExp == 0)
				sueldo *= 4.05;
			else if (annosExp > 0 && annosExp < 5)
				sueldo *= 4.15;
			else
				sueldo *= 4.25;
			return sueldo;
		}
		return 0;

	}
	/**
	 * Devuelve una cadena con la información del entrenador
	 */
	@Override
	public String toString() {
		return "Entrenador [nivel=" + nivel + ", annosExp=" + annosExp + "]";
	}

}
