package com.robo.maluch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var database = FirebaseDatabase.getInstance().reference


        btn_przod.setOnClickListener{
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




    }
}