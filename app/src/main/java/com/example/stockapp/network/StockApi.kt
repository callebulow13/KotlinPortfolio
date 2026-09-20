package com.example.stockapp.network

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.android.volley.BuildConfig
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.stockapp.data.Stock
import com.example.stockapp.data.StockPrice
import com.example.stockapp.R

class StockApi(private val context: Context) {
    private val queue = Volley.newRequestQueue(context)

    fun getStockHistory(
        symbol: String,
        onResult: (List<StockPrice>) -> Unit
    ) {
        val apiKey = context.getString(R.string.marketstack_api_key)
        val url = "https://api.marketstack.com/v1/eod?access_key=$apiKey&symbols=$symbol"

        // Construct the Volley json request
        val jsonRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->

                val data = response.getJSONArray("data")
                val prices = mutableListOf<StockPrice>()

                for (i in 0 until minOf(7, data.length())) {
                    val stockData = data.getJSONObject(i)

                    prices.add(
                        StockPrice(
                            price = stockData.getDouble("close").toFloat(),
                            date = stockData.getString("date")
                        )
                    )
                }
                onResult(prices)
            },
            { error ->
                Log.e("VolleyError", error.toString())
            }
        )

        // Add request to the queue
        queue.add(jsonRequest)
    }
}