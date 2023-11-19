package com.example.shop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.databinding.FragmentMainBinding
import com.example.shop.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val listSettingClass = mutableListOf<SettingClass>()
        listSettingClass.add(SettingClass("Регистрация","reg",0))
        listSettingClass.add(SettingClass("Авторизация","auth",1))
        binding = FragmentUserBinding.inflate(inflater)
        val context: Context = requireContext()
        val lifecycleOwner: LifecycleOwner = this

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = SettingAdapter(listSettingClass,context)
        if(DataModel.itemString.toString() !=""){
            DataModel.itemString.observe(lifecycleOwner, {
                binding.mainTextView.text = it
                })
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}