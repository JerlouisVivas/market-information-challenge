package com.challenge.stock.market.controller;

import com.challenge.stock.market.dto.MarketInformationOut;
import com.challenge.stock.market.service.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MarketController {
    private final static Logger logger = LoggerFactory.getLogger(MarketController.class);
    @Autowired
    MarketService service;
    @GetMapping("/stock/market/query")
    public ResponseEntity<List<MarketInformationOut>> getMarketInformation(@RequestParam String symbol, @RequestHeader("apikey") String apikey){
        logger.info("strockMarket controller requested");
        if(service.getUserByApiKey(apikey) != null){
            logger.info("is a valid api key for user");
            return new ResponseEntity<List<MarketInformationOut>>(service.getMarketInformation(symbol,apikey), HttpStatus.OK);
        }
        logger.info("api key for user is not valid");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
