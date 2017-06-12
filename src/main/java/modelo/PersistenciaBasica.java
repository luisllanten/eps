package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

@Singleton
public class PersistenciaBasica {
	
	private int id;
	/*private Map<Long, Afiliado> listaAfiliado;*/
        private Map<Integer, Afiliado> listaAfiliado;

	public PersistenciaBasica(){
		id = 0;
		listaAfiliado = new HashMap<>();
	}

	//CRUD AFILIADO
	public Afiliado crearAfiliado(Afiliado Afil) {
		Afil.setId(++id);
                listaAfiliado.put(id, Afil);
		return Afil;
	}
	
	public Collection<Afiliado> listarAfiliado() {
		return listaAfiliado.values();
	}
	
	public Afiliado buscarAfiliado(Long id) {			
		return listaAfiliado.get(id);
	}
	
	public Afiliado actualizarAfiliado(Afiliado Afil){		
		if( listaAfiliado.containsKey(Afil.getId()) ){
			listaAfiliado.put(Afil.getId(), Afil);
                        
			return Afil;
		}
		return null;
	}
	
	public boolean elminiarAfiliado(Long id){		
		if( listaAfiliado.containsKey(id) ){
			listaAfiliado.remove(id);
			return true;
		}		
		else return false;
	}

}