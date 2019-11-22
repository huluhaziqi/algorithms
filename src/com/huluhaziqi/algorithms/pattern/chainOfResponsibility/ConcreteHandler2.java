package com.huluhaziqi.algorithms.pattern.chainOfResponsibility;

public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handlerRequest(Request request) {
        if(request.getType() == RequestTypeEnum.type2){
            System.out.println(request.getName() + " handle by handler2");
            return;
        }
        if(successor != null){
            successor.handlerRequest(request);
        }
    }
}
