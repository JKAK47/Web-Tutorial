package org.vincent.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName Trade.java
 * @date 2019/6/10 - 23:14
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Data
public class Trade {
    private long tradeId;
    private String buySell;
    private String buyCurrency;
    private String sellCurrency;
}
