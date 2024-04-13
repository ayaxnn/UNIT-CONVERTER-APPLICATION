package com.example.mmiltask

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Timebtn = findViewById<ImageView>(R.id.igtime)
        val Distbtn = findViewById<ImageView>(R.id.igdis)
        val Weightbtn = findViewById<ImageView>(R.id.igwgt)
        val TEmpbtn = findViewById<ImageView>(R.id.igtemp)
        val btnPickImage = findViewById<Button>(R.id.btnPickImage)




        Distbtn.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        Timebtn.setOnClickListener {
            val intent1 = Intent(this, MainActivity4::class.java)
            startActivity(intent1)
        }


        Weightbtn.setOnClickListener {
            val intent1 = Intent(this, MainActivity5::class.java)
            startActivity(intent1)
        }


        TEmpbtn.setOnClickListener {
            val intent2 = Intent(this, MainActivity6::class.java)
            startActivity(intent2)
        }


        btnPickImage.setOnClickListener {
            pickImageFromGallery()
        }


    }


    private fun pickImageFromGallery() {
        val intent3 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent3, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri = data.data!!
            val intent = Intent(this, MainActivity7::class.java)
            intent.putExtra("imageUri", imageUri.toString())
            startActivity(intent)
        }


    }
}