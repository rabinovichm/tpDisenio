package grupo2.tpAnual.Repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import grupo2.tpAnual.AccesoriosPois.Comuna;
import grupo2.tpAnual.Observers.ObserverBusqueda;
@Entity
public class Usuario {
	@Id @GeneratedValue
	private long id; 
	private String nombre;
	@OneToMany 
	private List<ObserverBusqueda> accionesBusqueda = new ArrayList<ObserverBusqueda>();
	@ManyToOne 
	public Comuna comuna;
	
	private int esAdmin; //es 1 si es admin, 0 si es terminal
	
	public Usuario(){
		
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public long getId(){
		return id;
	}
	public void setComuna(Comuna com) {
		this.comuna = com;
	}

	public Comuna getComuna() {
		return comuna;
	}


	public void setAccionesBusqueda(List<ObserverBusqueda> observers) {
		this.accionesBusqueda.addAll(observers);
	}


	public void setAccionBusqueda(ObserverBusqueda observer) {
		this.accionesBusqueda.add(observer);
	}
	
	public List<ObserverBusqueda> getAccionesBusqueda() {
		return accionesBusqueda;
	}

	public void quitarObserversBusqueda(List<ObserverBusqueda> observers) {
		this.accionesBusqueda.removeAll(observers);

	}
	
	public void setEsAdmin(int admin){
		esAdmin = admin;
	}
	
	public int getEsAdmin(){
		return esAdmin;
	}
}