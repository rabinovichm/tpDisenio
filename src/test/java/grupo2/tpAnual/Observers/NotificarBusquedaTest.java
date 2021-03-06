package grupo2.tpAnual.Observers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import grupo2.tpAnual.Observers.NotificarDatosBusqueda;
import grupo2.tpAnual.Pois.POI;
import grupo2.tpAnual.Repositorios.DatosDeBusqueda;

public class NotificarBusquedaTest {
	LocalDate today=LocalDate.now();
	DatosDeBusqueda datoBuscado = new DatosDeBusqueda("corrientes", "peras", 10, 15, today,new ArrayList<POI>());
	NotificarDatosBusqueda observer = new NotificarDatosBusqueda(true);

	@Test
	public void notificarDatosDeBusquedaTest() {
		this.observer.notificarBusqueda(datoBuscado);
		Assert.assertTrue(this.observer.getRegister().consultarDatos().contains(datoBuscado));
	}
}	
