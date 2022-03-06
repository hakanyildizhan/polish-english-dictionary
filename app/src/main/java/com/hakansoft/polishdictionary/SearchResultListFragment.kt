package com.hakansoft.polishdictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakansoft.polishdictionary.databinding.FragmentSearchResultListBinding
import kotlinx.coroutines.*

class SearchResultListFragment : Fragment() {

    companion object {
        fun getApiCaller(context: String): IApiCaller {
            return when (context) {
                "app" -> LektorekApiCaller()
                "test" -> MockApiCaller()
                else -> throw Exception("Invalid context")
            }
        }
    }

    val args: SearchResultListFragmentArgs by navArgs()
    private val sharedTopBarViewModel: TopBarViewModel by activityViewModels()

    // Binding object instance corresponding to the fragment_search_result_list.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentSearchResultListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val searchTerm = args.searchTerm
        val partOfSpeech = args.partOfSpeech
        val ignoreDiacritics = args.ignoreDiacritics

        binding = FragmentSearchResultListBinding.inflate(inflater, container, false)

        var bottomSearchButton: ImageView = binding!!.include2.buttonSearch
        bottomSearchButton.bringToFront()
        bottomSearchButton.setOnClickListener {
            val action = SearchResultListFragmentDirections.actionBottombarFragmentToHomeSearchFragment()
            findNavController().navigate(action)
        }

        sharedTopBarViewModel.mainText.observe(viewLifecycleOwner) { mainText ->
            binding!!.include1.header.setText(mainText)
        }

        sharedTopBarViewModel.altText.observe(viewLifecycleOwner) { altText ->
            binding!!.include1.subHeader.setText(altText)
        }

        sharedTopBarViewModel.definitions.observe(viewLifecycleOwner) { definitions ->
            binding!!.definitions.adapter = ListSelectionRecyclerViewAdapter(requireContext(), definitions)
        }

        binding!!.topbarViewModel = sharedTopBarViewModel
        binding!!.topbarViewModel!!.setIsLoading(true)

        val apiCaller: IApiCaller = getApiCaller("app")
        var totalFound: Int = 0;
        var definitions = mutableListOf<List<HtmlDefinition>>()

        GlobalScope.launch {
            val apiResponse = withContext(Dispatchers.Default) {
                apiCaller.getDefinitions(searchTerm, ignoreDiacritics, partOfSpeech)
            }

            for (result in apiResponse!!.results) {
                definitions.add(HtmlDefinitionParser.parse(result.embeddedDefinition))
            }

            totalFound = Integer.parseInt(apiResponse!!.totalEntriesFound);
            binding!!.topbarViewModel!!.setDefinitions(definitions)
            binding!!.topbarViewModel!!.setMainText("Results for \"${searchTerm}\"")
            binding!!.topbarViewModel!!.setAltText("${totalFound} results found")
            binding!!.topbarViewModel!!.setIsLoading(false)
        }

        binding!!.definitions.layoutManager = LinearLayoutManager(requireContext())
        binding!!.definitions.adapter = ListSelectionRecyclerViewAdapter(requireContext(), definitions)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner

            // Assign the view model to a property in the binding class
            topbarViewModel = sharedTopBarViewModel

            // Assign the fragment
            searchResultListFragment = this@SearchResultListFragment
        }
    }
}