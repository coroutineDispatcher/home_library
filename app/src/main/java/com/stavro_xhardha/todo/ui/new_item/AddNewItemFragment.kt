package com.stavro_xhardha.todo.ui.new_item

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.stavro_xhardha.todo.R

class AddNewItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddNewItemFragment()
    }

    private lateinit var viewModel: AddNewItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_new_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNewItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
