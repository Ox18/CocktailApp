package com.example.cocktailapp.service

import com.example.cocktailapp.model.api.CocktailApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailApiService {
    @GET("search.php?s={name}")
    fun getCocktailList(@Path("name") name: String): Call<CocktailApiResponse>
}