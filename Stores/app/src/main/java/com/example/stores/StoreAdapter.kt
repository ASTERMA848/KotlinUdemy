package com.example.stores


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stores.databinding.ItemStoreBinding

class StoreAdapter(private val stores: MutableList<Store>,
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
        
        fun setListener(store: Store) { //Este método recibe un objeto Store como parámetro y lo utiliza para configurar un oyente en la vista
            binding.root.setOnClickListener { listener.onClick(store) }
        }
    }
    
    
}