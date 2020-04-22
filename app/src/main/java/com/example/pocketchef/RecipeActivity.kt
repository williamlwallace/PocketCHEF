package com.example.pocketchef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val recipe = intent.getSerializableExtra("recipe") as Recipe
        val recipeName = findViewById<TextView>(R.id.title)
        val recipeTime = findViewById<TextView>(R.id.time)
        val recipeIngredients = findViewById<ListView>(R.id.ingredientList)
        val recipeMethod = findViewById<ListView>(R.id.methodList)
        recipeName.text = recipe.name
        recipeTime.text = recipe.time + " minutes"

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipe.ingredients)
        val arrayAdapter2: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipe.method)
        recipeIngredients.adapter = arrayAdapter
        recipeMethod.adapter = arrayAdapter2




    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
