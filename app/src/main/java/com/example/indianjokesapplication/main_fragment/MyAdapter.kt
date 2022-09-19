package com.example.indianjokesapplication.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.indianjokesapplication.databinding.SingleListItemBinding
import com.example.indianjokesapplication.joke_api.JokeDataClassItem

class MyAdapter : ListAdapter<JokeDataClassItem, MyAdapter.MyViewHolder>(MyDiffUtil()) {

    class MyDiffUtil : DiffUtil.ItemCallback<JokeDataClassItem>() {
        override fun areItemsTheSame(oldItem: JokeDataClassItem, newItem: JokeDataClassItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JokeDataClassItem, newItem: JokeDataClassItem): Boolean {
            return oldItem == newItem
        }

    }

    class MyViewHolder(private val binding: SingleListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun myBind(item: JokeDataClassItem?) {
            binding.xmlVariable = item
            binding.executePendingBindings()
        }
        companion object {
            fun myCreate(parent: ViewGroup): MyViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = SingleListItemBinding.inflate(inflater)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.myCreate(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.myBind(item)
    }




}
