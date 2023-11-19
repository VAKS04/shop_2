package com.example.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.example.shop.databinding.FragmentAuthBinding
import com.example.shop.databinding.FragmentRegBinding

class AuthFragment : Fragment() {
    lateinit var binding: FragmentAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater)

        binding.linkToAuth.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.for_main,RegFragment()).commit()
        }
        val context = requireContext()
        val lifecycleOwner: LifecycleOwner = this
        binding.buttonAuth.setOnClickListener{
            val login = binding.userLoginAuth.text.toString().trim()
            val password = binding.userPasswordAuth.text.toString().trim()
            if (login == "" || password == "")
                Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else {
                val db = DBHelper(context, null)
                val isAuth = db.getUser(login, password)
                if (isAuth) {
                    Toast.makeText(context, "Авторизация пройдена", Toast.LENGTH_SHORT).show()
                    DataModel.itemString.value = "$login"
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.for_main,UserFragment()).commit()
                } else
                    Toast.makeText(context, "Авторизация $login НЕ пройдена", Toast.LENGTH_SHORT)
                        .show()

            }
        }
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = AuthFragment()
    }
}