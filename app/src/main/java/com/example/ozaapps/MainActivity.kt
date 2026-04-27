package com.example.ozaapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ozaapps.Home.Pertemuan7.SevenActivity
import com.example.ozaapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)


// Pertemuan 7
        findViewById<Button>(R.id.btnPertemuan7).setOnClickListener {
            startActivity(Intent(this, SevenActivity::class.java))
        }
        btnLogout = binding.btnLogout

        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", false)
                    editor.apply()

                    val intent = Intent(this, SevenActivity::class.java)
                    startActivity(intent)
                    finish()

                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}