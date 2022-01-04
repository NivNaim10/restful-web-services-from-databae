/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.apiexample.server;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("HelloWorld")
@RequestScoped
public class HelloWorldResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorldResource
     */
    public HelloWorldResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.apiexample.server.HelloWorldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getJson() {
        
        return "<html><body>Hey Niv!</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of HelloWorldResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.TEXT_HTML)
    public void postJson(String content) {
    }
}
