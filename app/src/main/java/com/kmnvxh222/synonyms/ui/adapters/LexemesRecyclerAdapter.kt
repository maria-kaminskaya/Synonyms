package com.kmnvxh222.synonyms.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.synonyms.R
import com.kmnvxh222.synonyms.model.locale.Lexeme
import kotlinx.android.synthetic.main.item_favorite_lexeme.view.*

class LexemesRecyclerAdapter(private var lexeme: List<Lexeme>) :
    RecyclerView.Adapter<LexemesRecyclerAdapter.LexemeViewHolder>() {

    private lateinit var mItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LexemeViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_lexeme, parent, false)
        return LexemeViewHolder(view, mItemClickListener)
    }

    override fun getItemCount(): Int = lexeme.size

    override fun onBindViewHolder(holder: LexemeViewHolder, position: Int) =
        holder.bind(lexeme[position])

    class LexemeViewHolder(itemView: View, private val mItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(lexeme: Lexeme) {
            itemView.favoriteLexeme.text = lexeme.lexeme
        }

        override fun onClick(v: View) = mItemClickListener.onItemClick(v, adapterPosition)
    }

    fun updateList(lexemeList: List<Lexeme>) {
        lexeme = lexemeList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }

}
