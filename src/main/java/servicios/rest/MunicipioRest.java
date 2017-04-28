package servicios.rest;

import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import modelo.Municipio;
import modelo.PersistenciaBasica;
import javax.ws.rs.*;


@Path("/municipio")
@Produces("application/json")
public class MunicipioRest {
    
    @Inject PersistenciaBasica persistenciaBasica;
    
    @GET
    @Produces("application/json")
    public Collection<Municipio> listar(){
        return persistenciaBasica.listaMunicipio();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Municipio buscar(@PathParam("id") Long pId){
        System.out.println("buscando Municipio con id: "+pId);
        return persistenciaBasica.buscarMunicipio(pId);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Municipio agregar(Municipio mun){
        persistenciaBasica.crearMunicipio(mun);
        return mun;
    }
    
    @DELETE
    @Path("{id}")
    public Response borrar(@PathParam("id") Long pId){
        System.out.println("eliminando Municipio con id: "+pId);
        persistenciaBasica.eliminarMunicipio(pId);
        return Response.noContent().build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Municipio actualizar(Municipio mun){
        persistenciaBasica.actualizarMunicipio(mun);
        return mun;
    }
    
}
