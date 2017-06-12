/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ims.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import modelo.Contrato;
import servicios.rest.ContratoRest;

/**
 *
 * @author Luis Llanten
 */
@ManagedBean
@SessionScoped
public class ContratoBean {

       @Inject ContratoRest contratoRest;
       
    private List<Contrato> contratos;    
    private Contrato contrato;

    public ContratoBean() {
    }
    
    @PostConstruct
    public void init(){
        contratos = contratoRest.buscarTodos();
        contrato = new Contrato();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        contratoRest.agregar(contrato);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se guardo con exito!") );
    }
    
//    public String eliminar(Contrato contrato){
//        contratoRest.borrar(contrato.getId());
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
//        init();
//        return null;
//    }

    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        departamentoRest.actualizar(departamento);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se actualizo con exito!") );
//    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
