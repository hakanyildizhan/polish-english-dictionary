package com.hakansoft.polishdictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hakansoft.polishdictionary.databinding.FragmentSearchResultRowBinding

class SearchResultRowFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultRowBinding
    private lateinit var viewModel: SearchResultRowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_result_row, container, false)
        viewModel = ViewModelProvider(this).get(SearchResultRowViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}