package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.databinding.FragmentFavoritesLexemesBinding
import com.kmnvxh222.synonyms.ui.viewmodel.FavoritesViewModel

class FavoritesLexemesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesLexemesBinding
    private val main = this
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesLexemesBinding.inflate(inflater, container, false)
        viewModel = FavoritesViewModel(requireContext())
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
            buttonNotes.setOnClickListener {
                NavHostFragment.findNavController(main).navigate(R.id.allNotesFragment)
            }
            if (visible) {
                buttonDeleteAll.setOnClickListener {
                    viewModel.deleteAll()
                }
            }
        }
    }
}