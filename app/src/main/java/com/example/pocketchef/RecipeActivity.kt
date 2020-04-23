package com.example.pocketchef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.ArrayAdapter
import android.widget.Button
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

        val timerButton = findViewById<Button>(R.id.timerButton)
        timerButton.setOnClickListener{
            val intent = Intent(AlarmClock.ACTION_SET_TIMER)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
            startActivity(intent)
        }


    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
