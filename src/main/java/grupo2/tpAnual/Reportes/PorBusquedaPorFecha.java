package grupo2.tpAnual.Reportes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grupo2.tpAnual.DatosDeBusqueda;
import grupo2.tpAnual.RegistrarDatosBusqueda;

public class PorBusquedaPorFecha{
	List<DatosDeBusqueda> registroBusqueda = new ArrayList<DatosDeBusqueda>();
	RegistrarDatosBusqueda register;
	
	public PorBusquedaPorFecha(RegistrarDatosBusqueda register){
		this.register = register; 
	}

	public Map<String, Integer> busquedasPorFecha (){
		Map<String, Integer> reporte = new HashMap<String, Integer>();
		this.registroBusqueda.addAll(this.register.consultarDatos());
		for(DatosDeBusqueda registro : registroBusqueda){
			Integer cantidadXFecha = reporte.get(registro.getFecha().toString()) ;
			if(cantidadXFecha != null){
				reporte.put(registro.getFecha().toString(), ++cantidadXFecha);
			}else{
				reporte.put(registro.getFecha().toString(), 1);
			}
		}
		return reporte;
		
		//Como recorrer el map despues
		//for ( Map.Entry<String, Label> entry : map.entrySet() ) {
		//    String key = entry.getKey();
		//    Label value = entry.getValue();
		//}
	}
	
}