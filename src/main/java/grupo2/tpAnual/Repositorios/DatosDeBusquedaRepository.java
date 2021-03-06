package grupo2.tpAnual.Repositorios;
import java.time.LocalDate;
import java.util.List;

public interface DatosDeBusquedaRepository {
	
	public List<DatosDeBusqueda> obtenerPorNombre(String nombreTerminal);
	
	public void agregarDatosBusqueda(DatosDeBusqueda registroBusqueda);
	
	public List<DatosDeBusqueda> consultarDatos();

	public List<Integer> obtenerTotalResultadosPorTerminal(String nombreTerminal);

	public Integer cantidadDeBusquedasDe(String nombre);
	
	public List<DatosDeBusqueda> filtrar(String nombreTerminal,int cantidad, LocalDate desde, LocalDate hasta);
	
	public List<DatosDeBusqueda> cantidadDePois(Integer cantidad);
}
