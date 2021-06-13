package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //Dodane 04.06.2021 !!!!!!!!!!!
        var database = FirebaseDatabase.getInstance().reference


        //zmiana ekranu z logowania do rejestracji
        tv_register.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }




        btn_login.setOnClickListener {


            when {
                TextUtils.isEmpty(editTextTextEmailAddress2.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Plese enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                TextUtils.isEmpty(editTextTextPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Plese enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    var email: String = editTextTextEmailAddress2.text.toString().trim { it <= ' ' }
                    val password: String = editTextTextPassword.text.toString().trim { it <= ' ' }

                    // logowanie przy użyciu FirebaseAuth
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "You are logged in successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()


                                val intent =
                                    Intent(this@LoginActivity, BluetoothActivity::class.java)
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()


                                //Dodane 04.06.2021 !!!!!!!!!!!
                                var imie:String="@.iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
                                database.child(imie).setValue(UserData(name=email,0, 0,0))

                            } else {
                                // Jeżeli zalogowanie się nie powiodło
                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                }
            }
        }











    }
}