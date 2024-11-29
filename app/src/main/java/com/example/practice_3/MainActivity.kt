package com.example.practice_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resIdImage = arrayListOf(R.drawable.cat, R.drawable.cow, R.drawable.dog, R.drawable.goat,
                                    R.drawable.horse, R.drawable.mouse, R.drawable.parrot,
                                    R.drawable.raccoon, R.drawable.sheep, R.drawable.wolf)

        val resIdWord = arrayListOf(R.raw.cat, R.raw.cow, R.raw.dog, R.raw.goat,
                                    R.raw.horse, R.raw.mouse, R.raw.parrot,
                                    R.raw.raccoon, R.raw.sheep, R.raw.wolf)

        val resIdSound = arrayListOf(R.raw.sound_cat, R.raw.sound_cow, R.raw.sound_dog,
                                    R.raw.sound_goat, R.raw.sound_horse, R.raw.sound_mouse,
                                    R.raw.sound_parrot, R.raw.sound_raccoon, R.raw.sound_sheep,
                                    R.raw.sound_wolf)

        val items: ArrayList<AnimalItem> = ArrayList()
        assets.open("animals.txt").bufferedReader().use { reader ->
            for ((i, name) in reader.readLines().withIndex()) {
                items.add(AnimalItem(name, resIdImage[i], resIdWord[i], resIdSound[i]))
            }
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(applicationContext, items)
    }
}