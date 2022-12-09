package es.jms.listausuariosroom.repository

import android.content.Context
import es.jms.listausuariosroom.dao.UsuarioDao
import es.jms.listausuariosroom.data_base.UsuarioDataBase
import es.jms.listausuariosroom.models.Usuario

/**
 * Created by Neil on 02,diciembre,2022
 * I.E.S Jandula company,
 * Andújar, Jaen.
 */
class UsuarioRepository (context: Context){

    var dataBase: UsuarioDataBase = UsuarioDataBase.getInstance(context)!!
    var usuarioDao: UsuarioDao = dataBase.usuarioDao()

    fun getAllUsuarios(): List<Usuario> {
        return usuarioDao.getAllUsuario()
    }

    fun insertUsuario(usuario: Usuario) {
        usuarioDao.insertarUsuario(usuario)
    }

    fun updateUsuario(usuario: Usuario) {
        usuarioDao.updateUser(usuario)
    }

    fun deleteUsuario(usuario: Usuario){
        usuarioDao.deleteUsuario(usuario)
    }

}