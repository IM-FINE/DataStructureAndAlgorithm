package com.jyh.stack;

import java.util.ArrayList;

/**
 * @Author: jyh
 * @Date: 2019/12/26
 * @Description: com.jyh.stack
 * @version: 1.0
 */
public class PolandNotationDemo {
    public static void main(String[] args) {
        String expression = "((11+42)*52+632)*2322-12*3"; //7,866,900
        //中缀转List
        ArrayList<String> infix = PolandNotationUtils.toInfixExpressionList(expression);
        System.out.println(infix);
        //中缀List转后缀List
        ArrayList<String> suffix = PolandNotationUtils.parseSuffixExpressionList(infix);
        System.out.println(suffix);
        //计算后缀List
        int res=PolandNotationUtils.calculate(suffix);
        System.out.println(res);
    }

}
