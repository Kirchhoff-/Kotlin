package com.example.kirchhoff.kotlin.kotlinbook.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.example.kirchhoff.kotlin.R
import com.example.kirchhoff.kotlin.kotlinbook.domain.commands.RequestDayForecastCommand
import com.example.kirchhoff.kotlin.kotlinbook.domain.model.Forecast
import com.example.kirchhoff.kotlin.kotlinbook.extensions.color
import com.example.kirchhoff.kotlin.kotlinbook.extensions.textColor
import com.example.kirchhoff.kotlin.kotlinbook.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import java.text.DateFormat

/**
 * @author Kirchhoff-
 */
public class DetailActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initToolbar()
        toolbarTitle = intent.getStringExtra(CITY_NAME)
        enableHomeAsUp { onBackPressed() }
        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute()
            uiThread { bindForecast(result) }
        }
    }


    private fun bindForecast(forecast: Forecast) = with(forecast) {
        Picasso.with(ctx).load(iconUrl).into(icon)
        supportActionBar?.subtitle = date.toDateString(DateFormat.FULL)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }


    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = it.first.toString()
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }
}