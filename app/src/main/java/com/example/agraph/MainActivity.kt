package com.example.agraph

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.EmbossMaskFilter
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.androidplot.pie.PieChart
import com.androidplot.pie.PieRenderer
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.androidplot.util.PixelUtils
import com.androidplot.xy.*

class MainActivity : AppCompatActivity() {

    //private lateinit var xyPlot: XYPlot
    private lateinit var pie: PieChart
    private val SELECTED_SEGMENT_OFFSET = 50F
    private lateinit var pieSegment1: Segment
    private lateinit var pieSegment2: Segment
    private lateinit var pieSegment3: Segment
    private lateinit var pieSegment4: Segment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pie = findViewById(R.id.mySimplePieChart)

        pie.legend.isVisible = true
        val padding = PixelUtils.dpToPix(30F)
        pie.pie.setPadding(padding, padding, padding, padding)

        pie.setOnTouchListener(object:View.OnTouchListener {
            override fun onTouch(view:View, motionEvent:MotionEvent):Boolean {
                val click = PointF(motionEvent.x, motionEvent.y)
                if (pie.pie.containsPoint(click))
                {
                    val segment = pie.getRenderer(PieRenderer::class.java).getContainingSegment(click)
                    if (segment != null)
                    {
                        var isSelected = getFormatter(segment).offset != 0F
                        deselectAll()
                        setSelected(segment, !isSelected)
                        pie.redraw()
                    }
                }
                return false
            }
            private fun getFormatter(segment:Segment): SegmentFormatter {
                return pie.getFormatter(segment, PieRenderer::class.java)
            }
            private fun deselectAll() {
                val segments = pie.registry.seriesList
                for (segment in segments)
                {
                    setSelected(segment, false)
                }
            }
            private fun setSelected(segment:Segment, isSelected:Boolean) {
                val f = getFormatter(segment)
                if (isSelected)
                {
                    f.offset = SELECTED_SEGMENT_OFFSET
                }
                else
                {
                    f.offset = 0F
                }
            }
        })

        pieSegment1 = Segment("Segment 1", 3)
        pieSegment2 = Segment("Segment 2", 1)
        pieSegment3 = Segment("Segment 3", 7)
        pieSegment4 = Segment("Segment 4", 9)

        val embossmaskfilter = EmbossMaskFilter(floatArrayOf(1F, 1F, 1F), 0.4f, 10f, 8.2f)

        val sf1 = SegmentFormatter(this, R.xml.pie_segment_formatter1)
        sf1.labelPaint.setShadowLayer(3f, 0f, 0f, Color.BLACK)
        sf1.fillPaint.setMaskFilter(embossmaskfilter)

        val sf2 = SegmentFormatter(this, R.xml.pie_segment_formatter2)
        sf1.labelPaint.setShadowLayer(3f, 0f, 0f, Color.BLACK)
        sf1.fillPaint.setMaskFilter(embossmaskfilter)

        val sf3 = SegmentFormatter(this, R.xml.pie_segment_formatter3)
        sf1.labelPaint.setShadowLayer(3f, 0f, 0f, Color.BLACK)
        sf1.fillPaint.setMaskFilter(embossmaskfilter)

        val sf4 = SegmentFormatter(this, R.xml.pie_segment_formatter4)
        sf1.labelPaint.setShadowLayer(3f, 0f, 0f, Color.BLACK)
        sf1.fillPaint.setMaskFilter(embossmaskfilter)

        pie.addSegment(pieSegment1, sf1)
        pie.addSegment(pieSegment2, sf2)
        pie.addSegment(pieSegment3, sf3)
        pie.addSegment(pieSegment4, sf4)



        // Out commented simple XY Plot for now.
        /*// Find my plot
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
        series2Format.linePaint.pathEffect = DashPathEffect(floatArrayOf(
            PixelUtils.dpToPix(20f),
            PixelUtils.dpToPix(15f)), 0f)
        //Adding the series to the plot display and changing label values.
        xyPlot.addSeries(series1, series1Format)
        xyPlot.addSeries(series2, series2Format)
        xyPlot.title.text = "Folk med Gedeskæg"
        xyPlot.domainTitle.text = "År det har groet"
        xyPlot.rangeTitle.text = "Længde på skæg"*/

    }
}
