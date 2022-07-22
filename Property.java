public class Property {
	private String propertyName; 
	private String city; 
	private double rentAmount; 
	private String owner; 
	private Plot plot; 
	
	@Override
	public String toString() {
		return "Property Name: " + propertyName + "\nLocated in " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount; 
	}
	
	//No-arg constructor. Empty string, 0 for rent, default plot
	public Property() {
		this.propertyName = "";
		this.city = ""; 
		this.rentAmount = 0; 
		this.owner = ""; 
		this.plot = new Plot(0, 0, 1, 1); 
	}

	//Copy Constructor
	public Property(Property p) {
		this.propertyName = p.propertyName; 
		this.city = p.city; 
		this.rentAmount = p.rentAmount; 
		this.owner = p.owner; 
		this.plot = p.plot; 
	}
	
	//Parameterized constructor, no Plot
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName; 
		this.city = city; 
		this.rentAmount = rentAmount; 
		this.owner = owner; 
	}
	
	//Parameterized constructor
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth ) {
		this.propertyName = propertyName;
		this.city = city; 
		this.rentAmount = rentAmount; 
		this.owner = owner; 
		this.plot = new Plot(x, y, width, depth); 
	}
	
	//Getter methods
	
	public String getCity() {
		return city; 
	}
	
	public String getOwner() {
		return owner; 
	}
	
	public String getPropertyName() {
		return propertyName; 
	}
	
	public double getRentAmount() {
		return rentAmount; 
	}
	
	public Plot getPlot() {
		return plot; 
	}
	
	//Setter methods
	
	public Plot setPlot(int x, int y, int width, int depth) {
		Plot plot = new Plot(x,y,width,depth);
		return plot; 
	}
	
	public void setCity(String city) {
		this.city = city; 
	}
	
	public void setOwner(String owner) {
		this.owner = owner; 
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName; 
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount; 
	}
}