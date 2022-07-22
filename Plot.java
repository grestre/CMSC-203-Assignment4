public class Plot {
	private int x; 
	private int y; 
	private int width; 
	private int depth; 
	
	//Constructors
	
	//No-Arg Constructor
	public Plot() {
	this.x = 0; 
	this.y = 0;
	this.width = 1; 
	this.depth = 1; 
	}
	
	//Copy Constructor
	public Plot(Plot p) {
		this.x = p.x; 
		this.y = p.y; 
		this.depth = p.depth; 
		this.width = p.width; 
	}
	
	//Parameterized Constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth; 
	}
	
	//Methods
	public boolean overlaps(Plot plot) {		
		  if(x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y)
			  return true; 
		  else 
			  return false; 
	}
	public boolean encompasses(Plot plot) {
		if(((plot.x>= x && plot.x <= (x+width)) && (plot.y >= y && plot.y <= (y+depth))) &&
                (((plot.x + plot.width)>= x && (plot.x+plot.width) <= (x+width)) && (plot.y >= y && plot.y <= ( y+depth))))
			return true; 
		return false; 	
	}

	
	//Setter methods
	public void setX(int x) {
		this.x = x; 
	}
	public void setY(int y) {
		this.y = y; 
	}
	public void setWidth(int width) {
		this.width = width; 
	}
	public void setDepth(int depth) {
		this.depth = depth; 
	}
	
	//Getter methods
	public int getX() {
		return x; 
	}
	public int getY() {
		return y; 
	}
	public int getWidth() {
		return width; 
	}
	public int getDepth() {
		return depth; 
	}
	
	//toString
	@Override
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth; 
	}
}

