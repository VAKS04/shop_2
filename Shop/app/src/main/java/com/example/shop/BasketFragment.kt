package com.example.shop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.databinding.FragmentBasketBinding

class BasketFragment : Fragment() {
    lateinit var binding: FragmentBasketBinding
    var item1 =Item(
        "Xiaomi Redmi 8 pro",
        "xiaomi",
        "xiaomi - топ за свои деньги",
        "Спереди смартфон выглядит так же как и другие устройства от Xiaomi большой IPS дисплей 6.53\", фронтальная камера помещается в привычной нам “капельке”. Боковая рамка выполнена из пластика. На левой стороне располагается комбинированный слот для двух nano-sim или же одну симкарту можно заменить на microSD. На правой стороне: качелька регулировки громкости и кнопка питания. На нижнем торце: USB Type-C, jack 3.5 мм, динамик и микрофон. И на верхнем торце расположились: дополнительный микрофон и ИК-передатчик для управления техникой. Тыльная часть смартфона выполнена из стекла Gorilla Glass 5, стекло, как мы уже привыкли, имеет очень красивые переливы. В центре на тыльной стороне располагаются: 3 основные камеры и дополнительный модуль датчика глубины, LED-вспышка, сканер отпечатка пальца. Смартфон достаточно крупный его размеры: длина 161.3 мм, ширина 76.4 мм, толщина 8.8 мм и вес 199 г.",
        "200$")
    var item2 = Item(
        "Iphone 14 pro max",
        "iphone",
        "iphone - только для обеспеченных",
        "Из аппаратных нововведений от iPhone 14 Pro Max получил процессор A16 Bionic, улучшенную камеру на 48 Мп и поддержку технологии Always-On Display, благодаря которой экран будет оставаться включенным постоянно. Этого удастся добиться за счёт снижения частоты обновления до 1 Гц.",
        "2000$")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val items = arrayListOf<Item>()
        items.add(item1)
        items.add(item2)
        binding = FragmentBasketBinding.inflate(inflater)
        val context: Context = requireContext()
        binding.recyclerInBasketFragment.layoutManager = LinearLayoutManager(context)
        binding.recyclerInBasketFragment.adapter = BasketAdapter(items,context)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = BasketFragment()
    }

}