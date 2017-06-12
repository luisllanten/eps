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
import modelo.Afiliado;
import modelo.Contrato;
import servicios.rest.AfiliadoRest;
import servicios.rest.ContratoRest;

    
@ManagedBean
@SessionScoped
public class AfiliadoBean {
     @Inject AfiliadoRest afiliadoRest;
       
    private List<Afiliado> afiliados;    
    private Afiliado afiliado;

    public AfiliadoBean() {
    }
    
    @PostConstruct
    public void init(){
        afiliados = afiliadoRest.buscarTodos();
        afiliado = new Afiliado();
    }
    
    public void guardar(){
        System.out.println("guardar...");
        afiliadoRest.agregar(afiliado);        
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Afiliado",  "Se guardo con exito!") );
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

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }
}
