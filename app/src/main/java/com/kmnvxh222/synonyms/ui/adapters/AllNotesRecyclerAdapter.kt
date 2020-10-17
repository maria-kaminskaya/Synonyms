package com.kmnvxh222.synonyms.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.model.locale.Note
import kotlinx.android.synthetic.main.item_note.view.*

class AllNotesRecyclerAdapter(private var note: List<Note>) :
    RecyclerView.Adapter<AllNotesRecyclerAdapter.NoteViewHolder>() {

    private lateinit var mItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view, mItemClickListener)
    }

    override fun getItemCount(): Int = note.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(note[position])

    class NoteViewHolder(itemView: View, private val mItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(note: Note) {
            itemView.textViewTitle.text = note.title
            itemView.textViewDate.text = note.date
        }

        override fun onClick(v: View) = mItemClickListener.onItemClick(v, adapterPosition)
    }

    fun updateList(noteList: List<Note>) {
        note = noteList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }

}
