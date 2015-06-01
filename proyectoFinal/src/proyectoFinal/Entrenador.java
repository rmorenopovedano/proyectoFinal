package proyectoFinal;

public class Entrenador extends Miembro implements Sueldos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NivelEntrenador nivel;
	private int annosExp;

	public Entrenador(String nombre, String apellido1, String apellido2, Categoria categoria,
			NivelEntrenador nivel, int annosExp)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super(Tipo.ENTRENADOR, nombre, apellido1, apellido2, categoria);
		setNivel(nivel);
		setAnnosExp(annosExp);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}


	public NivelEntrenador getNivel() {
		return nivel;
	}

	public void setNivel(NivelEntrenador nivel) {
		this.nivel = nivel;
	}

	public int getAnnosExp() {
		return annosExp;
	}

	public void setAnnosExp(int annosExp) {
		this.annosExp = annosExp;
	}

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

	@Override
	public String toString() {
		return "Entrenador [nivel=" + nivel + ", annosExp=" + annosExp + "]";
	}

}
