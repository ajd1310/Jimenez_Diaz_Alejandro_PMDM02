package com.example.jimenez_diaz_alejandro_pmdm02;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



/**
 * Clase PersonajeDetailFragment que representa un fragmento para mostrar
 * los detalles de un personaje, incluyendo su nombre, descripción,
 * imagen y habilidades.
 */
public class PersonajeDetailFragment extends Fragment {

    /**
     * TextView para mostrar el nombre del personaje.
     */
    private TextView nombreTextView;

    /**
     * TextView para mostrar la descripción del personaje.
     */
    private TextView descripcionTextView;

    /**
     * ImageView para mostrar la imagen del personaje.
     */
    private ImageView imagenImageView;

    /**
     * TextView para mostrar las habilidades del personaje.
     */
    private TextView habilidadesTextView;

    /**
     * Crea y devuelve la vista asociada a este fragmento.
     *
     * @param inflater Objeto LayoutInflater utilizado para inflar la vista del fragmento.
     * @param container Contenedor al que se debe agregar la vista del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento, si existe.
     * @return La vista inflada para este fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_personaje_detail, container, false);

        // Inicializar las vistas
        nombreTextView = view.findViewById(R.id.nombreTextView);
        descripcionTextView = view.findViewById(R.id.descripcionTextView);
        imagenImageView = view.findViewById(R.id.imagenImageView);
        habilidadesTextView = view.findViewById(R.id.habilidadesTextView);

        // Obtener datos de los argumentos pasados al fragmento
        if (getArguments() != null) {
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            int imagenResId = getArguments().getInt("imagenResId");
            String habilidades = getArguments().getString("habilidades");

            // Configurar los datos en las vistas
            nombreTextView.setText(nombre);
            descripcionTextView.setText(descripcion);
            imagenImageView.setImageResource(imagenResId);
            habilidadesTextView.setText(habilidades);
        }

        return view;
    }
}