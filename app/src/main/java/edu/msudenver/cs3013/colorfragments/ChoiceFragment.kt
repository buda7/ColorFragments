package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment(R.layout.fragment_choice) {

     var choiceListener: ChoiceListener? = null

    interface ChoiceListener {
        fun onSelected(choice: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement ChoiceListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val redT = view.findViewById<TextView>(R.id.redText)
        val blueT = view.findViewById<TextView>(R.id.blueText)

        redT.setOnClickListener {
            choiceListener?.onSelected(2)
        }

        blueT.setOnClickListener {
            choiceListener?.onSelected(1)
        }
    }
}