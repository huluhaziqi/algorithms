package com.huluhaziqi.algorithms.pattern.chainOfResponsibility;

public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handlerRequest(Request request) {
        if (request.getType() == RequestTypeEnum.type1) {
            System.out.println(request.getName() + " handle by handler1");
            return;
        }
        if (successor != null) {
            successor.handlerRequest(request);
        }
    }
}
