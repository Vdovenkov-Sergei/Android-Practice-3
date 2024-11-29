package com.example.practice_3

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.practice_3.databinding.ItemViewBinding

class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var imageView: ImageView = binding.imageView
    var nameView: TextView = binding.nameView
    var btnWord: Button = binding.buttonWord
    var btnSound: Button = binding.buttonSound
}