package com.example.mygooglebook.List

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mygooglebook.databinding.ItemBookBinding
import com.example.mygooglebook.remote.data.ResponseBookData
import com.example.mygooglebook.remote.data.VolumeInfoList

class ListFragmentAdapter : ListAdapter<ResponseBookData, RecyclerView.ViewHolder>(itemDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return listItemViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is listItemViewHolder){
            val item = getItem(position).items[position]
            holder.bind(item.volumeInfo)
        }
    }

    class listItemViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(_item : VolumeInfoList){
            binding.item = _item
        }
    }

    private class itemDiffCallback : DiffUtil.ItemCallback<ResponseBookData>() {
        override fun areItemsTheSame(
            oldItem: ResponseBookData,
            newItem: ResponseBookData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResponseBookData,
            newItem: ResponseBookData
        ): Boolean {
            return oldItem == newItem
        }
    }
}