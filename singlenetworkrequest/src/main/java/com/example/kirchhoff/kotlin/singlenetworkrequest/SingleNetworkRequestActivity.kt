package com.example.kirchhoff.kotlin.singlenetworkrequest

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

class SingleNetworkRequestActivity : AppCompatActivity() {

    private val viewModel: SingleNetworkRequestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SingleNetworkRequestUi(viewModel)
        }
    }
}

@Preview
@Composable
fun SingleNetworkRequestUiPreview() {
    SingleNetworkRequestUi(SingleNetworkRequestViewModel())
}

@Composable
fun SingleNetworkRequestUi(viewModel: SingleNetworkRequestViewModel) {
    val currentState by viewModel.screenData.observeAsState()

    val loadingVisible = currentState is ScreenData.Loading
    val textVisible = currentState is ScreenData.Success || currentState is ScreenData.Error
    val buttonEnabled = !loadingVisible
    val resultText = when (currentState) {
        is ScreenData.Success -> stringResource(
            id = R.string.single_network_request_info_from_server_pattern,
            (currentState as ScreenData.Success<out SingleNetworkRequestScreenData>).data.information
        )
        is ScreenData.Error -> (currentState as ScreenData.Error).message
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
            Text(stringResource(id = R.string.single_network_request))
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
            Text(text = resultText)
        }
    }
}
