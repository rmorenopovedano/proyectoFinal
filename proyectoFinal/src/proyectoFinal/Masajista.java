package proyectoFinal;

public class Masajista extends Miembro implements Sueldos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitulacionMasajista titulacion;
	private int annosExperiencia;

	public Masajista(String nombre, String apellido1, String apellido2, Categoria categoria,
			TitulacionMasajista titulacion, int annosExperiencia)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super(Tipo.MASAJISTA, nombre, apellido1, apellido2, categoria);
		setTitulacion(titulacion);
		setAnnosExperiencia(annosExperiencia);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}

	public TitulacionMasajista getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(TitulacionMasajista titulacion) {
		this.titulacion = titulacion;
	}

	public int getAnnosExperiencia() {
		return annosExperiencia;
	}

	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}

	@Override
	public float calcularSueldo(float sueldo) {
		switch (getTitulacion()) {
		case FISIOTERAPEUTA:
			if (annosExperiencia == 0)
				sueldo *= 2 * 0.6;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 2 * 0.7;
			else
				sueldo *= 2 * 0.8;
			return sueldo;
		case OSTEOPATA:
			if (annosExperiencia == 0)
				sueldo *= 2 * 0.4;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 2 * 0.5;
			else
				sueldo *= 2 * 0.6;
			return sueldo;
		case QUIROMASAJISTA:
			if (annosExperiencia == 0)
				sueldo *= 2 * 0.3;
			else if (annosExperiencia > 0 && annosExperiencia < 5)
				sueldo *= 2 * 0.4;
			else
				sueldo *= 2 * 0.5;
			return sueldo;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Masajista [titulacion=" + titulacion + ", annosExperiencia="
				+ annosExperiencia + "]";
	}
}
