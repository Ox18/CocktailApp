package com.example.cocktailapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailapp.databinding.ListItemBinding
import com.example.cocktailapp.model.api.CocktailResult

class CocktailListAdapter(val context:Context):RecyclerView.Adapter<CocktailListAdapter.ViewHolder>() {
    var cocktailList: List<CocktailResult> = emptyList<CocktailResult>()
    inner class ViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root)
    fun setData(list: MutableLiveData<List<CocktailResult>>){
        cocktailList = list[]
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktailObj = cocktailList[position]
        holder.binding.nameText.text = cocktailObj.strDrink
        holder.binding.descriptionText.text = cocktailObj.strInstructions
        Glide
            .with(context)
            .load(cocktailObj.strDrinkThumb)
            .into(holder.binding.iconImageView)
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }
}