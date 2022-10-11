import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Hashtable <String, Double> contenedor = new Hashtable<String, Double>();
		
		String nombre="";
		
			//Creamos un for para que haga una lista infinita de alumnos. Podrán finalizar la lista introduciendo FINALIZAR
			boolean finalizar=false;
			for (int i = 0; finalizar == false; i++) {
				System.out.println("");
				System.out.println("---LISTA DE ALUMNOS---");
				System.out.print("Introduce el nombre del alumno (Introduce FINALIZAR para acabar la lista): ");
					nombre=sc.nextLine();
				//Condición para finalizar la lista	
				if (nombre.equals("FINALIZAR")) {
					finalizar=true;
					System.out.println("Lista de alumnos finalizada.");
				//Si no cumple la condición guardará el nombre en la lista y llamar el método "media" y nos retornara la media y se guardará.
				}else {
					contenedor.put(nombre, media(contenedor, nombre));
				}
			}
			
			//Método para imprimir la lista completa con nombre y media de cada alumno.
			imprimirLista(contenedor);
			
	}


	
	//Método para calcular la media de cada alumno.
	public static double media(Hashtable<String, Double> contenedor,String nombre) {
		Scanner sc= new Scanner(System.in);
		boolean finalizar=false;
		double nota=0;
		double media=0.0;
		int i=0;
		
		
		System.out.println("");
		System.out.println("---LISTA DE NOTAS DE ("+nombre+")---");
		
		//for para que pueda introducir tantas notas como quiera y finalice la lista al introducir el número 666
		for (;finalizar == false; i++) {
			
			System.out.print("Introduce las notas (Introduce número 666 para finalizar): ");
				nota=sc.nextDouble();
			//Si nota coincide con 666 devuelve un true y se cierra el bucle.
			if (nota==666) {
				finalizar=true;
				System.out.println("Lista de notas finalizada.");
				//Restamos una posición a la i para poder contabilizar correctamente la cantidad de notas que hay
				i--;
				
			//Si la nota esta fuera de este rango pedirá de nuevo un número.
			}else if (nota>10 || nota<0){
				System.out.println("Nota no permitida. no añadida a la lista. introduzca una de nuevo");
				//Restamos una posición a la i para poder contabilizar correctamente la cantidad de notas que hay
				i--;
			//Si todo es correcto se ira acumulando la suma de la nota para luego dividirla.
			}else {
				media=media+nota;
			}
		}
		media=media/i;
		
		return media;
	}
	
	
	//Método para imprimir la lista formateada. usamos Enumeration para recorrer los valores del hashtable.
	public static void imprimirLista(Hashtable<String, Double> contenedor) {
		Enumeration medias = contenedor.elements();
		Enumeration nombres = contenedor.keys();
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("LISTADO COMPLETO DE ALUMNO + NOTA MEDIA");
		System.out.println("---------------------------------------");
	while (medias.hasMoreElements()) {
		System.out.println("Nombre: "+nombres.nextElement()+" || Nota media: " + medias.nextElement());		
	}
		
		
	}

}
