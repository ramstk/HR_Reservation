/**
 * 
 */
package com.solution.keypr.resource;



import org.springframework.stereotype.Component;

import com.solution.keypr.domain.Reservation;

/**
 * @author RAM
 *
 */
@Component
public class ReservationResourceAssembler extends ResourceAssembler<Reservation, ReservationResource> {


	@Override
	public ReservationResource toResource(Reservation reservation) {
		ReservationResource resource = new ReservationResource(reservation); 

		return resource;
	}

}
