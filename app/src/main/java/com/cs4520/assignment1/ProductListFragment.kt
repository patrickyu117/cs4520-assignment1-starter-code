package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.cs4520.assignment1.databinding.FragmentProductListBinding

// Fragment class for the product list
class ProductListFragment() : Fragment() {
    private lateinit var binding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the product list
        binding = FragmentProductListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Convert the list given to a list of Products
        val convertedList = convertProducts(productsDataset)
        // Pass the converted list to the product list adapter
        val itemAdapter = ProductListAdapter(convertedList)
        // Use recycler view for the layout manager
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        // User recycler view for the adapter and set it to our product list adapter
        binding.recyclerView.adapter = itemAdapter
    }
}
