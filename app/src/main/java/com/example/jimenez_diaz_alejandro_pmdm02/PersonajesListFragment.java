package com.example.jimenez_diaz_alejandro_pmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * Clase PersonajesListFragment que representa una lista de personajes
 * utilizando un RecyclerView dentro de un fragmento.
 */
public class PersonajesListFragment extends Fragment {

    /**
     * RecyclerView para mostrar la lista de personajes.
     */
    private RecyclerView recyclerView;

    /**
     * Lista de objetos Personaje que se mostrará en el RecyclerView.
     */
    private List<Personaje> personajes;

    /**
     * Constructor vacío requerido para instanciar el fragmento.
     */
    public PersonajesListFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo llamado para inflar la vista del fragmento y configurar su contenido.
     *
     * @param inflater           Objeto LayoutInflater para inflar el diseño del fragmento.
     * @param container          Contenedor donde se añadirá la vista del fragmento.
     * @param savedInstanceState Estado guardado previo, si lo hubiera.
     * @return La vista inflada del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_personajes_list, container, false);

        // Configurar el RecyclerView con un diseño lineal (lista vertical)
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtener la lista de personajes desde la clase PersonajesData
        if (getContext() != null) {
            personajes = PersonajesData.getPersonajes(getContext());
        }

        // Configurar el adaptador del RecyclerView
        PersonajesAdapter adapter = new PersonajesAdapter(personajes, personaje -> {
            // Mostrar un mensaje Toast al seleccionar un personaje
            Toast.makeText(getContext(), "Se ha seleccionado el personaje " + personaje.getNombre(), Toast.LENGTH_SHORT).show();

            // Navegación al fragmento de detalles
            Bundle bundle = new Bundle();
            bundle.putString("nombre", personaje.getNombre()); // Pasar el nombre del personaje
            bundle.putString("descripcion", personaje.getDescripcion()); // Pasar la descripción del personaje
            bundle.putInt("imagenResId", personaje.getImagenResId()); // Pasar el ID de la imagen
            bundle.putString("habilidades", personaje.formatHabilidades(personaje.getHabilidades())); // Pasar las habilidades formateadas

            // Crear el fragmento de detalles y asignarle los argumentos
            PersonajeDetailFragment detailFragment = new PersonajeDetailFragment();
            detailFragment.setArguments(bundle);

            // Reemplazar el fragmento actual por el fragmento de detalles y añadirlo a la pila
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Asignar el adaptador al RecyclerView
        recyclerView.setAdapter(adapter);

        // Mostrar un Snackbar con un mensaje de bienvenida
        Snackbar.make(view, "Bienvenidos al mundo de Mario", Snackbar.LENGTH_LONG).show();

        return view;
    }
}

