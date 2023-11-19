package com.example.shop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.shop.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    lateinit private var binding: FragmentItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentItemBinding.inflate(inflater)

        val context: Context = requireContext()

        binding.fbuttonItem.setOnClickListener {
            Toast.makeText(context, "Типо оформлен заказ", Toast.LENGTH_SHORT).show()
        }

        val lifecycleOwner: LifecycleOwner = this


        DataModel.itemList.observe(lifecycleOwner, {
            binding.ftitleInItem.text = it.title
            binding.fullDescInItem.text = it.full_desc
            binding.fbuttonItem.text = "Buy ${it.price}"
            binding.fimageInItem.setImageResource(it.image.toInt())
        })

        return binding.root
}
    companion object {
        @JvmStatic
        fun newInstance() = ItemFragment()

    }

}