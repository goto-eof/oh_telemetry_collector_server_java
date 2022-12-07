package org.isf.telemetry.bean;


public class KeyValue {
private Long key;
private String value;





public KeyValue(Long key, String value) {
	super();
	this.key = key;
	this.value = value;
}




public Long getKey() {
	return key;
}




public void setKey(Long key) {
	this.key = key;
}



public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}




@Override
public String toString() {
	return "KeyValue [key=" + key + ", value=" + value + "]";
}




}
