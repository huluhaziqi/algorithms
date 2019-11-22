package com.huluhaziqi.algorithms.pattern.memento;

public class PreviousCalculation implements PreviousCalculationToOriginator, PreviousCalculationToCarTaker {

    private int firstNumber;

    private int secondNumber;


    public PreviousCalculation(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}
