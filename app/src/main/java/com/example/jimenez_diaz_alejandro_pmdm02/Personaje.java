package com.example.jimenez_diaz_alejandro_pmdm02;

import java.util.List;

/**
 * Clase Personaje que representa un personaje con nombre, descripción,
 * una imagen asociada y una lista de habilidades.
 */
public class Personaje {

    /**
     * Nombre del personaje.
     */
    private String nombre;

    /**
     * Descripción del personaje.
     */
    private String descripcion;

    /**
     * ID del recurso de la imagen asociada al personaje.
     */
    private int imagenResId;

    /**
     * Lista de habilidades del personaje.
     */
    private List<String> habilidades;

    /**
     * Constructor que inicializa los atributos del personaje.
     *
     * @param nombre Nombre del personaje.
     * @param descripcion Descripción del personaje.
     * @param imagenResId ID del recurso de la imagen asociada al personaje.
     * @param habilidades Lista de habilidades del personaje.
     */
    public Personaje(String nombre, String descripcion, int imagenResId, List<String> habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
        this.habilidades = habilidades;
    }

    /**
     * Obtiene el nombre del personaje.
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del personaje.
     * @return La descripción del personaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el ID del recurso de la imagen asociada al personaje.
     * @return El ID del recurso de la imagen.
     */
    public int getImagenResId() {
        return imagenResId;
    }

    /**
     * Obtiene la lista de habilidades del personaje.
     * @return La lista de habilidades del personaje.
     */
    public List<String> getHabilidades() {
        return habilidades;
    }

    /**
     * Formatea la lista de habilidades en una cadena de texto separada por comas.
     * @param habilidades Lista de habilidades a formatear.
     * @return Cadena de texto con las habilidades separadas por comas.
     */
    public static String formatHabilidades(List<String> habilidades) {
        return String.join(", ", habilidades) + ".";
    }

    /**
     * Establece un nuevo nombre para el personaje.
     * @param nombre El nuevo nombre del personaje.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece una nueva descripción para el personaje.
     * @param descripcion La nueva descripción del personaje.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece un nuevo ID de recurso para la imagen del personaje.
     * @param imagenResId El nuevo ID del recurso de la imagen.
     */
    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }

    /**
     * Establece una nueva lista de habilidades para el personaje.
     * @param habilidades La nueva lista de habilidades del personaje.
     */
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
