package ar.edu.ub.proyecto_web.model;

import java.util.LinkedList;
import java.util.List;

public class Pauta {
	private String codigo;
	private String detalle;
	private List<Criterio> criterios;
	
	public Pauta(String codigo, String detalle) {
		this.codigo = codigo;
		this.detalle = detalle;
		this.criterios = new LinkedList<Criterio>();
	}
	
	public void agregarPauta(Criterio criterio) {
		this.criterios.add(criterio);
	}
	
	public void ejecutarCriterio(String url, HelpersConnection conexion) {
		for (Criterio criterio: criterios) 
			criterio.ejecutarTecnicas(url, conexion);
	}
}
