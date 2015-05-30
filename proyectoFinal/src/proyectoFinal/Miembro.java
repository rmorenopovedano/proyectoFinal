package proyectoFinal;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Miembro implements Serializable, Comparable<Miembro> {
	private Tipo tipo;
	private String nombre;
	static private final Pattern patronNombre = Pattern
			.compile("^[A-Za-z\\s\\.ÁáÉéÍíÓóÚúÚüÄäËëÏïOöÑñ]{2,20}$");
	static private final Pattern patronFecha = Pattern
			.compile("(19[0-9][0-9])|(20[0-9][0-9])");
	private String apellido1;
	private String apellido2;
	private String annoNacimiento;
	private Categoria categoria;
	private Date fechaAlta;
	protected int id;
	protected float sueldo;
	static private float SUELDO_BASE = 1000;
	private static int idContador;

	// private ArrayList<Selecciones> selecciones;

	public Miembro(Tipo tipo, String nombre, String apellido1,
			String apellido2, String añoNacimiento, Categoria categoria)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setAñoNacimiento(añoNacimiento);
		setCategoria(categoria);
		setFechaAlta();
		setId();
		setTipo(tipo);
		this.sueldo = SUELDO_BASE;
		// selecciones = new ArrayList<Selecciones>();
	}

	public Miembro(Tipo tipo, String nombre, String apellido1,
			String apellido2, String añoNacimiento)
			throws NombreInvalidoException, ApellidoInvalidoException,
			AñoNacimientoInvalidoException, ValorNegativoException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setAñoNacimiento(añoNacimiento);
		setCategoria();
		setFechaAlta();
		setId();
		setTipo(tipo);
		this.sueldo = SUELDO_BASE;
		// selecciones = new ArrayList<Selecciones>();
	}

	public Miembro(int id) {
		this.id = id;
	}

	private void setId() {
		this.id = ++idContador;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreInvalidoException {
		if (esNombreValido(nombre))
			this.nombre = nombre;
		else
			throw new NombreInvalidoException("Nombre incorrecto");
	}

	public String getAñoNacimiento() {
		return annoNacimiento;
	}

	public void setAñoNacimiento(String añoNacimiento)
			throws AñoNacimientoInvalidoException {
		if (esFechaValida(añoNacimiento) == 0)
			this.annoNacimiento = añoNacimiento;
		else if (esFechaValida(añoNacimiento) == 1)
			throw new AñoNacimientoInvalidoException(
					"Año no válido. El niño es demasiado pequeño.");
		else
			throw new AñoNacimientoInvalidoException(
					"Año no válido. Verifique el formato.");
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCategoria() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		int diferencia = Integer.parseInt(formato.format(new Date()))
				- Integer.parseInt(annoNacimiento);
		switch (diferencia) {
		case 6:
		case 7:
			this.categoria = Categoria.PREBENJAMIN;
			break;
		case 8:
		case 9:
			this.categoria = Categoria.BENJAMIN;
			break;
		case 10:
		case 11:
			this.categoria = Categoria.ALEVIN;
			break;
		case 12:
		case 13:
			this.categoria = Categoria.INFANTIL;
			break;
		case 14:
		case 15:
			this.categoria = Categoria.CADETE;
			break;
		case 16:
		case 17:
		case 18:
			this.categoria = Categoria.JUVENIL;
			break;
		default:
			this.categoria = Categoria.SENIOR;
			break;
		}
	}

	public String getFechaAlta() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fechaAlta);
	}

	public String getAnnoAlta() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		return formato.format(fechaAlta);
	}

	public void setFechaAlta() {
		this.fechaAlta = new Date();
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido1(String apellido1) throws ApellidoInvalidoException {
		if (esNombreValido(apellido1))
			this.apellido1 = apellido1;
		else
			throw new ApellidoInvalidoException("Apellido incorrecto");
	}

	public void setApellido2(String apellido2) throws ApellidoInvalidoException {
		if (apellido2.equals("")) {
			this.apellido2 = apellido2;
		} else if (esNombreValido(apellido2))
			this.apellido2 = apellido2;
		else
			throw new ApellidoInvalidoException("Apellido incorrecto");
	}

	public static boolean esNombreValido(String nombre) {
		return patronNombre.matcher(nombre).matches();
	}

	public static int esFechaValida(String annoNacimiento) {
		if (!patronFecha.matcher(annoNacimiento).matches())
			return 2; // Error de patrón no válido.
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		int diferencia = Integer.parseInt(formato.format(new Date()))
				- Integer.parseInt(annoNacimiento);
		if (diferencia < 0)
			return 2; // Error de año mayor que el actual
		if (diferencia < 6)
			return 1; // Error de niño demasiado pequeño
		return 0; // Todo OK.
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Miembro other = (Miembro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	// @Override
	// public abstract float calcularSueldo(int sueldo);

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public static float getSueldoBase() {
		return SUELDO_BASE;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Miembro [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", annoNacimiento="
				+ annoNacimiento + ", categoria=" + categoria + ", fechaAlta="
				+ fechaAlta + ", id=" + id + ", sueldo=" + sueldo + "]";
	}

	@Override
	public int compareTo(Miembro miembro) {
		int resultado = 0;
		if (this.apellido1.compareTo(miembro.apellido1) < 0)
			resultado = -1;// El apellido1 del primer miembro es menor
		else if (this.apellido1.compareTo(miembro.apellido1) > 0)
			resultado = 1;// El apellido1 del primero miembro es mayor
		else {
			if (this.apellido2.compareTo(miembro.apellido2) < 0)
				resultado = -1;// El apellido2 del primer miembro es menor
			else if (this.apellido2.compareTo(miembro.apellido2) > 0)
				resultado = 1;// El apellido2 del primer miembro es mayor
			else
				resultado = 0;// Los 2 apellidos son iguales
		}

		return resultado;

	}

}
