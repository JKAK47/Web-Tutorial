package org.vincent.strategy;

/**
 * Package: org.vincent.strategy
 * Created by PengRong on 2019/1/30.
 * ProjectName: Web-Tutorial
 */
public interface CalcSttlStrategy {
    /**
     * 该接口定义所有利息计算的接口约束
     *
     * @param name     账户名
     * @param calcDate 利息计算 截止日期
     * @return
     */
    double calcSttlStrategy(String name, String calcDate);
}
