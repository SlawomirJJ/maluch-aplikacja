package com.robo.maluch3

//import com.google.firebase.database.DatabaseReference

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.SeekBar
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var database = FirebaseDatabase.getInstance().reference
        var predkosc: Int = 0
        var predkoscPrzeskalowana=0
        if (predkosc !=null)
        {
            predkoscPrzeskalowana = (predkosc/3.333333333333 + 225).toInt()
        }





        btn_przod.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_przod.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("P",0,"R",predkoscPrzeskalowana ,0))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_przod.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R",predkosc,0))
            }
            true
        })


        btn_tyl.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_tyl.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("T",0,"R",predkoscPrzeskalowana,0))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_tyl.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R",predkoscPrzeskalowana,0))
            }
            true
        })


        btn_prawo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_prawo.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("R",0,"R",predkoscPrzeskalowana,0))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_prawo.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R",predkoscPrzeskalowana,0))
            }
            true
        })


        btn_lewo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_lewo.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("L",0,"R",predkoscPrzeskalowana,0))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_lewo.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R",predkoscPrzeskalowana,0))
            }
            true
        })






       var getdata =object:ValueEventListener{
           override fun onCancelled(p0: DatabaseError) {

           }



           override fun onDataChange(@NonNull p0: DataSnapshot) {

               var odl = StringBuilder()
               var pr = StringBuilder()
               var prz:String=""
               //var odlegloscPrzejechana: Float= 0.0F
               for (i in p0.children) {
                if(i.key=="PRZ")
                {
                  var  odlegloscPrzejechana = i.child("odleglosc_przejechana").getValue()
                       if (odlegloscPrzejechana is Double)
                       {
                           odlegloscPrzejechana = String.format("%.2f",odlegloscPrzejechana)

                       }

                  var predkosc = i.child("predkosc").getValue()
                    if (predkosc is Double)
                    {
                        predkosc = String.format("%.2f",predkosc)

                    }

                  var przeszkoda = i.child("przeszkoda").getValue()
                    if(przeszkoda=="true")
                    {
                        prz="przeszkoda!!!"
                    }


                    pr.append("prędkość: $predkosc [m/s]")
                    odl.append("trasa: $odlegloscPrzejechana [m]")
                }
               }






               textViewPrzeszkoda.setText(prz)
               textViewTrasa.setText(odl)
               textViewPredkosc.setText(pr)
           }

       }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)




        btn_przejdz_do_auto.setOnClickListener{
            val intent = Intent(this,SterAutoActivity::class.java)
            startActivity(intent)
        }

/*
        btn_pomiary.setOnClickListener{
            val intent = Intent(this,pomiaryActivity::class.java)
            startActivity(intent)
        }

*/


    seekBarRC.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            predkosc = progress.toString().toInt()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            //predkosc = progress.toString().toInt()
        }

    })






    }
}








