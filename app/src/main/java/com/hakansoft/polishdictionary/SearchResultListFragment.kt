package com.hakansoft.polishdictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import com.hakansoft.polishdictionary.databinding.FragmentSearchResultListBinding

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

        val apiCaller: IApiCaller = getApiCaller("app")
        var apiResponse = apiCaller.getDefinitions(searchTerm, ignoreDiacritics, partOfSpeech)

        var definitions = mutableListOf<List<HtmlDefinition>>()
        for (result in apiResponse!!.results) {
            definitions.add(HtmlDefinitionParser.parse(result.embeddedDefinition))
        }

        binding = FragmentSearchResultListBinding.inflate(inflater, container, false)

        sharedTopBarViewModel.mainText.observe(viewLifecycleOwner) { mainText ->
            binding!!.include1.header.setText(mainText)
        }

        sharedTopBarViewModel.altText.observe(viewLifecycleOwner) { altText ->
            binding!!.include1.subHeader.setText(altText)
        }

        sharedTopBarViewModel.setMainText("Results for \"${searchTerm}\"")
        sharedTopBarViewModel.setAltText("${apiResponse!!.totalEntriesFound} results found")

        return binding!!.root

        //R.layout.fragment_topbar.

        //val listview: ListView? = view?.findViewById(R.id.definitions);

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_search_result_list, container, false)
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