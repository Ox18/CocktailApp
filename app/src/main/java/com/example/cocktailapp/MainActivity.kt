package com.example.cocktailapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailapp.databinding.ActivityMainBinding
import com.example.cocktailapp.ui.CocktailListAdapter
import com.example.cocktailapp.ui.CocktailListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:CocktailListViewModel
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CocktailListViewModel::class.java)
        initUI()
    }
    private fun initUI(){
        
    }

}