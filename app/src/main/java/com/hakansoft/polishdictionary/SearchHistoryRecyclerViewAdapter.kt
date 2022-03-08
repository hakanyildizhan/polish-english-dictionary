package com.hakansoft.polishdictionary

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.hakansoft.polishdictionary.databinding.FragmentSearchHistoryRowBinding

class SearchHistoryRecyclerViewAdapter : RecyclerView.Adapter<SearchHistoryRowFragment> {

    private lateinit var words: List<SearchHistory>
    private lateinit var context: Context

    constructor(ctx: Context, words: List<SearchHistory>) : super() {
        this.words = words
        this.context = ctx
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryRowFragment {
        val binding = FragmentSearchHistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchHistoryRowFragment(binding)
    }

    override fun onBindViewHolder(holder: SearchHistoryRowFragment, position: Int) {
        if (words == null) {
            return
        }

        var word = this.words[position].word.trim()
        holder.binding.word.setText(word, TextView.BufferType.NORMAL)

        if (position %2 == 1) {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.resources, R.color.red_light, null));
        } else {
            holder.itemView.setBackgroundColor(ResourcesCompat.getColor(context.resources, R.color.white, null));
        }
    }

    override fun getItemCount(): Int {
        if (words == null) {
            return 0
        } else {
            return words.size
        }
    }
}