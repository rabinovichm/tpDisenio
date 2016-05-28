package grupo2.tpAnual;

import org.junit.Assert;
import org.junit.Test;

import grupo2.tpAnual.Observers.DatosDeBusqueda;
import grupo2.tpAnual.Observers.RegistrarBusqueda;

public class RegistrarBusquedaTest {
	RegistrarBusqueda observer = new RegistrarBusqueda();
	DatosDeBusqueda datoBuscado = new DatosDeBusqueda("libros", 18, 10, 15);

	@Test
	public void notificarBusquedaTest() {
		this.observer.notificarBusqueda(datoBuscado);
		Assert.assertEquals(this.observer.getRegistroBusqueda().size(), 1);

	}
}