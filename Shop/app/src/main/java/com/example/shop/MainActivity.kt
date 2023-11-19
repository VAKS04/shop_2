package com.example.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val parentLayout = R.id.for_main
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(parentLayout,MainFragment())

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.goods -> {
                    replaceFragment(parentLayout,MainFragment())
                }
                R.id.basket ->
//                    Toast.makeText(this,"Корзина",Toast.LENGTH_SHORT).show()
                    replaceFragment(parentLayout,BasketFragment())
                R.id.item_main -> {
                    replaceFragment(parentLayout,UserFragment())
                }
            }
            true
        }
    }
    fun replaceFragment(layout:Int,fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(layout,fragment).commit()
    }
}