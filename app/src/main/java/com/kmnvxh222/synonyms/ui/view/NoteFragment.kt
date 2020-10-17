package com.kmnvxh222.synonyms.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.databinding.FragmentNoteBinding
import com.kmnvxh222.synonyms.model.locale.Note
import com.kmnvxh222.synonyms.model.remote.Syn
import com.kmnvxh222.synonyms.ui.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_note.*
import java.text.SimpleDateFormat
import java.util.*


class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private val main = this
    private lateinit var viewModel: NoteViewModel
    private var argumentCheck: Boolean = false
    private var noteLocal: Note? = null
    private var noteArgument: Note? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        viewModel = NoteViewModel(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonListener()
        checkData()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkData() {
        if (arguments != null) {
            noteArgument = requireArguments().get("note") as? Note
            if (noteArgument != null) {
                binding.textViewDate.text = noteArgument!!.date
                binding.editText.append(noteArgument!!.content)
                argumentCheck = true
            } else {
                binding.textViewDate.text = getCurrentDate()
            }
        }
    }

    fun getWord(textOfTextView: String, offsetPosition: Int): String? {
        var endpositionofword = 0
        var startpositionofword = 0
        try {
            for (i in offsetPosition until textOfTextView.length) {
                if (i == textOfTextView.length) {
                    endpositionofword = i
                    break
                }
                if (textOfTextView[i] == ' ') {
                    endpositionofword = i
                    break
                }
            }
            for (i in offsetPosition downTo 0) {
                if (i == 0) {
                    startpositionofword = i
                    break
                }
                if (textOfTextView[i] == ' ') {
                    startpositionofword = i
                    break
                }
            }
            return textOfTextView.substring(startpositionofword, endpositionofword)
        } catch (e: RuntimeException) {
            return ""
        }
    }


    private fun setDialogLexeme(x: Float, y: Float, visibility: Boolean, text: String) {
        val syns = viewModel.getLexemeSyns(text)
        syns.observe(this, Observer<Syn?>() { syn ->
            if (syn != null) {
                val syns: List<String>? = syn.syns
                binding.dialogLexeme.isVisible = visibility
                binding.dialogLexeme.x = x
                binding.dialogLexeme.y = y + 350
                binding.textViewLexeme.text = text
                Log.d("setDialogLexeme", "syns $syns")
                if (syns != null) {
                    for (i in syns) {
                        binding.textViewSyns.append(i + "\n");
                    }
                }
                buttonDialogListener(text)
            }
        })
    }

    private fun buttonDialogListener(lexeme: String) {
        if (dialogLexeme.isVisible) {
            buttonCancel.setOnClickListener {
                binding.dialogLexeme.isVisible = false
            }
            buttonFavorites.setOnClickListener {
                val res = viewModel.addLexeme(lexeme)
                buttonFavorites.setBackgroundResource(R.drawable.ic_favorite)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun buttonListener() {
        with(binding) {
            buttonBack.setOnClickListener {
                if (argumentCheck && noteLocal != null) {
                    noteArgument?.content = noteLocal!!.content
                    noteArgument?.title = noteLocal!!.title
                    noteArgument?.date = noteLocal!!.date
                    viewModel.editNote(noteArgument!!)
                } else if (!argumentCheck && noteLocal != null) {
                    viewModel.addNewNote(noteLocal!!)
                }
                NavHostFragment.findNavController(main).popBackStack()
            }

            buttonDelete.setOnClickListener {
                viewModel.deleteNote(noteArgument!!)
            }

            val textWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    saveNote(s)
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    editText.setOnTouchListener { v, event ->
                        val layout: Layout? = (v as TextView).layout
                        val x = event.x.toInt()
                        val y = event.y.toInt()
                        if (layout != null) {
                            val line: Int = layout.getLineForVertical(y)
                            val offset: Int = layout.getOffsetForHorizontal(line, x.toFloat())
                            val text = s.toString()
                            val word = getWord(text, offset)
                            Log.v("getWord", "$word")
                            if (word != null) {
                                setDialogLexeme(event.x, event.y, true, word)
                            }

                        }
                        true
                    }


                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }
            }
            editText.addTextChangedListener(textWatcher)
        }

    }

    private fun saveNote(s: CharSequence?) {
        if (s != null) {
            var title: String = ""
            val content = s.toString()
            if (s.length > 10) {
                title = content.substring(0, 10)
            } else if (s.length < 10) {
                title = content
            }
            val date = getCurrentDate()
            noteLocal = Note(title, content, date)
        }
    }

    private fun getCurrentDate(): String {
        val currentDate = Date()
        val sdf = SimpleDateFormat("dd.MM.YYYY")
        val formattedDate: String = sdf.format(currentDate)
        return formattedDate
    }

}