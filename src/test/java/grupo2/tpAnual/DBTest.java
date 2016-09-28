package grupo2.tpAnual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class DBTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	private EntityManager em;
	
	@Before
	public void init(){
		em = PerThreadEntityManagers.getEntityManager();	
	}
	
	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}
	
	@Test
	public void persistirDireccion(){
		beginTransaction();
		Direccion dire= new Direccion("Medrano", "Almagro");
		persist(dire);
		commitTransaction();
		
		Direccion direccionBuscada = (Direccion) em.createQuery("from Direccion where zona = :zona").setParameter("zona", "Almagro").getSingleResult();
		assertEquals(direccionBuscada.getZona(),"Almagro");
		assertEquals(direccionBuscada.getCalle(),"Medrano");
		
	}	
	
	//Estos son los que no funcionan
	/*@Test
	public void persistirUsuario(){
		beginTransaction();
		Usuario user= new Usuario();
		Comuna comuna = new Comuna(1, null);
		user.setComuna(comuna);
		persist(user);
		commitTransaction();
		
		Usuario usuarioBuscado = (Usuario) em.createQuery("from Usuario where comuna = :comuna").setParameter("comuna", "1").getSingleResult();
		assertEquals(usuarioBuscado.getComuna(),1);
		
	}	
	
	@Test
	public void verificarRepositorioUsuario(){
		beginTransaction();
		UserRepository repoUsuarios = new UserRepository();
		
		Usuario juan = new Usuario();
		Comuna comuna = new Comuna(1, null);
		juan.setComuna(comuna);
		
		Usuario ana = new Usuario();
		Comuna comun = new Comuna(2, null);
		ana.setComuna(comun);
		
		repoUsuarios.setUsuarios(ana);
		repoUsuarios.setUsuarios(juan);
		persist(repoUsuarios);
		commitTransaction();
		
		Usuario usuarioBuscado = (Usuario) em.createQuery("from UserRepository where user_id = :id").setParameter("id", "2").getSingleResult();
		assertEquals(usuarioBuscado.getComuna(),2);
	}
	
	@Test 
	public void persistirDatosDeBusqueda(){
		beginTransaction();
		DatosDeBusqueda dato = new DatosDeBusqueda("San Juan", "banco", 5, 15, new LocalDate());
		persist(dato);
		commitTransaction();
		
		DatosDeBusqueda datoBuscado = (DatosDeBusqueda) em.createQuery("from DatosDeBusqueda where nombre = :nombre").setParameter("nombre", "San Juan");
		assertEquals(datoBuscado.getTotalDeResultados(), 15);
	}*/
}