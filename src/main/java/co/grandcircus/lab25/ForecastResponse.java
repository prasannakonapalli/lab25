package co.grandcircus.lab25;



public class ForecastResponse {
private Location loc;
private Data data;
private String productionCenter;


public String getProductionCenter() {
	return productionCenter;
}
public void setProductionCenter(String productionCenter) {
	this.productionCenter = productionCenter;
}
public ForecastResponse() {
	super();
}
public Location getLoc() {
	return loc;
}
public void setLoc(Location loc) {
	this.loc = loc;
}
public Data getData() {
	return data;
}
public void setData(Data data) {
	this.data = data;
}


}
