package com.huluhaziqi.algorithms.pattern.interpreter;

public class Client {


    public static Expression buildTree(){
        Expression temminal1 = new TerminalExpression("A");
        Expression temminal2 = new TerminalExpression("B");
        Expression temminal3 = new TerminalExpression("C");
        Expression temminal4 = new TerminalExpression("D");

        Expression alter1 = new OrExpression(temminal2,temminal3);//B OR C
        Expression alter2 = new OrExpression(temminal1,alter1);
        return new AndExpression(temminal4,alter2);
    }
    public static void main(String[] args) {

        Expression expression = buildTree();
        String str1 = "D A";

        String str2 = "D A E";
        System.out.println(expression.interpret(str1));
        System.out.println(expression.interpret(str2));
    }
}
