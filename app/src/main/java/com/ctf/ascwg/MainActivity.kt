package com.ctf.ascwg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.scottyab.rootbeer.RootBeer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

        fun decrypt(algorithm: String, cipherText: String, key: SecretKeySpec, iv: IvParameterSpec): String {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.DECRYPT_MODE, key, iv)
        val plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText))
        return String(plainText)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootBeer = RootBeer(applicationContext)

            //we didn't find indication of root
            login.setOnClickListener {

            val algorithm = "AES/CBC/PKCS5Padding"
            val key = SecretKeySpec("1561615050650065".toByteArray(), "AES")
            val iv = IvParameterSpec(ByteArray(16))
            val cipherText = "kcjiK3pT/4QdvfqmnPel/A=="
            val plainText = decrypt(algorithm, cipherText, key, iv)


            if (nameEt.text.toString().equals("badawy") and passEt.text.toString().equals(plainText)) {
                val intent = Intent(this, AnotherActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Welcome Badawy!", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Credentials are wrong!", Toast.LENGTH_LONG).show()
            }
        }
        }

}