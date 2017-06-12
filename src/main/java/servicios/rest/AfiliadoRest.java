package servicios.rest;
//no  
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
import modelo.Afiliado;
import javax.ws.rs.*;

@Stateless
@Path("/afiliados")
public class AfiliadoRest {
    
    @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Afiliado buscar(@PathParam("id") Long pId){
        return em.find(Afiliado.class, pId);        
    }
       
    
    @GET 
    @Produces("application/json")
    public List<Afiliado> buscarTodos(){
        String jpql = "SELECT d FROM Departamento d";
        TypedQuery<Afiliado> q = em.createQuery(jpql,Afiliado.class);
        List<Afiliado> resultado = q.getResultList();
        return resultado;
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
         if(a!=null){
        em.remove(a);
        }else{
            System.out.println("Afiliado no encontrado");
        }
        return Response.noContent().build();
    }   
  }
