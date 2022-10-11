import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Hashtable <String, Double> listaArticulos = new Hashtable<String, Double>();
		
		//Llamamos el método menú para que lo ejecute.
		menu(listaArticulos, sc);	
		
	}
	
	
	//Método menu que pedira que introduzca una opcion.
	public static void menu(Hashtable <String, Double> listaArticulos, Scanner sc) {
		//Creamos un bucle para que ejecute siempre el menú
		for (boolean i = true; i ==true;) {
			System.out.println();
			System.out.println("---BIENVENIDO AL CONTROL DE STOCK---");
			System.out.println("             - MENÚ -               ");
			System.out.println("");
			System.out.println("1- Añadir artículo nuevo.");
			System.out.println("2- Imprimir listado de articulos.");
			System.out.println("3- Revisar articulo.");
			System.out.println("4- Finalizar programa.");
			System.out.println();
			System.out.print("Seleccione una opción:");

				int opcion=sc.nextInt();
			//Usaremos el swithc con el número introducido para que selecione una opción u otra.
			switch (opcion) {
			case 1:
				añadirArticuloNuevo(listaArticulos, sc);
				break;
			case 2:
				imprimirListado(listaArticulos);
				break;
			case 3:
				revisarArticulo(listaArticulos, sc);
				break;
			case 4:
				i=false;
				break;
			default:
				System.out.println("Opción no válida.");
				break;
			}
		}
	}
	
	
	//Método para añadir aticulos nuevos a la lista
	public static void añadirArticuloNuevo(Hashtable <String, Double> listaArticulos, Scanner sc) {
		
		System.out.print("Introduce un artículo: ");
			String articulo=sc.next();
		System.out.print("Introduce el precio del articulo: ");
			double precio=sc.nextDouble();
			
			listaArticulos.put(articulo, precio);
		
	}
	
	
	//Método para imprimir el listado completo de artículos
	public static void imprimirListado(Hashtable <String, Double> listaArticulos) {
		//Creamos dos enumerations para recorrer el hastables
		Enumeration elementoLista = listaArticulos.elements();
		Enumeration articulosLista = listaArticulos.keys();
		System.out.println("");
		System.out.println("----------LISTADO COMPLETO----------");
		System.out.println("------------------------------------");
		
		//While para que recorra toda la lista y la imprima
		while (elementoLista.hasMoreElements()) {
			System.out.println("Artículo: "+articulosLista.nextElement()+" || Precio: "+elementoLista.nextElement());
		}
		System.out.println();
	}
	
	
	
	//Método para revisar un artículo en concreto.
	public static void revisarArticulo(Hashtable <String, Double> listaArticulos, Scanner sc) {
		System.out.print("Introduce un artículo que buscar: ");
			String articulo=sc.next();
		//Creamos dos enumerations para recorrer el hastables
		Enumeration elementoLista = listaArticulos.elements();
		Enumeration articulosLista = listaArticulos.keys();
		
		//While para que recorra toda la lista
		while (articulosLista.hasMoreElements()) {
			//Cuando articulo sea igual que la keu imprimira el key y el valor
			if (articulo.equals(articulosLista.nextElement())) {
				System.out.println("Articulo: "+articulo+" || Precio: "+listaArticulos.get(articulo));
			}
		}
	}
}
