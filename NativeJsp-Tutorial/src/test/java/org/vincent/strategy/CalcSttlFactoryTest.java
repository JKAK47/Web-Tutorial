package org.vincent.strategy;

import org.junit.Test;

import java.util.Date;

/**
 * Package: org.vincent.strategy
 * Created by PengRong on 2019/1/30.
 * ProjectName: Web-Tutorial
 * https://blog.csdn.net/kcp606/article/details/79435757
 */
public class CalcSttlFactoryTest {
    @Test
    public void calcSttlStrategyTest() throws Exception {
        CalcSttlFactory factory =new CalcSttlFactory();
        factory.calcSttlStrategy("ONE_TYPE",StrategyConst.ONE_TYPE,new Date().toString());
        factory.calcSttlStrategy("sdfasdf",StrategyConst.TWO_TYPE,new Date().toString());
        factory.calcSttlStrategy("THRESS_TYPE",StrategyConst.THRESS_TYPE,new Date().toString());
    }
}
