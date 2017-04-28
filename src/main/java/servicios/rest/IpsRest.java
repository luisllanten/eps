package servicios.rest;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Ips;
import modelo.PersistenciaBasica;
import javax.ws.rs.*;


@Path("/ips")
@Produces("application/json")
public class IpsRest {
    
    @Inject PersistenciaBasica persistenciaBasica;
    
    @GET
    @Produces("application/json")
    public Collection<Ips> listar(){
        return persistenciaBasica.listarIps();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Ips buscar(@PathParam("id") Long pId){
        System.out.println("buscando ips con id: "+pId);
        return persistenciaBasica.buscarIps(pId);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Ips agregar(Ips ip){
        persistenciaBasica.crearIps(ip);
        return ip;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        System.out.println("eliminando ips con id: "+pId);
        persistenciaBasica.eliminarIps(pId);
        return Response.noContent().build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Ips actualizar(Ips ip){
        persistenciaBasica.actualizarIps(ip);
        return ip;
    }
    
}
