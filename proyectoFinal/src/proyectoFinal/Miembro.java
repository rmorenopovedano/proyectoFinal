/**
 * 
 */
package proyectoFinal;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Clase padre que contiene la informaci�n com�n a todos los miembros
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Miembro implements Serializable, Comparable<Miembro> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Tipo de miembro
	 */
	private Tipo tipo;
	/**
	 * Nombre del miembro
	 */
	private String nombre;
	/**
	 * Patr�n para un nombre v�lido
	 */
	static private final Pattern patronNombre = Pattern
			.compile("^[A-Za-z\\s\\.������������������O���]{1,20}$");
	/**
	 * Patr�n para una fecha v�lida
	 */
	static private final Pattern patronFecha = Pattern
			.compile("(19[0-9][0-9])|(20[0-9][0-9])");
	/**
	 * Primer apellido del miembro
	 */
	private String apellido1;
	/**
	 * Segundo apellido del miembro
	 */
	private String apellido2;
	/**
	 * A�o de nacimiento del miembro
	 */
	private String annoNacimiento;
	/**
	 * Categor�a del miembro
	 */
	private Categoria categoria;
	/**
	 * Fecha de alta de un miembro
	 */
	private Date fechaAlta;
	/**
	 * Identificador del miembro
	 */
	protected int id;
	/**
	 * Sueldo del miembro
	 */
	protected float sueldo;
	/**
	 * Sueldo base de todos los miembros
	 */
	static private float SUELDO_BASE = 1000;
	/**
	 * Identificador autoincrementable
	 */
	public static int idContador;

	/**
	 * Construye un miembro por tipo, nombre, apellido1, apellido2 y categor�a
	 * 
	 * @param tipo
	 *            Representa el tipo del miembro
	 * @param nombre
	 *            Representa el nombre del miembro
	 * @param apellido1
	 *            Representa el primer apellido del miembro
	 * @param apellido2
	 *            Representa el segundo apellido del miembro
	 * @param categoria
	 *            Representa la categor�a del miembro
	 * @throws NombreInvalidoException
	 *             si el nombre es inv�lido
	 * @throws ApellidoInvalidoException
	 *             si el apellido es inv�lido
	 * @throws A�oNacimientoInvalidoException
	 *             si el a�o de nacimiento es inv�lido
	 * @throws ValorNegativoException
	 *             si el valor es negativo
	 */

	public Miembro(Tipo tipo, String nombre, String apellido1,
			String apellido2, Categoria categoria)
			throws NombreInvalidoException, ApellidoInvalidoException,
			A�oNacimientoInvalidoException, ValorNegativoException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setCategoria(categoria);
		setFechaAlta();
		setId();
		setTipo(tipo);
		this.sueldo = SUELDO_BASE;
	}

	/**
	 * Construye un nuevo miembro por tipo, nombre, apellido1, apellido2 y a�o
	 * de nacimiento
	 * 
	 * @param tipo
	 *            Representa el tipo del miembro
	 * @param nombre
	 *            Representa el nombre del miembro
	 * @param apellido1
	 *            Representa el primer apellido del miembro
	 * @param apellido2
	 *            Representa el segundo apellido del miembro
	 * @param a�oNacimiento
	 *            Representa el a�o de nacimiento del miembro
	 * @throws NombreInvalidoException
	 *             si el nombres es inv�lido
	 * @throws ApellidoInvalidoException
	 *             si el apellido es inv�lido
	 * @throws A�oNacimientoInvalidoException
	 *             si el a�o de nacimiento es inv�lido
	 * @throws ValorNegativoException
	 *             si el valor es negativo
	 */
	public Miembro(Tipo tipo, String nombre, String apellido1,
			String apellido2, String a�oNacimiento)
			throws NombreInvalidoException, ApellidoInvalidoException,
			A�oNacimientoInvalidoException, ValorNegativoException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setA�oNacimiento(a�oNacimiento);
		setCategoria();
		setFechaAlta();
		setId();
		setTipo(tipo);
		this.sueldo = SUELDO_BASE;

	}

	/**
	 * Construye un miembro nuevo por id
	 * 
	 * @param id
	 *            Representa el id del miembro
	 */

	public Miembro(int id) {
		this.id = id;
	}

	/**
	 * Modifica el id del miembro
	 */
	private void setId() {
		this.id = ++idContador;

	}

	/**
	 * Obtiene el nombre del miembro
	 * 
	 * @return nombre del miembro
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del miembro
	 * 
	 * @param nombre
	 *            Representa el nuevo nombre del miembro
	 * @throws NombreInvalidoException
	 *             si el nombre es inv�lido
	 */
	public void setNombre(String nombre) throws NombreInvalidoException {
		if (esNombreValido(nombre))
			this.nombre = nombre;
		else
			throw new NombreInvalidoException("Nombre incorrecto");
	}

	/**
	 * Obtiene el a�o de nacimiento del miembro
	 * 
	 * @return a�o de nacimiento del miembro
	 */
	public String getA�oNacimiento() {
		return annoNacimiento;
	}

	/**
	 * Modifica el a�o de nacimiento del miembro
	 * 
	 * @param a�oNacimiento
	 *            Representa el nuevo a�o de nacimiento del miembro
	 * @throws A�oNacimientoInvalidoException
	 *             si el a�o es inv�lido
	 */
	public void setA�oNacimiento(String a�oNacimiento)
			throws A�oNacimientoInvalidoException {
		if (esFechaValida(a�oNacimiento) == 0)
			this.annoNacimiento = a�oNacimiento;
		else if (esFechaValida(a�oNacimiento) == 1)
			throw new A�oNacimientoInvalidoException(
					"A�o no v�lido. El ni�o es demasiado peque�o.");
		else
			throw new A�oNacimientoInvalidoException(
					"A�o no v�lido. Verifique el formato.");
	}

	/**
	 * Obtiene la categor�a del miembro
	 * 
	 * @return categor�a del miembro
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Modifica la categor�a del miembro
	 * 
	 * @param categoria
	 *            Representa la nueva categor�a del miembro
	 */

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Modifica la categor�a del miembro
	 */
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

	/**
	 * Obtiene la fecha de alta del miembro
	 * 
	 * @return fecha de alta del miembro
	 */
	public String getFechaAlta() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fechaAlta);
	}

	/**
	 * Obtiene el a�o de alta del miembro
	 * 
	 * @return a�o de alta del miembro
	 */
	public String getAnnoAlta() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		return formato.format(fechaAlta);
	}

	/**
	 * Modifica la fecha de alta del miembro
	 */
	public void setFechaAlta() {
		this.fechaAlta = new Date();
	}

	/**
	 * Obtiene el primer apellido del miembro
	 * 
	 * @return apellido1 del miembro
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Obtiene el segundo apellido del miembro
	 * 
	 * @return apellido2 del miembro
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Modifica el primer apellido del miembro
	 * 
	 * @param apellido1
	 *            Representa el nuevo apellido1 del miembro
	 * @throws ApellidoInvalidoException
	 *             si el apellido es inv�lido
	 */
	public void setApellido1(String apellido1) throws ApellidoInvalidoException {
		if (esNombreValido(apellido1))
			this.apellido1 = apellido1;
		else
			throw new ApellidoInvalidoException("Apellido incorrecto");
	}

	/**
	 * Modifica el segundo apellido del miembro
	 * 
	 * @param apellido2
	 *            Repreenta el nuevo apellido2 del miembro
	 * @throws ApellidoInvalidoException
	 *             si el apellido es inv�lido
	 */
	public void setApellido2(String apellido2) throws ApellidoInvalidoException {
		if (apellido2.equals("")) {
			this.apellido2 = apellido2;
		} else if (esNombreValido(apellido2))
			this.apellido2 = apellido2;
		else
			throw new ApellidoInvalidoException("Apellido incorrecto");
	}

	/**
	 * M�todo que valida un nombre
	 * 
	 * @param nombre
	 *            Representa el nombre que se quiere validar
	 * @return true si el nombre es v�lido, false en otro caso
	 */
	public static boolean esNombreValido(String nombre) {
		return patronNombre.matcher(nombre).matches();
	}

	/**
	 * M�todo que valida una fecha
	 * 
	 * @param annoNacimiento
	 *            Representa la fecha que se quiere validar
	 * @return 0 si la fecha es v�lida, 1 si hay un error de que el ni�o es
	 *         demasiado peque�o, 2 si hay un error de formato o patr�n inv�lido
	 */
	public static int esFechaValida(String annoNacimiento) {
		if (!patronFecha.matcher(annoNacimiento).matches())
			return 2;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		int diferencia = Integer.parseInt(formato.format(new Date()))
				- Integer.parseInt(annoNacimiento);
		if (diferencia < 0)
			return 2;
		if (diferencia < 6)
			return 1;
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/**
	 * Obtiene el id del miembro
	 * 
	 * @return id del miembro
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtiene el sueldo del miembro
	 * 
	 * @return sueldo del miembro
	 */
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Modifica el sueldo del miembro
	 * 
	 * @param sueldo
	 *            Representa el nuevo sueldo del miembro
	 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Obtiene el sueldo base del miembro
	 * 
	 * @return sueldo base del miembro
	 */
	public static float getSueldoBase() {
		return SUELDO_BASE;
	}

	/**
	 * Obtiene el tipo del miembro
	 * 
	 * @return tipo del miembro
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo del miembro
	 * 
	 * @param tipo
	 *            Representa el nuevo tipo del miembro
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve una cadena con la informaci�n del miembro
	 */
	@Override
	public String toString() {
		return "Miembro [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", annoNacimiento="
				+ annoNacimiento + ", categoria=" + categoria + ", fechaAlta="
				+ fechaAlta + ", id=" + id + ", sueldo=" + sueldo + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Miembro miembro) {
		int resultado = 0;
		if (this.apellido1.compareTo(miembro.apellido1) < 0)
			resultado = -1;// El apellido1 del primer miembro es menor
		else if (this.apellido1.compareTo(miembro.apellido1) > 0)
			resultado = 1;// El apellido1 del primer miembro es mayor
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
