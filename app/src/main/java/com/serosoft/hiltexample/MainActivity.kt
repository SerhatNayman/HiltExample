package com.serosoft.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.serosoft.hiltexample.adapter.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDAtaObserver().observe(this, Observer {
            if (it != null) {
                recyclerViewAdapter.setListData(it)
                recyclerViewAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this, "Error in Getting Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}