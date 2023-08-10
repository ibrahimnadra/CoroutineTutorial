package com.example.coroutinetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch{
            Log.d(TAG, "Greetings from coroutine (thread : ${Thread.currentThread().name}")
        }
        Log.d(TAG, "Greetings from MainActivity (thread : ${Thread.currentThread().name}")
    }
}