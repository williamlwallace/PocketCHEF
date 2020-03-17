package com.example.pocketchef

data class Recipe(val name: String,
                  val time: Int,
                  val ingredients: ArrayList<String>,
                  val method: ArrayList<String>)