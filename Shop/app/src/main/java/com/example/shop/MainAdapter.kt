package com.example.shop

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(var items:List<Item>,var context: Context,var context_layout: Int)
    :RecyclerView.Adapter<MainAdapter.MyViewHolder>(){
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.image_in_list)
        val title:TextView = view.findViewById(R.id.title_in_list)
        val desc:TextView = view.findViewById(R.id.desc_in_list)
        val price:TextView = view.findViewById(R.id.price_in_list)
        val layout:LinearLayout = view.findViewById(R.id.layout_in_list)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(context_layout, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price

        val imageID = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.layout.setOnClickListener{
            DataModel.itemList.value = Item(
                items[position].title,
                imageID.toString(),
                items[position].desc,
                items[position].full_desc,
                items[position].price)
            Log.w("TTT","РАБОТАЕТ")

            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.for_main, ItemFragment()) // Замените YourFragment на ваш фрагмент
            fragmentTransaction.addToBackStack(null) // Добавьте транзакцию в стек возврата
            fragmentTransaction.commit()

        }
        holder.image.setImageResource(imageID)
    }
}