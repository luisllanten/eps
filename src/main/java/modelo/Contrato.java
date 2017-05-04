
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrato implements Serializable {
    
    // Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nro_contrato;
    private String descripcion;
    
    @Temporal(TemporalType.DATE )
    private Date inicio;
    
    @Temporal(TemporalType.DATE )
    private Date fin;
    
    private int monto;
     
    @ManyToOne
    @JoinColumn(name ="fk_ips")
    private Ips ips;

    // Constructores
    public Contrato() {
    }
    
    public Contrato(String n, String d, Date i, Date f, int m, Ips ip) {
        this.nro_contrato = n;
        this.descripcion = d;
        this.inicio = i;
        this.fin = f;
        this.monto = m;
        this.ips = ip;
        
    }

    // Getters & setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNroContrato() {
        return nro_contrato;
    }
    
    public void setNroContrato(String nro_contrato) {
        this.nro_contrato = nro_contrato;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getInicio() {
        return inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    
    public Date getFin() {
        return fin;
    }
    
    public void setFin(Date fin) {
        this.fin = fin;
    }
    
    public int getMonto() {
        return monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public Ips getIps() {
        return ips;
    }
    
    public void setIps(Ips ips) {
        this.ips = ips;
    }

}

