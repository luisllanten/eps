package servicios.rest;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Afiliado;
import modelo.PersistenciaBasica;
import javax.ws.rs.*;


@Path("/afiliado")
@Produces("application/json")
public class AfiliadoRest {
    
    @Inject PersistenciaBasica persistenciaBasica;
    
    @GET
    @Produces("application/json")
    public Collection<Afiliado> listar(){
        return persistenciaBasica.listarAfiliado();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Afiliado buscar(@PathParam("id") Long pId){
        System.out.println("buscando afiliado con id: "+pId);
        return persistenciaBasica.buscarAfiliado(pId);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Afiliado agregar(Afiliado af){
        persistenciaBasica.crearAfiliado(af);
        return af;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        System.out.println("eliminando afiliado con id: "+pId);
        persistenciaBasica.eliminarAfiliado(pId);
        return Response.noContent().build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Afiliado actualizar(Afiliado af){
        persistenciaBasica.actualizarAfiliado(af);
        return af;
    }
    
}
