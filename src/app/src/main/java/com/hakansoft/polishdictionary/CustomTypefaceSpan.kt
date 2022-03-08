package com.hakansoft.polishdictionary

import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan

// for API < 28
class CustomTypefaceSpan(private val typeface: Typeface?) : MetricAffectingSpan() {
    override fun updateDrawState(paint: TextPaint) {
        paint.typeface = typeface
    }

    override fun updateMeasureState(paint: TextPaint) {
        paint.typeface = typeface
    }
}