/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ims.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.Departamento;
import modelo.Municipio;
import servicios.rest.DepartamentoRest;
import servicios.rest.MunicipioRest;

/**
 *
 * @author Personal
 */
@ManagedBean
@SessionScoped
public class MunicipioBean {
    
    @Inject MunicipioRest municipioRest;
       
    private List<Municipio> municipios;    
    private Municipio municipio;

    public MunicipioBean() {
    }
    
    @PostConstruct
    public void init(){
        municipios = municipioRest.buscarTodos();
        municipio = new Municipio();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        municipioRest.agregar(municipio);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se guardo con exito!") );
    }
    
    public String eliminar(Departamento municipio){
        municipioRest.borrar(municipio.getCodigo());
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
        init();
        return null;
    }

    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        municipioRest.actualizar(municipio);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se actualizo con exito!") );
//    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
