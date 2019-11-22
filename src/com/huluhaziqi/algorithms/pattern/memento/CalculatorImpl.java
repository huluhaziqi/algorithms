package com.huluhaziqi.algorithms.pattern.memento;

public class CalculatorImpl implements Calculator {

    private int firstNumber;

    private int secondNumber;

    @Override
    public PreviousCalculationToCarTaker backupLastCalculation() {
        return new PreviousCalculation(firstNumber, secondNumber);
    }

    @Override
    public void restorePreviousCalculation(PreviousCalculationToCarTaker calculationToCarTaker) {
        this.firstNumber = ((PreviousCalculationToOriginator) calculationToCarTaker).getFirstNumber();
        this.secondNumber = ((PreviousCalculationToOriginator) calculationToCarTaker).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
        return firstNumber + secondNumber;
    }

    @Override
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public CalculatorImpl() {
    }
}
