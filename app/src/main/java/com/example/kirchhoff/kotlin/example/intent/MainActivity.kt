package com.example.kirchhoff.kotlin.example.intent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.kirchhoff.kotlin.databinding.AOtherBinding
import com.example.kirchhoff.kotlin.singlenetworkrequest.SingleNetworkRequestActivity
import com.example.ranges.RangeActivity

class MainActivity : Activity() {

    private lateinit var binding: AOtherBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            bRange.isVisible = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
            bRange.setOnClickListener {
                startActivity(Intent(this@MainActivity, RangeActivity::class.java))
            }
            bSingleNetworkRequest.setOnClickListener {
                startActivity(Intent(this@MainActivity, SingleNetworkRequestActivity::class.java))
            }
        }
    }
}
