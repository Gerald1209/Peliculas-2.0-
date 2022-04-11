package ni.edu.uca.peliculas20.dao

import androidx.room.*
import ni.edu.uca.peliculas20.entities.ClasificacionEntity

@Dao
interface ClasificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: ClasificacionEntity)

    @Query("SELECT * FROM TblCalasificacion")
    suspend fun getAll(): List<ClasificacionEntity>

    @Query("SELECT * FROM TblCalasificacion WHERE idClasificacion = :id")
    suspend fun getById(id : Int) : ClasificacionEntity

    @Update
    fun update(usuario: ClasificacionEntity)

    @Delete
    fun delete(usuario: ClasificacionEntity)

}