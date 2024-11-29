package com.example.practice_3

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_3.databinding.ItemViewBinding

class MyAdapter(
    private val context: Context,
    private val items: ArrayList<AnimalItem>
): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.nameView.text = item.name
        holder.imageView.setImageResource(item.image)
        holder.btnWord.setOnClickListener { playSound(item.animalWord) }
        holder.btnSound.setOnClickListener { playSound(item.animalSound) }
    }

    private fun playSound(soundResId: Int) {
        val mediaPlayer = MediaPlayer.create(context, soundResId)
        mediaPlayer?.apply {
            start()
            setOnCompletionListener { release() }
        } ?: run {
            println("Error: cannot play sound with id '$soundResId'")
        }
    }
}