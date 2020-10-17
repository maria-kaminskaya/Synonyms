package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.kmnvxh222.synonyms.databinding.FragmentLexemeBinding
import com.kmnvxh222.synonyms.ui.viewmodel.LexemeViewModel

class LexemeFragment : Fragment() {

    private lateinit var binding: FragmentLexemeBinding
    private val main = this
    private lateinit var viewModel: LexemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLexemeBinding.inflate(inflater, container, false)
        viewModel = LexemeViewModel(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun buttonListener() {
        with(binding) {
            buttonBack.setOnClickListener {
                NavHostFragment.findNavController(main).popBackStack()
            }
            buttonDelete.setOnClickListener {
//                viewModel.deleteLexeme()
            }
        }
    }

}