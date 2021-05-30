package ar.edu.ub.proyecto_web.controller;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ar.edu.ub.proyecto_web.model.Criterio;
import ar.edu.ub.proyecto_web.model.Tecnica;

@RestController
public class DemoController {

	
	@GetMapping()
	public String getAPIDate() {
		return new Date().toString();
	}
	
//	@GetMapping(path="/getAlumnos")
//	public String getAlumnosP3() {
//		LinkedList<Alumno> alumnos =  new LinkedList<Alumno>();
//		alumnos.add(new Alumno("Lautaro", 28));
//		alumnos.add(new Alumno("Victoria", 25));
//		alumnos.add(new Alumno("Cristian", 23));
//		Gson gson = new Gson();
//		return gson.toJson(alumnos);
//	}
	
	@GetMapping(path="/getAnalisisAW")
	public String getResultadoAccesibilidadWeb(String url) {
		LinkedList<Criterio> criterios =  new LinkedList<Criterio>();
		
		Criterio c111 = new Criterio("1.1.1", "Imagenes");
		c111.agregarTecnica(new Tecnica("H1", ""));
		c111.agregarTecnica(new Tecnica("H2", ""));
		c111.agregarTecnica(new Tecnica("H3", ""));
		c111.ejecutarTecnicas(url);
		
		Criterio c121 = new Criterio("1.2.1", "Foco");
		c121.agregarTecnica(new Tecnica("H4", ""));
		c121.agregarTecnica(new Tecnica("H5", ""));
		c121.agregarTecnica(new Tecnica("H6", ""));
		c121.ejecutarTecnicas(url);
		
		criterios.add(c111);
		criterios.add(c121);
		
		Gson gson = new Gson();
		return gson.toJson(criterios);
		
		
	}
	
}
