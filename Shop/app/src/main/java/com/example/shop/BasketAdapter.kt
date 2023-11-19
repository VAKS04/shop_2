package com.example.shop
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BasketAdapter(var items:List<Item>,var context: Context)
    :RecyclerView.Adapter<BasketAdapter.MyViewHolder>(){
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.image_in_list)
        val title:TextView = view.findViewById(R.id.title_in_list)
        val price:TextView = view.findViewById(R.id.price_in_list)
//        val pluss:TextView = view.findViewById(R.id.plus)
//        val minuss:TextView = view.findViewById(R.id.minus)
//        val number_of_product:TextView = view.findViewById(R.id.number_of_products)
//        val layout:LinearLayout = view.findViewById(R.id.layout_in_list)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_in_basket, parent,false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.price.text = items[position].price
//        holder.number_of_product = items[position]

        val imageID = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setOnClickListener{
            DataModel.itemList.value = Item(
                items[position].title,
                imageID.toString(),
                items[position].desc,
                items[position].full_desc,
                items[position].price)
            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.for_main, ItemFragment()) // Замените YourFragment на ваш фрагмент
            fragmentTransaction.addToBackStack(null) // Добавьте транзакцию в стек возврата
            fragmentTransaction.commit()
        }
        holder.image.setImageResource(imageID)

//        holder.pluss.setOnClickListener {
//            DataModel.numberInt.value =
//        }
    }
}