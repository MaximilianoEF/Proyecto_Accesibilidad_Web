package com.example.ProyAW.Tools;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

@TestInstance(Lifecycle.PER_CLASS)
public class TestPAW {
    
    private WebDriver driver;
    HelpersConnection conexion = new HelpersConnection(driver);
    private String url;

    public TestPAW(String url) {
    	this.url = url;
    }
    
    @BeforeAll
    public void setUp(/*String url*/) {

       conexion.getInstancia("https://output.jsbin.com/likewak");
       //https://www.w3.org/TR/html401/interact/forms.html#h-17.9
       //https://www.w3.org/International/articles/inline-bidi-markup/
       //http://jkorpela.fi/forms/navmenu.html
       //https://www.htmlquick.com/es/reference/tags/fieldset.html
       //https://aprende-web.net/html/ejemplos/ejemplo34.html
       //https://profesordeinformatica.com/index.php?direccion=html/resultado/72
       //https://www.w3.org/International/articles/inline-bidi-markup/
       //"https://www.demoblaze.com/"
       //"https://norfipc.com/codigos/como-usar-recaptcha-para-proteger-formulario.php"

    }

    @Test
    public void h2() {
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
                        assertFalse(image.getAttribute("alt").equals(""));
                    }else {
                        assertNull(image.getAttribute("alt"));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    @Test
    public void h4() {
        //Crear un orden de tabulación lógico a través de enlaces, controles de formulario y objetos
        // Procedimiento
        // Compruebe si tabindex se utiliza
        // Si tabindex se utiliza, compruebe que el orden de tabulación especificado por los tabindex atributos sigue las relaciones en el contenido.

        List<WebElement> indexs = conexion.findElements(By.xpath("//*[@tabindex]"));
        if(indexs.size() != 0){
            for(WebElement index : indexs){
                try{
                    assertFalse(index.getAttribute("tabindex").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }    
        //Se me ocurrio hacerlo asi porque si bien nos pide que halla una correlacion entre los valos de tabindex, estos pueden ser distintos o iguales,
        //si son iguales es posible verificar eso, pero si son distintos necesitaremos de una persona para saber si hay relacion entre dichos valores
        //por eso use un assertFalse indicando igual a vacio, porque ya nos alcanza que tenga un valor en el tabindex, sera condicion necesaria pero no suficiente

    }

    @Test
    public void h24() {
        //Proporcionar alternativas de texto para los area elementos de los mapas de imágenes.
        // Procedimiento
        // Para cada area elemento en un mapa de imágenes:
        // - Compruebe que el area elemento tenga un alt atributo.
        // - Compruebe que la alternativa de texto especificada por el alt atributo tenga el mismo propósito que la parte de la imagen del mapa de imágenes a la que hace referencia el area elemento del mapa de imágenes.

        List<WebElement> maps = conexion.findElements(By.xpath("//map/area"));
        if(maps.size() != 0){
            for(WebElement map : maps){
                try {
                    assertFalse(map.getAttribute("alt").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, debido a que podemos verificar que existe algun valor en el atributo alt del area, pero
        //se necesita una persona para verificar que el texto en el atributo alt este relacionado con la referencia a la imagen.

    }

    @Test
	public void h25() {
        //Proporcionar un título utilizando el elemento title.
        // Procedimiento
        // - Examine el código fuente del documento HTML o XHTML y verifique que title aparezca un elemento no vacío en la head sección.
        // - Compruebe que el title elemento describe el documento.

		try { 
		assertNotNull(conexion.title());
		assertFalse(conexion.title().equals(""));
		} catch(Throwable t) {
			System.out.println(t);
		}
        //Condicion necesaria pero no suficiente, con estos 2 asserts verificamos que el titulo de la pagina se encuentre presente,
        //que no sea nulo y que no este vacio pero para saber si describe el contenido necesitamos a una persona.

	}

    @Test
    public void h28() {
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
                            assertFalse(abbr.getAttribute("title").equals(""));
                        } catch(Throwable t) {
                                System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No existen abreviaturas");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion suficiente pero no necesaria, debido a que mediante esta tecnica podemos saber si se utilizan o no las etiquetas abbr,
        //pero no podemos verificar si se utilizan para una abreviatura, se necesita una persona.
        //Se crea una lista de elementos p, en cada p se verifica si no existen dentro de el etiquetas de abbr, si las hay
        //se comprueba de que este tenga el atributo title, si no hay se imprime por pantalla que no existen abreviaturas.

    }

    @Test
    public void h30() {
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
                    try{
                        assertNotNull(link.getAttribute("innerHTML"));
                    } catch (Throwable t){
                        System.out.println(t);
                    }
                } else {
                    List<WebElement> imgs = link.findElements(By.tagName("img"));
                    for(WebElement img : imgs){
                        try{
                            assertFalse(img.getAttribute("alt").equals(""));
                        } catch (Throwable t){
                            System.out.println(t);
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, esta tecnica nos permite verificar que cada elemento a tenga texto dentro de el, caso contrario se verifica
        //que dentro de el existan etiquetas img, y a su vez esas etiquetas deben tener un valor en el atributo alt, lo que no se puede corroborar es si el texto o el texto alternativo
        //este referenciado al tema que trata el link.

    }

    @Test
    public void h32() {
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
                        if(input.getAttribute("type").equals("submit")){
                            try {
                                assertTrue(input.getAttribute("type").equals("submit"));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        } else {
                            try {
                                assertTrue(input.getAttribute("type").equals("image"));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    }
                } else {
                    List<WebElement> buttons = form.findElements(By.tagName("button"));
                    if(buttons.size() != 0){
                        for(WebElement button : buttons){
                            try {
                                assertTrue(button.getAttribute("type").equals("submit"));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    } else {
                        System.out.println("No existen botones de envio");
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //En esta tecnica primero obtenemos los formularios, luego en cada uno de ellos buscamos todas las etiquetas inputs que existan, si existen verificamos que su atributo type sea
        //submit o image, si no existen inputs, buscamos si existen buttons dentro del form, de haberlo se corrobora que su atributo type sea submit, sino devuelve que no hay botones en el formulario.

    }

    @Test
    public void h33() {
        //Complementar el texto del enlace con el atributo de título
        // Procedimiento
        // - Examine el código fuente en busca de elementos de anclaje.
        // - Para cada elemento de ancla que tenga un title atributo, verifique que el title atributo junto con el texto del enlace describa el propósito del enlace.

        List<WebElement> links = conexion.findElements(By.xpath("//a[@href='']"));
        if(links.size() != 0){
            for(WebElement link : links){
                try {
                    assertFalse(link.getAttribute("title").equals(""));
                    assertFalse(link.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, ya que esta tecnica nos permite verificar que tanto en el atributo title como en la etiqueta se proporcione un texto descriptivo,
        //sin embargo no podemos corroborar la relacion-logica de dicho texto, para eso se necesita la intervencion de una persona.

    }

    @Test
    public void h34() {
        //Uso de una marca Unicode de derecha a izquierda (RLM) o marca de izquierda a derecha (LRM) para mezclar la dirección del texto en línea
        // Procedimiento
        // Examine la fuente en busca de lugares donde el texto cambie de dirección.
        // Cuando el texto cambia de dirección, compruebe si los caracteres neutrales, como los espacios o la puntuación, aparecen junto al texto que se representa en la dirección no predeterminada.
        // Cuando el n° 2 es verdadero y el algoritmo bidireccional HTML produciría la ubicación incorrecta de los caracteres neutrales, verifique si los caracteres neutrales van seguidos de marcas Unicode de derecha a izquierda o de izquierda a derecha que hacen que los caracteres neutrales se coloquen como parte de los caracteres anteriores.

        List<WebElement> dirIAD = conexion.findElements(By.xpath("//*[@dir='LTR']"));
        List<WebElement> dirDAI = conexion.findElements(By.xpath("//*[@dir='RTL']"));
        if(dirIAD.size() != 0) {
            for(WebElement dir : dirIAD){
                try {
                    assertTrue(dir.getAttribute("dir").equals("LTR"));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } if(dirDAI.size() != 0){
            for(WebElement dir : dirDAI){
                try {
                    assertTrue(dir.getAttribute("dir").equals("RTL"));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, si bien podemos identificar si hay elementos donde la direccion del texto va de izq. a der. o de der. a izq., esto
        //no nos permite corroborar si se debe aplicar este cambio de direccion por el tipo de idioma.

    }

    @Test
    public void h35() {
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
                        assertFalse(applet.getAttribute("alt").equals(""));
                        assertFalse(applet.getAttribute("innerHTML").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else {
                    System.out.println("Uno o los 2 elementos son nulos.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, debido a que encontramos los elementos applets, luego verificamos si su atributo alt no esta vacio y su contenido tampoco,
        //pero no podemos asegurar que el texto alternativo describa la mini aplicacion.

    }

    @Test
    public void h36() {
        //Uso de alt atributos en imágenes utilizadas como botones de envío.
        // Procedimiento
        // Para todos los input elementos que tienen un valor de atributo de tipo de "imagen", verifique la presencia de un alt atributo.
        // Compruebe que el alt atributo indique la función del botón.

        List<WebElement> inputs = conexion.findElements(By.xpath("//input[@type='image']"));
        if(inputs.size() != 0){
            for(WebElement input : inputs){
                if(input.getAttribute("alt") != null){
                    try {
                        assertFalse(input.getAttribute("alt").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else {
                    System.out.println("El atributo alt es null");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite encontrar los inputs de tipo imagen, luego verifica que su atributo alt tenga un valor,
        //pero no podemos comprobar si dicho valor tiene que ver con el boton o con la imagen, se necesita la intervencion de una persona

    }

    /*H37: Usar alt atributos en img elementos
    Procedimiento
    - Examina cada imgelemento del contenido.
    - Compruebe que cada imgelemento que transmite significado contiene un altatributo.
    - Si la imagen contiene palabras que son importantes para comprender el contenido, las palabras se incluyen en la alternativa de texto.
    Esta tecnica es inutil intentar realizarla debido a que se necesita la intervencion de una persona para saber si el valor en el atributo alt
    contiene una descripcion de la imagen, asi como palabras importantes en su texto.*/

    @Test
    public void h39() {
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
                        assertFalse(caption.getAttribute("innerHTML").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, porque la tecnica no nos permite comprobar que el contenido del caption identifica a la tabla,
        //solo podemos verificar que en el caption exista contenido.

    }

    @Test
    public void h40() {
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
                            assertFalse(dt.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                    for(WebElement dd : dds){
                        try {
                            assertFalse(dd.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No existe correlacion, hay mas elementos dd que elementos dt o hay mas elementos dt que dd");
                } 
            } 
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, debido a que la tecnica nos permite ubicar todas las dl, luego verificamos que existan la misma cantidad de dd elementos que de dt elementos,
        //y por ultimo se verifica que cada dd y dt elemento tengan contenido, pero es necesaria la intervencion de una persona para ver la correlacion del contenido.

    }

    @Test
    public void h42() {
        //Uso de h1-h6 para identificar encabezados
        // Procedimiento
        // - Compruebe que se utiliza el marcado de encabezado cuando el contenido es un encabezado.
        // - Compruebe que el marcado de encabezado no se utilice cuando el contenido no sea un encabezado.

        List<WebElement> h1 = conexion.findElements(By.tagName("h1"));
        List<WebElement> h2 = conexion.findElements(By.tagName("h2"));
        List<WebElement> h3 = conexion.findElements(By.tagName("h3"));
        List<WebElement> h4 = conexion.findElements(By.tagName("h4"));
        List<WebElement> h5 = conexion.findElements(By.tagName("h5"));
        List<WebElement> h6 = conexion.findElements(By.tagName("h6"));
        if(h1.size() != 0 || h2.size() != 0 || h3.size() != 0 || h4.size() != 0 || h5.size() != 0 || h6.size() != 0){
            for(WebElement h : h1){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h2){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h3){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h4){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h5){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement h : h6){
                try {
                    assertFalse(h.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, esta tecnica nos permite identificar si la mayoria de las etiquetas para encabezados es utilizada, luego de localizar los elementos se analiza uno por uno
        //para verificar que cada elemento h tenga contenido en el, lo que no podemos asegurar es que dicho contenido tenga que ver con el contexto de la pagina, por lo tanto es necesaria la intervencion
        //de una persona.

    }

    @Test
    public void h43() {
        //Uso de atributos id y encabezados para asociar celdas de datos con celdas de encabezado en tablas de datos.
        // Procedimiento
        // - Verifique las tablas de diseño: determine si el contenido tiene una relación con otro contenido tanto en su columna como en su fila. Si "no", la tabla es una tabla de diseño. Si "sí", la tabla es una tabla de datos.
        // - Para las tablas de datos, verifique que cualquier celda que esté asociada con más de una fila y/o un encabezado de columna contenga un headers atributo que enumere id todos los encabezados asociados con esa celda.
        // - Para tablas de datos donde cualquier celda contiene un atributo id o headers,
        //   - Verifique que cada uno de los id listados en el headers atributo de la celda de datos coincida con el id atributo de una celda que se usa como elemento de encabezado
        //   - Verifique que el headers atributo de una celda de datos contenga el id atributo de todos los encabezados asociados con la celda de datos
        //   - Verifique que todos los identificadores sean únicos (es decir, que no haya dos elementos en la página que tengan el mismo identificador)
        
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
                                assertTrue(id.getAttribute("id").equals(headers.getAttribute("headers")));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    }
                } else {
                    System.out.println("Error, estan faltando elementos para evaluar.");
                }
                if(tds.size() != 0){
                    for(WebElement td : tds){
                        if(td.getAttribute("headers") != null){
                            for(WebElement id : ths_id){
                                try {
                                    assertTrue(td.getAttribute("headers").contains(id.getAttribute("id")));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                        } else {
                            System.out.println("Error, estan faltando elementos para evaluar.");
                        }
                    }
                } else {
                    System.out.println("Error, estan faltando elementos para evaluar.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite identificar todas las tables de la pagina, en cada una de estas se analizaran las filas y sus encabezados, se los localiza y una vez esto se evalua si el id de ciertos encabezados coincidan con los headers de otros, luego se evalua si el id de los 
        //encabezados coincida parcialmente con los headers de las filas, sin embargo el primer inconveniente es que no podemos asegurar que sea una tabla de datos puesto que se necesita de la intervencion de una persona para saber si el contenido esta relacionado.
    }

    @Test
    public void h44() {
        //Usar elementos de etiqueta para asociar etiquetas de texto con controles de formulario
        // Procedimiento
        // Para todos los input elementos de tipo text, file o password, para todos textareas y para todos los select elementos de la página web:
        // - Compruebe que hay un label elemento que identifica el propósito del control antes de que el input, textarea o select elemento
        // - Compruebe que el for atributo del label elemento coincide con el ID de la input, textarea o select elemento
        // - Compruebe que el label elemento sea visible.
        // Para todos los input elementos de tipo checkbox o radio en la página Web:
        // - Verifique que haya un label elemento que identifique el propósito del control después del input elemento
        // - Compruebe que el for atributo del label elemento coincide con el id del input elemento.
        // - Compruebe que el label elemento sea visible.

        List<WebElement> inputs_text = conexion.findElements(By.xpath("//input[@type='text']"));
        List<WebElement> inputs_file = conexion.findElements(By.xpath("//input[@type='file']"));
        List<WebElement> inputs_password = conexion.findElements(By.xpath("//input[@type='password']"));
        List<WebElement> textareas = conexion.findElements(By.xpath("//textarea"));
        List<WebElement> selects = conexion.findElements(By.xpath("//select"));
        List<WebElement> checkboxs = conexion.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> radios = conexion.findElements(By.xpath("//input[@type='radio']"));
        List<WebElement> labels = conexion.findElements(By.tagName("label"));
        if(inputs_text.size() != 0){
            for(WebElement text : inputs_text){
                for(WebElement label : labels){
                    if(text.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(text.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));    
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(inputs_file.size() != 0) {
            for(WebElement file : inputs_file){
                for(WebElement label : labels){
                    if(file.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(file.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(inputs_password.size() != 0) {
            for(WebElement password : inputs_password){
                for(WebElement label : labels){
                    if(password.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(password.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(textareas.size() != 0) {
            for(WebElement textarea : textareas){
                for(WebElement label : labels){
                    if(textarea.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(textarea.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(selects.size() != 0) {
            for(WebElement select : selects){
                for(WebElement label : labels){
                    if(select.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(select.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(radios.size() != 0) {
            for(WebElement radio : radios){
                for(WebElement label : labels){
                    if(radio.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(radio.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else if(checkboxs.size() != 0) {
            for(WebElement checkbox : checkboxs){
                for(WebElement label : labels){
                    if(checkbox.getAttribute("id").equals(label.getAttribute("for"))){
                        try {
                            assertTrue(checkbox.getAttribute("id").equals(label.getAttribute("for")));
                            assertNull(label.getAttribute("type"));
                            assertFalse(label.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica realiza todas las verificaciones sin embargo hay un inconveniente el cual es saber si el contenido de las etiquetas estan relacionados con el contexto de la pagina,
        //por lo tanto es necesaria la intervencion de una persona.

    }

    @Test
    public void h45() {
        //Uso de longdesc
        //Procedimiento
        //- Compruebe que el img elemento tenga un atributo longdesc.
        //- Compruebe que el valor del longdesc atributo sea un URL válido de un recurso existente.
        //- Verifique que el contenido en el destino de ese URL contenga una descripción larga que describa el contenido original que no es de texto asociado con él.
        List<WebElement> images = conexion.findElements(By.xpath("//img[@longdesc]"));
        if(images.size() != 0){
            for(WebElement image : images){
                try {
                    assertFalse(image.getAttribute("longdesc").equals(""));
                    assertNotNull(image.getAttribute("longdesc"));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite localizar los img que posean el atributo longdesc, si lo poseen se verifica que el valor del atributo no sea ni vacio ni nulo, pero 
        //no podemos comprobar que ese valor sea una URL valida que contenga una descripcion, para ello nos hara falta la intervencion de una persona.

    }

    @Test
    public void h46() {
        //Uso noembed con embed
        //Procedimiento
        //- Compruebe si el embed elemento tiene un noembed elemento hijo
        //- Compruebe si el embed elemento tiene un noembed elemento que le sigue inmediatamente.
        
        List<WebElement> embeds = conexion.findElements(By.xpath("//embed"));
        if(embeds.size() != 0){
            for(WebElement embed : embeds){
                List<WebElement> noembeds = embed.findElements(By.tagName("noembed"));
                if(noembeds.size() == 1) {
                    try {
                        assertFalse(noembeds.isEmpty());
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else if(noembeds.size() == 0) {
                    List<WebElement> noembed_brother = conexion.findElements(By.xpath("//embed/following-sibling::noembed"));
                    //De esta manera podemos obtener todos aquellas etiquetas "hermanas"
                    if(noembed_brother.size() == 1) {
                        try {
                            assertFalse(noembed_brother.isEmpty());
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    } else if(noembeds.size() == 0) {
                        System.out.println("No hay elementos noembed.");
                    } else {
                        System.out.println("Esta mal diseñado ya que hay mas de un elemento noembed.");
                    }
                } else {
                    System.out.println("Esta mal diseñado ya que hay mas de un elemento noembed.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    @Test
    public void h48() {
        //Uso de ol, ul y dl para listas o grupos de enlaces
        // Procedimiento
        // - Compruebe que el contenido que tiene la apariencia visual de una lista (con o sin viñetas) esté marcado como una lista desordenada.
        // - Compruebe que el contenido que tiene la apariencia visual de una lista numerada esté marcado como una lista ordenada.
        // - Compruebe que el contenido esté marcado como una lista de definiciones cuando los términos y sus definiciones se presenten en forma de lista.

        List<WebElement> unorder_lists = conexion.findElements(By.tagName("ul"));
        List<WebElement> order_lists = conexion.findElements(By.tagName("ol"));
        List<WebElement> definition_lists = conexion.findElements(By.tagName("dl"));
        if(unorder_lists.size() != 0) {
            for(WebElement ul : unorder_lists){
                List<WebElement> lis = ul.findElements(By.tagName("li"));
                if(lis.size() != 0){
                    for(WebElement li : lis){
                        try {
                            assertFalse(li.getAttribute("innerHTML").equals(""));
                            System.out.println(li.getAttribute("innerHTML"));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No existen elementos li, por lo tanto esta mal diseñado.");
                }
            }
        } 
        if(order_lists.size() != 0) {
            for(WebElement ol : order_lists){
                List<WebElement> lis = ol.findElements(By.tagName("li"));
                if(lis.size() != 0){
                    for(WebElement li : lis){
                        try {
                            assertFalse(li.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No existen elementos li, por lo tanto esta mal diseñado.");
                }
            }
        } 
        if(definition_lists.size() != 0) {
            for(WebElement dl : definition_lists){
                List<WebElement> dts = dl.findElements(By.tagName("dt"));
                List<WebElement> dds = dl.findElements(By.tagName("dd"));
                if(dts.size() != 0 && dds.size() != 0 && dts.size() == dds.size()){
                    for(int i=0; i<dts.size(); i++){
                        try {
                            assertFalse(dts.get(i).getAttribute("innerHTML").equals(""));
                            assertFalse(dds.get(i).getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("Esta mal diseñado, faltan o sobran elementos dd y dt.");
                }
            }
        } 
        if(unorder_lists.size() == 0 && order_lists.size() == 0 && definition_lists.size() == 0) {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite identificar si existen elementos ol, ul y dl y si se encuentran correctamente desarrolladas, ademas de verificar si cada uno de los elementos posee contenido en su interior,
        //sin embargo esta tecnica no tiene en cuenta que dependiendo el tipo de contenido, debe ir dentro de un tipo especifico de lista, por lo tanto es necesaria la intervencion de una persona.

    }

    @Test
    public void h49() {
        //Uso de marcado semántico para marcar texto especial o enfatizado
        //Procedimiento
        //- Examine el contenido en busca de información que se transmite a través de variaciones en la presentación del texto.
        //- Compruebe que el marcado semántico apropiado (tal como em, strong, cite, blockquote, sub, y sup) se han utilizado para marcar el texto que la información transmite a través de variaciones en el texto.
        
        List<WebElement> ems = conexion.findElements(By.tagName("em"));
        List<WebElement> strongs = conexion.findElements(By.tagName("strong"));
        List<WebElement> cites = conexion.findElements(By.tagName("cite"));
        List<WebElement> blockquotes = conexion.findElements(By.tagName("blockquote"));
        List<WebElement> subs = conexion.findElements(By.tagName("sub"));
        List<WebElement> sups = conexion.findElements(By.tagName("sup"));
        if(ems.size() != 0) {
            for(WebElement em : ems){
                try{
                    assertFalse(em.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(strongs.size() != 0) {
            for(WebElement strong : strongs){
                try{
                    assertFalse(strong.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(cites.size() != 0) {
            for(WebElement cite : cites){
                try{
                    assertFalse(cite.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(blockquotes.size() != 0) {
            for(WebElement blockquote : blockquotes){
                try{
                    assertFalse(blockquote.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(subs.size() != 0) {
            for(WebElement sub : subs){
                try{
                    assertFalse(sub.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(sups.size() != 0) {
            for(WebElement sup : sups){
                try{
                    assertFalse(sup.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
        if(ems.size() == 0 && strongs.size() == 0 && cites.size() == 0 && blockquotes.size() == 0 && subs.size() == 0 && sups.size() == 0) {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite ubicar estas etiquetas especiales y verificar si cada una de ella posee contenido, el mayor inconveniente es que la información que se transmite a través de variaciones en la presentación del texto no esta comprobada,
        //por lo tanto nos estaria faltando la intervencion de una persona.

    }

    /*H51: Uso de marcado de tabla para presentar información tabular
    Procedimiento 
    - Verifique la presencia de información tabular.
    - Para cada aparición de información tabular:
       Compruebe que etiquetado de la tabla con al menos los elementos table, tr, thy td se utiliza.
    Esta tecnica es inutil desarrollarla debido a que depende de la informacion, la informacion nos guiara para saber que tipo de etiqueta debe llevar, por lo tanto esta tecnica es puramente
    para la intervencion de una persona.*/
    
    @Test
    public void h53() {
        //Usando el cuerpo del object elemento.
        // Procedimiento
        // - Compruebe que el cuerpo de cada object elemento contiene una alternativa de texto para el objeto.

        List<WebElement> objects = conexion.findElements(By.xpath("//object"));
        if(objects.size() != 0) {
            for(WebElement object : objects){
                List<WebElement> ps = object.findElements(By.tagName("p"));
                List<WebElement> imgs = object.findElements(By.tagName("img"));
                List<WebElement> objects1 = object.findElements(By.tagName("object"));
                if(ps.size() != 0) {
                    for(WebElement p : ps){
                        try{
                            assertFalse(p.getAttribute("innerHTML").equals(""));
                        } catch(Throwable t){
                            System.out.println(t);
                        }
                    }
                } else if(imgs.size() != 0) {
                    for(WebElement img : imgs){
                        try{
                            assertFalse(img.getAttribute("alt").equals(""));
                        } catch(Throwable t){
                            System.out.println(t);
                        }
                    }
                } else if(objects1.size() != 0) {
                    for(WebElement object1 : objects1){
                        try{
                            assertFalse(object1.getAttribute("innerHTML").equals(""));
                        } catch(Throwable t){
                            System.out.println(t);
                        }
                    }
                } else {
                    try{
                        assertFalse(object.getAttribute("innerHTML").equals(""));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }
    
    @Test
    public void h54() {
        //Usar el dfn elemento para identificar la instancia definitoria de una palabra
        //Procedimiento
        //- Identifique todas las palabras que están definidas en línea en el texto, es decir, donde la definición ocurre en una oración cerca de una ocurrencia de la palabra.
        //- Compruebe que cada palabra que se define en línea esté contenida en un dfn elemento.
        
        List<WebElement> defineds = conexion.findElements(By.xpath("//dfn"));
        if(defineds.size() != 0) {
            for(WebElement dfn : defineds){
                try{
                    assertFalse(dfn.getAttribute("innerHTML").equals(""));
                } catch(Throwable t){
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, en la tecnica se pueden localizar las etiquetas dfn y ver si poseen contenido, sin embargo es necesaria la intervencion 
        //de una persona para corroborar que se emplee en el contexto de definicion de una palabra o termino.

    }

    @Test
    public void h56() {
        //Uso del dir atributo en un elemento en línea para resolver problemas con recorridos direccionales anidados
        // Procedimiento
        // - Examinar la dirección del texto del texto en el documento.
        // - Si la dirección del texto es de derecha a izquierda, verifique que para el elemento ancestro que tiene un dir atributo, el atributo tenga el valor "rtl"        
        // - Si la dirección del texto es de izquierda a derecha, verifique que no haya ningún elemento ancestro con un dir atributo, o que para el elemento ancestro que tenga un dir atributo, el atributo tenga el valor "ltr"

        List<WebElement> cites = conexion.findElements(By.xpath("//p/cite"));
        List<WebElement> spans = conexion.findElements(By.xpath("//p/span"));
        if(cites.size() != 0){
            for(WebElement cite : cites){
                if(cite.getAttribute("dir").equals("rtl")){
                    try{
                        assertTrue(cite.getAttribute("dir").equals("rtl"));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                } else if(cite.getAttribute("dir").equals("ltr")){
                    try{
                        assertTrue(cite.getAttribute("dir").equals("ltr"));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
        } else if(spans.size() != 0){
            for(WebElement span : spans){
                if(span.getAttribute("dir").equals("rtl")){
                    try{
                        assertTrue(span.getAttribute("dir").equals("rtl"));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                } else if(span.getAttribute("dir").equals("ltr")){
                    try{
                        assertTrue(span.getAttribute("dir").equals("ltr"));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, si bien la tecnica se cumple parcialmente puesto que para que esto suceda se debe identificar que hay un idioma hebreo-indio, es decir, la precencia de un idioma de izquierda a derecha o 
        //de derecha a izquierda, para ello se requerira la intervencion de una persona. La tecnica nos permite identificar si dentro de un parrafo se encuentra un span o un cite, y luego verifica si posee el atributo dir; hay una pequeña duda
        //puesto que en la pagina de la W3 aparecen solo estas 2 etiquetas, pero la tecnica habla sobre los elementos de texto en linea y los elementos de linea son varios; consultar entre todos que decision tomar
        //a, abbr, acronym, b, basefont, bdo, big, br, cite, code, dfn, em, font, i, img, input, kbd, label, q, s, samp, select, small, span, strike, strong, sub, sup, textarea, tt, u, var
    
    }

    @Test
    public void h57() {
        //Uso de atributos de idioma en el elemento html
        //Examine el html elemento del documento.
        // Compruebe que el html elemento tenga un atributo lang y/o xml:lang.
        // Verifique que el valor del lang atributo cumpla con BCP 47: Etiquetas para la identificación de idiomas o su sucesor y refleje el idioma principal utilizado por la página web.
        String idiomas[] = {"aa", "ab", "ae", "af", "ak", "am", "an", "ar", "as", "av", "ay", "az", "ba", "be", "bg", "bh", "bi", "bm", "bn", "bo", "br", "bs", "ca", "ce", "ch", "co", "cr", "cs", "cu", "cv", "cy", "da", "de", "dv", "dz", "ee", "el", "en", "eo", "es", "et", "eu", "fa", "ff", "fi", "fj", "fo", "fr", "fy", "ga", "gd", "gl", "gn", "gu", "gv", "ha", "he", "hi", "ho", "hr", "ht", "hu", "hy", "hz", "ia", "id", "ie", "ig", "ii", "ik", "io", "is", "it", "iu", "ja", "jv", "ka", "kg", "ki", "kj", "kk", "kl", "km", "kn", "ko", "kr", "ks", "ku", "kv", "kw", "ky", "la", "lb", "lg", "li", "ln", "lo", "lt", "lu", "lv", "mg", "mh", "mi", "mk", "ml", "mn", "mr", "ms", "mt", "my", "na", "nb", "nd", "ne", "ng", "nl", "nn", "no", "nr", "nv", "ny", "oc", "oj", "om", "or", "os", "pa", "pi", "pl", "ps", "pt", "qu", "rm", "rn", "ro", "ru", "rw", "sa", "sc", "sd", "se", "sg", "si", "sk", "sl", "sm", "sn", "so", "sq", "sr", "ss", "st", "su", "sv", "sw", "ta", "te", "tg", "th", "ti", "tk", "tl", "tn", "to", "tr", "ts", "tt", "tw", "ty", "ug", "uk", "ur", "uz", "ve", "vi", "vo", "wa", "wo", "xh", "yi", "yo", "za", "zh", "zu"};
        WebElement html = conexion.findElement(By.tagName("html"));
        if(html.getAttribute("lang").length() != 0){
            for(int i=0; i<idiomas.length; i++){
                if(html.getAttribute("lang").equals(idiomas[i])){
                    try {
                        assertTrue(html.getAttribute("lang").equals(idiomas[i]));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Nota: Selenium no estaria reconociendo el atributo xml:lang en ningun tipo de etiqueta

    }

    @Test
    public void h58() {
        //Uso de atributos del lenguaje para identificar cambios en el lenguaje humano.
        //Para cada elemento del documento:
        //- Verifique que el lenguaje humano del contenido del elemento sea el mismo que el lenguaje heredado del elemento como se especifica en HTML 4.01, Herencia de códigos de idioma
        //- Para cada lang atributo del documento:
        //  - Verifique que el valor del lang atributo se ajuste a BCP 47: Etiquetas para la Identificación de Idiomas o su sucesor
        //- Para cada atributo xml: lang en el documento:
        //  - Verifique que el valor del xml:lang atributo se ajuste a BCP 47: Etiquetas para la Identificación de Idiomas o su sucesor
        WebElement html = conexion.findElement(By.tagName("html"));
        List<WebElement> langs = html.findElements(By.xpath("//*[@lang]"));
        String idiomas[] = {"aa", "ab", "ae", "af", "ak", "am", "an", "ar", "as", "av", "ay", "az", "ba", "be", "bg", "bh", "bi", "bm", "bn", "bo", "br", "bs", "ca", "ce", "ch", "co", "cr", "cs", "cu", "cv", "cy", "da", "de", "dv", "dz", "ee", "el", "en", "eo", "es", "et", "eu", "fa", "ff", "fi", "fj", "fo", "fr", "fy", "ga", "gd", "gl", "gn", "gu", "gv", "ha", "he", "hi", "ho", "hr", "ht", "hu", "hy", "hz", "ia", "id", "ie", "ig", "ii", "ik", "io", "is", "it", "iu", "ja", "jv", "ka", "kg", "ki", "kj", "kk", "kl", "km", "kn", "ko", "kr", "ks", "ku", "kv", "kw", "ky", "la", "lb", "lg", "li", "ln", "lo", "lt", "lu", "lv", "mg", "mh", "mi", "mk", "ml", "mn", "mr", "ms", "mt", "my", "na", "nb", "nd", "ne", "ng", "nl", "nn", "no", "nr", "nv", "ny", "oc", "oj", "om", "or", "os", "pa", "pi", "pl", "ps", "pt", "qu", "rm", "rn", "ro", "ru", "rw", "sa", "sc", "sd", "se", "sg", "si", "sk", "sl", "sm", "sn", "so", "sq", "sr", "ss", "st", "su", "sv", "sw", "ta", "te", "tg", "th", "ti", "tk", "tl", "tn", "to", "tr", "ts", "tt", "tw", "ty", "ug", "uk", "ur", "uz", "ve", "vi", "vo", "wa", "wo", "xh", "yi", "yo", "za", "zh", "zu"};
        if(langs.size() != 0){
            for(WebElement lang : langs){
                if(lang.getAttribute("lang").length() != 0){
                    for(int i=0; i<idiomas.length; i++){
                        if(lang.getAttribute("lang").equals(idiomas[i])){
                            try {
                                assertTrue(lang.getAttribute("lang").equals(idiomas[i]));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Nota: Selenium no estaria reconociendo el atributo xml:lang en ningun tipo de etiqueta

    }

    @Test
    public void h59() {
        //Uso del elemento de enlace y las herramientas de navegación
        //Para una página web que se encuentra dentro de una secuencia o colección de páginas web:
        // - Compruebe que todos los link elementos relacionados con la navegación se encuentran en la head sección del documento.
        // - Para cada link elemento de la head sección del documento que pertenece a la navegación, verifique que contenga al menos:
        //     * un rel atributo que identifica el tipo de enlace
        //     * un href atributo válido para localizar el recurso apropiado
        List<WebElement> head_links = conexion.findElements(By.xpath("//head/link"));
        if(head_links.size() != 0){
            for(WebElement link : head_links){
                try {
                    assertFalse(link.getAttribute("rel").equals(""));
                    assertFalse(link.getAttribute("href").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    @Test
    public void h60() {
        //Para cualquier conjunto de palabras y sus definiciones que sirvan como glosario:
        // Verifique que la head sección de la página web que contiene palabras, frases o abreviaturas definidas en un glosario contiene un link elemento
        // Verifica que el link elemento tenga atributo rel="glossary"
        // Compruebe que el href atributo del link elemento se refiere a la página del glosario.
        List<WebElement> head_links = conexion.findElements(By.xpath("//head/link"));
        if(head_links.size() != 0){
            for(WebElement link : head_links){
                if(link.getAttribute("rel").equals("glossary")){
                    try {
                        assertTrue(link.getAttribute("rel").equals("glossary"));
                        assertFalse(link.getAttribute("href").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else {
                    System.out.println("No se encontro el atributo deceado.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, debemos verificar con una persona si se esta definiendo un glosario de manera externa, a travez de una URL, luego la tecnica
        //realiza lo demas, en este caso intentamos localizar los elementos link dentro del head, si los hay preguntamos si alguno posee un atributo rel con valor glossary, y en ese caso 
        //se realizan los assert.

    }

    @Test
    public void h62() {
        //Usando el elemento rubí
        //Procedimiento
        //Para cada ejecución de texto donde se usa una anotación Ruby para proporcionar información de pronunciación:
        //- Compruebe que un rtelemento contiene información de pronunciación para cada texto definido por el rbelemento.
        //- Si se usa un marcado Ruby simple, verifique que el rpelemento esté presente para indicar a los agentes de usuario que no admiten anotaciones Ruby que el texto en el elemento rt proporciona la información de pronunciación.
        List<WebElement> leguage = conexion.findElements(By.xpath("//*[@lang='ja'or@lang='ch']"));
        if(leguage.size() != 0){
            List<WebElement> rubys = conexion.findElements(By.xpath("//ruby"));
            if(rubys.size() != 0){
                for(WebElement ruby : rubys){
                    WebElement rb = ruby.findElement(By.tagName("rb"));
                    WebElement rt = ruby.findElement(By.xpath("//rb/following-sibling::rt"));
                    if(rb != null && rt != null){
                        try{
                            assertFalse(rb.getAttribute("innerHTML").equals(""));
                            assertFalse(rt.getAttribute("innerHTML").equals(""));
                        } catch(Throwable t) {
                            System.out.println(t);
                        }
                    } else if(rb != null){
                        WebElement rp = ruby.findElement(By.xpath("//rb/following-sibling::rp"));
                        if (rp != null) {
                            WebElement rt_child = rp.findElement(By.tagName("rt"));
                            WebElement rt_brother = ruby.findElement(By.xpath("//rp/following-sibling::rt"));
                            if(rt_child != null){
                                try{
                                    assertFalse(rb.getAttribute("innerHTML").equals(""));
                                    assertFalse(rt_child.getAttribute("innerHTML").equals(""));
                                } catch(Throwable t) {
                                    System.out.println(t);
                                }
                            } else if(rt_brother != null){
                                try{
                                    assertFalse(rb.getAttribute("innerHTML").equals(""));
                                    assertFalse(rt_brother.getAttribute("innerHTML").equals(""));
                                } catch(Throwable t) {
                                    System.out.println(t);
                                }
                            } else {
                                System.out.println("La etiqueta rp no posee ningun elemento rt");
                            }
                        } else {
                            System.out.println("Esta mal diseñado.");
                        }
                    }
                }
            } else {
                System.out.println("No se emplea ningun elemento ruby");
            }
        } else {
            System.out.println("No se detecto el idioma para el cual se implementa la tecnica.");
        }
        
        //Ruby se usa comúnmente para texto en japonés y otros idiomas de Asia oriental.
    }

    @Test
    public void h63() {
        //Uso del atributo de alcance para asociar celdas de encabezado y celdas de datos en tablas de datos
        //Procedimiento:
        //Para cada tabla de datos:
        //- Compruebe que todos los th elementos tengan un scope atributo.
        //- Compruebe que todos los td elementos que actúan como encabezados de otros elementos tengan un scope atributo.
        //- Compruebe que todos los scope atributos tienen el valor row, col, rowgroup, o colgroup.
        List<WebElement> ths = conexion.findElements(By.tagName("th"));
        List<WebElement> tds = conexion.findElements(By.tagName("td"));
        String valores[] = {"row", "col", "rowgroup", "colgroup"}; 
        if(ths.size() != 0){
            for(WebElement th : ths){
                for(int i=0; i<valores.length; i++){
                    try {
                        assertFalse(th.getAttribute("scope").equals(valores[i]));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                }
            }
        } if(tds.size() != 0){
            for(WebElement td : tds){
                for(int i=0; i<valores.length; i++){
                    try {
                        assertFalse(td.getAttribute("scope").equals(valores[i]));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    @Test
    public void h64() {
        //Uso del title atributo de los elementos frame y iframe
        //Procedimiento
        //- Verifique cada marco y elemento iframe en el código fuente HTML o XHTML para ver la presencia de un atributo de título.
        //- Compruebe que el atributo del título contiene texto que identifica el marco.
        List<WebElement> frames = conexion.findElements(By.tagName("frame"));
        List<WebElement> iframes = conexion.findElements(By.tagName("iframe"));
        if(frames.size() != 0 || iframes.size() != 0){
            for(WebElement frame : frames){
                try {
                    assertFalse(frame.getAttribute("title").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
            for(WebElement iframe : iframes){
                try {
                    assertFalse(iframe.getAttribute("title").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    @Test
    public void h65() {
        //Usar el atributo de título para identificar controles de formulario cuando no se puede usar el elemento de etiqueta
        //Procedimiento
        //Identificar cada control de formulario que no esté asociado con un label elemento.
        //- Verifique que el control tenga un title atributo
        //- Compruebe que el title atributo identifica el propósito del control.
        List<WebElement> forms = conexion.findElements(By.xpath("//form"));
        String tipo_input[] = {"button","submit","cancel","reset","image","text","password","radio","checkbox"};
        if(forms.size() != 0){
            for(WebElement form : forms){
                List<WebElement> inputs = form.findElements(By.xpath("//input"));
                List<WebElement> buttons = form.findElements(By.xpath("//button"));
                List<WebElement> textareas = form.findElements(By.xpath("//textarea"));
                List<WebElement> selects = form.findElements(By.xpath("//select"));
                if(inputs.size() != 0){
                    for(WebElement input : inputs){
                        for(int i=0; i<tipo_input.length; i++){
                            if(input.getAttribute("type").equals(tipo_input[i])){
                                try {
                                    assertFalse(input.getAttribute("title").equals(""));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("No posee elementos de tipo input.");
                }
                
                if(buttons.size() != 0){
                    for(WebElement button : buttons){
                        try {
                            assertFalse(button.getAttribute("title").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No posee elementos de tipo button.");
                } 
                
                if(textareas.size() != 0){
                    for(WebElement textarea : textareas){
                        try {
                            assertFalse(textarea.getAttribute("title").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No posee elementos de tipo textarea.");
                }
                
                if(selects.size() != 0){
                    for(WebElement select : selects){
                        try {
                            assertFalse(select.getAttribute("title").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else {
                    System.out.println("No posee elementos de tipo select.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        

    }

    @Test
    public void h67() {
        //Uso de texto alternativo nulo y sin atributo de título en elementos img para imágenes que AT debería ignorar
        //Procedimiento
        //Para cada imagen que debe ignorarse:
        //- Compruebe que el titleatributo esté ausente o vacío.
        //- Verifique que el altatributo esté presente y vacío.
        List<WebElement> images = conexion.findElements(By.tagName("img"));
        if(images.size() != 0){
            for(WebElement image : images){
                if(image.getAttribute("title") == null && image.getAttribute("alt").equals("")){
                    try {
                        assertNull(image.getAttribute("title"));
                        assertTrue(image.getAttribute("alt").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } if(image.getAttribute("title") != null && image.getAttribute("alt").equals("")){
                    try {
                        assertTrue(image.getAttribute("title").equals(""));
                        assertTrue(image.getAttribute("alt").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                } 
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }

    }

    /*H69: Proporcionar elementos de encabezado al principio de cada sección de contenido.
    Procedimiento
    - Verifique que el contenido esté dividido en secciones separadas
    - Compruebe que cada sección de la página comience con un título.*/

    @Test
    public void h70() {
        //Uso de elementos de marco para agrupar bloques de material repetido
        //Procedimiento
        //Si la página web utiliza marcos para organizar el contenido:
        //- Compruebe si los bloques de contenido repetidos están organizados en marcos separados.
        //- Compruebe que los fotogramas con contenido repetido aparezcan en la misma ubicación dentro de cada conjunto de fotogramas.
        List<WebElement> framesets = conexion.findElements(By.tagName("frameset"));
        if(framesets.size() != 0){
            for(WebElement frameset : framesets){
                List<WebElement> frames = frameset.findElements(By.tagName("frame"));
                List<WebElement> noframes = frameset.findElements(By.tagName("noframes"));
                List<WebElement> framesets2 = frameset.findElements(By.tagName("frameset"));
                if(frames.size() != 0 && noframes.size() == 0 && framesets2.size() == 0){
                    for(WebElement frame : frames){
                        try {
                            assertFalse(frame.getAttribute("src").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else if(frames.size() != 0 && noframes.size() != 0 && framesets2.size() == 0){
                    for(WebElement frame : frames){
                        try {
                            assertFalse(frame.getAttribute("src").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                    for(WebElement noframe : noframes){
                        try {
                            assertFalse(noframe.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                } else if(frames.size() != 0 && noframes.size() != 0 && framesets2.size() != 0){
                    for(WebElement frame : frames){
                        try {
                            assertFalse(frame.getAttribute("src").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                    for(WebElement noframe : noframes){
                        try {
                            assertFalse(noframe.getAttribute("innerHTML").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    }
                    for(WebElement frameset2 : framesets2){
                        List<WebElement> frames2 = frameset2.findElements(By.xpath("//frameset/frame"));
                        List<WebElement> noframes2 = frameset2.findElements(By.xpath("//frameset/noframes"));
                        if(frames2.size() != 0 && noframes2.size() != 0){
                            for(WebElement frame : frames2){
                                try {
                                    assertFalse(frame.getAttribute("src").equals(""));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                            for(WebElement noframe : noframes2){
                                try {
                                    assertFalse(noframe.getAttribute("innerHTML").equals(""));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                        } else {
                            System.out.println("No se encontraron elementos con esta condicion.");
                        }
                    }
                } else if(frames.size() == 0 && noframes.size() == 0 && framesets2.size() != 0){
                    for(WebElement frameset2 : framesets2){
                        List<WebElement> frames2 = frameset2.findElements(By.xpath("//frameset/frame"));
                        List<WebElement> noframes2 = frameset2.findElements(By.xpath("//frameset/noframes"));
                        if(frames2.size() != 0 && noframes2.size() != 0){
                            for(WebElement frame : frames2){
                                try {
                                    assertFalse(frame.getAttribute("src").equals(""));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                            for(WebElement noframe : noframes2){
                                try {
                                    assertFalse(noframe.getAttribute("innerHTML").equals(""));
                                } catch (Throwable t) {
                                    System.out.println(t);
                                }
                            }
                        } else {
                            System.out.println("No se encontraron elementos con esta condicion.");
                        }
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite identificar si se utiliza el elemento frameset, luego localizamos las distintas posibilidades en las que podria estar diseñado, de manera correcta segun la W3C,
        //una vez identificados los frames y los noframes, se comprueba que los noframes no esten vacios y que el frame exista, lo que no podemos comprobar es si el contenido repetido se encuentre en 2 frames distintos, para ello se necesitara la intervencion de una persona.
        //Discutir si combiene implementar lo siguiente:
        // for(int i=0; i<framesets.size(); i++)
        //     for(int j=0; j<framesets.size(); j++)
        //         if(j != i)
        //             lista de frame, noframe a travez de frameset.get(i)
        //             lista de frame, noframe a travez de frameset.get(j)
        //             Realizar los assert verificando si el contenido de frame(i) es igual a frame(j)

    }

    @Test
    public void h71() {
        //Proporcionar una descripción para grupos de controles de formulario utilizando elementos de leyenda y conjunto de campos
        //Procedimiento
        //Para grupos de controles relacionados donde las etiquetas individuales para cada control no proporcionan una descripción suficiente y se necesita una descripción adicional a nivel de grupo,
        //- Compruebe que el grupo de elementos inputo relacionados lógicamente selectestén contenidos dentro de los fieldsetelementos.
        //- Verifique que cada uno fieldsettenga un legendelemento que incluya una descripción para ese grupo.
        List<WebElement> fieldsets = conexion.findElements(By.tagName("fieldset"));
        String tipo_input[] = {"button","submit","cancel","reset","image","text","password","radio","checkbox"};
        if(fieldsets.size() != 0){
            for(WebElement fieldset : fieldsets){
                WebElement legend = fieldset.findElement(By.xpath("//legend"));
                if(legend.getAttribute("innerHTML") != ""){
                    List<WebElement> inputs = fieldset.findElements(By.xpath("//input"));
                    List<WebElement> selects = fieldset.findElements(By.xpath("//select"));
                    if(inputs.size() != 0 && selects.size() == 0){
                        for(WebElement input : inputs){
                            for(int i=0; i<tipo_input.length; i++){
                                if(input.getAttribute("type").equals(tipo_input[i])){
                                    try{
                                        assertTrue(input.getAttribute("type").equals(tipo_input[i]));
                                        assertFalse(legend.getAttribute("innerHTML").equals(""));
                                    } catch(Throwable t){
                                        System.out.println(t);
                                    }
                                }
                            }
                        }
                    } else if(inputs.size() == 0 && selects.size() != 0){
                        for(WebElement select : selects){
                            try{
                                assertFalse(select.getAttribute("title").equals(""));
                                assertFalse(legend.getAttribute("innerHTML").equals(""));
                            } catch(Throwable t){
                                System.out.println(t);
                            }
                        }
                    } else {
                        System.out.println("No se encontraron elementos inputs o selects, o hay ambos elementos en el mismo fieldset, significa que esta mal diseñado");
                    }
                } else {
                    System.out.println("No se encontraron elementos legend, significa que esta mal diseñado");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, si bien esta tecnica nos permite localizar si hay fieldset, si este emplea un legend como descripcion y si emplea inputs o selects, aun queda por confirmar que la descripcion del legend no sea suficiente
        //como para tener que agrupar el formulario en grupos de controles y tambien falta verificar si esta bien agrupado los controles por su contenido, para ello hace falta la intervencion de una persona.

    }

    @Test
    public void h73() {
        //Uso del atributo de resumen del elemento de tabla para ofrecer una descripción general de las tablas de datos
        //Procedimiento
        //Para cada tabla de datos:
        //- Si summary esta presente , compruebe que el summary atributo describe la organización de la tabla o explica cómo utilizar la tabla.
        //- Si tanto un summary atributo como un caption elemento están presentes para la tabla de datos, verifique que summary no duplique el caption.
        List<WebElement> tables = conexion.findElements(By.tagName("table"));
        if(tables.size() != 0){
            for(WebElement table: tables) {
                List<WebElement> captions = table.findElements(By.xpath("//caption"));
                if(captions.size() == 0 && table.getAttribute("summary").equals("") == false){
                    try{
                        assertFalse(table.getAttribute("summary").equals(""));
                    } catch (Throwable t){
                        System.out.println(t);
                    }
                } else if(captions.size() != 0 && table.getAttribute("summary").equals("") == false){
                    for(WebElement caption : captions){
                        if(table.getAttribute("summary").equals(caption.getAttribute("innerHTML")) == false){
                            try{
                                assertFalse(table.getAttribute("summary").equals(caption.getAttribute("innerHTML")));
                            } catch (Throwable t){
                                System.out.println(t);
                            }
                        } else {
                            System.out.println("El contenido del summary se repite en el caption, por lo tanto esta mal diseñado.");
                        }
                    }
                } else {
                    System.out.println("No hay summary, ni caption dentro del table.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica nos permite identificar el uso de summary en un table y si se utiliza o no un elemento caption, tambien nos confirma si el contenido del summary es igual al contenido del caption
        //por lo que podemos ver si el contenido se repite, sin embargo no podemos asegurar que el summary proporciona una breve descripción de cómo se han organizado los datos en una tabla, por ello necesitaremos la intervencion de una persona.

    }

    /*H74: Asegurarse de que las etiquetas de apertura y cierre se utilicen de acuerdo con la especificación
    Procedimiento
    - Compruebe que haya etiquetas de cierre para todos los elementos con etiquetas de cierre requeridas.
    - Compruebe que no haya etiquetas de cierre para todos los elementos en los que están prohibidas las etiquetas de cierre.
    - Compruebe que las etiquetas de apertura y cierre de todos los elementos estén correctamente anidadas.*/

    /*H75: Asegurarse de que las páginas web estén bien formadas
    Necesitamos un Analizador XML y ver de que manera atrapar los archivos XML para ingresarlos en dicho analizador
    Procedimiento
    - Cargue cada archivo en un analizador XML de validación.
    - Compruebe que no haya errores de forma correcta.
    https://validator.w3.org/unicorn/ es un validador*/

    @Test
    public void h76() {
        // Uso de la actualización de metadatos para crear una redirección instantánea del lado del cliente
        // Procedimiento
        // - Encuentra todos los metaelementos del documento.
        // - Para cada meta elemento, verifique si contiene el atributo http-equivcon el valor " refresh" (no distingue entre mayúsculas y minúsculas) y el contentatributo con un número mayor que 0 seguido de ;'URL=anyURL'(donde anyURL significa el URI que debería reemplazar la página actual).
        
        List<WebElement> metas = conexion.findElements(By.tagName("meta"));
        if(metas.size() != 0){
            for(WebElement meta: metas) {
            	if(meta.getAttribute("http-equiv") != null && meta.getAttribute("content") != null) {
            		if(meta.getAttribute("http-equiv").equals("refresh") && meta.getAttribute("content").indexOf("0;URL=") != -1){
                        try {
                            assertTrue(meta.getAttribute("http-equiv").equals("refresh"));
                            assertFalse(meta.getAttribute("content").equals(""));
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                    } else {
                        System.out.println("No se encontraron elementos con esta condicion, esta mal diseñado.");
                    }
            	} else {
                    System.out.println("No se encontraron elementos con esta condicion, esta mal diseñado.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
    } 

    @Test
    public void h77() {
        // Identificar el propósito de un enlace usando el texto del enlace combinado con su elemento de lista adjunto
        // Procedimiento
        // Para cada enlace del contenido que utiliza esta técnica:
        //     - Compruebe que el enlace sea parte de un elemento de la lista.
        //     - Compruebe que el texto del enlace combinado con el texto del elemento de la lista adjunto describe el propósito del enlace.
        List<WebElement> uls = conexion.findElements(By.tagName("ul"));
        if(uls.size() != 0){
            for(WebElement ul : uls){
                List<WebElement> lis = ul.findElements(By.tagName("li"));
                if(lis.size() != 0){
                    for(WebElement li : lis){
                        String[] parts = li.getAttribute("innerHTML").split("<", 2);
                        if(parts.length > 1 && parts[0] != ""){
                            List<WebElement> as = li.findElements(By.tagName("a"));
                            if(as.size() != 0){
                                for(WebElement a : as){
                                    try {
                                        assertFalse(li.getAttribute("innerHTML").equals(""));
                                        assertFalse(a.getAttribute("innerHTML").equals(""));
                                        assertFalse(a.getAttribute("href").equals(""));
                                    } catch (Throwable t) {
                                        System.out.println(t);
                                    }
                                }
                            } else {
                                System.out.println("No se encontraron elementos con esta condicion.");
                            }
                        } else if(parts.length == 1){
                            List<WebElement> as = li.findElements(By.tagName("a"));
                            if(as.size() != 0){
                                for(WebElement a : as){
                                    try {
                                        assertFalse(a.getAttribute("innerHTML").equals(""));
                                        assertFalse(a.getAttribute("href").equals(""));
                                    } catch (Throwable t) {
                                        System.out.println(t);
                                    }
                                }
                            } else {
                                System.out.println("No se encontraron elementos con esta condicion.");
                            }
                        } else {
                            System.out.println("No se encontraron elementos con esta condicion.");
                        }
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, con la tecnica podemos preveer cierto patron que se debe cumplir para verificar la tecnica, sin embargo esto es insuficiente debido a que no podemos determinar
        //si el contenido que hay en li, combinado con el contenido dentro de a me describen el proposito del link, para ello hace falta el analisis humano.

    }
      

    // @Test
    // public void h78() {
    //     List<WebElement> ps = conexion.findElements(By.xpath("//p[a]"));
    //     if(ps.size() != 0){
    //         for(WebElement p : ps){
    //             WebElement a = p.findElement(By.tagName("a"));
    //             System.out.println(p.getAttribute("innerHTML"));
    //         }
    //     }
    // }

    // @Test
    // public void h79() {
    //     // Identificar el propósito de un enlace en una tabla de datos utilizando el texto del enlace combinado con la celda 
    //     // de la tabla adjunta y las celdas de encabezado de la tabla asociadas.
    //     // Para cada enlace del contenido que utiliza esta técnica:
    //     // - Compruebe que el enlace esté en una celda de la tabla.
    //     // - Compruebe que el texto del enlace combinado con el texto de las celdas del encabezado de la tabla asociada describe 
    //     //   el propósito del enlace.
        
    //     List<WebElement> table_elements = conexion.findElements(By.xpath("//table"));
    //     if(table_elements.size() != 0){
    //         for(WebElement table : table_elements) {
    //             List<WebElement> elements = table.findElements(By.xpath("//tr/td/a"));
    //             if(elements.size() > 1){
    //                 for(WebElement element : elements){
    //                     try {
    //                         assertFalse(element.getAttribute("href").equals(""));
    //                     } catch (Throwable t) {
    //                         System.out.println(t);
    //                     }
    //                 }
    //             } else {
    //                 System.out.println("No se encontraron elementos con esta condicion.");
    //             }
    //         }
    //     } else {
    //         System.out.println("No se encontraron elementos con esta condicion.");
    //     }
    // }

    // @Test
    // public void h80() {
    //     // Identificar el propósito de un enlace utilizando el texto del enlace combinado con el elemento de encabezado anterior
    //     // Para cada enlace del contenido que utiliza esta técnica:
    //     // - Encuentra el elemento de encabezado que precede al enlace
    //     // - Compruebe que el texto del enlace combinado con el texto de ese encabezado describe el propósito del enlace.
        
    //     List<WebElement> padres = conexion.findElements(By.xpath("//h2[a]|//h3[a]"));
    //     List<WebElement> hijos = conexion.findElements(By.xpath("//h2//a|//h3//a"));
    //     if(padres != null && hijos != null){
    //         for(int i=0; i<=padres.size(); i++){
    //             for(int j=0; j<=hijos.size(); j++){
    //                 try {
    //                     assertTrue(conexion.isComparable(padres.get(i).getText(), hijos.get(j).getText()));
    //                 } catch (Throwable t) {
    //                     System.out.println(t);
    //                 }
    //             }
    //         }
    //     }
    // }

    // @Test
    // public void h81() {
    //     // Identificar el propósito de un enlace en una lista anidada usando el texto del enlace combinado con el elemento de la lista principal bajo el cual se anida la lista
    //     // Para cada enlace del contenido que utiliza esta técnica:
    //     // - Encuentra el ulelemento u ol que contiene el enlace
    //     // - Compruebe que este elemento de la lista ( ul, ol) sea descendiente de un lielemento
    //     // - Compruebe que el texto del enlace combinado con el texto de ese elemento li describe el propósito del enlace.

    //     List<WebElement> padres = conexion.findElements(By.xpath("//li[ul[li[a]]]|//li[ol[li[a]]]"));
    //     List<WebElement> hijos = conexion.findElements(By.xpath("//li/ul/li[a]|//li/ol/li[a]"));
    //     if(padres != null && hijos != null){
    //         for(int i=0; i<=padres.size(); i++){
    //             for(int j=0; j<=hijos.size(); j++){
    //                 try {
    //                     assertTrue(conexion.isComparable(padres.get(i).getText(), hijos.get(j).getText()));
    //                 } catch (Throwable t) {
    //                     System.out.println(t);
    //                 }
    //             }
    //         }
    //     }
    // }

    @Test
    public void h83() {
        // Usar el atributo de destino para abrir una nueva ventana a solicitud del usuario e indicarlo en el texto del enlace
        // Procedimiento
        // - Active cada enlace en el documento para verificar si abre una nueva ventana.
        // - Para cada enlace que abra una nueva ventana, verifique que use el target atributo.
        // - Compruebe que el texto del enlace contiene información que indica que el enlace se abrirá en una nueva ventana.

        List<WebElement> aes = conexion.findElements(By.xpath("//a"));
        if(aes.size() != 0){
            for(WebElement a: aes) {
                if(a.getAttribute("target").equals("") == false){
                    try {
                        assertTrue(a.getAttribute("target").equals("_blank"));
                        assertFalse(a.getAttribute("innerHTML").equals(""));
                    } catch (Throwable t) {
                        System.out.println(t);
                    }
                } 
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente debido a que no podemos verificar si cada enlace del documento abre una nuva ventana.

    }

    @Test
    public void h84() {
        // Usar un botón con un elemento de selección para realizar una acción
        // Procedimiento
        // - Para cada select combinación de elemento / elemento de botón:
        //      - Verifique que el enfoque (incluido el enfoque del teclado) en una opción en el select elemento no resulte en ninguna acción
        //      - Compruebe que al seleccionar el botón se realiza la acción asociada con el select valor actual

        List<WebElement> forms = conexion.findElements(By.xpath("//form"));
        if(forms.size() != 0){
            for(WebElement form : forms) {
                List<WebElement> selects = form.findElements(By.tagName("select"));
                if(selects.size() != 0){
                    for(WebElement select : selects){
                        if(select.getAttribute("onchange") != null){
                            List<WebElement> options = select.findElements(By.tagName("option"));
                            if(options.size() != 0){
                                for(WebElement option : options){
                                    try {
                                        assertFalse(option.getAttribute("value").equals(""));
                                        assertFalse(option.getAttribute("innerHTML").equals(""));
                                    } catch (Throwable t) {
                                        System.out.println(t);
                                    }
                                }
                            }
                        } else {
                            WebElement button_input = form.findElement(By.xpath("//select/following-sibling::button|//select/following-sibling::input"));
                            if(button_input != null && button_input.getAttribute("type").equals("submit")){
                                List <WebElement> options = select.findElements(By.tagName("option"));
                                if(options.size() != 0){
                                    for(WebElement option : options){
                                        try {
                                            assertTrue(button_input.getAttribute("type").equals("submit"));
                                            assertFalse(option.getAttribute("innerHTML").equals(""));
                                        } catch (Throwable t) {
                                            System.out.println(t);
                                        }
                                }
                            }
                            } else {
                                System.out.println("No se encontraron button o input con type submit.");
                            }
                        }
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
            
        }
        
    }

    @Test
    public void h85() {
        // Uso de OPTGROUP para agrupar elementos OPTION dentro de un SELECT
        // Procedimiento
        // - Verifique el conjunto de opciones dentro de una lista de selección para ver si hay grupos de opciones relacionadas.
        // - Si hay grupos de opciones relacionadas, deben agruparse con optgroup.

        List<WebElement> forms = conexion.findElements(By.xpath("//form"));
        if(forms.size() != 0){
            for(WebElement form : forms) {
                List<WebElement> selects = form.findElements(By.tagName("select"));
                if(selects.size() != 0){
                    for(WebElement select: selects) {
                        List<WebElement> options = select.findElements(By.tagName("option"));
                        if(options.size() >= 6){
                            List<WebElement> optgroups = select.findElements(By.tagName("optgroup"));
                            if(optgroups.size() != 0){
                                for(WebElement optgroup : optgroups){
                                    if(optgroup.getAttribute("label") != null){
                                        try {
                                            assertFalse(optgroup.getAttribute("label").equals(""));
                                        } catch (Throwable t) {
                                            System.out.println(t);
                                        }
                                    } else {
                                        System.out.println("No se encontraron elementos optgroup con label.");
                                    }
                                }
                            } else {
                                System.out.println("No se encontraron elementos optgroup.");
                            }
                        } else {
                            System.out.println("No se necesita el elemento optgroup porque esta bien diseñado.");
                        }
                    }
                } else {
                    System.out.println("No se encontraron elementos con esta condicion.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos con esta condicion.");
        }
        //Condicion necesaria pero no suficiente, la tecnica esta diseñada para que siga un patron de diseño y si se cumple verificar que se este usando el elemento optgroup, el problema es que
        //la tecnica no verifica el conjunto de opciones dentro de una lista de selección para ver si hay grupos de opciones relacionadas, es por esto que necesita la intervencion de una persona

    }

    //H86: Proporcionar alternativas de texto para arte ASCII, emoticonos y leetspeak
    // Procedimiento
    // - Abra la página en un navegador común.
    // - Verifique que el contenido contenga arte ASCII, emoticonos y / o leetspeak.
    // - Verifique que haya una alternativa de texto inmediatamente antes o después de todo el arte ASCII, emoticonos y / o Leetspeak.

    //H88: uso de HTML de acuerdo con las especificaciones
    // Procedimiento
    // Para cada página HTML o XHTML:
    // - Verifique que la página use solo elementos, atributos y valores de atributo que están definidos en la especificación relevante.
    // - Verifique que los elementos, atributos y valores se utilicen de la manera prescrita por la especificación correspondiente.
    // - Compruebe que la página se pueda analizar correctamente, de acuerdo con las reglas de la especificación correspondiente.

    @Test
    public void h89() {
        // Uso del atributo de título para proporcionar ayuda contextual
        // Procedimiento:
        // - Identifique los controles de formulario que requieren entrada de texto.
        // - Verifique que cada control de formulario tenga una etiqueta asociada explícitamente
        // - Compruebe que cada control de formulario tenga ayuda contextual proporcionada en el titleatributo.

        List<WebElement> forms = conexion.findElements(By.xpath("//form"));
        if(forms.size() != 0){
            for(WebElement form: forms) {
                List<WebElement> inputs = form.findElements(By.xpath("//label/following-sibling::input"));
                if(inputs.size() != 0){
                    for(WebElement input : inputs){
                        if(input.getAttribute("title") != null){
                            try {
                                assertFalse(input.getAttribute("title").equals(""));
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        } else {
                            System.out.println("No se encontraron elementos input con atributo title.");
                        }
                    }
                } else {
                    System.out.println("No se encontraron elementos de tipo input que vengan luego de un label.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo form.");
        }
    }

    @Test
    public void h90() {
        // Indicación de los controles de formulario necesarios mediante etiqueta o leyenda
        // Procedimiento:
        // - Para cada control de formulario requerido, verifique que el estado requerido se indique en el control de formulario label o legend.
        // - Para cada indicador de estado requerido que no se proporciona en el texto, verifique que el significado del indicador se explique antes del control de formulario que lo usa.

        List<WebElement> forms = conexion.findElements(By.tagName("form"));
        if(forms.size() != 0){
            for(WebElement form: forms) {
                List<WebElement> legends = form.findElements(By.tagName("legend"));
                List<WebElement> labels = form.findElements(By.tagName("label"));
                List<WebElement> inputs = form.findElements(By.xpath("//label/following-sibling::input"));
                if(legends.size() != 0 && labels.size() != 0 && inputs.size() != 0){
                    for(WebElement legend : legends){
                        if(legend.getAttribute("innerHTML").contains("required")){
                            for(int i=0; i<labels.size(); i++){
                                for(int j=0; j<inputs.size(); j++){
                                    if(labels.get(i).getAttribute("for").equals(inputs.get(j).getAttribute("id"))){
                                        try {
                                            assertFalse(legend.getAttribute("innerHTML").equals(""));
                                            assertTrue(labels.get(i).getAttribute("for").equals(inputs.get(j).getAttribute("id")));
                                        } catch (Throwable t) {
                                            System.out.println(t);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if(legends.size() == 0 && labels.size() != 0 && inputs.size() != 0){
                    for(WebElement label : labels){
                        if(label.getAttribute("innerHTML").contains("required")){
                            for(WebElement input : inputs){
                                if(label.getAttribute("for").equals(input.getAttribute("id"))){
                                    try {
                                        assertFalse(label.getAttribute("innerHTML").equals(""));
                                        assertTrue(label.getAttribute("for").equals(input.getAttribute("id")));
                                    } catch (Throwable t) {
                                        System.out.println(t);
                                    }
                                } 
                            }
                        } 
                    }
                } else {
                    System.out.println("No se encontraron elementos de tipo legend o label dentro de un form.");
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo form.");
        } 
    }

    @Test
    public void h91() {
        // Uso de enlaces y controles de formulario HTML
        // Procedimiento:
        // - Inspeccione el código fuente HTML.
        // - Para cada instancia de enlaces y elementos de formulario, verifique que el nombre, el valor y el estado estén especificados como se indica en la tabla anterior.

        List<WebElement> links = conexion.findElements(By.xpath("//form/a"));
        List<WebElement> links_image = conexion.findElements(By.xpath("//form/a/img"));
        List<WebElement> buttons = conexion.findElements(By.xpath("//form/button"));
        List<WebElement> fieldsets = conexion.findElements(By.xpath("//form/fieldset/legend"));
        List<WebElement> inputs_button = conexion.findElements(By.xpath("//form/input[@type='button']|//form/input[@type='submit']|//form/input[@type='reset']"));
        List<WebElement> inputs_image = conexion.findElements(By.xpath("//form/input[@type='image']"));
        List<WebElement> inputs_text = conexion.findElements(By.xpath("//form/input[@type='text']"));
        List<WebElement> inputs_password = conexion.findElements(By.xpath("//form/input[@type='password']"));
        List<WebElement> inputs_file = conexion.findElements(By.xpath("//form/input[@type='file']"));
        List<WebElement> inputs_checkbox = conexion.findElements(By.xpath("//form/input[@type='checkbox']"));
        List<WebElement> inputs_radio = conexion.findElements(By.xpath("//form/input[@type='radio']"));
        List<WebElement> selects = conexion.findElements(By.xpath("//form/select"));
        List<WebElement> textareas = conexion.findElements(By.xpath("//form/textarea"));
        if(links.size() != 0){
            for(WebElement link: links) {
                try {
                    assertFalse(link.getAttribute("href").equals(""));
                    assertNotNull(link.getAttribute("innerHTML"));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo a.");
        }
        if(links_image.size() != 0){
            for(WebElement link: links_image) {
                try {
                    assertFalse(link.getAttribute("alt").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo img dentro de un a.");
        }
        if(buttons.size() != 0){
            for(WebElement button: buttons) {
                try {
                    if(button.getAttribute("title") != null){
                        assertFalse(button.getAttribute("title").equals(""));
                    } else {
                        assertFalse(button.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo button.");
        }
        if(fieldsets.size() != 0){
            for(WebElement fieldset: fieldsets) {
                try {
                    assertFalse(fieldset.getAttribute("innerHTML").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo fieldset.");
        }
        if(inputs_button.size() != 0){
            for(WebElement ibuttn: inputs_button) {
                try {
                    assertFalse(ibuttn.getAttribute("value").equals(""));
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input button.");
        }
        if(inputs_image.size() != 0){
            for(WebElement iimg: inputs_image) {
                try {
                    if(iimg.getAttribute("title") != null){
                        assertFalse(iimg.getAttribute("title").equals(""));
                    } else {
                        assertFalse(iimg.getAttribute("alt").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input img.");
        }
        if(inputs_text.size() != 0){
            for(WebElement itxt: inputs_text) {
                try {
                    if(itxt.getAttribute("title") != null){
                        assertFalse(itxt.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = itxt.findElement(By.xpath("//form/label[@for="+itxt.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input text.");
        }
        if(inputs_password.size() != 0){
            for(WebElement ipss: inputs_password) {
                try {
                    if(ipss.getAttribute("title") != null){
                        assertFalse(ipss.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = ipss.findElement(By.xpath("//form/label[@for="+ipss.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input password.");
        }
        if(inputs_file.size() != 0){
            for(WebElement ifile: inputs_file) {
                try {
                    if(ifile.getAttribute("title") != null){
                        assertFalse(ifile.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = ifile.findElement(By.xpath("//form/label[@for="+ifile.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input file.");
        }
        if(inputs_checkbox.size() != 0){
            for(WebElement icheck: inputs_checkbox) {
                try {
                    if(icheck.getAttribute("title") != null){
                        assertFalse(icheck.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = icheck.findElement(By.xpath("//form/label[@for="+icheck.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input checkbox.");
        }
        if(inputs_radio.size() != 0){
            for(WebElement iradio: inputs_radio) {
                try {
                    if(iradio.getAttribute("title") != null){
                        assertFalse(iradio.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = iradio.findElement(By.xpath("//form/label[@for="+iradio.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo input radio.");
        }
        if(selects.size() != 0){
            for(WebElement select: selects) {
                try {
                    if(select.getAttribute("title") != null){
                        assertFalse(select.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = select.findElement(By.xpath("//form/label[@for="+select.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo select.");
        }
        if(textareas.size() != 0){
            for(WebElement textarea: textareas) {
                try {
                    if(textarea.getAttribute("title") != null){
                        assertFalse(textarea.getAttribute("title").equals(""));
                    } else {
                        WebElement dad = textarea.findElement(By.xpath("//form/label[@for="+textarea.getAttribute("id")+"]"));
                        assertFalse(dad.getAttribute("innerHTML").equals(""));
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo textarea.");
        }
    }

    @Test
    public void h93(){
        // Asegurarse de que los id atributos sean únicos en una página web
        // Procedimiento
        // - Compruebe que todos los valores de los atributos de id sean únicos en la página web.

        List<WebElement> ids = conexion.findElements(By.xpath("//*[@id]"));
        boolean unicos = false;
        for(WebElement id : ids){
            for(WebElement id2 : ids){
                if(id.getAttribute("id").equals(id2.getAttribute("id"))){
                    unicos = true;
                } else {
                    unicos = false;
                }
            }
        }
        assertTrue(unicos);
    }

    // H94: Asegurarse de que los elementos no contengan atributos duplicados
    // Procedimiento
    // - Compruebe que ningún atributo aparece más de una vez en ningún elemento.

    @Test
    public void h95(){
        // Uso del elemento de seguimiento para proporcionar subtítulos
        // Procedimiento
        // Para cada video elemento utilizado para reproducir un video:
        // - Verifique que el video contenga un track elemento de kind subtítulos en el idioma del video.

        List<WebElement> videos = conexion.findElements(By.xpath("//video"));
        if(videos.size() != 0){
            for(WebElement video : videos){
                WebElement track = video.findElement(By.tagName("track"));
                try{
                    assertTrue(track.getAttribute("kind").equals("captions"));
                    assertFalse(track.getAttribute("srclang").equals(""));
                } catch(Throwable t){
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo video.");
        }
    }

    @Test
    public void h96(){
        // Uso del elemento de pista para proporcionar descripciones de audio
        // Procedimiento
        // Para cada video elemento utilizado para reproducir un video:
        // - Verifique que el video contenga un track elemento de kind descripciones en el idioma del video.

        List<WebElement> videos = conexion.findElements(By.xpath("//video"));
        if(videos.size() != 0){
            for(WebElement video : videos){
                WebElement track = video.findElement(By.tagName("track"));
                try{
                    assertTrue(track.getAttribute("kind").equals("descriptions"));
                    assertFalse(track.getAttribute("srclang").equals(""));
                } catch(Throwable t){
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo video.");
        }
    }

    @Test
    public void h97(){
        // Agrupacion de enlaces relacionados mediante el elemento de navegación
        // Procedimiento
        // Compruebe que los enlaces que están agrupados visualmente y representan una sección de la página están incluidos en un nav elemento.

        List<WebElement> navs = conexion.findElements(By.xpath("//nav"));
        if(navs.size() != 0){
            for(WebElement nav : navs){
                if(nav.getAttribute("aria-label") != ""){
                    try{
                        assertFalse(nav.getAttribute("aria-label").equals(""));
                    } catch(Throwable t){
                        System.out.println(t);
                    }
                } else {
                    List<WebElement> as = nav.findElements(By.tagName("a"));
                    if(as.size() >= 3){
                        for(WebElement a : as){
                            try{
                                assertFalse(a.getAttribute("href").equals(""));
                            } catch(Throwable t){
                                System.out.println(t);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontraron elementos de tipo nav.");
        }
        //Condicion necesaria pero no suficiente, debido a que no podemos comprobar que los enlaces que estan agrupados visualmente y representan una seccion sean los que se encuentran dentro del nav
    }

    
    
    @Test
    public void c6() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C6.html
    	//C6: posicionamiento de contenido basado en marcado estructural
    	/*Procedimiento
    	  Para contenido que usa CSS para posicionamiento
		  - Elimine la informaci�n de estilo del documento o desactive el uso de hojas de estilo en el agente de usuario.
		  - Compruebe que se conservan las relaciones estructurales y el significado del contenido.*/
    	//No existen t�cnicas disponibles para est� t�cnica.
    	//Reemplazar imagenes de espaciador por el uso de Margin y Padding
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c7() {
    	List <WebElement> links = conexion.findElements(By.tagName("a"));
    	if(links.size() != 0) {
    		for(WebElement link : links) {
    			List <WebElement> as = link.findElements(By.xpath("//*"));
    			if(as.size() !=0) {
    				for(WebElement a : as) {
    					if(a.getCssValue("display").equals("none")) {
    						assertTrue(a.getCssValue("display").equals("none"));
    					} else if(a.getCssValue("visibility").equals("hidden")) {
    						assertTrue(a.getCssValue("visibility").equals("hidden"));
    					} else {
    						System.out.println("Ninguno de los elementos dentro de la etiqueta a cumplen con la condicion none o hidden");
    					}
    				}
    			} else {
    				System.out.println("No hay elementos dentro de la etiqueta a");
    			}
    		}
    	} else {
    		System.out.println("No se encontraron elementos de tipo a");
    	}
    	
    }
    //Tecnica necesaria pero no suficiente, porque no podemos corroborar que el texto describa el proposito del link, hace falta la intervencion humana.

    @Test
    public void c8() {
    	List <WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	if(elementos.size() != 0) {
    		for(WebElement elemento : elementos){
    			if(elemento.getCssValue("letter-spacing").equals("") == false) {
    				assertFalse(elemento.getCssValue("letter-spacing").equals(""));
    			} else {
    				System.out.println("No posee el atributo letter-spacing");
    			}
    		}
    	}
    }
    
    @Test
    public void c12() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C12.html
    	//El objetivo de est� tecnica es que la fuente se adapate a la escala correspondiente (Responsividad).
    	//Comprobar que cada valor de la propieadad Font-Size de CSS est� expresado en %
    	//El metodo chequea que cada propiedad Font-Size contenga el simbolo %
    	//Que el resultado sea false no garantiza que no se haya tenido en cuenta la escala, solo que no se utiliz� est� tecnica correctamente y no se puete utilizar para reclamar conformidad.
    	
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			try {
    				assertTrue(elemento.getCssValue("font-size").contains("%"));
    			} catch (Throwable t) {
    				System.out.println(t);
    			}
    		}
    	}
    }
    
    @Test
    public void c13() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C13.html
    	//El objetivo de esta t�cnica es especificar un tama�o de fuente con nombre que exprese el tama�o de fuente relativo deseado.
    	//Comprobar que cada valor de la propieadad Font-Size de CSS contenga al menos uno de los siguientes valores: xx-small, xx-small, x-small, small, medium, large, x-large, xx-large, xsmaller, or larger.
    	//El metodo chequea que cada propiedad Font-Size contenga al menos uno de los valores mencionados.
    	//Que el resultado sea false no garantiza que no se haya tenido en cuenta el �xito del criterio, solo que no se utiliz� est� tecnica y no se puede utilizar para reclamar conformidad.
    	
    	String[] fontsizes = {"xx-small", "xx-small", "x-small", "small", "medium", "large", "x-large", "xx-large", "xsmaller", "larger"};
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {    		
    				for(String fontsize : fontsizes) {
    					if (elemento.getCssValue("font-size").contains(fontsize)) {
        					try {
            					assertTrue(elemento.getCssValue("font-size").contains(fontsize));
            					} catch(Throwable t) {
            						System.out.println(t);
            					}
    					}
    			}
    		}
    	}
    }
    
    @Test
    public void c14() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C14.html
    	//El objetivo de est� tecnica es que la fuente se adapate a la escala correspondiente (Responsividad).
    	//Comprobar que cada valor de la propieadad Font-Size de CSS est� expresado en "em"
    	//El metodo chequea que cada propiedad Font-Size contenga el simbolo "em"
    	//Que el resultado sea false no garantiza que no se haya tenido en cuenta la escala, solo que no se utiliz� est� tecnica correctamente y no se puete utilizar para reclamar conformidad.
    	
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			try {
    				assertTrue(elemento.getCssValue("font-size").contains("em"));
    			} catch (Throwable t) {
    				System.out.println(t);
    			}
    		}
    	}
    }
    
    
    @Test
    public void c15(){
    	//https://www.w3.org/TR/WCAG20-TECHS/C15.html
    	//El objetivo de est� t�cnica es proporcionar informaci�n cuando un elemento sea interactivo utilizando CSS.
    	//Que un :hover o un tab tenga un focus
    	//No pude comprobar que elementos tiene un :hover
    	/*if (driver instanceof JavascriptExecutor) {
    			    ((JavascriptExecutor)driver).executeScript("yourScript();");
    			} else {
    			    throw new IllegalStateException("This driver does not support JavaScript!");
    			}*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//style"));
    	boolean isFocus;
    	boolean isHover;
    	if (elementos.size() != 0) {
    		for (WebElement elemento : elementos) {
    			isFocus = elemento.getAttribute("innerHTML").contains(":focus");
    			isHover = elemento.getAttribute("innerHTML").contains(":hover");
    			if(isFocus && isHover) {
    				try {
        				assertTrue(isFocus);
        				System.out.println("Se cumplio!");
        			} catch (Throwable t) {
        				System.out.println(t);
        			}
    			} else {
    				System.out.println("No se cumplio!");
    			}
    		}
    	} else {
    		System.out.println("No hay elementos");
    	}
    }
    //Si no se cumple no es posible afirmar que no se este cumpliendo la tecnica, es necesaria la intervencion de una persona.
    
    @Test
    public void c17() {
    	//C17: Scaling form elements which contain text
    	//Procedure
    	//Enter some text into text-based form controls that receive user entered text.
    	//Increase the text size of the content by 200%.
    	//Check that the text in text-based form controls has increased by 200%.
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	String[] values = {"px", "ex", "em"};
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			System.out.println(elemento.getCssValue("font-size"));
    			for(int i=0; i<values.length; i++) {
    				if(elemento.getCssValue("font-size").contains(values[i])) {
    					try {
            				assertTrue(elemento.getCssValue("font-size").contains(values[i]));
            				System.out.println("Se cumplio font size");
            			} catch (Throwable t) {
            				System.out.println(t);
            			}
    				} else if(elemento.getCssValue("margin").contains(values[i])) {
    					try {
            				assertTrue(elemento.getCssValue("margin").contains(values[i]));
            				System.out.println("Se cumplio margin");
            			} catch (Throwable t) {
            				System.out.println(t);
            			}
    				}
    			}
    		}
    	}
    }
    //Tecnica a revisar / confirmar
    //Para desarrollar esta tecnica nos basamos en https://uniwebsidad.com/libros/css/capitulo-3/unidades-de-medida#:~:text=La%20unidad%20em%20hace%20referencia,puede%20aproximar%20por%200.5%20em%20.&text=La%20regla%20CSS%20anterior%20indica,de%20anchura%20igual%20a%201em%20.
    
    @Test
    public void c18() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C18.html
    	//No existen t�cnicas disponibles para est� t�cnica.
    	//Reemplazar imagenes de espaciador por el uso de Margin y Padding
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c19() {
    	/*
    	https://www.w3.org/TR/WCAG20-TECHS/C19.html
    	C19: Specifying alignment either to the left OR right in CSS
    	Procedure
		- Check that the text is aligned either left or right.
    	*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	boolean condition = true;
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			if(elemento.getCssValue("text-align").contains("left")) {
    				try {
        				assertTrue(elemento.getCssValue("text-align").contains("left"));
        				System.out.println("Se cumplio");
        			} catch (Throwable t) {
        				System.out.println(t);
        			}
    			} else if(elemento.getCssValue("text-align").contains("right")) {
    				try {
        				assertTrue(elemento.getCssValue("text-align").contains("right"));
        				System.out.println("Se cumplio");
        			} catch (Throwable t) {
        				System.out.println(t);
        			}
    			} else {
    				condition = false;
    			}
    			
    		}
    		if(condition == false) {
    			System.out.println("La propiedad text-align no posee el valor left o right");
    		}
    	}
    }
    
    @Test
    public void c20() {
    	/*
    	 https://www.w3.org/TR/WCAG20-TECHS/C20.html
    	 C20: Uso de medidas relativas para establecer anchos de columna de modo que las l�neas puedan promediar 80 caracteres o menos cuando se cambia el tama�o del navegador
    	 Procedimiento
		 - Pruebe para ver que las columnas est�n definidas en unidades relativas.
		 - Compruebe que la longitud de la l�nea se puede establecer en 80 caracteres o menos cambiando el tama�o de la ventana del navegador.*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*/p | //p"));
    	if(elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			if(elemento.getCssValue("column-width").contains("px")) {
    				String[] parts = elemento.getCssValue("column-width").split("p");
    				Integer value = Integer.parseInt(parts[0]);
    				if(value >= 140) {
    					try {
            				assertTrue(elemento.getCssValue("column-width").contains("px"));
            				System.out.println("Se cumplio");
            			} catch (Throwable t) {
            				System.out.println(t);
            			}
    				}
    			} else if(elemento.getCssValue("column-width").contains("ex")) {
    				String[] parts = elemento.getCssValue("column-width").split("e");
    				Integer value = Integer.parseInt(parts[0]);
    				if(value >= 20) {
    					try {
            				assertTrue(elemento.getCssValue("column-width").contains("ex"));
            				System.out.println("Se cumplio");
            			} catch (Throwable t) {
            				System.out.println(t);
            			}
    				}
    			} else if(elemento.getCssValue("column-width").contains("em")) {
    				String[] parts = elemento.getCssValue("column-width").split("e");
    				Integer value = Integer.parseInt(parts[0]);
    				if(value >= 10) {
    					try {
            				assertTrue(elemento.getCssValue("column-width").contains("em"));
            				System.out.println("Se cumplio");
            			} catch (Throwable t) {
            				System.out.println(t);
            			}
    				}
    			} else {
    				System.out.println("No posee atributo column-width");
    			}
    		}
    	}
    }
     
    @Test
    public void c21() {
    	/*
    	 https://www.w3.org/TR/WCAG20-TECHS/C21.html
    	 C21: Especificar el espaciado de l�nea en CSS
    	 Procedimiento
		 - Abra contenido en un navegador.
		 - Compruebe que el espacio entre l�neas en bloques de texto est� entre 1,5 y 2.*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*/p | //p"));
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			if(elemento.getCssValue("line-height").contains("px")) {
    				String[] parts = elemento.getCssValue("line-height").split("p");
    				Integer value = Integer.parseInt(parts[0]);
    				if(value >=24 || value <=32) {
    					try {
    	    				assertTrue(elemento.getCssValue("line-height").contains("px"));
    	    				System.out.println("Se cumplio");
    	    			} catch (Throwable t) {
    	    				System.out.println(t);
    	    			}
    				} else {
    					System.out.println("Tama�o no recomendado");
    				}
    			} else {
    				System.out.println("Medida relativa no aceptada");
    			}
    		}
    	}
    }
    
    @Test
    public void c22() {
    	/*
    	 https://www.w3.org/TR/WCAG20-TECHS/C22.html
    	 C22: Uso de CSS para controlar la presentaci�n visual de texto
    	 Las siguientes propiedades de CSS son �tiles para dise�ar texto y evitar la necesidad de texto en im�genes:
		 - La font-family propiedad se utiliza para mostrar el aspecto del c�digo en una familia de fuentes monoespaciada.
		 - La text-align propiedad se utiliza para mostrar el texto a la derecha de la ventana gr�fica.
		 - La font-size propiedad se utiliza para mostrar el texto en un tama�o mayor.
		 - La font-style propiedad se utiliza para mostrar texto en cursiva.
		 - La font-weight propiedad se utiliza para establecer c�mo se deben mostrar los caracteres delgados o gruesos en el texto.
		 - La color propiedad se utiliza para mostrar el color de texto o contenedores de texto.
		 - La line-height propiedad se utiliza para mostrar la altura de la l�nea de un bloque de texto.
		 - La text-transform propiedad se usa para controlar el caso de las letras en el texto.
		 - La letter-spacing propiedad se utiliza para controlar el espaciado de las letras en el texto.
		 - La background-image propiedad se puede utilizar para mostrar texto sobre un fondo que no sea texto.
		 - La first-line pseudoclase se puede utilizar para modificar la presentaci�n de la primera l�nea en un bloque de texto.
		 - La :first-letter pseudoclase se puede utilizar para modificar la presentaci�n de la primera letra en un bloque de texto.
		 - Las pseudoclases :beforey :after se pueden utilizar para insertar contenido decorativo que no sea texto antes o despu�s de los bloques de texto.
    	 */
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*/p | //*/h1 | //h1 | "
    			+ "//*/h2 | //h2 | //*/h3 | //h3 | //*/h4 | //h4 | //*/h5 | //h5 | //*/h6 | "
    			+ "//h6 | //p | //*/strong | //strong | //*/em | //em | //*/mark | //mark | "
    			+ "//*/i | //i | //*/b | //b | //*/u | //u | //*/s | //s |  //*/span | //span | "
    			+ "//*/cite | //cite | //*/div | //div | //*/code | //code"));
    	String[] property = {"font-family", "text-align", "font-size", "font-style", "font-weight",
    			"color", "line-height", "text-transform", "letter-spacing", "background-image"};
    	boolean[] complete = new boolean[property.length];
    	if(elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			for(int i=0; i<property.length; i++) {
    				if(elemento.getCssValue(property[i]).contains("monospace") || elemento.getCssValue("line-height").contains("right") || elemento.getCssValue("line-height").contains("em") || elemento.getCssValue("line-height").contains("italic") || elemento.getCssValue("line-height").contains("url") || elemento.getCssValue("line-height").isBlank() == false) {
    					complete[i] = true;
    					System.out.println("Se cumple");
    				} else {
    					System.out.println("Elemento sin ninguna de las propiedades");
    				}
    			}
    		}
    		try {
				assertTrue(complete.length == 10);
				System.out.println("Se cumplio");
			} catch (Throwable t) {
				System.out.println(t);
			}
    	}
    }
    
    @Test
    public void c23() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C23.html
    	//C23: especificar el texto y los colores de fondo del contenido secundario, como los banners, las funciones y la navegaci�n en CSS, sin especificar el texto y los colores de fondo del contenido principal
    	//Con las herramientas que contamos, comprobar que el switcheo de una planilla de estilo alternativa, 
    	//que siendo distinta pero con las mismas funcionalidades de la planilla de estilo original no se puede evaluar
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c24() {
    	/*
    	 https://www.w3.org/TR/WCAG20-TECHS/C23.html
    	 C24: uso de valores porcentuales en CSS para tama�os de contenedor
    	 Procedimiento:
		 - Verifique que todos los anchos de los contenedores est�n especificados como valores porcentuales.
		 - Aumente el tama�o del texto al 200%.
		 - Verifique para asegurarse de que no se requiera el desplazamiento horizontal para leer ninguna l�nea de texto.
		 - Compruebe que todo el texto todav�a est� visible en la p�gina.*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//div | //*/div | //span | //*/span"));
    	if(elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			try {
    				assertTrue(elemento.getCssValue("width").contains("px"));
    				System.out.println("Se cumplio");
    			} catch (Throwable t) {
    				System.out.println(t);
    			}
    		}
    	}
    }
    //Tecnica necesaria pero no sufiente, ya que para comprobar el punto 2, 3 y 4 es necesaria otra herramienta 
    
    @Test
    public void c25() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C25.html
    	//C25: especificar bordes y dise�o en CSS para delinear �reas de una p�gina web sin especificar texto y colores de fondo de texto
    	//Procedimiento
    	//- Abra la p�gina web en un navegador que permita a los usuarios cambiar los colores del contenido HTML.
    	//- Cambie el texto, el enlace y los colores de fondo en la configuraci�n del navegador para que sean diferentes a los que se establecen actualmente en el navegador.
    	//- Regrese a la p�gina y verifique que est� mostrando la p�gina con el nuevo texto, enlace y colores de fondo
    	//- Compruebe que todav�a se muestran los bordes y que se conserva el dise�o.
    	//Con las herramientas que contamos, comprobar que el switcheo de una planilla de estilo alternativa, 
    	//que siendo distinta pero con las mismas funcionalidades de la planilla de estilo original no se puede evaluar
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c27() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C27.html
    	//C27: Hacer que el orden DOM coincida con el orden visual
    	//Procedimiento
    	//- Examine visualmente el orden del contenido en la p�gina web tal como se presenta al usuario final.
    	//- Examine los elementos del DOM usando una herramienta que le permite ver el DOM.
		//- Aseg�rese de que el orden del contenido en las secciones del c�digo fuente coincida con la presentaci�n visual del contenido en la p�gina web. (p. ej., para una p�gina en ingl�s, el orden es de arriba a abajo y de izquierda a derecha) 
    	//Con las herramientas que contamos, comprobar que el switcheo de una planilla de estilo alternativa, 
    	//que siendo distinta pero con las mismas funcionalidades de la planilla de estilo original no se puede evaluar
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c28() {
    	/*
    	 C28: Especificaci�n del tama�o de los contenedores de texto mediante unidades em
    	 Procedimiento
		 - Identifica contenedores que contienen texto o permiten la entrada de texto.
		 - Verifique que el ancho y / o alto del contenedor est�n especificados en emunidades.*/
    	List<WebElement> elementos = conexion.findElements(By.xpath("//*"));
    	if (elementos.size() != 0) {
    		for(WebElement elemento : elementos) {
    			if(elemento.getCssValue("width").contains("em")) {
    				try {
        				assertTrue(elemento.getCssValue("width").contains("em"));
        				System.out.println("Se cumplio");
        			} catch (Throwable t) {
        				System.out.println(t);
        			}
    			} else if(elemento.getCssValue("height").contains("em")) {
    				try {
        				assertTrue(elemento.getCssValue("height").contains("em"));
        				System.out.println("Se cumplio");
        			} catch (Throwable t) {
        				System.out.println(t);
        			}
    			}
    		}
    	}
    }
    
    @Test
    public void c29() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C29.html
    	//Con las herramientas que contamos, comprobar que el switcheo de una planilla de estilo alternativa, 
    	//que siendo distinta pero con las mismas funcionalidades de la planilla de estilo original no se puede evaluar
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @Test
    public void c30() {
    	//https://www.w3.org/TR/WCAG20-TECHS/C30.html
    	//Identificar que exista una presentacion alternativa que pueda 
    	//seleccionar un usuario y analizar si esta alternativa posee imagenes del texto se hace imposible de evaluar con las herramientas que poseemos
    	System.out.println("Est� t�cnica debe ser comprobada manualmente");
    }
    
    @AfterAll
    public void tearDown() {

        conexion.close();

    }

}