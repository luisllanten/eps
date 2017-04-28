package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.naming.ldap.HasControls;

@Singleton
public class PersistenciaBasica {
    
    private long id;
    private Map<Long, Ips> listaIps;
    private Map<Long, Afiliado> listaAfiliado;
    private Map<Long, Contrato> listaContrato;
    private Map<Long, Departamento> listaDepartamento;
    private Map<Long, Municipio> listaMunicipio;
    
    public PersistenciaBasica(){
        id = 0;
        listaIps = new HashMap<>();
        listaAfiliado = new HashMap<>();
        listaContrato = new HashMap<>();
        listaDepartamento = new HashMap<>();
        listaMunicipio = new HashMap<>();
    }
    
 //CRUD Ips
    public Ips crearIps(Ips ip){
    ip.setId(++id);
    listaIps.put(id, ip);
    return ip;
    }
    
    public Collection<Ips> listarIps(){
        return listaIps.values();
    }
    
    public Ips buscarIps(Long id){
        return listaIps.get(id);
    }
    
    public Ips actualizarIps(Ips ip){
        if(listaIps.containsKey(ip.getId())){
            listaIps.put(ip.getId(), ip);
            
        }
        return ip;
    }
    
    public boolean eliminarIps(Long id){
        if(listaIps.containsKey(id)){
            listaIps.remove(id);
            return true;
        }
        else return false;        
    }
    
    //CRUD Afiliado
    public Afiliado crearAfiliado(Afiliado af){
    af.setId(++id);
    listaAfiliado.put(id, af);
    return af;
    }
    
    public Collection<Afiliado> listarAfiliado(){
        return listaAfiliado.values();
    }
    
    public Afiliado buscarAfiliado(Long id){
        return listaAfiliado.get(id);
    }
    
    public Afiliado actualizarAfiliado(Afiliado af){
        if(listaAfiliado.containsKey(af.getId())){
            listaAfiliado.put(af.getId(), af);
            
        }
        return af;
    }
    
    public boolean eliminarAfiliado(Long id){
        if(listaAfiliado.containsKey(id)){
            listaAfiliado.remove(id);
            return true;
        }
        else return false;        
    }
    
    //CRUD Contrato
    public Contrato crearContrato(Contrato con){
    con.setId(++id);
    listaContrato.put(id, con);
    return con;
    }
    
    public Collection<Contrato> listarContrato(){
        return listaContrato.values();
    }
    
    public Contrato buscarContrato(Long id){
        return listaContrato.get(id);
    }
    
    public Contrato actualizarContrato(Contrato con){
        if(listaContrato.containsKey(con.getId())){
            listaContrato.put(con.getId(), con);
            
        }
        return con;
    }
    
    public boolean eliminarContrato(Long id){
        if(listaContrato.containsKey(id)){
            listaContrato.remove(id);
            return true;
        }
        else return false;        
    }
    
    public Municipio crearMunicipio(Municipio mun){
    mun.setId(++id);
    listaMunicipio.put(id, mun);
    return mun;
    }
    
    public Collection<Municipio> listaMunicipio(){
        return listaMunicipio.values();
    }
    
    public Municipio buscarMunicipio(Long id){
        return listaMunicipio.get(id);
    }
    
    public Municipio actualizarMunicipio(Municipio mun){
        if(listaMunicipio.containsKey(mun.getId())){
            listaMunicipio.put(mun.getId(), mun);
            
        }
        return mun;
    }
    
    public boolean eliminarMunicipio(Long id){
        if(listaMunicipio.containsKey(id)){
            listaMunicipio.remove(id);
            return true;
        }
        else return false;        
    }
    
    public Departamento crearDepartamento(Departamento dep){
    dep.setId(++id);
    listaDepartamento.put(id, dep);
    return dep;
    }
    
    public Collection<Departamento> listaDepartamento(){
        return listaDepartamento.values();
    }
    
    public Departamento buscarDepartamento(Long id){
        return listaDepartamento.get(id);
    }
    
    public Departamento actualizarDepartamento(Departamento dep){
        if(listaDepartamento.containsKey(dep.getId())){
            listaDepartamento.put(dep.getId(), dep);
            
        }
        return dep;
    }
    
    public boolean eliminarDepartamento(Long id){
        if(listaDepartamento.containsKey(id)){
            listaDepartamento.remove(id);
            return true;
        }
        else return false;        
    }
}
