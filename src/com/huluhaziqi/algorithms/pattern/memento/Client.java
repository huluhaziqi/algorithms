package com.huluhaziqi.algorithms.pattern.memento;

public class Client {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        calculator.setFirstNumber(100);
        calculator.setSecondNumber(200);

        System.out.println(calculator.getCalculationResult());


        PreviousCalculationToCarTaker previousCalculationToCarTaker = calculator.backupLastCalculation();

        calculator.setFirstNumber(300);
        calculator.setSecondNumber(400);

        System.out.println(calculator.getCalculationResult());


        calculator.restorePreviousCalculation(previousCalculationToCarTaker);

        System.out.println(calculator.getCalculationResult());
    }
}
