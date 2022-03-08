package com.hakansoft.polishdictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakansoft.polishdictionary.databinding.FragmentSearchHistoryBinding

class SearchHistoryFragment : Fragment() {

    private var binding: FragmentSearchHistoryBinding? = null
    private val sharedTopBarViewModel: TopBarViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchHistoryBinding.inflate(inflater, container, false)
        sharedTopBarViewModel.setMainText("Search history")
        sharedTopBarViewModel.setAltText("")
        binding!!.topbarViewModel = sharedTopBarViewModel

        val application = requireNotNull(this.activity).application
        val dao = DictionaryDb.getInstance(application).searchHistoryDao
        val viewModelFactory = SearchHistoryViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SearchHistoryViewModel::class.java)

        viewModel.words.observe(viewLifecycleOwner, Observer { words ->
            binding!!.searchHistory.layoutManager = LinearLayoutManager(requireContext())
            binding!!.searchHistory.adapter = SearchHistoryRecyclerViewAdapter(requireContext(), words)
        })

        return binding!!.root
    }
}