package com.example.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores.databinding.ActivityMainBinding
import java.util.concurrent.LinkedBlockingQueue

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
               val store = StoreEntity(
                    name = mBinding.edName.text.toString().trim()
               ) // aca se crea el objeto guardando el nombre que se escribe en edName del ActivityMainBinding ||el motodo trim ayuda a quitar espacios en blancos antes o despues del string

               Thread { // Thread es un hilo que sirve para ejecutar operaciones en segundo plano
                    StoreApplication.database.storeDao().addStores(store) //agregar las tiendas a la base de datos
               }.start()

               mAdapter.add(store) //esta linea agrega la tienda
          }

          mBinding.fab.setOnClickListener { launchEditFragment() } //inflo la vista de fragment_edit_store

          setupRecyclerView()
     }

     private fun launchEditFragment() {
          val fragment = EditStoreFragment() //Instancia de la clase EditStoreFragment()
          val fragmentManager =
               supportFragmentManager //supportFragmentManager es un gestor de android para controlar elementos del fragment
          val fragmentTransaction = fragmentManager // decide como ejecutar el fragmentManager

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

          getStores()

          mBinding.recyclerView.apply {
               setHasFixedSize(true) //al tener una altura fija en item_store con "item_card_height", esta linea le dice que no puede cambiar su tamaño y asi optimizar recursos
               layoutManager = mGridLayout
               adapter = mAdapter //configuracion del adaptador
          }
     }


     private fun getStores() {
          val queue =
               LinkedBlockingQueue<MutableList<StoreEntity>>() // se configura una variable que es una "cola" de tipo  MutableList<StoreEntity
          Thread { //se abre un hilo que sirve para hacer operaciones ne segundo plano
               val stores = StoreApplication.database.storeDao()
                    .getAllStores() // llama al metodo que ejecuta la consulta de traer todas las tiendas
               queue.add(stores) // agrego a la cola la consulta
          }.start()

          mAdapter.setStores(queue.take()) // con .take() se espera que queue tenga un resultado para poder ejecutar la funcion setStores
     }

     /*
   -----------------------------------------------------------------------------------------------
   FUNCION QUE SE IMPLEMENTA AL TRAER LA interface OnClickListener
   -----------------------------------------------------------------------------------------------
    */
     override fun onClick(storeEntity: StoreEntity) {
     }

     override fun onFavoriteStore(storeEntity: StoreEntity) { // este metodo se implementa cuando se apriete el boton del corazon en cada tienda

          storeEntity.isFavorite =
               !storeEntity.isFavorite // cambio el valor boolenano de la vaiable tomando comor referencia el valor actual
          val queue = LinkedBlockingQueue<StoreEntity>() // se configura una variable que es una "cola" de tipo  MutableList<StoreEntity
          Thread { //manejo en segundo plano
               StoreApplication.database.storeDao().updateStores(storeEntity)
               queue.add(storeEntity)
          }.start()
          mAdapter.update(queue.take()) // con .take() se espera que queue tenga un resultado para poder ejecutar la funcion update

     }

     /*
     ----------------------------------------------------------------
     METODO PARA ELIMINAR UN REGISTRO DE LA BD
     ----------------------------------------------------------------
      */
     override fun onDeleteStore(storeEntity: StoreEntity) {
          val queue = LinkedBlockingQueue<StoreEntity>() // se configura una variable que es una "cola" de tipo  MutableList<StoreEntity
          Thread {
               StoreApplication.database.storeDao().deleteStores(storeEntity)
               queue.add(storeEntity)
          }.start()
          mAdapter.delete(queue.take())
     }
}








