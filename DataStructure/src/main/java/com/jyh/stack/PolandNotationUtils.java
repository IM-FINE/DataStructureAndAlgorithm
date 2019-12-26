package com.jyh.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: jyh
 * @Date: 2019/12/26
 * @Description: com.jyh.stack
 * @version: 1.0
 */
class PolandNotationUtils {
    private static int i; //辅助指针，用于扫描中缀表达式
    private static String str; //用于多位数拼接
    private static char c; //用于保存字符

    //中缀表达式转为ArrayList
    public static ArrayList<String> toInfixExpressionList(String s) {
        ArrayList<String> ls = new ArrayList<String>();
        while (i < s.length()) { //从左到右扫描
            c = s.charAt(i);
            if (c >= 48 && c <= 57) { //如果是数字
                str = "";//先清空
                while (true) {
                    if (c >= 48 && c <= 57) { //如果接下来也是数字
                        str += c;
                        i++;
                        if (i < s.length()) { //如果没有到最后
                            c = s.charAt(i);
                        } else {
                            break;
                        }
                    } else { //如果接下来不是数字
                        break;
                    }
                }
                ls.add(str);
            } else { //如果不是数字
                ls.add("" + c);
                i++;
            }
        }
        return ls;
    }

    //优先级比较
    public static int getPriority(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                break;
        }
        return res;
    }

    //中缀List转为后缀List
    public static ArrayList<String> parseSuffixExpressionList(ArrayList<String> ls) {
        //创建栈，存放符号
        Stack<String> stack = new Stack<>();
        //创建ArrayList，存放结果
        ArrayList<String> resList = new ArrayList<>();
        //遍历中缀List
        for (String item : ls) {
            if (item.matches("\\d+")) { //如果是数字
                resList.add(item);
            } else if (item.equals("(")) { //如果是"("，直接入栈
                stack.push(item);
            } else if (item.equals(")")) { //如果是")",弹出符号并加入List
                while (true) {
                    if (!(stack.peek().equals("("))) { //只要没有遇到"("就一直弹
                        resList.add(stack.pop());
                    } else { //遇到"("就弹出"("并结束循环
                        stack.pop();
                        break;
                    }
                }

            } else { //如果是符号，判断优先级
                while (true) {
                    if (stack.size() == 0 || getPriority(item) > getPriority(stack.peek())) { //栈为空或者优先级如果大于栈顶元素
                        break;
                    } else { //如果优先级小于等于栈顶元素，弹出符号并加入List
                        resList.add(stack.pop());
                    }
                }
                //当前符号入栈
                stack.push(item);
            }
        }
        //遍历完成后，栈中还有元素，依次弹出加入List
        while (true) {
            if (stack.size() != 0) {
                resList.add(stack.pop());
            } else {
                break;
            }
        }
        return resList;
    }

    //计算后缀表达式List
    public static int calculate(List<String> ls) {
        Stack<String> s = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) { //如果是数字，入栈
                s.push(item);
            } else { //如果是符号，弹出两个数字进行运算再将结果入栈
                int num2 = Integer.parseInt(s.pop());
                int num1 = Integer.parseInt(s.pop());
                int res = -9999;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    System.out.println("符号不对");
                }
                s.push("" + res);
            }
        }
        //留在栈中的元素就是结果
        return Integer.parseInt(s.pop());
    }
}
