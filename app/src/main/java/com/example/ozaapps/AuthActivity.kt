package com.example.ozaapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ozaapps.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var ivLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ivLogo = binding.ivLogo
        etUsername = binding.etUsername
        etPassword = binding.etPassword
        btnLogin = binding.btnLogin

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val editor = sharedPref.edit()


        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == password && username.isNotEmpty()) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()
                editor.putBoolean("isLogin", true)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                        etPassword.text.clear()
                    }
                    .show()
            }
        }
    }
}