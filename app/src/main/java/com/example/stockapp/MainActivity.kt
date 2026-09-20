package com.example.stockapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.stockapp.composable.HomeScreen
import com.example.stockapp.composable.StockCard
import com.example.stockapp.composable.StockScreen
import com.example.stockapp.data.Stock
import com.example.stockapp.data.StockOwned
import com.example.stockapp.network.StockApi
import com.example.stockapp.ui.theme.StockAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            StockAppTheme() {

                var stocksOwned by remember {
                    mutableStateOf<List<StockOwned>>(emptyList())
                }

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "HomeScreen", builder = {
                    composable("HomeScreen") {
                        HomeScreen(navController = navController, stocksOwned = stocksOwned)
                    }
                    composable("StockScreen/{symbol}") { backStackEntry ->
                        val symbol = backStackEntry.arguments?.getString("symbol") ?: "AAPL"

                        StockScreen(
                            symbol = symbol,
                            onStockBought = { boughtStock ->
                                val existingStock = stocksOwned.find {
                                    it.symbol == boughtStock.symbol
                                }
                                if (existingStock != null) {
                                    stocksOwned = stocksOwned.map {
                                        if (it.symbol == boughtStock.symbol) {
                                            it.copy(
                                                amount = it.amount + 1
                                            )
                                        } else {
                                            it
                                        }
                                    }
                                } else {
                                    stocksOwned = stocksOwned + boughtStock
                                }
                            }
                        )
                    }
                })
            }
        }
    }
}

