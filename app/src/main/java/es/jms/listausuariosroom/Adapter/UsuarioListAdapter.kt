package es.jms.listausuariosroom.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.jms.listausuariosroom.EditActivity
import es.jms.listausuariosroom.R
import es.jms.listausuariosroom.models.Usuario


class UsuarioListAdapter (val contexto: Context, val listaUsuarios: List<Usuario> ): RecyclerView.Adapter<UsuarioListAdapter.MyViewHolder>() {
    var onEditarClick: ((Usuario)->Unit)?=null // Le pasamos a esta clase 2 propiedades que son funciones que necesitamos, vamos al main a ver como se pasan
    var onBorrarClick: ((Usuario)->Unit)?=null

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvUsuario = view.findViewById<TextView>(R.id.tvUsuario)
        val btnEditar: Button = view.findViewById(R.id.btnEditar)
        val btnBorrar: Button = view.findViewById(R.id.btnDelete)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val usuario = listaUsuarios[position]

        holder.tvUsuario.text = usuario.nombre

        holder.btnBorrar.setOnClickListener {
            onBorrarClick?.invoke(usuario)
        }

        holder.btnEditar.setOnClickListener {
            onEditarClick?.invoke(usuario)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(contexto, EditActivity::class.java).putExtra("USUARIO_ID", usuario.idUsuario.toString())
            contexto.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

}