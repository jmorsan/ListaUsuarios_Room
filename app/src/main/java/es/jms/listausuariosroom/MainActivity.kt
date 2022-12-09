package es.jms.listausuariosroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.jms.listausuariosroom.Adapter.UsuarioListAdapter
import es.jms.listausuariosroom.models.Usuario
import es.jms.listausuariosroom.repository.UsuarioRepository

// Dependencias + Plugins (ROOM)

// Crear Entidades (Models Data con anotaciones)

// Crear DAOS (Objeto de Acceso a Datos) son Interface

// Crear la Arquitectura de la base de datos (La base de datos en si) con UsuarioDataBase

// Crear una clase Repository, Exclusivo de un tipo de datos, es decir, Cada Entidad/Clase
// necesita la suya, Crea

class MainActivity : AppCompatActivity() {
    lateinit var usuarioRepository: UsuarioRepository
    lateinit var recyclerView: RecyclerView
    lateinit var usuarios : List<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuarioRepository = UsuarioRepository(this)
        usuarios = usuarioRepository.getAllUsuarios()

        recyclerView = findViewById(R.id.rvUsuario)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UsuarioListAdapter(this,usuarios)

        var nombreUsuarioNuevo: EditText = findViewById(R.id.etUsuario)
        var btAddUsuario: Button = findViewById(R.id.btnAddUsuario)
        btAddUsuario.setOnClickListener{

            usuarioRepository.insertUsuario(Usuario(null,nombreUsuarioNuevo.text.toString()))
            usuarios = usuarioRepository.getAllUsuarios()
            recyclerView.adapter = UsuarioListAdapter(this,usuarios)
            nombreUsuarioNuevo.setText("")

        }

    }
}