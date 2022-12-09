package es.jms.listausuariosroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    companion object{
        lateinit var usuarioRepository: UsuarioRepository;
    }
    lateinit var reciclerView: RecyclerView;
    lateinit var usuarios : List<Usuario>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuarioRepository = UsuarioRepository(this)

        reciclerView = findViewById(R.id.rvUsuario)
        reciclerView.setHasFixedSize(true)
        reciclerView.layoutManager = LinearLayoutManager(this)
        actualizarVistaListado()

        var etDataUser: EditText = findViewById(R.id.etUsuario)
        var btnAddUsuario: Button = findViewById(R.id.btnAddUsuario)

        btnAddUsuario.setOnClickListener {

            // Insertamos el usuario que tenemos en el formulario
            usuarioRepository.insertUsuario(Usuario(null, etDataUser.text.toString()))
            actualizarVistaListado()
            // Vaciamos el editText para dejarlo disponible
            etDataUser.setText("")

        }
    }


    fun actualizarVistaListado() {
        var listaUsuarios = usuarioRepository.getAllUsuarios()
        var adapter = UsuarioListAdapter(this, listaUsuarios)

        adapter.onBorrarClick = { // Así es como se pasan esos parametros a la clase UsuarioListAdapter
                usuario -> onDeleteClick(usuario)
        }

        adapter.onEditarClick = { // Así es como se pasan esos parametros a la clase UsuarioListAdapter
                usuario -> onEditClick(usuario)
        }



        reciclerView.adapter = adapter // Y le volvemos a setear la clase al reciclerView
    }


    fun onDeleteClick(usuario: Usuario) {
        usuarioRepository.deleteUsuario(usuario)
        actualizarVistaListado()
    }

    fun onEditClick(usuario: Usuario) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Editar usuario")
        val view = LayoutInflater.from(this).inflate(R.layout.edit_usuario_dialog, null)
        val usuarioEditText = view.findViewById<EditText>(R.id.etUsuario)
        usuarioEditText.setText(usuario.nombre)
        builder.setView(view)
        builder.setPositiveButton(android.R.string.ok) { dialog, p1 ->
            var estaRelleno = true
            if (usuarioEditText.text.isBlank()) {
                estaRelleno = false
            }
            if (estaRelleno) {
                val nuevoNombre = usuarioEditText.text.toString()
                usuarioRepository.updateUsuario(Usuario(usuario.idUsuario,nuevoNombre))
                actualizarVistaListado()
            }
            if (!estaRelleno) {
                Toast.makeText(this, "Debes escribir algo", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton(android.R.string.cancel) { dialog, p1 ->
            dialog.cancel()
        }
        builder.show()
    }

    override fun onResume() {
        actualizarVistaListado()
        super.onResume()
    }

}