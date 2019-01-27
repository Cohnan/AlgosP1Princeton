

import java.util.Scanner;
import java.util.ArrayList;

//import Percolation;
//import model.Percolation;
//import controller.Controller;


public class PercolationViewer {

		private static void printMenu(){
			System.out.println("1. Create Percolation");
			System.out.println("2. Open site");
			System.out.println("3. Check if site is open");
			System.out.println("4. Check if site is full (connected to top)");
			System.out.println("5. Check if the system percolates");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public static void main(String[] args){
			
			// Idea: in args store whether I want to read a file (where the next arg would be its name
			// 		 or read from the console using Scanner
			// 		 or read from stdio, in which case I can use the terminal or a file with stored inputs
			
			Scanner lector = new Scanner(System.in);
			boolean fin = false;
			//String input = "";
			boolean answer;
			int row;
			int col;

			while( !fin ){
				printMenu();

				int option = lector.nextInt();
				switch(option){
					case 1: // Initialize
						System.out.println("--------- \nCreate Percolation System \nEnter grid length: ");
					    int capacidad = lector.nextInt();
						Controller.crearModelo(capacidad); 
						System.out.println("Percolation system created!");
						System.out.println("Number of open sites: " + Controller.numberOfOpenSites() + "\n---------");						
						break;

					case 2: // open()
						System.out.println("--------- \n:Open site \nEnter row and column separated by a space: ");
						row = lector.nextInt();
						col = lector.nextInt();
						Controller.open(row, col);
						System.out.println("Site opened: " + "(" + row + ", " + col +")");
						System.out.println("Number of open sites: " + Controller.numberOfOpenSites() + "\n---------");						
						break;
					
					case 3: // isOpen()
						System.out.println("Check if site is open \nEnter row and column separated by a space: ");
						row = lector.nextInt();
						col = lector.nextInt();
						answer = Controller.isOpen(row, col);
						if (answer)
						{
							System.out.println("Site " + "(" + row + ", " + col +") " + " is open!");
						}
						else
						{
							System.out.println("Site " + "(" + row + ", " + col +") " + " is NOT open!");
						}
						System.out.println("Number of open sites: " + Controller.numberOfOpenSites() + "\n---------");						
						break;
							
					case 4: // isFull()
						System.out.println("Check if site is full \nEnter row and column separated by a space: ");
						row = lector.nextInt();
						col = lector.nextInt();
						answer = Controller.isFull(row, col);
						if (answer)
						{
							System.out.println("Site " + "(" + row + ", " + col +")" + " is full!");
						}
						else
						{
							System.out.println("Site " + "(" + row + ", " + col +") " + " is NOT full!");
						}
						System.out.println("Number of open sites: " + Controller.numberOfOpenSites() + "\n---------");						
						break;
					
					case 5: // percolates()
						System.out.println("Check if system percolates \nEnter row and column separated by a space: ");
						answer = Controller.percolates();
						if (answer)
						{
							System.out.println("THE SYSTEM PERCOLATES!");
						}
						else
						{
							System.out.println("THE SYSTEM DOES NOT PERCOLATE!");
						}
						System.out.println("Number of open sites: " + Controller.numberOfOpenSites() + "\n---------");						
						break;

					case 6: 
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
