package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_przejdz_do_auto_pomiary
import kotlinx.android.synthetic.main.activity_pomiary.*
import kotlinx.android.synthetic.main.activity_ster_auto.*
import kotlinx.android.synthetic.main.activity_ster_auto.btn_przej_do_RC_pomiary

class pomiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomiary)


        var database = FirebaseDatabase.getInstance().reference




        btn_przej_do_RC_pomiary.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_przejdz_do_auto_pomiary.setOnClickListener {
            val intent = Intent(this, SterAutoActivity::class.java)
            startActivity(intent)
        }



        var getdata =object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }



            override fun onDataChange(@NonNull p0: DataSnapshot) {


                var temperatura =StringBuilder()
                var wilgotnosc = StringBuilder()
                var maxTemperatura:Double
                var maxWilgotnosc:Double

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

                    if(i.key=="dodatkoweDane")
                        {
                            maxTemperatura = i.child("maxTemperatura").getValue().toString().toDouble()
                            maxWilgotnosc = i.child("maxWilgotnosc").getValue().toString().toDouble()

                        }


                        var temp= i.child("temperatura").getValue()



                        temperatura.append("$temp")
                        var wilg= i.child("wilgotnosc").getValue()
                        wilgotnosc.append("$wilg")


                    }
                }




                textView_temperatura.setText(temperatura)
                textView_wilgotnosc.setText(wilgotnosc)


            }

        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)














    }
}





