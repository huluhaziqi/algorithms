package lin.java.test.pattern.memento;

public interface Calculator {

    PreviousCalculationToCarTaker backupLastCalculation();

    void restorePreviousCalculation(PreviousCalculationToCarTaker calculationToCarTaker);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}
