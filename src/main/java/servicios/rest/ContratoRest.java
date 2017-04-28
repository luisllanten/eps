package servicios.rest;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Contrato;
import modelo.PersistenciaBasica;
import javax.ws.rs.*;


@Path("/contrato")
@Produces("application/json")
public class ContratoRest {
    
    @Inject PersistenciaBasica persistenciaBasica;
    
    @GET
    @Produces("application/json")
    public Collection<Contrato> listar(){
        return persistenciaBasica.listarContrato();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Contrato buscar(@PathParam("id") Long pId){
        System.out.println("buscando contrato con id: "+pId);
        return persistenciaBasica.buscarContrato(pId);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Contrato agregar(Contrato con){
        persistenciaBasica.crearContrato(con);
        return con;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        System.out.println("eliminando contrato con id: "+pId);
        persistenciaBasica.eliminarContrato(pId);
        return Response.noContent().build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Contrato actualizar(Contrato con){
        persistenciaBasica.actualizarContrato(con);
        return con;
    }
    
}
