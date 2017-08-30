package com.iqmsoft.service;

import fish.payara.micro.cdi.Inbound;
import fish.payara.micro.cdi.Outbound;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.iqmsoft.model.TestMsg;

import java.util.logging.Logger;

@ApplicationScoped
public class EvtService {
    @Inject
    @Outbound
    private Event<TestMsg> event;

    @Inject
    @Outbound(loopBack = true)
    private Event<TestMsg> logbackEvent;

    public void fireEvent(String msg) {
        Logger.getLogger(EvtService.class.getName()).info("message to be fired: " + msg);
        event.fire(TestMsg.builder().msg(msg).build());
    }

    public void fireLoopBackEvent(String msg) {
        Logger.getLogger(EvtService.class.getName()).info("message(which will be loopBack) to be fired: " + msg);
        logbackEvent.fire(TestMsg.builder().msg(msg).build());
    }

    public void observeEvent(@Observes @Inbound TestMsg myMessage) throws InterruptedException {
        Logger.getLogger(EvtService.class.getName()).info("message received: " + myMessage);
    }
}
