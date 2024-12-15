package com.example.jimenez_diaz_alejandro_pmdm02;
import android.content.Context;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Clase PersonajesData que proporciona una lista estática de personajes
 * utilizando datos de recursos para facilitar la internacionalización.
 */
public class PersonajesData {

    /**
     * Obtiene una lista de objetos Personaje utilizando los recursos de la aplicación.
     *
     * @param context El contexto necesario para acceder a los recursos.
     * @return Una lista de objetos Personaje con sus respectivos datos.
     */
    public static List<Personaje> getPersonajes(Context context) {
        // Lista donde se almacenarán los personajes
        List<Personaje> personajes = new ArrayList<>();

        // Agregar un personaje: Mario
        personajes.add(new Personaje(
                context.getString(R.string.nombre_mario), // Nombre desde recursos
                context.getString(R.string.descripcion_mario), // Descripción desde recursos
                R.drawable.mario, // Imagen como recurso drawable
                Arrays.asList(
                        context.getString(R.string.habilidades_mario) // Lista de habilidades
                )
        ));

        // Agregar un personaje: Luigi
        personajes.add(new Personaje(
                context.getString(R.string.nombre_luigi),
                context.getString(R.string.descripcion_luigi),
                R.drawable.luigi,
                Arrays.asList(
                        context.getString(R.string.habilidades_luigi)
                )
        ));

        // Agregar un personaje: Peach
        personajes.add(new Personaje(
                context.getString(R.string.nombre_peach),
                context.getString(R.string.descripcion_peach),
                R.drawable.peach,
                Arrays.asList(
                        context.getString(R.string.habilidades_peach)
                )
        ));

        // Agregar un personaje: Bowser
        personajes.add(new Personaje(
                context.getString(R.string.nombre_bowser),
                context.getString(R.string.descripcion_bowser),
                R.drawable.bowser,
                Arrays.asList(
                        context.getString(R.string.habilidades_bowser)
                )
        ));

        // Agregar un personaje: Yoshi
        personajes.add(new Personaje(
                context.getString(R.string.nombre_yoshi),
                context.getString(R.string.descripcion_yoshi),
                R.drawable.yoshi,
                Arrays.asList(
                        context.getString(R.string.habilidades_yoshi)
                )
        ));

        // Agregar un personaje: Toad
        personajes.add(new Personaje(
                context.getString(R.string.nombre_toad),
                context.getString(R.string.descripcion_toad),
                R.drawable.toad,
                Arrays.asList(
                        context.getString(R.string.habilidades_toad)
                )
        ));

        // Agregar un personaje: Wario
        personajes.add(new Personaje(
                context.getString(R.string.nombre_wario),
                context.getString(R.string.descripcion_wario),
                R.drawable.wario,
                Arrays.asList(
                        context.getString(R.string.habilidades_wario)
                )
        ));

        // Agregar un personaje: Waluigi
        personajes.add(new Personaje(
                context.getString(R.string.nombre_waluigi),
                context.getString(R.string.descripcion_waluigi),
                R.drawable.waluigi,
                Arrays.asList(
                        context.getString(R.string.habilidades_waluigi)
                )
        ));

        // Agregar un personaje: Boo
        personajes.add(new Personaje(
                context.getString(R.string.nombre_boo),
                context.getString(R.string.descripcion_boo),
                R.drawable.boo,
                Arrays.asList(
                        context.getString(R.string.habilidades_boo)
                )
        ));

        // Retornar la lista completa de personajes
        return personajes;
    }
}


