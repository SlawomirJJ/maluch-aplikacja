package com.robo.maluch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //zmiana ekranu z logowania do rejestracji
        tv_register.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }




        btn_login.setOnClickListener {


            when {
                TextUtils.isEmpty(editTextTextEmailAddress2.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Proszę podać mail",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                TextUtils.isEmpty(editTextTextPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Proszę podać hasło.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = editTextTextEmailAddress2.text.toString().trim { it <= ' ' }
                    val password: String = editTextTextPassword.text.toString().trim { it <= ' ' }

                    // logowanie przy użyciu FirebaseAuth
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Zalogowano pomyślnie.",
                                    Toast.LENGTH_SHORT
                                ).show()


                                val intent =
                                    Intent(this@LoginActivity, MainActivity::class.java)
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
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