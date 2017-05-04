package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ips;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T10:43:11")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, String> descripcion;
    public static volatile SingularAttribute<Contrato, Integer> monto;
    public static volatile SingularAttribute<Contrato, Date> inicio;
    public static volatile SingularAttribute<Contrato, Date> fin;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Ips> ips;
    public static volatile SingularAttribute<Contrato, String> nro_contrato;

}