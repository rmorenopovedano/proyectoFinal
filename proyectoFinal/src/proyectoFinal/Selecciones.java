package proyectoFinal;

public class Selecciones {
	private Seleccionado seleccionado;
	private String a�o;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a�o == null) ? 0 : a�o.hashCode());
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
		if (a�o == null) {
			if (other.a�o != null)
				return false;
		} else if (!a�o.equals(other.a�o))
			return false;
		if (seleccionado != other.seleccionado)
			return false;
		return true;
	}
	public void annadir (){
		
	}
	
}
