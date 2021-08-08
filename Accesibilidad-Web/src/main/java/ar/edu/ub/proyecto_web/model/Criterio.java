package ar.edu.ub.proyecto_web.model;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;


public class Criterio {
	
	private String codigo;
	private String descripcion;
	private WebDriver driver;
	
	private List<Tecnica> tecnicas;
	
	
	public Criterio(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tecnicas =  new LinkedList<Tecnica>();
	}
	
	public void agregarTecnica(Tecnica tecnica) {
		this.tecnicas.add(tecnica);
	}
	
	public void ejecutarTecnicas(String url, HelpersConnection conexion) {
//		HelpersConnection conexion = new HelpersConnection(this.driver);
		for (Tecnica tecnica : tecnicas) 
			tecnica.ejecutar(url, conexion);
	}
	

}
