package grupo2.tpAnual;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CGPTest {
	
	private CGP cgp;
	private Servicio unServicio;
	private Servicio otroServicio;	
	private Rango unRango;
	private Rango otroRango;
	private DateTime momento;
	private List<Servicio> servicios;
	 
	@Before
	public void init(){
		cgp = new CGP();
		unServicio = new Servicio();
		otroServicio = new Servicio();
		unRango = new Rango();
		otroRango = new Rango();
		
		
		unRango.setDay(1);
		unRango.setHoraD(new Time (9,0,0));
		unRango.setHoraH(new Time (18,0,0));
			  
		otroRango.setDay(3);
		otroRango.setHoraD(new Time (9,0,0));
		otroRango.setHoraH(new Time (13,0,0));		  
		
		unServicio.setNombre("Rentas");
		unServicio.addRango(unRango);
		
		otroServicio.setNombre("otrasRentas");
		otroServicio.addRango(otroRango);
		
		servicios = new ArrayList<Servicio>();
		servicios.add(unServicio);
		servicios.add(otroServicio);	
		
		cgp.setServicios(servicios);
	}
	
	@Test
	 public void estaDisponibleRentasLunesALas1030() {
		 momento = new DateTime("2016-04-25T10:30:00");
		 //Assert.assertTrue(cgp.estaDisponible(momento, "Rentas")); 
		 Assert.assertTrue(cgp.estaDisponible(momento, "")); 
	 }
	 
	 /*@Test
	 public void noEstaDisponibleSabadoALas20() {
		 momento = new DateTime("2016-04-23T20:00:00");
		 Assert.assertFalse(cgp.estaDisponible(momento, "")); 
	 }*/

}