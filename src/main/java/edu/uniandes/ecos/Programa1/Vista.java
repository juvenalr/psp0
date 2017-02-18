package edu.uniandes.ecos.Programa1;

import java.util.ArrayList;
/**
 * Clase que muestra los diferentes menu de opciones y resultados
 * 
  */
public class Vista {

	public Vista()
	{}

	/**
	 * Muestra en la consola los calculos de la media y desviacion estandart
	 * 
	 * @param media, desviacion estandart
	 * 
	 */
public void MostrarMediayDesvEstandart(Double media, Double desvStatand)
 {
	System.out.println("Media: " + String.valueOf(media));
	System.out.println("desvStatand: " + String.valueOf(desvStatand));
 }

/**
 * Muestra el titulo y los valores de un conjunto de datos
 * 
 * @param titulo conjunto datos, lista valores conjunto datos
 * 
 */
public void MostrarConjuntodeDatos(String titulo, ArrayList<String> valores)
{
	String datos="";
	int p=1;
	
	for( String s : valores )
	{
		
		if (p==1)
		{
		datos= s;
		}
		
		else
		{
			datos= datos + "," + s;
		}
		p+=1;
	}
	
	
	System.out.println("Conjunto de Datos: " + titulo);
	System.out.println("                "+datos);
	
	
}
/**
 * Genera el Menu de Opciones de los procesos que se pueden aplicar al conjunto de datos actual
 *@param titulo conjunto de datos
 */
public void generarMenuProceso(String titulo)
{
		
	System.out.println("Digite Una De las Opciones del Menú Para Realizar Un Proceso Sobre El Conjunto de Datos: " +  titulo);
	System.out.println("(1) Calcular las Estadíticas del Conjunto de Datos");
	System.out.println("(2) Editar El Conjunto de Datos");
	System.out.println("(V) Volver Al Menú de Selección de Conjunto de Datos");
	
	
	
}
/**
 * Genera el Menu de opcines para seleccionar un conjunto de datso
 * @param lista de los titulos de los conjuntos de datos 
 */
public void generarMenuSelConjuntoDatos(ArrayList<String> titulos)
{
		
	System.out.println("Seleccione Un Conjunto de Datos Digitando La Opción Correpondiente" );
	int p=1;
	for( String s : titulos )
	{
		System.out.println("(" + String.valueOf(p)+")" + " " + s);
		p+=1;
	}
	
	System.out.println("(S) Salir");
		
}
/**
 * Genera el Menu de opciones para la edicion de datos
 * @param titulo del conjunro de datos
 */
public void generarMenuEditarDato( String titulo)
{
		
	System.out.println("Digite Una de las Opciones del Menú Para Realizar la Edición del Conjunto de Datos: " + titulo );
	System.out.println("(1) Adicionar un Nuevo Dato Al Conjunto de Datos");
	System.out.println("(2) Eliminar un Dato del Conjunto de Datos");
	System.out.println("(V) Volver Al Menú de Procesos");
		
}
/**
 * Genera el Menu de opciones para selccionar un dato y eleiminarlos
 * @param  titulo conjunto datos, lista valores conjunto datos
 */
public void generarMenuElimiEditarDato(String titulo, ArrayList<String> valores)
{
		
	System.out.println("Seleccione el Dato A Eliminar Digitando el Identificador del Dato (ID)" );
	System.out.println("              Conjunto de Datos: " +titulo);
	int p=1;
	for( String s : valores )
	{
		System.out.println("(" + String.valueOf(p)+")" + " " + s);
		p+=1;
	}
	
	System.out.println("(V) Volver Al Menú de Edición");	
}

/**
 * Genera el Menu de opciones para cargar el archivo con los datos
 * 
 */
public void generarMenuCargarArchivo()
{
	System.out.println("Benevenido al Porgrama1 PSP0 Calculo de Stadisticas");
	System.out.println("Por Favor Ingrese la Ruta del Archivo que Contiene los Datos o Digite S para salir");
		
	
}
}

