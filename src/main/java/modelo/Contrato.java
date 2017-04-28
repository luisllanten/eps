package modelo;

import java.util.Date;


public class Contrato {
    
    private Long id;
    private String nro_contrato;
    private String descripcion;
    private Date inicio;
    private Date fin;
    
    private int monto;
    private Ips ips;
    
    public Contrato(){
        
    }

    public Contrato(Long id, String nro_contrato, String descripcion, Date inicio, Date fin, int monto, Ips ips) {
        this.id = id;
        this.nro_contrato = nro_contrato;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.monto = monto;
        this.ips = ips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNro_contrato() {
        return nro_contrato;
    }

    public void setNro_contrato(String nro_contrato) {
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
