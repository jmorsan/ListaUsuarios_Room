package es.nhs.listausuariosroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import es.nhs.listausuariosroom.models.Usuario

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

    @Update
    fun updateUser(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)

}