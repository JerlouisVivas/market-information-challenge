package com.challenge.stock.market.utils;

public class Statics {
    public static String URL_GET_MARKET = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol={symbol}&outputsize=compact&datatype=csv&apikey={apiKey}";
    public static String TIME_SERIES = "Time Series (Daily)";
    public static String API_KEY = "X86NOH6II01P7R24";
    public static String OPEN_PRICE = "1. open";
    public static String HIGH_PRICE = "2. high";
    public static String LOW_PRICE = "3. low";
    public static String CLOSE_PRICE = "4. close";
}
