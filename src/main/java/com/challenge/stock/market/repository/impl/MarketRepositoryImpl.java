package com.challenge.stock.market.repository.impl;

import com.challenge.stock.market.repository.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.challenge.stock.market.utils.Statics.*;

@Slf4j
@Repository
public class MarketRepositoryImpl implements MarketRepository {
    private final static Logger logger = LoggerFactory.getLogger(MarketRepositoryImpl.class);
    @Override
    public List<String>  getMarketInformation(String symbol, String apiKey) {

        logger.info("market repository: get market information from  ALPHA API");
        Map<String,String> uriParams = new HashMap<>();
        uriParams.put("symbol",symbol);
        uriParams.put("apiKey",API_KEY);
        RestTemplate restService = new RestTemplate();
        ResponseEntity<String> response = restService.getForEntity(URL_GET_MARKET, String.class,uriParams);
        logger.info("market repository:returning information from  ALPHA API");
        return Arrays.asList(response.getBody().split("\n")).subList(1,101);
    }
}
