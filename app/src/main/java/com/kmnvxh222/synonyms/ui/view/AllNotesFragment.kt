package com.kmnvxh222.synonyms.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.databinding.FragmentAllNotesBinding
import com.kmnvxh222.synonyms.model.locale.Note
import com.kmnvxh222.synonyms.ui.adapters.AllNotesRecyclerAdapter
import com.kmnvxh222.synonyms.ui.viewmodel.AllNotesViewModel

class AllNotesFragment : Fragment() {


    private var listNotes: List<Note> = ArrayList()
    private lateinit var binding: FragmentAllNotesBinding
    private val main = this
    private lateinit var viewModel: AllNotesViewModel
    private lateinit var adapter: AllNotesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllNotesBinding.inflate(inflater, container, false)
        viewModel = AllNotesViewModel(requireContext())
        adapterInitialisation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun adapterInitialisation() {

        Log.d("AllNotesFragment", "adapterInitialisation")
        val notes = viewModel.getAllNotes()
        notes?.observe(viewLifecycleOwner, Observer<List<Note>>() { note ->
            listNotes = note
            Log.d("AllNotesFragment", "observe $note $listNotes")
            adapter = AllNotesRecyclerAdapter(note)
            adapter.setOnItemClickListener(adapterClickListener)
            binding.recyclerViewNotes.let { it ->
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }
        })

    }

    private val adapterClickListener = object : AllNotesRecyclerAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            val bundle = bundleOf("note" to listNotes[position])
            findNavController(main).navigate(R.id.noteFragment, bundle)
        }
    }

    private fun buttonListener() {
        with(binding) {
            buttonEdit.setOnClickListener {
                buttonDeleteAll.isVisible = true
            }
            buttonPlus.setOnClickListener {
                findNavController(main).navigate(R.id.noteFragment)
            }
            buttonL.setOnClickListener {
                findNavController(main).navigate(R.id.favoritesLexemesFragment)
            }
            buttonDeleteAll.setOnClickListener {
                viewModel.deleteAllNote()
                adapter.notifyDataSetChanged()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapterInitialisation()
    }

}