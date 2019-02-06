package com.stavro_xhardha.todo.ui.todo.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stavro_xhardha.todo.R
import com.stavro_xhardha.todo.model.Note
import kotlinx.android.synthetic.main.single_item_todo.view.*

class TodoAdapter(var list: List<Note>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_item_todo,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) = holder.bind(list[position])


    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView) {
            single_item_title.text = note.title
            single_item_description.text = note.description
        }

    }
}