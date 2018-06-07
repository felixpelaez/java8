package es.altran.curso;

public class Mobile extends Product {
	double inch;
	String model;
	
	public Mobile(int id, double price, String name,double inch, String model) {
		super(id, price, name);
		this.inch = inch;
		this.model = model;
	}

	public double getInch() {
		return inch;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return super.toString() + " Mobile [inch=" + inch + ", model=" + model + "]";
	}

	
	

}
