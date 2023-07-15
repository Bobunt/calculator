package com.example.calculator.calculator

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.elements.CalculatorButton
import com.example.calculator.elements.grayButtonColors
import com.example.calculator.elements.yellowButtonColors

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
) {
    val viewModel: CalculatorViewModel = viewModel()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp)
                    .weight(1F)
                    .fillMaxWidth(),
                text = "Calculator"
            )
                Text(
                    modifier = Modifier
                        .weight(3F)
                        .fillMaxSize(),
                    text = viewModel.uiState.value,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,
                    fontSize = 45.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
            )
            Column(
                modifier = Modifier
                    .weight(6F)
                    .fillMaxSize()
                    .padding(top = 6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(2F)
                            .fillMaxWidth(),
                        buttonColor = grayButtonColors(),
                        symbol = "AC",
                        onClick = { viewModel.deleteString() }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxWidth(),
                        buttonColor = grayButtonColors(),
                        symbol = "%",
                        onClick = { viewModel.addOperations("%") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxWidth(),
                        symbol = "+",
                        buttonColor = yellowButtonColors(),
                        onClick = { viewModel.addOperations("+") }
                    )
                }
                Row {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "7",
                        onClick = { viewModel.addSymbol("7") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "8",
                        onClick = { viewModel.addSymbol("8") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "9",
                        onClick = { viewModel.addSymbol("9") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "-",
                        buttonColor = yellowButtonColors(),
                        onClick = { viewModel.addOperations("-") }
                    )
                }
                Row {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "4",
                        onClick = { viewModel.addSymbol("4") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "5",
                        onClick = { viewModel.addSymbol("5") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "6",
                        onClick = { viewModel.addSymbol("6") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "*",
                        buttonColor = yellowButtonColors(),
                        onClick = { viewModel.addOperations("*") }
                    )
                }
                Row {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "1",
                        onClick = { viewModel.addSymbol("1") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "2",
                        onClick = { viewModel.addSymbol("2") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "3",
                        onClick = { viewModel.addSymbol("3") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "/",
                        buttonColor = yellowButtonColors(),
                        onClick = { viewModel.addOperations("/") }
                    )
                }
                Row {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "0",
                        onClick = { viewModel.addSymbol("0") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = ".",
                        onClick = { if (viewModel.dotAllowed) viewModel.addOperations(".") }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "Del",
                        onClick = { viewModel.deleteLastSymbol() }
                    )
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1F),
                        symbol = "=",
                        buttonColor = yellowButtonColors(),
                        onClick = { viewModel.calculation() }
                    )
                }
            }
        }
    }
}