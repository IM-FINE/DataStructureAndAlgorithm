package com.jyh.stack;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.stack
 * @version: 1.0
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        String expression = "288+2*6-12";
        //创建两个栈，一个数栈（存放数字），一个符号栈（存放符号）
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;//辅助指针，用于扫描
        int num1;
        int num2;
        int oper;
        int res;
        char ch = ' ';//每次扫满得到得到的char保存到ch
        String keepNums = "";//用于接收多位数
        //开始扫面
        while (true) {
            //依次得到表达式的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //根据ch是什么来做相应的处理
            if (isOper(ch)) { //如果是运算符
                //判断符号栈是否为空
                if (operStack.isEmpty()) {
                    //直接入栈
                    operStack.push(ch);
                } else {
                    //不为空，进行优先级比较
                    if (priority(ch) <= priority(operStack.peek())) {
                        //如果优先级小于等于栈中元素
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num1, num2, oper);
                        //计算完成后将结果入栈
                        numStack.push(res);
                        //将当前运算符入栈
                        operStack.push(ch);
                    } else {
                        //如果优先级大于栈中元素
                        //直接入栈
                        operStack.push(ch);
                    }
                }
            } else { //如果不是运算符
                //直接入数栈
                //numStack.push(ch - 48);//-48是因为1在ascii表的49号上
                //上一步只考虑了一位数
                //如果不是运算符，则拼接
                keepNums += ch;
                //如果index到最后了
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNums));
                }
                //如果是运算符
                else if (isOper(expression.charAt(index + 1))) {
                    //入栈
                    numStack.push(Integer.parseInt(keepNums));
                    //入完栈之后清空keepNums
                    keepNums = "";
                }

            }
            //让index+1
            index++;
            //如果扫描到最后了，退出循环
            if (index >= expression.length()) {
                break;
            }
        }
        //扫面完毕后，计算栈中剩余元素
        while (true) {
            if (operStack.isEmpty()) {
                //如果符号栈为空
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            //计算完成后将结果入栈
            numStack.push(res);
        }
        //最后留在栈中的数字即为最后的结果
        System.out.printf("表达式：%s=%d", expression, numStack.pop());

    }

    //判断优先级,返回的值越大，优先级越高
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否是运算符
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算两个数
    public static int cal(int num1, int num2, int oper) {
        int res = -1;//用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
