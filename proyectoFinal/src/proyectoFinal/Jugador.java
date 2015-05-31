package proyectoFinal;

public class Jugador extends Miembro implements Sueldos{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dorsal;
	private DemarcacionJugador demarcacion;
//	private ArrayList<Premios> premios;
	private int partidosJugados;
	private int golesMarcados;

	public Jugador(String nombre, String apellido1, String apellido2,
			String añoNacimiento,
			int partidosJugados, int dorsal, DemarcacionJugador demarcacion, int golesMarcados)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super(Tipo.JUGADOR, nombre, apellido1, apellido2, añoNacimiento);
		setDorsal(dorsal);
		setDemarcacion(demarcacion);
//		setAltura(altura);
//		setPremios(premios);
		setPartidosJugados(partidosJugados);
		setGolesMarcados(golesMarcados);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getGolesMarcados() {
		return golesMarcados;
	}

	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}

	public int getDorsal() {
		return dorsal;
	}

//	public ArrayList<Premios> getPremios() {
//		return premios;
//	}

//	public void setPremios(ArrayList<Premios> premios) {
//		this.premios = premios;
//	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public DemarcacionJugador getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(DemarcacionJugador demarcacion) {
		this.demarcacion = demarcacion;
	}

//	public float getAltura() {
//		return altura;
//	}

//	public void setAltura(float altura) {
//		this.altura = altura;
//	}

	@Override
	public float calcularSueldo(float sueldo) {
		switch (demarcacion) {
		case PORTERO:
			return sueldo *= 1.10;
		case ALA_DERECHO:
			return sueldo *= 1.15;
		case ALA_IZQUIERDO:
			return sueldo *= 1.15;
		case CIERRE:
			return sueldo *= 1.12;
		case PIVOT:
			return sueldo *= 1.20;

		}
		return 0;
	}

@Override
	public String toString() {
		return "Jugador [id="+super.id+", dorsal=" + dorsal + ", demarcacion=" + demarcacion+", sueldo="+sueldo
				+ ", partidosJugados=" + partidosJugados + ", golesMarcados="
				+ golesMarcados + "]";
	}


		

}
