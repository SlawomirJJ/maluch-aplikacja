package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.SeekBar
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
        var predkosc: Int=0
        var predkoscPrzeskalowana=20

        seekBarA.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                predkosc = progress.toString().toInt()
                predkoscPrzeskalowana = if (predkosc == 0) {
                    0

                } else {
                    (predkosc/3.333333333333 + 225).toInt()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


        btn_przej_do_RC_pomiary.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_pomiaryA.setOnClickListener{
            val intent = Intent(this,pomiaryActivity::class.java)
            startActivity(intent)
        }




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

                    database.child("ESP32").setValue(Sterowanie("S", punkt, "A", predkoscPrzeskalowana,wymiar))


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