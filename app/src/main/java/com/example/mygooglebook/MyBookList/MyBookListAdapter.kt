package com.example.mygooglebook.MyBookList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mygooglebook.database.Book
import com.example.mygooglebook.databinding.ItemMyBookBinding

class MyBookListAdapter : ListAdapter<Book,RecyclerView.ViewHolder>(itemDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemBindingViewHolder(ItemMyBookBinding.inflate
            (LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemBindingViewHolder){
            holder.bind(getItem(position))
        }
    }

    class ItemBindingViewHolder(
        private val binding: ItemMyBookBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(_item : Book){
            binding.item = _item
        }
    }


    private class itemDiffCallBack : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }

}