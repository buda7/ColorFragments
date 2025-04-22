package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment(R.layout.fragment_color) {

    companion object {
        var fragmentCount = 0

        fun newInstance(choice: Int): ColorFragment {
            val fragment = ColorFragment()
            fragment.arguments = Bundle().apply {
                putInt("COLOR CHOICE", choice)
            }
            return fragment
        }
    }

     var myIndex = 0
     val chosenColorTV: TextView?
        get() = view?.findViewById(R.id.mycolor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0

        when (choiceId) {
            1 -> {
                chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
            }
            else -> {
                chosenColorTV?.text = "UNKNOWN COLOR - UID $myIndex"
            }
        }
    }
}