package co.edu.uniquindio.poo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    
        Netflix netflix= new Netflix();
        Util util = new Util();
        Serie serie = new Serie(null, "The last one", null, null, null);
        Personaje personaje1 = new Personaje("Juan", "Colombia", 30, null);
        netflix.agregarSerie(serie);
        gestionArchivos(netflix);
        String archivo = "personaje.ser";
         util.serializarObjeto(personaje1, archivo);
         
         // Deserializar el objeto
         Personaje personaDeserializada = util.deserializarObjeto(archivo);
         System.out.println("Nombre: " + personaDeserializada.getNombre() + ", Edad: " + personaDeserializada.getEdad());
}
        private static void gestionArchivos(Netflix netflix){
        String formatoSeries = "La serie con titulo %s con codigo ";
        String formatoPersonajes = "El personaje con nombre %s con su país de nacimiento %S";
        // Lista de entidades ejemplo
        ArrayList<Serie> series = netflix.getSeries();
        ArrayList<ArrayList<Personaje>> personajes = new ArrayList<>();

        for(Serie serie: series ){
            personajes.add(new ArrayList<>(serie.getPersonajes()));
            
        }

        // Directorio
        File directorio = new File("Resources");
        //Creación de los archivos txt
        File archivoSeries = new File("Resources/Series.txt");
        File archivoPersonajes = new File("Resources/Personajes.txt");
        //Comprobación de la existencia del directorio
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado: " + directorio.getPath());
            } else {
                System.out.println("No se pudo crear el directorio.");
                return;
            }
        }
        // Almacenar datos en archivo
        try {
            Util.getInstance();
            //Método para gestionar el txt de miembros
            Util.escribirMiembrosTxt(archivoSeries, series, formatoSeries);
            //Método para gestionar el txt de deportes
            JOptionPane.showMessageDialog(null, "El archivo se creó correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al manipular el archivo");
        }
    }

    
}
