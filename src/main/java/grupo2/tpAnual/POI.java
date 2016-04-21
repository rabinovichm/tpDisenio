package grupo2.tpAnual;
import java.util.Date;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public abstract class POI {
	private Direccion _Direccion;
	private String _PalabraClave;
	protected Point _Ubicacion;
	protected Comuna _Comuna;
	//public Point Point; 
	
	public Direccion getDireccion() {
		return _Direccion;
	}

	public void setDireccion(Direccion dir) {
		this._Direccion = dir;
	}
	
	public void setPalabraClave(String pc){
		this._PalabraClave = pc;
	}
	public String getPalabraClave(){
		return _PalabraClave;
	}
	
	abstract boolean estaDisponible(Date fecha); 
	
	//abstract String estaDisponible (DateTime momento);
	 
	abstract boolean Busqueda(String texto);
	
	public void setUbicacion(double latitud, double longitud){
		this._Ubicacion=Point.and(latitud, longitud);
	}
	abstract boolean estaCerca(Point p);
	
	public Point getUbicacion (){
		return _Ubicacion;
	}
	
	public void setComuna(Comuna com){
		this._Comuna = com;
	}
}
