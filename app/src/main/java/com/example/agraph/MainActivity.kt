package com.example.agraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

class MainActivity : AppCompatActivity() {

    private lateinit var xyPlot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xyPlot = findViewById(R.id.plot)
        
    }
}
