package com.example.mygooglebook.List

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mygooglebook.Home.HomeViewPagerFragmenttDirections
import com.example.mygooglebook.R
import com.example.mygooglebook.databinding.ItemBookBinding
import com.example.mygooglebook.remote.data.Items
import com.example.mygooglebook.remote.data.ResponseBookData
import com.example.mygooglebook.remote.data.VolumeInfoList

class BookListFragmentAdapter : ListAdapter<Items, RecyclerView.ViewHolder>(itemDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return listItemViewHolder(ItemBookBinding.inflate
            (LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is listItemViewHolder){
            holder.bind(getItem(position).volumeInfo)
        }
    }

    class listItemViewHolder(
        private val binding: ItemBookBinding
        ): RecyclerView.ViewHolder(binding.root){

        private val defultImageUrl = "http://books.google.com/books/content?id=zyTCAlFPjgYC&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE70dbJVqfph7hFRlBelX2W4NbzCOZhPnAi3ZUz2JsAXeJllqy2stxPmBMzgtjvSAH3zUeYT4v5dKXuS77WAocFvefV6RXfbZ0ZmEW3uVgmMaj6a2I3otrNEBOQJziNBmQiXLHa6-&source=gbs_api"
        private val defultDescription = "Notting Description.. sorry"
        private val defultTitle = "Noting"

        init {
            binding.setClickListener {
                binding.item?.let { item ->
                    navigateToItem(item,it)
                }
            }
        }

        private fun navigateToItem(
            item : VolumeInfoList?,
            view : View
        ){
            val directions =
                HomeViewPagerFragmenttDirections.actionViewPagerFragmentToBookDetail(
                    item?.title ?: defultTitle,
                    item?.imageLinks?.smallThumbnail ?: defultImageUrl,
                    item?.description ?: defultDescription)
            view.findNavController().navigate(directions)
        }

        fun bind(_item : VolumeInfoList){
            binding.item = _item
        }
    }

    private class itemDiffCallback : DiffUtil.ItemCallback<Items>() {


        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }
    }
}