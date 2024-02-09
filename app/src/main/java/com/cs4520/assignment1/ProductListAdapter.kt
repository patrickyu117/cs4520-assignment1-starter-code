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

//    inner class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
//        private var itemImage: ImageView
//        private var itemName: TextView
//        private var itemExp: TextView
//        private var itemPrice: TextView
//
//        init {
//            itemImage = itemView.findViewById(R.id.product_image)
//            itemName = itemView.findViewById(R.id.product_name)
//            itemExp = itemView.findViewById(R.id.product_expiry_date)
//            itemPrice = itemView.findViewById(R.id.product_price)
//        }
//
//        fun bindFood(food: Product.Food) {
//            itemName.text = food.foodName
//            if (food.expiryDate != null) {
//                itemExp.text = food.expiryDate
//                itemExp.visibility = View.VISIBLE // Ensure visibility if date is available
//            } else {
//                itemExp.visibility = View.GONE // Hide if date is null
//            }
//            itemPrice.text = "%.2f".format(food.price)
//            itemImage.setImageResource(R.drawable.food)
//        }
//
//        fun bindEquipment(equipment: Product.Equipment) {
//            itemName.text = equipment.equipName
//            itemPrice.text = "%.2f".format(equipment.price)
//            itemImage.setImageResource(R.drawable.equipment)
//
//        }
//    }

    inner class ViewHolder(val itemBinding: ProductItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
            fun bindFood(food: Product.Food) {
                itemBinding.productName.text = food.name
                if (food.expiryDate != null) {
                    itemBinding.productExpiryDate.text = food.expiryDate
                    itemBinding.productExpiryDate.visibility = View.VISIBLE
                } else {
                    itemBinding.productExpiryDate.visibility = View.GONE
                }
                itemBinding.productPrice.text = food.price.toString()
                itemBinding.productImage.setImageResource(drawable.food)
                itemBinding.cardView.setCardBackgroundColor(color.light_red)
            }

            fun bindEquipment(equipment: Product.Equipment) {
                itemBinding.productName.text = equipment.equipName
                itemBinding.productPrice.text = equipment.price.toString()
                itemBinding.productImage.setImageResource(drawable.equipment)
            }


        }
}