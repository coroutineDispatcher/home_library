package com.stavro_xhardha.todo.ui.todo.todo

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.stavro_xhardha.todo.R
import com.stavro_xhardha.todo.model.Note
import com.stavro_xhardha.todo.ui.todo.TodoViewModelFactory
import kotlinx.android.synthetic.main.single_item_todo.view.*

class TodoAdapter(
    var list: List<Note>,
    var application: Application,
    var todoFragment: TodoFragment
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_item_todo,
                parent,
                false
            ),
            application, todoFragment
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) = holder.bind(list[position])


    class TodoViewHolder(itemView: View, application: Application, val todoFragment: TodoFragment) :
        RecyclerView.ViewHolder(itemView) {
        val app = application
        fun bind(note: Note) = with(itemView) {
            val viewModel = ViewModelProviders.of(
                todoFragment,
                TodoViewModelFactory(app)
            )
                .get(TodoViewModel::class.java)
            single_item_title.text = note.title
            single_item_description.text = note.author
            single_item_type.text = note.type
            iv_delete_note.setOnClickListener { it ->
                viewModel.deleteNote(note)
            }
        }
    }
}