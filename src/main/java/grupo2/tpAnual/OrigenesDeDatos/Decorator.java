package grupo2.tpAnual.OrigenesDeDatos;

import java.util.List;

import ServiciosExternos.ServicioExternoBanco;
import grupo2.tpAnual.Pois.POI;

public abstract class Decorator extends OrigenesDeDatos{
	OrigenesDeDatos origen;
	
	public Decorator(OrigenesDeDatos origen){
		this.origen = origen;
	}
	public abstract List<POI> busqueda(String txtABuscar);
}
	