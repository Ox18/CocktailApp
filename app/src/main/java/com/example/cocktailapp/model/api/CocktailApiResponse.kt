package com.example.cocktailapp.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CocktailApiResponse(
        @Expose @SerializedName("drinks") val drinks: List<CocktailResult>
)
data class CocktailResult(
        @Expose @SerializedName("strDrink") val strDrink:String?,
        @Expose @SerializedName("strInstructions") val strInstructions: String?,
        @Expose @SerializedName("strDrinkThumb") val strDrinkThumb : String
)
