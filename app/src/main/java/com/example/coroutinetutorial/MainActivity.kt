package com.example.coroutinetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch{
            val answer1 = networkCall1()
            val answer2 = networkCall2()
            Log.d(TAG, "Answer1 is $answer1")
            Log.d(TAG, "Answer2 is $answer2")
        }
    }

   suspend fun networkCall1(): String {
       delay(3000L)
       return "This is network call 1"
   }

    suspend fun networkCall2(): String {
        delay(3000L)
        return "This is network call 2"
    }
}