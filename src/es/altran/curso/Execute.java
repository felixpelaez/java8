package es.altran.curso;

import java.util.ArrayList;

import es.altran.curso.business.Business;

public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1= new Book (1, 10.0, "java1","altran", "Certificacion en Java I");
		Book b2= new Book (2, 20.0, "java2","altran", "Certificacion en Java II");
		Mobile m1 = new Mobile(3,1000.0,"mobile1",5.5,"samsung X");
		Mobile m2 = new Mobile(4,24.0,"mobile2",6.0,"samsung 6.0 inches");
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(m1);
		list.add(b2);
		list.add(b1);
		list.add(m2);

		
		for (Product prod : list) {
			System.out.println(prod);			
		}
		
		Business logic = new Business();
		logic.sortbyPrice(list);
		
		System.out.println("Lista Ordenada por precio.");
		for (Product prod : list) {
			System.out.println(prod);			
		}
		
		logic.sortbyName(list);
		
		System.out.println("Lista Ordenada por nombre.");
		for (Product prod : list) {
			System.out.println(prod);			
		}
		
		System.out.println("Producto con id 3.old:" + logic.getProductByID(list, 3));
		System.out.println("Producto con id 3.new:" + logic.getProductByID_Lambda(list, 3).get(0));
		
		ArrayList<Product> lista20=logic.getProductByPrice(list, 20.0, 30.0);
		System.out.println("Lista de 20 euros.old");
		for (Product prod : lista20) {
			System.out.println(prod);			
		}
		
		lista20=logic.getProductByPrice_Lambda(list, 20.0, 30.0);
		System.out.println("Lista de 20 euros.new");
		lista20.forEach(System.out::println);
		

		//list.sort((Product o1,Product o2) -> (int) ((o1.getPrice() -  o2.getPrice())));
		
		list.sort((Product o1,Product o2) -> {
		int result=0;
		if (o1.getPrice() < o2.getPrice()) {
			result=-1;
		}else if (o1.getPrice() > o2.getPrice()) {
			result=1;
		};return result;});

		
		System.out.println("\nLista Ordenada por precio.");
		list.forEach((p)->System.out.println(p));
		
		Double oo= new Double("3.0");
		
	}

}
