package com.cs4520.assignment1

// Product class that contains all details necessary
sealed class Product(val name: String, val type: String, val expiryDate: String?, val price: Int) {

    // Food class that contains all necessary information
    data class Food(
        val foodName: String,
        val productType: String,
        val foodExpiry: String?,
        val foodPrice: Int
    ) : Product(foodName, productType, foodExpiry, foodPrice)

    // Equipment class that takes all the necessary information
    data class Equipment(
        val equipName: String,
        val productType: String,
        val equipExpiry: String?,
        val equipPrice: Int
    ) : Product(equipName, productType, equipExpiry, equipPrice)
}

// Function to convert the list provided  to a list of products
fun convertProducts(productsDataset: List<List<Any?>>): List<Product> {
    val convertedProducts = mutableListOf<Product>()
    // Loop through the list, grab the entries, and convert the items to their respective products
    for (productData in productsDataset) {
        val (name, type, expiryDate, price) = productData
        when (type) {
            // Create either product type depending on what it is and add it to the list
            "Food" -> convertedProducts.add(Product.Food(name.toString(), type.toString(), expiryDate.toString(), Integer.valueOf(price.toString())))
            "Equipment" -> convertedProducts.add(Product.Equipment(name.toString(), type.toString(), expiryDate.toString(), Integer.valueOf(price.toString())))
        }
    }
    return convertedProducts.toList()
}

