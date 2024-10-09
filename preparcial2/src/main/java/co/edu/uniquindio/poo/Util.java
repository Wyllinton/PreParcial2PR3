package co.edu.uniquindio.poo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Util {

    private static Util instance;
    //Singleton
    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

        //Código para la gestión de archivos, se escriben los miembros en un txt
    public static <T> void escribirMiembrosTxt(File archivo, List<T> lista, String formato) throws IOException{
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
    
}
