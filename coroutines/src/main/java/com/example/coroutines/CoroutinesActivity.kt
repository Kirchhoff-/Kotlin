package com.example.coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        findViewById<View>(R.id.bFirstExample).setOnClickListener { fistExample() }
        findViewById<View>(R.id.bSecondExample).setOnClickListener { secondExample() }
        findViewById<View>(R.id.bThirdExample).setOnClickListener { thirdExample() }
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

    private fun secondExample() {
        runBlocking {
            launch {
                delay(200L)
                println("Task from runBlocking")
            }

            coroutineScope {
                // Creates a new coroutine scope
                val job = launch {
                    println("Task from nested launch, this is printed")
                    delay(500L)
                    println("Task from nested launch, this won't be printed")
                }

                delay(100L)
                println("Task from first coroutine scope") // Printed before initial launch
                job.cancel() // This cancels nested launch's execution
            }

            println("Coroutine scope is over") // This is not printed until nested launch completes/is cancelled
        }
    }

    private fun thirdExample() {
        runBlocking {
            val startTime = System.currentTimeMillis()
            val job = launch(Dispatchers.Default) {
                var nextPrintTime = startTime
                var i = 0
                while (isActive) {
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("I'm sleeping ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
            }
            delay(1300L) // delay a bit
            println("main: I'm tired of waiting!")
            job.cancelAndJoin() // cancels the job and waits for its completion
            println("main: Now I can quit.")
        }
    }
}