package com.robo.maluch3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var database = FirebaseDatabase.getInstance().reference


/*        btn_przod.setOnClickListener{
        database.setValue("Przod")
        }


        btn_tyl.setOnClickListener{
            database.setValue("Tyl")
        }

        btn_prawo.setOnClickListener{
            database.setValue("Prawo")
        }

        btn_lewo.setOnClickListener{
            database.setValue("Lewo")
        }


        btn_stop.setOnClickListener{
            database.setValue("stop")
        }
*/



        btn_przod.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_przod.setPressed(true)
                database.setValue("P")
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_przod.setPressed(false)
                database.setValue("S")
            }
            true
        })


        btn_tyl.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_tyl.setPressed(true)
                database.setValue("T")
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_tyl.setPressed(false)
                database.setValue("S")
            }
            true
        })


        btn_prawo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_prawo.setPressed(true)
                database.setValue("R")
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_prawo.setPressed(false)
                database.setValue("S")
            }
            true
        })


        btn_lewo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_lewo.setPressed(true)
                database.setValue("L")
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_lewo.setPressed(false)
                database.setValue("S")
            }
            true
        })



    }
}