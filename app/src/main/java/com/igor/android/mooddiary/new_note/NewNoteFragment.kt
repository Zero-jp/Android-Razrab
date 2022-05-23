package com.igor.android.mooddiary.new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteDatabase
import com.igor.android.mooddiary.database.NoteInfo
import com.igor.android.mooddiary.database.TimeRange
import com.igor.android.mooddiary.databinding.FragmentNewNoteBinding

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

    private lateinit var viewModel: NewNoteViewModel
    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireActivity().application
        val dao = NoteDatabase.getInstance(application).getNoteDatabaseDao()
        val viewModelFactory = NewNoteViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewNoteViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note, container, false)

        binding.emotionChooserBtn.setOnClickListener {
            var noteInfo = NoteInfo()
            noteInfo = getNoteInfoFromView(noteInfo)
            viewModel.onEmotionChooser(noteInfo)
            Navigation.findNavController(it).navigate(R.id.action_newNoteFragment_to_blankFragment)
        }

        initializeComponents()

        return binding.root
    }

    fun getNoteInfoFromView(noteInfo: NoteInfo): NoteInfo{
        noteInfo.date = binding.editTextDate.text.toString()
        noteInfo.timeRange = binding.spinnerTimeRange.selectedItemPosition
        noteInfo.body = binding.editTextMultiLineNoteBody.text.toString()
        System.out.println(noteInfo.date)
        System.out.println(noteInfo.timeRange)
        System.out.println(noteInfo.body)

//        if (dataCheck(noteInfo))
//            return noteInfo
//        else
//            // Вы ввели какое-то дерьмо
        return noteInfo
    }

    private fun dataCheck(noteInfo: NoteInfo): Boolean{
        if (noteInfo.date.isEmpty())
            return false

        if (noteInfo.body.isEmpty())
            return false

        if (noteInfo.timeRange > 4 || noteInfo.timeRange < 0)
            return false

        return true
    }

    private fun initializeComponents() {

        binding.spinnerTimeRange.adapter = ArrayAdapter<String>(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            TimeRange.values().map { it.getLabel(this.requireContext()) }
        )
    }
}