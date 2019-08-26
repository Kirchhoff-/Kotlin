package com.example.coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        findViewById<View>(R.id.bFirstExample).setOnClickListener{ fistExample() }
    }

    private fun fistExample() {
        GlobalScope.launch {
            delay(1000L)
            println("World")

            val sum1 = async {
                println("start first calculation")
                delay(100L)
                println("finish first calculation")
                2 + 2
            }

            val sum2 = async {
                println("start second calculation")
                delay(5000L)
                println("finish second calculation")
                3 + 3
            }

            println("waiting concurrent sum")
            val total = sum1.await() + sum2.await()
            println("Total is: $total")
        }

        println("Hello,")
    }
}