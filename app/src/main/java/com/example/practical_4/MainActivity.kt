package com.example.practical_4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.telecom.Call
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Pt_No = findViewById<EditText>(R.id.pt_no)
        val Btn_Dial = findViewById<Button>(R.id.Btn_No)
        val Pt_Url = findViewById<EditText>(R.id.pt_url)
        val Btn_Open_Url = findViewById<Button>(R.id.Btn_Url)
        val Ib_Gallery = findViewById<ImageButton>(R.id.ib_gallery)
        val Ib_Camara = findViewById<ImageButton>(R.id.ib_camara)
        val Ib_Call = findViewById<ImageButton>(R.id.ib_call)
        val Ib_Contact = findViewById<ImageButton>(R.id.ib_contact)
        val Ib_Alarm = findViewById<ImageButton>(R.id.ib_alarm)

        Btn_Dial.setOnClickListener {

            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + Pt_No.getText())).apply { startActivity(this) }
            Toast.makeText(this, "Now you can call", Toast.LENGTH_LONG).show()
        }

        Btn_Open_Url.setOnClickListener {

                Intent(Intent.ACTION_VIEW).setData(Uri.parse( "http://" + Pt_Url.getText())).apply { startActivity(this) }
                Toast.makeText(this, "opening url", Toast.LENGTH_LONG).show()
        }

        Ib_Call.setOnClickListener {

            Intent(Intent.ACTION_VIEW).setData(CallLog.Calls.CONTENT_URI).apply { startActivity(this) }
            Toast.makeText(this, "Welcome to call log", Toast.LENGTH_LONG).show()
        }

        Ib_Contact.setOnClickListener {

            Intent(Intent.ACTION_VIEW).setData(ContactsContract.Contacts.CONTENT_URI).apply { startActivity(this) }
            Toast.makeText(this, "Welcome to contact", Toast.LENGTH_LONG).show()
        }

        Ib_Gallery.setOnClickListener {

            val i = Intent(Intent.ACTION_PICK)
            i.type = "image/*"
            startActivity(i)
            Toast.makeText(this, "Welcome to Gallery", Toast.LENGTH_LONG).show()
        }

        Ib_Camara.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
            Toast.makeText(this, "Now you can take picture", Toast.LENGTH_LONG).show()
        }

        Ib_Alarm.setOnClickListener {

            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
            Toast.makeText(this, "Now you can set alarm", Toast.LENGTH_LONG).show()
        }
    }
}