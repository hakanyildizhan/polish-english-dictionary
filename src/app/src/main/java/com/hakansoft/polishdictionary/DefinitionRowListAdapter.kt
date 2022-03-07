package com.hakansoft.polishdictionary

import android.content.Context
import android.text.SpannableString
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter;
import androidx.core.content.ContextCompat

public class DefinitionRowListAdapter(
    context: Context,
    resource: Int,
    objects: MutableList<SpannableString>
) : ArrayAdapter<SpannableString>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = super.getView(position, convertView, parent)
        if (position % 2 == 0) {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.red_light));
        }
        return view;
    }
}