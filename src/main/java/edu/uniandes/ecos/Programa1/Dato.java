package edu.uniandes.ecos.Programa1;

/**
* Clas Nodo que almacena un valor de la lista de valore
*

*/
public class Dato {
	private Double valor;
	private Dato nextDato;
	public Dato() {
		
		this.nextDato = null;
	}
	
	 /**
     * Retorna el valor almacenado por el nodo
     * @return valor
     */
	public Double getValor() {
		return valor;
	}
	
	 /**
     * Asigna el valor a almacenar por el nodo
     * @param valor
     */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	 /**
     * Retorna el nodo siguiente conectado al actual nodo
     * @return valor
     */
	public Dato getNextDato() {
		return nextDato;
	}
	
	/**
     * Asigna el siguente nodo que se conecta al nodo actual
     * @param nets nodo
     */
	public void setNextDato(Dato nextDato) {
		this.nextDato = nextDato;
	}
	
	
	

}
