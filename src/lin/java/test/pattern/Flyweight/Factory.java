package lin.java.test.pattern.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    Flyweight get(String in) {
        if (!flyweightMap.containsKey(in)) {
            Flyweight flyweight = new ConcreteFly(in);
            flyweightMap.put(in, flyweight);
        }
        return flyweightMap.get(in);
    }
}
