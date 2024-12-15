package com.example.jimenez_diaz_alejandro_pmdm02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

/**
 * Clase PersonajesAdapter que gestiona la visualización de una lista de objetos
 * Personaje en un RecyclerView.
 */
public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder> {

    /**
     * Lista de personajes a mostrar en el RecyclerView.
     */
    private final List<Personaje> personajes;

    /**
     * Listener para manejar los clics en los elementos de la lista.
     */
    private final OnItemClickListener listener;

    /**
     * Interfaz para definir el comportamiento al hacer clic en un elemento.
     */
    public interface OnItemClickListener {
        /**
         * Metodo que se llama cuando un personaje es seleccionado.
         *
         * @param personaje El personaje que fue clicado.
         */
        void onItemClick(Personaje personaje);
    }

    /**
     * Constructor de la clase PersonajesAdapter.
     *
     * @param personajes Lista de personajes a mostrar.
     * @param listener   Objeto que implementa la interfaz OnItemClickListener.
     */
    public PersonajesAdapter(List<Personaje> personajes, OnItemClickListener listener) {
        this.personajes = personajes;
        this.listener = listener;
    }

    /**
     * Crea nuevos ViewHolder para representar los elementos de la lista.
     *
     * @param parent   El ViewGroup padre al que se agregará la nueva vista.
     * @param viewType El tipo de vista del nuevo elemento.
     * @return Una nueva instancia de PersonajeViewHolder.
     */
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    /**
     * Vincula un elemento de la lista de personajes a un ViewHolder.
     *
     * @param holder   El ViewHolder en el que se mostrará la información.
     * @param position La posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.bind(personaje, listener);
    }

    /**
     * Devuelve la cantidad de elementos en la lista.
     *
     * @return El número total de elementos en la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    /**
     * Clase interna PersonajeViewHolder que gestiona las vistas individuales de cada elemento.
     */
    static class PersonajeViewHolder extends RecyclerView.ViewHolder {

        /**
         * ImageView para mostrar la imagen del personaje.
         */
        private final ImageView imgPersonaje;

        /**
         * TextView para mostrar el nombre del personaje.
         */
        private final TextView txtNombre;

        /**
         * Constructor de la clase PersonajeViewHolder.
         *
         * @param itemView La vista del elemento que se va a gestionar.
         */
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPersonaje = itemView.findViewById(R.id.imgPersonaje);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            //txtDescripcion = itemView.findViewById(R.id.txtDescripcion); // Comentado para futura implementación
        }

        /**
         * Vincula los datos de un personaje a las vistas del ViewHolder.
         *
         * @param personaje El personaje cuyos datos se van a mostrar.
         * @param listener  Listener para manejar el clic en el elemento.
         */
        public void bind(final Personaje personaje, final OnItemClickListener listener) {
            imgPersonaje.setImageResource(personaje.getImagenResId());
            txtNombre.setText(personaje.getNombre());
            //txtDescripcion.setText(personaje.getDescripcion()); // Comentado para futura implementación

            itemView.setOnClickListener(v -> listener.onItemClick(personaje));
        }
    }
}