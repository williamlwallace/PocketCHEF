package com.example.pocketchef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        recipes.add(Recipe("Spaghetti Bolognese"))
        recipes.add(Recipe("Chicken and Mushroom Fettucine"))
        recipes.add(Recipe("Beef Vindaloo"))
        recipes.add(Recipe("Chilli Con Carne"))
        recipes.add(Recipe("Sheperd's Pie"))
        recipes.add(Recipe("Spicy Miso Ramen"))

        val adapter = CustomAdapter(recipes)

        recyclerView.adapter = adapter
    }
}
