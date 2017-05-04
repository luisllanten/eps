package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Departamento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T10:43:11")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> descripcion;
    public static volatile SingularAttribute<Municipio, String> codigo;
    public static volatile SingularAttribute<Municipio, Departamento> departamento;
    public static volatile SingularAttribute<Municipio, Integer> id;

}