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
public class DepartamentoBean {
    
    @Inject DepartamentoRest departamentoRest;
       
    private List<Departamento> departamentos;    
    private Departamento departamento;

    public DepartamentoBean() {
    }
    
    @PostConstruct
    public void init(){
        departamentos = departamentoRest.buscarTodos();
        departamento = new Departamento();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        departamentoRest.agregar(departamento);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se guardo con exito!") );
    }
    
    public String eliminar(Departamento departamento){
        departamentoRest.borrar(departamento.getCodigo());
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
        init();
        return null;
    }

    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        departamentoRest.actualizar(departamento);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se actualizo con exito!") );
//    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

   
    
}
