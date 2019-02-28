package com.stavro_xhardha.home_library.ui.book.add_new_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.stavro_xhardha.home_library.R
import com.stavro_xhardha.home_library.model.Book
import kotlinx.android.synthetic.main.add_new_item_fragment.*

class AddNewItemFragment : Fragment() {

    private lateinit var viewModel: AddNewItemViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_new_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddText.setOnClickListener {
            if (!etTitle.text.toString().isEmpty() && !etDescription.text.toString().isEmpty()
                && !etType.text.toString().isEmpty()
            ) {
                viewModel.insertNote(
                    Book(
                        title = etTitle.text.toString(), author = etDescription.text.toString(),
                        type = etType.text.toString()
                    )
                )
                Toast.makeText(activity, R.string.book_added, Toast.LENGTH_LONG).show()
                etDescription.setText("")
                etTitle.setText("")
                etType.setText("")
            } else {
                Toast.makeText(activity, R.string.fill_all_data, Toast.LENGTH_LONG).show()
            }
            //Navigation.findNavController(view).popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(
            this,
            AddNewItemViewModelFactory(activity!!.application)
        ).get(AddNewItemViewModel::class.java)
    }

}
