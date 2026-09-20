package com.example.stockapp.composable

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockapp.data.StockPrice

@Composable
fun StockChart(stockHistory: List<StockPrice>) {
    val stockHistory = stockHistory.reversed()

    val prices = stockHistory.map { it.price }
    val dates = stockHistory.map {
        LocalDate.parse(it.date.substring(0, 10))
            .format(
                DateTimeFormatter.ofPattern("d MMM", Locale("sv", "SE"))
            )
    }

    val max = prices.maxOrNull() ?: 0f
    val min = prices.minOrNull() ?: 0f
    val step = (max - min) / 4
    val labels = listOf(
        max,
        max - step,
        max - step * 2,
        max - step * 3,
        min
    )
// Ai har hjälpt till med att skapa denna graf, jag har försökt att be den förklara och lära mig av
    //koden och inte bara kopiera rakt av för att ha en förståelse för vad jag skrivit i min kod
    Column(
        modifier = Modifier
            .height(280.dp)
            .padding(0.dp, 20.dp)
    ) {

        Row(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                val xStep = size.width / (prices.size - 1)

                for (i in 0 until prices.size - 1) {
                    val x1 = i * xStep
                    val x2 = (i + 1) * xStep

                    val y1 = size.height - ((prices[i] - min) / (max - min) * size.height)
                    val y2 = size.height - ((prices[i + 1] - min) / (max - min) * size.height)

                    drawLine(
                        start = Offset(x1, y1),
                        end = Offset(x2, y2),
                        strokeWidth = 5f,
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .height(200.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                labels.forEach { price ->
                    Text(
                        color = MaterialTheme.colorScheme.onPrimary,
                        text = "%.0f".format(price)
                    )
                }


            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            dates.forEach { date ->
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {

                    Text(
                        text = date,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 12.sp
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun StockChartPreview() {
    val prices = listOf(
        295f,
        302f,
        298f,
        310f,
        305f,
        315f,
        312f
    )
    val dates = listOf(
        "8 sep",
        "9 sep",
        "10 sep",
        "11 sep",
        "12 sep",
        "13 sep",
        "14 sep"
    )
    val max = prices.maxOrNull() ?: 0f
    val min = prices.minOrNull() ?: 0f
    val step = (max - min) / 4
    val labels = listOf(
        max,
        max - step,
        max - step * 2,
        max - step * 3,
        min
    )

    Column(
        modifier = Modifier
            .height(280.dp)
            .padding(0.dp, 20.dp, 0.dp, 5.dp)
            .border(
                width = 1.dp,
                color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                val xStep = size.width / (prices.size - 1)

                for (i in 0 until prices.size - 1) {
                    val x1 = i * xStep
                    val x2 = (i + 1) * xStep

                    val y1 = size.height - ((prices[i] - min) / (max - min) * size.height)
                    val y2 = size.height - ((prices[i + 1] - min) / (max - min) * size.height)

                    drawLine(
                        start = Offset(x1, y1),
                        end = Offset(x2, y2),
                        strokeWidth = 5f,
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .height(200.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                labels.forEach { price ->
                    Text(
                        color = MaterialTheme.colorScheme.onPrimary,
                        text = "%.0f".format(price)
                    )
                }


            }
        }
        Row(
            modifier = Modifier
        ) {
            dates.forEach { date ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp, 0.dp),
                    contentAlignment = Alignment.CenterStart
                ) {

                    Text(
                        text = date,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 12.sp

                    )
                }

            }
        }
    }
}
