package com.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Slot {
	
	SLOT_1("8:00am - 9:00am"),
    SLOT_2("9:00am - 10:00am"),
    SLOT_3("10:00am - 11:00am"),
    SLOT_4("11:00am - 12:00pm"),
    SLOT_5("1:00pm - 2:00pm"),
    SLOT_6("2:00pm - 3:00pm"),
    SLOT_7("3:00pm - 4:00pm"),
    SLOT_8("4:00pm - 5:00pm"),
    SLOT_9("5:00pm - 6:00pm"), ;
    
    private String value;

//	public String getValue() {
//		return value;
//	}
//
//	public void setValue(String value) {
//		this.value = value;
//	}
//
//	private Slot(String value) {
//		this.value = value;
//	}
    
	   
	
}
