package edu.uniandes.ecos.Programa1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
* Clase que administra a los conjuntos de datos
*

*/
public class AdminDatos {
	
	/**
     * arrylist que contiene los diferentes conjuntos de datos
     */
	private ArrayList<ConjuntoDatos> ListaConjuntoDatos;
	
	/**
     * Conjunto de datos actualmete seleccionado del arraylist
     */
	private ConjuntoDatos actSelConjuntoDatos;
	
	public AdminDatos()
	{
		ListaConjuntoDatos=new ArrayList<ConjuntoDatos>();
		actSelConjuntoDatos= null;
	}
	
	/**
     * Lee los valores desde un archivo de texto, retorna falso si no puede abrir el archivo
     * 
     * @return leido
     */
	
public boolean readFile(String path)

{
	boolean leido = false;
	
	if ( path.contains(".txt"))
	{
		try {
				BufferedReader br = new BufferedReader(new FileReader(path));
			
				try {
					String line = br.readLine();
					while (line != null) 
					{
						ConjuntoDatos nuevoConjuntoDatos= new ConjuntoDatos();
						
						String[] valores= line.split(",") ;
						for (int i= 0; i<valores.length;i++) 
						{
							if (i==0)
							{
								nuevoConjuntoDatos.setTitulo(valores[i]);
							}				        
							else
							{
								try {
									Double pValor= Double.parseDouble(valores[i]);
							
									nuevoConjuntoDatos.addDato(pValor);
									}
								catch(NumberFormatException ex)
								{
									System.out.println("Conjunto de Datos " +nuevoConjuntoDatos.getTitulo()+ "Valor No Cargado: " + valores[i]);								
								}
							}						
						
						}
						ListaConjuntoDatos.add(nuevoConjuntoDatos);
						line = br.readLine();
			    }
				leido= true;
				br.close();
			} 
			catch (IOException e) 
			{
				
			}
			
		} 
		catch (FileNotFoundException e) 
			{
				System.out.println("El Archivo No Se Pudo Abrir");
				return false;
			}
	}
	
	
	return leido;
	}
/**
 * Obtiene la lista de los conjuntos de datos
 * 
 * @return leido
 */
public ArrayList<ConjuntoDatos> getListaConjuntoDatos() {
		return ListaConjuntoDatos;
	}


/**
 * Obtiene el conjunto de datos actualmente seleccionado
 * 
 * @return actSelConjuntoDatos
 */
	public ConjuntoDatos getActSelConjuntoDatos() {
		return actSelConjuntoDatos;
	}

	/**
	 *asigna al actualConjuto de datos
	 * 
	 * @param actSelConjuntoDatos
	 */
	public void setActSelConjuntoDatos(ConjuntoDatos actSelConjuntoDatos) {
		this.actSelConjuntoDatos = actSelConjuntoDatos;
	}



/**
 *Selecciona el actual conjuto de datos dada una posiscion drentro de la lista de conjuntos de datos si no reliza la selccion retona falso
*@return seleccionado
 */
public boolean selecionarConjuntoDatos(int posicion)
{
 boolean seleccionado= false;
 
 if (posicion <= this.getListaConjuntoDatos().size())
 {
	 this.setActSelConjuntoDatos(this.getListaConjuntoDatos().get(posicion-1));
	 seleccionado=true;
 }
 return seleccionado;
}

/**
 *genera la lista de los titulos de los conjuntos de datos
*@return posicion
 */
public ArrayList<String> getTitulosConjuntoDatos()
{
	ArrayList<String> titulos= new ArrayList<String>();
	
	for (int p =0 ;p<this.getListaConjuntoDatos().size();p++)
	{
		titulos.add(this.getListaConjuntoDatos().get(p).getTitulo());
	}
	
	return titulos;
}

/**
 *Obtiene la lista de valores del actual consjunto de datos selecionado
*@return posicion
 */
public ArrayList<String> getValoresActSelConjuntoDatos()
{
 	return this.getActSelConjuntoDatos().getListaValores();
}

/**
 *Adiciona un nuevo dato al actual conjunto de datos selecionado 
*@param valor
 */
public void addDatoActSelConjuntoDatos(Double valor)
{
	this.getActSelConjuntoDatos().addDato(valor);
	}

/**
 *Elimina un  dato al actual conjunto de datos selecionado dada una posiscion, si no se elimina el dato retorna falso
*@return valor
 */
public boolean delDatoActSelConjuntoDatos(int posicion)
{
	return this.getActSelConjuntoDatos().delDato(posicion);
	}

/**
 *calcula la media del actual conjunto de datos selecionado dada una posiscion
*@return media
 */
public Double calcMedActSelConjuntoDatos()
{
	Double media = 0.0;
	Double suma = 0.0;
	
	for(String val : this.getActSelConjuntoDatos().getListaValores() )
	{
	suma= suma + Double.parseDouble(val);
	}
	media= suma/this.getActSelConjuntoDatos().getNumeroElementos();
	return media;
	


}

/**
 *calcula la Desviacioón Standart del actual conjunto de datos selecionado
 *@param media
*@return desvStand
 */
public Double calcDevStanActSelConjuntoDatos(Double media)
{
	
	Double dif = 0.0;
	Double sumdif=0.0;
	Double desvStand=0.0;
	Double valordato=0.0;
	for(String val : this.getActSelConjuntoDatos().getListaValores() )
	{
		valordato= Double.parseDouble(val);
	 dif=  Math.pow(valordato - media, 2);
	 sumdif= sumdif+ dif;
	 
	}
	
	int denominador = this.getActSelConjuntoDatos().getNumeroElementos()-1;
	if (denominador > 0)
	{
	desvStand=Math.sqrt( sumdif/denominador);
	}
	return desvStand;
	}


}
