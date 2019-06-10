package org.vincent.controller;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName TradeController.java
 * @date 2019/6/10 - 23:24
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.pojo.Trade;

@RestController
@RequestMapping("trades")
public class TradeController {
    @RequestMapping(value = "/{trade}")
    public String handleTradeRequest (Trade trade, Model model) {
        System.out.println(trade);
        if (trade.getTradeId() == 0) {
            model.addAttribute("msg", "No trade found");
            return "no-trade-page";
        }
        model.addAttribute("trade", trade);
        return "trade-page";
    }
}
