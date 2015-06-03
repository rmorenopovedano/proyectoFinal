/**
 * 
 */
package proyectoFinal;

/**
 * Clase que contiene la informaci�n del Jugador
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Jugador extends Miembro implements Sueldos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dorsal del jugador
	 */
	private int dorsal;
	/**
	 * Demarcaci�n del jugador
	 */
	private DemarcacionJugador demarcacion;
	/**
	 * Partidos jugados por el jugador
	 */
	private int partidosJugados;
	/**
	 * Goles marcados por el jugador
	 */
	private int golesMarcados;

	/**
	 * Construye un nuevo jugador por nombre, apellido1, apellido2, a�o de
	 * nacimiento, partidos jugados, dorsal, demarcaci�n y goles marcados
	 * 
	 * @param nombre
	 *            Representa el nombre del jugador
	 * @param apellido1
	 *            Representa el primer apellido del jugador
	 * @param apellido2
	 *            Representa el segundo apellido del jugador
	 * @param a�oNacimiento
	 *            Representa el a�o de nacimiento del jugador
	 * @param partidosJugados
	 *            Representa los partidos jugador por el jugador
	 * @param dorsal
	 *            Representa el dorsal del jugador
	 * @param demarcacion
	 *            Representa la demarcaci�n del jugador
	 * @param golesMarcados
	 *            Representa los goles marcados por el jugador
	 * @throws NombreInvalidoException
	 *             si el nombre es inv�lido
	 * @throws ApellidoInvalidoException
	 *             si el apellido es inv�lido
	 * @throws A�oNacimientoInvalidoException
	 *             si el a�o de nacimiento es inv�lido
	 * @throws ValorNegativoException
	 *             si es un valor negativo
	 */

	public Jugador(String nombre, String apellido1, String apellido2,
			String a�oNacimiento, int partidosJugados, int dorsal,
			DemarcacionJugador demarcacion, int golesMarcados)
			throws NombreInvalidoException, ApellidoInvalidoException,
			A�oNacimientoInvalidoException, ValorNegativoException {
		super(Tipo.JUGADOR, nombre, apellido1, apellido2, a�oNacimiento);
		setDorsal(dorsal);
		setDemarcacion(demarcacion);
		setPartidosJugados(partidosJugados);
		setGolesMarcados(golesMarcados);
		super.setSueldo(calcularSueldo(Miembro.getSueldoBase()));
	}
	/**
	 * Obtiene los partidos jugados del jugador
	 * @return partidos jugados del jugador
	 */

	public int getPartidosJugados() {
		return partidosJugados;
	}
	/**
	 * Modifica los partidos jugados por el jugador
	 * @param partidosJugados Representa los nuevos partidos jugados por el jugador
	 */
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	/**
	 * Obtiene los goles marcados por el jugador
	 * @return goles marcados por el jugador
	 */
	public int getGolesMarcados() {
		return golesMarcados;
	}
	/**
	 * Modifica los goles marcados por el jugador
	 * @param golesMarcados Representa los nuevos goles marcados por el jugador
	 */
	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}
	/**
	 * Obtiene el dorsal del jugador
	 * @return dorsal del jugador
	 */
	public int getDorsal() {
		return dorsal;
	}
	/**
	 * Modifica el dorsal del jugador
	 * @param dorsal
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	/**
	 * Obtiene la demarcaci�n del jugador
	 * @return demarcaci�n del jugador
	 */
	public DemarcacionJugador getDemarcacion() {
		return demarcacion;
	}
	/**
	 * Modifica la demarcaci�n del jugador
	 * @param demarcacion Representa la nueva demarcaci�n del jugador
	 */
	public void setDemarcacion(DemarcacionJugador demarcacion) {
		this.demarcacion = demarcacion;
	}
	/**
	 * Calcula el sueldo del jugador dependiendo de su demarcaci�n
	 * @return el sueldo del jugador seg�n su demarcaci�n
	 */
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
		default:
			return sueldo *= 1.20;

		}

	}
	/**
	 * Devuelve una cadena con la informaci�n del jugador
	 */
	@Override
	public String toString() {
		return "Jugador [id=" + super.id + ", dorsal=" + dorsal
				+ ", demarcacion=" + demarcacion + ", sueldo=" + sueldo
				+ ", partidosJugados=" + partidosJugados + ", golesMarcados="
				+ golesMarcados + "]";
	}

}
