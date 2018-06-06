package lin.java.test.pattern.factory;

public class Product2Factory extends Factory {

    @Override
    public Product factoryMethod(){
        return new Product2();
    }
}
