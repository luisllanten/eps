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
import modelo.Contrato;
import javax.ws.rs.*;
import modelo.Afiliado;
import modelo.Departamento;


@Path("/contrato")
//guarda sin estado
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
    
    @GET 
    @Produces("application/json")
    public List<Contrato> buscarTodos(){
        String jpql = "SELECT c FROM Contrato c";
        TypedQuery<Contrato> q = em.createQuery(jpql,Contrato.class);
        List<Contrato> resultado = q.getResultList();
        return resultado;
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
        if(c!=null){
        em.remove(c);
        }else{
            System.out.println("Contrato no encontrado");
        }
        return Response.noContent().build();
    } 
    
//     @POST
//     @Produces("application/json")
//    public Contrato adicionar(Contrato entity){
//        em.persist(entity);
//        em.flush();
//        return entity;
//    @Consumes("application/json")
//    public Contrato actualizar(Contrato c){
//        em.merge(c);  
//        return c;
//     }
//    }
}
