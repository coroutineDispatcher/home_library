package com.stavro_xhardha.home_library.ui.book.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.stavro_xhardha.home_library.R
import com.stavro_xhardha.home_library.ui.book.TodoViewModelFactory
import kotlinx.android.synthetic.main.todo_fragment.*

class BooksFragment : Fragment() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.todo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        fab_add_new_note.setOnClickListener {
            navController.navigate(R.id.addNewItemFragment, null)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_notes.layoutManager = LinearLayoutManager(activity)

        bookViewModel = ViewModelProviders.of(
            this,
            TodoViewModelFactory(activity!!.application)
        )
            .get(BookViewModel::class.java)

        bookViewModel.notesList.observe(this, Observer { notes ->
            rv_notes.adapter = BooksAdapter(notes, activity!!.application , this)

        })

    }
}
