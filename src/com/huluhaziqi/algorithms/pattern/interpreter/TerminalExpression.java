package com.huluhaziqi.algorithms.pattern.interpreter;

import java.util.StringTokenizer;

public class TerminalExpression extends Expression{

    private String literal = null;

    public TerminalExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()){
            String test = st.nextToken();
            if(test.equals(literal)){
                return true;
            }
        }
        return false;
    }
}
