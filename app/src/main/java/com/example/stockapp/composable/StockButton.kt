package com.example.stockapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockapp.data.stocks
import com.example.stockapp.data.StockOption
import com.example.stockapp.network.StockApi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockButton(
    onStockSelected: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    // Kollar igenom lista på aktier som ligger i Stockoption.kt som AI har genererat

    val filteredStocks = stocks.filter {
        it.name.contains(searchText, ignoreCase = true) ||
                it.symbol.contains(searchText, ignoreCase = true)
    }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .padding(10.dp, 0.dp),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }

    ) {
        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                expanded = true
            },
            shape = RoundedCornerShape(12.dp),
            label = {
                Text("Sök bland aktier här")
            },
            modifier = Modifier
                .menuAnchor(
                    type = ExposedDropdownMenuAnchorType.PrimaryEditable,
                    enabled = true
                )
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary

            ),

            )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            containerColor = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp)
        ) {

                filteredStocks.forEach { stock ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "${stock.name} (${stock.symbol})",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        onClick = {
                            searchText = stock.symbol
                            expanded = false
                            onStockSelected(stock.symbol)
                        }

                    )
                }
            }
        }
    }

@Preview
@Composable
fun StockButtonPreview() {
}

