package com.stavro_xhardha.todo.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.stavro_xhardha.todo.R
import kotlinx.android.synthetic.main.todo_fragment.*

class TodoFragment : Fragment() {

    private lateinit var todoViewModel: TodoViewModel

    companion object {
        fun newInstance() = TodoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.todo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        floatingActionButton.setOnClickListener { it ->
            openAddNotesFragment(it)
        }

        rv_notes.layoutManager = GridLayoutManager(activity, 2)

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)

//        todoViewModel.notesList.observe(this, Observer { notes ->
//            //todo add adapter
//
//        })

    }

    private fun openAddNotesFragment(view: View) {
        view.findNavController().navigate(R.id.addNewItemFragment)
    }
}
