/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Afiliado;
import modelo.Afiliado_Contrato;

/**
 *
 * @author 1061696462
 */
    
    
@Path("/afiliado_contrato")
@Stateless
public class Afiliado_ContratoRest {
    
    @PersistenceContext(unitName = "epsPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Afiliado_Contrato buscar(@PathParam("id") Integer pId){
        return em.find(Afiliado_Contrato.class, pId);        
    }
    
    @GET 
    @Produces("application/json")
    public List<Afiliado_Contrato> buscarTodos(){
        String jpql = "SELECT d FROM Departamento d";
        TypedQuery<Afiliado_Contrato> q = em.createQuery(jpql,Afiliado_Contrato.class);
        List<Afiliado_Contrato> resultado = q.getResultList();
        return resultado;
    }
      
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Afiliado_Contrato agregar(Afiliado_Contrato entity){
       em.persist(entity);
       em.flush();
       return entity;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        Afiliado_Contrato a = em.find(Afiliado_Contrato.class, pId);
         if(a!=null){
        em.remove(a);
        }else{
            System.out.println("Afiliado no encontrado");
        }
        return Response.noContent().build();
    }   
}
 
