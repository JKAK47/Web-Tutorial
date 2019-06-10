package org.vincent;

import org.vincent.pojo.Trade;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author PengRong
 * @package org.vincent.converter
 * @ClassName TradeService.java
 * @date 2019/6/10 - 23:17
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class TradeService {
    private HashMap<Long, Trade> trades = new HashMap<>();

    @PostConstruct
    private void postConstruct() {
        //just populating with some dummy data
        //in real application will get the data from a database
        List<Currency> ccy = new ArrayList(Currency.getAvailableCurrencies());
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 1; i <= 10; i++) {
            Trade trade = new Trade();
            trade.setTradeId(i);
            trade.setBuySell(Math.random() > 0.5 ? "Buy" : "Sell");
            trade.setBuyCurrency(ccy.get(rnd.nextInt(0, ccy.size()))
                    .getCurrencyCode());
            trade.setSellCurrency(ccy.get(rnd.nextInt(0, ccy.size()))
                    .getCurrencyCode());
            trades.put((long) i, trade);
        }
    }

    public Trade getTradeById(long id) {
        return trades.get(id);

    }

    public List<Trade> getAllTrades() {
        return new ArrayList<>(trades.values());
    }
}
