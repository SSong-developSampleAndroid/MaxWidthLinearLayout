package com.ssong_develop.limitwidthlinearlayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun Context.dpToPx(dp: Int) : Int {
    val density = resources.displayMetrics.density
    return (dp * density).roundToInt()
}