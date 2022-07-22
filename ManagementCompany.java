import java.util.*;


public class ManagementCompany {
	private int MAX_PROPERTY = 5; 
	private double mgmFeePer; 
	private String name; 
	private Property[] properties; 
	private String taxID; 
	private int MGMT_WIDTH = 10; 
	private int MGMT_DEPTH = 10; 
	private Plot plot; 
	int count = 0;

	
	//Constructors
	//No-Arg
	public ManagementCompany() {
		this.name = ""; 
		this.taxID = ""; 
		this.plot = new Plot(0,0, 10, 10); 
		properties = new Property[MAX_PROPERTY]; 
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFee; 
		this.plot = new Plot(0,0, 10, 10); 
		properties = new Property[MAX_PROPERTY]; 
	}
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		this.plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY]; 
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name; 
		taxID = otherCompany.name; 
		mgmFeePer = otherCompany.mgmFeePer; 
		plot = otherCompany.plot; 
		properties = new Property[MAX_PROPERTY];
	}
	
	//Methods
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY; 
	}

	public int addProperty(Property property) {

		if(count >= MAX_PROPERTY)
			return -1; 
		if(property == null)
			return -2; 
		if(!this.plot.encompasses(property.getPlot()))
			return -3; 
		  for(int a = 0; a<properties.length; a++)
		  {
			if(properties[a] != null)
			{
				if(properties[a].getPlot().overlaps(property.getPlot()))
				{
					return -4; 
				}
			}
		  }
		 
			int currentCount = count; 			 
			properties[count] = property;
			count++; 
			return currentCount;
		  }


	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner)); 
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth)); 
	}
	private int maxRentPropertyIndex() {
		 int propIndex = 0;
		    for (int a = 0; a < properties.length; a++) {
		      if (properties[a] != null) {
		        if (properties[propIndex].getRentAmount() < properties[a].getRentAmount())
		          propIndex = a;
		      }
		    }
		    return propIndex;
	}
	public double totalRent() {
		double total = 0; 
		for(int a = 0; a < count; a++)
			if(properties[a] != null)
				total += properties[a].getRentAmount(); 
		return total; 
	}
	public double maxRentProp() {
		double maxRent = 0; 
		maxRent = properties[maxRentPropertyIndex()].getRentAmount(); 	//Calls maxRentPropertyIndex method and getRentAmount
		return maxRent; 
	}
	public String displayPropertyAtIndex(int i) {
		String str = ""; 
		if(properties[i] != null)		//Makes sure the array is not empty
			str = "Owner: " + properties[i].getOwner() + "City: " + properties[i].getCity() + " Property Name: " + properties[i].getPropertyName() + "Rent Amount: " + properties[i].getRentAmount() + "Plot: " + properties[i].getPlot(); 
		return str; 
	}
	
	@Override
	public String toString() {
		String str = ""; 
		double managementFee = (totalRent() * mgmFeePer/100); 		//Management fee
		for(int a = 0; a < MAX_PROPERTY; a++) {
			if(properties[a] == null)
				break; 
			str += "\n" +properties[a].toString()+"\n"; 
		}
		return "List of the properties for " + name + ", taxID: " + taxID + str + "\nTotal Management Fee: " + managementFee;
	}
	public Plot getPlot() {
		return plot;
	}
	public String getName() {
		return name; 
	}
}

