package com.najma.bookstore.ui.screen.cart

import com.najma.bookstore.model.OrderBook

data class CartState(
    val orderBook: List<OrderBook>,
    val totalPrice: Int
)