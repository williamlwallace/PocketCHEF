package com.example.pocketchef

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val recipeList: ArrayList<Recipe>) : RecyclerView.Adapter<CustomAdapter.ViewHolder> () {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName = itemView.findViewById<TextView>(R.id.recipeName)
        val recipeTime = itemView.findViewById<TextView>(R.id.recipeTime)
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

        holder.recipeName?.text = recipe.name
        holder.recipeTime?.text = recipe.time.toString() + " minutes"
    }
}