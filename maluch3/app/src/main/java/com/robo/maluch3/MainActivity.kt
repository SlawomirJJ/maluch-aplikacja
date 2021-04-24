package com.robo.maluch3

//import com.google.firebase.database.DatabaseReference

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val root = FirebaseDatabase.getInstance().reference.child("PRZ")//reference.root


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
                database.child("ESP32").setValue(Sterowanie("P",0,"R"))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_przod.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R"))
            }
            true
        })


        btn_tyl.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_tyl.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("T",0,"R"))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_tyl.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R"))
            }
            true
        })


        btn_prawo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_prawo.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("R",0,"R"))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_prawo.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R"))
            }
            true
        })


        btn_lewo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_DOWN) {
                btn_lewo.setPressed(true)
                database.child("ESP32").setValue(Sterowanie("L",0,"R"))
            }
            if (event.action and MotionEvent.ACTION_MASK == MotionEvent.ACTION_UP) {
                btn_lewo.setPressed(false)
                database.child("ESP32").setValue(Sterowanie("S",0,"R"))
            }
            true
        })



/*
         root.addValueEventListener(new ValueEventListener() {
             @override
             public void on DataChange(@NonNull DataSnapshot dataSnapshot){
                 for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                     add(snapshot.getValue().toString());
             }
                 adapter.notifyDataSetChanget();
             }
         })
*/

/*
        root.addValueEventListener {
            override fun onDataChange(@NonNull p0: DataSnapshot) {
                var odleglosc_przejechana = child("odleglosc_przejechana").getValue()
            }
        }

*/

       // root.addValueEventListener {
       var getdata =object:ValueEventListener{
           override fun onCancelled(p0: DatabaseError) {

           }



           override fun onDataChange(@NonNull p0: DataSnapshot) {

               var odl = StringBuilder()
               var pr = StringBuilder()
               var prz:String=""
               for (i in p0.children) {
                if(i.key=="PRZ")
                {
                    var odleglosc_przejechana = i.child("odleglosc_przejechana").getValue()
                    var predkosc = i.child("predkosc").getValue()
                    var przeszkoda = i.child("przeszkoda").getValue()
                    if(przeszkoda=="true")
                    {
                        prz="przeszkoda!!!"
                    }
                    odl.append("trasa: $odleglosc_przejechana \n")
                    pr.append("prędkość: $predkosc \n")
                }
               }






               textViewPrzeszkoda.setText(prz)
               textViewTrasa.setText(odl)
               textViewPredkosc.setText(pr)
           }

       }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
















    }
}




