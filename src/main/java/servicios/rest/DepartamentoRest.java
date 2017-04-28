package servicios.rest;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Departamento;
import modelo.PersistenciaBasica;
import javax.ws.rs.*;


@Path("/Departamento")
@Produces("application/json")
public class DepartamentoRest {
    
    @Inject PersistenciaBasica persistenciaBasica;
    
    @GET
    @Produces("application/json")
    public Collection<Departamento> listar(){
        return persistenciaBasica.listaDepartamento();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Departamento buscar(@PathParam("id") Long pId){
        System.out.println("buscando Departamento con id: "+pId);
        return persistenciaBasica.buscarDepartamento(pId);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Departamento agregar(Departamento dep){
        persistenciaBasica.crearDepartamento(dep);
        return dep;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        System.out.println("eliminando Departamento con id: "+pId);
        persistenciaBasica.eliminarDepartamento(pId);
        return Response.noContent().build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Departamento actualizar(Departamento dep){
        persistenciaBasica.actualizarDepartamento(dep);
        return dep;
    }
    
}
