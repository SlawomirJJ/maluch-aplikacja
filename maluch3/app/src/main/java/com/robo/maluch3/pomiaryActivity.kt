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
                var maxTemperatura=StringBuilder()
                var maxWilgotnosc=StringBuilder()
                var obstacleNumbers=StringBuilder()

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




                        var temp= i.child("temperatura").getValue()
                        temperatura.append("$temp")

                        var wilg= i.child("wilgotnosc").getValue()
                        wilgotnosc.append("$wilg")


                        var maxTemp = i.child("maxTemperatura").getValue()
                        maxTemperatura.append("$maxTemp")
                        //if(maxTemp<temp)
                        //{

                        //}

                        var maxWilg = i.child("maxWilgotnosc").getValue()
                        maxWilgotnosc.append("$maxWilg")

                        var obstacleNumb = i.child("obstacleNumbers").getValue()
                        obstacleNumbers.append("$obstacleNumb")


                    }
                   /* if(i.key=="dodatkoweDane")
                    {
                        var maxTemp = i.child("maxTemperatura").getValue()
                        maxTemperatura.append("$maxTemp")
                        //if()

                        var maxWilg = i.child("maxWilgotnosc").getValue()
                        maxWilgotnosc.append("$maxWilg")

                        var obstacleNumb = i.child("obstacleNumbers").getValue()
                        obstacleNumbers.append("$obstacleNumb")

                    }*/
                    if(i.key=="ESP32")
                    {
                        //var obstacleNumb = i.child("numero").getValue()
                        //obstacleNumbers.append("$obstacleNumb")
                    }
                }




                textView_temperatura.setText(temperatura)
                textView_wilgotnosc.setText(wilgotnosc)
                textView_licz_przeszkod.setText(obstacleNumbers)
                textView_maxTemperatura.setText(maxTemperatura)
                textView_maxWilgotnosc.setText(maxWilgotnosc)


            }

        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)














    }
}





