package ni.edu.uca.peliculas20.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uca.peliculas20.dao.ClasificacionDao
import ni.edu.uca.peliculas20.entities.ClasificacionEntity

interface MainDataBaseProvider{
    fun clasificacionDao() : ClasificacionDao
}
@Database(entities = [ClasificacionEntity::class], version =1 )
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider {
    abstract override fun clasificacionDao(): ClasificacionDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getInstace(context: Context): MainDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "clasificacion_main_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}