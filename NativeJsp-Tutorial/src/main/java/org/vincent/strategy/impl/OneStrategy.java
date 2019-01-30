package org.vincent.strategy.impl;

import org.vincent.strategy.Account;
import org.vincent.strategy.CalcSttlStrategy;
import org.vincent.strategy.StrategyConst;

/**
 * Package: org.vincent.strategy
 * Created by PengRong on 2019/1/30.
 * ProjectName: Web-Tutorial
 */
public class OneStrategy implements CalcSttlStrategy,Account {
    @Override
    public String getAccountType() {
        return StrategyConst.ONE_TYPE;
    }

    @Override
    public double calcSttlStrategy(String name, String calcDate) {
        System.out.println("name :" + name + ", calcDate :" + calcDate);
        return 1000;
    }
}
