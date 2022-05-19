package com.igor.android.mooddiary.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteDatabase
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.databinding.FragmentNewNoteBinding
import com.igor.android.mooddiary.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding

//    private val noteDatabaseDao = NoteDatabaseDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater, R.layout.fragment_title, container, false
        )

//        if (noteDatabaseDao.getAll() == null){
//            binding.listOpenBtn.visibility = View.GONE
//        }

        binding.listOpenBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment2_to_itemFragment)
        }
        binding.newNoteBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment2_to_newNoteFragment)
        }
        binding.statOpenBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment2_to_statisticFragment)
        }

        return binding.root
    }
}