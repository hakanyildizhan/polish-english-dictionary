package com.hakansoft.polishdictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hakansoft.polishdictionary.databinding.FragmentTopbarBinding

class TopBarFragment : Fragment() {

    private lateinit var binding: FragmentTopbarBinding
    //private lateinit var viewModel: TopBarViewModel
    //private val viewModel: TopBarViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //viewModel = ViewModelProvider(this).get(TopBarViewModel::class.java)
        binding = FragmentTopbarBinding.inflate(layoutInflater)
        //binding.lifecycleOwner = this

        val viewModel: TopBarViewModel =
        ViewModelProvider(findNavController().getViewModelStoreOwner(R.id.nav_graph)).get(
            TopBarViewModel::class.java
        )
        binding.lifecycleOwner = requireParentFragment().viewLifecycleOwner
        binding.topbarViewModel = viewModel

        var view = binding.root
        return view

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home_search, container, false)
    }
}