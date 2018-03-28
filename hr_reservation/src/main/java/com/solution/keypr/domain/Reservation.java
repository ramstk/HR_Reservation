package com.solution.keypr.domain;


import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author RAM
 *
 */

public class Reservation implements Identifiable {

	private Long rid;
	@NotNull
    @NotBlank
	private String gFullName;
	
	private String Rstatus;
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date checkinDate;
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date checkoutDate;
	
	@Override
	@Valid

	public Long getId() {
		
		return rid;
	}

	@Override
	public void setId(Long rid) {
		
		this.rid = rid;

	}
	@Valid
	public String getgFullName() {
		
		return gFullName;
	
	}

	public void setgFullName(String gFullName) {
		this.gFullName = gFullName;
	}

	/**
	 * @return the checkinDate
	 */
	@Valid
	public  Date getCheckinDate() {
		return checkinDate;
	}

	/**
	 * @param checkinDate the checkinDate to set
	 * @return 
	 */
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	/**
	 * @return the checkoutDate
	 */
	@Valid
	public Date getCheckoutDate() {
		 
		return checkoutDate;
	}

	/**
	 * @param checkoutDate the checkoutDate to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	//Based on the check-in and check-out date the reservation status is assigned
	public void setRStatus(String Rstatus) {
		
		this.Rstatus = Rstatus;
	}
		
	public String Rstatus() {
		Date cdate = new Date();
		
		if (cdate.before((Date) checkinDate))
		{ 
			Rstatus = "Future_Reservation";
		}
		else if (cdate.after((Date) checkinDate) && cdate.before((Date) checkoutDate))
		{ 
			Rstatus = "Checked_In";
		}
		else if (cdate.after((Date) checkinDate) && cdate.after((Date) checkoutDate))
		{
			Rstatus = "Checked_Out";
		}
		return Rstatus;
	}

	

}
