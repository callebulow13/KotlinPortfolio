package com.example.stockapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockapp.data.StockOwned
import com.example.stockapp.ui.theme.StockAppTheme

@Composable
fun StockList(stocksOwned: List<StockOwned>) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,

            ),
        modifier = Modifier
            .padding(10.dp, 0.dp)
            .fillMaxWidth()
            .heightIn(min = 150.dp, max = 400.dp)
    ) {
        Text(
            text = "Aktier",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(5.dp)
        )

        HorizontalDivider(
            color = MaterialTheme.colorScheme.secondary
        )

        if (stocksOwned.isEmpty()) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
            Text(
                text = "Du har inga innehav",
            )
            Text(
                fontSize = 16.sp,
                text = "Sök efter en aktie fär att göra ditt första köp",
            )
            }

        } else {
            // Aktie
            stocksOwned.forEach { stock ->
                Column(
                    modifier = Modifier
                        .padding(5.dp, 1.dp)
                ) {
                    Text(
                        text = stock.symbol,
                        modifier = Modifier
                            .padding(5.dp, 5.dp, 0.dp, 0.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp, 0.dp, 5.dp, 5.dp),
                        Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Kurs/Inköp"
                            )
                            Text(
                                text = "%.2f USD".format(stock.buyPrice),
                                fontSize = 14.sp
                            )
                            Text(
                                text = "%.2f USD".format(stock.buyPrice),
                                fontSize = 14.sp
                            )
                        }
                        Column {
                            Text(
                                text = "Sedan köp"
                            )
                            Text(
                                text = "0 %",
                                fontSize = 14.sp
                            )
                            Text(
                                text = "0 USD",
                                fontSize = 14.sp
                            )

                        }
                        Column {
                            Text(
                                text = "Innehav"
                            )
                            Text(
                                fontSize = 14.sp,
                                text = "%.2f USD".format(stock.amount * stock.buyPrice)
                            )
                            Text(
                                fontSize = 14.sp,
                                text = "${stock.amount} st"
                            )
                        }
                    }
                }
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}


@Preview
@Composable
fun StockListPreview() {
}