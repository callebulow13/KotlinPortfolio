package com.example.stockapp.composable

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockapp.BuildConfig
import com.example.stockapp.data.Stock
import com.example.stockapp.data.StockOwned
import com.example.stockapp.data.StockPrice
import com.example.stockapp.network.StockApi
import com.example.stockapp.ui.theme.StockAppTheme

@Composable
fun StockScreen(symbol: String, onStockBought: (StockOwned) -> Unit) {
    StockAppTheme {
        Surface {
            var stockHistory by remember { mutableStateOf<List<StockPrice>>(emptyList()) }

            val stockApi = StockApi(LocalContext.current)

            LaunchedEffect(Unit) {
                stockApi.getStockHistory(symbol) { result ->
                    stockHistory = result
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp, 40.dp)
                    .fillMaxSize()
            ) {

                if (stockHistory.isEmpty()) {
                    Text("Hämtar aktiekurs...")
                    Log.d("API_KEY", "Key exists: ${BuildConfig.MARKETSTACK_API_KEY.isNotEmpty()}")
                } else {


                    val latestStock = stockHistory.first()

                    StockCard(
                        Stock(
                            symbol = symbol,
                            price = latestStock.price.toDouble(),
                            date = latestStock.date
                        ),
                        stockHistory = stockHistory,
                        onStockBought = onStockBought
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun StockScreenPreview() {
    StockCardPreview()
}
