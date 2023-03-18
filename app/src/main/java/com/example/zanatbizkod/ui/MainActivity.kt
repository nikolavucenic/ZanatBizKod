package com.example.zanatbizkod.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zanatbizkod.R
import com.example.zanatbizkod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }.root)
    }
}