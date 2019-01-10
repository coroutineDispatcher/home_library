package com.stavro_xhardha.todo.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.stavro_xhardha.todo.R
import com.stavro_xhardha.todo.ui.TodoViewModelFactory
import kotlinx.android.synthetic.main.todo_fragment.*

class TodoFragment : Fragment() {

    private lateinit var todoViewModel: TodoViewModel

    companion object {
        fun newInstance() = TodoFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.todo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        floatingActionButton.setOnClickListener {
            navController.navigate(R.id.addNewItemFragment, null)
            floatingActionButton.hide()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_notes.layoutManager = GridLayoutManager(activity, 2)

        todoViewModel = ViewModelProviders.of(this, TodoViewModelFactory(activity!!.application))
            .get(TodoViewModel::class.java)

        todoViewModel.notesList.observe(this, Observer { notes ->
            //todo add adapter

        })

    }
}
