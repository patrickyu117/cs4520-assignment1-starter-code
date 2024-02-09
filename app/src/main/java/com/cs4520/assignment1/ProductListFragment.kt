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

class ProductListFragment() : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private var layoutManager : LayoutManager? = null
    private var adapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater, container, false)
//        val productList = productsDataset.filterIsInstance<List<String>>().map { convertProduct(it) }
//        layoutManager = LinearLayoutManager(requireContext())
//        binding.recyclerView.layoutManager = layoutManager
//        adapter = ProductListAdapter(productList)
//        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val convertedList = convertProducts(productsDataset)

        val itemAdapter = ProductListAdapter(convertedList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = itemAdapter
    }
}
