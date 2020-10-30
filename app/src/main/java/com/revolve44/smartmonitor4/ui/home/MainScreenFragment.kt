package com.revolve44.smartmonitor4.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.revolve44.smartmonitor4.R
import com.revolve44.smartmonitor4.adapters.HomeAdapter
import com.revolve44.smartmonitor4.core.Router
import kotlinx.android.synthetic.main.fragment_home.*

class MainScreenFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    var router : Router = Router()
//    lateinit var alertIcon : ImageView
    var i : Int = 12
   // var myDevices = arrayOf("Polaris Kettle", "PC", "Refrigerator", "MP3 Center", "Tesla Charger", "Heater", "Fan", "Xiamomi brash")
    //var thisfragment : HomeFragment = HomeFragment()
    lateinit var mainDescription : TextView
    var a = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        //final TickerView tickerView = findViewById(R.id.tickerView);
       // tickerView.setCharacterLists(TickerUtils.provideNumberList());
        mainDescription = view.findViewById(R.id.textdescription)

        showDescription()

        runTwoIndicators()

        twoIndicators.setOnClickListener {
            switchDescription()
        }


        //var tview : TickerView = ₽/час
        //var alertIcon : Int = R.id.alertIcon
        //alert()

    }

    private fun initRecyclerview() {
        recyler.apply {
            layoutManager = LinearLayoutManager(activity)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = HomeAdapter(router.arrayHolder(),router.arrayPowerConsume())

        }

    }

    @SuppressLint("SetTextI18n")
    fun showDescription(){

        mainDescription.text = "Smart Monitor"
        val handler = Handler()
        handler.postDelayed({
            // do something after 1000ms
            mainDescription.text = "за час вы тратите:"
        }, 4000)
    }

    fun switchDescription(){
//        if (a!=0){
//            a++
//        }


        when (a) {
            0 -> {
                mainDescription.text = "за час вы тратите:"
                runTwoIndicators()
                a++
            }
            1 -> {
                mainDescription.text = "за день вы потратите:"
                runTwoIndicators()
                a++
            }
            2 -> {
                mainDescription.text = "за месяц вы потратите:"
                runTwoIndicators()
                a++
            }
        }
//        if (a==0){
//            a++
//        }

        if (a>=3){ a = 0 }


    }

    fun runTwoIndicators(){
        when (a) {
            0 -> {
                tickerView.gravity = Gravity.CENTER
                tickerView.setText("1.2 ",true)

                tickerView2.gravity = Gravity.CENTER
                tickerView2.setText("12",true)
            }
            1 -> {
                tickerView.gravity = Gravity.CENTER
                tickerView.setText("9.4",true)

                tickerView2.gravity = Gravity.CENTER
                tickerView2.setText("807",true)
            }
            2 -> {
                tickerView.gravity = Gravity.CENTER
                tickerView.setText("350.6 ",true)

                tickerView2.gravity = Gravity.CENTER
                tickerView2.setText("10256",true)
            }
        }
//        tickerView.gravity = Gravity.CENTER
//        tickerView.setText("$i ",true)
//
//        tickerView2.gravity = Gravity.CENTER
//        tickerView2.setText("1.2",true)
    }

//    fun resetGray(): ColorMatrixColorFilter {
//        val matrix = ColorMatrix()
//        matrix.setSaturation(1f)
//        val filter = ColorMatrixColorFilter(matrix)
//        return filter
//    }
}