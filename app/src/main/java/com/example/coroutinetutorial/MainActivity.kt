package com.example.coroutinetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

//Join
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val job = GlobalScope.launch(Dispatchers.Default){
//            repeat(5){
//                Log.d(TAG, " Coroutine is still working.")
//                //This delay ensures that each repetition is separated by a pause of 1 second,
//                // resulting in a visible delay between each log statement.
//                delay(1000L)
//            }
//        }
//        runBlocking {
//            job.join()
//            Log.d(TAG, " Main thread is continuing.")
//        }
//    }
//}

//cancel
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val job = GlobalScope.launch(Dispatchers.Default){
//            Log.d(TAG, "Starting Long calculation.")
//            for(i in 30..50){
//                if(isActive){
//                    Log.d(TAG, "Fib($i) : ${fib(i)}")
//                }
//            }
//            Log.d(TAG, "Ending Long calculation.")
//        }
//        runBlocking {
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG, "Canceled Job.")
//        }
//    }
//
//    fun fib(n : Int) : Long{
//        return if(n == 0) 0
//        else if(n ==1) 1
//        else fib(n - 1) + fib(n - 2)
//    }
//}


//timeout
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default){
            Log.d(TAG, "Starting Long calculation.")
            withTimeout(1000L){
                for(i in 30..50){
                    if(isActive){
                        Log.d(TAG, "Fib($i) : ${fib(i)}")
                    }
                }
            }
            Log.d(TAG, "Ending Long calculation.")
        }
    }

    fun fib(n : Int) : Long{
        return if(n == 0) 0
        else if(n ==1) 1
        else fib(n - 1) + fib(n - 2)
    }
}


