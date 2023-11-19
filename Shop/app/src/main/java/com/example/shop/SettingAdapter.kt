package com.example.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SettingAdapter(var items:List<SettingClass>,var context: Context)
    :RecyclerView.Adapter<SettingAdapter.MyViewHolder>(){
        class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
            val icon:ImageView = view.findViewById(R.id.setting_icon)
            val text:TextView = view.findViewById(R.id.setting_title)
            val context_layout:LinearLayout = view.findViewById(R.id.settings_layout)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_in_settings,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = items[position].settingText
        val iconID = context.resources.getIdentifier(
            items[position].icon,
            "drawable",
            context.packageName
        )
        holder.context_layout.setOnClickListener{
            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            when (items[position].id){
                0 -> {
                    fragmentTransaction.replace(R.id.for_main, RegFragment()) // Замените YourFragment на ваш фрагмент
                    fragmentTransaction.addToBackStack(null) // Добавьте транзакцию в стек возврата
                    fragmentTransaction.commit()
                }
                1 -> {
                    fragmentTransaction.replace(R.id.for_main, AuthFragment()) // Замените YourFragment на ваш фрагмент
                    fragmentTransaction.addToBackStack(null) // Добавьте транзакцию в стек возврата
                    fragmentTransaction.commit()
                }
            }


        }
        holder.icon.setImageResource(iconID)
    }


    override fun getItemCount(): Int {
        return items.count()
    }
}