package com.example.coroutinetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

//Two network calls in a coroutine
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        GlobalScope.launch(Dispatchers.Default){
//            val time = measureTimeMillis {
//                //both occur after 6sec
//                val answer1 = networkCall1()
//                val answer2 = networkCall2()
//                Log.d(TAG, "Answer1 is $answer1")
//                Log.d(TAG, "Answer2 is $answer2")
//            }
//            Log.d(TAG, "Request took $time")
//        }
//    }
//
//   suspend fun networkCall1(): String {
//       delay(3000L)
//       return "This is network call 1"
//   }
//
//    suspend fun networkCall2(): String {
//        delay(3000L)
//        return "This is network call 2"
//    }
//}

//minimize time by launching separately
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        GlobalScope.launch(Dispatchers.Default){
//            val time = measureTimeMillis {
//                //both occur after 6sec
//                var answer1 : String ? = null
//                var answer2 : String ? = null
//                val job1 = launch { answer1 = networkCall1() }
//                val job2 =  launch { answer2 = networkCall2() }
//                //wait for them to finish
//                job1.join()
//                job2.join()
//                Log.d(TAG, "Answer1 is $answer1")
//                Log.d(TAG, "Answer2 is $answer2")
//            }
//            Log.d(TAG, "Request took $time")
//        }
//    }
//
//    suspend fun networkCall1(): String {
//        delay(3000L)
//        return "This is network call 1"
//    }
//
//    suspend fun networkCall2(): String {
//        delay(3000L)
//        return "This is network call 2"
//    }
//}

//better practice : async and await
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Default){
            val time = measureTimeMillis {
                //occurs concurrently(at the same time)
                val answer1 = async { networkCall1() }
                val answer2 =  async { networkCall2() }
                Log.d(TAG, "Answer1 is ${answer1.await()}")
                Log.d(TAG, "Answer2 is ${answer2.await()}")
            }
            Log.d(TAG, "Request took $time")
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