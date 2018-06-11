package lin.java.test.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Coposite extends Component {

    private List<Component> child;

    public Coposite(String name) {
        super(name);
        child = new ArrayList<>();
    }

    @Override
    void print(int level) {
        System.out.println("level" + level);
        System.out.println("Composite:" + name);
        for (Component c : child) {
            c.print(level + 1);
        }
    }

    @Override
    public void add(Component component) {
        child.add(component);
    }

    @Override
    public void remove(Component component) {
        if (child.indexOf(component) > 0) {
            child.remove(component);
        }
    }
}
