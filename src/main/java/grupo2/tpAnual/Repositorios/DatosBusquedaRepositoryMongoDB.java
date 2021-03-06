package grupo2.tpAnual.Repositorios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import grupo2.tpAnual.MorphiaService;

public class DatosBusquedaRepositoryMongoDB extends BasicDAO<DatosDeBusqueda, ObjectId>
		implements DatosDeBusquedaRepository {
	
	static MorphiaService morphia = new MorphiaService();
	
	public static DatosBusquedaRepositoryMongoDB instancia = new DatosBusquedaRepositoryMongoDB(DatosDeBusqueda.class, morphia.getDatastore());

	List<DatosDeBusqueda> listafiltro = new ArrayList<>();
	
	public DatosBusquedaRepositoryMongoDB(Class<DatosDeBusqueda> entityClass, Datastore dataStore) {
		super(entityClass, dataStore);
	}

	public List<DatosDeBusqueda> consultarDatos() {
		Query<DatosDeBusqueda> query = createQuery();		
		return query.asList();

	}

	public List<DatosDeBusqueda> obtenerPorNombre(String nombreTerminal) {
		Query<DatosDeBusqueda> query = createQuery().field("nombreTerminal").equal(nombreTerminal);
		return query.asList();

	}

	public void agregarDatosBusqueda(DatosDeBusqueda registroBusqueda) {
		save(registroBusqueda);
	}

	public List<Integer> obtenerTotalResultadosPorTerminal(String nombreTerminal) {
		List<DatosDeBusqueda> lista = this.obtenerPorNombre(nombreTerminal);		
		return lista.stream().map(datoDeBusqueda -> datoDeBusqueda.getTotalDeResultados()).collect(Collectors.toList());

	}

	public Integer cantidadDeBusquedasDe(String nombre) {
		return this.obtenerTotalResultadosPorTerminal(nombre).stream().reduce(0, (a, b) -> a + b);
	}
	
	
	public List<DatosDeBusqueda> cantidadDePois(Integer cantidad){
		
		Query<DatosDeBusqueda> query = createQuery().field("cantidadDePois").equal(cantidad);
		return query.asList();
	}
	
	public List<DatosDeBusqueda> filtrar(String nombreTerminal, int cantidad, LocalDate desde, LocalDate hasta){
		Query<DatosDeBusqueda> query = createQuery();
		
		if(cantidad != 0){
			query.field("cantidadDePois").equal(cantidad);
		}
		if (!nombreTerminal.isEmpty()){
			query.field("nombreTerminal").equal(nombreTerminal);
		}
		
		if(desde != null){
			query.field("fecha").greaterThanOrEq(desde);
		}
		if(hasta != null){
			query.field("fecha").lessThanOrEq(hasta);
		}
		return query.asList();
	}
	
	
	
	
}
