package com.najma.bookstore.model

data class Book (
    val id: Long,
    val name: String,
    val photo: Int,
    val author: String,
    val price: Int,
    val desc: String,
)
