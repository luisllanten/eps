package servicios.rest;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Departamento;
import javax.ws.rs.*;


@Stateless
@Path("/departamentos")
public class DepartamentoRest {
    
   @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Departamento buscar(@PathParam("id") Long pId){
        return em.find(Departamento.class, pId);        
    }
       
    
    @GET 
    @Produces("application/json")
    public List<Departamento> buscarTodos(){
        String jpql = "SELECT d FROM Departamento d";
        TypedQuery<Departamento> q = em.createQuery(jpql,Departamento.class);
        List<Departamento> resultado = q.getResultList();
        return resultado;
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
         if(d!=null){
        em.remove(d);
        }else{
            System.out.println("Departamento no encontrado");
        }
        return Response.noContent().build();
    }   
}
