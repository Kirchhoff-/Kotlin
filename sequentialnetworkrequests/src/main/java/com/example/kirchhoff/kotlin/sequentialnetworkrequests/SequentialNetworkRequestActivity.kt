package com.example.kirchhoff.kotlin.sequentialnetworkrequests

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kirchhoff.kotlin.core.ScreenData

class SequentialNetworkRequestActivity : AppCompatActivity() {

    private val viewModel: SequentialNetworkRequestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SequentialNetworkRequestUi(viewModel)
        }
    }
}

@Preview
@Composable
fun SequentialNetworkRequestUiPreview() {
    SequentialNetworkRequestUi(SequentialNetworkRequestViewModel())
}

@Composable
fun SequentialNetworkRequestUi(viewModel: SequentialNetworkRequestViewModel) {
    val currentState by viewModel.screenData.observeAsState()

    val loadingVisible = currentState is ScreenData.Loading
    val textVisible = currentState is ScreenData.Success || currentState is ScreenData.Error
    val buttonEnabled = !loadingVisible

    val infoText = when (currentState) {
        is ScreenData.Success -> stringResource(
            id = R.string.sequential_network_request_info_from_server_pattern,
            (currentState as ScreenData.Success<out SequentialNetworkRequestScreenData>).data.information
        )
        is ScreenData.Error -> (currentState as ScreenData.Error).message
        else -> ""
    }
    val additionalInfoText = when (currentState) {
        is ScreenData.Success -> stringResource(
            id = R.string.sequential_network_request_additional_info_from_server_pattern,
            (currentState as ScreenData.Success<out SequentialNetworkRequestScreenData>).data.additionalInfo
        )
        else -> ""
    }

    Column {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            enabled = buttonEnabled,
            onClick = { viewModel.requestData() }
        ) {
            Text(stringResource(id = R.string.sequential_network_request))
        }
        AnimatedVisibility(
            visible = loadingVisible,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            CircularProgressIndicator()
        }
        AnimatedVisibility(
            visible = textVisible,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = infoText)
        }
        AnimatedVisibility(
            visible = textVisible,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = additionalInfoText)
        }
    }
}
