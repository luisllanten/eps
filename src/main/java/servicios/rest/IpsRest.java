package servicios.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Ips;
import javax.ws.rs.*;
import modelo.Departamento;


@Path("/ips")
@Produces("application/json")
@Stateless
public class IpsRest {
    
   @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Ips buscar(@PathParam("id") Integer pId){
        return em.find(Ips.class, pId);        
    }
       
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Ips agregar(Ips entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Ips i = em.find(Ips.class, pId);
        if(!i.equals(null)){
        em.remove(i);
        }else{
            System.out.println("Ips no encontrado");
        }
        return Response.noContent().build();
    }   
}