package com.example.cocktailapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.model.api.CocktailApiResponse
import com.example.cocktailapp.model.api.CocktailResult
import com.example.cocktailapp.service.CocktailApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CocktailListViewModel(): ViewModel() {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    private val service: CocktailApiService = retrofit.create(CocktailApiService::class.java)

    val cocktailList = MutableLiveData<List<CocktailResult>>()

    fun getCocktailList(){
        val call = service.getCocktailList("margarita")

        call.enqueue(object: Callback<CocktailApiResponse> {
            override fun onResponse(call: Call<CocktailApiResponse>, response: Response<CocktailApiResponse>) {
                    if(response.isSuccessful){
                        response.body()?.let { it ->
                            cocktailList.postValue(it.drinks)
                        }
                    }
            }

            override fun onFailure(call: Call<CocktailApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }

}