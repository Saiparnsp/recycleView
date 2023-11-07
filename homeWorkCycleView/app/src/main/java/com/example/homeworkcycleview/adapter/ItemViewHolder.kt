package com.example.homeworkcycleview.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworkcycleview.databinding.ItemOfMainBinding
import com.example.homeworkcycleview.network.model.DataModel

class ItemViewHolder (private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val itemBinding get() = ItemOfMainBinding.bind(itemView)
    fun initView(data: DataModel, position: Int) {
        itemBinding.titleTextLabel.text = data.title
        itemBinding.subtitleTextLabel.text = data.subtitle
        Glide.with(context).load(data.youtubeImage).into(itemBinding.imageView);
        Glide.with(context).load(data.avatarImage).into(itemBinding.imageAvatar);
    }
}