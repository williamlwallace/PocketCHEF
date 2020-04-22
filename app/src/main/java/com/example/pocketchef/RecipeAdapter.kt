package com.example.pocketchef

import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter (val recipeList: ArrayList<Recipe>, val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecipeAdapter.ViewHolder> () {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName = itemView.findViewById<TextView>(R.id.recipeName)
        val recipeTime = itemView.findViewById<TextView>(R.id.recipeTime)

        fun bind(recipe: Recipe, clickListener: OnItemClickListener)
        {
            recipeName.text = recipe.name
            recipeTime.text = recipe.time

            itemView.setOnClickListener {
                clickListener.onItemClicked(recipe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe: Recipe = recipeList[position]
        holder.recipeName?.text = recipe.name.capitalize()
        holder.recipeTime?.text = recipe.time.toString() + " minutes"
        holder.bind(recipe, clickListener)
    }

}

interface OnItemClickListener{
    fun onItemClicked(recipe: Recipe)
}