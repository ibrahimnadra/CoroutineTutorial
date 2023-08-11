package com.example.coroutinetutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
//            ViewModelScope.launch {
            lifecycleScope.launch {
                while(true){
                    delay(1000L)
                    Log.d(TAG, "Still Running")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}