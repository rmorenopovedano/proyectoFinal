/**
 * 
 */
package proyectoFinal;

/**
 * Clase que contiene la información del Masajista
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Masajista extends Miembro implements Sueldos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Titulación del masajista
	 */
	private TitulacionMasajista titulacion;
	/**
	 * Años de experiencia del masajista
	 */
	private int annosExperiencia;

	/**
	 * Construye un nuevo masajista por nombre, apellido1, apellido2, categoría,
	 * titulación y años de experiencia
	 * 
	 * @param nombre
	 *            Representa el nombre del masajista
	 * @param apellido1
	 *            Representa el primer apellido del masajista
	 * @param apellido2
	 *            Representa el segundo apellido del masajista
	 * @param categoria
	 *            Representa la categoría del masajista
	 * @param titulacion
	 *            Representa la titulación del masajista
	 * @param annosExperiencia
	 *            Representa los años de experiencia del masajista
	 * @throws NombreInvalidoException
	 *             si el nombre no es válido
	 * @throws ApellidoInvalidoException
	 *             si el apellido no es válido
	 * @throws AñoNacimientoInvalidoException
	 *             si el año de nacimiento no es válido
	 * @throws ValorNegativoException
	 *             si el valor es negativo
	 */
	public Masajista(String nombre, String apellido1, String apellido2,
			Categoria categoria, TitulacionMasajista titulacion,
			int annosExperiencia) throws NombreInvalidoException,
			ApellidoInvalidoException, AñoNacimientoInvalidoException,
			ValorNegativoException {
		super(Tipo.MASAJISTA, nombre, apellido1, apellido2, categoria);
		setTitulacion(titulacion);
		setAnnosExperiencia(annosExperiencia);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}

	/**
	 * Obtiene la titulación del masajista
	 * 
	 * @return titulación del masajista
	 */
	public TitulacionMasajista getTitulacion() {
		return titulacion;
	}

	/**
	 * Modifica la titulacion del masajista
	 * @param titulacion Representa la nueva titulación del masajista
	 */
	public void setTitulacion(TitulacionMasajista titulacion) {
		this.titulacion = titulacion;
	}

	/**
	 * Obtiene los años de experiencia del masajista
	 * 
	 * @return años de experiencia del masajista
	 */
	public int getAnnosExperiencia() {
		return annosExperiencia;
	}

	/**
	 * Modifica los años de experiencia del masajista
	 * 
	 * @param annosExperiencia
	 *            Representa los nuevos años de experiencia del masajista
	 */
	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}

	/**
	 * Calcula el sueldo del masajista según su titulación y sus años de
	 * experiencia
	 * 
	 * @return sueldo del masajista
	 */
	@Override
	public float calcularSueldo(float sueldo) {
		switch (getTitulacion()) {
		case FISIOTERAPEUTA:
			if (annosExperiencia == 0)
				sueldo *= 3 * 0.6;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 3 * 0.7;
			else
				sueldo *= 3 * 0.8;
			return sueldo;
		case OSTEOPATA:
			if (annosExperiencia == 0)
				sueldo *= 3 * 0.4;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 3 * 0.5;
			else
				sueldo *= 3 * 0.6;
			return sueldo;
		default:
			if (annosExperiencia == 0)
				sueldo *= 3 * 0.3;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 3 * 0.4;
			else
				sueldo *= 3 * 0.5;
			return sueldo;
		}
	}

	/**
	 * Devuelve una cadena con la información del masajista
	 */
	@Override
	public String toString() {
		return "Masajista [titulacion=" + titulacion + ", annosExperiencia="
				+ annosExperiencia + "]";
	}
}
