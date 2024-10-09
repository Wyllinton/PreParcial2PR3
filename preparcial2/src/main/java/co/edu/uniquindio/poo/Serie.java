package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Date;

/*Realizar las funcionalidades necesarias para crear una aplicación para la gestión de la información de las series de Netflix, las series se caracterizan por su código, título, año de inicio, sinopsis, género al que pertenece (acción, aventura, animación, comedia, documental, drama, terror, musical, romance, ciencia ficción) y personajes que intervienen.
 */

public class Serie {
    private String codigo;
    private String titulo;
    private Date añoInicio;
    private String sinopsis;
    private GeneroSerie genero;
    private ArrayList<Personaje> personajes;
    
    public Serie(String codigo, String titulo, Date añoInicio, String sinopsis, GeneroSerie genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.añoInicio = añoInicio;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.personajes= new ArrayList<Personaje>();
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getAñoInicio() {
        return añoInicio;
    }
    public void setAñoInicio(Date añoInicio) {
        this.añoInicio = añoInicio;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public GeneroSerie getGenero() {
        return genero;
    }
    public void setGenero(GeneroSerie genero) {
        this.genero = genero;
    }
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }
    @Override
    public String toString() {
        return "Serie [codigo=" + codigo + ", titulo=" + titulo + ", añoInicio=" + añoInicio + ", sinopsis=" + sinopsis
                + ", genero=" + genero + ", personajes=" + personajes + "]";
    }

    
}

