package servicios.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Contrato;
import javax.ws.rs.*;
import modelo.Afiliado;


@Path("/contrato")
@Produces("application/json")
@Stateless
public class ContratoRest {
    
   @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Contrato buscar(@PathParam("id") Integer pId){
        return em.find(Contrato.class, pId);        
    }
       
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Contrato agregar(Contrato entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Contrato c = em.find(Contrato.class, pId);
        if(!c.equals(null)){
        em.remove(c);
        }else{
            System.out.println("Contrato no encontrado");
        }
        return Response.noContent().build();
    }   
}
