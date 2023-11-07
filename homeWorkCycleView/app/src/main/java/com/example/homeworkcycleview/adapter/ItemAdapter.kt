package com.example.homeworkcycleview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import com.example.homeworkcycleview.R
import com.example.homeworkcycleview.network.model.DataModel
import com.example.homeworkcycleview.ui.detail.DetailActivity

class ItemAdapter(private val context: Context) : ListAdapter<DataModel, ItemViewHolder>(DiffUtil()) {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_of_main, parent, false)
        return ItemViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = getItem(position)
        holder.initView(data, position)
        holder.itemView.setOnClickListener {
            val intent : Intent = Intent(context,DetailActivity::class.java).apply {
                putExtra(TITLE_CONTENT,data.title)
                putExtra(SUBTITLE_CONTENT,data.subtitle)
                putExtra(IMAGE_CONTENT,data.youtubeImage)
                putExtra(AVATAR_CONTENT,data.avatarImage)
            }
            context.startActivity(intent)
        }
    }
    companion object{
        val TITLE_CONTENT="details_title"
        val SUBTITLE_CONTENT="details_subTitle"
        val IMAGE_CONTENT="details_image"
        val AVATAR_CONTENT="details_avatar"
    }
}