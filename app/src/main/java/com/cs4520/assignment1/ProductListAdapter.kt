package com.cs4520.assignment1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.R.*
import com.cs4520.assignment1.databinding.ProductItemBinding

class ProductListAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ViewHolder {
        return ViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {
        val product = productList[position]
        when (product) {
            is Product.Food -> holder.bindFood(product)
            is Product.Equipment -> holder.bindEquipment(product)
        }
    }

    inner class ViewHolder(val itemBinding: ProductItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
            @SuppressLint("SetTextI18n")
            fun bindFood(food: Product.Food) {
                itemBinding.productName.text = food.name
                if (food.expiryDate != "null") {
                    itemBinding.productExpiryDate.text = food.expiryDate
                    itemBinding.productExpiryDate.visibility = View.VISIBLE
                } else {
                    itemBinding.productExpiryDate.visibility = View.GONE
                }
                itemBinding.productPrice.text = "$" + food.price.toString()
                itemBinding.productImage.setImageResource(drawable.food)
                itemBinding.cardView.setBackgroundResource(color.light_yellow)
            }

            @SuppressLint("SetTextI18n")
            fun bindEquipment(equipment: Product.Equipment) {
                itemBinding.productName.text = equipment.equipName
                itemBinding.productPrice.text = "$" + equipment.price.toString()
                itemBinding.productImage.setImageResource(drawable.equipment)
                itemBinding.cardView.setBackgroundResource(color.light_red)
                if (equipment.expiryDate != "null") {
                    itemBinding.productExpiryDate.text = equipment.expiryDate
                    itemBinding.productExpiryDate.visibility = View.VISIBLE
                } else {
                    itemBinding.productExpiryDate.visibility = View.GONE
                }
            }


        }
}