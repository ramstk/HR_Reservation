package com.solution.keypr.test.util;
import org.junit.Assert;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.solution.keypr.domain.Reservation;

public class ReservationTestUtil {
	public static void assertAllButIdsMatchBetweenReservations(Reservation expected, Reservation actual) {
    	Assert.assertEquals(expected.getgFullName(), actual.getgFullName());
    	Assert.assertEquals(expected.getCheckinDate(), actual.getCheckinDate());
    	Assert.assertEquals(expected.getCheckoutDate(), actual.getCheckoutDate());
    }
	
    public static Reservation generateTestReservation() throws ParseException {
    	Reservation reserve = new Reservation();
    	reserve.setgFullName("test name");
    	String str = "2018-10-12";
    	String str2 = "2018-10-12";
    	SimpleDateFormat 	formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date checkout = (Date) formatter.parse(str2);
    	Date checkin = (Date) formatter.parse(str);
    	reserve.setCheckinDate(checkin);
    	reserve.setCheckoutDate(checkout);
    	return reserve;
    }
    
     public static Reservation generateUpdatedReservation(Reservation original) throws ParseException {
    	 Reservation updated = new Reservation();
    	updated.setgFullName(original.getgFullName() + " updated");
    String str = "2018-11-10";
    	String str2 = "2018-11-10";
    	SimpleDateFormat 	formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date checkout = (Date) formatter.parse(str2);
    	Date checkin = (Date) formatter.parse(str);
    	updated.setCheckinDate(checkin);
    	updated.setCheckoutDate(checkout);
    	
    	return updated;
    }

}
