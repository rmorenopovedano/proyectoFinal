/**
 * 
 */
package proyectoFinal;

/**
 * Demarcaciones de los jugadores
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0 
 */
public enum DemarcacionJugador {
	/**
	 * Representa la demarcación Portero
	 */
	PORTERO, 
	/**
	 * Representa la demarcación Cierre
	 */
	CIERRE, 
	/**
	 * Representa la demarcación Ala Derecho
	 */
	ALA_DERECHO, 
	/**
	 * Representa la demarcación Ala Izquierda
	 */
	ALA_IZQUIERDO, 
	/**
	 * Representa la demarcación Pivot
	 */
	PIVOT;
	/**
	 * Devuelve el nombre de las demarcaciones
	 */
	public String toString() {
		return name();

	}
}
