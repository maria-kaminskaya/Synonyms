package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.databinding.FragmentFavoritesLexemesBinding
import com.kmnvxh222.synonyms.model.locale.Lexeme
import com.kmnvxh222.synonyms.model.locale.Note
import com.kmnvxh222.synonyms.ui.adapters.AllNotesRecyclerAdapter
import com.kmnvxh222.synonyms.ui.adapters.LexemesRecyclerAdapter
import com.kmnvxh222.synonyms.ui.viewmodel.FavoritesViewModel

class FavoritesLexemesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesLexemesBinding
    private val main = this
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var adapter: LexemesRecyclerAdapter
    private var listLexemes: List<Lexeme> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesLexemesBinding.inflate(inflater, container, false)
        viewModel = FavoritesViewModel(requireContext())
        adapterInitialisation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun adapterInitialisation(){
        val lexemes = viewModel.getAllLexemes()
        lexemes?.observe(viewLifecycleOwner, Observer<List<Lexeme>?>(){ lexeme->
            listLexemes = lexeme
            adapter = LexemesRecyclerAdapter(lexeme)
            adapter.setOnItemClickListener(adapterClickListener)
            binding.recyclerViewLexemes.let { it ->
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }
        })

    }

    private val adapterClickListener = object : LexemesRecyclerAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            val bundle = bundleOf("lexeme" to listLexemes[position])
            NavHostFragment.findNavController(main).navigate(R.id.lexemeFragment, bundle)
        }
    }

    private fun buttonListener() {
        with(binding) {
            buttonEdit.setOnClickListener {
                buttonDeleteAll.isVisible = true
            }
            buttonNotes.setOnClickListener {
                NavHostFragment.findNavController(main).navigate(R.id.allNotesFragment)
            }
                buttonDeleteAll.setOnClickListener {
                    viewModel.deleteAll()
                    adapter.notifyDataSetChanged()

            }
        }
    }
}