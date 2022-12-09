package es.jms.listausuariosroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import es.jms.listausuariosroom.models.Usuario

/**
 * Created by Neil on 02,diciembre,2022
 * I.E.S Jandula company,
 * Andújar, Jaen.
 */

@Dao
interface UsuarioDao {

    @Insert
    fun insertarUsuario(usuario: Usuario)

    @Query("Select * from usuario")
    fun getAllUsuario(): List<Usuario>

    @Query("Select * from usuario where idUsuario= :id")
    fun getUsuario(id : Int): Usuario

    @Update
    fun updateUser(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)


}