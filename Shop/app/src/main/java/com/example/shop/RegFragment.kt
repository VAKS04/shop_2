package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shop.databinding.FragmentRegBinding

class RegFragment : Fragment() {
    lateinit var binding:FragmentRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(inflater)
        binding.linkToAuth.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.for_main,AuthFragment()).commit()
        }
        binding.buttonReg.setOnClickListener{
            val context = requireContext()
            val login = binding.userLoginReg.text.toString().trim()
            val email = binding.userEmailReg.text.toString().trim()
            val password = binding.userPasswordReg.text.toString().trim()
            if(login == "" || email == "" || password ==""){
                Toast.makeText(context,"Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = User(login,email,password)
                val db = DBHelper(context,null)
                db.addUser(user)
                Toast.makeText(context,"Регистрация пройдена",Toast.LENGTH_SHORT).show()
                DataModel.itemString.value = "$login"
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.for_main,UserFragment()).commit()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RegFragment()
    }
}