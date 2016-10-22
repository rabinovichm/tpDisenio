package grupo2.tpAnual.Observers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import grupo2.tpAnual.MailSender;
import grupo2.tpAnual.AccesoriosPois.Rango;
import grupo2.tpAnual.Observers.EnviarMailBusqueda;
import grupo2.tpAnual.Pois.Comercio;
import grupo2.tpAnual.Pois.POI;
import grupo2.tpAnual.Repositorios.DatosDeBusqueda;

public class EnviarMailBusquedaTest {
		LocalDate today=LocalDate.now();
		MailSender mockmail = Mockito.mock(MailSender.class);
		DatosDeBusqueda datoBuscado = new DatosDeBusqueda("lasHeras", "libros", 10, 15, today, new ArrayList<POI>());
		DatosDeBusqueda datoBuscado2 = new DatosDeBusqueda("flores", "asado", 10, 15, today,new ArrayList<POI>());
	
	@Test
	public void enviarMailTest() {
		EnviarMailBusqueda observer = new EnviarMailBusqueda(1, mockmail, "juan@gmail.com");
		observer.notificarBusqueda(datoBuscado);
		Mockito.verify(mockmail).send("juan@gmail.com", "Notificacion de Busqueda", "La busqueda tardo mas de lo esperado");
			}
}
