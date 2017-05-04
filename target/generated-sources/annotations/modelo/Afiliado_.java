package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Contrato;
import modelo.Municipio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T10:43:11")
@StaticMetamodel(Afiliado.class)
public class Afiliado_ { 

    public static volatile SingularAttribute<Afiliado, String> num_documento;
    public static volatile SingularAttribute<Afiliado, String> apellido2;
    public static volatile SingularAttribute<Afiliado, Date> fecha_retiro;
    public static volatile SingularAttribute<Afiliado, Integer> estado;
    public static volatile SingularAttribute<Afiliado, Date> fecha_afiliacion;
    public static volatile SingularAttribute<Afiliado, String> apellido1;
    public static volatile SingularAttribute<Afiliado, Municipio> municipio;
    public static volatile SingularAttribute<Afiliado, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Afiliado, String> direccion;
    public static volatile ListAttribute<Afiliado, Contrato> contrato;
    public static volatile SingularAttribute<Afiliado, String> nombre2;
    public static volatile SingularAttribute<Afiliado, String> nombre1;
    public static volatile SingularAttribute<Afiliado, String> tipo_documento;
    public static volatile SingularAttribute<Afiliado, String> genero;
    public static volatile SingularAttribute<Afiliado, Integer> id;
    public static volatile SingularAttribute<Afiliado, String> telefono;

}