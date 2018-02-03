package fr.elfoa.hello.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Pierre Colomb
 */
@Path("hello")
public class HelloWorld {

    @GET
    public String getHello() {
        return "Hello World!";
    }

    // ajout

    @GET
    @Path("test")
    public int getInt(){
                return 1;
            }

    @GET
    @Path("{doc}")
    public String getDoctor(@PathParam("doc")
                                    String name) {
            return name + "1";
    }
}
