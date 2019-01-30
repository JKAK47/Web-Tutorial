package org.vincent.strategy;

import org.vincent.strategy.impl.OneStrategy;
import org.vincent.strategy.impl.ThreeStrategy;
import org.vincent.strategy.impl.TwoStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Package: org.vincent.strategy
 * Created by PengRong on 2019/1/30.
 * ProjectName: Web-Tutorial 策略工厂, 定义一个算法骨架 流程
 */
public class CalcSttlFactory {
    private static Map<String, CalcSttlStrategy> calcSttlMap = new HashMap<>(7);

    static {
        /* 字典 加 策略模式 消除 if - else
        * 以利息计算类型为 key，
        * 对应的计算策略为 value 建立 类型和算子的 映射关系。 */
        calcSttlMap.put(StrategyConst.ONE_TYPE, new OneStrategy());
        calcSttlMap.put(StrategyConst.TWO_TYPE, new TwoStrategy());
        calcSttlMap.put(StrategyConst.THRESS_TYPE, new ThreeStrategy());
    }

    /**
     * 设定计算利息的算法骨架 ，具体每种类型利息计算方式有不同的策略实现
     * @param name 利息计算账号名
     * @param calcType 计算利息类型
     * @param calcDate 利息计算时间截止日期
     * @return
     */
    public double calcSttlStrategy(String name, String calcType, String calcDate) throws Exception {
        /* 参数校验 */
        checkParam(name,calcType,calcDate);
        /* 第二步： 计算calcType 类型的利息*/
        CalcSttlStrategy sttlStrategy = calcSttlMap.get(calcType);
        double result=0;
        if (Objects.nonNull(sttlStrategy)) {
            result = sttlStrategy.calcSttlStrategy(name, calcDate);
        }
        /* 第三步： 计算完之后的其他业务操作 */
        System.out.println("calcSttl = "+result);
        return result;
    }

    private void checkParam(String name, String calcType, String calcDate) throws Exception {
        if (Objects.isNull(name) || Objects.isNull(calcType) || Objects.isNull(calcDate)){
            throw  new  Exception("参数不合法");
        }
    }
}
