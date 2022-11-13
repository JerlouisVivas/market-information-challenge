package com.challenge.stock.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketInformationOut {
    private String openPrice;
    private String higherPrice;
    private String lowerPrice;
    private String variationClosePrices;
}
