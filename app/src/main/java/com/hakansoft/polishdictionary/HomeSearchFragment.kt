package com.hakansoft.polishdictionary

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeSearchFragment : Fragment() {
    //private lateinit var binding: FragmentHomeSearchBinding
    //private lateinit var searchViewModel: HomeSearchViewModel

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        searchViewModel = ViewModelProvider(this).get(HomeSearchViewModel::class.java)
        binding = FragmentHomeSearchBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = searchViewModel

        var view = binding.root
        return view
        */

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_search, container, false)

        var searchButton: Button = view.findViewById<Button>(R.id.button_search);
        searchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val partOfSpeechSpinner: Spinner = view.findViewById(R.id.spinner_partofspeech)
                val partOfSpeech = partOfSpeechSpinner.selectedItem.toString()
                val searchTermEditText : EditText = view.findViewById(R.id.search_box)
                val searchTerm = searchTermEditText.text.toString()
                val action = HomeSearchFragmentDirections.searchAction(searchTerm, partOfSpeech)
                view.findNavController().navigate(action)
            }
        })

        return view
    }

    /*
    fun search(view: View) {
        val partOfSpeechSpinner: Spinner = requireView().findViewById(R.id.spinner_partofspeech)
        val partOfSpeech = partOfSpeechSpinner.selectedItem.toString()
        val searchTermEditText : EditText = requireView().findViewById(R.id.search_box)
        val searchTerm = searchTermEditText.text.toString()
        val action = HomeSearchFragmentDirections.searchAction(searchTerm, partOfSpeech)
        view.findNavController().navigate(action)
    }

     */
}