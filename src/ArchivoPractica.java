import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoPractica {
 public static void main(String[] args) {
	 
	 Scanner tec = new Scanner(System.in);
	 String nombre;
	 String crear;
	 String linea;
	 int conta = 0;
	 int numLinea = 1;
	 
	 System.out.println("Ingrese la ruta del archivo y nombre a leer: ");
	 nombre = tec.nextLine();  
	 System.out.println("Ingrese la ruta del archivo y nombre a guardar: ");
	 crear = tec.nextLine();
	 
	 File archivo = new File(nombre); 
	 try {
		FileReader reader = new FileReader(archivo);
		BufferedReader buffer = new BufferedReader(reader);
		
		System.out.println("Ingresa la palabra a buscar:\n ");
		nombre = tec.next();
		 
		try {
			// creamos el archivo
			File archivo1 = new File(crear); // lo utilizo para crear el archivo nuevo
			FileWriter writer = new FileWriter(archivo1);
			PrintWriter bu = new PrintWriter(writer);
			 bu.print("palabra a buscar: " + nombre + "\n"); 
		      while ((linea = buffer.readLine()) != null) { //se recorre linea por linea		
			    if(linea.contains(nombre)) { //este metodo valida si en la linea contiene la palabra que se busca
				
				 bu.println("Linea " + numLinea + ":"  + " " +  linea);
			    conta++; // esta variable nos mostrara el numero de veces que se encontro la palabra
			}
			numLinea ++; //iremos guardando el numero de linea que se esta recorriendo
		   }
		      bu.println("\nnumero de palabras encontradas: " + conta);
		     //System.out.println("\n numero de palabras encontradas: " + conta); // mostramos el numero de palabras encontradas 
		    bu.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 System.out.println("\n Archivo creado");
	 
 }
 
}
