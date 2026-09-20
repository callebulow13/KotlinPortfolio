package com.example.stockapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockapp.data.Stock
import com.example.stockapp.data.StockOwned
import com.example.stockapp.data.StockPrice
import com.example.stockapp.ui.theme.StockAppTheme
import org.intellij.lang.annotations.JdkConstants

@Composable
fun StockCard(stock: Stock, stockHistory: List<StockPrice>, onStockBought: (StockOwned) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(all = 8.dp)) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            {
                Text(
                    text = stock.symbol,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "%.2f USD".format(stock.price),
                    style = MaterialTheme.typography.headlineSmall
                )
                StockChart(stockHistory)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        onStockBought(
                            StockOwned(
                                symbol = stock.symbol,
                                buyPrice = stock.price,
                                amount = 1
                            )
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text("Köp")
                }
                Button(
                    onClick = {
                        (StockOwned(
                            symbol = stock.symbol,
                            buyPrice = stock.price,
                            amount = 1
                        )
                                )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text("Sälj")

                }
            }
        }
    }
}

@Preview
@Composable
fun StockCardPreview() {

    val stock = Stock(
        symbol = "AAPL",
        price = 300.0,
        date = "2026-09-10"
    )

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        {
            Column(Modifier.padding(10.dp, 0.dp)) {
                Text(
                    text = stock.symbol,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "${stock.price} USD",
                    style = MaterialTheme.typography.headlineSmall
                )
                StockChartPreview()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        (
                                StockOwned(
                                    symbol = stock.symbol,
                                    buyPrice = stock.price,
                                    amount = 1
                                )
                                )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text("Köp")
                }
                Button(
                    onClick = {
                        (
                                StockOwned(
                                    symbol = stock.symbol,
                                    buyPrice = stock.price,
                                    amount = 1
                                )
                                )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text("Sälj")

                }
            }
        }
    }
}





