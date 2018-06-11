package lin.java.test.pattern.TemplateMethod;

public abstract class Beverage {

    final void prepareRecipe(){
        boilWater();
        brew();
        addCondiments();
        pourInCup();
    }

    void boilWater(){
        System.out.println("boilWater");
    }

    void pourInCup(){
        System.out.println("pourInWater");
    }

    abstract void brew();

    abstract void addCondiments();
}
