package proyectoFinal;

public class Selecciones {
	private Seleccionado seleccionado;
	private String año;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((año == null) ? 0 : año.hashCode());
		result = prime * result
				+ ((seleccionado == null) ? 0 : seleccionado.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selecciones other = (Selecciones) obj;
		if (año == null) {
			if (other.año != null)
				return false;
		} else if (!año.equals(other.año))
			return false;
		if (seleccionado != other.seleccionado)
			return false;
		return true;
	}
	public void annadir (){
		
	}
	
}
