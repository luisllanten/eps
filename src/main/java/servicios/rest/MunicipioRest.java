package servicios.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Municipio;
import javax.ws.rs.*;
import modelo.Ips;


@Path("/municipio")
@Produces("application/json")
@Stateless
public class MunicipioRest {
    
    @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Municipio buscar(@PathParam("id") Integer pId){
        return em.find(Municipio.class, pId);        
    }
       
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Municipio agregar(Municipio entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Municipio m = em.find(Municipio.class, pId);
        if(!m.equals(null)){
        em.remove(m);
        }else{
            System.out.println("Ips no encontrado");
        }
        return Response.noContent().build();
    }   
}