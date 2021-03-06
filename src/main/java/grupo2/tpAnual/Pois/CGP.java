package grupo2.tpAnual.Pois;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import grupo2.tpAnual.AccesoriosPois.Servicio;

@Entity
@DiscriminatorValue("2")
public class CGP extends POI {
	
	@OneToMany
	private List<Servicio> servicios;

	public CGP(String nombre, Point ubicacion) {
		super(nombre, ubicacion);
		servicios = new ArrayList<>();
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> ser) {
		this.servicios = ser;
	}

	public void agregarServicio(Servicio serv){
		this.servicios.add(serv);
	}
	
	@Override
	public boolean tieneTextoEnOtrosAtributos(String texto) {
		for (Servicio ser : servicios) {
			if (ser.getNombre().contains(texto)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean estaDisponible(DateTime momento, String nombreServicio) {
		boolean disponible = false;
		if (nombreServicio != "") {
			disponible = servicios.stream().filter(x -> x.getNombre() == nombreServicio).collect(Collectors.toList())
					.get(0).estaDisponible(momento);
		} else {
			disponible = servicios.stream().anyMatch(servicio -> servicio.estaDisponible(momento));
		}
		return disponible;
	}

	@Override
	public boolean estaCerca(Point punto) {
		return (this.comuna.estaAdentro(punto));
	}

}