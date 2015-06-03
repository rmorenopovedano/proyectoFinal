/**
 * 
 */
package proyectoFinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase envoltorio para agregar o eliminar miembros a nuestro Club.
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Club implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ArraList donde están contenidos todos los miembros del club.
	 */
	private ArrayList<Miembro> plantilla = new ArrayList<Miembro>();
	/**
	 * Nombre del club
	 */
	private final String nombreClub = "C.D. Modas Levante";
	/**
	 * Indica si el Club ha sido modificado o no
	 */
	private boolean modificado;

	/**
	 * Añade un miembro al Club.
	 * 
	 * @param miembro
	 *            Representa el miembro que vamos a añadir al club.
	 */

	public void annadir(Miembro miembro) {
		plantilla.add(miembro);
	}

	/**
	 * Elimina un miembro del Club.
	 * 
	 * @param id
	 *            Representa el id miembro a eliminar.
	 * @return true si el miembro se elimina, false en otro caso.
	 *
	 */

	public boolean eliminar(int id) {
		Miembro miembro = new Miembro(id);
		return plantilla.remove(miembro);
	}

	/**
	 * Calcula el número de miembros del club.
	 * 
	 * @return número de miemtros del club.
	 */

	public int size() {
		return plantilla.size();
	}

	/**
	 * Obtiene una lista de miembros de la misma categoría
	 * 
	 * @param categoria
	 *            Representa la categoría a buscar
	 * @return Lista de miembros de una determinada categoría
	 */
	public ArrayList<Miembro> getMiembrosCategoria(Categoria categoria) {
		ArrayList<Miembro> arrMiembrosCategoria = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getCategoria() == categoria)
				arrMiembrosCategoria.add(miembro);
		}
		return arrMiembrosCategoria;
	}

	/**
	 * Obtiene una lista de miembros con la misma fecha de alta
	 * 
	 * @param fecha
	 *            Representa la fecha a buscar
	 * @return Lista de miembros dados de alta en la misma fecha
	 */
	public ArrayList<Miembro> getMiembrosFechaAlta(String fecha) {
		ArrayList<Miembro> arrMiembrosFechaAlta = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getFechaAlta().equals(fecha))
				arrMiembrosFechaAlta.add(miembro);
		}
		return arrMiembrosFechaAlta;
	}

	/**
	 * Obtiene solo los miembros tipo Jugador del club.
	 * 
	 * @return Lista de miembros de tipo Jugador.
	 */

	public String[] getJugadoresParaLista() {
		int tamano = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Jugador)
				tamano++;
		}
		String[] arrJugadores = new String[tamano];
		int conta = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Jugador) {
				arrJugadores[conta] = miembro.getId() + ".- "
						+ miembro.getNombre().toUpperCase() + " "
						+ miembro.getApellido1().toUpperCase() + " "
						+ miembro.getApellido2().toUpperCase();
				conta++;
			}
		}
		return arrJugadores;
	}

	/**
	 * Obtiene solo los miembros tipo Entrenador del club
	 * 
	 * @return Lista de miembros de tipo Entrenador
	 */
	public String[] getEntrenadoresParaLista() {
		int tamano = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Entrenador)
				tamano++;
		}
		String[] arrEntrenadores = new String[tamano];
		int conta = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Entrenador) {
				arrEntrenadores[conta] = miembro.getId() + ".- "
						+ miembro.getNombre().toUpperCase() + " "
						+ miembro.getApellido1().toUpperCase() + " "
						+ miembro.getApellido2().toUpperCase();
				conta++;
			}
		}
		return arrEntrenadores;
	}

	/**
	 * Obtiene solo los miembros tipo Masajista del Club
	 * 
	 * @return Lista de miembros de tipo Masajista
	 */
	public String[] getMasajistasParaLista() {
		int tamano = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Masajista)
				tamano++;
		}
		String[] arrMasajistas = new String[tamano];
		int conta = 0;
		for (Miembro miembro : plantilla) {
			if (miembro instanceof Masajista) {
				arrMasajistas[conta] = miembro.getId() + ".- "
						+ miembro.getNombre().toUpperCase() + " "
						+ miembro.getApellido1().toUpperCase() + " "
						+ miembro.getApellido2().toUpperCase();
				conta++;
			}
		}
		return arrMasajistas;
	}

	/**
	 * Obtiene una lista con todos los miembros del club
	 * 
	 * @return Lista con todos los miembros del club
	 */
	public String[] getMiembrosParaLista() {
		String[] arrMiembros = new String[plantilla.size()];
		int conta = 0;
		for (Miembro miembro : plantilla) {
			arrMiembros[conta] = miembro.getId() + ".- "
					+ miembro.getNombre().toUpperCase() + " "
					+ miembro.getApellido1().toUpperCase() + " "
					+ miembro.getApellido2().toUpperCase();
			conta++;

		}
		return arrMiembros;
	}

	/**
	 * Obtiene una lista de los miembros dados de alta en el mismo año
	 * 
	 * @param fechaAlta
	 *            Representa el año por el que vamos a buscar
	 * @return Lista de miembros dados de alta en el mismo año
	 */
	public ArrayList<Miembro> getMiembrosPorAnno(String fechaAlta) {
		ArrayList<Miembro> arrMiembrosPorAnno = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (Integer.parseInt(miembro.getAnnoAlta()) == Integer
					.parseInt(fechaAlta))
				arrMiembrosPorAnno.add(miembro);
		}
		return arrMiembrosPorAnno;
	}

	/**
	 * Determina si se ha modificado el club
	 * 
	 * @return true si ha sido modificado el club, false en otro caso
	 */

	public boolean isModificado() {
		return modificado;
	}

	/**
	 * Modifica el estado del club
	 * 
	 * @param modificado
	 *            Representa el estado que queremos darle al club
	 */

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Obtiene el miembro indicado por el índice
	 * 
	 * @param id
	 *            Representa el índice a buscar
	 * @return Miembro del club con el índice buscado
	 */
	public Miembro get(int id) {
		Miembro miembro = new Miembro(id);
		int index = plantilla.indexOf(miembro);
		if (index != -1) {
			return plantilla.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Devuelve una cadena con la información del club
	 */
	@Override
	public String toString() {
		return "Club [club=" + plantilla + ", nombreClub=" + nombreClub + "]";
	}

	/**
	 * Comprueba si el club esta vacío
	 * 
	 * @return true si esta vacío, false si contiene algún miembro
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ordena los miembros del club
	 */
	public void ordenar() {
		Collections.sort(plantilla);
	}

	/**
	 * Obtiene una lista de miembros según sea Jugador, Entrenador o Masajista
	 * 
	 * @param tipo
	 *            Representa el tipo de miembro que se quiere buscar
	 * @return Lista de miembros de un determinado tipo
	 */
	public ArrayList<Miembro> getMiembrosPorTipo(Tipo tipo) {
		ArrayList<Miembro> array = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getTipo().equals(tipo))
				array.add(miembro);
		}
		return array;
	}

	/**
	 * Obtiene un club filtrado según el tipo
	 * 
	 * @param tipo
	 *            Representa el tipo por el que se quiere filtrar
	 * @return Club filtrado según el tipo de miembro
	 */
	public Club getClubFiltradoTipo(Tipo tipo) {
		ArrayList<Miembro> arraylist = getMiembrosPorTipo(tipo);
		Club clubPorTipo = new Club();
		for (Miembro miembro : arraylist) {
			clubPorTipo.annadir(miembro);
		}

		return clubPorTipo;
	}
}
