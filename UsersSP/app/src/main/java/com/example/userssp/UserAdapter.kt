package com.example.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.userssp.databinding.ItemUserAltBinding
import com.example.userssp.databinding.ItemUserBinding

//las clases llamadas adapter van a ser el intermediario para ir a la vista (tipo controlador)
class UserAdapter(private val users: MutableList<User>,
                  private val listener: OnClickListener) : //clase que recibe una list de usuarios y la interface con un evento
     RecyclerView.Adapter<UserAdapter.ViewHolder>() {


     private lateinit var context: Context //el "lateinir" indica que esa variable a a ser inicializada despues
     override fun onCreateViewHolder(parent: ViewGroup,
                                     viewType: Int): ViewHolder { // este metodo dice que se va a inflar al vista en el listado
          context = parent.context
          val view = LayoutInflater.from(context).inflate(R.layout.item_user_alt, parent, false)
          return ViewHolder(view)
     }


     override fun onBindViewHolder(holder: ViewHolder,
                                   position: Int) { //este metodo muestra el listado
          val user = users.get(position)
          with(holder) {
               setListener(user) //llama al metodo de mas abajo, encargado de invocar al evento de la Interface
               binding.tvOrder.text =
                    (position + 1).toString() //aca en vez de cargar el id, se carga la posicion del objeto en la lista
               binding.tvName.text = user.getFullName()
               Glide.with(context).load(user.url).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop().circleCrop() //propiedad para que la imagen sea circular
                    .into(binding.imgPhoto) //cargar la imagen

          }
     }

     override fun getItemCount(): Int =
          users.size //este metodo indica cuantos elementos hay en el adapter


     /*
     ----------------------------------------------------------------
     METODO PARA BORRAR OBJETOS DE LA LISTA QUE VA A SER LLAMADO DESDE EL  MAIN
     ----------------------------------------------------------------
      */
     fun remove(position: Int) {
          users.removeAt(position)
          notifyItemRemoved(position)  //aca le aviso a la interfaz que se actualice solo en la parte modificada
     }

     inner class ViewHolder(view: View) :  //inner marca que se crea una clase interna adentro de otra clase
          RecyclerView.ViewHolder(view) { //El RecyclerView es una clase que Se utiliza para mostrar y administrar listas de elementos en una interfaz de usuario de una manera eficiente y flexible.
          val binding = ItemUserAltBinding.bind(view) //Le paso una vista "view" de la clase "View"

          fun setListener(user: User) { //va a crear una funcion por cada iteracion de lista (por cada usuario) ||esa funcion llama al evento de la interfaz || SE LO LLAMA ADAPTADOR
               binding.root.setOnClickListener { listener.onClick(user) }
          }
     }
}