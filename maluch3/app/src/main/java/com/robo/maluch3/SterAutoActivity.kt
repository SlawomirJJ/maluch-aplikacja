package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_ster_auto.*

class SterAutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ster_auto)



        var database = FirebaseDatabase.getInstance().reference


        btn_przej_do_RC.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
/*
        btn_pomiary.setOnClickListener{
            val intent = Intent(this,pomiaryActivity::class.java)
            startActivity(intent)
        }
*/



        btn_jedz.setOnClickListener {
            when {
                TextUtils.isEmpty(input_pkt.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@SterAutoActivity,
                        "Podaj punkt do którego chcesz się udać",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(input_wymiar.text.toString().trim{it<= ' '})->{
                    Toast.makeText(
                        this@SterAutoActivity,
                        "Podaj wymiar planszy w centymetrach kw",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                else -> {
                    var punkt = input_pkt.text.toString().toInt()
                    var wymiar = input_wymiar.text.toString().toInt()

                  /*  if (TextUtils.isEmpty(input_wymiar.text.toString().trim { it <= ' ' })) {
                        var wymiar = 2
                    }*/

                    database.child("ESP32").setValue(Sterowanie("S", punkt, "A", 255,wymiar))


                   /* if (!(TextUtils.isEmpty(input_wymiar.text.toString().trim { it <= ' ' }))) {
                        var wymiar = input_wymiar.text.toString().toInt()
                        database.child("ESP32").setValue(Sterowanie("S", punkt, "A", 255))
                    }
                    */

                }
            }
        }






    }
}