package org.vincent.strategy.impl;

import org.vincent.strategy.Account;
import org.vincent.strategy.CalcSttlStrategy;
import org.vincent.strategy.StrategyConst;

/**
 * Package: org.vincent.strategy.impl
 * Created by PengRong on 2019/1/30.
 * ProjectName: Web-Tutorial
 */
public class ThreeStrategy implements CalcSttlStrategy,Account {
    @Override
    public String getAccountType() {
        return StrategyConst.THRESS_TYPE;
    }

    @Override
    public double calcSttlStrategy(String name, String calcDate) {
        System.out.println("name :" + name + ", calcDate :" + calcDate);
        return 3000;
    }
}
