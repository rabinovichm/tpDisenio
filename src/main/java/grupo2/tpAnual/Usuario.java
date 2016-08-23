package grupo2.tpAnual;

import java.util.ArrayList;
import java.util.List;

import grupo2.tpAnual.Observers.ObserverBusqueda;

public class Usuario {
	private List<ObserverBusqueda> accionesBusqueda = new ArrayList<ObserverBusqueda>();
	public Comuna comuna;

	public void setComuna(Comuna com) {
		this.comuna = com;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public List<ObserverBusqueda> accionesDeBusqueda() {
		return this.accionesBusqueda;
	}

	public void agregarObserversBusqueda(List<ObserverBusqueda> observers) {
		this.accionesBusqueda.addAll(observers);
	}

	public List<ObserverBusqueda> getAccionesBusqueda() {
		return accionesBusqueda;
	}

	public void quitarObserversBusqueda(List<ObserverBusqueda> observers) {
		this.accionesBusqueda.removeAll(observers);

	}
}