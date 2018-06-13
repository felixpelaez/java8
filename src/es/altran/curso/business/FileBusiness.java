package es.altran.curso.business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import es.altran.curso.Product;

public class FileBusiness {
	public static final String DIRECTORY="C:\\tmp\\object_files\\";
	public static final String SUFIX=".ppp";
	
	public void putFile (Product paramProduct) {
	   FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(FileBusiness.DIRECTORY + paramProduct.getId() + FileBusiness.SUFIX);
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(paramProduct);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product getFile(String paramID) {
		   FileInputStream fileInputStream;
		   Product product = new Product();
		try {
			fileInputStream = new FileInputStream(FileBusiness.DIRECTORY + paramID + FileBusiness.SUFIX);
		    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    product = (Product) objectInputStream.readObject();
		    objectInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return product;
	}
	
	
	public Product getFile2(String paramID) {
		return getFile(Paths.get(FileBusiness.DIRECTORY + paramID));
	}
	
	public Product getFile(Path paramPath) {
		   FileInputStream fileInputStream;
		   Product product = new Product();
		try {
			fileInputStream = new FileInputStream(paramPath.toString());
		    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    product = (Product) objectInputStream.readObject();
		    objectInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return product;
	}
	
}
