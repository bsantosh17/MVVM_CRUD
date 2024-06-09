
package com.example.mymvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    var viewModel: DataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        val adapter = MyAdapter()
        recyclerView.adapter = adapter

        viewModel!!.data.observe(this, Observer { data ->
            adapter.submitList(data)
        })

        viewModel!!.error.observe(this, Observer { error ->
            // Handle error here
        })

        viewModel!!.fetchData()
    }
}