package ar.edu.ub.proyecto_web.model;

public class Tecnica {
	
	private String codigo; //H1
	private String descripcion; //...
	private ResultadoTecnica resultado;
	
	public Tecnica(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public void ejecutar(String url) {
		//selenium verrr TestResult
		this.resultado = ResultadoTecnica.OK;
	}
	
	

	
	
}
