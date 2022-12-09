package es.jms.listausuariosroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import es.jms.listausuariosroom.models.Usuario

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val idUsuario:String = intent.getStringExtra("USUARIO_ID").toString()
        var usuarioAEditar = MainActivity.usuarioRepository.getUsuario(idUsuario.toInt())

        var usuarioEditText: EditText = findViewById(R.id.etUsuario)
        usuarioEditText.setText(usuarioAEditar.nombre)

        var botonGuardar : Button = findViewById(R.id.btnGuardar)
        botonGuardar.setOnClickListener {
            var estaRelleno = true
            if (usuarioEditText.text.isBlank()) {
                estaRelleno = false
            }
            if (estaRelleno) {
                val nuevoNombre = usuarioEditText.text.toString()
                MainActivity.usuarioRepository.updateUsuario(Usuario(usuarioAEditar.idUsuario,nuevoNombre))

            }
            if (!estaRelleno) {
                Toast.makeText(this, "Debes escribir algo", Toast.LENGTH_SHORT).show()
            }
            onBackPressed()
        }
    }
}