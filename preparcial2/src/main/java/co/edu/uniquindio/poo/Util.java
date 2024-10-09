package co.edu.uniquindio.poo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Util {

    private static Util instance;

    // Singleton
    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    // Código para la gestión de archivos, se escriben los miembros en un txt
    public static <T> void escribirMiembrosTxt(File archivo, List<T> lista, String formato) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 0; i < lista.size(); i++) {
                writer.write(lista.get(i).toString());
                writer.newLine();
                if ((i + 1) % 10 == 0 || i == lista.size() - 1) {
                    writer.newLine();
                }

                // Si se ha escrito 10 elementos, hacemos flush para escribir en el archivo txt
                if ((i + 1) % 10 == 0) {
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para serializar un objeto
    public static void serializarObjeto(Personaje persona, String archivo) {
        try (FileOutputStream fileOut = new FileOutputStream(archivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(persona);
            System.out.println("Objeto serializado y guardado en " + archivo);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // Método para deserializar un objeto
    public static Personaje deserializarObjeto(String archivo) {
        Personaje persona = null;
        try (FileInputStream fileIn = new FileInputStream(archivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            persona = (Personaje) in.readObject();
            System.out.println("Objeto deserializado desde " + archivo);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return persona;
    }


    // Serializar un objeto en un archivo de XML
    public static void serializarObjetoXML(String nombre, Object objeto) throws IOException {

        XMLEncoder codificador;

        codificador = new XMLEncoder(new FileOutputStream(nombre));
        codificador.writeObject(objeto);
        codificador.close();
    }

    // Deserializar un objeto en un archivo XML
    public static Object deserializarObjetoXML(String nombre) throws IOException {
        XMLDecoder decodificador;
        Object objeto;

        decodificador = new XMLDecoder(new FileInputStream(nombre));
        objeto = decodificador.readObject();
        decodificador.close();

        return objeto;
    }

}
