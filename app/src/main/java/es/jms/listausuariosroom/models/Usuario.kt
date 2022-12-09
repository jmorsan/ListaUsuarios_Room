package es.jms.listausuariosroom.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Neil on 02,diciembre,2022
 * I.E.S Jandula company,
 * Andújar, Jaen.
 */
// Estas Entidades nos las facilita ROOM
@Entity(tableName = "usuario") // el nombre de la tabla de la base de datos

data class Usuario ( // (data) Clase que es de tipo datos, no tiene logica

    @PrimaryKey(autoGenerate = true) // Clave Primaria
    var idUsuario: Int? = null,

    @ColumnInfo(name="nombre") // Nombre de la columna
    val nombre: String

    )
