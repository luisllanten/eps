package servicios.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Afiliado;
import javax.ws.rs.*;


@Path("/afiliado")
@Produces("application/json")
@Stateless
public class AfiliadoRest {
    
    @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Afiliado buscar(@PathParam("id") Integer pId){
        return em.find(Afiliado.class, pId);        
    }
       
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Afiliado agregar(Afiliado entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Afiliado a = em.find(Afiliado.class, pId);
        if(!a.equals(null)){
        em.remove(a);
        }else{
            System.out.println("Afiliado no encontrado");
        }
        return Response.noContent().build();
    }   
}
