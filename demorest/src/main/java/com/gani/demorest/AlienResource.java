package com.gani.demorest;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource 
{
    AlienRepository repo = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Alien> getAliens()
    {
        System.out.println("getAlien called..");
        return repo.getAliens();
    }

    @GET
    @Path("alien/101")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Alien getAlien()
    {
        return repo.getAlien(101);
    }

    @POST //CREATION OF RESOURCE or DATA
    @Path("alien")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Alien createAlien(Alien a1)
    {
        System.out.println(a1);
        repo.create(a1);
        return a1;
    }

    @PUT //updating
    @Path("alien")
    //@Consumes(MediaType.APPLICATION_XML)//only to support XML
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Alien updateAlien(Alien a1)
    {
        System.out.println(a1);
        if(repo.getAlien(a1.getId()).getId()==0) {
            repo.create(a1);
        } else {
            repo.update(a1);
        }
        return a1;
    }

    @DELETE
    // Specify the path with the manually provided ID here
    @Path("alien/202") // here i am using id(202) to delete the id

    public Alien killAlien() {
        int id = 202; // Manually provided ID
        Alien a = repo.getAlien(id);
        if (a.getId() != 0) {
            repo.delete(id);
        }
        return a;
    }
}


//http://localhost:8082/demorest/webresources/aliens/alien -------->POST
//http://localhost:8082/demorest/webresources/aliens -------->GET
//http://localhost:8082/demorest/webresources/aliens/alien/202 ----> DELETE

