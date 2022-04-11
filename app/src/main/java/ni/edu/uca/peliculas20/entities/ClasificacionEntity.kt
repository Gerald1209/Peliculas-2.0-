package ni.edu.uca.peliculas20.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="TblCalasificacion")
data class ClasificacionEntity(
    @PrimaryKey(autoGenerate = true)
    val idClasificacion:Int = 0,
    @ColumnInfo(name = "abreviacion")
    val abreviacion: String,
    @ColumnInfo(name = "activo")
    val activo: Boolean,
    @ColumnInfo(name = "nombre")
    val nombre: String

    )
