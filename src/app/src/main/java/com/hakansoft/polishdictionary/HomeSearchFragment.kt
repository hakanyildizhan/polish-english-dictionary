package com.hakansoft.polishdictionary

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass.
 * Use the [HomeSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeSearchFragment : Fragment() {

    val args: HomeSearchFragmentArgs by navArgs()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var focusOnSearchbox: Boolean = args.focusOnSearchbox

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
                Utility.prepareWindow(getActivity()!!.getWindow(), context!!)
                view.findNavController().navigate(action)
            }
        })

        var searchBox = view.findViewById<EditText>(R.id.search_box)
        if (focusOnSearchbox) {
            searchBox.requestFocus()
            val imm: InputMethodManager? = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
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