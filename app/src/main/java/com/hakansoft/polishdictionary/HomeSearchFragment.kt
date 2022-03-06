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

/**
 * A simple [Fragment] subclass.
 * Use the [HomeSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeSearchFragment : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
}