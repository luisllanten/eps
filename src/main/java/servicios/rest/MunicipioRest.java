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
import modelo.Municipio;
import javax.ws.rs.*;
import modelo.Ips;


@Path("/municipios")
@Stateless
public class MunicipioRest {
    
    @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @Inject SingletonEJB singletonEJB; 
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Municipio buscar(@PathParam("id") Integer pId){
        return em.find(Municipio.class, pId);        
    }
    
    @GET
    @Produces("application/json")   
     public List <Municipio> buscarTodos(){
        String jpql = "SELECT p FROM Municipio p";
        TypedQuery <Municipio> q = em.createQuery(jpql,Municipio.class);
        List <Municipio> resultado = q.getResultList();
        return resultado;
    }

      public Municipio actualizar(Municipio p){
        em.merge(p);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
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
         if(m!=null){
        em.remove(m);
        }else{
            System.out.println("Ips no encontrado");
        }
        return Response.noContent().build();
    }   
}