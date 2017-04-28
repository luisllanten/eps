package modelo;

import java.util.Date;


public class Municipio {
    
    private Long id;
    private String codigo;
    private String descripcion;
    private Departamento departamento;
    
    public Municipio(){
        
    }

    public Municipio(Long id, String codigo, String descripcion, Departamento departamento) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    

    
    
    
    
    
}
