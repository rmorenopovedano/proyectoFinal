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
	 * Representa la demarcaci�n Portero
	 */
	PORTERO, 
	/**
	 * Representa la demarcaci�n Cierre
	 */
	CIERRE, 
	/**
	 * Representa la demarcaci�n Ala Derecho
	 */
	ALA_DERECHO, 
	/**
	 * Representa la demarcaci�n Ala Izquierda
	 */
	ALA_IZQUIERDO, 
	/**
	 * Representa la demarcaci�n Pivot
	 */
	PIVOT;
	/**
	 * Devuelve el nombre de las demarcaciones
	 */
	public String toString() {
		return name();

	}
}
