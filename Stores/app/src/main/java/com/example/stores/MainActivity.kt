package com.example.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

     /*
     ----------------------------------------------------------------
     VARIABLES GLOBALES
     ----------------------------------------------------------------
      */

     private lateinit var mBinding: ActivityMainBinding
     private lateinit var mAdapter: StoreAdapter
     private lateinit var mGridLayout: GridLayoutManager

     /*
     ----------------------------------------------------------------
     Inflo la vista
     ----------------------------------------------------------------
      */
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          mBinding =
               ActivityMainBinding.inflate(layoutInflater) //inflamos el binding de la actividad. El binding es un objeto que nos permite acceder a los elementos de la interfaz de usuario de la actividad.
          setContentView(mBinding.root)

          mBinding.btnSave.setOnClickListener { //se hace referencia al boton btnSave de la ActivityMainBinding || con setOnClickListener se le asigna un pyente al boton
               val store = Store(
                    name = mBinding.edName.text.toString()
                         .trim() // aca se crea el objeto guardando el nombre que se escribe en edName del ActivityMainBinding ||el motodo trim ayuda a quitar espacios en blancos antes o despues del string
               )
               mAdapter.add(store) //esta linea agrega la tienda
          }

          setupRecyclerView()
     }


     /*
     -----------------------------------------------------------------------------------------------
     FUNCION PARA CONFIGURAR EL RecyclerView()
     -----------------------------------------------------------------------------------------------
      */
     private fun setupRecyclerView() {
          mAdapter = StoreAdapter(
               mutableListOf(), this
          ) //al poner this se pasa la "actividad" que es la que se implementa desde la interface OnClickListener
          mGridLayout = GridLayoutManager(
               this, 2
          ) // con this se le pasa el "contexto" seria la actividad desde la interface OnClickListener y en spanCount la cantidad de interface OnClickListener

          mBinding.recyclerView.apply {
               setHasFixedSize(true) //al tener una altura fija en item_store con "item_card_height", esta linea le dice que no puede cambiar su tamaño y asi optimizar recursos
               layoutManager = mGridLayout
               adapter = mAdapter //configuracion del adaptador
          }
     }


     /*
   -----------------------------------------------------------------------------------------------
   FUNCION QUE SE IMPLEMENTA AL TRAER LA interface OnClickListener
   -----------------------------------------------------------------------------------------------
    */
     override fun onClick(store: Store) {
          TODO("Not yet implemented")
     }
}








