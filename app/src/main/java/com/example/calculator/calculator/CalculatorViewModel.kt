package com.example.calculator.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {
    var uiState by mutableStateOf(UiState())
    
    private var allowedOperationsAdd = false
    var dotAllowed = true

    private val _error = MutableSharedFlow<String?>()
    val error = _error.asSharedFlow()

    fun addSymbol(symbol: String) {
        if(uiState.value.length < 12) {
            allowedOperationsAdd = true
            uiState = uiState.copy(value = uiState.value + symbol)
            dotAllowed = true
        }
    }

    fun addOperations(symbol: String) {
        if (uiState.value.isEmpty() && symbol != "-" || uiState.value == "-") return
        if (allowedOperationsAdd) {
            allowedOperationsAdd = false
            uiState = uiState.copy(value = uiState.value + symbol)
        } else if (uiState.value.last().toString() != ".") {
            uiState = uiState.copy(value = uiState.value.dropLast(1))
            uiState = uiState.copy(value = uiState.value + symbol)
        }
        dotAllowed = false
    }

    fun deleteLastSymbol() {
        uiState = uiState.copy(value = uiState.value.dropLast(1))
        dotAllowed = true
    }

    fun deleteString() {
        uiState = uiState.copy(value = "")
        dotAllowed = true
    }

    fun calculation() {
        var num = ""
        var symbol = '+'
        var result = 0.0f
        for (i in uiState.value) {
            if(i in '0'..'9')
                num += i
            else {
                when (symbol) {
                    '+' -> result += Integer.parseInt(num).toFloat()
                    '-' -> result -= Integer.parseInt(num).toFloat()
                    '*' -> result *= Integer.parseInt(num).toFloat()
                    '/' -> result /= Integer.parseInt(num).toFloat()
                    '%' -> result %= Integer.parseInt(num).toFloat()
                }
                num = ""
                symbol = i
            }
        }

        when (symbol) {
            '+' -> result += Integer.parseInt(num).toFloat()
            '-' -> result -= Integer.parseInt(num).toFloat()
            '*' -> result *= Integer.parseInt(num).toFloat()
            '/' -> result /= Integer.parseInt(num).toFloat()
            '%' -> result %= Integer.parseInt(num).toFloat()
        }

        uiState = uiState.copy(value = result.toString())
    }
}