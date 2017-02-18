package edu.uniandes.ecos.Programa1;


import java.util.ArrayList;

/**
* Clase que reprenta a la lista vinculada de datos
*

*/
public class ConjuntoDatos {
	
	  /**
     * Nodo raiz de la lista
     */
	private Dato root;
	 /**
     * Titulo del conjunto de datos
     */
	private String titulo;
	
	public ConjuntoDatos() {
		this.root=null;
	}

	/**
     * Retorna el nodo raiz de la lista
     * @return valor
     */
	public Dato getRoot() {
		return root;
	}
	
	/**
     * Asigna el nodo raiz de la lista
     * @param root
     */

	public void setRoot(Dato root) {
		this.root = root;
	}

	/**
     * Retorna el titulo del conjunto de datos
     * @return titulo
     */
	public String getTitulo() {
		return titulo;
	}

	/**
     * Asigna el titulo al conjunto de datos
     * @param root
     */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
     * adiciona un nuevo dato a  la lista 
     * @param valor
     */
	
	public void addDato(Double valor)
	{
		
		Dato datoNuevo= new Dato();
		datoNuevo.setValor(valor);
		datoNuevo.setNextDato(null);
		if (this.getRoot() == null)
		{
			this.setRoot(datoNuevo);
		}
		
		
		else
		{
			Dato actDato = getRoot();
			while (actDato.getNextDato() != null)
			{
				actDato=actDato.getNextDato();
				
			}
			actDato.setNextDato(datoNuevo);
		}
	}
	
	/**
     * Obtiene el numero de elementos de la lista
     * @return numElementos
     */
	public int getNumeroElementos()
	{
		int numElementos=0;
		
		if (this.getRoot() != null)
			
		{  Dato actDato = this.getRoot();
			while (actDato != null)
			{
				numElementos +=1;
				actDato = actDato.getNextDato();
				
			}
		}
		
		return numElementos;		
		
	}
	
	/**
     * elimina un dato de una posiscion dada si no se puede eliminar retorna falso
     * @param posicion
     * @return borrado
     */
	public boolean delDato(int posicion)
	{
		boolean borrado = false;
		
		int numeroElementos = this.getNumeroElementos();
		
		if (numeroElementos >= posicion)
		{
		 
			if (posicion ==1)
			{
				this.setRoot(this.getRoot().getNextDato());
				borrado=true;
			}
			
			else
			{
				Dato beforeDato=this.getRoot() ;
				Dato actDato=this.getRoot().getNextDato();
				int p=2;
				while (p < posicion )
				{
					beforeDato= actDato;
					actDato= actDato.getNextDato();
					p+=1;
				}
				
				beforeDato.setNextDato(actDato.getNextDato());
				borrado=true;
			}
		}
		
		
		return borrado;
		
	}
	
	/**
     * obtiene una lista de los vaoles del conjunto de datos en formato texto
     * 
     * @return lValores
     */
	public ArrayList<String> getListaValores()
	{
		ArrayList<String> lValores = new ArrayList<String>();
		
		if (this.getRoot() != null)
			
		{  Dato actDato = this.getRoot();
			while (actDato != null)
			{
				if (actDato != null)
				{
				lValores.add(String.valueOf(actDato.getValor()));
				}
				actDato = actDato.getNextDato();
				
			}
		}
		
	
		return lValores;
		
		
	}
}

