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
import modelo.Afiliado_Contrato;
import servicios.rest.AfiliadoRest;
import servicios.rest.Afiliado_ContratoRest;

/**
 *
 * @author Luis Llanten
 */
@ManagedBean
@SessionScoped
public class Afiliado_ContratoBean{

    @Inject Afiliado_ContratoRest afiliado_contratoRest;
       
    private List<Afiliado_Contrato> afiliado_contratos;    
    private Afiliado_Contrato afiliado_contrato;

    public Afiliado_ContratoBean() {
    }
    
    @PostConstruct
    public void init(){
        afiliado_contratos = afiliado_contratoRest.buscarTodos();
        afiliado_contrato = new Afiliado_Contrato();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        afiliado_contratoRest.agregar(afiliado_contrato);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Afiliado_Contrato",  "Se guardo con exito!") );
    }
    
//    public String eliminar(Contrato contrato){
//        contratoRest.borrar(contrato.getId());
////        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente ") );
//        init();
//        return null;
//    }

    
//    public void actualizar(){
//        System.out.println("Actualizar...");
//        departamentoRest.actualizar(departamento);
//        init();
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se actualizo con exito!") );
//    }

    public List<Afiliado_Contrato> getAfiliado_Contratos() {
        return afiliado_contratos;
    }

    public void setAfiliado_Contratos(List<Afiliado_Contrato> afiliado_Contratos) {
        this.afiliado_contratos = afiliado_contratos;
    }

    public Afiliado_Contrato getAfiliado_Contrato() {
        return afiliado_contrato;
    }

    public void setAfiliado_Contrato(Afiliado_Contrato afiliado_Contrato) {
        this.afiliado_contrato = afiliado_contrato;
    }
}
