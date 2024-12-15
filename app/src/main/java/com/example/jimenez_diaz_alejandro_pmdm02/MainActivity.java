package com.example.jimenez_diaz_alejandro_pmdm02;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Locale;

/**
 * MainActivity es la actividad principal de la aplicación que gestiona la interfaz de usuario
 * principal, incluyendo un DrawerLayout, un NavigationView y un Toolbar.
 * También permite cambiar el idioma de la aplicación y gestionar la navegación entre fragments.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * El layout principal que contiene el menú lateral (Drawer).
     */
    private DrawerLayout drawerLayout;

    /**
     * Método que se ejecuta al crear la actividad.
     * @param savedInstanceState Estado de la instancia guardada, utilizado para restaurar el estado anterior.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadLocale(); // Carga el idioma configurado previamente.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Establece el título de la Toolbar
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Super Mario");

        // Configura el DrawerLayout y el NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Configura el ActionBarDrawerToggle para el DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Maneja las opciones seleccionadas del menú lateral
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    Toast.makeText(MainActivity.this, "Home seleccionado", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, new PersonajesListFragment())
                            .commit();
                } else if (item.getItemId() == R.id.nav_settings) {
                    Toast.makeText(MainActivity.this, "Ajustes seleccionados", Toast.LENGTH_SHORT).show();
                    // Abrir ajustes aquí
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Carga el fragmento inicial si no hay un estado guardado
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new PersonajesListFragment())
                    .commit();
        }

        // Configura el Switch para cambiar de idioma
        MenuItem switchItem = navigationView.getMenu().findItem(R.id.switch_language);
        View actionView = switchItem.getActionView();

        if (actionView != null) {
            SwitchCompat switchLanguage = actionView.findViewById(R.id.switch_language);

            if (switchLanguage != null) {
                switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (isChecked) {
                        setLocale("en"); // Cambiar a inglés
                        Toast.makeText(MainActivity.this, "Idioma cambiado a inglés", Toast.LENGTH_SHORT).show();
                    } else {
                        setLocale("es"); // Cambiar a español
                        Toast.makeText(MainActivity.this, "Idioma cambiado a español", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Log.e("MainActivity", "SwitchCompat no encontrado dentro de actionView");
            }
        } else {
            Log.e("MainActivity", "actionView es nulo para switch_language");
        }
    }

    /**
     * Método para inflar el menú de opciones.
     * @param menu Menú que se infla.
     * @return true si el menú se ha inflado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Maneja las opciones seleccionadas del menú de la Toolbar.
     * @param item Elemento del menú seleccionado.
     * @return true si la acción se ha gestionado correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            mostrarDialogoAcercaDe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un diálogo con información sobre la aplicación.
     */
    private void mostrarDialogoAcercaDe() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de...")
                .setIcon(R.drawable.mario)
                .setMessage("Aplicación desarrollada por\nAlejandro Jiménez Díaz.\nVersión 1.0.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Cambia el idioma de la aplicación y reinicia la actividad para aplicar los cambios.
     * @param languageCode Código del idioma a establecer (por ejemplo, "en" para inglés).
     */
    private void setLocale(String languageCode) {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String currentLanguage = prefs.getString("My_Lang", "");

        if (languageCode.equals(currentLanguage)) {
            return; // Evitar cambiar si el idioma ya está configurado
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("My_Lang", languageCode);
        editor.apply();

        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * Carga el idioma configurado previamente desde SharedPreferences.
     */
    private void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "es"); // Español por defecto
        setLocale(language);
    }
}
