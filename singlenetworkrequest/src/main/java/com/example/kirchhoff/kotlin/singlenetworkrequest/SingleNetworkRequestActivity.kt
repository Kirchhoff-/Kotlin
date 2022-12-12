package com.example.kirchhoff.kotlin.singlenetworkrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.kirchhoff.kotlin.core.ScreenData
import com.example.kirchhoff.kotlin.singlenetworkrequest.databinding.ActivitySingleNetworkRequestBinding

class SingleNetworkRequestActivity: AppCompatActivity() {

  private lateinit var binding: ActivitySingleNetworkRequestBinding
  private val viewModel: SingleNetworkRequestViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySingleNetworkRequestBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel.screenData.observe(this) {
      if (it != null) {
        displayData(it)
      }
    }
    binding.bPerformRequest.setOnClickListener {
      viewModel.requestData()
    }
  }

  private fun displayData(screenData: ScreenData<out SingleNetworkRequestScreenData>) {
    when (screenData) {
      is ScreenData.Success -> showInformationFromServer(screenData.data)
      is ScreenData.Error -> showError(screenData.message)
      is ScreenData.Loading -> showLoading()
    }
  }

  private fun showInformationFromServer(screenData: SingleNetworkRequestScreenData) {
    with(binding) {
      bPerformRequest.isEnabled = true
      pbLoading.isVisible = false
      tvInfo.isVisible = true

      tvInfo.text = getString(R.string.single_network_request_info_from_server_pattern, screenData.information)
    }
  }

  private fun showError(message: String) {
    with(binding) {
      bPerformRequest.isEnabled = true
      pbLoading.isVisible = false
      tvInfo.isVisible = true

      tvInfo.text = message
    }
  }

  private fun showLoading() {
    with(binding) {
      bPerformRequest.isEnabled = false
      tvInfo.isVisible = false
      pbLoading.isVisible = true
    }
  }
}
