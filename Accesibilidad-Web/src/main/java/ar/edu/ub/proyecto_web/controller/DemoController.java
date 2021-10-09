package ar.edu.ub.proyecto_web.controller;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ar.edu.ub.proyecto_web.model.Criterio;
import ar.edu.ub.proyecto_web.model.Pauta;
import ar.edu.ub.proyecto_web.model.Principio;
import ar.edu.ub.proyecto_web.model.Tecnica;

@RestController
@RequestMapping(value="/getAnalisisAW")
public class DemoController {

	private String URL;
	
	@GetMapping
	public String getResultadoAccesibilidadWeb() {
		LinkedList<Principio> principios = new LinkedList<Principio>();
		
		Principio pr1 = new Principio("1", "Perceptibilidad");
		Principio pr2 = new Principio("1", "Operabilidad");
		Principio pr3 = new Principio("1", "Comprensibilidad");
		Principio pr4 = new Principio("1", "Robustez");
		Pauta pa11 = new Pauta("1.1", "Alternativas Textuales");
		Pauta pa12 = new Pauta("1.2", "Contenido Multimedia dependiente del tiempo");
		Pauta pa13 = new Pauta("1.3", "Adaptabilidad");
		Pauta pa14 = new Pauta("1.4", "Distinguible");
		Criterio c111 = new Criterio("1.1.1", "Contenido no textual");
		Criterio c121 = new Criterio("1.2.1", "Solo audio y solo video");
		
//		Criterio c113 = new Criterio("1.3.1", "Contenido no textual");
//		Criterio c11N = new Criterio("1.1.N", "Contenido no textual");
		
		//Agrego Tecnica a Criterio 1.1.1
		c111.agregarTecnica(new Tecnica("H2", "Jirafa"));
		c121.agregarTecnica(new Tecnica("H4", "Elefante"));
		
		//Agrego Criterios a Pauta 1.1
		pa11.agregarPauta(c111);
		
		//Agrego Criterios a Pauta 1.2
		pa12.agregarPauta(c121);
		
		//Agrego Pauta a Principio 1
		pr1.agregarPauta(pa11);
		//Agrego Pauta a Principio 2
		pr1.agregarPauta(pa12);
		//Agrego Pauta a Principio 3
		pr1.agregarPauta(pa13);
		//Agrego Pauta a Principio 4
		pr1.agregarPauta(pa14);
		
		pr1.ejecutarPautas(this.URL);
		
//		c111.ejecutarTecnicas(url);
		
//		Criterio c121 = new Criterio("1.2.1", "Foco");
//		c121.agregarTecnica(new Tecnica("H4", ""));
//		c121.agregarTecnica(new Tecnica("H5", ""));
//		c121.agregarTecnica(new Tecnica("H6", ""));
//		c121.ejecutarTecnicas(url);
		
		principios.add(pr1);
//		principios.add(pr2);
		
		Gson gson = new Gson();
		return gson.toJson(principios);
		
		
	}
	
	@PostMapping
    public ResponseEntity<String> getUrl(@RequestBody String url) {
		this.URL = url;
		System.out.println("URL INGRESADA");
		System.out.println(this.URL);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
	
}
