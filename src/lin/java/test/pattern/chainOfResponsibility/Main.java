package lin.java.test.pattern.chainOfResponsibility;

public class Main {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        Request request1 = new Request(RequestTypeEnum.type1,"request1");

        Request request2 = new Request(RequestTypeEnum.type2,"request2");

        handler1.handlerRequest(request1);
        handler1.handlerRequest(request2);


        handler2.handlerRequest(request1);
        handler2.handlerRequest(request2);
    }
}
