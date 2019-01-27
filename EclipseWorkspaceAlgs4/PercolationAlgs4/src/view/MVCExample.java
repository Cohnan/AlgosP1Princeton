package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import model.data_structures.IArregloDinamico;;

public class MVCExample {

		private static void printMenu(){
			System.out.println("1. Crear Arreglo Dinamico de Strings");
			System.out.println("2. Agregar String");
			System.out.println("3. Buscar String");
			System.out.println("4. Eliminar String");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public static void main(String[] args){

			Scanner lector = new Scanner(System.in);
			boolean fin = false;
			String dato = "";
			String respuesta = "";

			while( !fin ){
				printMenu();

				int option = lector.nextInt();
				switch(option){
					case 1:
						System.out.println("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
					    int capacidad = lector.nextInt();
						Controller.crearModelo(capacidad); 
						System.out.println("Arreglo Dinamico creado");
						System.out.println("Numero actual de elementos " + Controller.darTamano() + "\n---------");						
						break;

					case 2:
						System.out.println("--------- \nDar cadena (simple) a ingresar: ");
						dato = lector.next();
						Controller.agregar(dato);
						System.out.println("Dato agregado");
						System.out.println("Numero actual de elementos " + Controller.darTamano() + "\n---------");						
						break;

					case 3:
						System.out.println("--------- \nDar cadena (simple) a buscar: ");
						dato = lector.next();
						respuesta = Controller.buscar(dato);
						if ( respuesta != null)
						{
							System.out.println("Dato encontrado: "+ respuesta);
						}
						else
						{
							System.out.println("Dato NO encontrado");
						}
						System.out.println("Numero actual de elementos " + Controller.darTamano() + "\n---------");						
						break;

					case 4:
						System.out.println("--------- \nDar cadena (simple) a eliminar: ");
						dato = lector.next();
						respuesta = Controller.eliminar(dato);
						if ( respuesta != null)
						{
							System.out.println("Dato eliminado "+ respuesta);
						}
						else
						{
							System.out.println("Dato NO eliminado");							
						}
						System.out.println("Numero actual de elementos " + Controller.darTamano() + "\n---------");						
						break;

					case 5: 
						System.out.println("--------- \n Hasta pronto !! \n---------"); 
						lector.close();
						fin = true;
						break;		  

					default: 
						System.out.println("--------- \n Opcion Invalida !! \n---------");
						break;
				}
			}
		}

}
