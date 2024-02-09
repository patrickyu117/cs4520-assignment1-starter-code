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

