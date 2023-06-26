package com.ctf.ascwg

import android.content.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_another.*
import android.content.SharedPreferences

class AnotherActivity : AppCompatActivity() {
    init {
        System.loadLibrary("api-keys")
    }
    external fun getKeys() : String
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
//
        val intentFilter = IntentFilter("com.ctf.MyBroadcastReceiver")
        val objReceiver = MyBroadcastReceiver()
        registerReceiver(objReceiver, intentFilter)

        sharedPreferences = getSharedPreferences("FLAG", MODE_PRIVATE)
        val editor: SharedPreferences.Editor =sharedPreferences.edit()
        editor.putString("FLAG", ""+getKeys())
        editor.apply()

        BroadCastBtn.setOnClickListener {
            val intent = Intent()
            intent.action = "com.ctf.MyBroadcastReceiver"
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            intent.putExtra("data", "Nothing to see here, move along.")
            sendBroadcast(intent)
//        val editor: SharedPreferences.Editor = MainActivity().sharedPreferences.edit()
//            editor.putString("FLAG", ""+getKeys())
//            editor.apply()


        }

        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}