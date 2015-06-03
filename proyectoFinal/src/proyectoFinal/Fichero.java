/**
 * 
 */
package proyectoFinal;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase que sirve para manipular ficheros
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Fichero implements Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1L;
	/**
	 * Fichero que vamos a manipular
	 */
	public static File fichero = new File("Sin-titulo.obj");

	/**
	 * Método para guardar un fichero
	 * 
	 * @param file
	 *            Representa el fichero que vamos a guardar
	 * @param club
	 *            Representa el club que vamos a guardar
	 * @throws IOException
	 */
	public static void guardar(File file, Club club) throws IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			objectOutputStream.writeObject(club);
		}
	}

	/**
	 * Método para abrir un fichero
	 * 
	 * @param archivo
	 *            Representa el fichero que vamos a abrir
	 * @return Objeto existente
	 * @throws FileNotFoundException
	 *             si no encuentra el fichero
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object abrir(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo))) {
			return (Object) ois.readObject();
		}
	}

	/**
	 * Añade una extensión .obj al fichero que queremos manipular
	 * 
	 * @param archivo
	 *            Representa el fichero que estamos usando
	 * @return Fichero con la extensión añadida
	 */
	public static File annadirExtension(File archivo) {
		String extension = archivo.getName();
		if (!extension.endsWith(".obj"))
			return new File(archivo + ".obj");
		return archivo;
	}

}
