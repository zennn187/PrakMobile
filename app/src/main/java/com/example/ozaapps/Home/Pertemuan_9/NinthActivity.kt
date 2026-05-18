package com.example.ozaapps.Home.Pertemuan_9

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ozaapps.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputEditText

class NinthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninth)

        // Inisialisasi View
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmit)
        val btnWebView = findViewById<MaterialButton>(R.id.btnWebView)
        val btnBack = findViewById<MaterialButton>(R.id.btnBack)
        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
        val listView = findViewById<ListView>(R.id.listViewMore)

        // 1. Logika Tombol Simpan
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Data $name tersimpan!", Toast.LENGTH_SHORT).show()
            } else {
                etName.error = "Input nama dulu!"
            }
        }

        btnWebView.setOnClickListener {
            val url = "https://oza-umkm.alwaysdata.net/dashboard"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }

        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            chip?.let {
                Toast.makeText(this, "Kategori: ${it.text}", Toast.LENGTH_SHORT).show()
            }
        }

        val menuLainnya = arrayOf("Privacy Policy", "Terms of Service", "About Developer", "Contact Us", "Feedback")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuLainnya)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = menuLainnya[position]
            Toast.makeText(this, "Membuka $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}