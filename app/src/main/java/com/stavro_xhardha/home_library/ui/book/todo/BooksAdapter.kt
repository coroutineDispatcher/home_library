package com.stavro_xhardha.home_library.ui.book.todo

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.stavro_xhardha.home_library.R
import com.stavro_xhardha.home_library.model.Book
import com.stavro_xhardha.home_library.ui.book.TodoViewModelFactory
import kotlinx.android.synthetic.main.single_item_todo.view.*

class BooksAdapter(
    var list: List<Book>,
    var application: Application,
    var booksFragment: BooksFragment
) : RecyclerView.Adapter<BooksAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_item_todo,
                parent,
                false
            ),
            application, booksFragment
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) = holder.bind(list[position])


    class TodoViewHolder(itemView: View, application: Application, val booksFragment: BooksFragment) :
        RecyclerView.ViewHolder(itemView) {
        val app = application
        fun bind(book: Book) = with(itemView) {
            val viewModel = ViewModelProviders.of(
                booksFragment,
                TodoViewModelFactory(app)
            )
                .get(BookViewModel::class.java)
            single_item_title.text = book.title
            single_item_description.text = book.author
            single_item_type.text = book.type
            iv_delete_note.setOnClickListener { it ->
                viewModel.deleteNote(book)
            }
        }
    }
}