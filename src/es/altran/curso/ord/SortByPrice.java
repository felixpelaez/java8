package es.altran.curso.ord;

import java.util.Comparator;

import es.altran.curso.Product;

public class SortByPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return (int) (o1.getPrice() - o2.getPrice());
		
	}
		

}
