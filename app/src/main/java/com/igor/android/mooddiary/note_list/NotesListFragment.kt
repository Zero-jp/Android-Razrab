package com.igor.android.mooddiary.note_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteDatabase
import com.igor.android.mooddiary.databinding.FragmentItemListBinding
// import com.igor.android.mooddiary.databinding.FragmentNotesListBinding

class NotesListFragment : Fragment() {

    companion object {
        fun newInstance() = NotesListFragment()
    }

    private lateinit var viewModel: NotesListViewModel
    private lateinit var binding: FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_list, container, false)
        initializeViewModel()
//        initializeComponents()
        initializeRecycleViewAdapter()

        return binding.root
    }

    private fun initializeViewModel() {
        val application = requireNotNull(this.activity).application
        val dao = NoteDatabase.getInstance(application).getNoteDatabaseDao()
        val viewModelFactory = NotesListViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(NotesListViewModel::class.java)
    }

    private fun initializeRecycleViewAdapter() {
        var adapter = NotesAdapter()
        binding.notesList.adapter = adapter


        adapter.context = this.requireContext()

        viewModel.notes.observe(viewLifecycleOwner, Observer { notes ->
            if (notes != null) {
                adapter.data = notes
            }
        })

        // adapter.context = this.requireContext()
    }
}