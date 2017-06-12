
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Municipio implements Serializable {
    
    // Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String codigo;
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name ="fk_departamento")
    private Departamento departamento;

    // Constructores
    public Municipio() {
        departamento =  new Departamento();
    }
    
    public Municipio(String c, String d, Departamento de) {
        this.codigo = c;
        this.descripcion = d;
        this.departamento = de;
    }

    // Getters & setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
