package com.cs4520.assignment1

sealed class Product(val name: String, val type: String, val expiryDate: String?, val price: Int) {

    data class Food(
        val foodName: String,
        val productType: String,
        val foodExpiry: String?,
        val foodPrice: Int
    ) : Product(foodName, productType, foodExpiry, foodPrice)

    data class Equipment(
        val equipName: String,
        val productType: String,
        val equipExpiry: String?,
        val equipPrice: Int
    ) : Product(equipName, productType, equipExpiry, equipPrice)
}

fun convertProducts(productsDataset: List<List<Any?>>): List<Product> {
    val convertedProducts = mutableListOf<Product>()
    for (productData in productsDataset) {
        val (name, type, expiryDate, price) = productData
        when (type) {
            "Food" -> convertedProducts.add(Product.Food(name.toString(), type.toString(), expiryDate.toString(), Integer.valueOf(price.toString())))
            "Equipment" -> convertedProducts.add(Product.Equipment(name.toString(), type.toString(), expiryDate.toString(), Integer.valueOf(price.toString())))
        }
    }
    return convertedProducts.toList()
}

