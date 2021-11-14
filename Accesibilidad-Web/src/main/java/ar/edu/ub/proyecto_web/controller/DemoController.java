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
		Principio pr2 = new Principio("2", "Operabilidad");
		Principio pr3 = new Principio("3", "Comprensibilidad");
		Principio pr4 = new Principio("4", "Robustez");
		Principio pr5 = new Principio("5", this.URL);
		
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
		Criterio c323 = new Criterio("3.2.3", "Navegaci�n consistente");
		Criterio c324 = new Criterio("3.2.4", "Identificación consistente");
		Criterio c331 = new Criterio("3.3.1", "Identificación de errores");
		Criterio c332 = new Criterio("3.3.2", "Instrucciones o etiquetas");
		Criterio c333 = new Criterio("3.3.3", "Sugerencia tras error");
		Criterio c334 = new Criterio("3.3.4", "Prevención de errores (egales, financieros, de datos)");
		Criterio c411 = new Criterio("4.1.1", "Interpretación");
		Criterio c412 = new Criterio("4.1.2", "Nombre, rol, valor");
		
		//Tecnicas H
		Tecnica h2 = new Tecnica("H2", "Combinando enlaces de texto e imagenes adyacentes para e mismo recurso");
		Tecnica h4 = new Tecnica("H4","Crear un orden de tabulación lógico a través de enlaces, controles de formulario y objetos");
		Tecnica h24 = new Tecnica("H24", "Proporcionar alternativas de texto para los areaelementos de los mapas de imágenes");
		Tecnica h25 = new Tecnica("H25","Proporcionar un título utilizando el elemento title");
		Tecnica h28 = new Tecnica("H28","Proporcionar definiciones de abreviaturas utilizando el elemento abbr");
		Tecnica h30 = new Tecnica("H30","Proporcionar texto de enlace que describa el propósito de un enlace para elementos de anclaje");
		Tecnica h32 = new Tecnica("H32","Proporcionar botones de envío");
		Tecnica h33 = new Tecnica("H33","Complementar el texto del enlace con el atributo de título");
		Tecnica h34 = new Tecnica("H34","Uso de una marca Unicode de derecha a izquierda (RLM) o marca de izquierda a derecha (LRM) para mezclar la dirección del texto en línea");
		Tecnica h35 = new Tecnica("H35","Proporcionar alternativas de texto en elementos de subprograma ");
		Tecnica h36 = new Tecnica("H36","Uso de atributos alt en imágenes utilizadas como botones de envío");
		Tecnica h37 = new Tecnica("H37","Uso de atributos alt en elementos ");
		Tecnica h39 = new Tecnica("H39","Uso de elementos de título para asociar títulos de tablas de datos con tablas de datos");
		Tecnica h40 = new Tecnica("H40","Uso de listas de descripción");
		Tecnica h42 = new Tecnica("H42","Uso de h1-h6 para identificar encabezados");
		Tecnica h43 = new Tecnica("H43","Uso de atributos de id y encabezados para asociar celdas de datos con celdas de encabezado en tablas de datos");
		Tecnica h44 = new Tecnica("H44","Uso de elementos de etiqueta para asociar etiquetas de texto con controles de formulario");
		Tecnica h45 = new Tecnica("H45","Uso de longdesc");
		Tecnica h46 = new Tecnica("H46","Uso de noembed con incrustar");
		Tecnica h48 = new Tecnica("H48","Uso de ol, ul y dl para listas o grupos de enlaces");
		Tecnica h49 = new Tecnica("H49","Uso de marcado semántico para marcar texto especial o enfatizado");
		Tecnica h51 = new Tecnica("H51","Uso de marcado de tabla para presentar información tabular");
		Tecnica h53 = new Tecnica("H53","Usando el cuerpo del elemento de objeto");
		Tecnica h54 = new Tecnica("H54","Usar el elemento dfn para identificar la instancia definitoria de una palabra");
		Tecnica h56 = new Tecnica("H56","Uso del atributo dir en un elemento en línea para resolver problemas con recorridos direccionales anidados");
		Tecnica h57 = new Tecnica("H57","Uso de atributos de idioma en el elemento html ");
		Tecnica h58 = new Tecnica("H58","Uso de atributos del lenguaje para identificar cambios en el lenguaje humano.");
		Tecnica h59 = new Tecnica("H59","Uso del elemento de enlace y las herramientas de navegación");
		Tecnica h60 = new Tecnica("H60","Uso del elemento de enlace para enlazar a un glosario");
		Tecnica h62 = new Tecnica("H62","Usando el elemento rubí");
		Tecnica h63 = new Tecnica("H63","Uso del atributo de alcance para asociar celdas de encabezado y celdas de datos en tablas de datos");
		Tecnica h64 = new Tecnica("H64","Uso del atributo de título del marco y los elementos del marco flotante");
		Tecnica h65 = new Tecnica("H65","Usar el atributo de título para identificar controles de formulario cuando no se puede usar el elemento de etiqueta");
		Tecnica h67 = new Tecnica("H67","Uso de texto alternativo nulo y sin atributo de título en elementos img para imágenes que AT debería ignorar");
		Tecnica h69 = new Tecnica("H69","Proporcionar elementos de encabezado al principio de cada sección de contenido.");
		Tecnica h70 = new Tecnica("H70","Uso de elementos de marco para agrupar bloques de material repetido");
		Tecnica h71 = new Tecnica("H71","Proporcionar una descripción para grupos de controles de formulario utilizando elementos de leyenda y conjunto de campos ");
		Tecnica h73 = new Tecnica("H73","Uso del atributo de resumen del elemento de tabla para ofrecer una descripción general de las tablas de datos");
		Tecnica h74 = new Tecnica("H74","Asegurarse de que las etiquetas de apertura y cierre se utilicen de acuerdo con la especificación.");
		Tecnica h75 = new Tecnica("H75","Asegurarse de que las páginas web estén bien formadas");
		Tecnica h76 = new Tecnica("H76","Uso de meta actualización para crear una redirección instantánea del lado del cliente");
		Tecnica h77 = new Tecnica("H77","Identificar el propósito de un enlace usando el texto del enlace combinado con su elemento de lista adjunto");
		Tecnica h78 = new Tecnica("H78","Identificar el propósito de un enlace usando el texto del enlace combinado con su párrafo adjunto");
		Tecnica h79 = new Tecnica("H79","Identificación del propósito de un enlace en una tabla de datos utilizando el texto del enlace combinado con la celda de la tabla adjunta y las celdas de encabezado de la tabla asociadas");
		Tecnica h80 = new Tecnica("H80","Identificar el propósito de un enlace utilizando el texto del enlace combinado con el elemento de encabezado anterior");
		Tecnica h81 = new Tecnica("H80","Identificar el propósito de un enlace en una lista anidada usando el texto del enlace combinado con el elemento de la lista principal bajo el cual se anida la lista");
		Tecnica h83 = new Tecnica("H83","Usar el atributo de destino para abrir una nueva ventana a solicitud del usuario e indicarlo en el texto del enlace");
		Tecnica h84 = new Tecnica("H84","Usar un botón con un elemento de selección para realizar una acción");
		Tecnica h85 = new Tecnica("H85","Uso de OPTGROUP para agrupar elementos OPTION dentro de un SELECT");
		Tecnica h86 = new Tecnica("H86","Proporcionar alternativas de texto para arte ASCII, emoticonos y leetspeak");
		Tecnica h88 = new Tecnica("H88","Uso de HTML de acuerdo con las especificaciones");
		Tecnica h89 = new Tecnica("H89","Uso del atributo title para proporcionar ayuda contextual");
		Tecnica h90 = new Tecnica("H90","Indicación de los controles de formulario requeridos mediante etiqueta o leyenda");
		Tecnica h91 = new Tecnica("H91","Uso de enlaces y controles de formulario HTML");
		Tecnica h93 = new Tecnica("H93","Asegurarse de que los atributos de identificación sean únicos en una página web");
		Tecnica h94 = new Tecnica("H94","Asegurarse de que los elementos no contengan atributos duplicados");
		Tecnica h95 = new Tecnica("H95","Uso del elemento de seguimiento para proporcionar subtítulos");
		Tecnica h96 = new Tecnica("H96","Uso del elemento de pista para proporcionar descripciones de audio");
		Tecnica h97 = new Tecnica("H97","Agrupación de enlaces relacionados mediante el elemento de navegación");
		
		//Tecnicas C
		Tecnica c06 = new Tecnica("C06","Posicionamiento de contenido basado en marcado estructural");
		Tecnica c07 = new Tecnica("C07","Usar CSS para ocultar una parte del texto del enlace");
		Tecnica c08 = new Tecnica("C08","Uso del espaciado entre letras CSS para controlar el espaciado dentro de una palabra");
		Tecnica c09 = new Tecnica("C09","Usar CSS para incluir imágenes decorativas");
		Tecnica c12 = new Tecnica("C12","Usar porcentaje para tamaños de fuente");
		Tecnica c13 = new Tecnica("C13","Uso de tamaños de fuente con nombre");
		Tecnica c14 = new Tecnica("C14","Uso de unidades em para tamaños de fuente");
		Tecnica c15 = new Tecnica("C15","Usar CSS para cambiar la presentación de un componente de la interfaz de usuario cuando recibe el foco");
		Tecnica c17 = new Tecnica("C17","Escalar elementos de formulario que contienen texto");
		Tecnica c18 = new Tecnica("C18","Uso de reglas de margen y relleno de CSS en lugar de imágenes espaciadoras para el diseño de la disposición");
		Tecnica c19 = new Tecnica("C19","Especificación de la alineación a la izquierda O a la derecha en CSS");
		Tecnica c20 = new Tecnica("C20","Uso de medidas relativas para establecer anchos de columna de modo que las líneas puedan promediar 80 caracteres o menos cuando se cambia el tamaño del navegador");
		Tecnica c21 = new Tecnica("C21","Especificar el espaciado de línea en CSS");
		Tecnica c22 = new Tecnica("C22","Uso de CSS para controlar la presentación visual de texto");
		Tecnica c23 = new Tecnica("C23","Especificar el texto y los colores de fondo del contenido secundario, como los banners, las funciones y la navegación en CSS, sin especificar el texto y los colores de fondo del contenido principal");
		Tecnica c24 = new Tecnica("C24","Uso de valores porcentuales en CSS para tamaños de contenedor");
		Tecnica c25 = new Tecnica("C25","Especificar bordes y diseño en CSS para delinear áreas de una página web sin especificar texto y colores de fondo de texto");
		Tecnica c27 = new Tecnica("C27","Hacer que el orden DOM coincida con el orden visual");
		Tecnica c28 = new Tecnica("C28","Especificación del tamaño de los contenedores de texto mediante unidades em");
		Tecnica c29 = new Tecnica("C29","Uso de un conmutador de estilo para proporcionar una versión alternativa conforme");
		Tecnica c30 = new Tecnica("C30","Usar CSS para reemplazar texto con imágenes de texto y proporcionar controles de interfaz de usuario para cambiar");
		
		
		//Agrego Tecnica a Criterio 1.1.1
		c111.agregarTecnica(h2);
		c111.agregarTecnica(h24);
		c111.agregarTecnica(h35);
		c111.agregarTecnica(h37);
		c111.agregarTecnica(h53);
		c111.agregarTecnica(h86);
		c111.agregarTecnica(h45);
		c111.agregarTecnica(h30);
		c111.agregarTecnica(h36);
		c111.agregarTecnica(h44);
		c111.agregarTecnica(h65);
		c111.agregarTecnica(h67);
		c111.agregarTecnica(c09);
		c111.agregarTecnica(c18);
		
		//Agrego Tecnica a Criterio 1.2.1
		c121.agregarTecnica(h96);
		
		//Agrego Tecnica a Criterio 1.2.2
		c122.agregarTecnica(h95);
		
		//Agrego Tecnica a Criterio 1.2.3
		c123.agregarTecnica(h53);
		c123.agregarTecnica(h96);
		
		//Agrego Tecnica a Criterio 1.3.1
		c131.agregarTecnica(h49);
		c131.agregarTecnica(h51);
		c131.agregarTecnica(h39);
		c131.agregarTecnica(h73);
		c131.agregarTecnica(h63);
		c131.agregarTecnica(h43);
		c131.agregarTecnica(h44);
		c131.agregarTecnica(h65);
		c131.agregarTecnica(h71);
		c131.agregarTecnica(h85);
		c131.agregarTecnica(h48);
		c131.agregarTecnica(h42);
		c131.agregarTecnica(h97);
		c131.agregarTecnica(c22);
		
		//Agrego Tecnica a Criterio 1.3.2
		c132.agregarTecnica(h34);
		c132.agregarTecnica(h56);
		c132.agregarTecnica(c06);
		c132.agregarTecnica(c08);
		c132.agregarTecnica(c27);
		
		//Agrego Tecnica a Criterio 1.3.3
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 1.4.1
		c141.agregarTecnica(c15);
		
		//Agrego Tecnica a Criterio 1.4.2
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 2.1.1
		c211.agregarTecnica(h91);
		
		//Agrego Tecnica a Criterio 2.1.2
		//Agrego Tecnica a Criterio 2.2.1
		//Agrego Tecnica a Criterio 2.2.2
		//Agrego Tecnica a Criterio 2.3.1
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 2.4.1
		c241.agregarTecnica(h69);
		c241.agregarTecnica(h70);
		c241.agregarTecnica(h64);
		c241.agregarTecnica(c06);
		
		//Agrego Tecnica a Criterio 2.4.2
		c242.agregarTecnica(h25);
		
		//Agrego Tecnica a Criterio 2.4.3
		c243.agregarTecnica(h4);
		c243.agregarTecnica(c27);
		
		//Agrego Tecnica a Criterio 2.4.4
		c244.agregarTecnica(h30);
		c244.agregarTecnica(h33);
		c244.agregarTecnica(h77);
		c244.agregarTecnica(h78);
		c244.agregarTecnica(h79);
		c244.agregarTecnica(h81);
		c244.agregarTecnica(c07);
		c244.agregarTecnica(h2);
		c244.agregarTecnica(h80);
		
		//Agrego Tecnica a Criterio 3.1.1
		c311.agregarTecnica(h57);
		
		//Agrego Tecnica a Criterio 3.2.1
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 3.2.2
		c322.agregarTecnica(h32);
		c322.agregarTecnica(h84);
		
		//Agrego Tecnica a Criterio 3.2.3
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 3.3.1
		//Sin tecnicas H o C
		
		//Agrego Tecnica a Criterio 3.3.2
		c332.agregarTecnica(h90);
		c332.agregarTecnica(h44);
		c332.agregarTecnica(h71);	
		c332.agregarTecnica(h65);
		
		//Agrego Tecnica a Criterio 4.1.1
		c411.agregarTecnica(h88);
		c411.agregarTecnica(h74);
		c411.agregarTecnica(h93);
		c411.agregarTecnica(h94);
		c411.agregarTecnica(h75);
		
		//Agrego Tecnica a Criterio 4.1.2
		c412.agregarTecnica(h91);
		c412.agregarTecnica(h44);
		c412.agregarTecnica(h64);
		c412.agregarTecnica(h65);
		c412.agregarTecnica(h88);
		
		//Agrego Criterios a Pauta 1.1
		pa11.agregarPauta(c111);
		
		//Agrego Criterios a Pauta 1.2
		pa12.agregarPauta(c121);
		pa12.agregarPauta(c122);
		pa12.agregarPauta(c123);
		pa12.agregarPauta(c124);
		pa12.agregarPauta(c125);
		
		//Agrego Criterios a Pauta 1.3
		pa13.agregarPauta(c131);
		pa13.agregarPauta(c132);
		pa13.agregarPauta(c133);
		
		//Agrego Criterios a Pauta 1.4
		pa14.agregarPauta(c141);
		pa14.agregarPauta(c142);
		pa14.agregarPauta(c143);
		pa14.agregarPauta(c144);
		pa14.agregarPauta(c145);
		
		//Agrego Criterios a Pauta 2.1
		pa21.agregarPauta(c211);
		pa21.agregarPauta(c212);
		
		//Agrego Criterios a Pauta 2.2
		pa22.agregarPauta(c221);
		pa22.agregarPauta(c222);
		
		//Agrego Criterios a Pauta 2.3
		pa23.agregarPauta(c231);
		
		//Agrego Criterios a Pauta 2.4
		pa24.agregarPauta(c241);
		pa24.agregarPauta(c242);
		pa24.agregarPauta(c243);
		pa24.agregarPauta(c244);
		pa24.agregarPauta(c245);
		pa24.agregarPauta(c246);
		pa24.agregarPauta(c247);
		
		//Agrego Criterios a Pauta 3.1
		pa31.agregarPauta(c311);
		pa31.agregarPauta(c312);
		
		//Agrego Criterios a Pauta 3.2
		pa32.agregarPauta(c321);
		pa32.agregarPauta(c322);
		pa32.agregarPauta(c323);
		pa32.agregarPauta(c324);
		
		//Agrego Criterios a Pauta 3.3
		pa33.agregarPauta(c331);
		pa33.agregarPauta(c332);
		pa33.agregarPauta(c333);
		pa33.agregarPauta(c334);
		
		//Agrego Criterios a Pauta 4.1
		pa41.agregarPauta(c411);
		pa41.agregarPauta(c412);
		
		//Agrego Pauta a Principio 1
		pr1.agregarPauta(pa11);
		pr1.agregarPauta(pa12);
		pr1.agregarPauta(pa13);
		pr1.agregarPauta(pa14);
		
		//Agrego Pauta a Principio 2
		pr2.agregarPauta(pa21);
		pr2.agregarPauta(pa22);
		pr2.agregarPauta(pa23);
		pr2.agregarPauta(pa24);
		
		//Agrego Pauta a Principio 3
		pr3.agregarPauta(pa31);
		pr3.agregarPauta(pa32);
		pr3.agregarPauta(pa33);
		
		//Agrego Pauta a Principio 4
		pr4.agregarPauta(pa41);
		
		principios.add(pr1);
		principios.add(pr2);
		principios.add(pr3);
		principios.add(pr4);
		principios.add(pr5);
		
		// Ejecución de cada una de las tecnicas
		for(Principio principio: principios){
			principio.ejecutarPautas(this.URL);
		}
		
		// Output de la API
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
