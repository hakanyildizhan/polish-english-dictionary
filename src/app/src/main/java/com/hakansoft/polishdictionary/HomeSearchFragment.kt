package com.hakansoft.polishdictionary

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class HomeSearchFragment : Fragment() {

    val args: HomeSearchFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var focusOnSearchbox: Boolean = args.focusOnSearchbox

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_search, container, false)

        var bottomSearchHistoryButton: ImageView = view.findViewById(R.id.button_search_history)
        bottomSearchHistoryButton.bringToFront()
        bottomSearchHistoryButton.setOnClickListener {
            val action = HomeSearchFragmentDirections.actionHomeSearchFragmentToSearchHistoryFragment()
            findNavController().navigate(action)
        }


        var searchButton: Button = view.findViewById<Button>(R.id.button_search);
        searchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val partOfSpeechSpinner: Spinner = view.findViewById(R.id.spinner_partofspeech)
                val partOfSpeech = partOfSpeechSpinner.selectedItem.toString()
                val searchTermEditText : EditText = view.findViewById(R.id.search_box)
                val searchTerm = searchTermEditText.text.toString().trim()
                val action = HomeSearchFragmentDirections.searchAction(searchTerm, partOfSpeech)
                Utility.prepareWindow(requireActivity().getWindow(), context!!)

                // save to search history
                val application = requireNotNull(v!!.findFragment<Fragment>().activity).application
                val dao = DictionaryDb.getInstance(application).searchHistoryDao
                val viewModelFactory = SearchHistoryViewModelFactory(dao)
                val viewModel = ViewModelProvider(v!!.findFragment<Fragment>(), viewModelFactory).get(SearchHistoryViewModel::class.java)
                viewModel.addSearchedWord(searchTerm)

                view.findNavController().navigate(action)
            }
        })

        var searchBox = view.findViewById<EditText>(R.id.search_box)
        if (focusOnSearchbox) {
            searchBox.requestFocus()
            val imm: InputMethodManager? = requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm!!.toggleSoftInput(
                InputMethodManager.HIDE_IMPLICIT_ONLY,0
            )
        }

        searchBox.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchButton.callOnClick()
                return@OnEditorActionListener true
            }
            false
        })

        return view
    }
}