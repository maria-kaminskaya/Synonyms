package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.kmnvxh222.synonyms.databinding.FragmentLexemeBinding
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.ui.viewmodel.LexemeViewModel

class LexemeFragment : Fragment() {

    private lateinit var binding: FragmentLexemeBinding
    private val main = this
    private lateinit var viewModel: LexemeViewModel
    private var lexemeArgument: Lexeme? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLexemeBinding.inflate(inflater, container, false)
        viewModel = LexemeViewModel(requireContext())
        checkData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkData() {
        lexemeArgument = requireArguments().get("lexeme") as Lexeme
        binding.textViewLexeme.text = lexemeArgument!!.lexeme
        getSyns(lexemeArgument!!.lexeme)

    }

    private fun buttonListener() {
        with(binding) {
            buttonBack.setOnClickListener {
                NavHostFragment.findNavController(main).popBackStack()
            }
            buttonDelete.setOnClickListener {
                viewModel.deleteLexeme(lexemeArgument!!)
            }
        }
    }

    private fun getSyns(text: String){
        val syns = viewModel.getLexemeSyns(text)
        syns.observe(viewLifecycleOwner, Observer<Syn?>() { syn ->
            if (syn != null) {
                val syns: List<String>? = syn.syns
                if (syns != null) {
                    for (i in syns){
                        binding.textViewSyns.append(i+"\n")
                    }
                }
            }
        })
    }
}