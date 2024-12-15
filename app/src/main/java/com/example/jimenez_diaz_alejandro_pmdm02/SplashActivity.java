package com.example.jimenez_diaz_alejandro_pmdm02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase SplashActivity que muestra una pantalla de presentación (splash screen)
 * al iniciar la aplicación, y luego redirige al MainActivity después de un retraso.
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Método llamado al crear la actividad.
     *
     * @param savedInstanceState Estado previo de la actividad, si lo hubiera.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Asignar el diseño asociado a la actividad
        setContentView(R.layout.activity_splash);

        // Crear un temporizador con un retraso de 3 segundos (3000 ms)
        new Handler().postDelayed(() -> {
            // Crear una intención para navegar a MainActivity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent); // Iniciar MainActivity

            // Finalizar SplashActivity para evitar que se pueda volver a esta pantalla
            finish();
        }, 3000); // Tiempo de retraso especificado en milisegundos
    }
}
