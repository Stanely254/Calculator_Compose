package com.stanley.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stanley.calculator.ui.theme.CalculatorTheme
import com.stanley.calculator.ui.theme.LightGray
import com.stanley.calculator.ui.theme.MediumGray
import com.stanley.calculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier.fillMaxSize().background(MediumGray).padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
){
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    "AC",
                    modifier = Modifier.background(LightGray).aspectRatio(2f).weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                CalculatorButton(
                    "Del",
                    modifier = Modifier.background(LightGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
                CalculatorButton(
                    "/",
                    modifier = Modifier.background(LightGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculatorOperation.Divide))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    "7",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                CalculatorButton(
                    "8",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                CalculatorButton(
                    "9",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculatorButton(
                    "*",
                    modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculatorOperation.Multiply))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    "4",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                CalculatorButton(
                    "5",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                CalculatorButton(
                    "6",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculatorButton(
                    "-",
                    modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculatorOperation.Subtract))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    "1",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                CalculatorButton(
                    "2",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                CalculatorButton(
                    "3",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculatorButton(
                    "+",
                    modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculatorOperation.Add))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    "0",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                CalculatorButton(
                    "%",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculatorOperation.Percent))
                    }
                )
                CalculatorButton(
                    ".",
                    modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                CalculatorButton(
                    "=",
                    modifier = Modifier.background(Orange).aspectRatio(1f).weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}