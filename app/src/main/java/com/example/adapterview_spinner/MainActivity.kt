package com.example.adapterview_spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adapterview_spinner.MainActivity
import com.example.adapterview_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie=arrayOf(
            "쿵푸팬더", "짱구는 못말려", "프랑켄슈타인",
            "아바타", "체인소맨", "국가대표", "토이스토리",
            "마당을 나온 암탉", "죽은 시인의 사회", "세계의 주인"
        )

        val posterID= arrayOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,
            R.drawable.image10
        )

        val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter=adapter

        binding.spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long)
            {
                binding.imageView.setImageResource(posterID[position])
                Toast.makeText(this@MainActivity, movie[position], Toast.LENGTH_SHORT).show()
            }
            override  fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}