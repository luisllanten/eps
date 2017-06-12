
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departamento implements Serializable {
    
    // Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;

    // Constructores
    public Departamento() {
    }
    
    public Departamento(Long c, String d) {
        this.codigo = c;
        this.descripcion = d;
    }

    // Getters & setters...
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
}
