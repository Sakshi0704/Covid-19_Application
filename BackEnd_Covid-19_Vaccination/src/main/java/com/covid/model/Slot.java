package com.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Slot {
	
	SLOT_1(){
		@Override
	    public String timeslot() {	    	
	    	return "8:00am - 9:00am";
	    }
	},
    SLOT_2{
    	@Override
	    public String timeslot() {	    	
	    	return "9:00am - 10:00am";
	    }
    },
    
    SLOT_3{
    	@Override
	    public String timeslot() {	    	
	    	return "10:00am - 11:00am";
	    }
    },
    
    
    SLOT_4{
    	@Override
	    public String timeslot() {	    	
	    	return "11:00am - 12:00pm";
	    }
	},
    
    SLOT_5{
    	@Override
	    public String timeslot() {	    	
	    	return "1:00pm - 2:00pm";
	    }
	},
    
    SLOT_6{
    	@Override
	    public String timeslot() {	    	
	    	return "2:00pm - 3:00pm";
	    }
	},
    
    SLOT_7{
    	@Override
	    public String timeslot() {	    	
	    	return "3:00pm - 4:00pm";
	    }
	},
    
    SLOT_8{
    	@Override
	    public String timeslot() {	    	
	    	return "4:00pm - 5:00pm";
	    }
	},
    
    SLOT_9{
    	@Override
	    public String timeslot() {	    	
	    	return "5:00pm - 6:00pm";
	    }
	};
	
	public String timeslot() {
		// TODO Auto-generated method stub
		return null;
	}

   
	
}
