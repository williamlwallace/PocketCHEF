package com.example.pocketchef

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.*
import com.example.pocketchef.MainActivity.GlobalVariable.recipes
import com.google.firebase.database.*
import com.google.gson.Gson

class AddRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        var ingredientList = arrayListOf<String>()
        var ingredientAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredientList)

        var ingredient = findViewById<EditText>(R.id.ingredient)
        var ingredientListView = findViewById<ListView>(R.id.ingredientList)

        var methodList = arrayListOf<String>()
        var methodAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, methodList)

        var method = findViewById<EditText>(R.id.method)
        var methodListView = findViewById<ListView>(R.id.methodList)

        // Adding ingredient on enter press
        ingredient.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                ingredientList.add(ingredient.text.toString())
                ingredientListView.adapter = ingredientAdapter
                ingredientAdapter.notifyDataSetChanged()
                ingredient.text.clear()

                return@OnKeyListener true
            }
            false
        })

        // Removing ingredient on press
        ingredientListView.setOnItemLongClickListener(object: AdapterView.OnItemLongClickListener {
            override fun onItemLongClick(adapterView:AdapterView<*>, view:View, i:Int, l:Long):Boolean {
                ingredientList.removeAt(i)
                ingredientAdapter.notifyDataSetChanged()
                return true
            }
        })

        // Adding method on enter press
        method.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                methodList.add(method.text.toString())
                methodListView.adapter = methodAdapter
                methodAdapter.notifyDataSetChanged()
                method.text.clear()

                return@OnKeyListener true
            }
            false
        })

        // Removing method on press
        methodListView.setOnItemLongClickListener(object: AdapterView.OnItemLongClickListener {
            override fun onItemLongClick(adapterView:AdapterView<*>, view:View, i:Int, l:Long):Boolean {
                methodList.removeAt(i)
                methodAdapter.notifyDataSetChanged()
                return true
            }
        })

        // Add recipe
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{

            val recipeName = findViewById<EditText>(R.id.recipeName).text.toString()
            val recipeTime = findViewById<EditText>(R.id.recipeTime).text.toString()

            if(recipeName != "" && recipeTime != "" && !ingredientList.isEmpty() && !methodList.isEmpty()) {
                val recipe = Recipe(recipeName, recipeTime, ingredientList, methodList)
                recipes.add(recipe)

                val sharedPreferences =
                    getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val gson = Gson()
                val json = gson.toJson(recipes)
                editor.putString("recipe list", json)
                editor.apply()

                // Go back to recipe screen
                Toast.makeText(this, "Added new recipe!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right)
            } else {
                Toast.makeText(this,"Please fill out all the fields!", Toast.LENGTH_SHORT).show()
            }


        }



    }
    

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
