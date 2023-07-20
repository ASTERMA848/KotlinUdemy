package com.example.stores

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
----------------------------------------------------------------
CLASE CON PARAMETROS EN EL CONSTRUCTOR PARA LA CREACION DE OBJETOS
----------------------------------------------------------------
 */
@Entity(tableName = "StoreEntity") //con esta linea se declara a la clase como una entity para la base de datos
data class StoreEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0, //@PrimaryKey(autoGenerate = true) esta parte asigna la llave primario diciendo que es auto incremental :)
                       var name: String,
                       var phone: String = "",
                       var website: String = "",
                       var isFavorite: Boolean = false)



