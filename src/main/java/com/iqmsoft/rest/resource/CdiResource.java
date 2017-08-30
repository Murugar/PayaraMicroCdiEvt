package com.iqmsoft.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.iqmsoft.service.EvtService;

import java.util.logging.Logger;

@Path("")
public class CdiResource {
    private EvtService eventService;

    @Inject
    public CdiResource(EvtService eventService) {
        this.eventService = eventService;
    }

    @GET
    public String fireClusteredEvent(@QueryParam("msg") String msg) {
        Logger.getLogger(CdiResource.class.getName()).info("message: " + msg);
        eventService.fireEvent(msg);
        return "DONE";
    }

    @Path("loop-back")
    @GET
    public String fireClusteredLoogBackEvent(@QueryParam("msg") String msg) {
        Logger.getLogger(CdiResource.class.getName()).info("message: " + msg);
        eventService.fireLoopBackEvent(msg);
        return "DONE";
    }
}
