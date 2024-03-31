package com.shyam.jetpackcompose.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shyam.jetpackcompose.R
import java.text.NumberFormat

class Calc : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxSize()
            ) {

                TipTimeLayout()

            }

        }
    }

    @Composable
    fun TipTimeLayout() {
        var amountInput by remember { mutableStateOf("") }
        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount)

        Text(
            text = stringResource(id = R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 20.dp, top = 40.dp)

        )

        EditNumberField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(150.dp))
    }

    private fun calculateTip(amount: Double, tipPercentage: Double = 15.0): String {
        val tip = tipPercentage * 100 / amount
        return NumberFormat.getCurrencyInstance().format(tip)

    }

    @Composable
    fun EditNumberField(modifier: Modifier = Modifier) {
        var amountInput by remember {
            mutableStateOf("")
        }
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = modifier,
            label = { Text(text = "Bill Amount") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = true
            ),
        )
    }
}