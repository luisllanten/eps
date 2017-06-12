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
import modelo.Ips;
import servicios.rest.ContratoRest;
import servicios.rest.IpsRest;

/**
 *
 * @author Luis Llanten
 */
@ManagedBean
@SessionScoped
public class IpsBean{

          @Inject IpsRest ipsRest;
       
    private List<Ips> ipss;    
    private Ips ips;

    public IpsBean() {
    }
    
    @PostConstruct
    public void init(){
        ipss = ipsRest.buscarTodos();
        ips = new Ips();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        ipsRest.agregar(ips);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Municipio",  "Se guardo con exito!") );
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

    public List<Ips> getIpss() {
        return ipss;
    }

    public void setIpss(List<Ips> ipss) {
        this.ipss = ipss;
    }

    public Ips getIps() {
        return ips;
    }

    public void setContrato(Ips contrato) {
        this.ips = contrato;
    }
}
