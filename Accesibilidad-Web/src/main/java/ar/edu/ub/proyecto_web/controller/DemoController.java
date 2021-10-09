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
		
		// Principios
		Principio pr1 = new Principio("1", "Perceptibilidad");
		Principio pr2 = new Principio("1", "Operabilidad");
		Principio pr3 = new Principio("1", "Comprensibilidad");
		Principio pr4 = new Principio("1", "Robustez");
		
		// Pautas 1.x
		Pauta pa11 = new Pauta("1.1", "Alternativas Textuales");
		Pauta pa12 = new Pauta("1.2", "Contenido Multimedia dependiente del tiempo");
		Pauta pa13 = new Pauta("1.3", "Adaptabilidad");
		Pauta pa14 = new Pauta("1.4", "Distinguible");
		// Pautas 2.x
		Pauta pa21 = new Pauta("2.1", "Accesible a través del teclado");
		Pauta pa22 = new Pauta("2.2", "Tiempo Suficiente");
		Pauta pa23 = new Pauta("2.3", "Ataques");
		Pauta pa24 = new Pauta("2.4", "Navegable");
		// Pautas 3.x
		Pauta pa31 = new Pauta("3.1", "Legible");
		Pauta pa32 = new Pauta("3.2", "Predecible");
		Pauta pa33 = new Pauta("3.3", "Ayuda a la entrada de datos");
		// Pautas 4.x		
		Pauta pa41 = new Pauta("4.1", "Compatible");
		
		// Criterios 
		Criterio c111 = new Criterio("1.1.1", "Contenido no textual");
		Criterio c121 = new Criterio("1.2.1", "Solo audio y solo video (Pregrabados)");
		Criterio c122 = new Criterio("1.2.2", "Subtitulos (Pregrabados)");
		Criterio c123 = new Criterio("1.2.3", "Audiodescripción o alternativa múltimedia (Pregrabada)");
		Criterio c124 = new Criterio("1.2.4", "Subtitulos (Directo)");
		Criterio c125 = new Criterio("1.2.5", "Audriodescripción (Pregrabada)");
		Criterio c131 = new Criterio("1.3.1", "Información y relaciones");
		Criterio c132 = new Criterio("1.3.2", "Secuencia significativa");
		Criterio c133 = new Criterio("1.3.3", "Caracteristicas sensoriales");
		Criterio c141 = new Criterio("1.4.1", "Empleo del color");
		Criterio c142 = new Criterio("1.4.2", "Control del audio");
		Criterio c143 = new Criterio("1.4.3", "Minimo");
		Criterio c144 = new Criterio("1.4.4", "Cambio de tamaño del texto");
		Criterio c145 = new Criterio("1.4.5", "Imagenes de Texto");
		Criterio c211 = new Criterio("2.1.1", "Teclado");
		Criterio c212 = new Criterio("2.1.2", "Sin trampa de teclado");
		Criterio c221 = new Criterio("2.2.1", "Limite de tiempo ajustable");
		Criterio c222 = new Criterio("2.2.2", "Pausar, detener, ocultar");
		Criterio c231 = new Criterio("2.3.1", "Tres destellos o por debajo del umbral");
		Criterio c241 = new Criterio("2.4.1", "Saltar bloques");
		Criterio c242 = new Criterio("2.4.2", "Pagina titulada");
		Criterio c243 = new Criterio("2.4.3", "Orden de foco");
		Criterio c244 = new Criterio("2.4.4", "Proposito de un vinculo (En su contexto)");
		Criterio c245 = new Criterio("2.4.5", "Multiples medios");
		Criterio c246 = new Criterio("2.4.6", "Encabezados y etiquetas");
		Criterio c247 = new Criterio("2.4.7", "Foco visible");
		Criterio c311 = new Criterio("3.1.1", "Idioma de la pagina");
		Criterio c312 = new Criterio("3.1.2", "Idioma de partes");
		Criterio c321 = new Criterio("3.2.1", "Con foco");
		Criterio c322 = new Criterio("3.2.2", "Con entrada y datos");
		Criterio c324 = new Criterio("3.2.4", "Identificación consistente");
		Criterio c331 = new Criterio("3.3.1", "Identificación de errores");
		Criterio c332 = new Criterio("3.3.2", "Instrucciones o etiquetas");
		Criterio c333 = new Criterio("3.3.3", "Sugerencia tras error");
		Criterio c334 = new Criterio("3.3.4", "Prevención de errores (egales, financieros, de datos)");
		Criterio c411 = new Criterio("4.1.1", "Interpretación");
		Criterio c412 = new Criterio("4.1.2", "Nombre, rol, valor");
		
		//Tecnicas H
		Tecnica h2 = new Tecnica("H2", "Combinando enlaces de texto e imagenes adyacentes para e mismo recurso");
		Tecnica h24 = new Tecnica("H24", "Proporcionar alternativas de texto para los areaelementos de los mapas de imágenes");
		
		//Agrego Tecnica a Criterio 1.1.1
		c111.agregarTecnica(h2);
		c111.agregarTecnica(h24);
		
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
