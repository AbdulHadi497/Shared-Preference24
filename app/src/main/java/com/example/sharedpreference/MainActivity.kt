package com.example.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var edit_Txt: EditText
    private lateinit var txt_View: TextView
    private lateinit var btn_Save: Button 
    private lateinit var btn_Load: Button

    private lateinit var sharedPreference: SharedPreferences

    private var shrdPrefName= "myPref"
    private var keyMessage= "message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_Txt = findViewById(R.id.edit_Txt)
        txt_View = findViewById(R.id.txt_View)
        btn_Load = findViewById(R.id.btn_Load)
        btn_Save = findViewById(R.id.btn_Save)

        sharedPreference = getSharedPreferences(shrdPrefName, MODE_PRIVATE)

        btn_Save.setOnClickListener {
            val message = edit_Txt.text.toString()

            if(message.isNotEmpty()){
                val editor = sharedPreference.edit()
                editor.putString(keyMessage,message)
                editor.apply()
                Toast.makeText(this, "Message Saved Successfully!!!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Please Enter Something", Toast.LENGTH_SHORT).show()
            }

            btn_Load.setOnClickListener{
                var savedMessage = sharedPreference.getString(keyMessage,null)

                if(savedMessage != null)
                {
                    txt_View.text = "saved Message: $savedMessage"
                }
                else{
                    txt_View.text = "Nothing Is Present!!!!"
                }
            }

        }
    }
}