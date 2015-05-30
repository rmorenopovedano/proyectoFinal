package proyectoFinal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Fichero implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static File fichero = new File("Sin-titulo.obj");


    public static void guardar(File file, Club club)
                    throws IOException {
            file = annadirExtension(file);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            new BufferedOutputStream(new FileOutputStream(file, false)))) {
                    objectOutputStream.writeObject(club);
            }
    }

    public static Object abrir(File archivo) throws FileNotFoundException,
                    IOException, ClassNotFoundException {
            archivo = annadirExtension(archivo);
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                            archivo))) {
                    return (Object) ois.readObject();
            }
    }

    public static File annadirExtension(File archivo) {
            String extension = archivo.getName();
            if (!extension.endsWith(".obj"))
                    return new File(archivo + ".obj");
            return archivo;
    }

   
}
