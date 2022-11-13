package com.challenge.stock.market.service.impl;

import com.challenge.stock.market.dto.MarketInformationOut;
import com.challenge.stock.market.model.User;
import com.challenge.stock.market.repository.MarketRepository;
import com.challenge.stock.market.repository.UserRepository;
import com.challenge.stock.market.service.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MarketServiceImpl implements MarketService {

    private final static Logger logger = LoggerFactory.getLogger(MarketServiceImpl.class);

    @Autowired
    MarketRepository repository;
    @Autowired
    UserRepository repositoryUser;

    @Override
    public List<MarketInformationOut> getMarketInformation(String symbol, String apiKey) {
        logger.info("market service: get market information");
        List<MarketInformationOut> marketInformation = new ArrayList<>();
        List<String> response = repository.getMarketInformation(symbol,apiKey);

        logger.info("market service: mapping information to dto");
        for(int i = 0; i < response.size(); i++){
            MarketInformationOut marketInfo = new MarketInformationOut();
            String[] obj = getStrArray(response.get(i));

            marketInfo.setOpenPrice(obj[1]);
            marketInfo.setHigherPrice(obj[2]);
            marketInfo.setLowerPrice(obj[3]);
            if(i < response.size() - 1){
                Double closeAct = Double.valueOf(obj[4]);
                Double closeAnt = Double.valueOf(getStrArray(response.get(i+1))[4]);
                marketInfo.setVariationClosePrices(String.valueOf(closeAct-closeAnt));
            }

            marketInformation.add(marketInfo);
        }

        logger.info("market service: return market information");
        return marketInformation;
    }


    @Override
    public User getUserByApiKey(String apiKey) {
        logger.info("market service: get user by Api Key");
        return repositoryUser.findByApiKey(apiKey);
    }

    private String[] getStrArray (String str){
        return str.split(",");
    }
}
