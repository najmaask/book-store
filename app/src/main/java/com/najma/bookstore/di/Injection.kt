package com.najma.bookstore.di

import com.najma.bookstore.data.BookRepository

object Injection {
    fun provideRepository(): BookRepository {
        return BookRepository.getInstance()
    }
}