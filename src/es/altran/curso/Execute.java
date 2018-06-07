package es.altran.curso;

import java.util.ArrayList;

import es.altran.curso.business.Business;

public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1= new Book (1, 10.0, "java1","altran", "Certificacion en Java I");
		Book b2= new Book (2, 20.0, "java2","altran", "Certificacion en Java II");
		Mobile m1 = new Mobile(3,1000.0,"mobile1",5.5,"samsung X");
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(m1);
		list.add(b2);
		list.add(b1);

		
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
	}

}
