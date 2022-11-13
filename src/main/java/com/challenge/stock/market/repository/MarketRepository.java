package com.challenge.stock.market.repository;


import java.util.List;
import java.util.Map;

public interface MarketRepository {
    List<String> getMarketInformation(String symbol, String apiKey);
}
