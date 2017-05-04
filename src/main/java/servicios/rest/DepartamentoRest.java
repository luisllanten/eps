package servicios.rest;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Departamento;
import javax.ws.rs.*;
import modelo.Contrato;


@Path("/departamento")
@Produces("application/json")
@Stateless
public class DepartamentoRest {
    
   @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Departamento buscar(@PathParam("id") Integer pId){
        return em.find(Departamento.class, pId);        
    }
       
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Departamento agregar(Departamento entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Departamento d = em.find(Departamento.class, pId);
        if(!d.equals(null)){
        em.remove(d);
        }else{
            System.out.println("Departamento no encontrado");
        }
        return Response.noContent().build();
    }   
}
