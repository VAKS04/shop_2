package com.example.shop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var bindigFrM:FragmentMainBinding

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
    var item3 = Item(
        "Honor magic5 Pro",
        "honor",
        "honor - просто хороший телефон",
        "Смартфон Honor Magic5 Pro оснащен дисплеем AMOLED с диагональю 6,81 дюйма и разрешением 1312×2848, прикрытым стеклом с покатыми краями. Физические размеры экрана составляют 73×157 мм, плотность точек — 460 ppi. Соотношение сторон 19,5:9. Ширина рамки вокруг экрана составляет 2 мм по бокам, 2,5 мм сверху и 3 мм снизу",
        "235$")
    var item4 = Item(
        "Vivo Y36 8GB/256GB",
        "vivo",
        "vivo - хороший",
        " - ",
        "145$"
    )
    var item5 = Item(
        "Samsung Galaxy S10+ 128Gb",
        "samsung",
        "samsung - как iphone, только дешевле",
        " - ",
        "500$"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindigFrM = FragmentMainBinding.inflate(inflater)
//        val db = DbProduct(requireContext(),null)
//        db.getProduct()
        val items = arrayListOf<Item>()
        items.add(item1)
        items.add(item2)
        items.add(item3)
        items.add(item4)
        items.add(item5)

        val context: Context = requireContext()
        bindigFrM.recyclerInFragment.layoutManager = LinearLayoutManager(context)
        bindigFrM.recyclerInFragment.adapter = ItemsAdapter(items,context)

        return bindigFrM.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}