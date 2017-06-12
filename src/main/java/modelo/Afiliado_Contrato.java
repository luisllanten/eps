/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 1061696462
 */
public class Afiliado_Contrato {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_afiliado;
    private Integer id_contrato;
    private String estado;
    
     public Afiliado_Contrato() {
         
         
    }

    public Afiliado_Contrato(Integer id, Integer id_afiliado, Integer id_contrato, String estado) {
        this.id = id;
        this.id_afiliado = id_afiliado;
        this.id_contrato = id_contrato;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_afiliado() {
        return id_afiliado;
    }

    public void setId_afiliado(Integer id_afiliado) {
        this.id_afiliado = id_afiliado;
    }

    public Integer getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(Integer id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     
    
    
}
