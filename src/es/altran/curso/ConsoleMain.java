package es.altran.curso;

import java.io.Console;
import java.util.ArrayList;

import es.altran.curso.business.FileBusiness;

public class ConsoleMain {

	public static void main(String[] args) {
	  Console console = null;
      String inputString = "";
      Product product=new Product();
      FileBusiness logicFile = new FileBusiness();
      ArrayList<Product> lista = new ArrayList<Product>();
      
      try{
         // creates a console object
         console = System.console();
         // if console is not null
         if (console != null){
        	while (true) {        		
	            inputString = console.readLine("ID: ");
	        	product.setId(Integer.parseInt(inputString));
	        	boolean bCorrectPrice=true;
	        	while (bCorrectPrice) {
	        		inputString = console.readLine("Price: ");
		            try {
		            	product.setPrice(Double.parseDouble(inputString));
		        		bCorrectPrice=false;
		            }catch(java.lang.NumberFormatException ee) {
		            	System.out.println("Número incorrecto.");
		            	bCorrectPrice=true;
		            }
        		}
	            inputString = console.readLine("Name: ");
	        	product.setName(inputString);
	            System.out.println("Product : " + product);
	            logicFile.putFile(product);
	            System.out.println("Save product : " + product);
	            lista.add(product);
	            inputString = console.readLine("Continuo (Y\\N) ? ");
	            if (inputString.equals("N")) {
	            	break;
	            }
	            product = new Product();
        	}
        	lista.forEach(System.out::println);

         }else {
        	 System.out.println("Execute from Console");
         }
      } catch (Exception ex)
      {
         ex.printStackTrace();
      }

	}

}
