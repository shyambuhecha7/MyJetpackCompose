package com.shyam.jetpackcompose.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shyam.jetpackcompose.R

class LazyColumnScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryList()
        }
    }
}

@Preview(showBackground = true, heightDp = 500, widthDp = 300)
@Composable
fun CountryList() {
    val countries: MutableList<Country> = countryData()
    LazyColumn(content = {
        items(countries) { country ->
            CardItem(
                image = country.flag,
                countryName = country.countryName,
                capital = country.capital
            )
        }
    })
}
@Composable
fun CardItem(image: Int, countryName: String, capital: String) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = image), contentDescription = "flag",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .weight(.3f)
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(.7f)
            ) {
                Text(
                    text = countryName,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = capital,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

data class Country(val flag: Int, val countryName: String, val capital: String)

fun countryData(): MutableList<Country> {
    val countries = mutableListOf(
        Country(R.drawable.india, "India", "New Delhi"),
        Country(R.drawable.usa, "United States", "Washington, D.C."),
        Country(R.drawable.canada, "Canada", "Ottawa"),
        Country(R.drawable.uk, "United Kingdom", "London"),
        Country(R.drawable.germany, "Germany", "Berlin"),
        Country(R.drawable.france, "France", "Paris"),
        Country(R.drawable.japan, "Japan", "Tokyo"),
        Country(R.drawable.china, "China", "Beijing"),
        Country(R.drawable.australia, "Australia", "Canberra"),
        Country(R.drawable.brazil, "Brazil", "Brasília")
    )
    return countries
}
