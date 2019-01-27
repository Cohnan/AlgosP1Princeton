

/*import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;*/

public class Controller {

	/* Instancia del Modelo del mundo */
	private static Percolation modelo = new Percolation(7);
	
	/**
	 * Requerimiento crear Arreglo Dinamico
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public static void crearModelo(int capacidad)
	{
		modelo = new Percolation(capacidad);
	}
	
	/**
	 * Requerimiento agregar elemento
	 * @param dato Dato a agregar al final del arreglo
	 */
	public static void open(int row, int col)
	{
		modelo.open(row, col);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public static boolean isFull (int row, int col)
	{
		return modelo.isFull(row, col);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public static boolean isOpen(int row, int col)
	{
		return modelo.isOpen(row, col);
	}
	
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el arreglo 
	 * @return numero de elementos presentes en el arreglo
	 */
	public static int numberOfOpenSites()
	{
		return modelo.numberOfOpenSites();
	}
	
	public static boolean percolates( ) {
		return modelo.percolates( );
	}
	
}
