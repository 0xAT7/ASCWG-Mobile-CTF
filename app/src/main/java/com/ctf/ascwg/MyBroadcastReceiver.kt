package com.ctf.ascwg

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class MyBroadcastReceiver : BroadcastReceiver() {
    init {
        System.loadLibrary("api-keys")
    }
    external fun getKeys() : String
    override fun onReceive(context: Context, intent: Intent) {

        val algorithm = "AES/CBC/PKCS5Padding"
        val key = SecretKeySpec("2561651651561651".toByteArray(), "AES")
        val iv = IvParameterSpec(ByteArray(16))
        val cipherText = "3KO5tETzqPHQGYdRQXJZE1x4ePh44iLL08vQJGjvXb4="
        val plainText = MainActivity().decrypt(algorithm, cipherText, key, iv)
        if (intent.getStringExtra("data").equals(plainText)) {
            Toast.makeText(context, "Flag: "+getKeys(),Toast.LENGTH_LONG).show()
        }
        else {
            Log.i("FLAG", "Hehehehe try again!")
            Toast.makeText(context, "Hehehehe try again!", Toast.LENGTH_LONG).show()
        }
        }
}