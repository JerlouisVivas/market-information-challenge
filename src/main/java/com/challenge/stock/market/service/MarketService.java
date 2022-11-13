package com.challenge.stock.market.service;

import com.challenge.stock.market.dto.MarketInformationOut;
import com.challenge.stock.market.model.User;

import java.util.List;


public interface MarketService {
    List<MarketInformationOut> getMarketInformation(String symbol, String apiKey);
    User getUserByApiKey(String apiKey);
}
