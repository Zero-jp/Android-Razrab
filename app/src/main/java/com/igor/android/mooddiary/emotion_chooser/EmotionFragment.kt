package com.igor.android.mooddiary.emotion_chooser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteDatabase
import com.igor.android.mooddiary.database.NoteInfo
import com.igor.android.mooddiary.databinding.FragmentChooseEmotionBinding
import com.igor.android.mooddiary.new_note.NewNoteViewModel
import com.igor.android.mooddiary.new_note.NewNoteViewModelFactory


class EmotionFragment : Fragment() {
    private lateinit var viewModel: EmotionViewModel
    private lateinit var binding: FragmentChooseEmotionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_choose_emotion, container, false)

        val application = requireActivity().application
        val dao = NoteDatabase.getInstance(application).getNoteDatabaseDao()
        val viewModelFactory = EmotionModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EmotionViewModel::class.java)



        binding.apply {
            var emoRange = 0
            happyLay.setOnClickListener {
                viewModel.onSaveNote(emoRange)
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
            normalLay.setOnClickListener {
                emoRange = 1
                viewModel.onSaveNote(emoRange)
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
            unhappyLay.setOnClickListener {
                emoRange = 2
                viewModel.onSaveNote(emoRange)
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
//            buttonBack.setOnClickListener {
//                // viewModel.saveData()
//                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_newNoteFragment)
//            }
        }

//        binding.buttonBack.setOnClickListener {
//            // viewModel.saveData()
//            Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_newNoteFragment)
//        }

        return binding.root
    }
}