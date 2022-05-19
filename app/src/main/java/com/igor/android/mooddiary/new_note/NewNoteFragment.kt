package com.igor.android.mooddiary.new_note

import android.os.Bundle
import android.os.Parcel
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import com.igor.android.mooddiary.database.NoteInfo.Companion.write
import com.igor.android.mooddiary.databinding.FragmentNewNoteBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NewNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewNoteFragment : Fragment() {

//    private lateinit var viewModel: NewNoteViewModel
//
//    private lateinit var binding: FragmentNewNoteBinding
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note, container, false)
//
//        viewModel = ViewModelProvider(this).get(NewNoteViewModel::class.java)
//
//        binding.emotionChooserBtn.setOnClickListener {
//            // dateField = viewModel.
//            Navigation.findNavController(it).navigate(R.id.action_newNoteFragment_to_blankFragment)
//        }
//
//        return binding.root
//    }

    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note, container, false)

        binding.emotionChooserBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_newNoteFragment_to_blankFragment)
        }

        return binding.root
    }
}