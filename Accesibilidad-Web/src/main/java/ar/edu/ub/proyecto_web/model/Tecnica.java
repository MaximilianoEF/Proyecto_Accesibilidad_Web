package ar.edu.ub.proyecto_web.model;

import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Tecnica {
	
	private String codigo; //H1
	private String descripcion; //...
	private ResultadoTecnica resultado;
	
	public Tecnica(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public void ejecutar(String url, HelpersConnection conexion) {
		conexion.getInstancia(url);
		switch(this.codigo) {
		case "H2":
			this.resultado = this.h2(conexion);
			break;
		case "H4":
			this.resultado = this.h4(conexion);
			break;
		default:
			System.out.println("Maxi Gato");
			break;
		}
		
	}
	
    public ResultadoTecnica h2(HelpersConnection conexion) {	
        //Combinando enlaces de texto e imágenes adyacentes para el mismo recurso
        // Procedimiento
        // Para cada a aplicación de esta técnica:
        // - Verifique que cada img elemento contenido dentro del a elemento tenga un valor nulo establecido para su alt atributo.
        // - Verifique que el a elemento contenga un img elemento que tenga un valor de alt atributo nulo o un valor que complemente el texto del enlace y describa la imagen
    	List<WebElement> images = conexion.findElements(By.xpath("//a/img"));
        if(images.size() != 0){
            for(WebElement image : images){
                try {
                    if(image.getAttribute("alt")!=null){
                    	return ResultadoTecnica.OK;
                    	
                    }else {
                    	return ResultadoTecnica.FAIL;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
//            System.out.println("No se encontraron elementos con esta condicion.");
		return ResultadoTecnica.FAIL;
    }

    public ResultadoTecnica h4(HelpersConnection conexion) {
        //Crear un orden de tabulación lógico a través de enlaces, controles de formulario y objetos
        // Procedimiento
        // Compruebe si tabindex se utiliza
        // Si tabindex se utiliza, compruebe que el orden de tabulación especificado por los tabindex atributos sigue las relaciones en el contenido.
        List<WebElement> indexs = conexion.findElements(By.xpath("//*[@tabindex]"));
        if(indexs.size() != 0){
            for(WebElement index : indexs){
                try{
                	if (index.getAttribute("tabindex").equals("")) {
                		  return ResultadoTecnica.FAIL;
                	}                	
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //Se me ocurrio hacerlo asi porque si bien nos pide que halla una correlacion entre los valos de tabindex, estos pueden ser distintos o iguales,
        //si son iguales es posible verificar eso, pero si son distintos necesitaremos de una persona para saber si hay relacion entre dichos valores
        //por eso use un assertFalse indicando igual a vacio, porque ya nos alcanza que tenga un valor en el tabindex, sera condicion necesaria pero no suficiente

    }
	
    public ResultadoTecnica h24(HelpersConnection conexion) {
        //Proporcionar alternativas de texto para los area elementos de los mapas de imágenes.
        // Procedimiento
        // Para cada area elemento en un mapa de imágenes:
        // - Compruebe que el area elemento tenga un alt atributo.
        // - Compruebe que la alternativa de texto especificada por el alt atributo tenga el mismo propósito que la parte de la imagen del mapa de imágenes a la que hace referencia el area elemento del mapa de imágenes.
        List<WebElement> maps = conexion.findElements(By.xpath("//map/area"));
        if(maps.size() != 0){
            for(WebElement map : maps){
                try {
                	if (map.getAttribute("alt").equals("")) {
                		return ResultadoTecnica.FAIL;	
                    	} else {
                    	return ResultadoTecnica.OK;	
                    	}

                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, debido a que podemos verificar que existe algun valor en el atributo alt del area, pero
        //se necesita una persona para verificar que el texto en el atributo alt este relacionado con la referencia a la imagen.
    }
    
    public ResultadoTecnica h25(HelpersConnection conexion) {
        //Proporcionar un título utilizando el elemento title.
        // Procedimiento
        // - Examine el código fuente del documento HTML o XHTML y verifique que title aparezca un elemento no vacío en la head sección.
        // - Compruebe que el title elemento describe el documento.
    	if (conexion.title()!=null) {
    		try {			
				if(conexion.title().equals("")) {
					return ResultadoTecnica.FAIL;	
				} else {
					return ResultadoTecnica.OK;
				}
			} 
    		catch(Throwable t) {
    			System.out.println(t);
    		}
		} 
		return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, con estos 2 asserts verificamos que el titulo de la pagina se encuentre presente,
        //que no sea nulo y que no este vacio pero para saber si describe el contenido necesitamos a una persona.
	}
    
    public ResultadoTecnica h28(HelpersConnection conexion) {
        //Proporcionar definiciones de abreviaturas utilizando el elemento abbr
        // Procedimiento
        // - Compruebe que se proporcione una expansión o definición para cada abreviatura vía abbr.
        List<WebElement> texts = conexion.findElements(By.xpath("//p"));
        if(texts.size() != 0){
            for(WebElement text : texts){
                List<WebElement> abbrs = text.findElements(By.tagName("abbr"));
                if(abbrs.size() != 0){
                    for(WebElement abbr : abbrs){
                        try { 
                            if(abbr.getAttribute("title").equals("")) {
                            	return ResultadoTecnica.FAIL;
                            }
                        } catch(Throwable t) {
                                System.out.println(t);
                        }
                    }
                } else {
                	return ResultadoTecnica.FAIL;
                }
            }
        }
        return ResultadoTecnica.FAIL;
        //Condicion suficiente pero no necesaria, debido a que mediante esta tecnica podemos saber si se utilizan o no las etiquetas abbr,
        //pero no podemos verificar si se utilizan para una abreviatura, se necesita una persona.
        //Se crea una lista de elementos p, en cada p se verifica si no existen dentro de el etiquetas de abbr, si las hay
        //se comprueba de que este tenga el atributo title, si no hay se imprime por pantalla que no existen abreviaturas.
    }
    
    public ResultadoTecnica h30(HelpersConnection conexion) {
        // Proporcionar texto de enlace que describa el propósito de un enlace para elementos de anclaje.
        // Procedimiento
        // Para cada enlace del contenido que utiliza esta técnica:
        // - Compruebe que el a elemento incluye texto o una alternativa de texto para el contenido que no es de texto.
        // - Si un img elemento es el único contenido del a elemento, verifique que su alternativa de texto describa el propósito del enlace.
        // - Si el a elemento contiene uno o más img elementos y el texto alternativo de los img elementos está vacío, verifique que el texto del enlace describa el propósito del enlace.
        // - Si el a elemento solo contiene texto, verifique que el texto describa el propósito del enlace
        List<WebElement> links = conexion.findElements(By.tagName("a"));
        if(links.size() != 0){
            for(WebElement link : links){
                if(link.getAttribute("innerHTML") != null){
                	return ResultadoTecnica.OK;
                } else {
                    List<WebElement> imgs = link.findElements(By.tagName("img"));
                    for(WebElement img : imgs){
                        try{
                        	if(img.getAttribute("alt").equals("")) {
                        		return ResultadoTecnica.FAIL;	
                        	} else {
                        		return ResultadoTecnica.OK;
                        	}
                        } catch (Throwable t){
                            System.out.println(t);
                        }
                    }
                }
            }
        }
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, esta tecnica nos permite verificar que cada elemento a tenga texto dentro de el, caso contrario se verifica
        //que dentro de el existan etiquetas img, y a su vez esas etiquetas deben tener un valor en el atributo alt, lo que no se puede corroborar es si el texto o el texto alternativo
        //este referenciado al tema que trata el link.
    }
    
    public ResultadoTecnica h32(HelpersConnection conexion) {
        //Proporcionar botones de envío
        //Procedimiento
        // Encuentra todas los formularios en el contenido
        // Para cada formulario, verifique que tenga un botón de envío (tipo de entrada = "enviar", tipo de entrada = "imagen" o tipo de botón = "enviar")

        List<WebElement> forms = conexion.findElements(By.tagName("form"));
        if(forms.size() != 0){
            for(WebElement form : forms){
                List<WebElement> inputs = form.findElements(By.xpath("//input[@type='submit' or @type='image']"));
                if(inputs.size() != 0){
                    for(WebElement input : inputs){
                                try {
                            	if(input.getAttribute("type").equals("submit")){
                            		return ResultadoTecnica.OK;
                            	}
                            	else {
                                    try {
                                        if (input.getAttribute("type").equals("image")) {
                                    	return ResultadoTecnica.OK;
                                        }else return ResultadoTecnica.FAIL;
                                    } catch (Throwable t) {
                                        System.out.println(t);
                                    	}
                            		}
                                } catch (Throwable t) {
                                System.out.println(t);
                                	}
                        	} 
                } else {
                    List<WebElement> buttons = form.findElements(By.tagName("button"));
                    if(buttons.size() != 0){
                        for(WebElement button : buttons){
                            try {
                                if(button.getAttribute("type").equals("submit")) {
                                	return ResultadoTecnica.OK;
                                } else return ResultadoTecnica.FAIL;
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    } else return ResultadoTecnica.FAIL;
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //En esta tecnica primero obtenemos los formularios, luego en cada uno de ellos buscamos todas las etiquetas inputs que existan, si existen verificamos que su atributo type sea
        //submit o image, si no existen inputs, buscamos si existen buttons dentro del form, de haberlo se corrobora que su atributo type sea submit, sino devuelve que no hay botones en el formulario.
    }
    
    public ResultadoTecnica h33(HelpersConnection conexion) {
        //Complementar el texto del enlace con el atributo de título
        // Procedimiento
        // - Examine el código fuente en busca de elementos de anclaje.
        // - Para cada elemento de ancla que tenga un title atributo, verifique que el title atributo junto con el texto del enlace describa el propósito del enlace.

        List<WebElement> links = conexion.findElements(By.xpath("//a[@href='']"));
        if(links.size() != 0){
            for(WebElement link : links){
                try {
                    if(link.getAttribute("title").equals("")) {
                    	return ResultadoTecnica.FAIL;
                    }
                    else if(link.getAttribute("innerHTML").equals("")) {
                    	return ResultadoTecnica.FAIL;
                    }
                    else return ResultadoTecnica.OK;
                	
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, ya que esta tecnica nos permite verificar que tanto en el atributo title como en la etiqueta se proporcione un texto descriptivo,
        //sin embargo no podemos corroborar la relacion-logica de dicho texto, para eso se necesita la intervencion de una persona.
    }
    
    public ResultadoTecnica h34(HelpersConnection conexion) {
        //Uso de una marca Unicode de derecha a izquierda (RLM) o marca de izquierda a derecha (LRM) para mezclar la dirección del texto en línea
        // Procedimiento
        // Examine la fuente en busca de lugares donde el texto cambie de dirección.
        // Cuando el texto cambia de dirección, compruebe si los caracteres neutrales, como los espacios o la puntuación, aparecen junto al texto que se representa en la dirección no predeterminada.
        // Cuando el n° 2 es verdadero y el algoritmo bidireccional HTML produciría la ubicación incorrecta de los caracteres neutrales, verifique si los caracteres neutrales van seguidos de marcas Unicode de derecha a izquierda o de izquierda a derecha que hacen que los caracteres neutrales se coloquen como parte de los caracteres anteriores.
    	boolean resultado = false;
        List<WebElement> dirIAD = conexion.findElements(By.xpath("//*[@dir='LTR']"));
        List<WebElement> dirDAI = conexion.findElements(By.xpath("//*[@dir='RTL']"));
        if(dirIAD.size() != 0) {
            for(WebElement dir : dirIAD){
                try {
                    if(dir.getAttribute("dir").equals("LTR")) {
                    	resultado = true;
                    } 
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }else if(dirDAI.size() != 0){
            for(WebElement dir : dirDAI){
                try {
                    if(dir.getAttribute("dir").equals("RTL")) {
                    	resultado = true;
                    } 
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } 
        if(resultado == true) {
        	return ResultadoTecnica.OK;
        }
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, si bien podemos identificar si hay elementos donde la direccion del texto va de izq. a der. o de der. a izq., esto
        //no nos permite corroborar si se debe aplicar este cambio de direccion por el tipo de idioma.
    }
    
    public ResultadoTecnica h35(HelpersConnection conexion) {
        //Proporcionar alternativas de texto sobre applet elementos
        //Procedimiento
        // - Ver el código fuente del elemento applet
        // - Compruebe que el elemento del subprograma contiene un alt atributo con una alternativa de texto para el subprograma
        // - Compruebe que el elemento de la mini aplicación contiene una alternativa de texto para la mini aplicación en el cuerpo del elemento de la mini aplicación
        List<WebElement> applets = conexion.findElements(By.tagName("applet"));
        if(applets.size() != 0){
            for(WebElement applet : applets){
                if(applet.getAttribute("alt") != null && applet.getAttribute("innerHTML") != null){
                    try {
                        if(applet.getAttribute("alt").equals("")) {
                        	return ResultadoTecnica.FAIL;
                        }
                        else if(applet.getAttribute("innerHTML").equals("")) {
                        	return ResultadoTecnica.FAIL;
                        }
                        else return ResultadoTecnica.OK;
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else {
                	return ResultadoTecnica.FAIL;
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, debido a que encontramos los elementos applets, luego verificamos si su atributo alt no esta vacio y su contenido tampoco,
        //pero no podemos asegurar que el texto alternativo describa la mini aplicacion.
    }
    
    public ResultadoTecnica h36(HelpersConnection conexion) {
        //Uso de alt atributos en imágenes utilizadas como botones de envío.
        // Procedimiento
        // Para todos los input elementos que tienen un valor de atributo de tipo de "imagen", verifique la presencia de un alt atributo.
        // Compruebe que el alt atributo indique la función del botón.
        List<WebElement> inputs = conexion.findElements(By.xpath("//input[@type='image']"));
        if(inputs.size() != 0){
            for(WebElement input : inputs){
                if(input.getAttribute("alt") != null){
                    try {
                        if(input.getAttribute("alt").equals("")) {
                        	return ResultadoTecnica.FAIL;
                        }
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else return ResultadoTecnica.FAIL;
            }
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, la tecnica nos permite encontrar los inputs de tipo imagen, luego verifica que su atributo alt tenga un valor,
        //pero no podemos comprobar si dicho valor tiene que ver con el boton o con la imagen, se necesita la intervencion de una persona
    }
    
    public ResultadoTecnica h39(HelpersConnection conexion) {
        //Uso de elementos de título para asociar títulos de tablas de datos con tablas de datos.
        // Procedimiento
        // Para cada tabla de datos:
        // - Compruebe que la tabla incluya un caption elemento.
        // - Compruebe que el contenido del caption elemento identifica a la tabla.
        List<WebElement> tables = conexion.findElements(By.tagName("table"));
        if(tables.size() != 0){
            for(WebElement table : tables){
                List<WebElement> captions = table.findElements(By.tagName("caption"));
                for(WebElement caption : captions){
                    try {
                        if(caption.getAttribute("innerHTML").equals("")) {
                        	return ResultadoTecnica.FAIL;
                        }else return ResultadoTecnica.OK;
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                }
            }
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, porque la tecnica no nos permite comprobar que el contenido del caption identifica a la tabla,
        //solo podemos verificar que en el caption exista contenido.
    }
    
    public ResultadoTecnica h40(HelpersConnection conexion) {
        //Uso de listas de descripción
        // Procedimiento
        // Para cualquier conjunto de términos y sus descripciones asociadas:
        // - Compruebe que la lista esté contenida en un dl elemento.
        // - Compruebe que cada término de la lista que se describe esté incluido en un dt elemento.
        // - Compruebe que cuando hay más de un término que comparte la misma descripción, los dt elementos se suceden inmediatamente.
        // - Compruebe que la descripción de cada término esté contenida en uno o más dd elementos.
        // - Compruebe que uno o más dd elementos siguen inmediatamente al uno o más dt elementos que contienen el término que se describe.
        List<WebElement> dls = conexion.findElements(By.tagName("dl"));
        if(dls.size() != 0){
            for(WebElement dl : dls){
                List<WebElement> dts = dl.findElements(By.xpath("//dt"));
                List<WebElement> dds = dl.findElements(By.xpath("//dd"));
                if(dts.size() == dds.size() && dts.size() != 0 && dds.size() != 0){
                    for(WebElement dt : dts){
                        try {
                            if(dt.getAttribute("innerHTML").equals("")) {
                            	return ResultadoTecnica.FAIL;
                            }
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                    for(WebElement dd : dds){
                        try {
                            if(dd.getAttribute("innerHTML").equals("")) {
                            	return ResultadoTecnica.FAIL;
                            } else return ResultadoTecnica.OK;
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else return ResultadoTecnica.FAIL;
            } 
        } 
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, debido a que la tecnica nos permite ubicar todas las dl, luego verificamos que existan la misma cantidad de dd elementos que de dt elementos,
        //y por ultimo se verifica que cada dd y dt elemento tengan contenido, pero es necesaria la intervencion de una persona para ver la correlacion del contenido.
    }
    
    public ResultadoTecnica h42(HelpersConnection conexion) {
        //Uso de h1-h6 para identificar encabezados
        // Procedimiento
        // - Compruebe que se utiliza el marcado de encabezado cuando el contenido es un encabezado.
        // - Compruebe que el marcado de encabezado no se utilice cuando el contenido no sea un encabezado.
    	boolean resultado = true;
        List<WebElement> h1 = conexion.findElements(By.tagName("h1"));
        List<WebElement> h2 = conexion.findElements(By.tagName("h2"));
        List<WebElement> h3 = conexion.findElements(By.tagName("h3"));
        List<WebElement> h4 = conexion.findElements(By.tagName("h4"));
        List<WebElement> h5 = conexion.findElements(By.tagName("h5"));
        List<WebElement> h6 = conexion.findElements(By.tagName("h6"));
        if(h1.size() != 0 || h2.size() != 0 || h3.size() != 0 || h4.size() != 0 || h5.size() != 0 || h6.size() != 0){
            for(WebElement h : h1){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h2){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h3){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h4){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h5){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h6){
                try {
                    if(h.getAttribute("innerHTML").equals("")) {
                    	resultado = false;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(resultado == true) {
            return ResultadoTecnica.OK;
        }
        return ResultadoTecnica.FAIL;        
        //Condicion necesaria pero no suficiente, esta tecnica nos permite identificar si la mayoria de las etiquetas para encabezados es utilizada, luego de localizar los elementos se analiza uno por uno
        //para verificar que cada elemento h tenga contenido en el, lo que no podemos asegurar es que dicho contenido tenga que ver con el contexto de la pagina, por lo tanto es necesaria la intervencion
        //de una persona.
        //REVISAR TECNICA
    }  
    
    public ResultadoTecnica h43(HelpersConnection conexion) {
        //Uso de atributos id y encabezados para asociar celdas de datos con celdas de encabezado en tablas de datos.
        // Procedimiento
        // - Verifique las tablas de diseño: determine si el contenido tiene una relación con otro contenido tanto en su columna como en su fila. Si "no", la tabla es una tabla de diseño. Si "sí", la tabla es una tabla de datos.
        // - Para las tablas de datos, verifique que cualquier celda que esté asociada con más de una fila y/o un encabezado de columna contenga un headers atributo que enumere id todos los encabezados asociados con esa celda.
        // - Para tablas de datos donde cualquier celda contiene un atributo id o headers,
        //   - Verifique que cada uno de los id listados en el headers atributo de la celda de datos coincida con el id atributo de una celda que se usa como elemento de encabezado
        //   - Verifique que el headers atributo de una celda de datos contenga el id atributo de todos los encabezados asociados con la celda de datos
        //   - Verifique que todos los identificadores sean únicos (es decir, que no haya dos elementos en la página que tengan el mismo identificador)
        boolean resultado = false;
        List<WebElement> tables = conexion.findElements(By.tagName("table"));
        if(tables.size() != 0){
            for(WebElement table : tables){
                List<WebElement> ths_id = table.findElements(By.xpath("//tr/th[@id]"));
                List<WebElement> ths_headers = table.findElements(By.xpath("//tr/th[@id and @headers]"));
                List<WebElement> tds = table.findElements(By.xpath("//tr/td"));
                if(ths_id.size() != 0 && ths_headers.size() != 0){
                    for(WebElement id : ths_id){
                        for(WebElement headers : ths_headers){
                            try {
                                if(id.getAttribute("id").equals(headers.getAttribute("headers"))) {
                                	resultado = true;
                                } else return ResultadoTecnica.FAIL;
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    }
                } else return ResultadoTecnica.FAIL;
                if(tds.size() != 0){
                    for(WebElement td : tds){
                        if(td.getAttribute("headers") != null){
                            for(WebElement id : ths_id){
                                try {
                                    if(td.getAttribute("headers").contains(id.getAttribute("id"))) {
                                    	resultado = true;
                                    } else return ResultadoTecnica.FAIL;
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                        } else return ResultadoTecnica.FAIL;
                    }
                } else return ResultadoTecnica.FAIL;
            }
        }
        if(resultado == true) {
            return ResultadoTecnica.OK;
        }
        return ResultadoTecnica.FAIL;
        //Condicion necesaria pero no suficiente, la tecnica nos permite identificar todas las tables de la pagina, en cada una de estas se analizaran las filas y sus encabezados, se los localiza y una vez esto se evalua si el id de ciertos encabezados coincidan con los headers de otros, luego se evalua si el id de los 
        //encabezados coincida parcialmente con los headers de las filas, sin embargo el primer inconveniente es que no podemos asegurar que sea una tabla de datos puesto que se necesita de la intervencion de una persona para saber si el contenido esta relacionado.
    }
    
    
}
