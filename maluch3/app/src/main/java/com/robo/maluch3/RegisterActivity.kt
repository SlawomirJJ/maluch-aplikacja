package com.robo.maluch3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity //było pierwotnie
import android.os.Bundle    //było pierwotnie
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp //tak o se dodalem
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseAuth  //? FirebaseAuth
//import com.google.firebase.auth.com.google.firebase.auth.FirebaseAuth // pojawiła się taka podpowiedz
//import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*



class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



    //val button = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener{


            when{
            TextUtils.isEmpty(editTextTextEmailAddress.text.toString().trim{it<= ' '})->{
                Toast.makeText(
                    this@RegisterActivity,
                    "Plese enter email.",
                    Toast.LENGTH_SHORT
                ).show()
            }


            TextUtils.isEmpty(editTextTextPassword2.text.toString().trim{it<= ' '})->{
                Toast.makeText(
                    this@RegisterActivity,
                    "Plese enter password.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else->{
                val email: String =editTextTextEmailAddress.text.toString().trim{it <=' '}
                val password: String =editTextTextPassword2.text.toString().trim{it <=' '}

                //Create an instance and create a register a user with email and password
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(
                        OnCompleteListener<AuthResult>{task ->

                            //if the registration is succesfully done
                            if (task.isSuccessful){

                            }
                        }
                    )
            }



        }
    }



    }
}