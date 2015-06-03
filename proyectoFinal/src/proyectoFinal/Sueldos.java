/**
 * 
 */
package proyectoFinal;

/**
 * Interfaz que calcula los sueldos de cada uno de los tipos de los miembros del
 * club
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public interface Sueldos {
	/**
	 * Calcula el sueldo de un miembro
	 * 
	 * @param sueldo
	 *            Representa el sueldo base del miembro
	 * @return sueldo del miembro
	 */
	float calcularSueldo(float sueldo);
}
