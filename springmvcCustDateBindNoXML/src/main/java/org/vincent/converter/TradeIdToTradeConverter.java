package org.vincent.converter;

import org.springframework.core.convert.converter.Converter;
import org.vincent.TradeService;
import org.vincent.pojo.Trade;

/**
 * @author PengRong
 * @package org.vincent.converter
 * @ClassName TradeIdToTradeConverter.java
 * @date 2019/6/10 - 23:16
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class TradeIdToTradeConverter implements Converter<String,Trade>{
    private TradeService tradeService;

    public TradeIdToTradeConverter (TradeService tradeService) {
        this.tradeService = tradeService;
    }
    @Override
    public Trade convert(String id) {
        try {
            Long tradeId = Long.valueOf(id);
            return tradeService.getTradeById(tradeId);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
