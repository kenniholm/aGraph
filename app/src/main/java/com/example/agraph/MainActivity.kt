package com.example.agraph

import android.graphics.Color
import android.graphics.DashPathEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidplot.util.PixelUtils
import com.androidplot.xy.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var xyPlot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        // Find my plot
        xyPlot = findViewById(R.id.plot)
        //List of values to display on y axis
        var series1Numbers = listOf(1, 4, 2, 8, 4, 16, 8, 32, 16, 64)
        var series2Numbers = listOf(5, 2, 10, 5, 20, 10, 40, 20, 80, 40)
        //Set mock data for different series
        var series1 = SimpleXYSeries(series1Numbers, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Folk under 50")
        var series2 = SimpleXYSeries(series2Numbers, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Folk over 50")
        //Set color for different series lines and dots.
        var series1Format = LineAndPointFormatter(Color.RED, Color.GREEN, Color.TRANSPARENT, null)
        var series2Format = LineAndPointFormatter(Color.BLUE, Color. RED, Color.TRANSPARENT, null)
        // Sets the graphline as dashed. #Example of styling.
        series2Format.linePaint.setPathEffect(DashPathEffect(floatArrayOf(
            PixelUtils.dpToPix(20f),
            PixelUtils.dpToPix(15f)), 0f))
        //Adding the series to the plot display and changing label values.
        xyPlot.addSeries(series1, series1Format)
        xyPlot.addSeries(series2, series2Format)
        xyPlot.title.text = "Folk med Gedeskæg"
        xyPlot.domainTitle.text = "År det har groet"
        xyPlot.rangeTitle.text = "Længde på skæg"

    }
}
