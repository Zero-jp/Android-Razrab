package com.igor.android.mooddiary.emotion_chooser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.databinding.FragmentChooseEmotionBinding


class EmotionFragment : Fragment() {
    private lateinit var binding: FragmentChooseEmotionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_choose_emotion, container, false)

        // viewModel = ViewModelProvider(this).get(NewNoteViewModel::class.java)



        binding.apply {
            happyLay.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
            normalLay.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
            unhappyLay.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_titleFragment2)
            }
            buttonBack.setOnClickListener {
                // viewModel.saveData()
                Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_newNoteFragment)
            }
        }

        binding.buttonBack.setOnClickListener {
            // viewModel.saveData()
            Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_newNoteFragment)
        }

        return binding.root
    }
}