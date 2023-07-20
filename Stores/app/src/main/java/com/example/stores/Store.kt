package com.example.stores

/*
----------------------------------------------------------------
CLASE CON PARAMETROS EN EL CONSTRUCTOR PARA LA CREACION DE OBJETOS
----------------------------------------------------------------
 */
data class Store(var id: Long = 0,
                 var name: String,
                 var phone: String = "",
                 var website: String = "",
                 var isFavorite: Boolean = false)

