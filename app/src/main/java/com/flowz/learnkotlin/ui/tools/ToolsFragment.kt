package com.flowz.learnkotlin.ui.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.flowz.learnkotlin.R
import kotlinx.android.synthetic.main.fragment_tools.view.*
import kotlinx.android.synthetic.main.nav_header_main3.view.*

class ToolsFragment : Fragment() {

    private lateinit var toolsViewModel: ToolsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_tools, container, false)

        val textView: TextView = root.findViewById(R.id.text_tools)

        toolsViewModel.text.observe(this, Observer { textView.text = it })

        textView.setOnClickListener {
            findNavController().navigate(R.id.action_nav_tools_to_testingFragment)
        }



        return root
    }
}