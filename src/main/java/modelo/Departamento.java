
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento implements Serializable {
    
    // Atributos
    @Id    
    private String codigo;
    private String descripcion;

    // Constructores
    public Departamento() {
    }
    
    public Departamento(String c, String d) {
        this.codigo = c;
        this.descripcion = d;
    }

    // Getters & setters...
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
  
}
