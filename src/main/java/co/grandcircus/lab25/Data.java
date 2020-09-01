package co.grandcircus.lab25;

public class Data {
private String text[];
private String temperature[]; 
private String iconLink[];

public String[] getIconLink() {
	return iconLink;
}

public void setIconLink(String[] iconLink) {
	this.iconLink = iconLink;
}

public Data() {
	super();
}

public String[] getText() {
	return text;
}

public void setText(String[] text) {
	this.text = text;
}

public String[] getTemperature() {
	return temperature;
}

public void setTemperature(String[] temperature) {
	this.temperature = temperature;
}
 


}
