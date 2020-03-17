package com.example.pocketchef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val recipes = ArrayList<Recipe>()

        recipes.add(Recipe("Spaghetti Bolognese", 30, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))
        recipes.add(Recipe("Chicken and Mushroom Fettucine",50, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))
        recipes.add(Recipe("Beef Vindaloo", 45, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))
        recipes.add(Recipe("Chilli Con Carne", 40, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))
        recipes.add(Recipe("Sheperd's Pie",90, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))
        recipes.add(Recipe("Spicy Miso Ramen", 60, arrayListOf("Spaghetti", "Mince"), arrayListOf("Blah", "blah")))

        val adapter = CustomAdapter(recipes)

        recyclerView.adapter = adapter
    }
}
