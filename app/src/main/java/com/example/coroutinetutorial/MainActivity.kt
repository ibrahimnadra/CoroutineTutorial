package com.example.coroutinetutorial

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView1 = findViewById<TextView>(R.id.textView1)

        GlobalScope.launch{
            Log.d(TAG, "Coroutine is started in thread : ${Thread.currentThread().name}")
            val answer = networkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG, "Settting text in thread : ${Thread.currentThread().name}")
                textView1.text = answer
            }
        }
    }

    suspend fun networkCall(): String {
       delay(3000L)
       return "This is network call 1"
   }
}