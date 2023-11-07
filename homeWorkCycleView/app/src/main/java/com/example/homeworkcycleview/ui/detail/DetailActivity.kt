package com.example.homeworkcycleview.ui.detail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.homeworkcycleview.databinding.ActivityDetailBinding
import java.net.HttpURLConnection
import java.net.URL


class DetailActivity : AppCompatActivity() {
    private val detailBinding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate((layoutInflater))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(detailBinding.root)
        var title_payload=intent.getStringExtra("details_title")
        var subtitle_payload=intent.getStringExtra("details_subTitle")
        var image = intent.getStringExtra("details_image")
        Glide.with(this).load(image).into(detailBinding.imageView);
        var imageAvatar = intent.getStringExtra("details_avatar")
        Glide.with(this).load(imageAvatar).into(detailBinding.imageAvatar);
        detailBinding.displayName.text = title_payload
        detailBinding.displaySubtitle.text = subtitle_payload

    }
}