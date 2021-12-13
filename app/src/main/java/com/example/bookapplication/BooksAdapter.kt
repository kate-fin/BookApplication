package com.example.bookapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.models.BookModel

class BooksAdapter(private val books: List<BookModel>): RecyclerView.Adapter<BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_book, parent, false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(position: Int): BookModel{
        return books[position]
    }

    override fun getItemCount(): Int {
        return books.size
    }
}

class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView = itemView.findViewById(R.id.bookTitle)
    private val authorView: TextView = itemView.findViewById(R.id.bookAuthor)

    fun bind(book: BookModel){
        titleView.text = book.title
        authorView.text = book.author

    }
}