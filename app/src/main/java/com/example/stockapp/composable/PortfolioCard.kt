package com.example.stockapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockapp.data.Portfolio
import com.example.stockapp.data.Stock
import com.example.stockapp.network.StockApi
import com.example.stockapp.ui.theme.StockAppTheme

@Composable
fun PortfolioCard() {
    StockAppTheme {

        val portfolio = Portfolio(
            value = 100000,
            performance = 4.82
        )
        Column(
        )
        {
            Text(
                text = "Din portfölj",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(10.dp, 40.dp, 0.dp)

            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(10.dp, 20.dp, 10.dp, 0.dp)
                    .fillMaxWidth()
            )
            {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column {
                        Text(
                            text = "Totalt värde",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            text = "${portfolio.value} kr",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 24.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.Bottom)
                    ) {
                        Text(
                            text = "+${portfolio.performance}%",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                }

            }

            // Kort för ägda aktier


            // Button for sending requests.
            /* Button(
                 onClick = {
                     stockApi.getStock("AAPL") { result ->
                         stock = result
                     }
                 }
             ) {
                 Text("Hämta aktiekurs nu v ")
             }

             // Capture state of the current post in a when expression.
             // Display a PostCard if data is available.
             when (val stockState = stock) {
                 null -> Text("Click the button!")
                 else -> StockCard(stockState)
             }*/
        }
    }
}

@Preview
@Composable
fun PortfolioCardPreview() {
    StockAppTheme {
        PortfolioCard()
    }
}