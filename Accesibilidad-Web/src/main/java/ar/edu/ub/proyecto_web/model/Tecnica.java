package ar.edu.ub.proyecto_web.model;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Tecnica {
	
	private String codigo; //H1
	private String descripcion; //...
	private ResultadoTecnica resultado;
	private WebDriver driver;
	
	public Tecnica(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public void ejecutar(String url, HelpersConnection conexion) {
		//selenium verrr TestResult
//		this.resultado = ResultadoTecnica.OK;
//		this.resultado = this.h2();
		conexion.getInstancia("https://output.jsbin.com/likewak");
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
//                        assertFalse(image.getAttribute("alt").equals(""));
                    	return ResultadoTecnica.OK;
                    	
                    }else {
//                        assertNull(image.getAttribute("alt"));
                    	return ResultadoTecnica.FAIL;
                    }
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
//            System.out.println("No se encontraron elementos con esta condicion.");
        	return ResultadoTecnica.FAIL;
        }
		return ResultadoTecnica.FAIL;

    }

    public ResultadoTecnica h4(HelpersConnection conexion) {
        //Crear un orden de tabulación lógico a través de enlaces, controles de formulario y objetos
        // Procedimiento
        // Compruebe si tabindex se utiliza
        // Si tabindex se utiliza, compruebe que el orden de tabulación especificado por los tabindex atributos sigue las relaciones en el contenido.
    	
    	boolean result = true;
        List<WebElement> indexs = conexion.findElements(By.xpath("//*[@tabindex]"));
        if(indexs.size() != 0){
            for(WebElement index : indexs){
                try{
//                    assertFalse(index.getAttribute("tabindex").equals(""));
                	if (index.getAttribute("tabindex").equals("")) {
                	result = false;	
                	} else {
                	}
                	
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        } else {
//            System.out.println("No se encontraron elementos con esta condicion.");
            return ResultadoTecnica.FAIL;
        }   
        if (result == true) {
        	return ResultadoTecnica.OK;
        } else {
        	return ResultadoTecnica.FAIL;
        }
        //Se me ocurrio hacerlo asi porque si bien nos pide que halla una correlacion entre los valos de tabindex, estos pueden ser distintos o iguales,
        //si son iguales es posible verificar eso, pero si son distintos necesitaremos de una persona para saber si hay relacion entre dichos valores
        //por eso use un assertFalse indicando igual a vacio, porque ya nos alcanza que tenga un valor en el tabindex, sera condicion necesaria pero no suficiente

    }
	
}
