package com.stavro_xhardha.todo.ui.todo.add_new_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.stavro_xhardha.todo.R
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.ui.todo.TodoViewModelFactory
import kotlinx.android.synthetic.main.add_new_item_fragment.*

class AddNewItemFragment : Fragment() {

    private lateinit var viewModel: AddNewItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_new_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddText.setOnClickListener {
            viewModel.insertNote(Note(title = etTitle.text.toString(), description = etDescription.text.toString()))
            Navigation.findNavController(view).popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this,
            TodoViewModelFactory(activity!!.application)
        ).get(AddNewItemViewModel::class.java)
    }

}
