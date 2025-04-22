package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceFragment.ChoiceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choiceId: Int) {
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(choiceId)

        supportFragmentManager.beginTransaction()
            .replace(fcv.id, colorFragment)
            .addToBackStack(null)
            .commit()
    }
}