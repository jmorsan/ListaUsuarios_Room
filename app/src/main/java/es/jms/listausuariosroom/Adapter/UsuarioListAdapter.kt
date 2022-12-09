package es.jms.listausuariosroom.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.jms.listausuariosroom.R
import es.jms.listausuariosroom.models.Usuario


class UsuarioListAdapter (val contexto: Context, val listaUsuarios: List<Usuario> ): RecyclerView.Adapter<UsuarioListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val usuario = listaUsuarios[position]
        holder.tvUsuario.text = usuario.nombre

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvUsuario = view.findViewById<TextView>(R.id.tvUsuario)

    }
}
