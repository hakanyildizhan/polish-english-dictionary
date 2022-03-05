package com.hakansoft.polishdictionary

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.MetricAffectingSpan
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.hakansoft.polishdictionary.databinding.FragmentSearchResultRowBinding


class ListSelectionRecyclerViewAdapter : RecyclerView.Adapter<SearchResultRowFragment> {

    private lateinit var definitions: List<List<HtmlDefinition>>
    private lateinit var context: Context
    private var typefaceMap = mutableMapOf<HtmlFontStyle,Typeface>()

    constructor(ctx: Context, definitions: List<List<HtmlDefinition>>) : super() {
        this.definitions = definitions
        this.context = ctx
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultRowFragment {
        val binding = FragmentSearchResultRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchResultRowFragment(binding)
    }

    override fun onBindViewHolder(holder: SearchResultRowFragment, position: Int) {
        var definition = this.definitions[position]

        val text = SpannableStringBuilder("${position+1}")
        val typefaceSpanJuraRegular = ResourcesCompat.getFont(this.context, R.font.jura_regular);
        text.setSpan(createTypeface(typefaceSpanJuraRegular!!), 0, text.count(), Spanned.SPAN_INCLUSIVE_INCLUSIVE)

        val fullText: StringBuilder = java.lang.StringBuilder("${position+1}")
        for (piece in definition) {
            fullText.append(" ${piece.text}")
        }

        for (piece in definition) {
            var start: Int = text.length

            if (!typefaceMap.containsKey(piece.fontType)) {
                val typeface = ResourcesCompat.getFont(this.context,getFontFamily(piece.fontType))
                typefaceMap.put(piece.fontType, typeface!!)
            }

            var typeFace = typefaceMap[piece.fontType]!!

            text.append(" ${piece.text}")
            text.setSpan(createTypeface(typeFace), start, text.count(), Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        }

        holder.binding.definition.setText(text, TextView.BufferType.SPANNABLE)

        if (position %2 == 1) {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.resources, R.color.red_light, null));
        } else {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.resources, R.color.white, null));
        }
    }

    override fun getItemCount(): Int {
        return definitions.size
    }

    fun getFontFamily(fontStyle: HtmlFontStyle) : Int {
        return when (fontStyle) {
            HtmlFontStyle.Italic -> R.font.barlow_thinitalic
            HtmlFontStyle.Bold -> R.font.jura_bold
            HtmlFontStyle.None -> R.font.jura_light
            HtmlFontStyle.Unknown -> R.font.jura_light
        }
    }

    fun createTypeface(typeface: Typeface) : MetricAffectingSpan {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            return TypefaceSpan(typeface)
        } else {
            return CustomTypefaceSpan(typeface)
        }
    }
}