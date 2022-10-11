import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Double> lista = new ArrayList <Double>();
		double sumaIVA=0.0;

		//Llamamos a los metodos y los separamos con guiones para que sea mas legible por pantalla.
		listaCompra(lista, sc);
		System.out.println("-------------------------");
		calculoIva(sc, lista);
		System.out.println("-------------------------");
		numArticulosComprados(lista);
	}


	
	
	//Creamos un metodo para pedir los precios e ir introduciendolos en un arraylist
	public static ArrayList<Double> listaCompra(ArrayList<Double> lista, Scanner sc) {

		boolean fin=false;
		//Bucle mientras no introduzca el numero 0 podrá ir introduciendo precios en la lista 
		for (int i = 0; fin == false; i++) {
			System.out.print("Introduce el precio de un producto (Introduce el número 0 para finalizar la lista):  ");
			double precioProducto=sc.nextDouble();
			//Si precioProducto coincide con 0 retorna un true y cierra el for
			if (precioProducto==0) {
				fin=true;
			//De lo contrario añade el precio a la lista
			}else {
				lista.add(precioProducto);
			}
		}
		
	return lista;
	}

	//Método para calcular el IVA sea 21 o 4 
	public static void calculoIva(Scanner sc, ArrayList<Double> lista ) {
		System.out.print("Introduce el IVA a aplicar (21% o 4%): ");
			double IVA=sc.nextDouble();
			double sumaBruta=0.0;		
			double sumaIVA =0.0;
			
			//for que se repita hasta la longitud maxima de la lista y que vaya acumulando los precios
			for (int i = 0; i < lista.size(); i++) {
				sumaBruta=sumaBruta+lista.get(i);
				
			}
			//Condicional si  el IVA es 21 o 4 realice los siguientes pasos de sumar el precio en bruto y sumar el precio en bruto + el iva.
			if (IVA==21 || IVA==4) {
				IVA=IVA/100;
				sumaIVA=sumaBruta*IVA+sumaBruta;
				System.out.println("Precio total brutos a pagar: "+sumaBruta);
				System.out.println("Precio total de los productos + IVA: "+sumaIVA);
				System.out.println("-------------------------");
				System.out.print("Introduce la cantidad de dinero € a pagar: ");
					double dinero=sc.nextDouble();
					dinero=dinero-sumaIVA;
				System.out.println("Serán "+dinero+" € de cambio");
			}else {
				System.out.println("Porcentade de IVA introducido no válido.");
			}
			
	}

	//Metodo que te indica la cantidad de productos comprados.
	public static void numArticulosComprados(ArrayList<Double> lista) {
		System.out.println("Numero de articulos comprados: "+lista.size());
	}
}
