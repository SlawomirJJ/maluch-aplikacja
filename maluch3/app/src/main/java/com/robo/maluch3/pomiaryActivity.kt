package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_ster_auto.*

class pomiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomiary)


        var database = FirebaseDatabase.getInstance().reference


/*

        btn_przej_do_RC.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_przejdz_do_ster_autonom.setOnClickListener{
            val intent = Intent(this,SterAutoActivity::class.java)
            startActivity(intent)
        }
 */










    }
}