package grupo2.tpAnual;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import grupo2.tpAnual.OrigenesDeDatos.OrigenesDeDatos;
import grupo2.tpAnual.Pois.POI;
import grupo2.tpAnual.Repositorios.DatosDeBusqueda;
import grupo2.tpAnual.Repositorios.DatosDeBusquedaRepository;
import grupo2.tpAnual.Repositorios.Usuario;

@Entity
@Table(name="Mapa") 
public class Mapa {
	@Transient
	private EntityManager em;
	//@OneToMany @JoinColumn (name="id_origenes")
	
	@Transient 
	private List<OrigenesDeDatos> origenesDeDatos;
	@Id @GeneratedValue @Column(name="id_mapa")
	private Integer id;
	//@Transient
	@Column(name="nombre")
	private String nombre;
	@Transient
	//@Column(name="usuario") @OneToMany @JoinColumn(name="id_usuario")
	private Usuario usuario;
	private DatosDeBusquedaRepository repositorioDB;
	
	

	public Mapa(List<OrigenesDeDatos> listaDeOrigenes, DatosDeBusquedaRepository repositorio) {
		
		origenesDeDatos = new ArrayList<OrigenesDeDatos>();
		this.origenesDeDatos.addAll(listaDeOrigenes);
		this.repositorioDB=repositorio;
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("db");
		em = emf.createEntityManager();

	}

	public List<POI> busquedaRealizadaPorElUsuario(String txtABuscar) {
		long tiempoInicio = System.currentTimeMillis();
		List<POI> result = new ArrayList<POI>();

		
		this.origenesDeDatos.forEach(integracion -> result.addAll(integracion.busqueda(txtABuscar)));
		long tiempoFin = System.currentTimeMillis();
		LocalDate today= LocalDate.now();
		long segundosTardados = (tiempoFin - tiempoInicio) / 1000;

		DatosDeBusqueda datosParaObserver = new DatosDeBusqueda(this.nombre, txtABuscar, segundosTardados,
				result.size(), today , result);
		
		this.repositorioDB.agregarDatosBusqueda(datosParaObserver); 
		
		usuario.getAccionesBusqueda().forEach(observer -> observer.notificarBusqueda(datosParaObserver));

		return result;
	}

	public List<OrigenesDeDatos> getOrigenesDeDatos() {
		/*em.getTransaction().begin();
		List<OrigenesDeDatos> origenes = new ArrayList<OrigenesDeDatos>();
		origenes = (List<OrigenesDeDatos>) em.createQuery("from origenesDeDatos").getResultList();
		em.getTransaction().commit();
		return origenes;*/
		
		return this.origenesDeDatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(Usuario user) {
		this.usuario = user;
	}
}
