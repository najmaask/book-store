package com.najma.bookstore.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najma.bookstore.data.BookRepository
import com.najma.bookstore.model.OrderBook
import com.najma.bookstore.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class  HomeViewModel(
    private val repository: BookRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderBook>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderBook>>>
        get() = _uiState

    fun getAllBooks() {
        viewModelScope.launch {
            repository.getAllBooks()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderBooks ->
                    _uiState.value = UiState.Success(orderBooks)
                }
        }
    }
}