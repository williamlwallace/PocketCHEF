package com.example.pocketchef

import java.io.Serializable

data class Recipe(var name: String,
                  var time: String,
                  var ingredients: ArrayList<String>,
                  var method: ArrayList<String>) : Serializable {

}