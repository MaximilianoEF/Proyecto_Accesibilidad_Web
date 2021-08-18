package ar.edu.ub.proyecto_web.model;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;



public class Principio {
	private String codigo;
	private String detalle;
	private List<Pauta> pautas;
	private WebDriver driver;
	
	public Principio(String codigo, String detalle) {
		this.codigo = codigo;
		this.detalle = detalle;
		this.pautas = new LinkedList<Pauta>();
	}
	
	public void agregarPauta(Pauta pauta) {
		this.pautas.add(pauta);
	}
	
	public void ejecutarPautas(String url) {
		HelpersConnection conexion = new HelpersConnection(this.driver);
		for(Pauta pauta: pautas) {
			pauta.ejecutarCriterio(url, conexion);
		}
		conexion.close();
	}
}
