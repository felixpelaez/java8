package es.altran.curso;

import java.util.List;
import static java.util.Arrays.asList;
import es.altran.curso.business.JDBCBusiness;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCBusiness dao = new JDBCBusiness();
		List<Product> products = asList(new Product(1,1.1,"p1")
				,new Product(2,2.1,"p2")
				,new Product(3,3.1,"p3")
				,new Product(4,4.1,"p4")
				,new Product(5,5.1,"p5"));
		
		//products.forEach((p) -> {dao.insert(p);});
		dao.selectAll().forEach(System.out::println);
	}

}
