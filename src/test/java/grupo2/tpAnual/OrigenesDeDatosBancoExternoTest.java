package grupo2.tpAnual;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import grupo2.tpAnual.OrigenesDeDatos.OrigenesDeDatosBancoExterno;

public class OrigenesDeDatosBancoExternoTest {

	private BancoExterno bancoExterno = new BancoExterno(-34.666612, -58.3858490);
	private OrigenesDeDatosBancoExterno bancoExternoDatos;
	private String banco;
	private String servicio;
	private String respuestaJson;

	@Before
	public void init() {
		bancoExternoDatos = new OrigenesDeDatosBancoExterno();
		banco = "Banco de la Plaza";
		servicio = "cobro cheques";
	}

	/*
	 * @Test public void integTest() { respuestaJson =
	 * "{ \"banco\": \"Banco de la Plaza\", \"x\": -35.9338322, \"y\": 72.348353, \"sucursal\": \"Avellaneda\", \"gerente\": \"Javier Loeschbor\", \"servicios\": [ \"cobro cheques\", \"depósitos\", \"extracciones\", \"transferencias\", \"créditos\", \"\", \"\", \"\" ] }"
	 * ;
	 * Mockito.when(integBancoExterno.busqueda(banco)).thenReturn(respuestaJson)
	 * ;
	 * 
	 * }
	 */
}