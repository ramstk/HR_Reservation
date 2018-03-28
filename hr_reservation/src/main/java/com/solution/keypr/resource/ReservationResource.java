/**
 * Presentation layer
 */
package com.solution.keypr.resource;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solution.keypr.domain.Reservation;

/**
 * @author RAM
 *
 */
public class ReservationResource extends ResourceSupport{
	private final long rid;
	private final String gFullName;
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private final Date checkinDate;
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private final Date checkoutDate;
	private final String rStatus;
	
	public ReservationResource (Reservation reservation) {
		rid = reservation.getId();
		gFullName = reservation.getgFullName();
		checkinDate = reservation.getCheckinDate();
		checkoutDate = reservation.getCheckoutDate();
		rStatus = reservation.Rstatus();
	}
	
	@JsonProperty("id")
	public Long getResourceId() {
		return rid;
	}
	public String getGFullName() {
		return gFullName;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public String getRstatus() {
		return rStatus;	
	}
	

}
