package es.nhs.listausuariosroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Dependencias + Plugins (ROOM)

// Crear Entidades (Models Data con anotaciones)

// Crear DAOS (Objeto de Acceso a Datos) son Interface

// Crear la Arquitectura de la base de datos (La base de datos en si) con UsuarioDataBase

// Crear una clase Repository, Exclusivo de un tipo de datos, es decir, Cada Entidad/Clase
// necesita la suya, Crea

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}