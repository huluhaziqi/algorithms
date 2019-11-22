package com.huluhaziqi.algorithms.pattern.TemplateMethod;

public class Client {

    public static void main(String[] args) {
        CaffeBeverage caffeBeverage = new CaffeBeverage();
        caffeBeverage.prepareRecipe();
        Tea tea = new Tea();
        tea.prepareRecipe();
    }
}
