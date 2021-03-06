package grupo2.tpAnual.Reportes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import grupo2.tpAnual.AccesoriosPois.Rango;
import grupo2.tpAnual.Pois.Comercio;
import grupo2.tpAnual.Pois.POI;
import grupo2.tpAnual.Reportes.PorBusquedaPorFecha;
import grupo2.tpAnual.Repositorios.DatosBusquedaRepositoryMemory;
import grupo2.tpAnual.Repositorios.DatosDeBusqueda;

 
public class ReporteBusquedaPorFechaTest {
	 
	DatosBusquedaRepositoryMemory registro;
	DatosDeBusqueda datoBuscado;
	DatosDeBusqueda datoBuscado2;
	DatosDeBusqueda datoBuscado3;
	PorBusquedaPorFecha reporte;
	private Comercio comercio;
	private Rango unRango;
	private Rango otroRango;
	private Rango rango;
	private List<Rango> listaRangos;
	private List<POI> pois;
	private LocalDate today;
	@Before
	public void init() {
		today = LocalDate.now();
		unRango = new Rango(1, LocalTime.of(9, 0, 0), LocalTime.of(18, 0, 0));
		otroRango = new Rango(3, LocalTime.of(9, 0, 0), LocalTime.of(13, 0, 0));
		rango = new Rango(3, LocalTime.of(15, 0, 0), LocalTime.of(18, 30, 0));
		listaRangos = Arrays.asList(unRango, otroRango, rango);
		comercio = new Comercio("Supermercado argenChino", Point.and(-34.664837, -58.385674), listaRangos);
		pois= new ArrayList<>();
		pois.add(comercio);
		registro = new DatosBusquedaRepositoryMemory();
		datoBuscado = new DatosDeBusqueda("lasHeras", "libros", 10, 15, today,pois);
		datoBuscado2 = new DatosDeBusqueda("flores", "carpetas", 14, 15, today.minusDays(1),pois);
		datoBuscado3 = new DatosDeBusqueda("flores", "carpetas", 14, 15, today.minusDays(2),pois);
		registro.agregarDatosBusqueda(datoBuscado);
		registro.agregarDatosBusqueda(datoBuscado2);
		registro.agregarDatosBusqueda(datoBuscado3);
		reporte = new PorBusquedaPorFecha(registro);
		
	}

	@Test
	public void obtenerReporteTest() {
		Map<LocalDate, Integer> map = reporte.busquedasPorFecha();
		Assert.assertEquals(map.get(today).intValue(), 1);
		Assert.assertEquals(map.get(today.minusDays(1)).intValue(), 1);
		Assert.assertEquals(map.size(), 3);
	}
}
