package es.altran.curso.business;

import java.util.ArrayList;
import java.util.Collections;

import es.altran.curso.Product;
import es.altran.curso.ord.SortByName;
import es.altran.curso.ord.SortByPrice;

public class Business {

	public void sortbyPrice(ArrayList<Product> paramLista) {
		Collections.sort(paramLista,new SortByPrice());		
	}
	
	public void sortbyName(ArrayList<Product> paramLista) {
		Collections.sort(paramLista,new SortByName());		
	}
}
