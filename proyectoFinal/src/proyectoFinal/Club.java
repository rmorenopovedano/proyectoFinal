package proyectoFinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Club implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Miembro> plantilla = new ArrayList<Miembro>();
	private final String nombreClub = "C.D. Modas Levante";
	private boolean modificado;

	public void annadir(Miembro miembro) {
		plantilla.add(miembro);
	}

	public boolean eliminar(int id) {
		Miembro miembro = new Miembro(id);
		return plantilla.remove(miembro);
	}

	public int size() {
		return plantilla.size();
	}

	public ArrayList<Miembro> getMiembrosCategoria(Categoria categoria) {
		ArrayList<Miembro> arrMiembrosCategoria = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getCategoria() == categoria)
				arrMiembrosCategoria.add(miembro);
		}
		return arrMiembrosCategoria;
	}

	public ArrayList<Miembro> getJugadores() {
		ArrayList<Miembro> arrJugadores = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getTipo() == Tipo.JUGADOR)
				arrJugadores.add(miembro);
		}
		return arrJugadores;
	}

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
						+ miembro.getNombre() + " " + miembro.getApellido1()+ " "+miembro.getApellido2();
				conta++;
			}
		}
		return arrJugadores;
	}
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
						+ miembro.getNombre() + " " + miembro.getApellido1()+ " "+miembro.getApellido2();
				conta++;
			}
		}
		return arrEntrenadores;
	}
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
						+ miembro.getNombre() + " " + miembro.getApellido1()+ " "+miembro.getApellido2();
				conta++;
			}
		}
		return arrMasajistas;
	}

	public String[] getMiembrosParaLista() {
		int tamano = 0;
		for (Miembro miembro : plantilla) {
			tamano++;
		}
		String[] arrMiembros = new String[tamano];
		int conta = 0;
		for (Miembro miembro : plantilla) {
			arrMiembros[conta] = miembro.getId() + ".- " + miembro.getNombre()
					+ " " + miembro.getApellido1()+" "+miembro.getApellido2();
			conta++;

		}
		return arrMiembros;
	}
	public ArrayList<Miembro> getMiembrosPorAnno(String fechaAlta) {
		ArrayList<Miembro> arrMiembrosPorAnno = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			System.out.println(miembro.getAnnoAlta()+" "+fechaAlta);
			if (Integer.parseInt(miembro.getAnnoAlta()) == Integer.parseInt(fechaAlta))
				arrMiembrosPorAnno.add(miembro);
		}
		return arrMiembrosPorAnno;
	}
	
	public ArrayList<Miembro> getMiembrosPorTipo(Tipo tipo) {
		ArrayList<Miembro> array = new ArrayList<Miembro>();
		for (Miembro miembro : plantilla) {
			if (miembro.getTipo().equals(tipo))
				array.add(miembro);
		}
		return array;
	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	public Miembro get(int id) {
		Miembro miembro = new Miembro(id);
		int index = plantilla.indexOf(miembro);
		if (index != -1) {
			return plantilla.get(index);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Club [club=" + plantilla + ", nombreClub=" + nombreClub + "]";
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void ordenar() {
		Collections.sort(plantilla);
	}

	public Club getClubFiltradoTipo(Tipo tipo) {
		ArrayList<Miembro> arraylist = getMiembrosPorTipo(tipo);
		Club clubEntrenadores = new Club();
		for (Miembro miembro : arraylist) {
				clubEntrenadores.annadir(miembro);
		}

		return clubEntrenadores;
	}
}
