package es.jms.listausuariosroom.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.jms.listausuariosroom.dao.UsuarioDao
import es.jms.listausuariosroom.models.Usuario

/**
 * Created by Neil on 02,diciembre,2022
 * I.E.S Jandula company,
 * Andújar, Jaen.
 */

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDataBase: RoomDatabase() {

    abstract fun usuarioDao():UsuarioDao

    companion object {
        private var INSTANCE: UsuarioDataBase? = null

        fun getInstance(context: Context): UsuarioDataBase? {
            if (INSTANCE == null) {
                synchronized(UsuarioDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        UsuarioDataBase::class.java, "usuario.db").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }


    }

}