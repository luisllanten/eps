
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Afiliado implements Serializable {
    
    // Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String tipo_documento;
    private String num_documento;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;
    
    @Temporal(TemporalType.DATE )
    private Date fecha_nacimiento;
    
    private String genero;
    private String direccion;
    private String telefono;
    
    @Temporal(TemporalType.DATE )
    private Date fecha_afiliacion;
    
    @Temporal(TemporalType.DATE )
    private Date fecha_retiro;
    
    private int estado;
    
    @ManyToOne
    @JoinColumn(name ="fk_municipio")
    private Municipio municipio;
    
    @ManyToMany
    @JoinTable(
            name="afiliado_contrato",
            joinColumns = @JoinColumn(name ="afiliado_id"),
            inverseJoinColumns=@JoinColumn(name="contrato_id")
    )
    
    private List<Contrato> contrato = new ArrayList<>();

    // Constructores
    public Afiliado() {
    }
    
    public Afiliado(String t, String n, String a1, String a2, String n1, String n2, Date fn,
            String g, String d, String te, Date fa, Date fr, int e, Municipio mu) {
        this.tipo_documento = t;
        this.num_documento = n;
        this.apellido1 = a1;
        this.apellido2 = a2;
        this.nombre1 = n1;
        this.nombre2 = n2;
        this.fecha_nacimiento = fn;
        this.genero = g;
        this.direccion = d;
        this.telefono = te;
        this.fecha_afiliacion = fa;
        this.fecha_retiro = fr;
        this.estado = e;
        this.municipio = mu;
        
        
    }

    // Getters & setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTipoDocumento() {
        return tipo_documento;
    }

    public void setTipoDocumento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    
    public String getNumDocumento() {
        return num_documento;
    }

    public void setNumDocumento(String num_documento) {
        this.num_documento = num_documento;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }
    
    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
    
    public Date getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Date getFechaAfiliacion() {
        return fecha_afiliacion;
    }

    public void setFechaAfiliacion(Date fecha_afiliacion) {
        this.fecha_afiliacion = fecha_afiliacion;
    }
    
    public Date getFechaRetiro() {
        return fecha_retiro;
    }

    public void setFechaRetiro(Date fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }    
    
}
