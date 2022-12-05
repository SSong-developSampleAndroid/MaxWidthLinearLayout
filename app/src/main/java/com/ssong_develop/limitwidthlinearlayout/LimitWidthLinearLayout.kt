package com.ssong_develop.limitwidthlinearlayout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import com.google.android.material.textview.MaterialTextView
import java.lang.Integer.max

class LimitWidthLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val childViewSet = mutableSetOf<MaterialTextView>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var maxWidth = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            childViewSet.add(child as MaterialTextView)
            child.measure(
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            )
            maxWidth = max(maxWidth,child.measuredWidth)
        }
        if (maxWidth >= context.dpToPx(40)) {
            test()
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun test() {
        childViewSet.forEach {
            Log.d("ssong-develop2","${it}")
        }
        Log.d("ssong-develop1","Limit Function Invoke!")
    }
}