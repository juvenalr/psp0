package edu.uniandes.ecos.Programa1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Clase principal que se utiliza para la interaccion con el usuario
 * 
  */


public class Controlador 
{
	
public AdminDatos cModelo;
public Vista cVista;

public Controlador()
{
 cModelo = new AdminDatos();
 cVista= new Vista();
}
/**
 * Permite leer una linea entrada en la Consola de comandos
 * 
  */
public String leerLineaConsola()
{ String line = null;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	try {
		line = reader.readLine();
		} catch (IOException e) {
	}
	return line;
}

/**
 * Carga el archivo de datos para ser almacenado como conjuntos de datos
 * 
  */
public void cargarArchivo()
{
	cVista.generarMenuCargarArchivo();
	String val= leerLineaConsola();
	
	if (val != null )
	{
		if(val.toLowerCase().equals("s"))
			
		{
			
			System.exit(0) ;
		}
		else if (cModelo.readFile(val))
		{MostrarValoresCargados();
			
		 MenuSelConjuntoDatos();
		}
		else
		{
			cargarArchivo();
		}
		
		
	}
}

/**
 * Captura la selecion del conjunto de datros realizada por el usuario
 * 
  */
public void MenuSelConjuntoDatos()
{
	cVista.generarMenuSelConjuntoDatos(cModelo.getTitulosConjuntoDatos());
	
	String val=leerLineaConsola();
	if(val.toLowerCase().equals("s"))		
	{
		System.exit(0);
	}
	
	else if ( esEntero(val))
		
	{
		int valor= Integer.parseInt(val);
		if (cModelo.selecionarConjuntoDatos(valor))
		{menuProcesos();}
		else
		{
			MenuSelConjuntoDatos();
		}
		
	}
	else
	{
		MenuSelConjuntoDatos();
	}
}

/**
 * Captura la selecion del proceso que se relizara sobre el conjunto de datos que selecciono el usuario
 * 
  */
public void menuProcesos()
{
 cVista.generarMenuProceso(cModelo.getActSelConjuntoDatos().getTitulo());
 String val=leerLineaConsola();
 if(val.toLowerCase().equals("v"))		
	{
	 MenuSelConjuntoDatos();
	}
	
	else if ( esEntero(val))
	{
		int valor= Integer.parseInt(val);
		switch (valor)
		{
		case 1:
			
			Double media = cModelo.calcMedActSelConjuntoDatos();
			Double dS= cModelo.calcDevStanActSelConjuntoDatos(media);
			cVista.MostrarMediayDesvEstandart(media, dS);
			menuProcesos();
			break;
		case 2:
			menuEditar();
			break;
		default:
			menuProcesos();
			break;
		}
	}
	else
	{
		
		menuProcesos();
	}
}

/**
 * Captura la selecion del tipo de edicion que el usuario realizara sobre el conjunto de datos selecionado
 * 
  */
public void menuEditar()

{
	 cVista.generarMenuEditarDato(cModelo.getActSelConjuntoDatos().getTitulo());
	 String val=leerLineaConsola();
	 if(val.toLowerCase().equals("v"))		
		{
		 menuProcesos();
		}
		
		else if ( esEntero(val))
		{
			int valor= Integer.parseInt(val);
			
			switch (valor)
			{
			case 1:
				System.out.println("Ingrese el Nuevo Valor");
		       String addval= leerLineaConsola();
		       if (esNumero(addval))
		       {
		    	   cModelo.getActSelConjuntoDatos().addDato(Double.parseDouble(addval));
		    	   cVista.MostrarConjuntodeDatos(cModelo.getActSelConjuntoDatos().getTitulo(),cModelo.getActSelConjuntoDatos().getListaValores());
		    	   menuEditar();
		       }
		       else
		       {
		    	   System.out.println("El Valor NO Es Un Numero Real");
		    	   menuEditar();
		       }
		       break;
			case 2:
				menuEliminarDato();
				break;
			default:
				menuEditar();
				break;
			}
		}
		else
		{
			
			menuEditar();
		}
	}
/**
 * Captura la selecion del elemento que se eliminara del conjunto de datos selcionado por el ususario
 * 
  */
public void menuEliminarDato()
{
cVista.generarMenuElimiEditarDato(cModelo.getActSelConjuntoDatos().getTitulo(), cModelo.getActSelConjuntoDatos().getListaValores());
String val=leerLineaConsola();
if(val.toLowerCase().equals("v"))		
	{
	menuEditar();
	}
	
	else if ( esEntero(val))
	{
		int valor= Integer.parseInt(val);
		
		if(cModelo.delDatoActSelConjuntoDatos(valor))
		{
			System.out.println("Eliminado Dato: (" + valor +") " );
			cVista.MostrarConjuntodeDatos(cModelo.getActSelConjuntoDatos().getTitulo(),cModelo.getActSelConjuntoDatos().getListaValores());
			menuEditar();
		}
		else
		{
			menuEliminarDato();
		}
	}
	else
	{
		menuEliminarDato();
		
	}
}
/**
 *Muestra en pantalla los valores de los conjuntos de datos cargados

 */
 public void MostrarValoresCargados()
{
	for (int p =0 ;p<cModelo.getListaConjuntoDatos().size();p++)
	{	
	cVista.MostrarConjuntodeDatos(cModelo.getListaConjuntoDatos().get(p).getTitulo(), cModelo.getListaConjuntoDatos().get(p).getListaValores());
	}
}
 /**
  * define si un valor en formato texto correponde a un numero entero
  * @return boleano 
   */
public boolean esEntero(String val)
{
	

	try {
		Integer.parseInt(val);

	return true;
		}
	catch(NumberFormatException ex)
	{
		return false;
	}
	
	
}
/**
 * define si un valor en formato texto correponde a un numero 
 * @return boleano 
  */
public boolean esNumero(String val)
{
		

	try {
		Double.parseDouble(val);

	return true;
		}
	catch(NumberFormatException ex)
	{
		return false;
	}
	
	
}
/**
 * funcion principal
 
  */

static public void main(String args[])
{
 Controlador aplicacion = new Controlador();
 aplicacion.cargarArchivo();
 
}
}





