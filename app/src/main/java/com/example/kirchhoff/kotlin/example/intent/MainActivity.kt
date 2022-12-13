package com.example.kirchhoff.kotlin.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kirchhoff.kotlin.R
import com.example.kirchhoff.kotlin.singlenetworkrequest.SingleNetworkRequestActivity
import com.example.ranges.RangeActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityUi(
                rangeClickListener = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            RangeActivity::class.java
                        )
                    )
                },
                singleNetworkRequestClickListener = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            SingleNetworkRequestActivity::class.java
                        )
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun MainActivityUiPreview() {
    MainActivityUi({}, {})
}

@Composable
fun MainActivityUi(
    rangeClickListener: (() -> Unit),
    singleNetworkRequestClickListener: (() -> Unit)
) {
    Column {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { rangeClickListener.invoke() }
        ) {
            Text(stringResource(id = R.string.range))
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { singleNetworkRequestClickListener.invoke() }
        ) {
            Text(stringResource(id = R.string.single_network_request))
        }
    }
}
