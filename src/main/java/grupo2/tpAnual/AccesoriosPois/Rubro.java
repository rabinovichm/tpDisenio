package grupo2.tpAnual.AccesoriosPois;
import javax.persistence.*;

@org.mongodb.morphia.annotations.Entity
@Entity
@Table(name="Rubro")
public class Rubro {
	@Id	@GeneratedValue 
	private Integer id;
	@Column(name="tipo")
	private String tipoRubro;
	@Column(name="radioCercania")
	private double radioCercania;
	@org.mongodb.morphia.annotations.Embedded
	@OneToOne
	private Rango disponibilidad;

	public String getTipo() {
		return tipoRubro;
	}

	public void setTipo(String tip) {
		this.tipoRubro = tip;
	}

	public Rango getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Rango dis) {
		this.disponibilidad = dis;
	}

	public double getRadioCercania() {
		return radioCercania;
	}

	public void setRadioCercania(double Radio) {

		this.radioCercania = Radio;
	}
	
	public Integer getId(){
		return this.id;
	}

	public boolean Busqueda(String tipo) {
		return tipoRubro.equals(tipo);
	}
}
