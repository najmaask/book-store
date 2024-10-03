package com.najma.bookstore.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najma.bookstore.data.BookRepository
import com.najma.bookstore.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: BookRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedBooks() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedBooks()
                .collect { orderBook ->
                    val totalPrice =
                        orderBook.sumOf { it.book.price * it.count }
                    _uiState.value = UiState.Success(CartState(orderBook, totalPrice))
                }
        }
    }

    fun updateBook(bookId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateBook(bookId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedBooks()
                    }
                }
        }
    }
}