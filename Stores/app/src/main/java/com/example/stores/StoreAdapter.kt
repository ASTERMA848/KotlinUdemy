package com.example.stores


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter(private var stores: MutableList<StoreEntity>,
                   private val listener: OnClickListener) //La clase OnClickListener se utiliza para escuchar los eventos de clic en una vista. Se puede usar para agregar una acción cuando el usuario hace clic en una vista, como abrir una nueva actividad, mostrar un mensaje o cambiar el estado de la vista.
     : RecyclerView.Adapter<StoreAdapter.viewHolder>() {

     private lateinit var mContext: Context //La clase Context proporciona una variedad de métodos para acceder a recursos, servicios y otras partes del sistema Android

     /*
     ----------------------------------------------------------------
     Estos 3 metodos son heredados de la clase RecyclerView.Adapter. es una clase base para los adaptadores que se utilizan para mostrar datos en un RecyclerView.
     ----------------------------------------------------------------
      */
     override fun getItemCount(): Int {
          return stores.size
     }

     override fun onCreateViewHolder(parent: ViewGroup,
                                     viewType: Int): viewHolder { //El método onCreateViewHolder() crea un nuevo objeto ViewHolder para cada elemento en el adaptador
          mContext = parent.context
          val view = LayoutInflater.from(mContext)
               .inflate(R.layout.item_store, parent, false) //infla la vista
          return viewHolder(view)
     }

     override fun onBindViewHolder(holder: viewHolder,
                                   position: Int) { //El método onBindViewHolder() vincula los datos de un elemento del adaptador a su correspondiente ViewHolder
          val store = stores.get(position)
          with(holder) {
               setListener(store)
               binding.tvName.text = store.name
               binding.cbFavorite.isChecked =
                    store.isFavorite // le digo al boton que se actualice con su correspondiente valor
          }

     }

     /*
     ----------------------------------------------------------------
     METODO PARA AGREGAR LA TIENDA QUE VIENE DESDE EL edName del ActivityMainBinding
     ----------------------------------------------------------------
      */
     @SuppressLint("NotifyDataSetChanged") //la anotación @SuppressLint("NotifyDataSetChanged") se utiliza para indicar que el programador está consciente de que está usando la función
     fun add(storeEntity: StoreEntity) {
          stores.add(storeEntity)
          notifyDataSetChanged() // se refresca la vista del adaptador
     }


     /*
     Esta funcion actualiza el listado de las listad que se ven en pantalla
      */
     @SuppressLint("NotifyDataSetChanged") // la anotación @SuppressLint("NotifyDataSetChanged") se utiliza para indicar que el programador está consciente de que está usando la función
     fun setStores(stores: MutableList<StoreEntity>) {
          this.stores = stores // con this se va a actualizar el listado de listas
          notifyDataSetChanged() // esta linea notifica que se actualice el listado de las listas
     }

     /*
     ----------------------------------------------------------------
     funcion que actualiza el estado de favorito en cada tienda
     ----------------------------------------------------------------
      */
     infix fun update(storeEntity: StoreEntity) {
          val index =
               stores.indexOf(storeEntity) // guardo en una variable el indice del objeto (devuelve -1 en caso de no encontrar nada)
          if (index != -1) { // compruebo el indice
               stores.set(index, storeEntity) // seteo el objeto con su nuevo valor
               notifyItemChanged(index) //en vez de notificar un actualizacion completa, notifico solo en la parte del boton de mg <3
          }

     }

     /*
    -----------------------------------------------------------------------------
    FUNCION PARA ELIMINAR UNA TIENDA
    -----------------------------------------------------------------------------
      */
     infix fun delete(storeEntity: StoreEntity) {
          val index =
               stores.indexOf(storeEntity) // guardo en una variable el indice del objeto (devuelve -1 en caso de no encontrar nada)
          if (index != -1) { // compruebo el indice
               stores.removeAt(index) //borro el objeto
               notifyItemRemoved(index)
          }

     }

     /*
  ----------------------------------------------------------------
  Esta clase se utiliza para mantener una referencia a la vista que se muestra para cada elemento en el RecyclerView
  ----------------------------------------------------------------
  La clase viewHolder tiene una propiedad llamada binding, que es una referencia al objeto ItemStoreBinding que se utiliza para vincular los datos a la vista.
  ----------------------------------------------------------------
   */
     inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
          val binding =
               ItemStoreBinding.bind(view) //ItemStoreBinding que se utiliza para enlazar los datos a la vista.

          fun setListener(storeEntity: StoreEntity) { //Este método recibe un objeto Store como parámetro y lo utiliza para configurar un oyente en la vista

               with(binding.root) {//acceder a la vista raíz (root) que contiene todos los elementos visuales de la interfaz
                    setOnClickListener { listener.onClick(storeEntity) }

                    setOnLongClickListener {//Click largo para borrar el objeto
                         listener.onDeleteStore(storeEntity)
                         true
                    }
               }


               binding.cbFavorite.setOnClickListener { //Implementacion del boton con forma del corazon que esta en la espera de que pase algo en ese boton
                    listener.onFavoriteStore(storeEntity)
               }

          }


     }


}