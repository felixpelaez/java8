package es.altran.curso.business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.altran.curso.Product;

public class JDBCBusiness {
	Connection con;
	private final String url = "jdbc:mysql://localhost:3306/kill_amazon";
	private final String user = "root";
	private final String password = "root";
	private final String creator="java8";
	
	 String query_insert = "INSERT INTO products ("
			    + " id,"
			    + " price,"
			    + " name,"
			    + " user) VALUES ("
			    + " ?, ?, ?, ?)";
	private final String query_select="SELECT * FROM products where user='" + creator + "'";
	
	
	
	public JDBCBusiness() {
		super();
		try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
		// TODO Auto-generated constructor stub
	}



	public boolean insert(Product paramProduct) {
        try {
        	PreparedStatement st = con.prepareStatement(query_insert);
            st.setInt(1, paramProduct.getId());
            st.setDouble(2, paramProduct.getPrice());
            st.setString(3, paramProduct.getName());
            st.setString(4, creator);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
	
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		Product prod;
        try {
        	Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery(query_select);
        	 while ( rs.next() ) {
        		 prod = new Product();
                 prod.setId(rs.getInt("id"));
                 prod.setPrice(rs.getDouble("price"));
                 prod.setName(rs.getString("name"));
                 result.add(prod);
             }
        	 stmt.close();
             con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
	
	
	
}
