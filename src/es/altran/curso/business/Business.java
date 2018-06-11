package es.altran.curso.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public Product getProductByID(ArrayList<Product> paramLista, int paramID) {
		Product result= new Product();
		for (Product prod: paramLista) {
			if (prod.getId()==paramID) {
				return prod;
			}
		}
		return result;			
	}
	
	public ArrayList<Product> getProductByID_Lambda(ArrayList<Product> paramLista, int paramID) {
		return 	paramLista.stream()
                .filter(p -> p.getId()==paramID)
                .collect(Collectors.toCollection(() -> new ArrayList<Product>()));		
	}
	
	
	
	public ArrayList<Product> getProductByPrice(ArrayList<Product> paramLista, double paramMini,double paramMax) {
		ArrayList <Product> result= new ArrayList<Product>();
		for (Product prod: paramLista) {
			if (prod.getPrice() >= paramMini && prod.getPrice() <= paramMax) {
				result.add(prod);
			}
		}
		return result;			
	}
	
	public ArrayList<Product> getProductByPrice_Lambda(ArrayList<Product> paramLista, double paramMini,double paramMax) {
		return paramLista.stream()
                .filter(p -> p.getPrice() >=paramMini && p.getPrice() <=paramMax)
                .collect(Collectors.toCollection(() -> new ArrayList<Product>()));
	}
	
}
