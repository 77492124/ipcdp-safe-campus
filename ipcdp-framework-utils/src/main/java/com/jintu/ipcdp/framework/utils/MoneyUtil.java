package com.jintu.ipcdp.framework.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Classname MoneyUtil
 * @Description 金额转换工具类
 * @Date 2019/12/1 9:35
 * @Created by wjh
 */
public class MoneyUtil {
    /**
     * 元转分，确保price保留两位有效数字
     * @return
     */
    public static int changeY2F(double price) {
        DecimalFormat df = new DecimalFormat("#.00");
        price = Double.valueOf(df.format(price));
        int money = (int)(price * 100);
        return money;
    }

    /**
     * 分转元，转换为bigDecimal在toString
     * @return
     */
    public static String changeF2Y(int price) {
        return BigDecimal.valueOf(Long.valueOf(price)).divide(new BigDecimal(100)).toString();
    }

    public static void main(String[] args) {
        System.out.println(changeY2F(1.222222));
        System.out.println(changeF2Y(1005));
    }
}
