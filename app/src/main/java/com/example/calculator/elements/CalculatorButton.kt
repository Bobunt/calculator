package com.example.calculator.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.Grey
import com.example.calculator.ui.theme.GreyDark
import com.example.calculator.ui.theme.Orange
import org.w3c.dom.Text

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    symbol: String,
    buttonColor: ButtonColors? = null,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .height(72.dp)
            .padding(horizontal = 4.dp)
            .fillMaxWidth(),
        colors = buttonColor ?: grayDarkButtonColors(),
        onClick = { onClick() },
    ) {
        Text(text = symbol)
    }
}
@Composable
fun grayDarkButtonColors() = ButtonDefaults.buttonColors(
    containerColor = GreyDark
)

@Composable
fun grayButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Grey
)

@Composable
fun yellowButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Orange
)

