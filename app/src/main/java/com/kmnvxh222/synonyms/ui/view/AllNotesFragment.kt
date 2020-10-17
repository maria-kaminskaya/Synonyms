package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.databinding.FragmentAllNotesBinding
import com.kmnvxh222.synonyms.ui.viewmodel.AllNotesViewModel

class AllNotesFragment : Fragment() {

    private lateinit var binding: FragmentAllNotesBinding
    private val main = this
    private lateinit var viewModel: AllNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        viewModel = AllNotesViewModel(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun buttonListener() {
        with(binding) {
            val visible = buttonDeleteAll.isVisible
            buttonEdit.setOnClickListener {
                buttonDeleteAll.isVisible = true
            }
            buttonPlus.setOnClickListener {
                findNavController(main).navigate(R.id.noteFragment)
            }
            buttonL.setOnClickListener {
                findNavController(main).navigate(R.id.favoritesLexemesFragment)
            }
            if (visible) {
                buttonDeleteAll.setOnClickListener {
                    viewModel.deleteAllNote()
                }
            }
        }
    }

}