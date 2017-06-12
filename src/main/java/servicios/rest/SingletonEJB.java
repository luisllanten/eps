package servicios.rest;
// 1
import javax.ejb.Singleton;

@Singleton
public class SingletonEJB {
    
    private long codigoOperacion;
    
    public SingletonEJB(){
        codigoOperacion = 0;
    }
    
    public void incrementarCodigo(){
        codigoOperacion++;
    }
    
    public long getCodigoOperacion(){
        return codigoOperacion;
    }
}
