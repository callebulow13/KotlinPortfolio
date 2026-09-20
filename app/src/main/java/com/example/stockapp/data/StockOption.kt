package com.example.stockapp.data

data class StockOption (
    val name: String,
    val symbol: String
)

val stocks = listOf(

    // Tech
    StockOption("Apple", "AAPL"),
    StockOption("Microsoft", "MSFT"),
    StockOption("NVIDIA", "NVDA"),
    StockOption("Amazon", "AMZN"),
    StockOption("Alphabet", "GOOGL"),
    StockOption("Meta", "META"),
    StockOption("Tesla", "TSLA"),
    StockOption("Netflix", "NFLX"),
    StockOption("AMD", "AMD"),
    StockOption("Intel", "INTC"),
    StockOption("Adobe", "ADBE"),
    StockOption("Salesforce", "CRM"),
    StockOption("Oracle", "ORCL"),
    StockOption("IBM", "IBM"),
    StockOption("Qualcomm", "QCOM"),
    StockOption("Broadcom", "AVGO"),
    StockOption("Micron Technology", "MU"),
    StockOption("Palantir", "PLTR"),
    StockOption("Uber", "UBER"),
    StockOption("PayPal", "PYPL"),
    StockOption("Shopify", "SHOP"),
    StockOption("Spotify", "SPOT"),

    // Finans
    StockOption("JPMorgan Chase", "JPM"),
    StockOption("Bank of America", "BAC"),
    StockOption("Wells Fargo", "WFC"),
    StockOption("Goldman Sachs", "GS"),
    StockOption("Morgan Stanley", "MS"),
    StockOption("Citigroup", "C"),
    StockOption("Visa", "V"),
    StockOption("Mastercard", "MA"),
    StockOption("American Express", "AXP"),
    StockOption("BlackRock", "BLK"),
    StockOption("Berkshire Hathaway", "BRK-B"),

    // Konsument
    StockOption("Coca-Cola", "KO"),
    StockOption("PepsiCo", "PEP"),
    StockOption("McDonald's", "MCD"),
    StockOption("Walmart", "WMT"),
    StockOption("Costco", "COST"),
    StockOption("Nike", "NKE"),
    StockOption("Starbucks", "SBUX"),
    StockOption("Disney", "DIS"),
    StockOption("Home Depot", "HD"),
    StockOption("Target", "TGT"),
    StockOption("Procter & Gamble", "PG"),
    StockOption("Colgate-Palmolive", "CL"),

    // Hälsa
    StockOption("Johnson & Johnson", "JNJ"),
    StockOption("Eli Lilly", "LLY"),
    StockOption("Pfizer", "PFE"),
    StockOption("Merck", "MRK"),
    StockOption("AbbVie", "ABBV"),
    StockOption("UnitedHealth", "UNH"),
    StockOption("Moderna", "MRNA"),
    StockOption("Novo Nordisk", "NVO"),

    // Industri / Energi
    StockOption("Exxon Mobil", "XOM"),
    StockOption("Chevron", "CVX"),
    StockOption("Shell", "SHEL"),
    StockOption("BP", "BP"),
    StockOption("Boeing", "BA"),
    StockOption("Caterpillar", "CAT"),
    StockOption("Honeywell", "HON"),
    StockOption("General Electric", "GE"),
    StockOption("Lockheed Martin", "LMT"),
    StockOption("3M", "MMM"),

    // Fordon
    StockOption("Ford", "F"),
    StockOption("General Motors", "GM"),
    StockOption("Toyota", "TM"),
    StockOption("Ferrari", "RACE"),

    // Halvledare
    StockOption("TSMC", "TSM"),
    StockOption("ASML", "ASML"),
    StockOption("Applied Materials", "AMAT"),
    StockOption("Lam Research", "LRCX"),
    StockOption("Texas Instruments", "TXN"),
    StockOption("ARM", "ARM"),
    StockOption("Marvell Technology", "MRVL"),

    // Kommunikation
    StockOption("Comcast", "CMCSA"),
    StockOption("Verizon", "VZ"),
    StockOption("AT&T", "T"),
    StockOption("T-Mobile", "TMUS"),
    StockOption("Warner Bros Discovery", "WBD"),
    StockOption("Fox", "FOXA"),
)
